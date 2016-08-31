package kryo;

import java.io.Serializable;
import java.util.List;

public class Classes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int cno;
	private String name;
	private List<User> users;

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Classes [cno=" + cno + ", name=" + name + ", users=" + users + "]";
	}

}
