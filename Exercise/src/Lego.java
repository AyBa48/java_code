/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
import java.util.ArrayList;
class Piece {
	private String nom;
	public Piece (String name){
		nom = name;
	}
	public String getNom () {
		return nom;
	}
	public String toString () {
		return getNom(); //+ " (nom de la piece)";
	}
}
	class Composant {
		private Piece piece;
		private int quantity;
		public Composant (Piece comp, int num){
			piece = comp;
			quantity =num;
		}
		public Piece getPiece() {
			return piece;
		};
		public int getQuantite(){
			return quantity;
		};
	} 
	class Simple extends Piece {
		private String orientation;
		public Simple (String name, String orient){
			super(name);
			orientation=orient;
		}
		public Simple (String name){
			super(name);
			orientation="aucune";
	}
		public String getOrientation(){return orientation;};
		public String toString(){
			return super.toString() +" "+ getOrientation();
		};
}
	class Composee extends Piece {
		private int tailleMax;
		private ArrayList<Simple>pieceCompose=new ArrayList<Simple>();
		public Composee (String name, int lengMax){
			super(name);
			tailleMax=lengMax;
		}
		public int taille() {return pieceCompose.size();};
		public int tailleMax() {return tailleMax;};
		public void construire(Simple p) {
			if(taille()<tailleMax()){
				pieceCompose.add(p);
			}
			if (taille()>tailleMax){
				System.out.println("Construction impossible");
			}
		}
		public String toString(){
			String t="";
			for (int i=0; i<pieceCompose.size()-1;++i){
				if (pieceCompose.get(i).getOrientation()!= "aucune"){
					 t=t+pieceCompose.get(i).getNom()+" "+pieceCompose.get(i).getOrientation()+", "+pieceCompose.get(i+1).getNom()+" "+pieceCompose.get(i+1).getOrientation();
				}else {
					 t=t+pieceCompose.get(i).getNom()+", "+pieceCompose.get(i+1).getNom()+" "+pieceCompose.get(i+1).getOrientation()+", ";
				}
			 }
			 return super.getNom() + " (" + t +")";
		}
	}
class Construction {
	private int composantMax;
	private ArrayList<Simple> compo=new ArrayList<Simple>();
	private ArrayList<Composee> cont=new ArrayList<Composee>();
	ArrayList<Integer> quantity=new ArrayList<Integer>();
	ArrayList<Integer> quant=new ArrayList<Integer>();
	public Construction (int nbreMax){
		composantMax=nbreMax;
	}
	public int taille(){return compo.size();};
	public int tailleMax() {return composantMax;};
	public void ajouterComposant (Simple com, int num){
		if (taille()<tailleMax()){
			compo.add(com);
			quantity.add(num);
		}else {
			System.out.println("Ajout de composant impossible");
		}
	}
	public void ajouterComposant (Composee comp, int numb){
		if (cont.size()<numb) {
			cont.add(comp);
			quant.add(numb);
		}else {
			System.out.println("Ajout de composant impossible");
		}
	}
	public String toString(){
		String h="";
		for (int i=0; i<=compo.size()-1;++i){
			h="("+compo.get(i).getNom()+") " + "(quantité "+quantity.get(i)+")"+"\n"+ cont.get(i)+" (quantité "+quant.get(i)+")"+"\n"+cont.get(i+1)+" (quantité "+quant.get(i+1)+")";
		}
		return h;
	}
}
/*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/

class Lego {

    public static void main(String[] args) {
        // declare un jeu de construction de 10 pieces
        Construction maison = new Construction(10);

        // ce jeu a pour premier composant: 59 briques standard
        // une brique standard a par defaut "aucune" comme orientation
        maison.ajouterComposant(new Simple("brique standard"), 59);

        // declare une piece dont le nom est "porte", composee de 2 autres pieces
        Composee porte = new Composee("porte", 2);

        // cette piece composee est constituee de deux pieces simples:
        // un cadran de porte orient'e a gauche
        // un battant orient'e a gauche
        porte.construire(new Simple("cadran porte", "gauche"));
        porte.construire(new Simple("battant", "gauche"));

        // le jeu a pour second composant: 1 porte
        maison.ajouterComposant(porte, 1);

        // dÃ©clare une piece composee de 3 autres pieces dont le nom est "fenetre"
        Composee fenetre = new Composee("fenetre", 3);

        // cette piece composee est constitu'ee des trois pieces simples:
        // un cadran de fenetre (aucune orientation)
        // un volet orient'e a gauche
        // un volet orient'e a droite
        fenetre.construire(new Simple("cadran fenetre"));
        fenetre.construire(new Simple("volet", "gauche"));
        fenetre.construire(new Simple("volet", "droit"));

        // le jeu a pour troisieme composant: 2 fenetres
        maison.ajouterComposant(fenetre, 2);

        // affiche tous les composants composants (nom de la piece et quantit'e)
        // pour les pieces compos'ees : affiche aussi chaque piece les constituant
        System.out.println("Affichage du jeu de construction : ");
        System.out.println(maison);
    }
}
