package se;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 테트로미노2_14660_tmp {
	static class point{
		int i, j, val;

		public point(int i, int j, int val) {
			super();
			this.i = i;
			this.j = j;
			this.val = val;
		}
	}
	
	//32, 4, 2
	static int[][][] shape = {
			{{0, 0}, {0, 1}, {0, 2}, {0, 3}},
			{{0, 0}, {0, -1}, {0, -2}, {0, -3}},
			{{0, 0}, {1, 0}, {2, 0}, {3, 0}},
			{{0, 0}, {-1, 0}, {-2, 0}, {-3, 0}},
			
			{{0, 0}, {1, 0}, {0, 1}, {1, 1}},
			{{0, 0}, {-1, 0}, {0, 1}, {-1, 1}},
			{{0, 0}, {1, 0}, {0, -1}, {1, -1}},
			{{0, 0}, {-1, 0}, {0, -1}, {-1, -1}},
			
			{{0, 0}, {1, 0}, {1, 1}, {2, 1}},
			{{0, 0}, {1, 0}, {1, -1}, {2, -1}},
			{{0, 0}, {0, 1}, {1, 1}, {1, 2}},
			{{0, 0}, {0, 1}, {-1, 1}, {-1, 2}},
			{{0, 0}, {-1, 0}, {-1, 1}, {-2, 1}},
			{{0, 0}, {-1, 0}, {-1, -1}, {-2, -1}},
			{{0, 0}, {0, -1}, {1, -1}, {1, -2}},
			{{0, 0}, {0, -1}, {-1, -1}, {-1, -2}},
			//
			{{0, 0}, {1, 0}, {1, -1}, {1, -2}},
			{{0, 0}, {1, 0}, {1, 1}, {1, 2}},
			{{0, 0}, {-1, 0}, {-1, 1}, {-1, 2}},
			{{0, 0}, {-1, 0}, {-1, -1}, {-1, -2}},
			{{0, 0}, {0, 1}, {1, 1}, {2, 1}},
			{{0, 0}, {0, -1}, {-1, -1}, {-2, -1}},
			{{0, 0}, {0, 1}, {-1, 1}, {-2, 1}},
			{{0, 0}, {0, -1}, {1, -1}, {2, -1}},

			{{0, 0}, {0, -1}, {0, -2}, {1, -2}},
			{{0, 0}, {0, -1}, {0, -2}, {-1, -2}},
			{{0, 0}, {0, 1}, {0, 2}, {-1, 2}},
			{{0, 0}, {0, 1}, {0, 2}, {1, 2}},
			{{0, 0}, {1, 0}, {2, 0}, {2, 1}},
			{{0, 0}, {1, 0}, {2, 0}, {2, -1}},
			{{0, 0}, {-1, 0}, {-2, 0}, {-2, -1}},
			{{0, 0}, {-1, 0}, {-2, 0}, {-2, 1}},
			
			//
			{{0, 0}, {0, 1}, {-1, 1}, {0, 2}},
			{{0, 0}, {0, 1}, {1, 1}, {0, 2}},
			{{0, 0}, {1, 0}, {1, 1}, {2, 0}},
			{{0, 0}, {1, 0}, {1, -1}, {2, 0}},
			{{0, 0}, {0, -1}, {-1, -1}, {0, -2}},
			{{0, 0}, {0, -1}, {1, -1}, {0, -2}},
			{{0, 0}, {-1, 0}, {-1, 1}, {-2, 0}},
			{{0, 0}, {-1, 0}, {-1, -1}, {-2, 0}}
	};
	
	static int n, m;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		int max1 = 0;
		int max2 = 0;
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				max1 = 0;
				for(int t=0; t<shape.length; t++) {
					int tmp = 0;
					boolean flag = false;
					ArrayList<point> arr = new ArrayList<>();
					for(int d=0; d<4; d++) {
						int ci=i+shape[t][d][0];
						int cj=j+shape[t][d][1];
						if(ci>=0 && ci<n && cj>=0 && cj<m) {
							tmp += map[ci][cj];
							arr.add(new point(ci, cj, map[ci][cj]));
							if(d==3) {
								if(tmp>max2) {
									flag = true;
									for (point point : arr) {
										map[point.i][point.j] = 0;
									}
								}
								
							}
						}
						else break;
					}
					if(flag) {
						//
						for(int ii=0; ii<n; ii++) {
							for(int jj=0; jj<m; jj++) {
								for(int tt=0; tt<shape.length; tt++) {
									int tmp2 = 0;
									for(int dd=0; dd<4; dd++) {
										int cii=ii+shape[tt][dd][0];
										int cjj=jj+shape[tt][dd][1];
										if(cii>=0 && cii<n && cjj>=0 && cjj<m) {
											tmp2 += map[cii][cjj];
											if(dd==3) {
												if(max<tmp+tmp2) {
													cnt++;
//													System.out.println(cnt+" :" +tmp+" "+tmp2+" "+i+" "+j+" "+ii+" "+jj+" "+max2);
//													max1 = Math.max(tmp, tmp2);
													max1 = tmp;
													max = tmp+tmp2;
												}
//													
											}
										}
										else break;
									}
								}
							}
						}
						//
						for (point point : arr) {
							map[point.i][point.j] = point.val;
						}
					}
				}
				max2 = Math.max(max2, max1);
			}
		}
		System.out.println(max);
		
	}
}
