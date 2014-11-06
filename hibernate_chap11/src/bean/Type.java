package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Type {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_movie")
	@SequenceGenerator(sequenceName="seq_movie",name="seq_movie",initialValue=1,allocationSize=1)
	
	private int id;
	
	@Column
	private String name;
	


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
