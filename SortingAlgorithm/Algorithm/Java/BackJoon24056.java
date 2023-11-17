package SortingAlgorithm.Algorithm.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon24056 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        String[] A = bf.readLine().split(" ");
        String[] B = bf.readLine().split(" ");

        int[] arr = new int[n];
        int[] brr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(A[i]);
            brr[i] = Integer.parseInt(B[i]);
        }
        
        insertionSort(arr, brr);

    }

    public static void insertionSort(int[] arr, int[] brr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {

            int newItem = arr[i]; // 타겟

            int loc = i - 1;
            
            while (loc >= 0 && newItem < arr[loc]) {
                arr[loc + 1] = arr[loc]; // 앞에 있는 숫자가 뒤에 오는 숫자보다 더 작을 때 삽입 >> 앞에 수가 크면 멈춤. 

                loc--; // -1 되면 반복문 멈춤 즉 커서위치가 맨앞으로 간다. 더이상 비교할 값이 존재하지 않음. 

                // i 는 타겟의 위치
                // 타겟은 i - 1 과 1 + 1 사이에 존재하면 안된다. 
                if (newItem == brr[i-1] && newItem == brr[i+1]) {
                    System.out.println(0);
                }else {
                    System.out.println(1);
                }
                
            }

            if (loc + 1 != i) {
                arr[loc + 1] = newItem;
            }
        }
    }
}
