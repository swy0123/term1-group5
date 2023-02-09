import java.util.Scanner;

public class thu_beak_2661 {

    private static boolean endFlag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dfs(0, n, "");
    }

    private static void dfs(int depth, int targetDepth, String value) {
        // 종료 플레그가 있다면 종료
        if (endFlag) {
            return;
        }

        // 중복된 부분이 존재하는지 확인
        // 중복된 부분이 존재하면 return;
        if (depth != 0) {
            for (int i = 1; i <= value.length() / 2; i++) {
                String sub1 = value.substring(value.length() - i);
                String sub2 = value.substring(value.length() - i * 2, value.length() - i);
                if (sub1.equals(sub2)) {
                    return;
                }
            }
        }

        // 길이가 n과 같다면 종료
        if (depth == targetDepth) {
            System.out.println(value);
            endFlag = true;
            return;
        }

        // 반복
        for (int i = 1; i < 4; i++) {
            dfs(depth + 1, targetDepth, value + i);
        }
    }
}
