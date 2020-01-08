package vo;

import java.sql.Date;

public class ReViewBean {
	private int review_num;
	private int ref_num;
	private String user_id;
	private String review;
	private Date date;
	private int star;

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String Review() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public int getReview_num() {
		return review_num;
	}
	
	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}
	
	public int getRef_num() {
		return ref_num;
	}
	
	public void setRef_num(int ref_num) {
		this.ref_num = ref_num;
	}

}
