
public class OwjekSporty extends Owjek {
	public OwjekSporty() { // constructor class
		super(2015, 140, 0, 3000, 0, 20000, 0, 10, 60);
	}
	
	// menghitung harga 5 km pertama
	public double hitungFirst5KmCost(double jarak){
		if(jarak > 0){
			return 20000;
		}else{
			return 0;
		}
	}
	// menghitung harga km selanjutnya jika ada
	public double hitungKmSelanjutnya(double jarak){
		if(jarak > 5.0){
			double jarakSisa = jarak - 5.0;
			return jarakSisa * 3000;
		}else{
			return 0;
		}
		
	}
	// menghitung harga 5 km pertama dan selanjutnya
	public double hitungSementara(double jarak){
		if(jarak <= 5.0){
			return hitungFirst5KmCost(jarak);
		}else{
			return 20000 + (hitungKmSelanjutnya(jarak));
		}
	}
	// menghitung harga promo untuk 8 km pertama
	public double hitungPromo(double jarak, double tarif){
		if(jarak > 8.0){
			return 17400;
		}else{
			return (60 / 100.0) * tarif;
		}
	}
	// menghitung harga setelah dikurangi promo
	public double hitungTarif(double km){
		return hitungSementara(km) - hitungPromo(km, hitungSementara(km));
	}
	// menghitung harga proteksi
	public double hitungProtectionCost(double jarak){
		return (10/100.0) * hitungTarif(jarak);
	}
	// menghitung harga total setelah ditambah harga proteksi
	public double hitungTotal(double jarak){
		return hitungTarif(jarak) + hitungProtectionCost(jarak);
	}
}
