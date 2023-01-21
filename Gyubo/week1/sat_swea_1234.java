import java.util.Scanner;

class sat_swea_1234 {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            String numbers = sc.next();

            int i = 0;
            while (i < numbers.length() -1) {
                if (numbers.charAt(i) == numbers.charAt(i + 1)) {
                    numbers = numbers.substring(0, i) + numbers.substring(i + 2);
                    if (i > 0){
                        i--;
                    }
                    continue;
                }
                i++;
            }

            System.out.println("#" + test_case + " " + numbers);

        }
    }
}