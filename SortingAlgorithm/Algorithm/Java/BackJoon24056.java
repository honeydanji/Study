package SortingAlgorithm.Algorithm.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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
        int[] testArr;
        int[] testBrr;
        String testA;
        String testB;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int newItem = arr[i];
            int loc = i - 1;
            
            while (loc >= 0 && newItem < arr[loc]) {
                arr[loc + 1] = arr[loc];
                loc--;
                
                testArr = arr;
                testBrr = brr;

                testA = Arrays.toString(testArr).replaceAll("[^0-9]", "");
                testB = Arrays.toString(testBrr).replaceAll("[^0-9]", "");

                System.out.println(testA + " " + testB);

                if(Integer.parseInt(testA) == Integer.parseInt(testB)) {
                    System.out.println(1);
                    break;
                }
                if(Integer.parseInt(testA) < Integer.parseInt(testB)) {
                    System.out.println(0);
                    break;
                }
            }

            if (loc + 1 != i) {
                arr[loc + 1] = newItem;
            }
        }
    }
}
