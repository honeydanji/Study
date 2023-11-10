package SortingAlgorithm2.QuickSort;

import java.util.Scanner;
import java.util.Stack;

public class QuickSort_not_recur {

    private static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    private static void quickSort(int[] a, int left, int right) {
        Stack<Integer> lstack = new Stack<>();
        Stack<Integer> rstack = new Stack<>();

        lstack.push(left);
        rstack.push(right);

        while (lstack.isEmpty() != true) {
            int pl = left = lstack.pop();
            int pr = right = rstack.pop();
            int x = a[(left + right) / 2];
        
            do {
                while (a[pl] < x) pl++;
                while (a[pr] > x) pr--;
                if (pl <= pr) {
                    swap(a, pl++, pr--);
                }
            }while (pl <= pr);

            if (left < pr) {
                lstack.push(left);
                rstack.push(pr);
            }

            if (pl < right) {
                lstack.push(pl);
                rstack.push(right);
            }
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("요솟수 입력");
        int nx = sc.nextInt();
        int[] x = new int[nx];

        System.out.println(String.format("배열 요소 %d 개 입력", nx));
        for(int i = 0; i < x.length; i++) {
            x[i] = sc.nextInt();
        }

        quickSort(x, 0, nx - 1);

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
    }  
}
