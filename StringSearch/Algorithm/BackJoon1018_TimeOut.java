package StringSearch.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BackJoon1018_TimeOut {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = bf.readLine().split(" ");
        List<char[]> bw = new ArrayList<>();
        List<Integer> bStart = new ArrayList<>();

        for(int i = 0; i < Integer.parseInt(nm[0]); i++) {
            bw.add(bf.readLine().toCharArray());
        }

        for(int ii = 0; ii < bw.size() - 7; ii++) {
            for(int jj = 0; jj < bw.get(0).length - 7; jj++) {
                bStart.add(c(ii,jj,bw));
            }
        }
        search(bStart);
    }

    private static void search(List<Integer> bStart) {
        if (bStart.size() >= 1) {
            int min = bStart.get(0);
            for(int i = 1; i < bStart.size(); i++) {
                if(bStart.get(i) < min) {
                    min = bStart.get(i);
                }
            }
            System.out.println(min);
        }else {
            System.out.println(bStart.get(0));
        }
    }

    private static int c(int ii, int jj, List<char[]> bw) {
        int bCount = 0;

        for (int i = ii; i < 8 + ii; i++) {
            for (int j = jj; j < 8 + jj - 1; j++) {
                if (bw.get(i)[j] == bw.get(i)[j+1]) { // 여기서 왜 오류가 나오는 거지???
                    if (bw.get(i)[j] == 'W') {
                        bw.get(i)[j+1] = 'B';
                    } else {
                        bw.get(i)[j+1] = 'W';
                    }
                    bCount++;
                }
            }
            if (i != bw.size()-1 && bw.get(i)[jj] == bw.get(i+1)[jj]) {
                if(bw.get(i)[jj] == 'B') {
                    bw.get(i+1)[jj] = 'W';
                }else {
                    bw.get(i+1)[jj] = 'B';
                }
                bCount++;
            }
        }
        return bCount;
    }
}



