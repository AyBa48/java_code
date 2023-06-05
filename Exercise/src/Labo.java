class Souris {

    public static final int ESPERANCE_VIE_DEFAUT = 36;

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    	private int poids;
    	private int age;
    	private String couleur;
    	private  int esperanceVie;
    	private boolean clonee ;
    	public Souris(int p, String coul, int ag, int espvie) 
    	{
    		poids = p;
    		couleur = coul;
    		age = ag;
    		esperanceVie = espvie;
    		System.out.println("Une nouvelle souris !");
    	}
    	public Souris(int p, String coul, int ag) 
    	{
    		poids = p;
    		couleur = coul;
    		age = ag;
    		esperanceVie = ESPERANCE_VIE_DEFAUT;
    		System.out.println("Une nouvelle souris !");
    	}
    	public Souris(int p, String coul)
    	{
    		poids = p;
    		couleur = coul;
    		age = 0;
    		esperanceVie = ESPERANCE_VIE_DEFAUT;
    		System.out.println("Une nouvelle souris !");
    	}
    	public Souris (Souris souris)
    	{
    		poids = souris.poids;
    		couleur = souris.couleur;
    		age = souris.age;
    		esperanceVie =souris.esperanceVie * 4/5;
    		clonee = true;
    		System.out.println("Clonage d'une souris !");
    	}
    	
    	public String toString()
    	{
    		if (clonee) {
    			return "Une souris " + couleur + ", clonee, de " + age + " mois et pesant " + poids + " grammes";
    		}else {
    			return "Une souris " + couleur + " de " + age + " mois et pesant " + poids + " grammes";
    		}
    	}
    	public void vieillir ()
    	{
    		this.age = this.age + 1;
    		if (clonee ){
    			if(this.age > this.esperanceVie/2){
    				this.couleur = "verte";
    				}
    			}
    	}
    	public void evolue () {
    		do {
        		vieillir();
        	}while (this.age < esperanceVie);
    	}
    	
    } 
/*******************************************
 * Ne rien modifier après cette ligne.
 *******************************************/

public class Labo {

    public static void main(String[] args) {
        Souris s1 = new Souris(50, "blanche", 2);
        Souris s2 = new Souris(45, "grise");
        Souris s3 = new Souris(s2);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        s1.evolue();
        s2.evolue();
        s3.evolue();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
