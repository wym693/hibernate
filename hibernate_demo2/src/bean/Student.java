package bean;

import java.util.HashSet;
import java.util.Set;

public class Student {
	
   private int id;
   
   private String name;
   
   
   //��ϵ���� �Է�������Ϊ�Լ�����
   private Teacher teacher;
   
   
   //������ϵ ��Ŀ����
   private Set<Subject> subjects=new HashSet<Subject>();
   
   //��ϵ����  ѧ��֤��ϵ һ��һ
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
