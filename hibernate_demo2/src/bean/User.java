package bean;

//һ��Ҫд����
public class User {
	
	private int id;
	
	private String name;
	
	private int age;
	
	private double height;
	
	
	
	public User() {
	}

	public User(String name, int age, double height) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
	}
	
	public User(String name, int age) {
		this.name = name;
		this.age = age;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	
	
}
