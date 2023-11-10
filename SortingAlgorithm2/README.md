## [▶Java](Algorithm/Java/), [▶Python](Algorithm/Python/)을 이용한 정렬 알고리즘 구현 (2023-11-11)

#### 정렬 알고리즘 비교

| 알고리즘                      | 기능                                              | 장점                                                         | 단점                                                         | 시간 복잡도 (평균 및 최악)  |
| ------------------------- | ------------------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ---------------------------- |
| **퀵 정렬 (Quick Sort)**     | Pivot을 기준으로 분할하여 정렬                     | - 평균적으로 빠른 속도 (평균 O(n log n))<br>- 추가 메모리 공간 필요 없음 | - 최악의 경우(정렬된 데이터) 성능이 좋지 않음 (최악 O(n^2))<br>- 불안정 정렬 | O(n log n) (평균), O(n^2) (최악) |
| **병합 정렬 (Merge Sort)**   | 분할 정복 알고리즘으로 배열을 분할하고 병합           | - 안정적이고 일정한 성능 (항상 O(n log n))<br>- 대규모 데이터에 효과적 | - 추가 메모리 공간 필요 (임시 배열)<br>- 구현이 복잡함          | O(n log n) (평균 및 최악)      |
|

#### Summary
- 분할 정복 알고리즘은 log 밑은 2 다.
- 퀵정렬은 굉장히 효율적이지만 상황에 따라 성능이 급격하게 안좋아진다.
- 병합정렬은 서로 떨어져 있는 요소를 교환하는 것이 아니기 때문에 안정적인 정렬이다.

#### TIP
- Arrays.sort  
        <img src = "https://github.com/honeydanji/Study/assets/129818881/c1e38fb7-f6d3-4717-bb87-5004cdec89da">
    - 위 sort 메서드는 클래스 객체 배열을 정렬할 떄 사용.

- 그럼 Comparator 구현은 어떻게 하는 가? 
```
    static final Comparator<class.type> HEIGHT_ORDER = new HeightOrderComparator();

    private static class HeightOrderComparator implements Comparator<class.type> {
        public int compare(class.type test1, class.type test2) {
            return (test1.비교대상 > test2.비교대상) ? 1 :
                    (test1.비교대상 < test2.비교대상) ? -1 : 0
        }
    }

    .....

    Arrays.sort(x, class.Type.HEIGHT_ORDER);
    // 재정의한 Comparator 사용 법.

```
- 위 코드를 보면 순서가 이상하다. 
    - 보통은 클래스를 정의하고 상수를 초기화 해야한다.
    - 하지만 예상과는 다르게 오류없이 작동이 된다. 그런데 왜?
    - 정적 멤버는 클래스 로드 시점에 초기화 되기 때문에 오류 없이 작동이 된다.

- 정적 멤버?
    - static으로 선언된 필드, 메서드, 클래스 
- 클래스 로드 시점 ?
    - JVM이 클래스를 참조할 때 내부에 있는 정적 멤버들이 초기화 되는 시점.
    - 그러므로 정적 멤버들은 코드 위치와 상관없이 호출이 가능하다. 
