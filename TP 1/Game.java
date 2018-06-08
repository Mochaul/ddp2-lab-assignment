import java.util.Random;

public class Game {
	// instance variables
	private Boolean finished = false;
	private Liga liga;
	
	public Game(int totalTim){// Game constructor
		this.liga = new Liga(totalTim);
	}
	
	public void cekSelesai() {// method to cek if the game is finished
		if (Liga.getPertandinganSelesai() + liga.totalMatches() == Liga.getPertandinganSelesai()) {
			this.finished = true;
		}
		if (this.finished == true) {
			System.out.println("LIGA FASILKOM MUSIM INI TELAH USAI\n");
			System.out.println("CHAMPION : " + liga.getArrayTim()[0].getNamaTim() + "\n\n");
			liga.showKlasemen();
			liga.showPencetakgol();
			System.out.println("\n\n GOODBYE...");
			
		}
	}
	// setter, getter
	public Liga getLiga(){
		return this.liga;
	}

	public Boolean isFinished() {
		return this.finished;
	}
	
	public void setFinished(Boolean finished) {
		this.finished = finished;
	}
	
	public void sortKlasemen() {// method to sort klasemen
		for (int i = liga.getArrayTimSorted().length-1; i>=0; i--) {
			boolean swapped = false;
			for (int j = 0; j<i; j++) {
				if(liga.getArrayTimSorted()[j].getJumlahPoin() < liga.getArrayTimSorted()[j+1].getJumlahPoin() || ((liga.getArrayTimSorted()[j].getJumlahPoin() == liga.getArrayTimSorted()[j+1].getJumlahPoin()) && (liga.getArrayTimSorted()[j].selisihGol() < liga.getArrayTimSorted()[j+1].selisihGol()))) {
					Tim T = liga.getArrayTimSorted()[j];
					liga.getArrayTimSorted()[j] = liga.getArrayTimSorted()[j+1];
					liga.getArrayTimSorted()[j+1] = T;
					swapped = true;
				}
			}
			if (!swapped) {
				return;
			}
		}
	}
	
	public String nextGame() {// method for auto nextGame
		StringBuilder build = new StringBuilder();
		Random random = new Random();
		
		build.append(liga.jadwalSelanjutnya() + "\n\n");
		Tim A = this.liga.getArrayTim()[Liga.getCounterSusun1()];
		Tim B = this.liga.getArrayTim()[Liga.getCounterSusun2()];
		
		int randomGol = random.nextInt(5);
		int randomIdxPemain = 0;
		A.setJumlahGol(A.getJumlahGol()+randomGol);
		for (int i = 0; i<randomGol;i++) {
			randomIdxPemain = random.nextInt(4);
			A.getArrayPemain()[randomIdxPemain].addJumlahGol();
		}
		
		int randomKK = random.nextInt(3);
		boolean[] pemainKK = new boolean[5];
		for (int i=0; i<randomKK; i++) {
			randomIdxPemain = random.nextInt(4);
			A.getArrayPemain()[randomIdxPemain].addJumlahKartuKuning();
			if (pemainKK[randomIdxPemain]) {
				A.getArrayPemain()[randomIdxPemain].addJumlahKartuMerah();
				pemainKK[randomIdxPemain] = false;
			}else {
				pemainKK[randomIdxPemain] = true;
			}
			A.getArrayPemain()[randomIdxPemain].addJumlahPelanggaran();
		}
		
		int randomKM = random.nextInt(2);
		for (int i=0; i<randomKM; i++) {
			randomIdxPemain = random.nextInt(4);
			A.getArrayPemain()[randomIdxPemain].addJumlahKartuMerah();
			A.getArrayPemain()[randomIdxPemain].addJumlahPelanggaran();
		}
		
		int randomP = random.nextInt(5);
		for (int i=0; i<randomP; i++) {
			A.getArrayPemain()[random.nextInt(4)].addJumlahPelanggaran();
		}
		
		int randomGolB = random.nextInt(5);
		B.setJumlahGol(B.getJumlahGol()+randomGolB);
		for (int i = 0; i<randomGolB;i++) {
			B.getArrayPemain()[random.nextInt(4)].addJumlahGol();
		}
		
		int randomKKB = random.nextInt(3);
		boolean[] pemainKKB = new boolean[5];
		for (int i=0; i<randomKKB; i++) {
			randomIdxPemain = random.nextInt(4);
			B.getArrayPemain()[randomIdxPemain].addJumlahKartuKuning();
			if (pemainKKB[randomIdxPemain]) {
				B.getArrayPemain()[randomIdxPemain].addJumlahKartuMerah();
				pemainKKB[randomIdxPemain] = false;
			}else {
				pemainKKB[randomIdxPemain] = true;
			}
			B.getArrayPemain()[randomIdxPemain].addJumlahPelanggaran();
		}
		
		int randomKMB = random.nextInt(2);
		for (int i=0; i<randomKMB; i++) {
			randomIdxPemain = random.nextInt(4);
			B.getArrayPemain()[randomIdxPemain].addJumlahKartuMerah();
			B.getArrayPemain()[randomIdxPemain].addJumlahPelanggaran();
		}
		
		int randomPB = random.nextInt(5);
		for (int i=0; i<randomPB; i++) {
			B.getArrayPemain()[random.nextInt(4)].addJumlahPelanggaran();
		}
		B.setJumlahKebobolan(B.getJumlahKebobolan() + randomGol);
		A.setJumlahKebobolan(A.getJumlahKebobolan() + randomGolB);
		if (randomGol > randomGolB) {
			A.addJumlahMenang();
			B.addJumlahKalah();
			A.addJumlahPoin(3);
		} else if (randomGol < randomGolB) {
			A.addJumlahKalah();
			B.addJumlahMenang();
			B.addJumlahPoin(3);
		} else {
			A.addJumlahSeri();
			B.addJumlahSeri();
			A.addJumlahPoin(1);
			B.addJumlahPoin(1);
		}
		liga.sortTopScorer();
		this.sortKlasemen();

		int totalP = randomP + randomKK + randomKM;
		int totalPB = randomPB + randomKKB + randomKMB;
		
		build.append("Tim : " + A.getNamaTim() + "\n");
		build.append("Gol : " + randomGol + "\n");
		build.append("Pelanggaran : " + totalP + "\n");
		build.append("Kartu Kuning : " + randomKK + "\n");
		build.append("Kartu Merah : " + randomKM + "\n\n");
		
		build.append("Tim : " + B.getNamaTim() + "\n");
		build.append("Gol : " + randomGolB + "\n");
		build.append("Pelanggaran : " + totalPB + "\n");
		build.append("Kartu Kuning : " + randomKKB + "\n");
		build.append("Kartu Merah : " + randomKMB + "\n");
		return build.toString();
	}
	
	public String nextGame(String[] perintah) {// method for manual nextGame
		StringBuilder build = new StringBuilder();
		build.append(liga.jadwalSelanjutnya() + "\n\n");
		Tim A = this.liga.getArrayTim()[Liga.getCounterSusun1()];
		Tim B = this.liga.getArrayTim()[Liga.getCounterSusun2()];
		int i2 = 1;
		int i3 = 2;
		int counterGolA = 0;
		int counterGolB = 0;
		int counterKKA = 0;
		int counterKKB = 0;
		int counterKMA = 0;
		int counterKMB = 0;
		int counterPA = 0;
		int counterPB = 0;
		counterGolA = 0;
		counterGolB = 0;
		counterKKA = 0;
		counterKKB = 0;
		counterKMA = 0;
		counterKMB = 0;
		counterPA = 0;
		counterPB = 0;
		for (int i = 0; i<perintah.length; i+=3) {
			if (A.getNamaTim().equals(perintah[i2])) {
				if (perintah[i].equals("-g")) {
					counterGolA++;
					A.setJumlahGol(A.getJumlahGol()+1);
					for (Pemain pemain : A.getArrayPemain()) {
						if (Integer.parseInt(perintah[i3]) == (pemain.getNomorPemain())) {
							pemain.addJumlahGol();
						}
					}
				} else if (perintah[i].equals("-kk")) {
					counterKKA++;
					counterPA++;
					for (Pemain pemain : A.getArrayPemain()) {
						if (Integer.parseInt(perintah[i3]) == (pemain.getNomorPemain())) {
							pemain.addJumlahKartuKuning2();
							pemain.addJumlahPelanggaran();
							if (pemain.getTotalKK() == 2) {
								counterKMA++;
								pemain.addJumlahKartuMerah();
								pemain.setTotalKK(0);
							}
						}
					}
					
				} else if (perintah[i].equals("-km")) {
					counterKMA++;
					counterPA++;
					for (Pemain pemain : A.getArrayPemain()) {
						if (Integer.parseInt(perintah[i3]) == (pemain.getNomorPemain())) {
							pemain.addJumlahKartuMerah();
							pemain.addJumlahPelanggaran();
						}
					}
				} else if (perintah[i].equals("-p")) {
					counterPA++;
					for (Pemain pemain : A.getArrayPemain()) {
						if (Integer.parseInt(perintah[i3]) == (pemain.getNomorPemain())) {
							pemain.addJumlahPelanggaran();
						}
					}
				}
			} else if (B.getNamaTim().equals(perintah[i2])) {
				if (perintah[i].equals("-g")) {
					counterGolB++;
					B.setJumlahGol(B.getJumlahGol()+1);
					for (Pemain pemain : B.getArrayPemain()) {
						if (Integer.parseInt(perintah[i3]) == (pemain.getNomorPemain())) {
							pemain.addJumlahGol();
						}
					}
				} else if (perintah[i].equals("-kk")) {
					counterKKB++;
					counterPB++;
					for (Pemain pemain : B.getArrayPemain()) {
						if (Integer.parseInt(perintah[i3]) == (pemain.getNomorPemain())) {
							pemain.addJumlahKartuKuning2();
							pemain.addJumlahPelanggaran();
							if (pemain.getTotalKK() == 2) {
								counterKMB++;
								pemain.addJumlahKartuMerah();
								pemain.setTotalKK(0);
							}
						}
					}
					
				} else if (perintah[i].equals("-km")) {
					counterKMB++;
					counterPB++;
					for (Pemain pemain : B.getArrayPemain()) {
						if (Integer.parseInt(perintah[i3]) == (pemain.getNomorPemain())) {
							pemain.addJumlahKartuMerah();
							pemain.addJumlahPelanggaran();
						}
					}
				} else if (perintah[i].equals("-p")) {
					counterPB++;
					for (Pemain pemain : B.getArrayPemain()) {
						if (Integer.parseInt(perintah[i3]) == (pemain.getNomorPemain())) {
							pemain.addJumlahPelanggaran();
						}
					}
				}
			
			}else {
				return "Tim tidak bertanding hari ini.";
			}
			i2 += 3;
			i3 += 3;
		}
		B.setJumlahKebobolan(B.getJumlahKebobolan() + counterGolA);
		A.setJumlahKebobolan(A.getJumlahKebobolan() + counterGolB);
		if (counterGolA > counterGolB) {
			A.addJumlahMenang();
			B.addJumlahKalah();
			A.addJumlahPoin(3);
		} else if (counterGolA < counterGolB) {
			A.addJumlahKalah();
			B.addJumlahMenang();
			B.addJumlahPoin(3);
		} else {
			A.addJumlahSeri();
			B.addJumlahSeri();
			A.addJumlahPoin(1);
			B.addJumlahPoin(1);
		}
		liga.sortTopScorer();
		this.sortKlasemen();
		
		build.append("Tim : " + A.getNamaTim() + "\n");
		build.append("Gol : " + counterGolA + "\n");
		build.append("Pelanggaran : " + counterPA + "\n");
		build.append("Kartu Kuning : " + counterKKA + "\n");
		build.append("Kartu Merah : " + counterKMA + "\n\n");
		
		build.append("Tim : " + B.getNamaTim() + "\n");
		build.append("Gol : " + counterGolB + "\n");
		build.append("Pelanggaran : " + counterPB + "\n");
		build.append("Kartu Kuning : " + counterKKB + "\n");
		build.append("Kartu Merah : " + counterKMB + "\n");
		return build.toString();
	}
}
