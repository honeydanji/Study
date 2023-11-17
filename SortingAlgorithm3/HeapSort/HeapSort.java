package SortingAlgorithm3.HeapSort;

import java.util.Scanner;

public class HeapSort {

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void downHeap(int[] a, int left, int right) {
        // 임시 변수 temp에 현재 노드의 값을 저장
        int temp = a[left];

        // 자식 노드와 부모 노드의 인덱스를 나타내는 변수들을 초기화합니다.
        int child;
        int parent;

        // 힙을 구성하는 부분
        for (parent = left; parent < (right + 1) / 2; parent = child) {
            
            
            int cl = parent * 2 + 1; // 자식노드 왼쪽
            int cr = cl + 1;         // 자식노드 오른쪽

            // child에는 더 큰 값을 가진 자식 노드의 인덱스가 저장됩니다.   
            child = (cr <= right && a[cr] > a[cl]) ? cr : cl;
            
            // 현재 노드의 값이 자식 노드의 값보다 크거나 같으면 탈출
            if (temp >= a[child]) {
                break;
            }
            
            // 현재 노드의 값이 자식 노드보다 작으면 위치 변경
            a[parent] = a[child];
        }
        
        a[parent] = temp;
    }

    // 주어진 배열 'a'에 대해 힙 정렬을 수행하는 함수입니다. 배열 크기는 'n'입니다.
    static void heapSort(int[] a, int n) {
        
        // 단계 1: 최대 힙 구축
        for (int i = (n - 1) / 2; i >= 0; i--) {
            downHeap(a, i, n - 1); // 'i'를 루트로 하는 서브트리가 최대 힙의 속성을 만족하도록 downHeap 호출
        }

        // 단계 2: 정렬 수행
        for (int i = n - 1; i > 0; i--) {
            swap(a, 0, i);           // 루트(가장 큰 요소)를 마지막 정렬되지 않은 요소와 교환
            downHeap(a, 0, i - 1);    // 남은 요소들을 최대 힙의 속성을 유지하도록 다시 힙화
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("힙 정렬");
        System.out.print("요솟수: ");
        int nx = sc.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = sc.nextInt();
        }

        heapSort(x, nx); // 배열 x를 힙 정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println(x[i]);
        }
    }
}
