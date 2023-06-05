import java.util.Scanner;

public class Crypto {

    static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    static final int DECALAGE = 4;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Veuillez entrer une chaine de caracteres : ");
        String s = scanner.nextLine();

        // la chaine a coder
        String aCoder = "";
        // la chaine codee
        String chaineCodee = "";

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        char esp = ' ';
       
        int indices;
        int news =0;
        			for (int i = 0; i <= (s.length()-1); ++i) {
        				for (int j = 0; j <= (ALPHABET.length()-1); ++j) {
            	        		if(s.charAt(i)== ALPHABET.charAt(j) || s.charAt(i) == esp) {
            	        			indices = ALPHABET.indexOf(s.charAt(i));
            	        			if (s.charAt(i) == esp) {
            	        				aCoder = aCoder + esp;
            	        				chaineCodee = chaineCodee + esp;
            	        			} else {
            	        				
                	        			aCoder = aCoder + ALPHABET.charAt(indices);
                	        			news = indices + DECALAGE;
                	        			if (news <= (ALPHABET.length())) {
                	        				chaineCodee = chaineCodee + ALPHABET.charAt(indices + DECALAGE);
                	        			}else {
                	        				indices = news - ALPHABET.length();
                	        				chaineCodee = chaineCodee + ALPHABET.charAt(indices);
                	        				
                	        			}
                	        			
                	        			
            	        			}      				    
        	        	       	        	                        		        			
        		}
        	}
        }
        			
 
        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/
        System.out.format("La chaine initiale etait : '%s'\n", s);

        if (aCoder.isEmpty()) {
            System.out.println("La chaine a coder est vide.\n");
        } else {
            System.out.format("La chaine a coder est : '%s'\n", aCoder);
            System.out.format("La chaine codee est : '%s'\n", chaineCodee);
        }
    }
}
