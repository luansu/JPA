package hcmute.models;

import java.io.Serializable;
import java.util.Date;

public class UsersModels implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String email;

	private String fullname;
	private int phone;
	private String passwd;
	private Date signup_date;
	private Date last_login;
	private boolean is_admin;
	
	public UsersModels() {
		super();
	}

	

	public UsersModels(int id, String username, String email, String fullname, int phone, String passwd,
			Date signup_date, Date last_login, boolean is_admin) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.fullname = fullname;
		this.phone = phone;
		this.passwd = passwd;
		this.signup_date = signup_date;
		this.last_login = last_login;
		this.is_admin = is_admin;
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

	@Override
	public String toString() {
		return "users [id=" + id + ", email=" + email + ", fullname=" + fullname + ", phone=" + phone + ", passwd="
				+ passwd + ", signup_date=" + signup_date + ", last_login=" + last_login + ", is_admin=" + is_admin
				+ "]";
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


}
