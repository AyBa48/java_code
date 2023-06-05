import java.util.Scanner;

class Cluedo2 {

    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {
    	
        System.out.print("Pensez a un personnage : Mlle Rose, ");
        System.out.println("le Professeur Violet, le Colonel Moutarde,");
        System.out.println("le Reverend Olive ou Mme Leblanc.\n");
        
        System.out.print("Votre personnage porte-t-il des lunettes ? ");
        System.out.print("(true : oui, false : non) ");
        boolean lunettes = clavier.nextBoolean();
        
        System.out.print("Est-ce que votre personnage est un homme ? ");
		boolean homme = clavier.nextBoolean();
             
           
        

        if (lunettes) {
        	if (homme) {
        		System.out.print("Votre personnage a-t-il des moustaches ? ");
        		boolean moustaches = clavier.nextBoolean();
        		if (moustaches) {
        			System.out.print("==> Le personnage auquel vous pensez est ");
        			System.out.print("le Colonel moutarde");
        		
        		}else {
        			System.out.print("==> Le personnage auquel vous pensez est ");
                    System.out.print("le Reverend olive");
        		   }
        		
        	  }else {
        		  System.out.print("Votre personnage porte-t-il un chapeau ? ");
                  boolean chapeau = clavier.nextBoolean();
                  if (chapeau) {
          			System.out.print("==> Le personnage auquel vous pensez est ");
          			System.out.print("le Professeur Violet");
                  }else {
                	  System.out.print("==> Le personnage auquel vous pensez est ");
                	  System.out.print("Mme leblanc");
                  }
        	  }   
        }else {
        	System.out.print("==> Le personnage auquel vous pensez est ");
        	System.out.print("Mlle rose");
     
        	
        	
            /*******************************************
             * Completez le programme a partir d'ici.
             *******************************************/
        	
        	                      
            /*******************************************
             * Ne rien modifier apres cette ligne.
             *******************************************/
            
        
        }

        System.out.println();
    }
}
