public class Task {
	private String name;
	private int bobot;
	private boolean selesai;
	
	public Task(String name, int bobot) {
		this.name = name;
		this.bobot = bobot;
		this.selesai = false;
	}
	
	public String selesaiBelum(){
		if (this.selesai) {
			return "Selesai";
		} else{
			return "Belum selesai";
		}
	}
	
	public String toString() {
		return "Task: " + this.name + ", bobot: " + this.bobot + ", status: " + this.selesaiBelum();
	}
}
