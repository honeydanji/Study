## [▶Java](Algorithm/Java/), [▶Python](Algorithm/Python/)을 이용한 리스트 구현 (2023-11-30)

#### 링크드리스트 구현 방식
1. 포인터 이용 연결 리스트
    <img src = "https://github.com/honeydanji/Study/assets/129818881/697ab601-ae75-4ced-a836-65caa2a1facd">
2. 배열커서 이용 연결 리스트
3. 원형 이중 연결 리스트

#### Summary
1. 포인터 이용 연결 리스트
    - 각 노드의 있는 "next"는 다음 노드의 주소가 저장되어 있다. 인스턴스가 어디에 있는 지 찾아 가기 위해서는 주소를 이용해야 한다.
    - 삭제, 추가, 이동 등 노드를 컨트롤할 때 ```currentPointer```를 잘 봐야한다.