import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class sat_swea_7272 {

    private static final Map<Character, Integer> map = new HashMap<>();

    public static void main(String args[]) throws Exception {
        map.put('A', 1);
        map.put('B', 2);
        map.put('D', 1);
        map.put('O', 1);
        map.put('P', 1);
        map.put('Q', 1);
        map.put('R', 1);

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            String str1 = sc.next();
            String str2 = sc.next();

            boolean flag = false;

            if (str1.length() != str2.length()) {
                System.out.println("#" + test_case + " " + "DIFF");
                continue;
            }

            for (int i = 0; i < str1.length(); i++) {
                char c1 = str1.charAt(i);
                char c2 = str2.charAt(i);

                int i1;
                int i2;
                i1 = map.getOrDefault(c1, 0);
                i2 = map.getOrDefault(c2, 0);

                if (i1 == i2) {
                    continue;
                }
                flag = true;
                break;
            }

            if (flag) {
                System.out.println("#" + test_case + " " + "DIFF");
                continue;
            }
            System.out.println("#" + test_case + " " + "SAME");
        }
    }
}