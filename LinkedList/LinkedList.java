package LinkedList;

import java.util.Comparator;

public class LinkedList<E> {
    
    // 노드
    class Node<E> {
        private E data; // 현재 노드에 있는 데이터
        private Node<E> next; // 포인터(다음 노드 가리킴)
        

        // 생성자
        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> headPointer;   // 머리 포인트(머리 노드 참조)
    private Node<E> currentPointer; // 선택 포인터(선택 노드 참조)

    // 생성자
    public LinkedList() {
        headPointer = currentPointer = null;
    }

    // 노드 검색
    public E search(E addObject, Comparator<? super E> c) {
        Node<E> scanNode = headPointer;

        while (scanNode != null) {
            if (c.compare(addObject, scanNode.data) == 0) {
                currentPointer = scanNode;
                return scanNode.data;
            }
            scanNode = scanNode.next;
        }
        return null;
    }

    // 머리에 노드 삽입
    public void addFirst(E addObject) {
        Node<E> scanNode = headPointer; // 삽입 전의 머리 노드
        headPointer = currentPointer = new Node<E>(addObject, scanNode);
    }

    // 꼬리에 노드 삽입 (리스트가 비어 있는 경우)
    public void addLast(E addObject) {
        if (headPointer == null) { // 리스트가 비어 있을 경우 머리에 삽입
            addFirst(addObject);
        }else { // 리스트가 비어있지 않은 경우 꼬리에 삽입
            Node<E> scanNode = headPointer;
            while (scanNode.next != null) { // 포인터를 꼬리 노드로 이동하는 과정
                scanNode = scanNode.next;
            }
            scanNode.next = currentPointer = new Node<E>(addObject, null);
        }
    }

    // 머리 노드를 삭제
    public void removeFirst() {
        if (headPointer != null) {
            headPointer = currentPointer = headPointer.next;
        }
    }

    // 꼬리 노드를 삭제
    public void removeLast() {
        if (headPointer != null) {
            if (headPointer.next == null) {
                removeFirst();
            }
            else {
                Node<E> scanNode = headPointer; // 스캔 중인 노드
                Node<E> previousNode = headPointer; // 스캔 중인 노드의 앞쪽 노드

                while (scanNode.next != null) {
                    previousNode = scanNode;
                    scanNode = scanNode.next;
                }

                previousNode.next = null;   // 꼬리 노드 삭제
                currentPointer = previousNode;
            }
        }
    }

    // 노드 p를 삭제
    public void remove(Node<E> p) {
        if (headPointer != null) {
            if (headPointer == p) {
                removeFirst();
            }else {
                Node<E> scanNode = headPointer;
                
                while (scanNode.next != p) {
                    scanNode = scanNode.next;
                    if (scanNode == null) return; // p가 리스트에 없음
                }
                scanNode.next = p.next;
                currentPointer = scanNode;
            }
        }
    }

    // 선택 노드를 삭제
    public void removeCurrentNode() {
        remove(currentPointer);
    }

    // 모든 노드를 삭제
    public void clear() {
        while (headPointer != null) {
            removeFirst();
        }
        currentPointer = null;
    }

    // 선택 노드를 하나 뒤쪽으로 진행 (현재 노드를 가리키는 포인터를 뒤쪽으로 옮긴다.)
    public boolean next() {
        if (currentPointer == null || currentPointer.next == null) {
            return false;
        }
        currentPointer = currentPointer.next;
        return true;
    }

    // 선택 노드를 출력
    public void printCurrentNode() {
        if (currentPointer == null) {
            System.out.println("선택한 노드가 없습니다.");
        }else {
            System.out.println(currentPointer.data);
        }
    }

    // 모든 노드를 출력
    public void printAllNode() {
       Node<E> scanNode = headPointer;

       while (scanNode != null) {
        System.out.println(scanNode.data);
        scanNode = scanNode.next;
       }
    }
}
