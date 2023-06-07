import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] dogA = new boolean[1000];
    static boolean[] dogB = new boolean[1000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());

        int cnt = 1;
        dogA[0] = dogB[0] = true;
        while (cnt < 1000 - a) {
            for(int i = cnt; i < cnt + a; i++) dogA[i] = true;
            cnt += (a + b);
        }
        cnt = 1;
        while (cnt < 1000 - c) {
            for(int i = cnt; i < cnt + c; i++) dogB[i] = true;
            cnt += (c + d);
        }

        for (int i = 0; i < 3; i++) {
            if (dogA[arr[i]] && dogB[arr[i]]) System.out.println(2);
            else if(!dogA[arr[i]] && !dogB[arr[i]]) System.out.println(0);
            else System.out.println(1);
        }
    }
}
