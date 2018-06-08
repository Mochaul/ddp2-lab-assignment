import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panelUtama;
	private double posisiP1;
	private double posisiP2;
	private double posisiAkhirX;
	
	public Frame(double posisiP1, double posisiP2, double posisiAkhirX) {
		this.posisiP1 = posisiP1;
		this.posisiP2 = posisiP2;
		this.posisiAkhirX = posisiAkhirX;
		setSize(1000, 1000);
		setTitle("Simulasi");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createPanel();
		insertDraw();
		setVisible(true);
	}
	
	public void insertDraw() {
		Gambar gambar = new Gambar(posisiP1, posisiP2, posisiAkhirX);
		panelUtama.add(gambar);
	}

	public void createPanel() {
		panelUtama = new JPanel();
		panelUtama.setLayout(new BorderLayout());
		add(panelUtama);
	}
}
