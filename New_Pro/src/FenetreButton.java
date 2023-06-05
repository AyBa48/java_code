import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class FenetreButton extends JFrame {
	private JPanel pan = new JPanel();
	private JButton button = new JButton("Mon Bouton");
	public FenetreButton(){
		this.setTitle("Animation");
		this.setSize(300, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//Ajout du bouton à content pan
		pan.add(button);
		this.setContentPane(pan);
		this.setVisible(true);
	}

}
