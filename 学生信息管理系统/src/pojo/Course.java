package pojo;

public class Course {
	private String id;//�γ̵�id
	private String name;//�γ̵�����
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return " [�γ̱��=" + id + ", �γ���=" + name + "]";
	}}


