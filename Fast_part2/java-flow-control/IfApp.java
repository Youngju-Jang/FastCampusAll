
public class IfApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String id = "egoing";
		String inputId = args[0];
		
		
		String pass = "1111";
		String inputPass = args[1];
		
		System.out.println();
		
		System.out.println("Hi.");
		
		//if(inputId == id ) {
//		if(inputId.equals(id)) {
//			if(inputPass.equals(pass)) {
//				System.out.println("Master!");
//			} else {
//				System.out.println("Wrong Passwoard!");
//			}
//		} else {
//			System.out.println("who are you?");
//		}
		
		if(inputId.equals(id) && inputPass.equals(pass)) {
				System.out.println("Master!");
		} else {
			System.out.println("who are you?");
		}
		
		String o1 = new String("java");
		String o2 = new String("java");
		// >> o1.equals(o2)
		
		String o3 = "java";
		String o4 = "java";
		// o3 == o4 °¡´É 
		System.out.println();
		
		
		
		

	}

}
