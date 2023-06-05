import java.util.Scanner;

class Cluedo1 {

    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Pensez a un personnage : Mlle Rose, ");
        System.out.println("le Professeur Violet, le Colonel Moutarde,");
        System.out.println("le Reverend Olive ou Mme Leblanc.\n");

        System.out.print("Votre personnage a-t-il des moustaches ? ");
        System.out.print("(true : oui, false : non) ");
        boolean moustaches = clavier.nextBoolean();

        System.out.print("Votre personnage porte-t-il des lunettes ? ");
        boolean lunettes = clavier.nextBoolean();

        System.out.print("Votre personnage porte-t-il un chapeau ? ");
        boolean chapeau = clavier.nextBoolean();

        System.out.print("Est-ce que votre personnage est un homme ? ");
        boolean homme = clavier.nextBoolean();

        System.out.print("==> Le personnage auquel vous pensez est ");

        if (chapeau) {
        	
            /*******************************************
             * Completez le programme a partir d'ici.
             *******************************************/
        	if (lunettes && homme){
        			System.out.print("le Professeur Violet");
        	   }
        }
        if (lunettes) {
        	if (homme) {
        		if (moustaches) {
        			System.out.print("le Colonel moutarde");
        		}else {
        			System.out.print("le Reverend olive");
        		}
        	}else {
        		System.out.print("Mme leblanc");
        	}
        }else {
        	System.out.print("Mlle rose");
        	                      
            /*******************************************
             * Ne rien modifier apres cette ligne.
             *******************************************/
            
        
        }

        System.out.println();
    }
}
