import java.util.*;

/**
 * Created by kianutamaradianur on 4/18/17.
 */
public class PathingCoordinates {
    static ArrayList<String> koor; //menyimpan koordinat koordinat
    private static Map map = new Map(); //membuat map
    private Point p; //membuat object class point
    public static Queue<Point> q = new ArrayDeque<>(); //membuat sebuah queue untuk memberikan urutan siapa yang harus
                                                       //di cek atas bawah kiri kanan terlebih dahulu

    public static Point getPathBFS(int x, int y) { //method untuk mencari jalan

        q.add(new Point(x,y, null)); //memasukan point start kedalam queue

        while(!q.isEmpty()) { //bagian ini akan jalan selama queue ada isinya
            Point p = q.remove(); //menghapus 1 point p yang paling depan antriannya

            if (map.get(p.x, p.y)=='F'){ //bila ketemu F atau finish maka akan mereturn point finish tersebut beserta parent2nya
                return p;
            }

            if(isFree(p.x+1,p.y)) { //mengecek kearah bawah
                map.set('.', p.x, p.y);
                //arr[p.x][p.y] = 1;
                Point nextP = new Point(p.x+1,p.y, p);
                q.add(nextP);
            }

            if(isFree(p.x-1,p.y)) { //mengecek kearah atas
                map.set('.', p.x, p.y);
                //arr[p.x][p.y] = 1;
                Point nextP = new Point(p.x-1,p.y, p);
                q.add(nextP);
            }

            if(isFree(p.x,p.y+1)) { //mengecek kearan kanan
                map.set('.', p.x, p.y);
                //arr[p.x][p.y] = 1;
                Point nextP = new Point(p.x,p.y+1, p);
                q.add(nextP);
            }

            if(isFree(p.x,p.y-1)) {//mengecek kearah kiri
                map.set('.', p.x, p.y);
                //arr[p.x][p.y] = 1;
                Point nextP = new Point(p.x,p.y-1, p);
                q.add(nextP);
            }

        }
        return null; //apabila tidak ada jalan
    }


    public static boolean isFree(int x, int y) { //mengecek apakah dia bisa dilewati atau tidak atau sudah sampai tujuan
        if((x >= 0 && x < 50) && (y >= 0 && y < 100) && (map.get(x,y) == ' ' || map.get(x,y) == 'F')) {
            return true;
        }
        return false;
    }

    public void showMap(){
        map.print();
    } //show map

    public boolean isJalan(String koordinat){  //method untuk mengecek apakah input yang diberikan merupakan sebuah jalan atau #
        if((koordinat.charAt(0)>='A' && koordinat.charAt(0)<='E') && (koordinat.charAt(2)>='Q' && koordinat.charAt(2)<='Z')){
            char karakter = map.get(10*(koordinat.charAt(0)-65)+Integer.parseInt(koordinat.substring(1,2)), 10*(koordinat.charAt(2)-81)+Integer.parseInt(koordinat.substring(3,4)));
            if(karakter=='#') {
                //System.out.printf("input tidak valid: %s bukan jalan\n", koordinat);
                return false;
            }
            else return true;
        }
        else { //apabila koordinatnya melebihi dari yang seharusnya
            //System.out.println("ERROR : Tidak ada koordinat itu");
            return false;
        }
    }

    public ArrayList<String> goKerja(String asal, String tujuan){ //main method untuk mencari jalan
        koor = new ArrayList<>();//array untuk menyimpan koordinat
        if(isJalan(asal) && isJalan(tujuan)){ //mengecek apakah koordinat jalan atau bukan
            findKoordinat(asal, tujuan);
                while(p.getParent() != null) {
                p.transfer(); //menyimpan ke arraylist koor
                p = p.getParent(); //mengambil parent dari koor itu
            }

            for(int x = 0; x<50; x++){ //membersihkan map dari titik titik yang berantakan
                for (int y=0; y<100; y++){
                    if(map.get(x,y)=='.'){
                        //jarak++;
                        map.set(' ',x,y);
                    }
                }
            }

            for(String i : koor){ //mencetak titik2 yang seharusnya dilewati yang telah disimpan di array list koor
                String temp[] = i.split(",");
                map.set('.', Integer.parseInt(temp[1]), Integer.parseInt(temp[0]));
            }

            String[] koorAkhir = koor.get(0).split(",");
            map.set('F', Integer.parseInt(koorAkhir[1]), Integer.parseInt(koorAkhir[0])); //mencetak karakter F karena tadi terhapus

//            if(perintah[7].equalsIgnoreCase("regular")){
//                owJekRegular.bayarOwJek(jarak); //bayar owjek jika menggunakan owjek regular
//            }
//            else if(perintah[7].equalsIgnoreCase("sporty")){
//                owJekSporty.bayarOwJek(jarak); //bayar owjek jika menggunakan owjek sporty
//            }
//            else if(perintah[7].equalsIgnoreCase("exclusive")){
//                owJekExclusive.bayarOwJek(jarak); //bayar owjek jika menggunakan owjek exclusive
//            }

            for(int x = 0; x<50; x++){ //membersihkan keseluruhan map
                for (int y=0; y<100; y++){
                    if(map.get(x,y)=='.' || map.get(x,y)=='F' || map.get(x,y)=='S'){
                        map.set(' ',x,y);
                    }
                }
            }
            q.clear(); //membersihkan antrian
        }
        koor.remove(0);
        Collections.reverse(koor);
        return koor;
    }

    public void findKoordinat(String koorAwal, String koorAkhir){ // mengconvert dari string menjadi koordinat yang bisa dimasukan ke method pencari jalan
        int koorVertikalAwal = 10*(koorAwal.charAt(0)-65)+Integer.parseInt(koorAwal.substring(1,2));
        int koorHorizontalAwal = 10*(koorAwal.charAt(2)-81)+Integer.parseInt(koorAwal.substring(3,4));
        int koorVertikalAkhir = 10*(koorAkhir.charAt(0)-65)+Integer.parseInt(koorAkhir.substring(1,2));
        int koorHorizontalAkhir = 10*(koorAkhir.charAt(2)-81)+Integer.parseInt(koorAkhir.substring(3,4));

        map.set('S', koorVertikalAwal, koorHorizontalAwal);
        map.set('F', koorVertikalAkhir, koorHorizontalAkhir);

        p = getPathBFS(koorVertikalAwal, koorHorizontalAwal); //mulai mencari jalan

        map.set('S', koorVertikalAwal, koorHorizontalAwal);// mengset S di map
    }

    public ArrayList<String> getKoor() {
        return koor;
    }

    private static class Point { //membuat class object point untuk memudahkan mencari jalan
        int x;
        int y;
        Point parent;

        public Point(int x, int y, Point parent) {
            this.x = x;
            this.y = y;
            this.parent = parent; //memudahkan mencari jalan awal
        }

        public Point getParent() {
            return this.parent;
        } //mendapatkan parent

        public void transfer(){
            koor.add(y+","+x);
        } //mentransfer ke koor

        public String toString() {
            return y+","+x;
        }
    }
}