package by.gstu.lab1.entities;


import by.gstu.lab1.actions.FileActions;

public class Runner {

	public static void main(String[] args) {
		University gstu = new University("GSTU");
		gstu.setStudents(FileActions.getStudents("students.txt"));
		System.out.println("All students of FAIS: " + gstu.getByFaculty(Faculty.valueOf("FAIS")));
		
		for(Faculty fac : Faculty.values()) {
			System.out.println("Students of " + fac.toString() + ": " + gstu.getByFaculty(fac));
		}
		
		for(int i = 1; i < 5; i++) {
			System.out.println("Students of " + i + " course: " + gstu.getByCourse(i));
		}
		
		System.out.println("Students, who was born later than 1997: " + gstu.getByAge(1997));
		
		System.out.println("Students of IT-32: " + gstu.getByGroup("IT-32"));
	}

}
