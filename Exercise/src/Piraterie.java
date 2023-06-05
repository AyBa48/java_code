/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
abstract class Navire {
	private int x;
	private int y;
	private int drapeau;
	private boolean detruit;
	public Navire (int coordX, int coordY, int drap){
		if(coordX>0 && coordY>0){
			x=coordX;
			y=coordY;
		}
		if (coordX>Piraterie.MAX_X && coordY>Piraterie.MAX_Y){
			x=Piraterie.MAX_X;
			y=Piraterie.MAX_Y;
		}
		
		drapeau=drap;
		detruit=false;
	}
	public int getX() {return x;};
	public int getY() {return y;};
	public int getDrapeau() {return drapeau;};
	public boolean estDetruit() {
		return detruit ==true;
	}
	public double distance(Navire autre){
		return Math.sqrt((getX()-autre.getX())*(getX()-autre.getX())+((getY()-autre.getY())*(getY()-autre.getY())));
	}
	public void avance(int unitsX, int unitsY){
			x=x+unitsX;
			y=y+unitsY;
			if (x>Piraterie.MAX_X && y>Piraterie.MAX_Y){
				x=Piraterie.MAX_X;
				y=Piraterie.MAX_Y;
		}
	}
	public void coule() {
		detruit=true;
		}
	public String getNom(){return "Bateau";};
	public String toString() {
		return getNom() + " avec drapeau " + getDrapeau()+ " en ( "+getX()+ ", "+getY()+" )";
		}		
	public void rencontre(Navire bat){
		if (distance(bat) <= Piraterie.RAYON_RENCONTRE) {
			if (getDrapeau() != bat.getDrapeau()){
				combat(bat);
			}
		}
	}
	public abstract void combat(Navire nav);
	public abstract void recoitBoulet();
	public boolean estPacifique(){
		return Marchand.class==getClass();
  }
}
class Pirate extends Navire {
	private boolean endommage;
	Pirate (int coorX, int coorY, int drap, boolean endom) {
		super(coorX, coorY, drap);
		endommage=endom;
	}
	public String getNom(){return super.getNom() + " pirate";};
	public String toString () {
		if (estEndommage()&&estDetruit()==false){
	
			return super.toString() + " -> ayant subi des dommages";
		}
		if (estDetruit()){
			return super.toString() + " -> detruit";
		}
		else {
			return super.toString() + " -> intact";
		}
	}
	public boolean estEndommage() {
		return endommage==true;
	}
	public void combat(Navire nav) {
		if (nav.estPacifique()){
			nav.recoitBoulet();
			
		}
		if (nav.estPacifique()==false&&estPacifique()==false){
			recoitBoulet();
			nav.recoitBoulet();
			
		}
		if(estPacifique()==false&&nav.estPacifique()){
			nav.recoitBoulet();
		
		}
	}
	public void recoitBoulet() {
		if (estEndommage()==false) {
			endommage=true;
			return;
		}
		if (estEndommage()) {
				coule();
			
		}
	}
}
class Marchand extends Navire {
	public Marchand (int coordX, int coordY, int drap) {
		super(coordX, coordY, drap);
	}
	public String toString () {
		if (estDetruit()){
			return super.toString() + " -> detruit";
		}else {
			return super.toString() + " -> intact";
		}
	}
	public String getNom(){return super.getNom() + " marchand";};
	public void combat(Navire na){
		if (na.estPacifique()==false){
			recoitBoulet();
		}
	}
    public void recoitBoulet() {
    	   coule();

	}
}
	
/*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/
class Piraterie {

    static public final int MAX_X = 500;
    static public final int MAX_Y = 500;
    static public final double RAYON_RENCONTRE = 10;

    static public void main(String[] args) {
        // Test de la partie 1
        System.out.println("***Test de la partie 1***");
        System.out.println();
        // un bateau pirate 0,0 avec le drapeau 1 et avec dommages
        Navire ship1 = new Pirate(0, 0, 1, true);
        // un bateau marchand en 25,0 avec le drapeau 2
        Navire ship2 = new Marchand(25, 0, 2);
        System.out.println(ship1);
        System.out.println(ship2);
        System.out.println("Distance: " + ship1.distance(ship2));
        System.out.println("Quelques deplacements horizontaux et verticaux");
        // se deplace de 75 unites a droite et 100 en haut
        ship1.avance(75, 100);
        System.out.println(ship1);
        System.out.println(ship2);
        System.out.println("Un deplacement en bas:");
        ship1.avance(0, -5);
        System.out.println(ship1);
        ship1.coule();
        ship2.coule();
        System.out.println("Apres destruction:");
        System.out.println(ship1);
        System.out.println(ship2);

        // Test de la partie 2
        System.out.println();
        System.out.println("***Test de la partie 2***");
        System.out.println();

        // deux vaisseaux sont enemis s'ils ont des drapeaux differents

        System.out.println("Bateau pirate et marchand ennemis (trop loins):");
        // bateau pirate intact
        ship1 = new Pirate(0, 0, 1, false);
        ship2 = new Marchand(0, 25, 2);
        System.out.println(ship1);
        System.out.println(ship2);
        ship1.rencontre(ship2);
        System.out.println("Apres la rencontre:");
        System.out.println(ship1);
        System.out.println(ship2);
        System.out.println();

        System.out.println("Bateau pirate et marchand ennemis (proches):");
        // bateau pirate intact
        ship1 = new Pirate(0, 0, 1, false);
        ship2 = new Marchand(2, 0, 2);
        System.out.println(ship1);
        System.out.println(ship2);
        ship1.rencontre(ship2);
        System.out.println("Apres la rencontre:");
        System.out.println(ship1);
        System.out.println(ship2);
        System.out.println();

        System.out.println("Bateau pirate et marchand amis (proches):");
        // bateau pirate intact
        ship1 = new Pirate(0, 0, 1, false);
        ship2 = new Marchand(2, 0, 1);
        System.out.println(ship1);
        System.out.println(ship2);
        ship1.rencontre(ship2);
        System.out.println("Apres la rencontre:");
        System.out.println(ship1);
        System.out.println(ship2);
        System.out.println();

        System.out.println("Deux bateaux pirates ennemis intacts (proches):");
        // bateaux pirates intacts
        ship1 = new Pirate(0, 0, 1, false);
        ship2 = new Pirate(2, 0, 2, false);
        System.out.println(ship1);
        System.out.println(ship2);
        ship1.rencontre(ship2);
        System.out.println("Apres la rencontre:");
        System.out.println(ship1);
        System.out.println(ship2);
        System.out.println();

        System.out.println("Un bateau pirate intact et un avec dommages, ennemis:");
        // bateau pirate intact
        Navire ship3 = new Pirate(0, 2, 3, false);
        System.out.println(ship1);
        System.out.println(ship3);
        ship3.rencontre(ship1);
        System.out.println("Apres la rencontre:");
        System.out.println(ship1);
        System.out.println(ship3);
        System.out.println();

        System.out.println("Deux bateaux pirates ennemis avec dommages:");
        System.out.println(ship2);
        System.out.println(ship3);
        ship3.rencontre(ship2);
        System.out.println("Apres la rencontre:");
        System.out.println(ship2);
        System.out.println(ship3);
        System.out.println();
    }
}
