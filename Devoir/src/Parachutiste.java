import java.util.Scanner;

class Parachutiste {

    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {

        double masse = 80.0;
        do {
            System.out.print("masse du parachutiste (>= 40) ? ");
            masse = clavier.nextDouble();
        } while (masse < 40.0);

        double h0 = 39000.0;
        do {
            System.out.print("hauteur de depart du parachutiste (>= 250) ? ");
            h0 = clavier.nextInt();
        } while (h0 < 250.0);

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        double g = 9.81;
        double v0=0;
        double t0=0;
        double vitesse = v0;
        double hauteur = h0;
        double accel = g;
        double surface = 2.0;
        double t =t0;
        
        	
        	while (vitesse <= 343){
        		// Utilisez cette ligne pour l'affichage
                System.out.format("%.0f, %.4f, %.4f, %.5f\n",
                                  t, hauteur, vitesse, accel);
                ++t;
                
                double s=surface/masse;
                double q=Math.exp(-s*(t-t0));                   	
                hauteur=(h0-(g/s)*(t-t0)-((v0-(g/s))/s)*(1-q));
            	vitesse=((g/s)*(1-q)+v0*q);
            	accel=(g-s*vitesse); 
        	
        	}
        	System.out.println ("## Felix depasse la vitesse du son");
        	while (accel>=0.5) {
        		// Utilisez cette ligne pour l'affichage
                System.out.format("%.0f, %.4f, %.4f, %.5f\n",
                                  t, hauteur, vitesse, accel);
                ++t;
                
                double s=surface/masse;
                double q=Math.exp(-s*(t-t0));                   	
                hauteur=(h0-(g/s)*(t-t0)-((v0-(g/s))/s)*(1-q));
            	vitesse=((g/s)*(1-q)+v0*q);
            	accel=(g-s*vitesse); 
        	}
            System.out.println ("## Felix a atteint sa vitesse maximale");
            while (hauteur >= 2500) {
            	// Utilisez cette ligne pour l'affichage
                System.out.format("%.0f, %.4f, %.4f, %.5f\n",
                                  t, hauteur, vitesse, accel);
                ++t;
                
                double s=surface/masse;
                double q=Math.exp(-s*(t-t0));                   	
                hauteur=(h0-(g/s)*(t-t0)-((v0-(g/s))/s)*(1-q));
            	vitesse=((g/s)*(1-q)+v0*q);
            	accel=(g-s*vitesse);
            }
            System.out.println (" ## Felix ouvre son parachute");
            surface = 25.0;
            v0=vitesse;
            t0=t;
            h0=hauteur;
           
        	while(hauteur>0) {
        		// Utilisez cette ligne pour l'affichage
                System.out.format("%.0f, %.4f, %.4f, %.5f\n",
                                  t, hauteur, vitesse, accel);
                ++t;
                
                double s=surface/masse;
                double q=Math.exp(-s*(t-t0));                   	
                hauteur=(h0-(g/s)*(t-t0)-((v0-(g/s))/s)*(1-q));
            	vitesse=((g/s)*(1-q)+v0*q);
            	accel=(g-s*vitesse); 
        	
        }
                  	    	
        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

    }
}
