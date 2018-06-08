import java.util.Arrays;
import java.util.Scanner;

// Mochamad Aulia Akbar Praditomo
// 1606827145
// Tugas Praktek 1
//todo : 2kk = 1 km,
public class Main {
	
	private static Scanner input;

	public static void main (String[] args) {// Main Method
		input = new Scanner(System.in); // create scanner
		System.out.println("WELCOME...");
		System.out.println("Jika tidak ada output maka input salah.");
		System.out.print("[LIGAF12]=> ");
		String firstInp = input.nextLine();
		String[] pisahStr = firstInp.split(" ");
		if (!pisahStr[0].equals("init")) {// error handling
			System.out.println("Perintah awal harus \"init = x\", silahkan jalankan ulang program.");
			System.exit(0);
		}
		if (pisahStr.length == 1) {// error handling
			System.out.println("Perintah awal harus \"init = x\", silahkan jalankan ulang program.");
			System.exit(0);
		}
		try {  
			Integer.parseInt(pisahStr[1]); 
		  }  
		  catch(NumberFormatException nfe)  
		  {  
		    System.out.print("Setelah init masukan jumlah tim yang bertanding, silahkan jalankan ulang program.");  
		    System.exit(0);
		  }  
		if (Integer.parseInt(pisahStr[1]) < 4 || Integer.parseInt(pisahStr[1]) >10){
			System.out.println("Jumlah tim hanya dari 4 sampai dengan 10, silahkan jalankan ulang program.");
			System.exit(0);
		}
		int totalTim = Integer.parseInt(pisahStr[1]);
		Game game = new Game(totalTim); // create object game
		
		while(!game.isFinished()) {// ask input while game is not finished
			System.out.print("[LIGAF12]=> ");
			String perintah = input.nextLine();
			String[] perintahPisah = perintah.split(" ");
			switch(perintahPisah[0]){
			case "nextGame": // case if input is nextGame
				if (perintahPisah.length == 1) {// if input is nextGame auto
					System.out.println(game.nextGame());
				} else if (perintahPisah[1].equals("-all")) {// if input is nextGame all
					int sisaMatch = game.getLiga().totalMatches();
					for (int i=0; i<sisaMatch; i++) {
						System.out.println(game.nextGame());
					}
					
				} else if (perintahPisah.length > 2) {// if input is nextGame manual
					String[] perintahManual = Arrays.copyOfRange(perintahPisah, 1, perintahPisah.length);
					int counterG = 0;
					for (int i = 0; i<perintahManual.length; i+=3) {
						if (perintahManual[i].equals("-g")) {
							counterG++;
						}
						if (counterG > 0) {
							System.out.println(game.nextGame(perintahManual));
							break;
						}
					}
					if (counterG == 0) {//error handling
						System.out.println("Mode manual harus ada gol.");
					}
					counterG = 0;
				} else {//error handling
					System.out.println("Perintah nextGame tidak valid.");
				}
				break;
			case "show": // case if input is show
				if (perintahPisah[1].equals("klasemen") && perintahPisah.length == 2) {// if input is show klasemen
					game.getLiga().showKlasemen();
				} else if (perintahPisah[1].equals("nextGame") && perintahPisah.length == 2) {// if input is show nextGame
					game.getLiga().showNextGame();
				} else if (perintahPisah[1].equals("pencetakGol") && perintahPisah.length == 2) {// if input is show pencetakGol
					game.getLiga().showPencetakgol();
				} else if (perintahPisah[1].equals("tim") && perintahPisah.length == 3) {// if input is show tim
					game.getLiga().showTim(perintahPisah[2]);
				} else if (perintahPisah[1].equals("pemain") && perintahPisah.length == 4) {// if input is show pemain
					game.getLiga().showPemain(perintahPisah[2], perintahPisah[3]);
				} else {
					System.out.println("Perintah show tidak valid.");
				}
				break;
			default : // error handling
				System.out.println("Perintah tidak valid silahkan ulangi perintah.");
			}
			game.cekSelesai(); // cek if the game is finished
		}
	}
}