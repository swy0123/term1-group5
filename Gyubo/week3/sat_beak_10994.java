import java.util.Arrays;
import java.util.Scanner;

public class sat_beak_10994 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size = n * 4 - 3;
        char[][] table = new char[size][size];

        for (char[] chars : table) {
            Arrays.fill(chars, ' ');
        }

        for (int i = n; i >0; i --){
            markStar(n, i, table);
        }

        for (char[] chars : table) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static void markStar(int maxSize, int currentSize, char[][] table) {
        int startIndex = (maxSize - currentSize) * 2;
        int endIndex = table.length - startIndex - 1;

        for (int i = startIndex; i <= endIndex; i++){
            table[startIndex][i] = '*';
            table[endIndex][i] = '*';
            table[i][startIndex] = '*';
            table[i][endIndex] = '*';
        }
    }
}
