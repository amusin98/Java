package by.gstu.lab1.actions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import by.gstu.lab1.entities.Faculty;
import by.gstu.lab1.entities.Student;

public class FileActions {
	public static Collection<Student> getStudents(String path) {
		File file = new File(path);
		List<Student> students = new ArrayList<>();
		try {
			List<String> lines = Files.readAllLines(file.toPath());
			for(String line : lines) {
				String[] parts = line.split(",");
				try {
					Student student = new Student(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], new SimpleDateFormat("dd/MM/yyyy").parse(parts[4]), parts[5]);
					student.setPhone(parts[6]);
					student.setFaculty(Faculty.valueOf(parts[7]));
					student.setGroup(parts[8]);
					student.setCourse(Integer.parseInt(parts[9]));
					students.add(student);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}
}
