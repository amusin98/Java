/**
 * 
 */
package by.gstu.lab1.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author user
 *
 */
public class University {
	private String name;
	private Collection<Student> students;
	/**
	 * @param name
	 */
	public University(String name) {
		super();
		this.name = name;
	}
	
	
	public Collection<Student> getByFaculty(Faculty faculty) {
		Collection<Student> students = new ArrayList<>();
		for(Student st : this.getStudents()) {
			if(st.getFaculty().equals(faculty)) {
				students.add(st);
			}
		}
		return students;
	}
	
	public Collection<Student> getByCourse(int course) {
		Collection<Student> students = new ArrayList<>();
		for(Student st : this.getStudents()) {
			if(st.getCourse() == course) {
				students.add(st);
			}
		}
		return students;
	}
	
	public Collection<Student> getByGroup(String group) {
		Collection<Student> students = new ArrayList<>();
		for(Student st : this.getStudents()) {
			if(st.getGroup().equals(group)) {
				students.add(st);
			}
		}
		return students;
	}
	
	public Collection<Student> getByAge(int year) {
		Collection<Student> students = new ArrayList<>();
		for(Student st : this.getStudents()) {
			try {
				if(st.getBirthDate().compareTo(new SimpleDateFormat("dd/MM/yyyy").parse("31/12/" + year)) > 0) {
					students.add(st);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return students;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the students
	 */
	public Collection<Student> getStudents() {
		return students;
	}
	/**
	 * @param students the students to set
	 */
	public void setStudents(Collection<Student> students) {
		this.students = students;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((students == null) ? 0 : students.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		University other = (University) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "University [name=" + name + ", students=" + students + "]";
	}
	
	
}
