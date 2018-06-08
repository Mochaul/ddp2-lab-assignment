public class Employee {
	private String name;
	private String employeeId;
	private int pangkat;
	private int divisi;
	
	public static String temanTerbaru;
	
	public Employee(String name, String employee_id, int pangkat, int division) {
		this.name = name;
		this.employeeId = employee_id;
		this.pangkat = pangkat;
		this.divisi = division;

		temanTerbaru = name;
	}
	
	public void workOnTask(Task assigned, Gaji gajiEmployee) {
		// @TODO implementasi fungsi ini
		if (!assigned.selesai) {
			assigned.selesai = true;
			gajiEmployee.totalBobot += assigned.bobot;
			System.out.println(this.name + " telah mengerjakan tugas " + assigned.name + " dengan bobot " + assigned.bobot);	
		} else{
			System.out.println(this.name + " gagal mengerjakan tugas " + assigned.name + " dengan bobot karena status sudah selesai");
		}
	}
	
	public String namaDivisi() {
		if (this.divisi == 0){
			return "Engineering";
		}
		else if (this.divisi == 1){
			return "Data";
		}
		else {
			return "Marketing";
		}
	}
	
	public String namaPangkat() {
		if (this.pangkat == 1){
			return "Newbie";
		}
		else if (this.pangkat == 2){
			return "Junior";
		}
		else {
			return "Senior";
		}
	}
	
	public String toString() {
		return "Karyawan #" + this.employeeId + ": " + this.name + ", " + this.namaDivisi() + " " + this.namaPangkat();
	}
}
