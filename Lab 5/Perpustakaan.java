import java.util.Arrays;

public class Perpustakaan {
	private int banyak;
	private Lemari[] isi;

	public Perpustakaan(int banyakLemari) {
		this.isi = new Lemari[banyakLemari];
		this.banyak = banyakLemari;
	}
	
	public void tambahLemari() {
		this.isi = Arrays.copyOf(this.isi, this.banyak+1);
	}
	
	public int getBanyak() {
		return banyak;
	}

	public void setBanyak(int banyak) {
		this.banyak = banyak;
	}

	public Lemari[] getIsi() {
		return isi;
	}

	public void setIsi(Lemari lemari, int i) {
		this.isi[i] = lemari;
	}
	
	public void setIsiBaru(Lemari lemari, int i) {
		this.isi[i] = lemari;
		this.banyak += 1;
	}
}