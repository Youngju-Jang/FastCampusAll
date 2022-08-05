package p2_ch5;

public class l06_generic<T> {
	// https://gitlab.com/easyspubjava/javacoursework/-/tree/master/Chapter5/5-03
	
	/* 05.LinkedList
	 * 동일한 데이터 타입을 순서에 따라 관리하는 자료 구조 
	 * 자료를 저장하는 노드에는 자료와 다음 요소를 가리키는 링크(포인터)가 있음
	 * 자료가 추가 될때 노드 만큼의 메모리를 할당 받고 이전 노드의 링크로 연결함 (정해진 크기가 없음)
	 * 연결 리스트의 i 번째 요소를 찾는게 걸리는 시간은 요소의 개수에 비례 : O(n)
	 * jdk 클래스 : LinkedList
	 */

	// 06. 무엇이든 담을 수 있는 제네릭(Generic) 프로그래밍
	// 다양한 자료형이 적용될 수 있음
	
	// https://gitlab.com/easyspubjava/javacoursework/-/tree/master/Chapter5/5-07
	// 07. <T extends 클래스> 사용하기
	// public class GenericPrinter<T extends Material> {...}
	// 자료형 매개변수를 메서드의 매개변수나 반환 값으로 가지는 메서드는 자료형 매개 변수가 하나 이상인 경우도 있음
	// 제네릭 클래스가 아니어도 내부에 제네릭 메서드는 구현하여 사용 할 수 있음
	// public <자료형 매개 변수> 반환형 메서드 이름(자료형 매개변수.....) { }
	// public class Point<T, V> {...
	// public static <T, V> double makeRectangle(Point<T, V> p1, Point<T, V> p2) {..
	
	
	private T material;
	
	public void setMaterial(T material) {
		this.material = material;
	}
	
	public T getMaterial() {
		return material;
	}
	
	public String toString(){
		return material.toString();
	}



}
