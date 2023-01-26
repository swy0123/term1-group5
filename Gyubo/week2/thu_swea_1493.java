import java.util.Scanner;

public class thu_swea_1493 {

    private static final int MAX_VALUE = 10000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        int[] arr = makeArr();

        for (int tc = 1; tc < testCase + 1; tc++) {
            int p = sc.nextInt();
            int q = sc.nextInt();

            int[] pCoord = makeCoord(p, arr);
            int[] qCoord = makeCoord(q, arr);
            int[] nCoord = {pCoord[0] + qCoord[0], pCoord[1] + qCoord[1]};

            int prevValue = arr[nCoord[0]];
            for (int y = 2; y < nCoord[1] + 1; y++) {
                int value = prevValue + y + nCoord[0] - 2;
                prevValue = value;
            }
            System.out.println("#" + tc + " " + prevValue);
        }
    }

    private static int[] makeCoord(int number, int[] arr) {
        // 1 열에 있는지 확인
        for (int x = 1; x < MAX_VALUE; x++) {
            if (number == arr[x]) {
                return new int[]{x, 1};
            } else if (arr[x] > number) {
                break;
            }
        }

        for (int x = 1; x < MAX_VALUE; x++) {
            if (arr[x] > number) {
                break;
            }
            int prevValue = arr[x];
            for (int y = 2; y < MAX_VALUE; y++) {
                int value = y - 2 + prevValue + x;
                prevValue = value;
                if (value == number) {
                    return new int[]{x, y};
                } else if (value > number) {
                    break;
                }
            }
        }
        return null;
    }

    private static int[] makeArr() {
        int[] arr = new int[MAX_VALUE + 1];
        for (int i = 1; i < MAX_VALUE + 1; i++) {
            arr[i] = i + arr[i - 1];
        }
        return arr;
    }
}