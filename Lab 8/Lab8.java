import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

/**
 * Class utama Lab 8. Diusahakan agar
 * Anda tidak mengubah isi dari class ini.
 */
public class Lab8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Item> cart = new ArrayList<Item>();

        String[] input;

        // Menerima masukan hingga EOF
        while (scan.hasNextLine()) {
            input = scan.nextLine().split(" ");

            // Ketika user memasukkan perintah TAMBAH
            if (input[0].equalsIgnoreCase("TAMBAH")) {
                Item item;

                if (input.length != 4) {
                    continue;
                }

                // Menginstansiasi barang sesuai dengan kategorinya
                switch(input[1]) {
                    case "Elektronik":
                        item = new Elektronik(input[2], Integer.parseInt(input[3]));
                        break;
                    case "Pakaian":
                        item = new Pakaian(input[2], Integer.parseInt(input[3]));
                        break;
                    case "Makanan":
                        item = new Makanan(input[2], Integer.parseInt(input[3]));
                        break;
                    default:
                        System.out.println("Kategori tidak ada. Silakan coba lagi.");
                        continue;
                }

                // Menampilkan info barang yang ditambahkan
                item.added();

                // Menambahkan barang ke cart belanjaan
                cart.add(item);

            // Ketika user memasukkan perintah DETAIL
            } else if (input[0].equalsIgnoreCase("DETAIL")) {

                // Mencetak detail setiap barang
                for (Item item : cart) {
                    item.detail();
                }

            // Ketika user memasukkan perintah CHECKOUT
            } else if (input.length == 1 && input[0].equalsIgnoreCase("CHECKOUT")) {
                double total = 0;

                // Melakukan proses pembelian dari setiap barang
                for (Item item : cart) {
                    item.checkout();

                    // Menambahkan harga barang ke harga total
                    total += item.price();
                }

                // Mencetak total harga seluruh barang yang telah dibeli
                System.out.println("--- Total harga: " + total);

                // Mengosongkan cart belanjaan
                cart = new ArrayList<Item>();

            // Ketika user memasukkan perintah CHECKOUT SORTED
            } else if (input.length == 2 && input[0].equalsIgnoreCase("CHECKOUT") && input[1].equalsIgnoreCase("SORTED")) {
                // Mensorting barang pada cart
                Collections.sort(cart);

                double total = 0;

                // Melakukan proses pembelian dari setiap barang
                for (Item item : cart) {
                    item.checkout();

                    // Menambahkan harga barang ke harga total
                    total += item.price();
                }

                // Mencetak total harga seluruh barang yang telah dibeli
                System.out.println("--- Total harga: " + total);

                // Mengosongkan cart belanjaan
                cart = new ArrayList<Item>();

            // Ketika user memasukkan perintah CHECKOUT <persen diskon>
            } else if (input.length == 2 && input[0].equalsIgnoreCase("CHECKOUT")) {
                double total = 0;
                int discount = Integer.parseInt(input[1]);

                // Melakukan proses pembelian dari setiap barang
                for (Item item : cart) {
                    // Checkout dengan diskon
                    item.checkout(discount);

                    // Menambahkan harga barang dipotong diskon tertentu ke harga total
                    total += item.price(discount);
                }

                // Mencetak total harga seluruh barang yang telah dibeli
                System.out.println("--- Total harga: " + total);

                // Mengosongkan cart belanjaan
                cart = new ArrayList<Item>();
            }
        }
    }
}
