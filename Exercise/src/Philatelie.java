import java.util.ArrayList;

class Timbre {

    public static final int ANNEE_COURANTE = 2014;
    public static final int VALEUR_TIMBRE_DEFAUT = 1;
    public static final String PAYS_DEFAUT = "Suisse";
    public static final String CODE_DEFAUT = "lambda";

    public static final int BASE_1_EXEMPLAIRES = 100;
    public static final int BASE_2_EXEMPLAIRES = 1000;
    public static final double PRIX_BASE_1 = 600;
    public static final double PRIX_BASE_2 = 400;
    public static final double PRIX_BASE_3 = 50;

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
   private String codeTimbre;
   private int anneeEmission;
   private String paysOrigine;
   private double valeurFacial;
   private double prixDeVente;
   public Timbre(String code, int annee, String pays, double valeur)
   {
	  codeTimbre = code;
	  valeurFacial = valeur;
	  paysOrigine = pays;
	  anneeEmission=annee;
   }
   public Timbre(String code, int annee, String pays)
   {
	  codeTimbre = code;
	  valeurFacial = VALEUR_TIMBRE_DEFAUT;
	  paysOrigine = pays;
	  anneeEmission=annee;
   }
    public Timbre(int annee, String pays, double valeur)
    {
    	codeTimbre = CODE_DEFAUT;
  	  valeurFacial = valeur;
  	  paysOrigine = pays;
  	  anneeEmission=annee;
    }
    public Timbre (String code, int annee){
    	codeTimbre = code;
    	  valeurFacial = VALEUR_TIMBRE_DEFAUT;
    	  paysOrigine = PAYS_DEFAUT;
    	  anneeEmission=annee;
	}
    public Timbre(String pays, double valeur)
    {
    	codeTimbre = CODE_DEFAUT;
    	  valeurFacial = valeur;
    	  paysOrigine = pays;
    	  anneeEmission=ANNEE_COURANTE;
    }
    public Timbre(double valeur)
    {
    	codeTimbre = CODE_DEFAUT;
  	  valeurFacial = valeur;
  	  paysOrigine = PAYS_DEFAUT;
  	  anneeEmission=ANNEE_COURANTE;
    }
    public Timbre(String code)
    {
    	codeTimbre = code;
  	  valeurFacial = VALEUR_TIMBRE_DEFAUT;
  	  paysOrigine = PAYS_DEFAUT;
  	  anneeEmission=ANNEE_COURANTE;
    }
    public Timbre()
    {
    	codeTimbre = CODE_DEFAUT;
    	  valeurFacial = VALEUR_TIMBRE_DEFAUT;
    	  paysOrigine = PAYS_DEFAUT;
    	  anneeEmission=ANNEE_COURANTE;
    }
    public int age(){return ANNEE_COURANTE-anneeEmission;};
    public String getCode() {return codeTimbre;};
    public int getAnnee() {return anneeEmission;};
    public String getPays() {return paysOrigine;};
    public double getValeurFaciale() {return valeurFacial;};
    
    public double vente() 
    {
    	if (age() < 5){
    		prixDeVente = valeurFacial;
    	}else {
    		if (age() > 5){
    			prixDeVente = valeurFacial *age()*2.5;
    		}
    	}
    	return prixDeVente;
    }
    public String toString()
    {
    	return ("Timbre de code "+getCode()+" datant de "+getAnnee()+" (provenance "+ getPays()+") ayant pour valeur faciale "+getValeurFaciale()+" francs");
    }
 }
class Rare extends Timbre {
	private int nbreExemplaire;
	public Rare(String cde, int anEmission, String paysOrig, double valfacial,int nbreExplaire){
		super(cde, anEmission, paysOrig, valfacial);
		nbreExemplaire=nbreExplaire;
	}
	public Rare (int anEmission, String paysOrig, double valfacial,int nbreExplaire){
		super(anEmission, paysOrig, valfacial);
		nbreExemplaire=nbreExplaire;
	}
	public Rare (String cde, int anEmission, String paysOrig, int nbreExplaire)
	   {
		super(cde, anEmission, paysOrig);
		nbreExemplaire=nbreExplaire;
	   }
	public Rare (String paysOrig, double valfacial,int nbreExplaire){
		super(paysOrig, valfacial);
		nbreExemplaire=nbreExplaire;
	}
	public Rare (String cde, int anEmission, int nbreExplaire){
		super(cde, anEmission);
		nbreExemplaire=nbreExplaire;
	}
	public Rare (double valfacial,int nbreExplaire){
		super(valfacial);
		nbreExemplaire=nbreExplaire;
	}
	public Rare (String cde,int nbreExplaire){
		super(cde);
		nbreExemplaire=nbreExplaire;
	}
	public Rare (int nbrExplaire){
		super();
		nbreExemplaire=nbrExplaire;
	}
	public double vente(){
		double prixVente =0;
		if (getExemplaires() <= BASE_1_EXEMPLAIRES){
			prixVente = PRIX_BASE_1 * super.age()/10;
			return prixVente;
		}
		if(getExemplaires() > BASE_1_EXEMPLAIRES && getExemplaires()<BASE_2_EXEMPLAIRES){
			prixVente = PRIX_BASE_2 * super.age()/10;
			return prixVente;
		}
		if (getExemplaires() >= BASE_2_EXEMPLAIRES){
			prixVente = PRIX_BASE_3 * super.age()/10;
			return prixVente;
		}
		return prixVente;
	}
	public int getExemplaires() {return nbreExemplaire;};
	public String toString() {
		return super.toString() + "\n"+ " Nombre d'exemplaires -> " + getExemplaires();
	}
}
class Commemoratif extends Timbre {
	public Commemoratif(String cde, int anEmission, String paysOrig, double valfacial){
		super(cde, anEmission, paysOrig, valfacial);
	}
	public Commemoratif (String cde, int anEmission, String paysOrig)
	   {
		super(cde, anEmission, paysOrig);
	   }
	public Commemoratif (int anEmission, String paysOrig, double valfacial){
		super(anEmission, paysOrig, valfacial);
	}
	public Commemoratif (String cde, int anEmission){
		super(cde, anEmission);
	}
	public Commemoratif (String paysOrig, double valfacial){
		super(paysOrig, valfacial);
		
	}
	public Commemoratif (double valfacial){
		super(valfacial);
    }
	public Commemoratif (String cde){
		super(cde);
    }
	public Commemoratif (){
		super();
    }
	public double vente() {
		return super.vente()*2;
	}
	public String toString() {
		return super.toString() + "\n"+ " Timbre celebrant un evenement.";
	}
}
/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/

class Philatelie {

    public static void main(String[] args) {

        // ordre des parametres: nom, annee d'emission, pays, valeur faciale,
        // nombre d'exemplaires
        Rare t1 = new Rare("Guarana-4574", 1960, "Mexique", 0.2, 98);

        // ordre des parametres: nom, annee d'emission, pays, valeur faciale
        Commemoratif t2 = new Commemoratif("700eme-501", 2002, "Suisse", 1.5);
        Timbre t3 = new Timbre("Setchuan-302", 2004, "Chine", 0.2);

        Rare t4 = new Rare("Yoddle-201", 1916, "Suisse", 0.8, 3);


        ArrayList<Timbre> collection = new ArrayList<Timbre>();

        collection.add(t1);
        collection.add(t2);
        collection.add(t3);
        collection.add(t4);

        for (Timbre timbre : collection) {
            System.out.println(timbre);
            System.out.println("Prix vente : " + timbre.vente() + " francs");
            System.out.println();
        }
    }
}

