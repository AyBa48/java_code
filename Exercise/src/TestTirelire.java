import java.util.Scanner;

/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
 class Tirelire {
	private double montant;
	public double getMontant() {return montant;}
	void afficher() {
		if (montant == 0) {
			System.out.println ("Vous êtes sans le sous.");
		}else {
			if (montant > 0) {
				System.out.println ("Vous avez :"+ " "+ montant + " "+ "euros dans votre tirelire.");
			}
		}
	}
	void secouer () {
		if (montant != 0) {
			System.out.println("Bing bing");
		}else {
			return ;
		}
	}
	void remplir (double montant){
		if (montant >0){
			this.montant = this.montant + montant;
		}else {
			return;
		}
	}
	void vider (){
		this.montant = 0;
	}
	void puiser (double montant){
		if (montant >this.montant || montant < 0){
			return;
		}else {
			this.montant = this.montant - montant;
		}
	}
	public double  calculerSolde (double budget){
		if (budget <= 0){
			return this.montant;
		}else {
			return this.montant - budget;
		}
	
	}
}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
 public class TestTirelire {

	    public static void main(String[] args) {
	        Tirelire piggy = new Tirelire();

	        piggy.vider();
	        piggy.secouer();
	        piggy.afficher();

	        piggy.puiser(20.0);
	        piggy.secouer();
	        piggy.afficher();

	        piggy.remplir(550.0);
	        piggy.secouer();
	        piggy.afficher();

	        piggy.puiser(10.0);
	        piggy.puiser(5.0);
	        piggy.afficher();

	        System.out.println();

	        // le budget de vos vacances de rêves.
	        double budget;
	        Scanner clavier = new Scanner(System.in);

	        System.out.println("Donnez le budget de vos vacances : ");
	        budget = clavier.nextDouble();

	        // ce qui resterait dans la tirelire après les
	        // vacances
	        double solde = piggy.calculerSolde(budget);

	        if (solde >= 0) {
	            System.out.print("Vous êtes assez riche pour partir en vacances !");
	            System.out.print(" il vous restera " + solde + " euros");
	            System.out.print(" à la rentrée \n");
	            piggy.puiser(budget);
	        }

	        else {
	            System.out.print("Il vous manque " + (-solde) + " euros");
	            System.out.print(" pour partir en vacances !\n");
	        }
	    }
	}