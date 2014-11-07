package bean;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

public class MovieCondition {
	


	private String titile;
	private String director;
	private String actor;
	private Double minPrice;
	private Double maxPrice;
	
	private Type   type;
	
	
	
	
	public MovieCondition(String titile, String director, String actor,
			Double minPrice, Double maxPrice, Type type) {
		this.titile = titile;
		this.director = director;
		this.actor = actor;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.type = type;
	}




	public MovieCondition() {
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

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}



	public Double getMinPrice() {
		return minPrice;
	}



	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}



	public Double getMaxPrice() {
		return maxPrice;
	}



	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}
	
	
	

}
