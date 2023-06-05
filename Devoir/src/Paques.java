import java.util.Scanner;


public class Paques {
	private final static Scanner CLAVIER = new Scanner(System.in);
	public static void main(String[] args) {
		int year = demanderAnnee();
		int day = datePaques(year);
		afficheDate(year, day);
		
		
	}

	static int demanderAnnee()
	{
		int annee;
		do {
			System.out.println("Entrez une annee (1583-4000) :");
			annee = CLAVIER.nextInt();
		} while (annee <1583 || annee > 4000);
		return annee;
	}
	static void afficheDate(int an, int jour)
	{int days = jour;
		if (days <= 31) {
			System.out.println("Date de Paques en"+ " "+ an + " "  +":"+ " " +days + " "+ "mars");
		}else {
			if (days >= 32) {
				days = days - 31;
				System.out.println("Date de Paques en"+ " "+ an + " "  +":"+ " "  + days + " " + "avril");
			}
		}
		
	}
	static int datePaques (int yr)
	{
		int s = (yr/100) ;
		int p = (13 + 8*s)/25;
		int q = (s/4);
		int m = (15 - p + s - q);
		int n = (4 + s - q) % 7;
		int d = (m + 19 * (yr%19)) % 30;
		int e = ((2 * (yr % 4) + 4 * (yr % 7) + 6 * d + n) % 7);
		int jr = e + d + 22;
		if (e == 6) {
			if (d ==29 || d== 28 && (11*(m+1)%30)<19) {
				jr = jr - 7;
			}
		}
		return jr;
	}
}
