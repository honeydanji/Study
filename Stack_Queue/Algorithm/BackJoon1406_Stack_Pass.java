package Stack_Queue.Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BackJoon1406_Stack_Pass {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stk1 = new Stack<>();
        Stack<Character> stk2 = new Stack<>();

        // 초기 문자열
        char[] input = bf.readLine().toCharArray();

        for(char ch : input) {
            stk1.push(ch);
        }

        // 명령어 횟수
        int num = Integer.parseInt(bf.readLine());

        // test
        String[] test;

        for(int i = 0; i < num; i++) {
            String command = bf.readLine();
            switch(command) {
                // 커서가 맨압 > 무시 or 왼쪽 이동
                case "L" :  
                    if(!stk1.empty()) {
                        stk2.push(stk1.pop());
                    }
                    break; 
                // 커서가 맨뒤 > 무시 or 오른쪽 이동
                case "D" :
                    if(!stk2.empty()) {
                        stk1.push(stk2.pop());
                    }
                    break;
                // 커서가 맨압 > 무시 or 왼쪽 문자 삭제
                case "B" :
                    if(!stk1.empty()) {
                        // stk2.push(stk1.pop());
                        stk1.pop();
                        // stk1.push(stk2.pop());
                    }
                    break;
                // "문자" 커서 왼쪽에 추가
                default :
                    test = command.split(" ");
                    stk1.push(test[1].charAt(0));
                break;
            }
        }
        for(char ch : stk1) {
            bw.write(ch);
        }
        while(!stk2.isEmpty()) {
            bw.write(stk2.pop());
        }

        bw.flush();
		bw.close();
    }
    
}
