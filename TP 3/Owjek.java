
public class Owjek {
	//instance variables
	private int minYearAllowed;
	private int minTopSpeed;
	private int minCc;
	private double costPerKm;
	private double first2KmCost;
	private double first5KmCost;
	private double fixedCost;
	private double protectionCost;
	private double promo;
	
	// constructor class utama
	public Owjek(int minYearAllowed, int minTopSpeed, int minCc, double costPerKm, double first2KmCost, double first5KmCost, double fixedCost, double protectionCost, double promo) {
		this.minYearAllowed = minYearAllowed;
		this.minTopSpeed = minTopSpeed;
		this.minCc = minCc;
		this.costPerKm = costPerKm;
		this.first2KmCost = first2KmCost;
		this.first5KmCost = first5KmCost;
		this.fixedCost = fixedCost;
		this.protectionCost = protectionCost;
		this.promo = promo;
	}
	
	// method menghitung harga promo
	public double hitungPromo(double tarif){
		return (promo / 100.0) * tarif;
	}
}
