import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Egg {

    public int durability;
    public int weight;

    public Egg(int durability, int weight) {
        super();
        this.durability = durability;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Egg [durability=" + durability + ", weight=" + weight + "]";
    }
}

public class mon_beak_16987 {

    private static int maxNumber = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Egg[] eggs = new Egg[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        dfs(0, eggs);
        System.out.println(maxNumber);
    }

    private static void dfs(int leftEggIndex, Egg[] eggs) {
        // 정상종료
        if (leftEggIndex == eggs.length) {
            countBrokenEggs(eggs);
            return;
        }

        // 비정상 종료
        if (eggs[leftEggIndex].durability <= 0) {
            dfs(leftEggIndex + 1, eggs);
            return;
        }

        boolean flag = false;
        for (int rightEggIndex = 0; rightEggIndex < eggs.length; rightEggIndex++) {
            if (rightEggIndex == leftEggIndex) {
                continue;
            }
            if (eggs[rightEggIndex].durability <= 0) {
                continue;
            }
            flag = true;
            eggs[leftEggIndex].durability -= eggs[rightEggIndex].weight;
            eggs[rightEggIndex].durability -= eggs[leftEggIndex].weight;
            dfs(leftEggIndex + 1, eggs);
            eggs[leftEggIndex].durability += eggs[rightEggIndex].weight;
            eggs[rightEggIndex].durability += eggs[leftEggIndex].weight;
        }
        if (!flag) {
            countBrokenEggs(eggs);
            return;
        }
    }

    private static void countBrokenEggs(Egg[] eggs) {
        int count = 0;
        for (int i = 0; i < eggs.length; i++) {
            if (eggs[i].durability <= 0) {
                count++;
            }
        }
        maxNumber = Math.max(count, maxNumber);
    }
}
