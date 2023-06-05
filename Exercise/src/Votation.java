import java.util.ArrayList;
import java.util.Random;

/*******************************************
 * Completez le programme à partir d'ici.
 *******************************************/
class Postulant {
	private String nom;
	private int nbreElecteur;
	Postulant(String name){
		nom=name;
		nbreElecteur=0;
	}
	public void elect() {nbreElecteur=nbreElecteur+1;};
	public void init() {nbreElecteur=0;};
	public int getVotes() {return nbreElecteur;};
	public String getNom() {return nom;};
}
class Scrutin  {
	private ArrayList<Vote>votes=new ArrayList<Vote>();
	private ArrayList<Postulant> p =new ArrayList<Postulant>();
	private int votantMax;
	private double votantEffectif;
	private int jourScrutin;
	public Scrutin (ArrayList<Postulant> c, int maxVotant, int jour) {
		p=c;
		votantMax=maxVotant;
		jourScrutin=jour;
		votantEffectif=0;
	}
	public void calculerVotants(){
		double t=0;
		for (int i=0; i<=p.size()-1; ++i){
			t=t+p.get(i).getVotes();
		}
		votantEffectif=t;
	}
	public void init(){
		for(Postulant c:p){
			c.init();
		}
		
	}
	public void resultats() {
		calculerVotants();
		if (votantEffectif==0){
			System.out.println("Scrutin annule, pas de votants");
		}else {
			System.out.format("Taux de participation -> %.1f", (votantEffectif/votantMax)*100);
			System.out.println (" pour cent");
			System.out.println("Nombre effectif de votants -> "+votantEffectif);
			System.out.format("Le chef choisi est -> "+gagnant().getNom());
			System.out.println();
			System.out.println();
			System.out.println("Repartition des electeurs");
			for (Postulant pos:p){
				System.out.format(pos.getNom()+" -> %.1f",(pos.getVotes()/votantEffectif)*100);
				System.out.println(" pour cent des electeurs");
			}
		}
		System.out.println();
	}
	public Postulant gagnant(){
		int k;
		int u = 0;
		Postulant t = null;
		for (int i=0; i<=p.size()-1; ++i){
			for(int j=0; j<=p.size()-1; ++j){
				u=Math.max(u, Math.max(p.get(i).getVotes(), p.get(j).getVotes()));
				}
		}
		k=u;
		for(int h=0; h<=p.size()-1; ++h){
			if(p.get(h).getVotes()==k){
				t=p.get(h);
	        }
        }
			return t;
    }
	public void compterVotes(){
		for (int v=0; v<=votes.size()-1; ++v){
			if(votes.get(v).estInvalide()==false){
				for(int j=0; j<=p.size()-1;++j){
					if(p.get(j)==votes.get(v).getPostulant()){
						p.get(j).elect();
					}
				}
				
			}
		}
	}
	public void simuler(double pourCent, int jourVote){
		double nbreVotant;
		int votant;
		nbreVotant=votantMax*pourCent;
		votant=(int)nbreVotant;
		int candNum;
		for (int i=0; i<=votant; ++i){
			candNum=Utils.randomInt(p.size());
			if(i%3==0){
				votes.add(new BulletinElectronique(p.get(candNum), jourVote, jourScrutin));
				System.out.println(new BulletinElectronique(p.get(candNum), jourVote, jourScrutin));
			}
			if(i%3==1){
				if(i%2==0){
					votes.add(new BulletinPapier(p.get(candNum), jourVote, jourScrutin, false));
					System.out.println(new BulletinPapier(p.get(candNum), jourVote, jourScrutin, false));
				}else{
					votes.add(new BulletinPapier(p.get(candNum), jourVote, jourScrutin, true));
					System.out.println(new BulletinPapier(p.get(candNum), jourVote, jourScrutin, true));
				}
			}
			if(i%3==2){
				if(i%2==0){
					votes.add(new BulletinCourrier(p.get(candNum), jourVote, jourScrutin, false));
					System.out.println(new BulletinCourrier(p.get(candNum), jourVote, jourScrutin, false));
				}else{
					votes.add(new BulletinCourrier(p.get(candNum), jourVote, jourScrutin, true));
					System.out.println(new BulletinCourrier(p.get(candNum), jourVote, jourScrutin, true));
				}
			}
		}
	}
}
abstract class Vote {
	private Postulant posChoisi;
	private int dateEffet;
	private int dateLim;
	public Vote(Postulant ind, int jVote, int dlim){
		posChoisi=ind;
		dateEffet=jVote;
		dateLim=dlim;
	}
	public abstract boolean estInvalide();
	public Postulant getPostulant(){
		return posChoisi;
	}
	public int getDate(){
		return dateEffet;
	}
	public int getDateLimite(){
		return dateLim;
	}
	public String toString(){
		if(estInvalide()){
			return "pour "+getPostulant().getNom() + " -> invalide";
		}else{
			return "pour "+getPostulant().getNom() + " -> valide";
		}
		
	}
}
class BulletinPapier extends Vote {
		private boolean signe;
		public BulletinPapier(Postulant ind, int jVote, int dlim, boolean sgn){
			super(ind, jVote, dlim);
			signe = sgn;
		}
		public boolean estInvalide(){
			return signe == false;
		}
		@Override
		public String toString(){
			if(estInvalide()){
				return "vote par bulletin papier "+super.toString();
			}else {
				return "vote par bulletin papier "+super.toString();
			}
		}
	}
interface CheckBulletin {
	public boolean checkDate();
}
class BulletinElectronique extends Vote implements CheckBulletin{
	public BulletinElectronique(Postulant ind, int jVote, int dlim){
		super(ind, jVote, dlim);
	}
	public boolean estInvalide() {
		return getDate()>getDateLimite()-2;
	}
	public boolean checkDate(){
		return getDate()<=getDateLimite()-2;
	}
	@Override
	public String toString(){
		if(estInvalide()){
			return "vote electronique "+super.toString();
		}else {
			return "vote electronique "+super.toString();
		}
	}
}
class BulletinCourrier extends BulletinPapier implements CheckBulletin {

	public BulletinCourrier(Postulant ind, int jVote, int dlim, boolean sgn) {
		super(ind, jVote, dlim, sgn);
	}
	public boolean checkDate(){
		return getDate()<=getDateLimite();
	
	}
	public boolean estInvalide(){
		return checkDate()==false || super.estInvalide();
	}
	@Override
	public String toString(){
		if(checkDate()==false){
			return "envoi par courrier d'un "+ super.toString();
		}else{
			return "envoi par courrier d'un "+ super.toString();
		}
	}
}
/*******************************************
 * Ne pas modifier les parties fournies
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/

class Utils {

    private static final Random RANDOM = new Random();

    // NE PAS UTILISER CETTE METHODE DANS LES PARTIES A COMPLETER
    public static void setSeed(long seed) {
        RANDOM.setSeed(seed);
    }

    // génère un entier entre 0 et max (max non compris)
    public static int randomInt(int max) {
        return RANDOM.nextInt(max);
    }
}

/**
 * Classe pour tester la simulation
 */

class Votation {

    public static void main(String args[]) {
        // TEST 1
        System.out.println("Test partie I:");
        System.out.println("--------------");

        ArrayList<Postulant> postulants = new ArrayList<Postulant>();
        postulants.add(new Postulant("Tarek Oxlama"));
        postulants.add(new Postulant("Nicolai Tarcozi"));
        postulants.add(new Postulant("Vlad Imirboutine"));
        postulants.add(new Postulant("Angel Anerckjel"));

        postulants.get(0).elect();
        postulants.get(0).elect();

        postulants.get(1).elect();
        postulants.get(1).elect();
        postulants.get(1).elect();

        postulants.get(2).elect();

        postulants.get(3).elect();
        postulants.get(3).elect();
        postulants.get(3).elect();
        postulants.get(3).elect();

        // 30 -> nombre maximal de votants
        // 15 jour du scrutin
        Scrutin scrutin = new Scrutin(postulants, 30, 15);
        scrutin.calculerVotants();
        scrutin.resultats();

        // FIN TEST 1

        // TEST 2
        System.out.println("Test partie II:");
        System.out.println("---------------");

        scrutin = new Scrutin(postulants, 30, 15);
        scrutin.init();
        // tous les bulletins passent le check de la date
        // les parametres de simuler sont dans l'ordre:
        // le pourcentage de votants et le jour du vote
        scrutin.simuler(0.75, 12);
        scrutin.compterVotes();
        scrutin.resultats();

        scrutin = new Scrutin(postulants, 30, 15);
        scrutin.init();
        // seuls les bulletins papier passent
        scrutin.simuler(0.75, 15);
        scrutin.compterVotes();
        scrutin.resultats();

        scrutin = new Scrutin(postulants, 30, 15);
        scrutin.init();
        // les bulletins electroniques ne passent pas
        scrutin.simuler(0.75, 15);
        scrutin.compterVotes();
        scrutin.resultats();
        //FIN TEST 2

    }
}
