import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// z
public class mon_beak_1074 {

    private static int count = 0;
    private static int r;
    private static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, n);

        search(size, 0, 0);
    }

    private static void search(int size, int x, int y) {
        if (size == 2) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (y + i == r && x + j == c) {
                        System.out.println(count);
                        System.exit(0);
                    }
                    count++;
                }
            }
            return;
        }

        int newSize = size / 2;
        if (r < y + newSize && c < x + newSize) {
            search(newSize, x, y);
        }
        count += newSize * newSize;
        if (r < y + newSize && c >= x + newSize) {
            search(newSize, x + newSize, y);
        }
        count += newSize * newSize;
        if (r >= y + newSize && c < x + newSize) {
            search(newSize, x, y + newSize);
        }
        count += newSize * newSize;
        if (r >= y + newSize && c >= x + newSize) {
            search(newSize, x + newSize, y + newSize);
        }
    }
}
