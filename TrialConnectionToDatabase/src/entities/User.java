package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String password;

	private String username;

	private String userType;

	//bi-directional many-to-one association to ListItem
	@OneToMany(mappedBy="user")
	private List<ListItem> listitems;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public List<ListItem> getListitems() {
		return this.listitems;
	}

	public void setListitems(List<ListItem> listitems) {
		this.listitems = listitems;
	}

	public ListItem addListitem(ListItem listitem) {
		getListitems().add(listitem);
		listitem.setUser(this);

		return listitem;
	}

	public ListItem removeListitem(ListItem listitem) {
		getListitems().remove(listitem);
		listitem.setUser(null);

		return listitem;
	}

}