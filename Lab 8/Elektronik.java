/**
 * Class yang merepresentasikan barang
 * dengan kategori Elektronik.
 */
public class Elektronik extends Item{

    public Elektronik(String name, int price) {
        super(name, price);
    }
    
    public void added() {
    	System.out.println("Menambahkan " + name + " seharga " + price + " biar canggih!");
    }
    
    public void detail() {
        System.out.println(name + " adalah peralatan elektronik. Mendapat diskon 15%.");
    }
    
    public void checkout() {
        System.out.println(name + " berhasil dibeli. Harga: " + this.price() + ".");
    }
     
    public double price() {
        return price*85/100;
    }     
}
