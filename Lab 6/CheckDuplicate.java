import java.util.Scanner;


public class CheckDuplicate {
	public static void main(String [] args){
		Scanner inp = new Scanner(System.in);
		while (true) {
	        System.out.print("Masukan : ");
	        String input = inp.nextLine();
	        System.out.println("Keluaran : " + checkDuplicate(input));
		}
    }

    public static boolean checkDuplicate(String s){
    	if ((s==null)||(s.length() <= 1)){
            return false;
        }
    	if (s.substring(0, 1).equalsIgnoreCase(s.substring(1, 2))) {
        	return true;
        }
        return checkDuplicate(s.substring(1));
    }
}
