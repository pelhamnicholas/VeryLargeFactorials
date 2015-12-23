import java.util.Scanner;

/**
 * 
 * @author Nicholas
 *	ID: 006742522
 */
public class Driver {
	
	public static void main(String args[]) {
		LineWriter lw;
		
		Scanner in = new Scanner(System.in);
		Factorial fact = new Factorial();
		
		System.out.print("Enter a number to calculate it's factorial: ");
		while (in.hasNextInt()) {
			int base = in.nextInt();
			lw = new LineWriter(base + ".dat");
			fact.getLineWriter(lw);
			long start = System.currentTimeMillis();
			System.out.println(base + "!: ");
			fact.fact(base);
			fact.print();
			long end = System.currentTimeMillis();
			System.out.println(" Seconds to calculate: " + (end - start) / 1000);
			lw.println(" Seconds to calculate: " + (end - start) / 1000);
			System.out.println();
			lw.println();
			lw.close();
			System.out.println("Enter x to exit, or another");
			System.out.print("number to calculate it's factorial: ");
		}
	}

}