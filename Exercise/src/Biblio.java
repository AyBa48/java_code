import java.util.ArrayList;

class Auteur {

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
	private String nom;
	private boolean prix;
	public Auteur (String name, boolean price)
	{
		nom = name;
		prix = price;
	}
	public String getNom() {return nom;};
	public boolean getPrix() {return prix;};
}
class Oeuvre {
	private String titre;
	private Auteur reference;
	private String langue;
	public Oeuvre (String title, Auteur auteur, String langage)
	{
		titre = title;
		reference = auteur; 
		langue = langage;
	}
	public Oeuvre (String title, Auteur auteur)
	{
		titre = title;
		reference = auteur; 
		langue = "francais";
	}
	public String getTitre() {return titre;};
	public Auteur getAuteur() {return reference;};
	public String getLangue() {return langue;};
	public void afficher() 
	{
		System.out.println (titre + ", " + getAuteur().getNom() + ", en " + getLangue());
	}
}
class Exemplaire {

	private Oeuvre refer;
	//La class Exemplaire doit déclarer un attribut de type Oeuvre; cette référence que doit retourner méthode getOeuvre() .
	public Exemplaire (Oeuvre reference)
	{
		refer=reference;
		System.out.println("Nouvel exemplaire -> " + refer.getTitre() + ", " + refer.getAuteur().getNom() +", en " + refer.getLangue());
	}
	public Exemplaire (Exemplaire reference)
	{
		refer=reference.getOeuvre();
		System.out.println("Copie d’un exemplaire de -> " + reference.getOeuvre().getTitre() + ", "+ reference.getOeuvre().getAuteur().getNom() +",  en " + reference.getOeuvre().getLangue());
	}
	public Oeuvre getOeuvre() {return refer;};
	public void afficher() {System.out.println( "Un exemplaire de "+refer.getTitre() + ", " + refer.getAuteur().getNom() +", en " + refer.getLangue());};
	
}
class Bibliotheque {
	private String nom;
	private ArrayList<Exemplaire> exemplaires = new ArrayList<Exemplaire>();
	public Bibliotheque(String name)
	{
		nom = name;
		System.out.println("La bibliothèque " + name + " est ouverte !");
	}
	public String getNom() {return nom;};
	public ArrayList<Exemplaire> stocker(Oeuvre reference, int nbreExemplaire )
	{
		for (int i=1; i<=nbreExemplaire; ++i) {
			exemplaires.add(new Exemplaire(reference));
		}		
		return exemplaires;
	}
	public ArrayList<Exemplaire> stocker(Oeuvre reference)
	{
		exemplaires.add(new Exemplaire(reference));
		return exemplaires;
    }
	public ArrayList<Exemplaire> listerExemplaires(String lang)
	{
		ArrayList <Exemplaire> exemp = new ArrayList<Exemplaire>();
		for(int i=0; i<=exemplaires.size()-1; ++i) {
			String lan=exemplaires.get(i).getOeuvre().getLangue();
			if((lan.equals(lang))){
				exemp.add(exemplaires.get(i));	
				//System.out.println(exemplaires.get(i).afficher());
			}
		}
		return exemp;
	}	
	public ArrayList<Exemplaire> listerExemplaires(){
		ArrayList <Exemplaire> exemp = new ArrayList<Exemplaire>();
		for (int i=0; i<=exemplaires.size()-1;++i){
			exemp.add(exemplaires.get(i));
			//System.out.println(exemp.get(i).afficher());
		}
		return exemp;
  }
	public int compterExemplaires(Oeuvre reference){
		int j=0;
		String livre = reference.getTitre();
	// comparaison des attributs de l'oeuvre des exemplaires
		for (int i=0; i<=exemplaires.size()-1; ++i){
			if((livre).equals(exemplaires.get(i).getOeuvre().getTitre())){
				 ++j;
			}else{
				j=j+0;
			}
		}
		return j;
}
	public void afficherAuteur(boolean par) {
		for (int i=1; i<=exemplaires.size()-1;++i){
			if (par==true){
				if (exemplaires.get(i).getOeuvre().getAuteur().getPrix()==true){
					System.out.println(exemplaires.get(i).getOeuvre().getAuteur().getNom());
				}
					}else {
							if (exemplaires.get(i).getOeuvre().getAuteur().getPrix()==false){
								System.out.println(exemplaires.get(i).getOeuvre().getAuteur().getNom());
						}
				}			
		}
	}
	public void afficherAuteur(){
		for (int i=1; i<=exemplaires.size()-1;++i){
			if (exemplaires.get(i).getOeuvre().getAuteur().getPrix()==true){
				System.out.println(exemplaires.get(i).getOeuvre().getAuteur().getNom());
		}
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

public class Biblio {

    public static void afficherExemplaires(ArrayList<Exemplaire> exemplaires) {
        for (Exemplaire exemplaire : exemplaires) {
            System.out.print("\t");
            exemplaire.afficher();
        }
    }

    public static void main(String[] args) {
        // create and store all the exemplaries
        Auteur a1 = new Auteur("Victor Hugo", false);
        Auteur a2 = new Auteur("Alexandre Dumas", false);
        Auteur a3 = new Auteur("Raymond Queneau", true);

        Oeuvre o1 = new Oeuvre("Les Miserables", a1, "francais");
        Oeuvre o2 = new Oeuvre("L\'Homme qui rit", a1, "francais");
        Oeuvre o3 = new Oeuvre("Le Comte de Monte-Cristo", a2, "francais");
        Oeuvre o4 = new Oeuvre("Zazie dans le metro", a3, "francais");
        Oeuvre o5 = new Oeuvre("The count of Monte-Cristo", a2, "anglais");

        Bibliotheque biblio = new Bibliotheque("municipale");
        biblio.stocker(o1, 2);
        biblio.stocker(o2);
        biblio.stocker(o3, 3);
        biblio.stocker(o4);
        biblio.stocker(o5);

        // ...
        System.out.println("La bibliotheque " + biblio.getNom() + " offre ");
        afficherExemplaires(biblio.listerExemplaires());
        String langue = "anglais";
        System.out.println("Les exemplaires en " + langue + " sont  ");
        afficherExemplaires(biblio.listerExemplaires(langue));
        System.out.println("Les auteurs a succes sont  ");
        biblio.afficherAuteur();
        System.out.print("Il y a " + biblio.compterExemplaires(o3) + " exemplaires");
        System.out.println(" de  " + o3.getTitre());
    }
}

