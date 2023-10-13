package Java;

import java.util.Scanner;

public class BinarySearch_Basic {
    static String SearchBasic(int key, int[] searchList) {
        int first = 0;
        int last = searchList.length - 1;

        do {
            int middle = (first + last) / 2;
            if(key == searchList[middle]) {
                return "key는 " + middle + "번 index에 존재합니다."; 
            }else if(key < searchList[middle]) {
                last = middle - 1;
            }else if(key > searchList[middle]) {
                first = middle + 1;
            }
        }while(first <= last);

        return "값이 존재 하지 않습니다.";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 찾고자 하는 key
        System.out.print("찾고자 하는 key를 입력하세요 : ");
        int key = sc.nextInt();

        // 배열 크기(범위)
        System.out.print("범위를 지정해주세요 : ");
        int size = sc.nextInt();
        
        // 배열 선언
        int[] searchList = new int[size];
        
        // 배열 0번 인덱스 입력
        System.out.print("0번 index 값을 입력해주세요 : ");
        searchList[0] = sc.nextInt();

        // 오름차순으로 입력받기
        for(int i = 1; i < size; i++) {
            do {
                searchList[i] = sc.nextInt();
            }while(searchList[i] < searchList[i - 1]);
        }

        System.out.println("SearchList[] :");
        for(int i : searchList) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println(SearchBasic(key, searchList));
    }
}

/*
    * 1. 배열 크기를 정하자
    * 2. 찾고자 하는 값을 정하자
    * 3. 이진탐색 메서드를 작성하자
    * 4. key값이 존재하면 index를 출력하자
    * 5. key값이 존재하지 않으면 "찾는 값이 없습니다."를 출력하자
*/

