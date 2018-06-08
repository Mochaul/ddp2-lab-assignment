import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MapGUI extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Scanner input;


	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            FileReader fr = new FileReader("map.txt");
            input = new Scanner(fr);
            int line = 0;
            while(input.hasNextLine()){
                String textLine = input.nextLine();
                for(int n=0; n<textLine.length(); n++){
                    if(textLine.charAt(n)=='#'){
                        draw(g, n, line, Color.green, "rect");
                    }
                    else{
                        draw(g, n, line, Color.black, "rect");
                    }
                }
                line++;
            }
        }
        catch (IOException e) {

            e.printStackTrace();
        }
        draw(g, 50,30,Color.BLACK, "text");
        draw(g, 50,30,Color.black, "text2");
    }


    public void draw(Graphics g, int x, int y, Color color, String bentuk) {
        g.setColor(color);
        if(bentuk.equalsIgnoreCase("rect")) {
            g.fillRect(60+(x*10), 50+(y*12), 10, 12);
        }
        else if(bentuk.equalsIgnoreCase("oval")) g.fillOval(60+(x*10), 50+(y*12), 10, 12);
        else if(bentuk.equalsIgnoreCase("text")) {
            for(int n =0; n<10; n++){
                g.drawString(Character.toString((char)(81+n)), 60+(n*100), 37);
                for(int m=0; m<10; m++){
                    g.drawString(String.valueOf(m), 60+(n*10+m)*10, 49);
                }
            }
        }
        else if(bentuk.equalsIgnoreCase("text2")){
            for(int n =0; n<5; n++){
                g.drawString(Character.toString((char)(65+n)), 42, 61+(n*12*10));
                for(int m=0; m<10; m++){
                    g.drawString(" "+String.valueOf(m), 46, 61+(n*120)+m*12);
                }
            }
        }
    }
}
