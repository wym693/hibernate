package bean;

import java.util.HashSet;
import java.util.Set;

public class Student {
	
   private int id;
   
   private String name;
   
   
   //关系属性 对方类型作为自己属性
   private Teacher teacher;
   
   
   //关联关系 科目集合
   private Set<Subject> subjects=new HashSet<Subject>();
   
   //关系属性  学生证关系 一对一
   private StudentCard card;
   
   
   
   
   
   
   
   
   
   public StudentCard getCard() {
	return card;
}

public void setCard(StudentCard card) {
	this.card = card;
}

public Set<Subject> getSubjects() {
	return subjects;
}

public void setSubjects(Set<Subject> subjects) {
	this.subjects = subjects;
}

public Teacher getTeacher() {
	return teacher;
}

public void setTeacher(Teacher teacher) {
	this.teacher = teacher;
}

public Student(String name) {
	super();
	this.name = name;
}

public Student() {
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
