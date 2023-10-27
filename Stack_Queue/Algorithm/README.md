## BackJoon1406

- 해당 문제는 커서의 위치에 따라 요소를 추가 및 삭제를 하는 것이 핵심이다.
- 요소를 처리하는 방식은 ArrayList, LikedList을 생각했고 문제에서 제안한 방식은 LinkedList와 Stack이었다.
- 문제 이해를 돕기 위해서 구현을 먼저하고 코드 리팩토링 계획을 했다.

1. LinkedList -> TimeOut
    - 커서를 이용해서 요소를 컨트롤 했지만 계속해서 시간초과가 생겼다.
    - 내가 만든 커서는 위치를 나타낼 뿐이지 실제로 커서가 움직이는 건 아니다. 
    - 그러므로 작업을 할 때마다 처음부터 다시 요소를 찾는다. >> 시간복잡도 O(N)
    - 시간초과를 해결하려면 실제로 커서가 위치만 나타내는 것이 아닌 움직여야 하는 것이 핵심이다.

2. LikeedList, ListIterator -> Pass
    - ListIterator를 이용하면 실제로 커서를 이용해 요소를 제어할 수 있다.
    - 요소를 제어한 뒤에 커서는 처음으로 돌아가지 않는다. >> 시간복잡도 O(1)
    - 시간초과를 해결

#### Interface Iterator<E>
- ListIterator는 List 인터페이스를 확장한 서브 인터페이스
    ```Java
    List<Character> inputList = new LinkedList<>();
    ListIterator<Character> iter = inputList.listIterator();
    ```
- 위 코드처럼 List Collection을 구체화한 클래스(ArrayList, LinkedList)에만 적용이 가능하다.
- 순서가 있는 리스트의 요소를 조작하는데 유용하다.
- https://minhamina.tistory.com/18   << 링크를 통하면 더 정확하게 개념정리가 가능하다.


## BackJoon10845

- 단순히 Queue의 메서드를 구현하는 문제.
- Queue의 작동방식을 이해하는데 도움이 많이 되었다.

1. ArrayList 와 LinkedList 성능 차이
    <img src="https://github.com/honeydanji/Algorithm/assets/129818881/fed247f5-c004-4685-8709-b7c14f152ff9">

    - 요소를 제어하는데 있어서는 LinkedList가 효율적이라고는 했지만 속에서는 크게 차이가 없어 보인다.





