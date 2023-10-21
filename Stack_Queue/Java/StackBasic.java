package Stack_Queue.Java;

import java.util.Scanner;

class StackBasic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        IntStack s = new IntStack(64);

        while (true) {
            System.out.println(); // 메뉴 구분
            System.out.printf("현재 데이터 개수: %d / %d/n");
            System.out.print("(1) 푸시  (2) 팝  (3) 덤프  (0) 종료: ");

            int menu = sc.nextInt();
            if (menu == 0) break;
            
            int x;
            switch (menu) {
                case 1:
                    System.out.println("데이터: ");
                    x = sc.nextInt();
                    try {
                        s.push(x);
                    } catch(IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찾습니다.");
                    }
                    break;

                case 2:
                    try {
                        x = s.pop();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch(IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 3:
                    try {
                        x = s.peek();
                        System.out.println("픽한 데이터는 " + x + "입니다.");
                    } catch(IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 4:
                    s.dump();
                    break;
            }
        }

    }
}

class IntStack {
    private int[] stk;
    private int capacity;
    private int ptr;        // 스택 포인터

    // 실행시 예외 : 스택이 비어 있음
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {}
    }


    // 실행 시 예외 : 스택이 가득 참
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {}
    }

    // 생성자
    public IntStack(int maxlen) {
        ptr = 0;
        capacity = maxlen;
        try {
            stk = new int[capacity];
        } catch (OutOfMemoryError e) { // 메모리 초과 >> 생성할 수 없음.
            capacity = 0;
        }
    }

    // push
    public int push(int x) throws OverflowIntStackException {
        if (ptr >= capacity) {
            throw new OverflowIntStackException(); // 오류를 던진다
        }return stk[ptr++] = x;
    }

    // pop
    public int pop() throws EmptyIntStackException {
        if (ptr <= 0) {
            throw new EmptyIntStackException();
        }return stk[--ptr];
    }

    // peek
    public int peek() throws EmptyIntStackException {
        if (ptr <= 0) {
            throw new EmptyIntStackException();
        }return stk[ptr - 1];
    }

    // dump
    public void dump() {
        if (ptr <= 0) {
            System.out.println("스택이 비어 있습니다.");
        }else {
            for (int i = 0; i < ptr; i++){
                System.out.println(stk[i] + " ");
            }System.out.println();
        }
    }
}

/* 
 *  추가로 공부할 것들
 * ? RuntimeException ?
 * ? throw ? >> return이랑 차이가 뭔가??
 * 
 *
 */