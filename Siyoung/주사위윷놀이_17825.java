package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주사위윷놀이_17825 {
    static int[] blue = {5, 10 ,15};
    
    static ArrayList<Integer>[] board;
    static int[] num, pos, map;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        num = new int[10];
        for(int i=0; i<10; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        
        pos = new int[4];
        map = new int[33];
        
        board = new ArrayList[33];
        for(int i=0; i<33; i++) {
            board[i] = new ArrayList<>();
        }
        for(int i=0; i<20; i++) {
            board[i].add(i+1);
            map[i] = i*2;
        }
        map[20] = 40;
        board[5].add(21);
        map[21] = 13;
        board[21].add(22);
        map[22] = 16;
        board[22].add(23);
        map[23] = 19;
        board[23].add(24);
        map[24] = 25;
        
        board[10].add(25);
        map[25] = 22;
        board[25].add(26);
        map[26] = 24;
        board[26].add(24);
        
        board[15].add(27);
        map[27] = 28;
        board[27].add(28);
        map[28] = 27;
        board[28].add(29);
        map[29] = 26;
        board[29].add(24);
        
        board[24].add(30);
        map[30] = 30;
        board[30].add(31);
        map[31] = 35;
        board[31].add(20);
        board[20].add(32);
        map[32] = 0;
//        for (int i=0; i<33; i++) {
//			System.out.println(board[i] +" " + map[i]);
//		}
        solve(0, 0);
        System.out.println(max);
    }
    //파란 칸인지 확인
    private static boolean isBlue(int cp) {
    	for(int i=0; i<3; i++) {
    		if(cp==blue[i]) return true;
    	}
    	return false;
    }
    //다음 위치
    private static int nextPos(int cp, int cnt) {
    	if(isBlue(cp)) {
    		cp = board[cp].get(1);
    		cnt -= 1;
    	}
    	for(int i=0; i<cnt; i++) {
    		cp = board[cp].get(0);
    		if(cp == 32) break;
    	}
    	return cp;
    }
    //곂치는지 확인
    private static boolean isStack(int tmp, int np) {
    	for(int i=0; i<4; i++) {
    		if(tmp==i)continue;
    		if(pos[i] == 0 || pos[i] == 32) continue;
    		if(pos[i] == np) return true;
    	}
    	return false;
    }
    
    //백트래킹
    private static void solve(int idx, int score) {
    	if(idx == 10) {
    		max = Math.max(max, score);
//            System.out.println(Arrays.toString(pos) + score);
    		return;
    	}
    	
    	for(int k=0; k<4; k++) {
    		int tmp = pos[k];
    		if(tmp == 32) continue;
    		int np = nextPos(pos[k], num[idx]);
    		if(!isStack(k, np)) {
    			pos[k] = np;
    			solve(idx+1, score+map[np]);
    			pos[k] = tmp;
    		}
    	}
    	
    }

}