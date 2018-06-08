public class Gym {
    private String nama;
    private Double koefisienEfektivitas;

    public Gym(String nama, Double koefisienEfektivitas) {
        // @TODO constructor
    	this.nama = nama;
    	this.koefisienEfektivitas = koefisienEfektivitas;
    }

    public void gunakanTreadmill(Manusia manusia, Integer waktu, Integer kecepatan) {
        // @TODO 
        // kurangi totalKalori manusia sebanyak kalkulasi kalori
        // tolak jika totalKalori yang ada kurang dari kalori yang akan dibakar dan cetak "[nama manusia] tidak dapat menggunakan treadmill karena kekurangan energi."
        // apabila berhasil cetak "[nama manusia] menggunakan treadmill selama [waktu] dengan kecepatan [kecepatan]"
    	if (manusia.getTotalKalori() < this.hitungKaloriTreadmill(kecepatan, waktu)) {
    		System.out.println(manusia.getNama() + " tidak dapat menggunakan treadmill karena kekurangan energi.");
    	} else {
    		System.out.println(manusia.getNama() + " menggunakan treadmill selama " + waktu + " dengan kecepatan " + kecepatan);
    		manusia.setTotalKalori(manusia.getTotalKalori() - this.hitungKaloriTreadmill(kecepatan, waktu));
    	}
    	
    }

    private Double hitungKaloriTreadmill(Integer kecepatan, Integer waktu) {
        // @TODO kalkulasi kalori terbakar:
        //      koefisienEfektivitas * 1.2 * kecepatan (km/h) * waktu (menit)
    	return this.koefisienEfektivitas * 1.2 * waktu * kecepatan;
    }

    public void gunakanStationaryBike(Manusia manusia, Integer waktu) {
        // @TODO kurangi totalKalori manusia sebanyak kalkulasi kalori
        // tolak jika totalKalori yang ada kurang dari kalori yang akan dibakar dan cetak "[nama manusia] tidak dapat menggunakan stationary bike karena kekurangan energi."
        // apabila berhasil cetak "[nama manusia] menggunakan stationary bike selama [waktu]"
    	if (manusia.getTotalKalori() < this.hitungKaloriStationaryBike(waktu)) {
    		System.out.println(manusia.getNama() + " tidak dapat menggunakan stationary bike karena kekurangan energi.");
    	} else {
    		System.out.println(manusia.getNama() + " menggunakan stationary bike selama " + waktu);
    		manusia.setTotalKalori(manusia.getTotalKalori() - this.hitungKaloriStationaryBike(waktu));
    	}
    }

    private Double hitungKaloriStationaryBike(Integer waktu) {
        // @TODO kalkulasi kalori terbakar:
        //      koefisienEfektivitas * 10 * waktu
    	return this.koefisienEfektivitas * 10 * waktu;
    }
}