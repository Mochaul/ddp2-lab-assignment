import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Tim {
	// Instance variables
	private String namaTim;
	private Integer peringkat;
	private Integer jumlahMenang;
	private Integer jumlahKalah;
	private Integer jumlahSeri;
	private Integer jumlahPoin;
	private Integer jumlahGol;
	private Integer jumlahKebobolan;
	private Pemain[] arrayPemain;
	// Array dummy tim
	private static ArrayList<String> arrayTim = new ArrayList<String>(Arrays.asList("Gajah", "Rusa", "Belalang", "Kodok", "Kucing", "Tupai", 
																			 "Rajawali", "Siput", "Kumbang", "Semut", "Ular", "Harimau", 
																			 "Kuda", "Serigala", "Panda", "Kadal", "Ayam", "Bebek"));
	public Tim() {// Constructor Tim
		this.namaTim = this.randomNamaTim();
		this.jumlahMenang = 0;
		this.jumlahKalah = 0;
		this.jumlahSeri = 0;
		this.jumlahPoin = 0;
		this.jumlahGol = 0;
		this.jumlahKebobolan = 0;
		this.arrayPemain = new Pemain [5];
		for (int i = 0; i<5; i++){
			Pemain pemain = new Pemain();
			this.arrayPemain[i] = pemain;
			this.arrayPemain[i].setNamaTim(this.namaTim);
		}
	}
	Random random = new Random();
	
	public String randomNamaTim() {// Method random nama tim
		int idxTim = random.nextInt(arrayTim.size()-1);
		String randomTim = arrayTim.get(idxTim);
		arrayTim.remove(idxTim);
		return randomTim;
	}
	// Setter, getter
	public String getNamaTim() {
		return namaTim;
	}
	public Pemain[] getArrayPemain() {
		return arrayPemain;
	}
	public Integer selisihGol() {
		return this.jumlahGol-this.jumlahKebobolan;
	}
	public Integer getPeringkat() {
		return peringkat;
	}
	public void setPeringkat(Integer peringkat) {
		this.peringkat = peringkat;
	}
	public Integer getJumlahMenang() {
		return jumlahMenang;
	}
	public void addJumlahMenang() {
		this.jumlahMenang += 1;
	}
	public Integer getJumlahKalah() {
		return jumlahKalah;
	}
	public void addJumlahKalah() {
		this.jumlahKalah += 1;
	}
	public Integer getJumlahSeri() {
		return jumlahSeri;
	}
	public void addJumlahSeri() {
		this.jumlahSeri += 1;
	}
	public Integer getJumlahPoin() {
		return jumlahPoin;
	}
	public void addJumlahPoin(Integer jumlahPoin) {
		this.jumlahPoin += jumlahPoin;
	}
	public Integer getJumlahGol() {
		return jumlahGol;
	}
	public void setJumlahGol(Integer jumlahGol) {
		this.jumlahGol = jumlahGol;
	}
	public Integer getJumlahKebobolan() {
		return jumlahKebobolan;
	}
	public void setJumlahKebobolan(Integer jumlahKebobolan) {
		this.jumlahKebobolan = jumlahKebobolan;
	}
	
}
