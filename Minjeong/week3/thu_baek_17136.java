import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] leftCnt = { 5, 5, 5, 5, 5 };
    static int[][] board;
    static int res = 0, real = 987654321;
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[10][10];
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        find();
        if (!flag) System.out.println(-1);
        else System.out.println(real);
    }

    private static void find() {
        if (isAllFilled()) {
            real = Math.min(real, res);
            flag = true;
            return;
        }

        for (int i = 5; i >= 1; i--) {
            Pair p = canPatch(i);
            if (p != null) {
                leftCnt[i - 1] -= 1;
                fill(i, i + 1, p);
                find();
                leftCnt[i - 1] += 1;
                fill(i, 1, p);
            }
        }
    }

    private static Pair canPatch(int w) {
        if (leftCnt[w - 1] == 0) return null;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 1)  {
                    for (int k = i; k < i + w; k++) {
                        for (int l = j; l < j + w; l++) {
                            if (k < 0 || k >= 10 || l < 0 || l >= 10) return null;
                            if (board[k][l] != 1) return null;
                        }
                    }
                    return new Pair(i, j);
                }
            }
        }
        return null;
    }

    private static void fill(int w, int value, Pair p) {
        int x = p.x;
        int y = p.y;
        if (value == 1) res--;
        else res++;
        for (int i = x; i < x + w; i++) {
            for (int j = y; j < y + w; j++) {
                board[i][j] = value;
            }
        }
    }

    private static boolean isAllFilled() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 1)  {
                    return false;
                }
            }
        }
        return true;
    }
}
