public class Lemari {
	private int banyakBuku;
	private int kapasitas;
	private Buku[] slotBuku;

	public Lemari(int kapasitas) {
		this.banyakBuku = 0;
		this.kapasitas = kapasitas;
		this.slotBuku = new Buku[this.kapasitas];
	}

	public int getKapasitas() {
		return kapasitas;
	}

	public void setKapasitas(int kapasitas) {
		this.kapasitas = kapasitas;
	}
	
	public void setIsi(Buku buku){
		this.slotBuku[this.banyakBuku] = buku;
		this.banyakBuku += 1;
	}

	public int getBanyakBuku(){
		return banyakBuku;
	}
	
	public Buku[] getSlot() {
		return slotBuku;
	}
	
}
