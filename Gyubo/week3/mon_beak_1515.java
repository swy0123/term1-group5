import java.util.Scanner;

public class mon_beak_1515 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.next().toCharArray();

        int index = 0;

        for (int i = 1; i < 30000; i++) {
            for (char c : Integer.toString(i).toCharArray()) {
                char currentChar = input[index];
                if (currentChar == c) {
                    index++;
                }
                if (index == input.length){
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}
