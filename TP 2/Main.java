import java.util.Locale;
import java.util.Scanner;

public class Main {
	private static Scanner inp;

	public static void main (String[] args) { //Main method
		inp = new Scanner(System.in); //create object scanner
		Map map = new Map(); // create object map
		boolean finished = false;
		while (!finished) {
			System.out.print(">> ");
			String input = inp.nextLine();
			String[] inputPisah = input.split("\\s+");
			switch (inputPisah[0]) {
				case "show": //case if show
					if (inputPisah[1].equals("map") && inputPisah.length == 2) {
						map.print();
					} else {
						System.out.println("Perintah tidak Valid.");
					}
					break;
				case "go": // case if go
					if (inputPisah.length == 8 && inputPisah[1].equals("from") && inputPisah[3].equals("to") && inputPisah[5].equals("with") && inputPisah[6].equals("OW-JEK") && !(inputPisah[2].equalsIgnoreCase(inputPisah[4])) && (inputPisah[7].equals("Regular") || inputPisah[7].equals("Sporty") || inputPisah[7].equals("Exclusive"))) {
						//command pathfinding
						Map mapPath = new Map();
						if(!(Pathing.checkPath(inputPisah[2], inputPisah[4], mapPath))) {
							double jarak = (Pathing.shortestPathfinder(inputPisah[2], inputPisah[4], mapPath))/10;
							System.out.println("");
							Locale.setDefault(Locale.GERMANY);
							System.out.println("Terimakasih telah melakukan perjalanan dengan Ow-Jek");
							if (inputPisah[7].equals("Regular")) {
								OwjekRegular regular = new OwjekRegular();
								System.out.printf("[Jarak] %.1f KM%n", jarak);
								System.out.println("[TipeO] Regular");
								System.out.printf("[2KMPe] Rp %.2f (+)%n", regular.hitungFirst2KmCost(jarak));
								System.out.printf("[KMSel] Rp %.2f (+)%n", regular.hitungKmSelanjutnya(jarak));
								System.out.printf("[Promo] Rp %.2f (-)%n", regular.hitungPromo(jarak, regular.hitungSementara(jarak)));
								System.out.printf("[TOTAL] Rp %.2f%n", regular.hitungTarif(jarak));
							} else if (inputPisah[7].equals("Sporty")) {
								OwjekSporty sporty = new OwjekSporty();
								System.out.printf("[Jarak] %.1f KM%n", jarak);
								System.out.println("[TipeO] Sporty");
								System.out.printf("[5KMPe] Rp %.2f (+)%n", sporty.hitungFirst5KmCost(jarak));
								System.out.printf("[KMSel] Rp %.2f (+)%n", sporty.hitungKmSelanjutnya(jarak));
								System.out.printf("[Promo] Rp %.2f (-)%n", sporty.hitungPromo(jarak, sporty.hitungSementara(jarak)));
								System.out.printf("[Prtks] Rp %.2f (+)%n", sporty.hitungProtectionCost(jarak));
								System.out.printf("[TOTAL] Rp %.2f%n", sporty.hitungTotal(jarak));
							} else {
								OwjekExclusive exclusive = new OwjekExclusive();
								System.out.printf("[Jarak] %.1f KM%n", jarak);
								System.out.println("[TipeO] Exclusive");
								System.out.println("[Fixed] Rp 10000,00 (+)");
								System.out.printf("[KMSel] Rp %.2f (+)%n", exclusive.hitungCostPerKm(jarak));
								System.out.printf("[Promo] Rp %.2f (-)%n", exclusive.hitungPromo(exclusive.hitungTarif(jarak)));
								System.out.printf("[Prtks] Rp %.2f (+)%n", exclusive.hitungProtectionCost(jarak));
								System.out.printf("[TOTAL] Rp %.2f%n", exclusive.hitungTotal(jarak));
							}
						} else {
							System.out.println("Koordinat tidak valid atau koordinat bukan jalan.");
						}
					} else {
						System.out.println("Perintah tidak Valid.");
					}
					break;
				case "exit": //case if exit
					if (inputPisah.length == 1) {
						finished = true;
						System.out.println("Program telah selesai dijalankan.");
					} else {
						System.out.println("Perintah tidak Valid.");
					}
					break;
				default: // case if input is wrong
					System.out.println("Perintah tidak valid.");
					break;
			}
		}
	}
}
