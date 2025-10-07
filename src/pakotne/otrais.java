package pakotne;

import java.util.Scanner;

public class otrais {
	static Scanner scan = new Scanner(System.in);
public static int StudSk() {
	Scanner scan = new Scanner(System.in);
	int studSk;
	System.out.println("ievadit studentu skaitu");
	studSk = scan.nextInt();	
	return studSk;

}
	
	
	public static int KritSk() {
		int kritSk;
		do {
			System.out.println("Kāds būs kritēriju skaits?");
			while(!scan.hasNextInt()) {
				System.out.println("Kāds būs kritēriju skaits?");
				scan.next();
			}
			kritSk = scan.nextInt();
		}while(kritSk<1);
		
		
		scan.nextLine();
		return kritSk;
	}
	
	}

