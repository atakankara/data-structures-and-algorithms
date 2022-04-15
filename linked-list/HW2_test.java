import java.util.Scanner;


public class HW2_test {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		double coeff;
		int power;
		LinkedList.Node poly1 = null;
		LinkedList.Node poly2 = null;
		LinkedList.Node current = null;
		// reads tokens from the console and constructs a LinkedList from them
		while (scan.hasNextDouble()) {
			coeff = scan.nextDouble();
			power = scan.nextInt();
			if (poly1 == null) {
				poly1 = LinkedList.createNode(coeff, power);
				current = poly1;
			}
			else {
				current.next = LinkedList.createNode(coeff, power);;
				current = current.next;
			}
		}
		scan.next(); // gets rid of the "end" token in the end of each list in the test cases

		current = null;
		// reads tokens from the console and constructs a LinkedList from them
		while (scan.hasNextDouble())
		{
			coeff = scan.nextDouble();
			power = scan.nextInt();
			if (poly2 == null)
			{
				poly2 = LinkedList.createNode(coeff, power);
				current = poly2;
			}
			else
			{
				current.next = LinkedList.createNode(coeff, power);;
				current = current.next;
			}
		}
		scan.next(); // gets rid of the "end" token in the end of each list in the test cases
		LinkedList.printList(LinkedList.add(poly1, poly2));
		LinkedList.printList(LinkedList.multiply(poly1, poly2));
		scan.close();
	}
}
