## [▶Java](Java/), [▶Python](Python/)을 이용한 Stack, Queue 구현 (2023-10-21)
1. Stack
- 개념 : 후입선출(LIFO : Last In, First Out) 원칙을 따르는 선형 데이터 구조.
- 장점 :
    - 웹 브라우저 방문기록(뒤로가기)
    - 실행 취소
    - 역순 문자열 만들기
    - 후위 표기법 계산
- 단점 : 중간 요소 접근이 어려움

2. Queue
- 개념 : 선입선출(FIFO : First In, First Out) 원칙을 따르는 선형 데이터 구조
- 장점 : 
    - 은행 업무
    - 대기열 순서와 같은 우선순위의 작업 예약 등
    - 서비스 센터의 대기시간
    - 프로세스 관린
- 단점 : 중간 요소 접근이 어려움

#### Summary
- Stack과 Queue는 상황에 따라 효율이 달라지기 때문에 적절하게 사용해야한다.
- Stack 시간 복잡도
    - 일반적인 스택 > 선형탐색, O(N)
    - Deque 사용 스택 : O(N)
- Queue 
    - 일반적인 큐 > 선형탐색, O(N)
    - 우선순위 큐 > 선형탐색, O(N)
    - Heap 사용 큐 > O(log N)
    - Deque 사용 큐 > O(N)

#### TIP
1. Exception
- Exception 전체 구성도
<img src ="https://github.com/honeydanji/Algorithm/assets/129818881/88992c81-7ca2-4b9d-8c25-cc583e00c786">
    - Error : 시스템에 비정상적인 상황이 생겼을 때 발생하는 예외
    - Exception : 개발자가 구현한 로직에서 발생 >> 미리 예측이 가능한 영역

    
- Checked Exception vs UnChecked Exception
<img src = "https://github.com/honeydanji/Algorithm/assets/129818881/ba7e70d0-6596-477a-aa33-ed92cbad238a">

- RuntimeException 무엇? >> 컴파일이 아닌 프로그램이 실행될 때 발생하는 예외

    >> RuntimeException를 상속받는 Java에서 제공하는 예외 클래스
    - NullPointerException (널 포인터 예외)
    - ArithmeticException (산술 연산 예외)
    - ArrayIndexOutOfBoundsException (배열 인덱스 예외) 등이 존재한다.
    
    >> 런타임 예외를 직접 설정하는 경우
    ```Java
    public static void test(int a) {
        if(a == 0){
            throw new RuntimeException("a는 0이 되면 안됩니다.")
        }
    }
    ```

2. Object와 Generic
- Obeject
    - Object 타입으로 선언한 배열은 Integer든 String이든 타입이 섞여도 문법적으로 문제가 없다.
    - 그러므로 컴파일 단계에서 오류를 잡을 수 없다.(런타임에러에서는 가능)
    - 컴파일시에 에러를 잡을 수 없으니 런타임시에 잡아야하는데 이건 비용이나 시간적 측면에서 손실이 크다.
    - 형변환을 제대로 하지 않으면 'classcastException'과 같은 오류가 발생한다.

- Generic
    - 컴파일 단계에서 타입을 체크한다. 즉 타입이 명시적이기 때문에 컴파일 단계에서 에러를 잡을 수 있다.
    - 그러므로 가독성이 향상하고 유지보수를 더 쉽게 만든다.
    - 형변환과 관련된 오류를 줄이는데 도움이 된다.

- 정리
    - Object는 모든 객체를 저장할 수 있지만 컴파일러가 타입 검사를 하지 않아 런타임 오류 발생 가능
    - Generic은 타입을 명시하여 컴파일 시에 타입 안정성을 보장
