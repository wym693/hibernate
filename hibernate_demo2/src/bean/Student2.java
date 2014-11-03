package bean;

import java.util.HashSet;
import java.util.Set;

public class Student2 {
	
   private int id;
   
   private String name;
   
   
  
   //关系属性  学生证关系 一对一
   private StudentCard2 card2;
   
   public Student2() {
}
   
   
   



public Student2(String name) {
	super();
	this.name = name;
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



public StudentCard2 getCard2() {
	return card2;
}



public void setCard2(StudentCard2 card2) {
	this.card2 = card2;
}
   
   

}
