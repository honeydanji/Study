package RecursiveAlgorithm.Java;

import java.util.Scanner;

public class Recursive_Factorial {
    
    static int factorial(int n) {

        // 삼항연산자
        return (n > 0) ? n * factorial(n - 1) : 1;

        // 조건문
        // if (n > 0) {
        //     return n * factorial(n-1);
        // }else {
        //     return 1;
        // }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("정수를 입력해주세요.: ");
        int num = sc.nextInt();

        System.out.println(num + "! = " + factorial(num));
    }
}
