package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon10816_1차 {

    static int binarySearch(int[] nList, int a) {

        int first = 0;
        int last = nList.length - 1;
        int num = 0;

        do {
            int mid = (first + last)/2;
            if(nList[mid] == a){
                num++;
            }else if(nList[mid] < a) {
                first = mid + 1;
            }else{
                last = mid - 1;
            }
        }while(first <= last);

        return num;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 상근이 숫자 카드 개수
        System.out.println("숫자 카드 개수 입력 :");
        int n = Integer.parseInt(bf.readLine());

        // 상근이 숫자 카드
        System.out.println("숫자 카드 입력 :"); 
        String[] nn = bf.readLine().split(" ");
        int[] nList = new int[n];
        for(int i = 0; i < nList.length; i++) {
            nList[i] = Integer.parseInt(nn[i]);
        }
        
        // 정렬하기
        Arrays.sort(nList);

        // 비교 카드 개수
        System.out.println("비교 카드 개수 입력 :");
        int m = Integer.parseInt(bf.readLine());

        // 비교 숫자 카드 
        System.out.println("비교 숫자 카드 입력 :");
        String[] mm = bf.readLine().split(" ");
        int[] mList = new int[m];
        for(int i = 0; i < mList.length; i++) {
            mList[i] = Integer.parseInt(mm[i]);
        }

        // 오름차순 정렬
        Arrays.sort(nList);

        // 이진분류
        for(int a : mList) {
            if(binarySearch(nList, a) == 1) {
                // System.out.println("값이 존재합니다.");
                System.out.println(binarySearch(nList, a));
            }
        }

    }
}

// 배열을 이용하면 요소들이 고정되어 있어서 mid 값이 변하지 않음.