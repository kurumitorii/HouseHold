package beans;

import java.io.Serializable;
import java.util.Date;

public class HouseHold implements Serializable {
    private static final long serialVersionUID = 1L;

	    private String today;
		private String accountid;
	    private String spending;
	    private String income;
	    private String categry;
	    private String memo;
	    private Date createdDate;
	    private Date updatedDate;

	    public String getToday() {
			return today;
		}
		public void setToday(String today) {
			this.today = today;
		}
		public void setAccountid(String accountid) {
			this.accountid = accountid;
		}
		public String getAccountid() {
			return accountid;
		}
		public String getSpending() {
			return spending;
		}
		public void setPassword(String spending) {
			this.spending = spending;
		}
		public String getIncome() {
			return income;
		}
		public void setIncome(String income) {
			this.income = income;
		}
		public String getCategry() {
			return categry;
		}
		public void setCategry(String categry) {
			this.categry = categry;
		}
		public String getMemo() {
			return memo;
		}
		public void setMemo(String memo) {
			this.memo = memo;
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
}
