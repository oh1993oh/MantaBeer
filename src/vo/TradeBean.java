package vo;

import java.sql.Date;

public class TradeBean {
	private int trade_num;
	private int trade_quantity;
	private int product_product_num;
	private int user_user_num;
	private int trade_classification;
	private Date trade_date;
	private String trade_notice;
	private int trade_sale;
	private Date trade_state_date;
	private String trade_state;
	private String product_name;
	private int product_price;
	private int adress_adress_num;
	/////
	private String user_name;
	private int  totalprice;
	private String adress;
	/////
	
	public int getTrade_num() {
		return trade_num;
	}
	public void setTrade_num(int trade_num) {
		this.trade_num = trade_num;
	}
	public int getTrade_quantity() {
		return trade_quantity;
	}
	public void setTrade_quantity(int trade_quantity) {
		this.trade_quantity = trade_quantity;
	}
	public int getProduct_product_num() {
		return product_product_num;
	}
	public void setProduct_product_num(int product_product_num) {
		this.product_product_num = product_product_num;
	}
	public int getUser_user_num() {
		return user_user_num;
	}
	public void setUser_user_num(int user_user_num) {
		this.user_user_num = user_user_num;
	}
	public int getTrade_classification() {
		return trade_classification;
	}
	public void setTrade_classification(int trade_classification) {
		this.trade_classification = trade_classification;
	}
	public Date getTrade_date() {
		return trade_date;
	}
	public void setTrade_date(Date trade_date) {
		this.trade_date = trade_date;
	}
	public String getTrade_notice() {
		return trade_notice;
	}
	public void setTrade_notice(String trade_notice) {
		this.trade_notice = trade_notice;
	}
	public int getTrade_sale() {
		return trade_sale;
	}
	public void setTrade_sale(int trade_sale) {
		this.trade_sale = trade_sale;
	}
	public Date getTrade_state_date() {
		return trade_state_date;
	}
	public void setTrade_state_date(Date trade_state_date) {
		this.trade_state_date = trade_state_date;
	}
	public String getTrade_state() {
		return trade_state;
	}
	public void setTrade_state(String trade_state) {
		this.trade_state = trade_state;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public int getAdress_adress_num() {
		return adress_adress_num;
	}
	public void setAdress_adress_num(int adress_adress_num) {
		this.adress_adress_num = adress_adress_num;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}

}
