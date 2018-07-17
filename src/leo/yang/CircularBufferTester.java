package leo.yang;

import java.util.Scanner;

public class CircularBufferTester {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = "";
		System.out.println("What size is your circular buffer?");
		CircularBuffer x = new CircularBuffer(in.nextInt());
		while (!input.equalsIgnoreCase("q")) {
			System.out.println("What Would you like to do? a = add, d = delete, g = get size, dis = display");
			String action = in.nextLine();
			if (action.equalsIgnoreCase("a")) {
				System.out.println("What would you like to add?");
				x.add(in.nextInt());
			} else if (action.equalsIgnoreCase("d")){
				int a = x.delete();
				if(a == -1) {
					
				} else {
					System.out.println(a);
				}
			} else if (action.equalsIgnoreCase("g")) {
				System.out.println(x.getSize());
			} else if (action.equalsIgnoreCase("dis")) {
				x.display();
			}
			System.out.println("Do you want to quit? (q to quit, anything else to continue)");
			input = in.nextLine();
		}
	}
}