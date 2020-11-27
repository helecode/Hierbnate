package S1114HibernateFirst;

import java.io.Serializable;
/*
 * 类名称和表名称一致
 * 属性名及类型和表字段名类型一致
 * 
 * 该类称为POJO类（简单的java对象）
 * 需要实现Serializabled接口
 */
public class S1HibernaterFirstMessage implements Serializable{
	
	 private int id;    
	 private String name;
	 private int age;   
	 private String sex;
	 private String  phone;
	 
	public S1HibernaterFirstMessage() {
		super();
	}
	
	public S1HibernaterFirstMessage(int id, String name, int age, String sex,
			String phone) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "S01HibernaterFirstMessage [id=" + id + ", name=" + name
				+ ", age=" + age + ", sex=" + sex + ", phone=" + phone + "]";
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
}
