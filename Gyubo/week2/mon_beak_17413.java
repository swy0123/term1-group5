import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class mon_beak_17413 {

    public static void main(String[] args) throws IOException {
        /**
         * 1. 입력 리스트로 나누기
         * 2. tag가 아닌값 split
         * 3. split된값 역순 정렬
         * 4. 정렬된값으로 리스트 변경
         * 5. 이어붙이기
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        List<String> answerList = new ArrayList<>();
        StringBuilder tmpStr = new StringBuilder();

        // 모든 입력값 태그값으로 split
        for (char c : input.toCharArray()) {
            if (c == '<') {
                if (tmpStr.length() > 0) {
                    answerList.add(tmpStr.toString());
                    tmpStr.setLength(0);
                }
            } else if (c == '>') {
                tmpStr.append(c);
                answerList.add(tmpStr.toString());
                tmpStr.setLength(0);
                continue;
            }
            tmpStr.append(c);
        }
        if (tmpStr.length() > 1) {
            answerList.add(tmpStr.toString());
        }

        // split한 값중 태그가 아닌값에 대하여 재정렬 실행
        StringBuilder answer = new StringBuilder();
        for (String s : answerList) {
            if (s.charAt(0) == '<') {
                answer.append(s);
                continue;
            }

            // 띄어쓰기 분리
            String[] splitString = s.split(" ");
            for (int i = 0; i < splitString.length; i++) {
                StringBuilder ns = new StringBuilder(splitString[i]).reverse();
                if (i == splitString.length - 1) {
                    answer.append(ns.toString());
                    continue;
                }
                ns.append(" ");
                answer.append(ns.toString());
            }
        }
        System.out.println(answer);
    }
}
