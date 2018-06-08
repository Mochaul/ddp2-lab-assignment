
public class OwjekExclusive extends Owjek {
	public OwjekExclusive() { //constructor class
		super(2016, 0, 500, 5000, 0, 0, 10000, 5, 50);
	}
	// menghitung harga per km
	public double hitungCostPerKm(double jarak){
		return jarak * 5000;
	}
	// menghitung harga per km ditambah harga fixed
	public double hitungTarif(double jarak){
		if(jarak > 0){
			return 10000 + hitungCostPerKm(jarak);
		}else{
			return 10000;
		}
	}
	// menghitung harga setelah dikurangi harga promo
	public double hitungSementara(double jarak){
		return hitungTarif(jarak) - hitungPromo(hitungTarif(jarak));
	}
	// menghitung harga proteksi
	public double hitungProtectionCost(double jarak){
		return (5/100.0) * hitungSementara(jarak);
	}
	// menghitung harga total setelah ditambah harga proteksi
	public double hitungTotal(double jarak){
		return hitungSementara(jarak) + hitungProtectionCost(jarak);
	}
}
