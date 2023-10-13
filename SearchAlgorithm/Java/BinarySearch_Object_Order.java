// 순서정렬 : 컴퓨터에서 정의하는 정렬방식
package Java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BinarySearch_Object_Order {

    static class personData {
        private String name; 
        private int height;
        private double vision;

        public personData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        @Override
        public String toString() {
            return name + " " + height + " " + vision;
        }

        // 키에 대해서 오름차순으로 정렬하기 위한 comparator
        public static final Comparator<personData> HEIGHT_ORDER = new HeightOrderComparator(); 

        private static class HeightOrderComparator implements Comparator<personData> {

            public int compare(personData pd1, personData pd2) {
                return (pd1.height > pd2.height) ? 1 :
                        (pd1.height < pd2.height) ? -1 : 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        personData[] persondata = 
        {new personData("허지은", 165, 1.1),
        new personData("홍세현", 166, 1.4),
        new personData("박수현", 168, 1.9),
        new personData("이예진", 169, 1.3), 
        new personData("이수호", 175, 1.5),
        new personData("하성진", 184, 2.0)
        };

        System.out.println("키가 몇 cm인 사람을 찾고 있나요?");
        int height = sc.nextInt();
        int index = Arrays.binarySearch(persondata, new personData("", height, 0.0), personData.HEIGHT_ORDER);

        if(index < 0) {
            System.out.println("값이 존재하지 않습니다.");
        }else{
            System.out.println("값이 " + index + "번 index에 존재합니다.");
            System.out.println("찾은 데이터: " + persondata[index]);
        }
    }
}
