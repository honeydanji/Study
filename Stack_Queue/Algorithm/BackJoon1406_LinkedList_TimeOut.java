package Stack_Queue.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class BackJoon1406_LinkedList_TimeOut {
    
    public static void main(String[] args) throws IOException {
        // 입력 셋팅
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 초기 문자열
        String input = bf.readLine(); 
        String[] inputArray = input.split("");
        List<String> inputList = new LinkedList<>();
        for(String s : inputArray) {
            inputList.add(s);
        }
        
        // 초기 커서 위치(맨뒤)
        int cusor = input.length();

        // 명령어 횟수
        int num = Integer.parseInt(bf.readLine());

        // test
        String[] test;

        for(int i = 0; i < num; i++) {
            String command = bf.readLine();
            switch(command) {
                // 커서가 맨압 > 무시 or 왼쪽 이동
                case "L" :
                if(cusor == 0) {
                    break;
                }else {
                    cusor--;
                    break;
                }
                // 커서가 맨뒤 > 무시 or 오른쪽 이동
                case "D" :
                if(cusor == inputList.size()) {
                    break;
                }else{
                    cusor++;
                    break;
                }
                // 커서가 맨압 > 무시 or 왼쪽 문자 삭제
                case "B" :
                if(cusor == 0) {
                    break;
                }else {
                    inputList.remove(--cusor);
                    // cusor--;
                    break;
                }
                // "문자" 커서 왼쪽에 추가
                default :
                test = command.split(" ");
                // String plus = command.charAt(1);
                inputList.add(cusor, test[1]);
                cusor++;
                break;
            }
        }
        for(String a : inputList) {
            System.out.print(a);
        }
    }
}
/* TIP
 * 해당 문제에서는 요소를 추가 및 삭제 하는 경우가 많다.
 * 배열처럼 고정되어 있으면 안되고 List를 사용하는 것이 좋겠다.
 * 커서 위치가 핵심
 * 
 * ArrayList : 요소에 빠르게 접근가능, 그러나 요소를 추가하거나 제거할 때 느림
 * LinkedList : 요소를 빠르게 추가하거나 제거가 가능함. 단 순차적으로 접근할 때 느림
 * 
 * 시간초과 이유
 * : LinkedList를 사용하면 요소 추가 및 제거가 빠르게 가능하다고 한다. 하지만 해당 문제의 핵심은 커서
 * 즉 커서가 왔다 갔다 하는 방식이다. 커서의 위치에 따라 해당 요소를 지울 수 있다. 하지만 LinkedList특성상
 * 해당 커서가 요소를 지울 때 마다 우리눈에 보이지 않지만 커서는 처음부터 다시 움직이는 것이다.
 * 커서가 고정되어 있으면 시간초과가 나오지 않는데 커서는 요소를 지우고 다시 제자리로 돌아가고 또 지우고 돌아가고
 * 반복하기 때문에 시간복잡도가 O(N) 즉 60만개의 예시가 주어지면 60만번 반복을 한다는 소리다.
 * 
 * 커서를 고정 시키는 것이 시간 초과를 해결하는 핵심이다. 
*/ 

