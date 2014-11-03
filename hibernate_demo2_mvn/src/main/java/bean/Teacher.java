package bean;

import java.util.HashSet;
import java.util.Set;

//老师1  n List Map Set
public class Teacher {

	private int id;

	private String name;
	
	private Set<Student> students=new HashSet<Student> ();
	
	
	
	
	
	
	
	
	
	

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Teacher(String name) {
		this.name = name;
	}

	public Teacher() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
