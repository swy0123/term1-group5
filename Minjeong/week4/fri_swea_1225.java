package ssafy.day01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int testCase = 1; testCase <= 10; testCase++) {
        	Queue<Integer> q = new LinkedList<>();
        	int T = Integer.parseInt(br.readLine());
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
        	
        	int cycle = 1;
        	while(q.peek() - cycle > 0) {
        		q.offer(q.poll() - cycle++);
        		if (cycle == 6) cycle = 1;
        	}
        	q.poll();
        	q.offer(0);
        	
            System.out.print("#" + testCase + " ");
            while (!q.isEmpty()) System.out.print(q.poll() + " ");
            System.out.println();
        }
    }
}
