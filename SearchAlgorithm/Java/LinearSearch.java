package Java;

import java.util.Random;
import java.util.Scanner;

public class LinearSearch {

    static String linear_search(int num, int[] list) {

        for(int i = 0; i < list.length; i++) {
            if(list[i] == num) {
                return "key 값은 " + i + "번 index에 존재합니다.";
            }
        }
        return "key 값은 존재하지 않습니다.";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 찾고자 하는 key 입력
        int key = sc.nextInt();

        // 1. list 선언 및 초기화
        int[] list = new int[] {1,2,3,4,5,6,7};

        // 2. list 선언 후 반복문으로 입력 받기
        Random rd = new Random();

        int n = sc.nextInt();
        int[] list_for = new int[n];
        for(int i = 0; i < list_for.length; i++) {
            list_for[i] = rd.nextInt(n+1);
        }

        System.out.println(linear_search(key, list)); // 1번
        System.out.println(linear_search(key, list_for)); // 2번
    }
}

/*
 * 선형탐색
 * 
 * 
 * 
 */