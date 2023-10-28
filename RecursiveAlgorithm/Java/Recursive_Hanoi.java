package RecursiveAlgorithm.Java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recursive_Hanoi {
    private static int total = 0;
    private static List<String> list = new ArrayList<>();
    
    static void move(int n, int x, int y) {
        if (n > 1) {
            move(n - 1, x, 6 - x - y);
        }

        total++;
        list.add(x + " " + y);
        
        if (n > 1) {
            move(n - 1, 6 - x - y, y);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        move(n, 1, 3);
        System.out.println(total);
        for(String s : list) {
            System.out.println(s);
        }
    }
}
