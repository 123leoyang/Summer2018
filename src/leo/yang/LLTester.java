package leo.yang;

import java.util.Scanner;

public class LLTester {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = "";
		System.out.println("Welome to Linked List Tester");
		LinkedLists<Integer> x = new LinkedLists<Integer>();
		while (!input.equalsIgnoreCase("q")) {
			System.out.println("What Would you like to do? a = add, d = delete, g = get size, dis = display");
			String action = in.nextLine();
			if (action.equalsIgnoreCase("a")) {
				System.out.println("What would you like to add?");
				int num = in.nextInt();
				System.out.println("Where would you like to add it? (hit enter to add at end)");
				String next = in.nextLine();
				if (next.equalsIgnoreCase("")) {
					x.add(num);
				} else {
					x.add(num, Integer.parseInt(next));
				}
			} else if (action.equalsIgnoreCase("d")){
				System.out.println("What index would you like to delete? (hit enter to delete the end)");
				String next = in.nextLine();
				if (next.equalsIgnoreCase("")) {
					x.remove();
				} else {
					x.remove(Integer.parseInt(next));
				}
			} else if (action.equalsIgnoreCase("g")) {
				System.out.print(x.getSize());
			} else if (action.equalsIgnoreCase("dis")) {
				System.out.print(x.get(0));
				boolean check = true;
				for(int i = 1; i < x.getSize() && check; i++) {
					if (x.node(i) == null) {
						check = false;
					} else {
						System.out.print(", " + x.get(i));
					}
				}
			}
			System.out.println("\nDo you want to quit? (q to quit, anything else to continue)");
			input = in.nextLine();
		}
	}

}
