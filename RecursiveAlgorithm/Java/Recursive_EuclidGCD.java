package RecursiveAlgorithm.Java;

import java.util.Scanner;

public class Recursive_EuclidGCD {

    static int EuclidGCD(int num1, int num2) {
        return (num2 != 0) ? EuclidGCD(num2, num1 % num2) : num1;

        // if(num2 != 0) {
        //     return EuclidGCD(num2, num1 % num2);
        // }else{
        //     return num1;
        // } 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("2개의 정수를 입력하세요.: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        System.out.println(num1 + ", " + num2 + " 최대공략수 = " + EuclidGCD(num1, num2));
    }
    
}
