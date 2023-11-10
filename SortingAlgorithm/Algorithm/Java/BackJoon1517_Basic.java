package SortingAlgorithm.Algorithm.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BackJoon1517_Basic {
    private static int count = 0;
    private static List<Integer> bubble;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        bubble = new ArrayList<>();

        String[] test = bf.readLine().split(" ");

        for (int i = 0; i < test.length; i++) {
            bubble.add(Integer.parseInt(test[i]));
        }

        // 정렬
        sort(bubble);
    }

    // 정렬 및 카운팅
    private static void sort(List<Integer> bubble) {
        for (int i = 0; i < bubble.size() - 1; i++) {
            for (int j = bubble.size() - 1; j > i; j--) {
                if (bubble.get(j - 1) > bubble.get(j)) {
                    count++;
                    swap(bubble, j-1, j);
                }
            }
        }
        System.out.println(count);
    }

    // 요소 정렬
    private static void swap(List<Integer> bubble, int x, int y) {
        int a = bubble.get(x);
        bubble.set(x, bubble.get(y));
        bubble.set(y, a);
    }
}
