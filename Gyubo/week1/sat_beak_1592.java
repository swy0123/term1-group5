import java.util.Scanner;

public class sat_beak_1592 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();

        /**
         * 입력받은만큼 공던진 횟수를 배열을 생성
         * l에 도달할때까지 무한반복
         * 현재위치 확인
         *  다음 탐색 위치 계산
         *
         */

        int[] arr = new int[n];
        int index = 0;
        int negative;
        int count = -1;

        while (true) {
            arr[index] += 1;
            count++;

            if (arr[index] == m) {
                break;
            }

            if (arr[index] % 2 == 1) {
                negative = 1;
            } else {
                negative = -1;
            }

            // 다음 위치 계산
            index = (index + l * negative) % n;

            if (index < 0) {
                index = n + index;
            }
        }
        System.out.println(count);
    }
}
