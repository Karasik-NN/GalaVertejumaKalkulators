package pakotne;

import java.util.Scanner;

public class otrais {
	static Scanner scan = new Scanner(System.in);
public static int StudSk() {
	Scanner scan = new Scanner(System.in);
	int studSk;
	do {
		System.out.println("Cik studentiem aprēķināsi gala vērtējumu?");
		while(!scan.hasNextInt()) {
			System.out.println("Cik studentiem aprēķināsi gala vērtējumu?");
			scan.next();
		}
		studSk = scan.nextInt();
		
	}while(studSk<1);
	return studSk;
}
	
	
	public static void KritSk() {
		int kritSk;
		do {
			System.out.println("Kāds būs kritēriju skaits?");
			while(!scan.hasNextInt()) {
				System.out.println("Kāds būs kritēriju skaits?");
				scan.next();
			}
			kritSk = scan.nextInt();
		}while(kritSk<1);
		String[] kriteriji = new String[kritSk];
		int[] kriterijaSvars = new int[kritSk];
		int[][] kriterijaVertejums = new int[studSk][kritSk];
		double[] semestraVertejums = new double[studSk];
		
		scan.nextLine();
	}
}
