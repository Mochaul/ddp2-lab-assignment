public class Makanan {

	private String nama;
    private String rasa;
    private Integer kalori;

    public Makanan(String nama){
    	// @TODO constructor makanan dengan 0 kalori dan rasa tidak enak
    	this.nama = nama;
    	this.rasa = "Tidak enak";
    	this.kalori = 0;
    	
    }

    public Makanan(String nama, String rasa, Integer kalori) {
        // @TODO constructor
    	this.nama = nama;
    	this.rasa = rasa;
    	this.kalori = kalori;
    }

    // @TODO setter-getter seperlunya
    public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getRasa() {
		return rasa;
	}

	public void setRasa(String rasa) {
		this.rasa = rasa;
	}

	public Integer getKalori() {
		return kalori;
	}

	public void setKalori(Integer kalori) {
		this.kalori = kalori;
	}
}