
public class Ville {
	protected String nomVille;
	private String nomPays;
	private int nbreHabitants;
	private char categorie;
	public static int nbreInstance=0;
	private static int nbreInstanceBis=0;
	public Ville(){
		System.out.println("Création d'une ville !");
		nomVille= "Inconnu";
		nomPays= "Inconnu";
		nbreHabitants = 0;
		this.setCategorie();
		nbreInstance++;
		nbreInstanceBis++;
	}
	public Ville(String pNom, int pNbre, String pPays){
		System.out.println("Création d'une ville avec des paramètres!");
		nomVille = pNom;
		nomPays = pPays;
		nbreHabitants = pNbre;
		this.setCategorie();
		nbreInstance++;
		nbreInstanceBis++;
	}
	//Permet d'acceder au variable d'instance//
	public String getNom(){
		return nomVille;
	}
	public String getPays(){
		return nomPays;
	}
	public int getNombreHabitants(){
		return nbreHabitants;
	}
    //Permet de modifier les variables d'instances
	public void setNom(String pNom){
		nomVille = pNom;
	}
	public void setnomPays (String pPays){
		nomPays = pPays;
	}
	public void setNombreHabitants (int nbre){
		nbreHabitants = nbre;
		this.setCategorie();
	}
	public char getCategorie(){
		return categorie;
	}
	public static int getNbreInstanceBis(){
		return nbreInstanceBis;
	}
	private void setCategorie(){
		int borneSuperieur[] = {0, 1000, 10000, 100000, 500000, 1000000, 5000000, 1000000};
		char categories[] = {'?', 'A', 'B', 'C', 'D', 'E', 'F','G', 'H'};
		int i = 0;
		while(i<borneSuperieur.length && this.nbreHabitants>borneSuperieur[i])
			++i;
		this.categorie=categories[i];
	}
	//Description de la ville
	public String decrisToi(){
		return "\t"+this.nomVille+" est une ville de "+this.nomPays+ ", elle comporte : "+this.nbreHabitants+" habitant(s) => elle est donc "
				+ "de catégorie : "+this.categorie;
	}
	//Retourne resultat comparaison ville
	public String comparer (Ville v1){
		String str=new String();
		if (v1.getNombreHabitants()>this.nbreHabitants/*peut etre remplacé par getNombreHabitants()*/){
			str=v1.getNom()+" est une ville plus peuplée que "+getNom();//this.nomVille;
		}else{
			str=this.nomVille+" est une ville plus peuplée que "+v1.getNom();
		}
		return str;
	}
	public String toString(){
		return "\t"+this.nomVille+" est une ville de "+this.nomPays+ ", elle comporte : "+this.nbreHabitants+" habitant(s) => elle est donc "
				+ "de catégorie : "+this.categorie;
	}
}
