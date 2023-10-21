## Stack, Queue 사용 방법
1. 로직을 직접 구현
2. 'java.util.Stack'과 'java.util.Queue' 인터페이스 사용 

## Stack, Queue 종류
1. Stack : 배열, Deque
2. Queue : 배열, 우선순위큐, Heap, Deque


#### Summary
- Stack Basic Version
    >> push, pop, peek 등 각각의 메서드를 구현하는 것이 목표.

- Queue Basic Version
    >> Inque, Deque, peek 등 각각의 메서드를 구현하는 것이 목표

- Object Version
    >> 대부분의 코드는 Basic과 동일하다. 다른 점은 클래스가 Generic 타입으로 선언된 것!
    ```Java
    class IntStack<E> {
        private E[] stk;
        private int capacity;
        private int ptr;

        ''''
    }
    ```
    >> Generic은 런타임시 타입이 결정되기 때문에 생성자 호출이 안된다.

    >> Generic 타입의 배열은 형변환을 통해서 구현 가능
    ```Java
    public IntStack(int maxlen) {
        ptr = 0;
        capacity = maxlen;
        try {
            stk = (E[]) new Object[capacity]; // 형변환 (타입 안정성을 해치는 지 판단해야함.)
        } catch (OutOfMemoryError e) { // 메모리 초과 >> 생성할 수 없음.
            capacity = 0;
        }
    }
    ```
    >> 위 처럼 형변환을 하면 타입 안정성을 컴파일 시에 확인이 어렵다. (드문 상황)

    >> 배열이아닌 컬렉션을 사용하면 위와 같은 문제는 해결된다.

