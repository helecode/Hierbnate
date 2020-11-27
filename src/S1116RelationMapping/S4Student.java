package S1116RelationMapping;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity//����������һ���־û�����
@Table(name="student")//ָ���ó־û��������ɵı���
public class S4Student implements Serializable{

	@Id//ָ������Ϊ����
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sid")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column
	private String sex;
	@ManyToOne
	@JoinColumn(name="cid")
	private S5Class cid;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public S5Class getCid() {
		return cid;
	}
	public void setCid(S5Class cid) {
		this.cid = cid;
	}
	
	
}
