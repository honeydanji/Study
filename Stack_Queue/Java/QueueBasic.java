package Stack_Queue.Java;

import java.util.Scanner;

public class QueueBasic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntQueue q = new IntQueue(64);

        while(true) {
            System.out.println(); // 메뉴 구분
            System.out.printf("현재 데이터 개수: %d / %d/n");
            System.out.print("(1) 인큐  (2) 디큐  (3) 피크 (4) 덤프 (0) 종료: ");

            int menu = sc.nextInt();
            if (menu == 0) break;
            
            int x;
            switch (menu) {
                // 인큐
                case 1:
                    System.out.println("데이터: ");
                    x = sc.nextInt();
                    try {
                        q.enque(x); 
                    } catch(IntStack.OverflowIntStackException e) {
                        System.out.println("큐가 가득 찾습니다.");
                    }
                    break;

                // 디큐
                case 2:
                    try {
                        x = q.deque();
                        System.out.println("디큐한 데이터는 " + x + "입니다.");
                    } catch(IntStack.EmptyIntStackException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                // 피크
                case 3:
                    try {
                        x = q.peek();
                        System.out.println("픽한 데이터는 " + x + "입니다.");
                    } catch(IntStack.EmptyIntStackException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 4:
                    q.dump();
                    break;
            }
        }
    }
}

class IntQueue {
    private int[] que;
    private int capacity;
    private int front;  // 맨앞 커서
    private int rear;   // 맨뒤 커서 + 1
    private int num;    // 현재 데이터 개수

    // 비어 있을 때
    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {}
    }

    // 가득 찾을 때
    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {}
    }

    public IntQueue(int maxlen) {
        num = front = rear = 0;
        capacity = maxlen;
        try {
            que = new int[capacity]; // 큐 배열 생성
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    // 인큐
    public int enque(int x) throws OverflowIntQueueException {
        if (num >= capacity) {
            throw new OverflowIntQueueException();
        }
        que[rear++] = x;
        num++;
        if(rear == capacity)
            rear = 0;
        return x;
    }

    // 디큐
    public int deque() throws EmptyIntQueueException {
        if (num <=0 ){
            throw new EmptyIntQueueException();
        }
        int x = que[front++];
        num--;
        if(front == capacity){
            front = 0;
        }
        return x;
    }

    // 피크
    public int peek() throws EmptyIntQueueException {
        if (num <= 0) {
            throw new EmptyIntQueueException();
        }
        return que[front];
    }

    // 큐에서 x를 검색
    public int indexOf(int x) {
        for(int i = 0; i < num; i++) {
            int idx = (i + front) % capacity;
            if (que[idx] == x)  // 검색성공
                return idx;
        }
        return -1;  // 검색실패
    }

    // 프런트 > 리어순으로 큐 요소 출력
    public void dump() {
        if (num <= 0) {
            System.out.println("큐가 비어 있습니다.");
        }else {
            for (int i = 0; i < num; i++){
                System.out.println(que[(i + front) % capacity] + " ");
            }System.out.println();
        }
    }
}

/*
 * 1. 일반적인 방법
 * 인큐 : 시간복잡도 O(1)
 * 디큐 : 시간복잡도 O(n) >> 맨앞에 요소가 빠지면 나머지 요소들이 한칸씩 앞으로 움직여야함
 * 
 * 2. 링 버퍼
 * 인큐, 디큐 : 시간복잡도 O(1)
 */