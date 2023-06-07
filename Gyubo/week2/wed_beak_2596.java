import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class wed_beak_2596 {

    private static String[] codes = {
            "000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010"};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String input = sc.next();

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.substring(6 * i, 6 + 6 * i);
        }

        StringBuilder sb = new StringBuilder();
        for (int strIndex = 0; strIndex < n; strIndex++) {
            List<Integer> countList = new ArrayList<>();
            boolean flag = false;
            for (int codeIndex = 0; codeIndex < codes.length; codeIndex++) {
                int count = 0;
                for (int i = 0; i < 6; i++) {
                    if (arr[strIndex].charAt(i) != codes[codeIndex].charAt(i)) {
                        count++;
                    }
                }
                if (count == 0) {
                    sb.append((char) (codeIndex + 'A'));
                    flag = true;
                    break;
                }
                countList.add(count);
            }

            if (!flag) {
                int min = Collections.min(countList);
                if (min == 1) {
                    for (int i = 0; i < codes.length; i++) {
                        if (countList.get(i) == min) {
                            sb.append((char) (i + 'A'));
                            break;
                        }
                    }
                }
                else{
                    System.out.println(strIndex + 1);
                    return;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
