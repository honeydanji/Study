package RecursiveAlgorithm.Algorithm;

import java.util.Scanner;

public class BackJoon9663_BackTracking_CompileError {
    
    private boolean[] flag_a;
    private boolean[] flag_b;
    private boolean[] flag_c;
    private int[] pos;
    private int count;

    private void setQueen(int n) {
        this.flag_a = new boolean[n];
        this.flag_b = new boolean[2 * n - 1];
        this.flag_c = new boolean[2 * n - 1];
        this.pos = new int[n];
        this.count = 0;
    }

    static void set(int i, BackJoon9663_BackTracking_CompileError b, int n) {
        for (int j = 0; j < n; j++) {
            if(b.flag_a[j] == false && b.flag_b[i + j] == false && b.flag_c[i - j + (n - 1)] == false) {
                b.pos[i] = j;
                if (i == n - 1) {
                    b.count++;
                }else {
                    b.flag_a[j] = b.flag_b[i + j] = b.flag_c[i - j + (n - 1)] = true;
                    set(i + 1, b, n);
                    b.flag_a[j] = b.flag_b[i + j] = b.flag_c[i - j + (n - 1)] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        BackJoon9663_BackTracking_CompileError b = new BackJoon9663_BackTracking_CompileError();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        b.setQueen(n);
        set(0,b,n);
        System.out.println(b.count);
    }

}
