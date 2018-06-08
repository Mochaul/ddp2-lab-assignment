
public class Karyawan {
	private String nama;
	private String gender;
	private double gaji;
	
	public Karyawan(String nama, String gender, double gaji) {
		this.nama = nama;
		this.gender = gender;
		this.gaji = gaji;
	}

	public String getNama() {
		return nama;
	}

	public String getGender() {
		return gender;
	}

	public double getGaji() {
		return gaji;
	}

	public void setGaji(double gaji) {
		this.gaji = gaji;
	}
}
