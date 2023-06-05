import java.util.ArrayList;
import java.util.Scanner;

class TrancheMax {

    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {

        // Entree de la matrice
        System.out.println("Saisie de la matrice :");
        String matrice = clavier.nextLine();
        System.out.format("Matrice saisie :\n%s\n", matrice);

        // stocke les indices des lignes contenant la plus grande sequence de
        // '1' consecutifs dans la matrice
        ArrayList<Integer> maxConsecutifList = new ArrayList<Integer>();

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        ArrayList<Integer> maxList = new ArrayList<Integer>();
        int n ;
        String[] lignes =  matrice.split(" {1,}");
        for (int k = 0; k <= (lignes.length -1); ++k){
        	int r=0;
        		for(int x=0; x+1 <= (lignes[k].length()-1); ++x)  {
        			if (lignes[k].charAt(x) != '0' &&  lignes[k].charAt(x) != '1' && lignes[k].charAt(x) != ' ') {
            			System.out.println("Matrice invalide, seulement '1' , '0' et ' ' admis!");
            			return;
        			}else {
            		    if ((lignes[k]).length() != (lignes[lignes.length-k-1]).length() && matrice.charAt(x) != ' ') {
                       	    System.out.println ("Matrice invalide, lignes de longueurs differentes!");
                       	    return;	
                     }else {
                    	 if (lignes[k].charAt(x)== '1' && lignes[k].charAt(x+1) == '1') {
                    		 ++r; 
                    	 }
                      } 
        	        }
        		}
        		n=r;
        		if (n >= 1) {
        			 maxConsecutifList.add(k);
        			 maxList.add(n);
        		     }
        		}
                //for (int g = 0; g <= (maxConsecutifList.size()-1); ++g) {
                //	if (maxList.get(g) > maxList.get(maxList.size()-g-1)) {
               // 		maxConsecutifList.remove(maxList.size()-g-1);	
              //  	}
              //  }
        
        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

        if (maxConsecutifList.isEmpty()) {
            System.out.println("Pas de lignes avec des 1!");
        } else {
            System.out.println("Ligne(s) avec le plus de 1 consecutifs:");
            for (Integer index : maxConsecutifList) {
                System.out.println(index);
            }
        }
    }
  }
