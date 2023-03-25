package algorithm.week3.fri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 백준 22944 죽음의 비
 */
public class fri_baek_22944 {
    
    static class point{
        int i, j, life, armor, num, cnt;

        public point(int i, int j, int life, int armor, int num, int cnt) {
            super();
            this.i = i;
            this.j = j;
            this.life = life;
            this.armor = armor;
            this.num = num;
            this.cnt = cnt;
        }
        
    }
    
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    static int n, h, d, min;
    static char[][] map;
    static boolean[][][] v;
    static boolean[][] used;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new char[n][n];
        min = -1;
        int si=-1, sj=-1;
        int ucnt = 0;
        
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<n; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'S') {
                    si = i;
                    sj = j;
                }
                if(map[i][j] == 'U') {
                    ucnt++;
                }
            }
        }
        v = new boolean[n][n][ucnt+1];
        used = new boolean[n][n];
        bfs(si, sj);
        System.out.println(min);
        
    }
    
    //i, j, life, armor, num, cnt
    private static void bfs(int si, int sj) {
        Queue<point> q = new LinkedList<>();
        q.add(new point(si, sj, h, 0, 0, 0));
        v[si][sj][0] = true;
        
        A: while(!q.isEmpty()) {
        	
        	
            point p = q.poll();
//            for (boolean[][] v1 : v) {
//            	for (boolean[] v2 : v1) {
//            		System.out.print(Arrays.toString(v2));
//				}
//            	System.out.println();
//			}System.out.println(p.life +" " + p.armor+" "+p.cnt);
            
            if(p.life==0) continue;
            
            L : for(int dr=0; dr<4; dr++) {
                int ci = p.i+di[dr];
                int cj = p.j+dj[dr];
                if(ci>=0 && ci<n && cj>=0 && cj<n) {
                    if(v[ci][cj][p.num]) continue L;
                    if(map[ci][cj] == 'U') {
                    	if(!used[ci][cj]) {
                    		q.add(new point(ci, cj, p.life, d-1, p.num+1, p.cnt+1));
                            v[ci][cj][p.num+1] = true;
                            used[ci][cj] = true;
                    	}
                    }
                    else {
                        if(map[ci][cj]!='E') {
                            if(p.armor>0) {
                            	q.add(new point(ci, cj, p.life, p.armor-1, p.num, p.cnt+1));
                            	v[ci][cj][p.num] = true;
                            }
                            else {
                                if(p.life>1) {
                                	q.add(new point(ci, cj, p.life-1, p.armor, p.num, p.cnt+1));
                                	v[ci][cj][p.num] = true;
                                }
                                else continue L;
                            }
                        }
                        else {
                            min = p.cnt+1;
                            break A;
                        }
                       
                    }
                    
                }
            }
            
        }
        
    }

}