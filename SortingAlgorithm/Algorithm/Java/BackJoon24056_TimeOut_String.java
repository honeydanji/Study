package SortingAlgorithm.Algorithm.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BackJoon24056_TimeOut_String {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        String[] a = bf.readLine().split(" ");
        String[] b = bf.readLine().split(" ");

        insertionSort(a, b);
    }

    public static void insertionSort(String[] arr, String[] brr) {
        boolean test = false;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int newItem = Integer.parseInt(arr[i]);
            int loc = i - 1;
            
            while (loc >= 0 && newItem < Integer.parseInt(arr[loc])) {
                arr[loc + 1].equals(arr[loc]);
                loc--;
            }
            if (loc + 1 != i) {
                arr[loc + 1] = Integer.toString(newItem);
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
