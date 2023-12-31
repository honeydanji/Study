## [▶Java](Java/), [▶Python](Python/)을 이용한 재귀 알고리즘 구현 (2023-10-28)
1. 직접재귀
- 개념 : 함수 내에서 자신을 직접 호출하는 재귀 형태
- 장점 : 코드의 간결화가 가능하다.
- 단점 : 
    - 재귀를 호출할 때 마다 스택영역에 프레임이 추가되기 때문에 메모리 차지가 크다.
    - 중복계산이 많다.(메모화 기법사용하면 해결 가능.)
- 예시 : 팩토리얼
    ```Java
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
    ```

2. 간접재귀
- 개념 :  두 개 이상의 함수가 서로를 호출하여 재귀적으로 상호 작용하는 형태의 재귀
- 장점 : 코드의 간결화가 가능하다.
- 단점 : 
    - 재귀를 호출할 때 마다 스택영역에 프레임이 추가되기 때문에 메모리 차지가 크다.
    - 중복계산이 많다.(메모화 기법사용하면 해결 가능.)
- 예시 :
    ```Java
    public static void A(int n) {
        if (n > 0) {
            System.out.println("A(" + n + ") 호출");
            B(n - 1);
        }
    }

    public static void B(int n) {
        if (n > 0) {
            System.out.println("B(" + n + ") 호출");
            A(n - 1);
        }
    }

    public static void main(String[] args) {
        A(3);
    }
    ```

3. 백트래킹
- 개념 : 백트래킹은 조건을 만족하지 않는 경우, 해당 상태를 포기하고 이전 상태로 돌아가는 기법
- 장점 : 문제의 모든 가능성을 탐색할 수 있다.
- 단점 : 로직이 복잡하고 시간이 오래 걸린다.
- 예시 :  N-퀸 문제
    ```Java
        // 생략
    ```

#### Summary
- 재귀는 함수를 호출할 때 마다 스택영역에 데이터가 추가 되기 때문에 메모리를 많이 차지한다.
- 재귀로 구현할 수 있는 건 반복문, Stack, Queue로도 가능하다.
- 가장 큰 단점으로는 재귀가 반복될 때 마다 스택영역에 새로운 프레임이 추가 되기 때문에 큰 메모리를 차지한다.
- 재귀는 중복계산이 많아서 메모리 차지가 심한데 이를 해결 하기 위해서 메모화기법을 사용하면된다.


