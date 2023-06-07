import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int testCase = 1; testCase <= 10; testCase++) {
            int n = sc.nextInt();
            String str = sc.next();

            boolean flag = true;
            while (flag) {
                for (int i = 0; i < str.length() - 1; i++) {
                    if (str.charAt(i) == str.charAt(i + 1)) {
                        String pattern = str.substring(i, i + 2);
                        str = str.replace(pattern, "");
                        break;
                    }
                    if (i == str.length() - 2) flag = false;
                }
            }

            System.out.println("#" + testCase + " " + str);
        }
    }
}