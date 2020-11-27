package S1116RelationMapping;

public class S1Staff {
	private int sid;
	private String name;
	private S2Department department;
	private String position;
	private String phone;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public S2Department getDepartment() {
		return department;
	}
	public void setDepartment(S2Department department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
