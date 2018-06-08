public class Buku {
	private String id;
	private	String genre;
	private String nomorLemari;
	private String judul;
	
	public Buku(String id, String genre, String nomorLemari, String judul) {
		this.id = id;
		this.genre = genre;
		this.nomorLemari = nomorLemari;
		this.judul = judul;
	}

	public String toString(){
		return getJudul() + ", " + getId() + ", " + getGenre();
	}
	public String getId() {
		return id;
	}

	public String getGenre() {
		return genre;
	}

	public String getNomorLemari() {
		return nomorLemari;
	}

	public String getJudul() {
		return judul;
	}

}