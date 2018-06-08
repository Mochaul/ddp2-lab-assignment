
public class OwjekRegular extends Owjek {
	public OwjekRegular () { // constructor class
		super(2012, 0, 0, 1000, 3000, 0, 0, 0, 40);
	}
	// menghitung harga 2 km pertama
	public double hitungFirst2KmCost(double jarak){
		if(jarak >= 0){
			return 3000;
		}else{
			return 0;
		}
	}
	// menghitung harga km selanjutnya jika ada
	public double hitungKmSelanjutnya(double jarak){
		if(jarak > 2.0){
			double jarakSisa = jarak - 2.0;
			return jarakSisa * 1000;
		}else{
			return 0;
		}
		
	}
	// menghitung harga promo sampai 6 km
	public double hitungPromo(double jarak, double tarif){
		if(jarak > 6.0){
			return 2800;
		}else{
			return (40 / 100.0) * tarif;
		}
	}
	// menghitung harga 2 km pertama ditambah hitung km selanjutnya
	public double hitungSementara(double jarak){
		if(jarak <= 2.0){
			return hitungFirst2KmCost(jarak);
		}else{
			return 3000 + (hitungKmSelanjutnya(jarak));
		}
	}
	// menghitung harga total setelah dikurangi harga promo
	public double hitungTarif(double jarak){
		return hitungSementara(jarak) - hitungPromo(jarak, hitungSementara(jarak));
	}
}
