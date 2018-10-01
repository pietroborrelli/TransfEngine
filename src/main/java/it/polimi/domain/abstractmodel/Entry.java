package it.polimi.domain.abstractmodel;

public class Entry {

	private String id;
	private String name;
	private String type;
	
	public Entry() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Entry(String id) {
		super();
		this.id=id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Entry [name=" + name + ", type=" + type + "]";
	}
	
}
