
public class Gaji {
	private String name;
	private int gaji;
	private int totalBobot;
	private int pangkat;
	
	public Gaji(String name, int pangkat) {
		this.name = name;
		this.pangkat = pangkat;
		this.gaji = pangkat * 5000000;
		this.totalBobot = 0;
	}
		
	public void dispenseWages() {
		// @TODO
		// Cetak: "[nama karyawan] telah menerima gaji sebesar [gaji] dengan bonus sebesar [jumlah bonus]".
		System.out.println(this.name + " telah menerima gaji sebesar " + this.gaji + " dengan bonus sebesar " + this.calculateBonus());
	}
	
	public long calculateBonus() {
		// @TODO
		// hitung bonus sesuai dengan instruksi di soal
		if (this.pangkat == 1) {
			if (this.totalBobot > 5){
				return (this.totalBobot-5)*1000000;
			} else{
				return 0;
			}
		}
		else if (this.pangkat == 2) {
			if (this.totalBobot > 10){
				return (this.totalBobot-10)*1000000;
			} else{
				return 0;
			}
		}else {
			if (this.totalBobot > 15){
				return (this.totalBobot-15)*1000000;
			} else{
				return 0;
			}
		}
	}
}
