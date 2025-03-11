package exam;

import java.util.Random;
import java.util.Scanner;

//Math.random()
//Random: PC가 자동으로 생성하는 원리 -> 기본 소수점으로 출력됨
public class exam1 {
	
	public static void main(String[] args) {
//		Math.ceil(Math.random()*99); //Math를 이용해 사용하는 방법
//		Random //Random 클래스를 이용해 사용하는 방법 
//		for(int i=0; i<5; i++) {
//			double rd = Math.random(); 
//			System.out.println(rd); //숫자가 랜덤으로 나옴
			
//			char word = (char)((rd * 26) + 97); //영어 소문자 a 시작번호 97, 소문자가 랜덤으로 나옴
//			char word = (char)((rd * 26) + 65); //영어 대문자 A 시작번호 65, 대문자가 랜덤으로 나옴
//			System.out.println(word);
			
			Random rand = new Random();
			Scanner sc = new Scanner(System.in);
			System.out.println("숫자 하나를 입력하세요: ");
			int no = sc.nextInt(); 
			for(int f=0; f<=no; f++) {
				int free = rand.nextInt(99);
				System.out.println(free);
			}
			
			sc.close();
		}
	}
