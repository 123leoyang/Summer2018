package leo.yang;

import java.util.Scanner;

public class HashMapTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String input = "";
		System.out.println("Welome to Hash Map Tester");
		System.out.println("What size is your HashMap?");
		int s = in.nextInt();
		HashMap<String, String> x = new HashMap<String, String>(s);
		while (!input.equalsIgnoreCase("q")) {
			System.out.println("What Would you like to do? a = add, d = delete, g = get size, r = return a value");
			String action = in.nextLine();
			if (action.equalsIgnoreCase("a")) {
				System.out.println("What is your Entry's key?");
				String key = in.nextLine();
				System.out.println("What is your Entry's value?");
				String str = in.nextLine();
				System.out.println("Key: ("+ key + ", " + str + ")");
				x.put(key, str);
			} else if (action.equalsIgnoreCase("d")){
				System.out.println("What key would you like to delete?");
				String key = in.nextLine();
				x.remove(key);
			} else if (action.equalsIgnoreCase("g")) {
				System.out.print(x.getSize());
			} else if (action.equalsIgnoreCase("r")) {
				System.out.println("What key you like to find?");
				String key = in.nextLine();
				System.out.println(x.get(key));
			}
			System.out.println("\nDo you want to quit? (q to quit, anything else to continue)");
			input = in.nextLine();
		}
	}

}
