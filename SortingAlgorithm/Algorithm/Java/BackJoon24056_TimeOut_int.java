package SortingAlgorithm.Algorithm.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BackJoon24056_TimeOut_int {

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
        boolean test = false;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int newItem = arr[i];
            int loc = i - 1;
            
            while (loc >= 0 && newItem < arr[loc]) {
                arr[loc + 1] = arr[loc];
                loc--;
            }
            if (loc + 1 != i) {
                arr[loc + 1] = newItem;
            }

            if(Arrays.toString(arr).equals(Arrays.toString(brr))) {
                test = true;
                System.out.println(1);
            }
        }
        if(!test) {
            System.out.println(0);
        }
    }
}
