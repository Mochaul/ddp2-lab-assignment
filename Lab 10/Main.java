import javax.swing.JOptionPane;

public class Main{
	public static void main(String[] args) {
		double posisiP1 = 0;
		double posisiP2 = 0;
		double kecepatanTembak = 0;
		double sudutTembak = 0;
		double tMaks = 0;
		
		try {
			posisiP1 = Double.parseDouble(JOptionPane.showInputDialog("Masukan posisi Player 1 (meter): "));
			if (posisiP1<0 || posisiP1>1000) {
				JOptionPane.showMessageDialog(null, "Posisi harus 0 < x < 1000.", "ERROR", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Input harus berupa angka.", "ERROR", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		try{
			posisiP2 = Double.parseDouble(JOptionPane.showInputDialog("Masukan posisi Player 2 (meter): "));;
			if (posisiP2<0 || posisiP2>1000) {
				JOptionPane.showMessageDialog(null, "Posisi harus 0 < x < 1000.", "ERROR", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Input harus berupa angka.", "ERROR", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		try{
			kecepatanTembak = Double.parseDouble(JOptionPane.showInputDialog("Masukan kecepatan tembakan (m/s): "));;
			if (kecepatanTembak<0 || kecepatanTembak>1000) {
				JOptionPane.showMessageDialog(null, "Kecepatan harus 0 < x < 1000.", "ERROR", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Input harus berupa angka.", "ERROR", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		try{
			sudutTembak = Double.parseDouble(JOptionPane.showInputDialog("Masukan sudut elevasi tembakan (derajat): "));;
			if (sudutTembak<0 || sudutTembak>90) {
				JOptionPane.showMessageDialog(null, "Sudut elevasi harus 0 < x < 90.", "ERROR", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Input harus berupa angka.", "ERROR", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
			
		tMaks = 2*((kecepatanTembak*Math.sin(Math.toRadians(sudutTembak)))/9.81);
		
		for (double i = 0; i<=tMaks; i++) {
			System.out.printf("t:  %.2f detik x:   %.2f m y:   %.2f m\n", i, hitungX(kecepatanTembak,sudutTembak,i,posisiP1), hitungY(kecepatanTembak,sudutTembak,i));
		}
		System.out.printf("t:  %.2f detik x:   %.2f m y:   %.2f m\n", tMaks, hitungX(kecepatanTembak,sudutTembak,tMaks,posisiP1), hitungY(kecepatanTembak,sudutTembak,tMaks));
		
		double xMaks = hitungX(kecepatanTembak,sudutTembak,tMaks,posisiP1);
		Frame frame = new Frame(posisiP1, posisiP2, xMaks);
		
		if (Math.abs(xMaks-posisiP2)<=5) {
			JOptionPane.showMessageDialog(null, "Tembakan mengenai Player 2.");
			frame.dispose();
		} else {
			JOptionPane.showMessageDialog(null, "Tembakan tidak mengenai Player 2.");
			frame.dispose();
		}
	}
	
	public static double hitungX(double kecepatanTembak, double sudutTembak, double t, double posisiP1) {
		return ((kecepatanTembak*Math.cos(Math.toRadians(sudutTembak)))*t)+posisiP1;
	}
	
	public static double hitungY(double kecepatanTembak, double sudutTembak, double t) {
		return (kecepatanTembak*Math.sin(Math.toRadians(sudutTembak)))*t - (0.5*9.81*t*t);
	}
}
