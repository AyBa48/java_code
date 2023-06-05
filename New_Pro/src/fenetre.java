import javax.swing.JFrame;
public class fenetre {
	public static void main (String[] args){
		JFrame fen = new JFrame();
		//Definir un titre pour la fenetre
		fen.setTitle("Ma première fenêtre JAVA");
		//Definir la taille de la fenetre
		fen.setSize(400, 200);
		//Positionner notre objet au centre
		fen.setLocationRelativeTo(null);
		//Termine le processus lorsqu'on click sur le boutton rouge
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Rendre la fenetre visible
		fen.setVisible(true);
	}

}
