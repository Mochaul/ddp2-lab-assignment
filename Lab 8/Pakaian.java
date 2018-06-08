/**
 * Class yang merepresentasikan barang
 * dengan kategori Pakaian.
 */
public class Pakaian extends Item{

    public Pakaian(String name, int price) {
        super(name, price);
    }
    
    public void added() {
    	System.out.println("Menambahkan " + name + " seharga " + price + " agar tampil lebih modis!");
    }
    
    public void detail() {
        System.out.println("Pakaian " + name + " dengan diskon 10%.");
    }
    
    public void checkout() {
        System.out.println(name + " berhasil dibeli. Harga: " + this.price() + ".");
    }
    
    public double price() {
        return price*90/100;
    }
}
