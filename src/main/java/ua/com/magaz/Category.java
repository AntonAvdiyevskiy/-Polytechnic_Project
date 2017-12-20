package ua.com.magaz;

import java.util.List;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
public class Category{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
	private List<Toy>toys;
	
	
	public Category() {
		super();
	}
	
	

	public Category(String name) {
		super();
		this.name = name;
	}

	public List<Toy> getToys() {
		return toys;
	}



	public void setToys(List<Toy> toys) {
		this.toys = toys;
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
