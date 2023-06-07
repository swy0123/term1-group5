import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Info {
    int dir;
    int len;

    public Info(int dir, int len) {
        this.dir = dir;
        this.len = len;
    }
}
public class Main {
    static int[] counts = new int[5];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Info[] list = new Info[6];
        int maxVal = 0, maxIdx = -1;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            counts[a] += 1;
            list[i] = new Info(a, b);
            if (b > maxVal) {
                maxIdx = i;
                maxVal = b;
            }
        }

        Info[] idxs = new Info[2];
        int t = 0;
        for (int i = 0; i < 6; i++) {
            Info info = list[i];
            if (counts[info.dir] == 1) idxs[t++] = info;
        }

        if (maxIdx == 5) {
            if (counts[list[0].dir] == 1) maxIdx = 0;
        }
        else {
            if (counts[list[maxIdx + 1].dir] == 1) maxIdx++;
        }
        int area = idxs[0].len * idxs[1].len;
        if (maxIdx == 5) area -= (list[1].len * list[2].len);
        else if (maxIdx == 4) area -= (list[0].len * list[1].len);
        else if (maxIdx == 3) area -= (list[0].len * list[5].len);
        else area -= (list[maxIdx + 2].len * list[maxIdx + 3].len);
        System.out.println(area * k);
    }
}