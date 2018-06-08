import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Pemain {
	// Instance variables
	private Integer nomorPemain;
	private String namaPemain;
	private Integer jumlahGol;
	private Integer jumlahPelanggaran;
	private Integer jumlahKartuKuning;
	private Integer jumlahKartuMerah;
	private Integer totalKK = 0;
	private String namaTim;
	// Array dummy pemain
	private boolean[] arrayNomor = new boolean[99];
	private static ArrayList<String> arrayPemain = new ArrayList<String>(Arrays.asList("Arnold", "Kaidou", "Chopper", "Pica", "Enel", "Zoro",
																				"Pedro", "Beckman", "Ace", "Shiryu", "Sakazuki", "Marco", 
																				"Garp", "Dadan", "Sengoku", "Sanji", "Magellan", "Dragon",
																				"Sabo", "Smoker", "Luffy", "Franky", "Borsalino", "Buggy",
																				"Crocodile", "Shanks", "Yasopp", "Coby", "Burgess", "Usopp",
																				"Law", "Kid", "Bege", "Yonji", "Doffy", "Edward", "Mihawk",
																				"Shanks", "Jinbei", "Killer", "Robin", "Roger", "Shiki",
																				"Rayleigh", "Robb", "Kuma", "Moriah", "Teach", "Pagaya",
																				"Conis", "Hachi", "Brook", "Kinemon", "Vergo", "Caesar",
																				"Momo", "Mohji", "Cabaji", "Jozu", "Vista", "Doma", "Augur",
																				"Drake", "Ivankov", "Charlotte", "Bellamy", "Demaro", "Dorry",
																				"Brogy", "Kuro", "Zeff", "Gin", "Pearl", "Alvide", "Apoo",
																				"Kuzan", "Nami", "Brook", "Hancock", "Koala"));
	public Pemain (){ // Costructor pemain
		this.nomorPemain = this.randomNomorPemain();
		this.namaPemain = this.randomNamaPemain();
		this.jumlahGol = 0;
		this.jumlahPelanggaran = 0;
		this.jumlahKartuKuning = 0;
		this.jumlahKartuMerah = 0;
	}
	Random random = new Random();
	
	public String randomNamaPemain() {// Method random nama pemain
		int idxPemain = random.nextInt(arrayPemain.size()-1);
		String randomNamePemain = arrayPemain.get(idxPemain);
		arrayPemain.removeAll(Collections.singleton(randomNamePemain));
		return randomNamePemain;	
	}
	
	public Integer randomNomorPemain() {// Method random nomor pemain
		int idxNomor = random.nextInt(98);
		while (arrayNomor[idxNomor]){
			idxNomor = random.nextInt(98);
		}
		arrayNomor[idxNomor] = true;
		return idxNomor+1;
	}

	//Method setter, getter, adder
	public Integer getNomorPemain() {
		return nomorPemain;
	}

	public String getNamaTim() {
		return namaTim;
	}

	public Integer getTotalKK() {
		return totalKK;
	}

	public void setTotalKK(Integer totalKK) {
		this.totalKK = totalKK;
	}

	public void setNamaTim(String namaTim) {
		this.namaTim = namaTim;
	}

	public String getNamaPemain() {
		return namaPemain;
	}

	public Integer getJumlahGol() {
		return jumlahGol;
	}

	public void addJumlahGol() {
		this.jumlahGol += 1;
	}

	public Integer getJumlahPelanggaran() {
		return jumlahPelanggaran;
	}

	public void addJumlahPelanggaran() {
		this.jumlahPelanggaran += 1;
	}

	public Integer getJumlahKartuKuning() {
		return jumlahKartuKuning;
	}

	public void addJumlahKartuKuning() {
		this.jumlahKartuKuning += 1;
	}
	
	public void addJumlahKartuKuning2() {
		this.jumlahKartuKuning += 1;
		this.totalKK += 1;
		
	}

	public Integer getJumlahKartuMerah() {
		return jumlahKartuMerah;
	}

	public void addJumlahKartuMerah() {
		this.jumlahKartuMerah += 1;
	}
}
