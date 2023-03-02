package week4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * swea 5656. [모의 SW 역량테스트] 벽돌 깨기
 */
public class thu_swea_5656 {
    
    static class point{
        int i, j, cnt;

        public point(int i, int j, int cnt) {
            super();
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }
    }

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    
    static int n, w, h, min;
    static int[][] map;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            
            map = new int[h][w];
            
            for(int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            min = Integer.MAX_VALUE;
            perm(0, new int[n]);
            System.out.println("#"+test_case+" "+ min);
        }
    }
    
    private static void perm(int idx, int[] v) {
    	if(idx == n) {
    		int[][] tmp = new int[h][w];
    		for(int i=0; i<h; i++) {
    			tmp[i] = map[i].clone();
    		}
    		
    		for(int i=0; i<v.length; i++) {
    			bfs(v[i]);

    		}
    		int sum = 0;
    		for (int[] i : map) {
				for (int j : i) {
					if(j != 0) sum++;
				}
			}
//    		min = Math.min(min, sum);
    		if(min > sum) {
    			min = sum;
//    			for (int[] is : map) {
//    				System.out.println(Arrays.toString(is));
//    			}System.out.println(sum);
    		}

    		for(int i=0; i<h; i++) {
    			map[i] = tmp[i].clone();
    		}
    		return;
    	}
    	
    	for(int i=0; i<w; i++) {
    		v[idx] = i;
    		perm(idx+1, v);
    	}
    	
    }
    
    private static boolean bfs(int num) {
    	int tmpi=-1;
    	for(int i=0; i<h; i++) {
    		if(map[i][num]!=0) {
    			tmpi = i;
    			break;
    		}
    	}
    	if(tmpi==-1) return false;
    	
    	Queue<point> q = new LinkedList<>();
    	q.add(new point(tmpi, num, map[tmpi][num]));
    	map[tmpi][num] = 0;
    	
    	while(!q.isEmpty()) {
    		point p = q.poll();
    		
    		for(int d=0; d<4; d++) {
    			int ci, cj;
    			for(int l=1; l<p.cnt; l++) {
    				ci = p.i+di[d]*l;
    				cj = p.j+dj[d]*l;
    				if(ci>=0 && ci<h && cj>=0 && cj<w && map[ci][cj]!=0) {
    					q.add(new point(ci, cj, map[ci][cj]));
    					map[ci][cj] = 0;
    				}
    			}
    		}
    	}
    	down();
    	
    	return true;
    }
    
    private static void down() {
    	for(int j=0; j<w; j++) {
    		for(int i=h-1; i>=0; i--) {
    			if(map[i][j] == 0) {
    				for(int k=i-1; k>=0; k--) {
    					if(map[k][j]!=0) {
    						map[i][j] = map[k][j];
        					map[k][j] = 0;
        					break;
    					}
    				}
    			}
    		}
    	}
    }
}