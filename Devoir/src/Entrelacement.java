import java.util.Scanner;

class Entrelacement {

    private static Scanner clavier = new Scanner(System.in);
    public static void main(String[] args) {
        int[] tab1 = {1, 7, 6};
        int taille = tab1.length;
        int[] tab2 = new int[taille];

        System.out.println("Saisie du tableau : ");
        // lecture du second tableau
        for(int i = 0; i < taille; ++i) {
            System.out.println("Entrez une valeur pour l'element " + i + " : ");
            tab2[i] = clavier.nextInt();
        }

        // affichage
        System.out.println("Les tableaux a entrelacer sont : ");
        for(int i = 0; i < taille; ++i) {
            System.out.print(tab1[i] + " " );
        }
        System.out.println();

        for(int i = 0; i < taille; ++i) {
            System.out.print(tab2[i] +  " " );
        }
        System.out.println();

        /*******************************************
        * Completez le programme a partir d'ici.
        *******************************************/
        System.out.println("Le resultat est:");
        for (int j = 0; j<taille; ++j) {
        	
        	
        	System.out.print(tab1[j] + " "+ tab2[j]+ " ");
        	
        }
        System.out.println();

        /*******************************************
        * Ne rien modifier apres cette ligne.
        *******************************************/

    }

}
