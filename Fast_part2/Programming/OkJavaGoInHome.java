import org.opentutorials.iot.Elevator;
import org.opentutorials.iot.Lighting;
import org.opentutorials.iot.Security;

public class OkJavaGoInHome {

	public static void main(String[] args) {
		
		String id = "JAVA APT 507";
		
		// TODO Auto-generated method stub
		// Elevator call
		Elevator myElevator = new Elevator(id);
		myElevator.callForUp(1);
		
		// Security off
		Security mySecurity = new Security(id);
		mySecurity.off();
				
		// Light on 
		Lighting hallLamp = new Lighting(id+" / Hall Lamp");
		hallLamp.on();
		
		Lighting floorLamp = new Lighting(id+" / Floor Lamp");
		floorLamp.on();
		
		// org패키지를 신규 lib패키지밑으로 넣었을 경우
		// cmd로 실행 >> javac -cp ".;lib" OkJavaGoInHome.java
		// javac -cp ".;Programming/" Programming/OkJavaGoInHomeInput.java >> 이리하니 오류가안뜸
		// java class못찾는 오류 : %JAVA_HOME%\lib;.  << ;. 추가하기

	}

}
