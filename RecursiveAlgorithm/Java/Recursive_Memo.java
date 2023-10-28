package RecursiveAlgorithm.Java;

import java.util.Scanner;

public class Recursive_Memo {

    static String[] memo;

    // 메모화를 도입한 recur 메서드
    static void recur(int n) {
        if (memo[n + 1] != null){
            System.out.println(memo[n + 1]);
        }else {
            if (n > 0) {
                recur(n - 1);
                System.out.println(n);
                recur(n - 2);
                memo[n + 1] = memo[n] + n + "\n" + memo[n - 1];
            } else {
                memo[n+1] = "";
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("정수를 입력하세요.: ");
        int x = sc.nextInt();

        memo = new String[x + 2];
        recur(x);
    }
    
}
/*
 * 메모화
 * 
 * 재귀함수의 반복횟수를 줄일수 있도록 해준다.
 * 결과값은 동일하다.
 */