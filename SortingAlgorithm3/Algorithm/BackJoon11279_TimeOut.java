package SortingAlgorithm3.Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BackJoon11279_TimeOut {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        int input;

        List<Integer> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < testCase; i++) {
            input = sc.nextInt();

            if (input == 0) {
                if(arr.isEmpty()) {
                    sb.append(input + "\n");
                    continue;
                }

                // 배열을 힙으로 만든다 >> 루트에는 최상위값이 존재 해야함.
                for (int j = (arr.size() - 1) / 2; j >= 0; j--) {
                    downHeap(arr, j, arr.size() - 1); // 'i'를 루트로 하는 서브트리가 최대 힙의 속성을 만족하도록 downHeap 호출
                }

                // 제일 큰값 삭제와 동시에 출력
                int output = arr.remove(0);
                if (i != testCase - 1) {
                    sb.append(output + "\n");
                }else {
                    sb.append(output);
                }
            }else {
                arr.add(input);
            }
        }

        System.out.println(sb);
    }

    static void downHeap(List<Integer> a, int left, int right) {
        // 임시 변수 temp에 현재 노드의 값을 저장
        int temp = a.get(left);

        // 자식 노드와 부모 노드의 인덱스를 나타내는 변수들을 초기화합니다.
        int child;
        int parent;

        // 힙을 구성하는 부분
        for (parent = left; parent < (right + 1) / 2; parent = child) {
            
            
            int cl = parent * 2 + 1; // 자식노드 왼쪽
            int cr = cl + 1;         // 자식노드 오른쪽

            // child에는 더 큰 값을 가진 자식 노드의 인덱스가 저장됩니다.   
            child = (cr <= right && a.get(cr) > a.get(cl)) ? cr : cl;
            
            // 현재 노드의 값이 자식 노드의 값보다 크거나 같으면 탈출
            if (temp >= a.get(child)) {
                break;
            }
            
            // 현재 노드의 값이 자식 노드보다 작으면 위치 변경
            a.set(parent, a.get(child));
        }
        
        a.set(parent, temp);
    }
    
}
