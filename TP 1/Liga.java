import java.util.Arrays;

public class Liga {	
	// Instance variables
	private Integer banyakTim;
	private Tim[] arrayTim;
	private static Tim[] roundRobin;
	private Tim[] arrayTimSorted;
	private Pemain[] topScorer;
	private static int counterSusun1 = 0, counterSusun2 =0;
	private static int pertandinganSelesai = 0;
	
	// Constructor Liga
	public Liga(Integer banyakTim){
		this.banyakTim = banyakTim;
		this.arrayTim = new Tim[this.banyakTim];
		for(int i = 0; i<this.banyakTim; i++) {
			Tim tim = new Tim();
			this.arrayTim[i] = tim;
		}
		this.arrayTimSorted = Arrays.copyOf(this.arrayTim, this.arrayTim.length);
		this.topScorer = this.makeTopScorer();
	}
	public Pemain[] makeTopScorer() {// Method membuat array topscorer
		Pemain[] topScorer = new Pemain[getBanyakTim()*5];
		int totalPemain = 0;
		for (int i = 0; i < getBanyakTim(); i++) {
			for (int j = 0; j < getArrayTim()[i].getArrayPemain().length; j++) {
				topScorer[totalPemain] = getArrayTim()[i].getArrayPemain()[j];
				totalPemain++;
			}
		}
		return topScorer;
	}
	public void sortTopScorer() {// Method sorting array topscorer
		for (int i = this.topScorer.length-1; i>=0; i--) {
			boolean swapped = false;
			for (int j = 0; j<i; j++) {
				if(this.topScorer[j].getJumlahGol() < this.topScorer[j+1].getJumlahGol()) {
					Pemain P = this.topScorer[j];
					this.topScorer[j] = this.topScorer[j+1];
					this.topScorer[j+1] = P;
					swapped = true;
				}
			}
			if (!swapped) {
				return;
			}
		}
	}
	public void showKlasemen() {// Method memperlihatkan klasemen
		System.out.println(" Peringkat |      Nama Tim      |   Jumlah Gol\t| Jumlah Kebobolan | Menang | Kalah | Seri | Poin");
		System.out.println("-------------------------------------------------------------------------------------------------");
		Tim[] tim = this.getArrayTimSorted();
		for (int i = 0; i<tim.length; i++) {
			System.out.println("     " + (i+1) + "\t   |   " + tim[i].getNamaTim() + "\t\t|       "+ tim[i].getJumlahGol() + "  \t|\t  "+tim[i].getJumlahKebobolan() + "        |    "+tim[i].getJumlahMenang() + "   |   " + tim[i].getJumlahKalah() + "   |   " + tim[i].getJumlahSeri() + "  |   " + tim[i].getJumlahPoin());
		}
	}
	
	public void showPencetakgol() {// Method memperlihatkan topScorer
		System.out.println("Peringkat | Nama Pemain |  Nama Tim  | Jumlah Gol");
		System.out.println("-------------------------------------------------");
		for (int i = 0; i<10; i++) {
			System.out.printf("    %-6d|    %-9s|    %-8s|    %-6s\n", i+1, this.topScorer[i].getNamaPemain(), this.topScorer[i].getNamaTim(), this.topScorer[i].getJumlahGol());
		}
	}
	
	public void showPemain(String namaTim, String nomorNamaPemain) {// Method memperlihatkan pemain
		for (Tim tim : this.getArrayTim()) {
			if (tim.getNamaTim().equals(namaTim)) {
				for (Pemain pemain : tim.getArrayPemain()) {
					if (pemain.getNamaPemain().equals(nomorNamaPemain)) {
						System.out.println("Nomor : " + pemain.getNomorPemain());
						System.out.println("Nama : " + pemain.getNamaPemain());
						System.out.println("Gol : " + pemain.getJumlahGol());
						System.out.println("Pelanggaran : " + pemain.getJumlahPelanggaran());
						System.out.println("Kartu Kuning : " + pemain.getJumlahKartuKuning());
						System.out.println("Kartu Merah : " + pemain.getJumlahKartuMerah());
					} try {
						int nomorPemain = Integer.parseInt(nomorNamaPemain);
						if (pemain.getNomorPemain() == nomorPemain){
							System.out.println("Nomor : " + pemain.getNomorPemain());
							System.out.println("Nama : " + pemain.getNamaPemain());
							System.out.println("Gol : " + pemain.getJumlahGol());
							System.out.println("Pelanggaran : " + pemain.getJumlahPelanggaran());
							System.out.println("Kartu Kuning : " + pemain.getJumlahKartuKuning());
							System.out.println("Kartu Merah : " + pemain.getJumlahKartuMerah());
						}
					} catch(NumberFormatException nfe) {}
				}
			} 
		}
	}
	
	public void showTim(String namaTim) {// Method memperlihatkan tim
		System.out.println("  Nomor |      Nama     | Gol | Pelanggaran | Kartu Kuning | Kartu Merah");
		System.out.println("------------------------------------------------------------------------");
		for (Tim tim : this.getArrayTim()) {
			if (tim.getNamaTim().equals(namaTim)) {
				for (Pemain pemain : tim.getArrayPemain()) {
					System.out.println("  " + pemain.getNomorPemain() + "\t|     " + pemain.getNamaPemain() + "\t|  " + pemain.getJumlahGol() + "  |      " + pemain.getJumlahPelanggaran() + "      |       " + pemain.getJumlahKartuKuning() + "      |     " + pemain.getJumlahKartuMerah());
				}
			}
		}
	}
	
	public void showNextGame() {// Method memperlihatkan game selanjutnya
		int tmp = 0;
		counterSusun2++;
		if(counterSusun2 == this.banyakTim) {
			tmp = counterSusun2;
			counterSusun1++;
			counterSusun2 = counterSusun1 + 1;
		}
		System.out.println(this.arrayTim[counterSusun1].getNamaTim() + " VS " + this.arrayTim[counterSusun2].getNamaTim());
		if(tmp == this.banyakTim) {
			counterSusun1--;
			counterSusun2 = tmp;
		}
		counterSusun2--;
	}
	
	public String jadwalSelanjutnya() {// Method menentukan pertandingan selanjutnya
		roundRobin = new Tim[2];
		counterSusun2++;
		if(counterSusun2 == this.banyakTim) {
			counterSusun1++;
			counterSusun2 = counterSusun1 + 1;
		}
		roundRobin[0] = this.arrayTim[counterSusun1];
		roundRobin[1] = this.arrayTim[counterSusun2];
		pertandinganSelesai++;
		return "Statistika Pertandingan Tim " + roundRobin[0].getNamaTim() + " VS Tim " + roundRobin[1].getNamaTim();
	}
	
	public int factorial(int nTim) {// Method menghitung faktorial
        if(nTim == 1){
            return 1;
        }
        return nTim * (factorial(nTim-1));
    }
	
	public int totalMatches() {// Method menghitung sisa pertandingan
		return (factorial(this.banyakTim) / (factorial(2)*factorial(this.banyakTim-2)))-pertandinganSelesai;
	}

	// Setter, getter
	public Integer getBanyakTim() {
		return banyakTim;
	}

	public Tim[] getArrayTim() {
		return arrayTim;
	}

	public Tim[] getArrayTimSorted() {
		return arrayTimSorted;
	}

	public static int getCounterSusun1() {
		return counterSusun1;
	}

	public static int getCounterSusun2() {
		return counterSusun2;
	}

	public static int getPertandinganSelesai() {
		return pertandinganSelesai;
	}
}
