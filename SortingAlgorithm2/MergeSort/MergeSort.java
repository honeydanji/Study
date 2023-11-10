package SortingAlgorithm2.MergeSort;

import java.util.Scanner;

public class MergeSort {
    private static int[] buff;

    private static void __mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int i;
            int center = (left + right) / 2;
            int p = 0;
            int j = 0;
            int k = left;

            __mergeSort(a, left, center);
            __mergeSort(a, center + 1, right);

            for (i = left; i <= center; i++) {
                buff[p++] = a[i];
            }

            while (i <= right && j < p) {
                a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];
            }

            while (j < p) {
                a[k++] = buff[j++];
            }
        }
    }

    private static void mergeSort(int[] a, int n) {
        buff = new int[n];

        __mergeSort(a, 0, n - 1);

        buff = null;
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

        mergeSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
    }  
}
