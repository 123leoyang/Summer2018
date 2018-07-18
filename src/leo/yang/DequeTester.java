package leo.yang;

import java.util.Scanner;

public class DequeTester {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = "";
		System.out.println("What size is your deque?");
		Deque x = new Deque(in.nextInt());
		while (!input.equalsIgnoreCase("q")) {
			System.out.println("What Would you like to do? af = add to front, ar = add to rear, pf = pop front, pr = pop rear");
			String temp = in.nextLine();
			if (temp.equalsIgnoreCase("af")) {
				System.out.println("What would you like to add?");
				x.addFront(in.nextInt());
			} else if (temp.equalsIgnoreCase("df")){
				int a = x.popFront();
				if(a == -1) {
					
				} else {
					System.out.println(a);
				}
			}
			if (temp.equalsIgnoreCase("ar")) {
				System.out.println("What would you like to add?");
				x.addRear(in.nextInt());
			} else if (temp.equalsIgnoreCase("dr")){
				int a = x.popRear();
				if(a == -1) {
					
				} else {
					System.out.println(a);
				}
			}
			System.out.println("Do you want to quit? (q to quit, anything else to continue)");
			input = in.nextLine();
		}
	}
}
