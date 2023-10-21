package Stack_Queue.Java;

public class StackObject {
    
}

class IntStack<E> {
    private E[] stk;
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
            stk = (E[]) new Object[capacity]; // 형변환 (타입 안정성을 해치는 지 판단해야함.)
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
 * 제네릭 타입과 Object 타입의 차이점
 * 
 * Obeject
 * - 최상위 클래스인 Object로 선언을 하면 컴파일 단계에서 오류를 잡을 수 없다.(런타임에러에서는 가능)
 * - Object 타입으로 선언한 배열은 Integer든 String이든 타입이 섞여도 문법적으로 문제가 없기 때문이다.
 * 
 * Generic
 * - 컴파일 단계에서 타입을 체크한다.
 * - 캐스팅이 필요 없다.
 * - 타입을 명시적으로 하기 때문에 에러를 런타임이 아닌 컴파일단계에서 잡을 수 있다.
 */