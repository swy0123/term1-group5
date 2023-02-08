import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
 
public class Solution {
     static int[][] del = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
     static Map<Character, Character> m = new HashMap<>();
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        m.put('^', '0'); m.put('0', '^'); m.put('U', '0');
        m.put('v', '1'); m.put('1', 'v'); m.put('D', '1');
        m.put('<', '2'); m.put('2', '<'); m.put('L', '2');
        m.put('>', '3'); m.put('3', '>'); m.put('R', '3');
        
        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int trainX = 0, trainY = 0;
            char[][] map = new char[h][w];
            for (int i = 0; i < h; i++) {
            	String tmp = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = tmp.charAt(j);
					if (m.containsKey(map[i][j])) {
						trainX = i;
						trainY = j;
					}
				}
			}
            
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            
            for (int i = 0; i < n; i++) {
            	// 포탄 발사 명령어가 아닐 때
            	char command = input.charAt(i);
            	if (m.containsKey(command)) {
            		int head = m.get(command) - '0';
            		map[trainX][trainY] = m.get(m.get(command));
            		int nx = trainX + del[head][0];
            		int ny = trainY + del[head][1];
            		if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
            		if (map[nx][ny] == '.') {
            			map[nx][ny] = map[trainX][trainY];
            			map[trainX][trainY] = '.';
            			trainX = nx;
            			trainY = ny;
            		}
            	}
            	// 포탄 발사 명령어일 때
            	else {
            		int head = m.get(map[trainX][trainY]) - '0';
            		int nx = trainX;
            		int ny = trainY;
            		while(true) {
            			nx += del[head][0];
                		ny += del[head][1];
                		if (nx < 0 || nx >= h || ny < 0 || ny >= w) break;
                		if (map[nx][ny] == '*') {
                			map[nx][ny] = '.';
                			break;
                		}
                		else if (map[nx][ny] == '#') break;
            		}
            	}
            }
            
            // 출력
            System.out.print("#" + testCase + " ");
            for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
        }
    }
}


