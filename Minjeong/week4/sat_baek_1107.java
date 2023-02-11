import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, res = Integer.MAX_VALUE;
    static boolean[] buttons = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        if (m != 0) st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            buttons[tmp] = true;    // true이면 버튼 고장
        }

        res = Math.abs(n - 100);
        find(0, 0);
        System.out.println(res);
    }

    private static void find(int channel, int pressed) {
        if (!(channel == 0 && pressed == 0) && channel == n) {
            res = Math.min(pressed, res);
            return;
        }
        if (channel > 1000000) return;

        for (int i = 0; i < 10; i++) {
            if (channel == 0 && i == 0 && pressed >= 1) continue;
            if (!buttons[i]) find(channel * 10 + i, pressed + 1);
        }
        if (!(channel == 0 && pressed == 0)) find(n, pressed + Math.abs(n - channel));
    }
}

