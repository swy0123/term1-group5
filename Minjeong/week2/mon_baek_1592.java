import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n, m, l;
        n = sc.nextInt();
        m = sc.nextInt();
        l = sc.nextInt();
        int[] participants = new int[n + 1];

        participants[1] = 1;
        int maxCnt = participants[1], totalCnt = 0, now = 1;
        while(maxCnt != m) {
            now = nextReceiver(participants, now, l);
            participants[now] += 1;
            maxCnt = Math.max(maxCnt, participants[now]);
            totalCnt++;
        }
        System.out.println(totalCnt);
    }

    private static int nextReceiver(int[] participants, int now, int l) {
        int n = participants.length - 1;
        if (participants[now] % 2 == 1) now += l;
        else now -= l;
        if (now < 1) now += n;
        else if (now > n) now -= n;
        return now;
    }
}
