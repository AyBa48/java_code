import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
public class TestFenetre extends JFrame{
	private Panneau pan = new Panneau();
	private Bouton bouton = new Bouton("Mon bouton");
	private JPanel container = new JPanel();
	public TestFenetre(){
		this.setTitle("Ma fenêtre Animée java");
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.setBackground(Color.gray);
		container.setLayout(new BorderLayout());
		container.add(pan, BorderLayout.CENTER);
		container.add(bouton, BorderLayout.SOUTH);
		this.setContentPane(container);
		
		//Ajout de l'objet Panneau sur la Fenetre
		//this.setContentPane(pan);
		this.setVisible(true);
		go();
	}
	private void go(){
		// les coordonnées de départ de notre rond
		int x = pan.getPosX(), y=pan.getPosY();
		//le boolean pour savoir si l'on recule ou non sur l'axex
		boolean backX = false;
		//le boolean pour savoir si l'on recule ou non sur l'axe y
		boolean backY = false;
		
		//On utilise une boucle while sans fin
		while(true){
			// Si la coordonnée x est inferieur à 1, on avance 
			if (x<1)
				backX=false;
			//Si la coordonnée x est supérieureà la taille du Panneau moins la taille du rond, on recule 
			if(x>pan.getWidth()-50)
				backX = true;
			//Idem pour l'axe y
			if(y<1)
				backY=false;
			if(y>pan.getHeight() -50)
				backY = true;
			//Si on avance, on incremente la coordonnée
			//backX est un boolean, donc !backX revient à écrire
			//if (backX== false)
			if (!backX)
				pan.setPosX(++x);
			//sinon on décremente
			else
				pan.setPosX(--x);
			if(!backY)
				pan.setPosY(++y);
			else
				pan.setPosY(--y);
		//}
		//for(int i = -50; i<pan.getWidth(); ++i){
		//	int x = pan.getPosX(), y=pan.getPosY();
		//	++x;
		//	++y;
			//pan.setPosX(x);
			//pan.setPosY(y);
			pan.repaint();
			try {
				Thread.sleep(3);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}

}
