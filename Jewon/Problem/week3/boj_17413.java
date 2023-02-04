package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_17413 {
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder(br.readLine());
		StringBuilder buf = new StringBuilder();
		
		for (int i = 0; i < sb.length(); i++) {
			switch (sb.charAt(i)) {
			case '<':
				swap(buf);
				buf.setLength(0);
				buf.append(sb.charAt(i));
				break;
			case '>':
				buf.append(sb.charAt(i));
				System.out.print(buf);
				buf.setLength(0);
				break;
			case ' ':
				if(buf.toString().contains("<")) {
					buf.append(sb.charAt(i));
				}else {					
					swap(buf);
					System.out.print(sb.charAt(i));
					buf.setLength(0);
				}
				break;

			default:
				buf.append(sb.charAt(i));
				if(i == sb.length()-1) {
					swap(buf);
				}
				break;
			}
			
		}
		// 한문자씩 확인하고 버퍼에 집어 넣는다.
		// <을 만나면 지금까지 버퍼를 스왑후 출력함
		// >를 만나면 지금까지 버퍼를 출력함
		// ' '을 만나면 지금까지 버퍼를 스왑후 출력함
	}
	
	private static void swap(StringBuilder buf) {
		for(int i = buf.length()-1; i>= 0 ; i--) {
			System.out.print(buf.charAt(i));
		}
	}

}
