package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


//多
@Entity
@Table
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_movie")
	@SequenceGenerator(sequenceName="seq_movie",name="seq_movie",initialValue=1,allocationSize=1)
	private int id;
	
	@Column
	private String titile;
	@Column
	private String director;
	@Column
	
	private String actor;
	@Column
	
	private Double price;
	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name="typeid")
	private Type   type;
	
	
	public Movie() {
	}
	

	public Movie(String titile, String director, String actor,
			Double price, Type type) {
		this.titile = titile;
		this.director = director;
		this.actor = actor;
		this.price = price;
		this.type = type;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitile() {
		return titile;
	}

	public void setTitile(String titile) {
		this.titile = titile;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	
	
	
	
	
	
	
	

}
