import java.util.Scanner;

public class DDP2_TUTORIAL5 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);		
		String firstInp = input.nextLine();
		String[] pisahAngka = firstInp.split(" ");
		int banyakLemari = Integer.parseInt(pisahAngka[0]);
		int kapasitasLemari = Integer.parseInt(pisahAngka[1]);
		Perpustakaan perpus = new Perpustakaan(banyakLemari);
		for (int i=0; i < banyakLemari; i++){
			Lemari lemari = new Lemari(kapasitasLemari);
			perpus.setIsi(lemari, i);
		}
		while(true){
			String perintah = input.nextLine();
			String[] perintahPisah = perintah.split(" ");
			switch(perintahPisah[0]){
			case "INFO":
				int totalBuku = 0;
				System.out.println(perpus.getBanyak());
				for (int i = 0; i < perpus.getBanyak(); i++){
					System.out.println(i);
					totalBuku += perpus.getIsi()[i].getBanyakBuku();
				}
				System.out.println("Perpustakaan terdiri dari " + banyakLemari + " lemari dengan jumlah buku di lemari sebanyak " + totalBuku + " buku");
				break;
			case "+LEMARI":
				perpus.tambahLemari();
				Lemari lemari = new Lemari(kapasitasLemari);
				perpus.setIsiBaru(lemari, banyakLemari);
				banyakLemari += 1;
				System.out.println("Lemari berhasil ditambah");
				break;
			case "LIST":
				Lemari lemariTerpilih = perpus.getIsi()[Integer.parseInt(perintahPisah[1])-1];
				int banyakBuku = lemariTerpilih.getBanyakBuku();
				if (banyakBuku == 0){
					System.out.println("Tidak ada buku di lemari " + perintahPisah[1]);
				}else{
					for(int i = 0; i < banyakBuku; i++){
						System.out.println(lemariTerpilih.getSlot()[i]);
					}
				}
				break;
			case "CARI":
				String genrenya = perintahPisah[1];
				perpus.getBanyak();
				int tidakCocok = 0;
				for (int i = 0; i < banyakLemari; i++){
					Lemari ini = perpus.getIsi()[i];
					for(int t = 0; t < ini.getBanyakBuku(); t++){
						Buku bukuIni = ini.getSlot()[t];
						if(bukuIni.getGenre().equals(genrenya)){
							System.out.println(bukuIni.getJudul() + ", " + bukuIni.getId() + ", terdapat di lemari " + (i+1));
						}else{
						tidakCocok++;
						}
					}
				}
				int banyaknyaBuku = 0;
				for (int i =0; i < perpus.getBanyak(); i++){
					banyaknyaBuku += perpus.getIsi()[i].getBanyakBuku();
				}
				if (tidakCocok == banyaknyaBuku){
					System.out.println("Tidak ada buku dengan genre tersebut");
				}
				break;
			case "TAMBAH":
				Lemari tambahBuku = perpus.getIsi()[Integer.parseInt(perintahPisah[3])-1];
				String judul = "";
				for (int i = 4; i < perintahPisah.length; i++){
					judul += perintahPisah[i] + " ";
				}
				judul = judul.substring(0, judul.length()-1);
				Buku bukuTambah = new Buku(perintahPisah[1], perintahPisah[2], perintahPisah[3], judul);
				if(tambahBuku.getBanyakBuku() >= tambahBuku.getKapasitas()){
					System.out.println("Lemari " + perintahPisah[3] + " sudah penuh!");
				}else{
					tambahBuku.setIsi(bukuTambah);
					System.out.println("Buku " + judul + " ditambahkan pada lemari " + perintahPisah[3]);
				}
				break;
			default:
				System.out.println("Perintah tidak valid");
				break;
			}
			
		}
	}

}