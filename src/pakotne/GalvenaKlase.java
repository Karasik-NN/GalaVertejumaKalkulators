
package pakotne;

import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class GalvenaKlase {
	static Scanner scan = new Scanner(System.in);
	public static int skaitlaParbaude(String zinojums, int min, int max) {
		String ievade;
		int skaitlis;
		while (true) {
		ievade = JOptionPane.showInputDialog(null, zinojums, "Datu ievade", JOptionPane.INFORMATION_MESSAGE);
		if (ievade == null) return -1;

		try {
		skaitlis = Integer.parseInt(ievade);
		if (skaitlis < min || skaitlis > max) {
		JOptionPane.showMessageDialog(null, "Noradits nekorets intervals", "Nekorekti dati", JOptionPane.WARNING_MESSAGE);
		continue;
		}
		return skaitlis;
		} catch (NumberFormatException e) {
		JOptionPane.showMessageDialog(null, "Netika ievadits vesels skaitlis", "Nekorekti dati", JOptionPane.ERROR_MESSAGE);
		}
		}
		}

		
	public static void main(String[] args) {
		int studSk = 0, kritSk;
		Scanner scan = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.#");
		
			
			
		otrais.StudSk();
		int studsk = otrais.StudSk();
		String[] studenti = new String[studsk];
		// Vērtēšanas kritēriju skaita ievade
			
		otrais.KritSk();
		int kritsk = otrais.KritSk();
		
		String[] kriteriji = new String[kritsk];
		int[] kriterijaSvars = new int[kritsk];
		int[][] kriterijaVertejums = new int[kritsk][kritsk];
		double[] semestraVertejums = new double[kritsk];

		
		VardUzvard();
		
		// Definē kritērijus
        int maxSvars = 100;
		int sk = 1;
		double atlSvars;
for(int i=0; i<kriteriji.length; i++) {
	do {
		System.out.println("Ievadi "+(i+1)+". kritēriju");
		kriteriji[i] = scan.nextLine().trim();
	} while(!kriteriji[i].matches("^[\\p{L} ]+$"));
			// Norāda katra kritērija svaru
			do {
				System.out.println("Ievadi "+(i+1)+". kritērija svaru (max: "+maxSvars+")");
				while(!scan.hasNextInt()) {
					System.out.println("Ievadi "+(i+1)+". kritērija svaru");
					scan.next();
				}
				kriterijaSvars[i] = scan.nextInt();
				/* Minimālā KATRA ATLIKUŠĀ kritērija svars ir 5
				 * kopējai svaru vērtībai ir jābūt 100 (ne mazāk, ne vairāk)
				*/
				atlSvars = (maxSvars - kriterijaSvars[i]) / (double)(kriteriji.length - sk);
			} while(kriterijaSvars[i]>maxSvars || kriterijaSvars[i]<5 || 
				  (i != kriteriji.length-1 && kriterijaSvars[i] == maxSvars) ||
				  (i == kriteriji.length-1 && (maxSvars - kriterijaSvars[i])  > 0) 
				  || atlSvars < 5);
			maxSvars -= kriterijaSvars[i];
			sk++;
			scan.nextLine();
		}
		
		// Norāda vērtējumu kādu ieguvis katrs audzēknis par katru kritēriju
		for(int i=0; i<kriterijaVertejums.length; i++) {
			for(int j=0; j<kriterijaVertejums[i].length; j++) {
				do {
					System.out.println("Ievadi "+studenti[i]+" vērtējumu par kritēriju "+kriteriji[j]);
					while(!scan.hasNextInt()) {
						System.out.println("Ievadi "+studenti[i]+" vērtējumu par kritēriju "+kriteriji[j]);
						scan.next();
					}
					kriterijaVertejums[i][j] = scan.nextInt();
				}while(kriterijaVertejums[i][j]<0 || kriterijaVertejums[i][j]>10);
			}
		}
		
		// Gala vērtējuma aprēķināšana
		double rezultats;
		for(int i=0; i<studenti.length; i++) {
			rezultats=0;
			for(int j=0; j<kriteriji.length; j++) {
				rezultats += ((double) kriterijaSvars[j]/100)*kriterijaVertejums[i][j];
			}
			semestraVertejums[i] = rezultats;
		}
		
		// Gala vērtējumu izvadīšana
		for(int i=0; i<studenti.length; i++) {	
			for(int j=0; j<kriteriji.length; j++) {
				System.out.println("Studenta "+studenti[i]+" vērtējums par kritēriju "+kriteriji[j]+" ir "+kriterijaVertejums[i][j]+", kura svars ir "+kriterijaSvars[j]);
			}
			System.out.println("Semestra vērtējums ir "+df.format(semestraVertejums[i])+" balles"
					+ "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		}
		scan.close();
	}

	public static void VardUzvard() {
		String[] skoleni=new String[otrais.StudSk()];
        System.out.print("Ievadit darbu skaitu: ");
        int drb=scan.nextInt();
        scan.nextLine();
        
        String[] darbi=new String[drb];
        int[] svars=new int[drb];
        for(int i=0;i<otrais.StudSk();i++)
        {
        	System.out.print("Vards "+(i+1)+": ");
        skoleni[i]=scan.nextLine();
        }
	}
}
	
		



	




