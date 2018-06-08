public class DDP2Tutorial2 {
    public static void main(String[] args) {
        // @TODO instansiasi obyek manusia
    	Manusia manusia = new Manusia("Mochaul", 17, 70, 176, "Pria", 0.0);
        manusia.cetakInformasi(); 

        // @TODO instansiasi beberapa makanan:
        // apel: 52 kalori
    	Makanan apel = new Makanan("apel", "lezat", 52);
        // nasi goreng: 163 kalori
    	Makanan nasiGoreng = new Makanan("nasi goreng", "enak", 163);
        // nasi padang: 306 kalori
    	Makanan nasiPadang = new Makanan("nasi padang", "nikmat", 306);
        // indomie: 342 kalori
    	Makanan indomie = new Makanan("indomie", "mantap", 342);
        // soto betawi: 363 kalori
    	Makanan sotoBetawi = new Makanan("soto betawi", "kurang", 363);
        // pizza: 266 kalori
    	Makanan pizza = new Makanan("pizza", "enak", 266);
        manusia.makan(nasiPadang);
        manusia.makan(apel);
        manusia.cetakInformasi();
        // ----------------
        // Contoh keluaran:
        // ----------------
        // John Smith
        // Umur    : 25 Tahun
        // Berat   : 60 KG
        // Tinggi  : 180 CM
        // Kalori  : 358
        // BMR     : 1618
        // KKH     : 2207 Kalori/hari

        // @TODO instansiasi gym dengan koefisien 1.25
        Gym gym = new Gym("Mochaul", 1.25);
        gym.gunakanTreadmill(manusia, 10, 10);
        gym.gunakanTreadmill(manusia, 20, 10);
        gym.gunakanTreadmill(manusia, 500, 10);
        manusia.cetakInformasi();
        // ----------------
        // Contoh keluaran:
        // ----------------
        // John Smith
        // Umur    : 25 Tahun
        // Berat   : 60 KG
        // Tinggi  : 180 CM
        // Kalori  : 208
        // BMR     : 1618
        // KKH     : 2207 Kalori/hari

        manusia.makan(indomie);
        manusia.makan(indomie);
        manusia.makan(indomie);
        manusia.makan(indomie);
        manusia.makan(indomie);
        manusia.makan(indomie); // kelebihan makan
        manusia.cetakInformasi();
        // ----------------
        // Contoh keluaran:
        // ----------------
        // John Smith
        // Umur    : 25 Tahun
        // Berat   : 60 KG
        // Tinggi  : 180 CM
        // Kalori  : 1928
        // BMR     : 1618
        // KKH     : 2207 Kalori/hari

        gym.gunakanStationaryBike(manusia, 30);
        gym.gunakanTreadmill(manusia, 30, 10);
        manusia.cetakInformasi();
        // ----------------
        // Contoh keluaran:
        // ----------------
        // John Smith
        // Umur    : 25 Tahun
        // Berat   : 60 KG
        // Tinggi  : 180 CM
        // Kalori  : 1103
        // BMR     : 1618
        // KKH     : 2207 Kalori/hari
    }
}