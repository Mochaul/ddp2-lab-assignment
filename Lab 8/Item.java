/**
 * Class yang merepresentasikan barang
 * yang tersedia di Kiospedia.
 *
 * Anda diperbolehkan mengubah isi class ini.
 */
public class Item implements Comparable<Item>{
    protected String name;
    protected double price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void added() {
        System.out.println("Menambah barang.");
    }

    public double price() {
        return price;
    }
    
    public double price(int discount) {
        return price*(100-discount)/100;
    }   

    public void checkout() {
        System.out.println(name + " berhasil dibeli. Harga: " + this.price() + ".");
    }
    
    public void checkout(int discount) {
        System.out.println(name + " berhasil dibeli. Harga: " + this.price(discount) + ".");
    }

    public void detail() {
        System.out.println("Detail barang.");
    }
    
    public int compareTo(Item other) {
    	return this.name.compareTo(other.name);
    }

}
