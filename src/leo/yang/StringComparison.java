package leo.yang;

public class StringComparison {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "flibbity jibbit";
	//	String b = "flibbity ";
		String b = "flibbity jibbit";
	//	b+="jibbit";
		System.out.println(b);
		if(a == b) {
			System.out.println("a == b");
		}
		if(a.equals(b)) {
			System.out.println("a.equals(b)");
		}

	}

}
