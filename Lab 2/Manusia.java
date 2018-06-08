public class Manusia {
    private String nama;
    private Integer umur;
    private Integer berat;
    private Integer tinggi;
	private String jenisKelamin;
    private Double totalKalori;

    public Manusia(String nama, Integer umur, Integer berat, Integer tinggi, String jenisKelamin, Double totalKalori) {
        this.nama = nama;
        this.umur = umur;
        this.berat = berat;
        this.tinggi = tinggi;
        this.jenisKelamin = jenisKelamin;
        this.totalKalori = totalKalori;
    }

    private double hitungBMR() {
        // @TODO kalkulasi BMR
        // https://en.wikipedia.org/wiki/Harris%E2%80%93Benedict_equation
    	if (this.jenisKelamin == "Pria"){
    		return ((10 * this.getBerat()) + (6.25 * this.getTinggi()) - (5 * this.getUmur()) + 5); 
    	} else {
    		return ((10 * this.getBerat()) + (6.25 * this.getTinggi()) - (5 * this.getUmur()) - 161);
    	}
    }

    private double hitungKaloriHarian() {
        // @TODO kalkulasi kebutuhan kalori harian
        // (lihat perhitungan Harris-Benedict, asumsikan manusia melakukan light exercise)
    	return this.hitungBMR() * 1.375;
    }

    public void makan(Makanan makanan) {
        // @TODO
        // tambah totalKalori sebanyak kalori dari makanan
        // tolak jika kalori tambahan akan melebihi kebutuhan kalori harian
        // Cetak "[nama manusia] memakan [nama makanan] yang rasanya [rasa]"
    	if (this.getTotalKalori() + makanan.getKalori() > this.hitungKaloriHarian()){
    		System.out.println(this.getNama() + " tidak bisa memakan " + makanan.getNama() + " karena akan melebihi batas kebutuhan kalori hariannya.");
    	} else {
    		System.out.println(this.getNama() + " memakan " + makanan.getNama() + " yang rasanya " + makanan.getRasa());
    		this.totalKalori = this.getTotalKalori() + makanan.getKalori();
    	}
    }

    public void cetakInformasi() {
        // @TODO
        // keluarkan nama, umur, berat, tinggi, totalKalori, BMR, dan kebutuhan kalori harian
        // -------
        // Contoh:
        // -------
        // John Smith
        // Umur    : 25 Tahun
        // Berat   : 60 KG
        // Tinggi  : 180 CM
        // Kalori  : 0
        // BMR     : 1618
        // KKH     : 2207 Kalori/hari
    	System.out.println(this.getNama());
    	System.out.println("Umur\t: " + this.getUmur() + " Tahun");
    	System.out.println("Berat\t: " + this.getBerat() + " KG");
    	System.out.println("Tinggi\t: " + this.getTinggi() + " CM");
    	System.out.printf("Kalori\t: %.0f\n", this.getTotalKalori());
    	System.out.println("BMR\t: " + (int) this.hitungBMR());
    	System.out.println("KKH\t: " + (int) this.hitungKaloriHarian() + " Kalori/hari");
    }

    // @TODO setter-getter seperlunya
	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public Integer getUmur() {
		return umur;
	}

	public void setUmur(Integer umur) {
		this.umur = umur;
	}

	public Integer getBerat() {
		return berat;
	}

	public void setBerat(Integer berat) {
		this.berat = berat;
	}

	public Integer getTinggi() {
		return tinggi;
	}

	public void setTinggi(Integer tinggi) {
		this.tinggi = tinggi;
	}

	public String getJenisKelamin() {
		return jenisKelamin;
	}

	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}

	public Double getTotalKalori() {
		return totalKalori;
	}

	public void setTotalKalori(Double totalKalori) {
		this.totalKalori = totalKalori;
	}

}