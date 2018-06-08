import java.util.ArrayList;
import java.util.Scanner;

public class Perusahaan {
	private static Scanner inp;

	public static void main(String[] args) {
		inp = new Scanner(System.in);
		ArrayList<Karyawan> list = new ArrayList<Karyawan>();
		while (true) {
			String input = inp.nextLine();
			String[] pisahInput = input.split("\\s+");
			switch (pisahInput[0]) {
				case "REKRUT":
					boolean duplicate = false;
					for (int i=0;i<list.size();i++) {
						if (list.get(i).getNama().equalsIgnoreCase(pisahInput[1])) {
							System.out.println("Sudah ada karyawan bernama " + pisahInput[1] + " yang diterima");
							duplicate = true;
							break;
						}
					}
					if (!duplicate) {
						if (pisahInput[2].equals("Staf") && pisahInput[3].equals("IT")) {
							Karyawan karyawan = new StafIT(pisahInput[1], pisahInput[4]);
							list.add(karyawan);
							System.out.println(pisahInput[1] + " diterima bekerja sebagai " + pisahInput[2] + " " + pisahInput[3]);
						} else if (pisahInput[2].equals("Staf") && pisahInput[3].equals("HRD")) {
							Karyawan karyawan = new StafHRD(pisahInput[1], pisahInput[4]);
							list.add(karyawan);
							System.out.println(pisahInput[1] + " diterima bekerja sebagai " + pisahInput[2] + " " + pisahInput[3]);
						} else if (pisahInput[2].equals("Janitor")) {
							Karyawan karyawan = new Janitor(pisahInput[1], pisahInput[3]);
							list.add(karyawan);
							System.out.println(pisahInput[1] + " diterima bekerja sebagai " + pisahInput[2]);
						} else if (pisahInput[2].equals("Security")) {
							Karyawan karyawan = new Security(pisahInput[1], pisahInput[3]);
							list.add(karyawan);
							System.out.println(pisahInput[1] + " diterima bekerja sebagai " + pisahInput[2]);
						} else {
							System.out.println("Perintah rekrut tidak valid.");
						}
					}
					duplicate = false;
					break;
				case "LEMBUR":
					boolean counter = false;
					for (int i = 1; i<pisahInput.length; i++) {
						for (int j = 0; j<list.size(); j++) {
							if (pisahInput[i].equalsIgnoreCase(list.get(j).getNama())) {
								list.get(j).setGaji(list.get(j).getGaji()*1.15);
								System.out.println("Gaji " + list.get(j).getNama() + " telah ditambahkan sebanyak " + ((int) Math.ceil(list.get(j).getGaji()/1.15*0.15)));
								counter = true;
							}
						}
						if (!counter) {
							System.out.println("Tidak ada karyawan bernama " + pisahInput[i]);
						counter = false;
						}
					}
					break;
				case "GAJIAN":
					if (list.size() == 0) {
						System.out.println("Tidak ada karyawan yang terdaftar");
					} else {
						for (int i = 0; i<list.size(); i++) {
							if (list.get(i) instanceof StafIT) {
								System.out.println("Staf IT bernama " + list.get(i).getNama() + " memiliki gaji " + (int) Math.ceil(list.get(i).getGaji()));
							} else if (list.get(i) instanceof StafHRD) {
								System.out.println("Staf HRD bernama " + list.get(i).getNama() + " memiliki gaji " + (int) Math.ceil(list.get(i).getGaji()));
							} else if (list.get(i) instanceof Security) {
								System.out.println("Security bernama " + list.get(i).getNama() + " memiliki gaji " + (int) Math.ceil(list.get(i).getGaji()));
							} else if (list.get(i) instanceof Janitor) {
								System.out.println("Janitor bernama " + list.get(i).getNama() + " memiliki gaji " + (int) Math.ceil(list.get(i).getGaji()));
							}
						}
					}
					
					break;
				case "SAPA":
					boolean contain1 = false;
					boolean contain2 = false;
					for (int i = 0; i<list.size(); i++) {
						if (list.get(i).getNama().equalsIgnoreCase(pisahInput[1])) {
							contain1 = true;
						}
						if (list.get(i).getNama().equalsIgnoreCase(pisahInput[2])) {
							contain2 = true;
						}
					}
					if (contain1 && contain2) {
						for (int j = 0; j<list.size(); j++) {
							if (list.get(j).getNama().equalsIgnoreCase(pisahInput[2])) {
								if (list.get(j) instanceof Security) {
									if (list.get(j).getGender().equalsIgnoreCase("Pria")) {
										System.out.println(pisahInput[1] + " menyapa Pak " + pisahInput[2] + " dengan penuh kasih sayang");
									} else {
										System.out.println(pisahInput[1] + " menyapa Bu " + pisahInput[2] + " dengan penuh kasih sayang");
									}
								} else if (list.get(j) instanceof Janitor) {
									if (list.get(j).getGender().equalsIgnoreCase("Pria")) {
										System.out.println(pisahInput[1] + " menyapa Mas " + pisahInput[2] + " dengan penuh kasih sayang");
									} else {
										System.out.println(pisahInput[1] + " menyapa Mbak " + pisahInput[2] + " dengan penuh kasih sayang");
									}
								} else {
									System.out.println(pisahInput[1] + " menyapa Kak " + pisahInput[2] + " dengan penuh kasih sayang");
								}
							}
						}
					}
					if (!contain1) {
						System.out.println("Tidak ada karyawan bernama " + pisahInput[1]);
					}
					if (!contain2) {
						System.out.println("Tidak ada karyawan bernama " + pisahInput[2]);
					}
					contain1 = false;
					contain2 = false;
					break;
				case "NGODING":
					boolean containNama = false;
					for (int i = 0; i<list.size(); i++) {
						if (list.get(i).getNama().equalsIgnoreCase(pisahInput[1])) {
							containNama = true;
						}
					}
					if (containNama) {
						for (int i = 0; i<list.size(); i++) {
							if (list.get(i).getNama().equalsIgnoreCase(pisahInput[1])) {
								if (list.get(i) instanceof StafIT) {
									System.out.println(pisahInput[1] + " sedang ngoding gembira");
								} else {
									System.out.println(pisahInput[1] + " tidak bisa mengambil pekerjaan lain");
								}
							}
						}
					} else {
						System.out.println("Tidak ada karyawan bernama " + pisahInput[1]);
					}
					containNama = false;
					break;
				case "KELOLA":
					boolean containNama2 = false;
					for (int i = 0; i<list.size(); i++) {
						if (list.get(i).getNama().equalsIgnoreCase(pisahInput[1])) {
							containNama2 = true;
						}
					}
					if (containNama2) {
						for (int i = 0; i<list.size(); i++) {
							if (list.get(i).getNama().equalsIgnoreCase(pisahInput[1])) {
								if (list.get(i) instanceof StafHRD) {
									System.out.println(pisahInput[1] + " sedang mengelola perusahaan");
								} else {
									System.out.println(pisahInput[1] + " tidak bisa mengambil pekerjaan lain");
								}
							}
						}
					} else {
						System.out.println("Tidak ada karyawan bernama " + pisahInput[1]);
					}
					containNama2 = false;
					break;
				case "SAPU":
					boolean containNama3 = false;
					for (int i = 0; i<list.size(); i++) {
						if (list.get(i).getNama().equalsIgnoreCase(pisahInput[1])) {
							containNama3 = true;
						}
					}
					if (containNama3) {
						for (int i = 0; i<list.size(); i++) {
							if (list.get(i).getNama().equalsIgnoreCase(pisahInput[1])) {
								if (list.get(i) instanceof Janitor) {
									System.out.println(pisahInput[1] + " sedang menyapu bersih");
								} else {
									System.out.println(pisahInput[1] + " tidak bisa mengambil pekerjaan lain");
								}
							}
						}
					} else {
						System.out.println("Tidak ada karyawan bernama " + pisahInput[1]);
					}
					containNama3 = false;
					break;
				case "JAGA":
					boolean containNama4 = false;
					for (int i = 0; i<list.size(); i++) {
						if (list.get(i).getNama().equalsIgnoreCase(pisahInput[1])) {
							containNama4 = true;
						}
					}
					if (containNama4) {
						for (int i = 0; i<list.size(); i++) {
							if (list.get(i).getNama().equalsIgnoreCase(pisahInput[1])) {
								if (list.get(i) instanceof Security) {
									System.out.println(pisahInput[1] + " sedang menjaga perusahaan");
								} else {
									System.out.println(pisahInput[1] + " tidak bisa mengambil pekerjaan lain");
								}
							}
						}
					} else {
						System.out.println("Tidak ada karyawan bernama " + pisahInput[1]);
					}
					containNama4 = false;
					break;
				default: 
					System.out.println("Input tidak valid.");
                	break;
			}
		}
	}
}
