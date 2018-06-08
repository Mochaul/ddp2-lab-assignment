import java.time.LocalDate;
import java.time.Period;

public class Internship {
	
	private String nama, tempatTanggalLahir, golDarah, sudahBelum, emoticon, tempatLahir;
	private Double tinggi, berat;
	private Integer lulus, counterSyarat = 0;
	private Boolean jomblo;
	
	public Internship(String nama, String tempatTanggalLahir, Double tinggi, Double berat, String golDarah, Integer lulus, Boolean jomblo){
		this.nama = nama;
		this.tempatTanggalLahir = tempatTanggalLahir;
		this.tinggi = tinggi;
		this.berat = berat;
		this.golDarah = golDarah;
		this.lulus = lulus;
		this.jomblo = jomblo;
	}
	
	LocalDate hariIni = LocalDate.now();
	
	public Integer hitungUmur(){
		
		String[] pisah = this.tempatTanggalLahir.split("/");
		this.tempatLahir = pisah[0];
		String tanggalLahir = pisah[1];
		String[] pisah2 = tanggalLahir.split("-");
		String hariStr = pisah2[0];
		Integer hari = Integer.parseInt(hariStr);
		String bulanStr = pisah2[1];
		Integer bulan = Integer.parseInt(bulanStr);
		String tahunStr = pisah2[2];
		Integer tahun = Integer.parseInt(tahunStr);	
		LocalDate ultah = LocalDate.of(tahun, bulan, hari);
		return Period.between(ultah, hariIni).getYears();
	}
		
	public String getTempatLahir() {
		return tempatLahir;
	}

	public Double hitungBMI(){
		
		return (double) (this.berat/((this.tinggi*this.tinggi)/10000));
		
	}
	
	public Integer hitungLulus(){
		
		LocalDate tanggalLulus = LocalDate.of(this.lulus, 6, 15);
		return Period.between(hariIni, tanggalLulus).getYears();
	}
		
	public void testJomblo(){
	
		if (this.jomblo) {
			this.sudahBelum = "Belum";
			this.emoticon = "(";
		} else {
			this.sudahBelum = "Sudah";
			this.emoticon = ")";
		}
	}
	
	public String getSudahBelum() {
		return this.sudahBelum;
	}

	public String getEmoticon() {
		return this.emoticon;
	}
		
	public Integer hitungSyarat(){
		
		String namaSaja = this.nama.replaceAll("\\s+", "");
		if ((namaSaja.length()%2) == 1){
			this.counterSyarat += 1;
		}
		if (this.hitungBMI() >= 18 && this.hitungBMI() <= 20){
			this.counterSyarat += 1;
		}
		if (this.golDarah.equalsIgnoreCase("AB")){
			this.counterSyarat += 1;
		}
		if (this.hitungLulus()<= 1){
			this.counterSyarat += 1;
		}
		if (!this.jomblo){
			this.counterSyarat += 1;
		}
		return this.counterSyarat;	
	}
	
	public String cekTerima(){
	
		if (this.counterSyarat < 3){
			return "ditolak";
		} else {
			return "diterima";
		}
	}
		
	public long hitungIsus(){
		return (long) (this.hitungUmur()*this.hitungUmur()*this.berat*this.tinggi*this.tinggi);
	}
	
}