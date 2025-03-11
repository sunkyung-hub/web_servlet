package exam;

import java.util.ArrayList;
import java.util.Arrays;

public class exam8 extends ex8_box {
	@Override
	public void even() { //짝수
		ArrayList<Integer> number = new ArrayList<Integer>(Arrays.asList(this.data));
		int w = 0;
		while(w<number.size()) { //모든 자료가 지워지고(배열 초기화), 계속 반복하면서 짝수 확인
			if(number.get(w) % 2 == 1) { //홀수값 조건은 배열에서 삭제 
				number.remove(w); 
				//remove시 index, 즉 node 번호가 바뀜 
				w=0; //0 사용은 배열에 값이 삭제되면, 노드 변화로 처음부터 다시 검토하도록 함
			}
			else { //해당 조건(홀수)가 아니면 +1 증가시켜서 배열을 검토하는 형태
				w++; // 증감 후 다시 반복
			}
		}
		System.out.println("짝수: " + number);
	}
	
	@Override
	public void odd() { //홀수
		ArrayList<Integer> number2 = new ArrayList<Integer>(Arrays.asList(this.data));
		int w = 0;
		while(w<number2.size()) {
			if(number2.get(w) % 2 ==0) { //홀수값 조건은 배열에서 삭제 
				number2.remove(w); 
			}
			w++;
		}
		System.out.println("홀수: " + number2);
	}
	
	public static void main(String[] args) {
		new exam8().even(); 
		new exam8().odd();
	}

}

abstract class ex8_box{
	Integer data[] = {3, 5, 2, 1, 6, 7, 8, 9, 10, 4};
	
//	public void sum() { //자료형도 쓰지 않고 this.data 형식으로 쓰는건 x
//	}
	
	abstract public void even();
	abstract public void odd();
	
	
		
	
	
}