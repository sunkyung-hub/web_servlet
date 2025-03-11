package exam;

import java.util.Scanner;

public class exam6 {

	public static void main(String[] args) {
		String user[][] = { 
				{"마동석", "01053514423"},
				{"김무열", "01023103637"},
				{"박지환", "01069882901"},
				{"마동석", "01008081010"}   

		};
			
		Scanner sc = new Scanner(System.in);
		System.out.println("고객명을 입력하세요: ");
//		String name = sc.nextLine();
		String name = sc.nextLine().replaceAll(" ", ""); //이름을 한 칸 띄우고 검색해도 원래 단어로 검색되도록
		System.out.println(name);
		
		int w = 0; 
		while(w<user.length) {
			if(name.equals(user[w][0])) {
				System.out.println(user[w][0] + "님 연락처" + user[w][1] + "입니다.");
			}
			w++;
		}
		
		sc.close();
		
	}

}
