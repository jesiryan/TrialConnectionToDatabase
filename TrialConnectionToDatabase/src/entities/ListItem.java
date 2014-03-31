package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the listitem database table.
 * 
 */
@Entity
@NamedQuery(name="ListItem.findAll", query="SELECT l FROM ListItem l")
public class ListItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String itemContent;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public ListItem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemContent() {
		return this.itemContent;
	}

	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}