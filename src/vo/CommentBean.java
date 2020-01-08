package vo;

import java.sql.Timestamp;

public class CommentBean {
	private int comment_num;
	private int comment_blog_num;
	private Timestamp comment_date;
	private int commnet_parent;
	private int comment_re_ref;
	private int comment_re_lev;
	private int comment_re_seq;
	private String comment_content;
	private String comment_name;
	
	
	
	
	public String getComment_name() {
		return comment_name;
	}
	public void setComment_name(String comment_name) {
		this.comment_name = comment_name;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}
	public int getComment_blog_num() {
		return comment_blog_num;
	}
	public void setComment_blog_num(int comment_blog_num) {
		this.comment_blog_num = comment_blog_num;
	}
	public Timestamp getComment_date() {
		return comment_date;
	}
	public void setComment_date(Timestamp comment_date) {
		this.comment_date = comment_date;
	}
	public int getCommnet_parent() {
		return commnet_parent;
	}
	public void setCommnet_parent(int commnet_parent) {
		this.commnet_parent = commnet_parent;
	}
	public int getComment_re_ref() {
		return comment_re_ref;
	}
	public void setComment_re_ref(int comment_re_ref) {
		this.comment_re_ref = comment_re_ref;
	}
	public int getComment_re_lev() {
		return comment_re_lev;
	}
	public void setComment_re_lev(int comment_re_lev) {
		this.comment_re_lev = comment_re_lev;
	}
	public int getComment_re_seq() {
		return comment_re_seq;
	}
	public void setComment_re_seq(int comment_re_seq) {
		this.comment_re_seq = comment_re_seq;
	}
	
	
}
