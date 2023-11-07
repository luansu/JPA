package hcmute.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u from Users u")
public class Users implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String email;
	private String fullname;
	private int phone;
	private String passwd;
	private Date signup_date;
	private Date last_login;
	private boolean is_admin;
	
	@OneToMany(mappedBy="user")
	private List<Rating> rating_list;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(int id, String email, String fullname, int phone, String passwd, Date signup_date, Date last_login,
			boolean is_admin, List<Rating> rating_list) {
		super();
		this.id = id;
		this.email = email;
		this.fullname = fullname;
		this.phone = phone;
		this.passwd = passwd;
		this.signup_date = signup_date;
		this.last_login = last_login;
		this.is_admin = is_admin;
		this.rating_list = rating_list;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Date getSignup_date() {
		return signup_date;
	}

	public void setSignup_date(Date signup_date) {
		this.signup_date = signup_date;
	}

	public Date getLast_login() {
		return last_login;
	}

	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}

	public boolean isIs_admin() {
		return is_admin;
	}

	public void setIs_admin(boolean is_admin) {
		this.is_admin = is_admin;
	}

	public List<Rating> getRating_list() {
		return rating_list;
	}

	public void setRating_list(List<Rating> rating_list) {
		this.rating_list = rating_list;
	}	
}
