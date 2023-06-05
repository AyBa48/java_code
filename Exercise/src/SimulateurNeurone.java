import java.util.ArrayList;

/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
class Position {
	private double x;
	private double y;
	public Position (double coordX, double coordY){
		x=coordX;
		y=coordY;
	}
	public Position (){
		x=0.;
		y=0.;
	}
	public double getX() {return x;};
	public double getY() {return y;};
	public String toString (){
		return "("+x+", "+y+")";
	}
}
class Neurone {
	private Position position;
	protected double signalInterne;
	protected double facteurAttenuation;
	protected ArrayList<Neurone>connexions=new ArrayList<Neurone>();
	public Neurone(Position p, double atten){
		position =p;
		facteurAttenuation=atten;
		signalInterne=0;
	}
	public void connexion(Neurone n){
		connexions.add(n);};
	public int getNbConnexions(){
		return connexions.size();};
	public Neurone getConnexion (int index){
		return connexions.get(index);};
	public Position getPosition(){
		return position;};
	public double getAttenuation() {
		return facteurAttenuation;};
	public double getSignal(){
		return signalInterne;};
	public void recoitStimulus(double stimulus){
		signalInterne=stimulus*facteurAttenuation;
		for (int i=0; i<=getNbConnexions()-1; ++i) {
			getConnexion(i).recoitStimulus(signalInterne);
			//getConnexion(i).signalInterne = signalInterne;//
			//getConnexion(i).signalInterne=(signalInterne*getConnexion(i).facteurAttenuation);
			//if(i==0){
			//	getConnexion(i).getConnexion(i).signalInterne=getConnexion(i).signalInterne*getConnexion(i).getConnexion(i).getAttenuation();
			//}
			//if(getNbConnexions()>=1 && i==1){
			//	getConnexion(1).signalInterne=getConnexion(0).signalInterne+getConnexion(1).signalInterne;
			//	getConnexion(i).getConnexion(i-1).signalInterne=getConnexion(1).signalInterne*getConnexion(1).getConnexion(0).getAttenuation();
			//}
			//if(i>1){
				//getConnexion(i).getConnexion(i-1).signalInterne=getConnexion(i).signalInterne*getConnexion(i).getConnexion(i-1).getAttenuation();
			//}
		}
	}
	@Override
	public String toString() {
		String t="";
		if(connexions.size()>0){
			for (int i=0; i<=getNbConnexions()-1; ++i){
				t=t+"Le neurone en position "+getPosition()+" avec attenuation "+getAttenuation()+" en connexion avec"+"\n"+
			"- un neurone en position "+getConnexion(i).getPosition()+"\n";
			}
			return t; 
		}
		if(connexions.size()<=1){
			return t=t+"Le neurone en position "+getPosition()+" avec attenuation "+getAttenuation()+ " sans connexion\n";
		}else {
			return " sans connexion\n";
		}	
	}
}
class NeuroneCumulatif extends Neurone {
	public NeuroneCumulatif (Position coord, double attenu){
		super(coord, attenu);
	}
	public void recoitStimulus(double stimulus){
		//signalInterne = signalInterne + stimulus * facteurAttenuation;
		super.recoitStimulus((signalInterne + stimulus * facteurAttenuation)/facteurAttenuation);
		}
	}
class Cerveau {
	private ArrayList<Neurone>nEcerveau=new ArrayList<Neurone>();
	private ArrayList<NeuroneCumulatif>cerveau=new ArrayList<NeuroneCumulatif>();
	public int getNbNeurones(){
		return nEcerveau.size();
	}
	public Neurone getNeurone(int index){
		return nEcerveau.get(index);
	}
	public void ajouterNeurone(Position pos, double attenuation){
		nEcerveau.add(new Neurone(pos, attenuation));
		cerveau.add(null);
	}
	public void ajouterNeuroneCumulatif(Position pos, double attenuation){
		nEcerveau.add(new NeuroneCumulatif(pos, attenuation));
		cerveau.add(new NeuroneCumulatif(pos, attenuation));
	}
	public void stimuler(int index, double stimulus){
		if(cerveau.get(index)==null){
			getNeurone(index).recoitStimulus(stimulus);
			//getNeurone(0).getConnexion(1).signalInterne+=getNeurone(0).getConnexion(0).signalInterne;;
	    }
		if(cerveau.get(index)!=null){
			cerveau.get(index).recoitStimulus(stimulus);
		}
		//for(int j=0; j<cerveau.size()-1;++j){
		//	if(cerveau.get(j)!=null){
		//		cerveau.get(j).recoitStimulus(stimulus);
			//	cerveau.get(j+1).recoitStimulus(cerveau.get(j).signalInterne);
			//	if(j==index){
			//		cerveau.get(index).signalInterne=getNeurone(index).signalInterne;
			//		cerveau.get(index+1).signalInterne=getNeurone(index+1).signalInterne;
			//	}
	       // }
	    // }
	}
	public double sonder(int index){
		return getNeurone(index).getSignal();
	}
	public void creerConnexions(){
		 try {
				getNeurone(0).connexion(getNeurone(1));
				getNeurone(0).connexion(getNeurone(2));
				for (int i=1; i<getNbNeurones()-2;i+=2){
					getNeurone(i).connexion(getNeurone(i+1));
					getNeurone(i+1).connexion(getNeurone(i+2));
				}
			}
			catch (Exception e){
			}
		//try{
		//if(getNbNeurones()>=1){
		//	getNeurone(0).connexion(getNeurone(1));
		//	getNeurone(0).connexion(getNeurone(2));
		//}
		//if(getNbNeurones()<=1){
		//	getNeurone(0).connexion(getNeurone(1));
		//}
		
		//	if(getNbNeurones()<=0)
		//	{throw new Exception();}	
		//	for (int i=0; i<getNbNeurones()-2; ++i){
		//		if (i%2!=0){
			//		getNeurone(i).connexion(getNeurone(i+1));
				//	getNeurone(i+1).connexion(getNeurone(i+2));
			//	}
			//}
		//}
		//catch (Exception e){
			//System.out.println("Le cerveau contient 0 neurone(s)");
		//}
		
	}
	public String toString(){
		String y="";
		System.out.println();
		System.out.println();
		System.out.println("*----------*");
		System.out.println();
		System.out.println();
		if(getNbNeurones()>0){
			System.out.println("Le cerveau contient "+getNbNeurones()+ " neurone(s)");
	    }//else{
		//	if(getNbNeurones()==0){
		//		System.out.println("Le cerveau contient 0 neurone(s)");
		//	}
			
		//}
		
		for(int i=0; i<=getNbNeurones()-1; ++i){
			if(i==0){
				y=y+"Le neurone en position "+getNeurone(0).getPosition()+" avec attenuation "+getNeurone(0).getAttenuation()+" en connexion avec"+"\n"+
						"- un neurone en position "+getNeurone(0).getConnexion(0).getPosition()+"\n"+
				        "- un neurone en position "+getNeurone(0).getConnexion(1).getPosition()+"\n";
			}
			if (i==getNbNeurones()-1){
				y=y+"Le neurone en position "+getNeurone(i).getPosition()+" avec attenuation "+getNeurone(i).getAttenuation()+" sans connexion"+"\n";
			}
			if(i>=1&&i<getNbNeurones()-1){
				y=y+"Le neurone en position "+getNeurone(i).getPosition()+" avec attenuation "+getNeurone(i).getAttenuation()+" en connexion avec"+"\n"+
						"- un neurone en position "+getNeurone(i).getConnexion(0).getPosition()+"\n";	
				}
		}
		return y + "\n" + "*----------*"+ "\n"+ "\n";
	}
}
/*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/
public class SimulateurNeurone {

    public static void main(String[] args) {
        // TEST DE LA PARTIE 1
        System.out.println("Test de la partie 1:");
        System.out.println("--------------------");

        Position position1 = new Position(0, 1);
        Position position2 = new Position(1, 0);
        Position position3 = new Position(1, 1);

        Neurone neuron1 = new Neurone(position1, 0.5);
        Neurone neuron2 = new Neurone(position2, 1.0);
        Neurone neuron3 = new Neurone(position3, 2.0);

        neuron1.connexion(neuron2);
        neuron2.connexion(neuron3);
        neuron1.recoitStimulus(10);

        System.out.println("Signaux : ");
        System.out.println(neuron1.getSignal());
        System.out.println(neuron2.getSignal());
        System.out.println(neuron3.getSignal());

        System.out.println();
        System.out.println("Premiere connexion du neurone 1");
        System.out.println(neuron1.getConnexion(0));


        // FIN TEST DE LA PARTIE 1

        // TEST DE LA PARTIE 2
        System.out.println("Test de la partie 2:");
        System.out.println("--------------------");

        Position position5 = new Position(0, 0);
        NeuroneCumulatif neuron5 = new NeuroneCumulatif(position5, 0.5);
        neuron5.recoitStimulus(10);
        neuron5.recoitStimulus(10);
        System.out.println("Signal du neurone cumulatif  -> " + neuron5.getSignal());

        // FIN TEST DE LA PARTIE 2

        // TEST DE LA PARTIE 3
        System.out.println();
        System.out.println("Test de la partie 3:");
        System.out.println("--------------------");
        Cerveau cerveau = new Cerveau();

        // parametres de construction du neurone:
        // la  position et le facteur d'attenuation
        cerveau.ajouterNeurone(new Position(0,0), 0.5);
        cerveau.ajouterNeurone(new Position(0,1), 0.2);
        cerveau.ajouterNeurone(new Position(1,0), 1.0);

        // parametres de construction du neurone cumulatif:
        // la  position et le facteur d'attenuation
        cerveau.ajouterNeuroneCumulatif(new Position(1,1), 0.8);
        cerveau.creerConnexions();
        cerveau.stimuler(0, 10);

        System.out.println("Signal du 3eme neurone -> " + cerveau.sonder(3));
        System.out.println(cerveau);
        // FIN TEST DE LA PARTIE 3
    }
}
