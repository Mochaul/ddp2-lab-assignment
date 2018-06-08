import java.util.Scanner;


public class StringReversal {
    public static String reverseString(String str) 
    {     
        if ((str==null)||(str.length() <= 1) )
        {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }
    public static void main(String[] args) 
    {
        Scanner inp = new Scanner(System.in);
        while (true) {
        	System.out.print("Masukan : ");
            String input = inp.nextLine();
            System.out.println("Keluaran : " + StringReversal.reverseString(input)); 
        }   
    }    
}
