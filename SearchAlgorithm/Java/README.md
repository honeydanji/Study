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
    ```Java
    Arrays.binarySearch(persondata, new personData("", height, 0.0), personData.HEIGHT_ORDER);
    ```
    
    >> Arrays.binarySearch의 구성을 한번보자.
    ```Java
    // binarySearch 구조
    public static <T> int binarySearch(T[] a, T key, Comparator<? super T> c) {
        return binarySearch0(a, 0, a.length, key, c);
    }
    // a : 주어진 배열, key : 찾고자하는 객체, Comparator : 요소 비교 
    ```
    
    >> Arrays.binarySearch의 작동방식을 이해하기 위해서는 binaarySearch0()의 구조를 알아야 한다.
    ```Java
    private static <T> int binarySearch0(T[] a, int fromIndex, int toIndex,
                                         T key, Comparator<? super T> c) {
        if (c == null) {
            return binarySearch0(a, fromIndex, toIndex, key);
        }
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            T midVal = a[mid];
            int cmp = c.compare(midVal, key);
            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }
    ```
    >> bianrySearch0() 코드를 보면 객체배열 비교에서 이진탐색이 작동되는 방식을 알 수 있다.

    ```Java
    // Comprator 정의(height 기준)
    public static final Comparator<personData> HEIGHT_ORDER = new HeightOrderComparator(); 

        private static class HeightOrderComparator implements Comparator<personData> {

            public int compare(personData pd1, personData pd2) {
                return (pd1.height > pd2.height) ? 1 :
                        (pd1.height < pd2.height) ? -1 : 0;
            }
        }
    ```
    
    >> Comparator를 구현해서 사용한다. 왜?? 객체마다 비교 기준을 달리할 수 있다. 즉 커스텀이 가능하다.
    
    >> 예제 코드에서는 "height"를 기준으로 Comparator를 구현했다.
    
    >> 그러므로 Arrays.binarySearch()를 이용해서 이진탐색에 대한 기준은 Comparator에 따라서 다르다.     
