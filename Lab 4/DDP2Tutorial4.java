public class DDP2Tutorial4 {
	public static void main(String[] args) {
		Employee ann = new Employee("Ann", "1SE40", 3, 0);
		System.out.println(Employee.temanTerbaru);
		System.out.println(ann);
		Employee bob = new Employee("Bob", "1SE25", 2, 1);
		System.out.println(Employee.temanTerbaru);
		System.out.println(bob);
		Employee charlie = new Employee("Charlie", "1PM21", 1, 2);
		System.out.println(Employee.temanTerbaru);
		System.out.println(charlie);
		
		Task taskOne = new Task("Implement first feature", 10);
		System.out.println(taskOne);
		Task taskTwo = new Task("Implement second feature", 15);
		System.out.println(taskTwo);
		Task taskThree = new Task("Supervise development", 20);
		System.out.println(taskThree);
		
		Gaji gajiAnn = new Gaji("Ann", 3);
		Gaji gajiBob = new Gaji("Bob", 2);
		Gaji gajiCharlie = new Gaji("Charlie", 1);
		
		ann.workOnTask(taskOne, gajiAnn);
		bob.workOnTask(taskTwo, gajiBob);
		charlie.workOnTask(taskThree, gajiCharlie);
		
		System.out.println(taskOne);
		System.out.println(taskTwo);
		System.out.println(taskThree);
		
		gajiAnn.dispenseWages();
		gajiBob.dispenseWages();
		gajiCharlie.dispenseWages();
	}
}
