package S1116RelationMapping;

import java.util.Set;

public class S2Department {
	private int did;
	private String dname;
	private Set<S1Staff> staffSet;
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Set<S1Staff> getStaffSet() {
		return staffSet;
	}
	public void setStaffSet(Set<S1Staff> staffSet) {
		this.staffSet = staffSet;
	}
	
}
