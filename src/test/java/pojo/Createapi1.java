package pojo;

public class Createapi1 {
	
	public Createapi1() {
		
	}
	public Createapi1(String name, String description, Boolean _public) {
		
		this.name = name;
		this.description = description;
		this._public = _public;
	}
	String name;
	String description;
	Boolean _public;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean get_public() {
		return _public;
	}
	public void set_public(Boolean _public) {
		this._public = _public;
	}
	
	
	

}
