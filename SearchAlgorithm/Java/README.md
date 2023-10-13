## 이진탐색 하는 방법
1. 로직을 직접 구현 
2. Arrays.binarySearch()에 의한 이진 검색 >> API 문서 확인하기

## 이진탐색 대상
1. 기본 자료형 배열
2. 객체 배열
    - static int binarySearch(Obejct[] a, Object key) >> 자연 정렬
    - static <T> int binarySearch(T[] a, T key, Comparator<? super T> c) >> 순서 정렬

    >> 객체 배열의 이진 탐색에는 2가지 방법이 위와 같이 존재한다.
    
    >> binarySearch를 보면 파라미터 타입이 Object 최상위 클래스임을 알 수 있다.
    
    >> 그러므로 어떠한 타입의 배열이 들어와도 받을 수 있다.

#### summary
- Basic Version
    >> sort(), binarySearch() 를 사용하지 않을 때는 do-while문을 사용해서 하나씩 검사하면 입력을 받는다.
- Object_Natural Version
    >> 자연정렬에 대한 개념만 체크하고 넘어가자.
- Object_Order Version
    >> Arrays.binarySearch()를 사용해서 Comparator 객체를 넘겨주는게 핵심이다.
    
    >> Comparator를 구현해서 사용한다. 왜?? 객체마다 비교 기준을 달리할 수 있다. 즉 커스텀이 가능하다.
    
    >> 예제 코드에서는 "height"를 기준으로 Comparator를 구현했다.
    
    >> 그러므로 Arrays.binarySearch()를 이용해서 이진탐색에 대한 기준은 Comparator에 따라서 다르다.

#### TIP
- @Override의 사용 유무
    >> 보통 클래스 or 인터페이스를 상속받아서 메서드를 사용할 때 가독성을 위해 @Override를 사용한다.
    
    >> Comparator를 상속받았음에도 불구하고 @Override를 사용하지 않는다.
    
    >> 그건 Comparator의 compare가 Java에서 제공하는 내장 메소드이기 때문이다.
    
    >> 정리를 하면 (상속받는 경우에서)
    
    >> 사용자 정의 메소드 : @Override를 사용
    
    >> Java에서 제공하는 내장 메서드 : @Override를 사용 X 
        
