import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JRadioButton;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextArea;

public class OwJekGUI {

	private JFrame frmOwjek;
	private JTextField textField;
	private JTextField textField_1;
	private final JLabel lblOwjek = new JLabel("OW-Jek");
	private OwjekRegular regular;
	private OwjekSporty sporty;
	private OwjekExclusive exclusive;
	private String namaTipe, tempAsal, tempTujuan;
	private boolean usage;
	public PathingCoordinates startUp = new PathingCoordinates();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OwJekGUI window = new OwJekGUI();
					window.frmOwjek.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OwJekGUI() {
		MapGUI mapGUI = new MapGUI();
		initialize(mapGUI);
		lblOwjek.setForeground(Color.GREEN);
		lblOwjek.setBackground(Color.GREEN);
		lblOwjek.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblOwjek.setBounds(99, 578, 126, 36);
		frmOwjek.getContentPane().add(lblOwjek);
		
		JLabel lblCreatedBy = new JLabel("Created by : MAAP");
		lblCreatedBy.setBounds(12, 627, 115, 16);
		frmOwjek.getContentPane().add(lblCreatedBy);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MapGUI mapGUI) {
		
		frmOwjek = new JFrame();
		frmOwjek.setForeground(Color.WHITE);
		frmOwjek.setTitle("OW-Jek by MAAP");
		frmOwjek.setResizable(false);
		frmOwjek.setBounds(100, 100, 1334, 703);
		frmOwjek.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOwjek.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(0, 305, 296, 267);
		textArea.setFont(new Font("Tahoma", Font.BOLD, 18));
		textArea.setEditable(false);
		frmOwjek.getContentPane().add(textArea);
		
		textField = new JTextField();
		textField.setBackground(Color.BLACK);
		textField.setForeground(Color.WHITE);
		textField.setText("");
		textField.setBounds(12, 42, 197, 28);
		frmOwjek.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setBackground(Color.BLACK);
		textField_1.setText("");
		textField_1.setColumns(10);
		textField_1.setBounds(12, 92, 197, 28);
		frmOwjek.getContentPane().add(textField_1);
		
		JLabel lblNewLabel = new JLabel("From");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(12, 13, 56, 16);
		frmOwjek.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("To");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(12, 73, 56, 16);
		frmOwjek.getContentPane().add(lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Regular");
		rdbtnNewRadioButton.setBackground(Color.RED);
		rdbtnNewRadioButton.setBounds(26, 211, 127, 25);
		frmOwjek.getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	regular = new OwjekRegular();
	        	namaTipe = "Regular";
	        }
	    });
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Sporty");
		rdbtnNewRadioButton_1.setBackground(Color.ORANGE);
		rdbtnNewRadioButton_1.setBounds(26, 241, 127, 25);
		frmOwjek.getContentPane().add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	sporty = new OwjekSporty();
	        	namaTipe = "Sporty";
	        }
	    });
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Exclusive");
		rdbtnNewRadioButton_2.setBackground(Color.CYAN);
		rdbtnNewRadioButton_2.setBounds(26, 271, 127, 25);
		frmOwjek.getContentPane().add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	exclusive = new OwjekExclusive();
	        	namaTipe = "Exclusive";
	        }
	    });
		
		ButtonGroup tipeOwjek = new ButtonGroup();
	    tipeOwjek.add(rdbtnNewRadioButton);
	    tipeOwjek.add(rdbtnNewRadioButton_1);
	    tipeOwjek.add(rdbtnNewRadioButton_2);
	    	
		JLabel lblTipeOwjek = new JLabel("Tipe OW-Jek");
		lblTipeOwjek.setBackground(Color.BLACK);
		lblTipeOwjek.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipeOwjek.setBounds(12, 186, 88, 16);
		frmOwjek.getContentPane().add(lblTipeOwjek);
		
		JPanel panel = mapGUI;
		panel.setBounds(257, -11, 1059, 655);
		frmOwjek.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("Hitung Tarif");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(41, 137, 135, 25);
		frmOwjek.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	if (usage) {
		    		clearGUI(mapGUI);
		    		tipeOwjek.clearSelection();
		    		textArea.setText("");
		    	}
				Map map = new Map();
				if(!(Pathing.checkPath(textField.getText(), textField_1.getText(), map))) {
		    		tempAsal = textField.getText();
		    		tempTujuan = textField_1.getText();
		    		int[] koorAsal = findKoordinat(textField.getText());
                    int[] koorTujuan = findKoordinat(textField_1.getText());
                    mapGUI.draw(mapGUI.getGraphics(), koorAsal[0], koorAsal[1], Color.BLUE, "rect");
                    mapGUI.draw(mapGUI.getGraphics(), koorTujuan[0], koorTujuan[1], Color.RED, "rect");
                    ArrayList<String> koordinat = startUp.goKerja(textField.getText(), textField_1.getText());
                    for(String i : koordinat) { //mencetak titik2 yang seharusnya dilewati yang telah disimpan di array list koor
                        try {
                            Thread.sleep(50);
                            String temp[] = i.split(",");
                            mapGUI.draw(mapGUI.getGraphics(), Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Color.WHITE, "oval");
                        }
                        catch (InterruptedException ex){
                        }
                    usage = true;
                    }
                    double jarak = (Pathing.shortestPathfinder(textField.getText(), textField_1.getText(), map))/10;
                    if (namaTipe.equals("Regular")) {
                    	textArea.setText("Tarif\n\nJarak = " + jarak + "\nTipe = " + namaTipe + "\n\n2Km Pertama = Rp " + regular.hitungFirst2KmCost(jarak) + "(+)\nKM Selanjutnya = Rp " + regular.hitungKmSelanjutnya(jarak) + "(+)\nPromo = Rp " + regular.hitungPromo(jarak, regular.hitungSementara(jarak)) + "(-)\n\nTotal = Rp " + regular.hitungTarif(jarak));
                    } else if (namaTipe.equals("Sporty")) {
                    	textArea.setText("Tarif\n\nJarak = " + jarak + "\nTipe = " + namaTipe + "\n\n5Km Pertama = Rp " + sporty.hitungFirst5KmCost(jarak) + "(+)\nKM Selanjutnya = Rp " + sporty.hitungKmSelanjutnya(jarak) + "(+)\nPromo = Rp " + sporty.hitungPromo(jarak, sporty.hitungSementara(jarak)) + "(-)\nProtection = Rp " + sporty.hitungProtectionCost(jarak) + "(+)\n\nTotal = Rp " + sporty.hitungTarif(jarak));
                    } else {
                    	textArea.setText("Tarif\n\nJarak = " + jarak + "\nTipe = " + namaTipe + "\n\n5Km Pertama = Rp 10000.0" + "(+)\nKM Selanjutnya = Rp " + exclusive.hitungCostPerKm(jarak) + "(+)\nPromo = Rp " + exclusive.hitungPromo(exclusive.hitungTarif(jarak)) + "(-)\nProtection = Rp " + exclusive.hitungProtectionCost(jarak) + "(+)\n\nTotal = Rp " + exclusive.hitungTotal(jarak));
                    }
		    	} else {
		    		JOptionPane.showMessageDialog(null, "Input tidak valid.", "ERROR", JOptionPane.ERROR_MESSAGE);
		    	}
		    }
		});
		
	}
	public int[] findKoordinat(String koor){
        int koorVertikalAwal = 10*(koor.charAt(0)-65)+Integer.parseInt(koor.substring(1,2));
        int koorHorizontalAwal = 10*(koor.charAt(2)-81)+Integer.parseInt(koor.substring(3,4));
        int[] temp = {koorHorizontalAwal, koorVertikalAwal};
        return temp;
    }
	public void clearGUI(MapGUI mapGUI){
		ArrayList<String> koordinat = startUp.goKerja(tempAsal, tempTujuan);
        for(String i : koordinat) { //mencetak titik2 yang seharusnya dilewati yang telah disimpan di array list koor
                String temp[] = i.split(",");
                mapGUI.draw(mapGUI.getGraphics(), Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Color.BLACK, "oval");
        }
        int[] arrAsal = findKoordinat(tempAsal);
        int[] arrTujuan = findKoordinat(tempTujuan);
        mapGUI.draw(mapGUI.getGraphics(), arrAsal[0], arrAsal[1], Color.BLACK, "rect");
        mapGUI.draw(mapGUI.getGraphics(), arrTujuan[0], arrTujuan[1], Color.BLACK, "rect");
	}
}
