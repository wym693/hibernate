package bean;

import java.util.HashSet;
import java.util.Set;

public class Subject {
	
   private int id;
   
   private String name;
   
   
   //关系属性 对方类型作为自己属性
   private Set<Student> students=new HashSet<Student>();
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   public Set<Student> getStudents() {
	return students;
}

public void setStudents(Set<Student> students) {
	this.students = students;
}


public Subject(String name) {
	super();
	this.name = name;
}

public Subject() {
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
