package SortingAlgorithm.Algorithm.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon24056 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        String[] A = bf.readLine().split(" ");
        String[] B = bf.readLine().split(" ");

        int[] arr = new int[n];
        int[] brr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(A[i]);
            brr[i] = Integer.parseInt(B[i]);
        }
        
        insertionSort(arr, brr);

    }

    public static void insertionSort(int[] arr, int[] brr) {
        int n = arr.length;
        for (int currentLocation = 1; currentLocation < n; currentLocation++) {

            int currentItem = arr[currentLocation]; // 현재위치에 있는 현재값

            int previousLocation = currentLocation - 1; // 이전 위치 == 현재 위치에서 한칸 앞으로 
            
            while (previousLocation >= 0 && currentItem < arr[previousLocation]) {
                arr[previousLocation + 1] = arr[previousLocation]; // 앞에 있는 숫자가 뒤에 오는 숫자보다 더 작을 때 삽입 >> 앞에 수가 크면 멈춤. 
                    // 현재값 위치                // 이전값

                previousLocation--; // -1 되면 반복문 멈춤 즉 커서위치가 맨앞으로 간다. 더이상 비교할 값이 존재하지 않음.
                // 이전 위치를 앞으로 이동 왜??
                // 현재값이 이전값과 비교했는데 더 이전 값중에 작은 값이 나올 때 까지 확인하기 위해서
            }

            if (previousLocation + 1 != currentLocation) {
                    // 이전 위치를 한칸 앞으로 이동했을 때 현재 위치면 
                arr[previousLocation + 1] = currentItem;
                    // 이전 값에 현재 값을 삽입한다. >> 적절한 위치를 찾음. 
            }

            // if문의 역할은 현재 값이 적절한 위치를 찾으면 값을 삽입하고 그렇지 않으면 이전 위치에 존재하는 값들 중에서 현재값보다
            // 큰 값이 존재하기 때문에 큰 값들보다 이전에 위치할 때까지 반복하게 해준다. 
            // 그러면 현재 위치 즉 타겟값이 자기 자리를 찾을 때 까지는 삽입하지 않는다. 

            // 해당 문제의 정답을 유추해보자면
            // 삽입정렬이 진행되는 과정은 무조건 가능
            // 삽입정렬이 필요한 배열에서 정렬이 필요한 요소들이 원래 위치해 있어야할 자리가 아닌 곳에 위치하면 무조건 false 즉 0을 출력한다.
            // 그럼? 요소가 본래의 위치가 아닌 경우는 어떻게 판단하는 가?

            // 반대로 생각해보자.
            // 더 빠른 삽입정렬을 이용해서 B 배열이 포함되면 
        }
    }
}
