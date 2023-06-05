import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
public class Panneau extends JPanel{
	private int posX = -50;
	private int posY = -50;
	public void paintComponent(Graphics gr){
		//Vous verrez cette phrase chaque fois que la methode 
		//sera invoquée
		System.out.println("Je suis executé en x= "+posX+ " y= "+posY);
		//On choisit une couleur de fond pour le rectangle
		gr.setColor(Color.gray);
		//On le dessine de sorte qu'il occupe toute la surface
		gr.fillRect(0,  0, this.getWidth(), this.getHeight());
		gr.setColor(Color.MAGENTA);
		gr.fillOval(posX, posY, 50, 50);
	}
	public int getPosX(){
		return posX;
	}
	public void setPosX(int posX){
		this.posX =posX;
	}
	public int getPosY(){
		return posY;
	}
	public void setPosY(int posY){
		this.posY = posY;
	}

}
