import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton; 

public class Bouton extends JButton implements MouseListener{
	private String name;
	public Bouton(String str){
		super(str);
		this.name =str;
		//Cette instruction permettra à l'objet de s'écouter dès qu'un 
		//de la souris sera intercepté, il en sera averti
		this.addMouseListener(this);
	}
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		GradientPaint gp = new GradientPaint(0, 0, Color.blue, 0, 20, Color.cyan, true);
		g2d.setPaint(gp);
		g2d.fillRect(0,  0, this.getWidth(), this.getHeight());
		g2d.setColor(Color.white);
		g2d.drawString(this.name, this.getWidth()/2 -(this.getWidth()/2/4), (this.getHeight()/2)+5);
	}
	//Methode appelée lors du clic de la souris
	public void mouseClicked(MouseEvent event){}
	//Methode appelée lors du survol de la souris
	public void mouseEntered(MouseEvent event){}
	//Methode appelée lorsque la souris sort de la zone du bouton
	public void mouseExited(MouseEvent event){}
	//Methode appeléelorsque l'on presse le bouton gauche de la souris
	public void mousePressed (MouseEvent event){}
	//Methode appelée lorsque l'on relache le clic de la souris
	public void mouseReleased (MouseEvent event){}

}
