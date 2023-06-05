/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
import java.util.ArrayList;
class Vehicule {
	private String nom;
	private double vitesseMax;
	private int poids;
	private int niveauCarburant;
	public Vehicule (String name, double vitesse, int weight, int carburant) {
		nom = name;
		vitesseMax = vitesse;
		poids = weight;
		niveauCarburant= carburant;
	}
	public Vehicule () {
		nom = "Anonyme";
		vitesseMax = 130;
		poids = 1000;
		niveauCarburant= 0;
	}
	public String toString () {
		return nom + " -> Vitesse max = "+ vitesseMax + " km/h, poids = "+ poids + " kg";
	}
	public double performance() {
		return vitesseMax/poids;
	}
	public boolean meilleur(Vehicule autreVehicule) {
		return performance()>autreVehicule.performance();
	}
	public String getNom() { return nom;};
	public double getVitesseMax() { return vitesseMax;};
	public int getPoids() {return poids;};
	public int getCarburant() {return niveauCarburant;};
	public  boolean estDeuxRoues() {
		return getClass()==Moto.class;
	}
}
class Voiture extends Vehicule {
	private String categorie;
	public Voiture (String name, double speed, int weight, int carb, String cat) {
		super(name, speed, weight, carb);
		categorie=cat;
	}
	public String getCategorie(){
		return categorie;};
	public String toString () {
		return super.toString() + ", Voiture de "+ categorie;
	}
}
class Moto extends Vehicule {
	private  boolean sidecar;
	public Moto (String nam, double speeds, int weigt, int carbu, boolean h){
		super(nam, speeds, weigt, carbu);
		sidecar=h;
}
	public Moto (String nam, double speeds, int weigt, int carbu){
		super(nam, speeds, weigt, carbu);
		sidecar=false;
}
	public String toString() {
		if (sidecar) {
			return super.toString() + ", Moto, avec sidecar";
		}else {
			return super.toString() + ", Moto";
	}	
}
	public  boolean estDeuxRoues() {
		return sidecar==false;
    }
}
abstract class Rallye extends Vehicule {
	public abstract boolean check();
}
class GrandPrix extends Rallye {
	private ArrayList<Vehicule> vehicule= new ArrayList<Vehicule>();
	public ArrayList<Vehicule> ajouter(Vehicule v) {
		 vehicule.add(v);
		 return vehicule;};
	public boolean check() {
		boolean t=false;
		ArrayList<Vehicule>roue=new ArrayList<Vehicule>();
		ArrayList<Vehicule>voit=new ArrayList<Vehicule>();
		for (int i=0; i<=vehicule.size()-1; ++i){
			if (vehicule.get(i).estDeuxRoues()){
				roue.add(vehicule.get(i));
			}else {voit.add(vehicule.get(i));}
		}
		if (voit.size()!=roue.size()){
			if (vehicule.size()==voit.size()){
				return t=true;
			}
			if (vehicule.size()==roue.size()){
				return t=true;
		}
			if (vehicule.size()!=roue.size()&&vehicule.size()!=voit.size()) {
				return t=false;
		}
	}
		return t;
}
	public void run(int tours){
		int t=0;
		int g=0;
		int y=0;
		ArrayList<Vehicule>f=new ArrayList<Vehicule>();
		ArrayList<Vehicule>ar=new ArrayList<Vehicule>();
		if (check()==false){
			System.out.println("Pas de Grand Prix");
		}else {
			for (Vehicule v: vehicule){
				t=v.getCarburant()-tours;
				if(t>0){
					f.add(v);
				}
				if(t<0){
					System.out.println("Elimination de tous les vehicules");
					return;
				}
			}
			for (Vehicule a:f){
			
				if(meilleur(a)==false){
					ar.add(a);
					g=g+1;
				}
			}
			for (Vehicule j:ar){
				if(meilleur(j)==false) {
					y=y+1;
				}
			}
			System.out.println ("Le gagnant du grand prix est -> "+ ar.get(g-1).toString());
		    }
	    }
}
/*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/
public class Course {

    public static void main(String[] args) {

        // PARTIE 1
        System.out.println("Test partie 1 : ");
        System.out.println("----------------");
        Vehicule v0 = new Vehicule();
        System.out.println(v0);

        // les arguments du constructeurs sont dans l'ordre:
        // le nom, la vitesse, le poids, le carburant
        Vehicule v1 = new Vehicule("Ferrari", 300.0, 800, 30);
        Vehicule v2 = new Vehicule("Renault Clio", 180.0, 1000, 20);
        System.out.println();
        System.out.println(v1);
        System.out.println();
        System.out.println(v2);

        if (v1.meilleur(v2)) {
            System.out.println("Le premier vehicule est meilleur que le second");
        } else {
            System.out.println("Le second vehicule est meilleur que le premier");
        }
        // FIN PARTIE 1

        // PARTIE2
        System.out.println();
        System.out.println("Test partie 2 : ");
        System.out.println("----------------");

        // les trois premiers arguments sont dans l'ordre:
        // le nom, la vitesse, le poids, le carburant
        // le dernier argument indique la presence d'un sidecar
        Moto m1 = new Moto("Honda", 200.0, 250, 15, true);
        Moto m2 = new Moto("Kawasaki", 280.0, 180, 10);
        System.out.println(m1);
        System.out.println();
        System.out.println(m2);
        System.out.println();

        // les trois premiers arguments sont dans l'ordre:
        // le nom, la vitesse, le poids, le carburant
        // le dernier argument indique la categorie
        Voiture vt1 = new Voiture("Lamborghini", 320, 1200, 40, "course");
        Voiture vt2 = new Voiture("BMW", 190, 2000, 35, "tourisme");
        System.out.println(vt1);
        System.out.println();
        System.out.println(vt2);
        System.out.println();
        // FIN PARTIE 2

        // PARTIE 3
        System.out.println();
        System.out.println("Test partie 3 : ");
        System.out.println("----------------");

        GrandPrix gp1 = new GrandPrix();
        gp1.ajouter(v1);
        gp1.ajouter(v2);
        System.out.println(gp1.check());

        GrandPrix gp2 = new GrandPrix();
        gp2.ajouter(vt1);
        gp2.ajouter(vt2);
        gp2.ajouter(m2);
        System.out.println(gp2.check());

        GrandPrix gp3 = new GrandPrix();
        gp3.ajouter(vt1);
        gp3.ajouter(vt2);
        gp3.ajouter(m1);
        System.out.println(gp3.check());

        GrandPrix gp4 = new GrandPrix();
        gp4.ajouter(m1);
        gp4.ajouter(m2);
        System.out.println(gp4.check());
        // FIN PARTIE 3

        // PARTIE 4
        System.out.println();
        System.out.println("Test partie 4 : ");
        System.out.println("----------------");
        GrandPrix gp5 = new GrandPrix();
        gp5.ajouter(vt1);
        gp5.ajouter(vt2);

        System.out.println("Premiere course :");
        gp5.run(11);
        System.out.println();

        System.out.println("Deuxieme  course :");
        gp3.run(40);
        System.out.println();

        System.out.println("Troisieme  course :");
        gp2.run(11);
        // FIN PARTIE 4
    }

}
