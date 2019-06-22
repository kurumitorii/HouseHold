package beans;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
	private String accountid;
    private String password;
    private String branch;
    private String department;
    private String authuser;
    private Date createdDate;
    private Date updatedDate;
    private String account;
    private String search;
    private String datesearch;
    private String datesearch2;

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
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public String getAccountid() {
		return accountid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getAuthuser() {
		return authuser;
	}
	public void setAuthuser(String authuser) {
		this.authuser = authuser;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String search) {
		this.search = search;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String account) {
		this.account = account;
	}
	public String getDatesearch() {
		return datesearch;
	}
	public void setDatesearch(String datesearch) {
		this.datesearch = datesearch;
	}
	public String getDatesearch2() {
		return datesearch2;
	}
	public void setDatesearch2(String datesearch2) {
		this.datesearch2 = datesearch2;
	}
}

