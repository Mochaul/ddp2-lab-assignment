/**
 * Class yang merepresentasikan barang
 * dengan kategori Makanan.
 */
public class Makanan extends Item{

    public Makanan(String name, int price) {
        super(name, price);
    }
    
    public void added() {
    	System.out.println("Menambahkan " + name + " seharga " + price + " . Enak!");
    }
    
    public void detail() {
    	System.out.println(name + " bisa dimakan. Diskon 5%.");
    }
    
    public void checkout() {
        System.out.println(name + " berhasil dibeli. Harga: " + this.price() + ".");
    }
    
    public double price() {
        return price*95/100;
    }
}
