import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 거짓말
public class mon_beak_1043 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int trueNumber = Integer.parseInt(st.nextToken());

        int[] parents = new int[n + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        boolean[] truthTable = new boolean[51];
        for (int i = 0; i < trueNumber; i++) {
            truthTable[Integer.parseInt(st.nextToken())] = true;
        }

        List<List<Integer>> partyList = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < m; i++) {
            List<Integer> tmpList = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int partyNumber = Integer.parseInt(st.nextToken());
            int prevNumber = Integer.parseInt(st.nextToken());
            tmpList.add(prevNumber);

            for (int j = 1; j < partyNumber; j++) {
                int currentNumber = Integer.parseInt(st.nextToken());
                tmpList.add(currentNumber);
                union(parents, prevNumber, currentNumber, truthTable);
                prevNumber = currentNumber;
            }

            partyList.add(tmpList);
        }

        for (List<Integer> integers : partyList) {
            boolean flag = false;
            for (Integer person : integers) {
                if (truthTable[findParent(parents, person)]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static void union(int[] parents, int prevNumber, int currentNumber, boolean[] truthTable) {
        int p1 = findParent(parents, prevNumber);
        int p2 = findParent(parents, currentNumber);

        if (truthTable[p1]) {
            parents[p2] = parents[p1];
            return;
        }
        if (truthTable[p2]) {
            parents[p1] = parents[p2];
            return;
        }
        parents[p1] = parents[p2];
    }

    private static int findParent(int[] parents, int number) {
        if (parents[number] == number) {
            return number;
        } else {
            return parents[number] = findParent(parents, parents[number]);
        }
    }
}
