import java.util.Scanner;

class Suite {

    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {

        int debut;
        do {
            System.out.print("de (>= 1) ? ");
            debut = clavier.nextInt();
        } while (debut < 1);

        int fin;
        do {
            System.out.print("a (>= " + debut + ") ? ");
            fin = clavier.nextInt();
        } while (fin < debut);

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        
        int k=0;
        
        for (int x=debut; x<=fin; ++x) {
                       	
        		k=x;
        		int n=0;
        		while (k > 0) {
        			n=n+1;
                	if (k%3 == 0) {
                		k=k+4;
                	}else {
                		if(k%4 == 0) {
                			k=k/2;
                    	}else {
                    		k=k-1;
                			}
                		
                	}
                	
                	
        }
        		System.out.println(x+"->"+n);	
        		
        
        				
        		}
        	
        	 
        			

        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

    }
}
