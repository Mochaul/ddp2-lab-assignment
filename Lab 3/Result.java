import java.util.Scanner;

public class Result {

	public static void main(String[] args){
		System.out.println("Program Wawancara Perusahaan iSUS");
		System.out.println("---------------------------------");
		
		Scanner input = new Scanner(System.in);
		System.out.print("Nama : ");
		String nama = input.nextLine();
		
		System.out.print("Tempat/Tanggal Lahir : ");
		String tempatTanggalLahir = input.nextLine();
		
		System.out.print("NIK : ");
		Long nik = input.nextLong();
		
		System.out.print("Tinggi : ");
		Double tinggi = input.nextDouble();
		
		System.out.print("Berat Badan : ");
		Double berat = input.nextDouble(); input.nextLine();
		
		System.out.print("Golongan Darah : ");
		String golDarah = input.nextLine();
		
		System.out.print("Pengalaman : ");
		String pengalaman = input.nextLine();
		
		System.out.print("Pendidikan saat ini : ");
		String pendidikan = input.nextLine();
		
		System.out.print("Perkiraan lulus : ");
		Integer lulus = input.nextInt(); input.nextLine();
		
		System.out.print("Jomblo : ");
		Boolean jomblo = input.nextBoolean();
		
		Internship intern = new Internship(nama, tempatTanggalLahir, tinggi, berat, golDarah, lulus, jomblo);
		intern.testJomblo();

		System.out.println("\nDATA TERSIMPAN");
		System.out.println("-----------------------------------");
		
		System.out.printf("%s - %d Tahun - BMI : %.4f\n", nama, intern.hitungUmur(), intern.hitungBMI());
		System.out.println("Asal " + intern.getTempatLahir() + " Bergolongan darah " + golDarah);
		System.out.println("Lulus dalam " + intern.hitungLulus() + " tahun dari " + pendidikan);
		System.out.println("Berpengalaman " + pengalaman);
		System.out.println(intern.getSudahBelum() + " mempunyai pasangan hidup :" + intern.getEmoticon());
		
		System.out.println("\nPREDIKSI");
		System.out.println("-----------------------------------");
		
		System.out.println("Nilai iSUS " + intern.hitungIsus());
		System.out.println("Memenuhi " + intern.hitungSyarat() + " dari 5 syarat");
		System.out.println(nama + " " + intern.cekTerima());
		
	}

}
