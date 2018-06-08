import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class Gambar extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double posisiP1;
	private double posisiP2;
	private double posisiAkhirX;
	
	public Gambar(double posisiP1, double posisiP2, double posisiAkhirX) {
		this.posisiP1 = posisiP1;
		this.posisiP2 = posisiP2;
		this.posisiAkhirX = posisiAkhirX;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(Color.blue);
		g2D.fillRect((int) this.posisiP1, 700, 50, 50);
		g2D.fillOval((int) (this.posisiAkhirX), 700, 25, 25);
		g2D.setColor(Color.red);
		g2D.fillRect((int) this.posisiP2, 700, 50, 50);
	}

}