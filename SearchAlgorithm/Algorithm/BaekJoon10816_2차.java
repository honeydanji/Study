package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BaekJoon10816_2차 {

    static int binarySearch(List<Integer> nList, int a) {

        int first = 0;
        int last = nList.size() - 1;
        int num = 0;

        do {
            int mid = (first + last)/2;
            if(nList.get(mid) == a){
                num++;
                nList.remove(mid);
            }else if(nList.get(mid) < a) {
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
        List<Integer> nList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            nList.add(Integer.parseInt(nn[i]));
        }
        
        // 정렬하기
        nList.sort(Comparator.naturalOrder());

        for(Integer b : nList){
            System.out.print(b + " ");
        }

        // 비교 카드 개수
        System.out.println("비교 카드 개수 입력 :");
        int m = Integer.parseInt(bf.readLine());

        // 비교 숫자 카드 
        System.out.println("비교 숫자 카드 입력 :");
        String[] mm = bf.readLine().split(" ");
        List<Integer> mList = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            mList.add(Integer.parseInt(mm[i]));;
        }

        // 오름차순 정렬
        mList.sort(Comparator.naturalOrder());

        // 이진분류
        for(int a : mList) {
            if(binarySearch(nList, a) == 1) {
                System.out.println("값이 존재합니다.");
                System.out.println(binarySearch(nList, a));
            }
        }

    }
}

/*
 * List : 인터페이스
 * ArrayList : 클래스
 * 
 * >> List 안에 ArrayList, LinkedList가 존재한다고 생각하면 된다.
 */