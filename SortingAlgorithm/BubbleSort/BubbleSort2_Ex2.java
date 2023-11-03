package SortingAlgorithm.BubbleSort;

import java.util.Scanner;

public class BubbleSort2_Ex2 {
    private static int count = 0;
    private static int exchg = 0;

    private static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    private static void bubbleSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            pass(i);
            for (int j = n - 1; j > i; j--) {
                if (a[j - 1] > a[j]) {
                    plus(a, j);
                    swap(a, j - 1, j);
                }else {
                    minus(a, j);
                }
            }
            output(a);
            if (exchg == 0) break;
        }
    }

    // Pass 메시지
    private static void pass(int i) {
        System.out.println("패스 " + (i + 1) + ": ");
    }

    // 교환이 일어난 위치 '+' 추가
    private static void plus(int[] a, int j) {
        for(int aa : a) {
            System.out.print(aa + " ");
            if(aa == a[j-1]) {
                exchg++;
                count++;
                System.out.print("+ ");
            }else {
                System.out.print("  ");
            }
        }
        System.out.println();
    }

    // 교환이 일어나지 않은 위치 '-' 추가
    private static void minus(int[] a, int j) {
        for(int aa : a) {
            System.out.print(aa + " ");
            if(aa == a[j-1]) {
                count++;
                System.out.print("- ");
            }else {
                System.out.print("  ");
            }
        }
        System.out.println();
    }

    private static void output(int[] a) {
        for(int aa : a) {
            System.out.print(aa + "   ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("버블 정렬(버전 2 Ex 2)");
        System.out.print("요솟수: ");
        int nx = sc.nextInt();
        int[] x = new int[nx];

        for(int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "]" + ": ");
            x[i] = sc.nextInt();
        }

        bubbleSort(x, nx);
        System.out.println("비교를 " + count + "회 했습니다.");
        System.out.println("교환을 " + exchg + "회 했습니다.");
    }
}
