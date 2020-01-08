package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static db.jdbcUtil.*;

import vo.AdressBean;
import vo.ReViewBean;
import vo.ShopBean;
import vo.TradeBean;

public class ShopDAO {
	Connection con;

	private ShopDAO() {
	};

	private static ShopDAO instance;

	public static ShopDAO getInstence() {

		if (instance == null) {
			instance = new ShopDAO();
		}

		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int selectListCount(String category, String origin) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int listCount = 0;
		
		String sql = "";
		try {
			sql = "select count(*) from product";
			if(category != null || origin != null) {
				sql = sql + " where ";
				if(category != null) {
					sql = sql + "product_category like '%" + category + "%'";
				}
				if(origin != null) {
					if(origin.equals("기타국가")) {
						sql = sql + "product_origin in('이탈리아','덴마크','핀란드')";
					}else {
						sql = sql + "product_origin = '" + origin + "'";
					}
				}
			}
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("selectListCount() ���� - " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}

		return listCount;
	}

	public ArrayList<ShopBean> selectProductList(int page, int limit, String category, String origin) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ShopBean> articleList = new ArrayList<ShopBean>();
		int startRow = (page - 1) * limit;
		System.out.println("origin="+origin);
		try {
			// $$ where 판매중인지 여부판별(soldout)
			String sql = "SELECT * FROM product";
			if(category != null || origin != null) {
				sql = sql + " where ";
				if(category != null) {
					sql = sql + "product_category like '%" + category + "%'";
				}
				if(origin != null) {
					if(origin.equals("기타국가")) {
						sql = sql + "product_origin in('이탈리아','덴마크','핀란드')";
					}else {
						sql = sql + "product_origin = '" + origin + "'";
					}
				}
			}
			sql = sql + " LIMIT ?,?";
			System.out.println("sql = "+sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, limit);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ShopBean shopBean = new ShopBean();

				shopBean.setProduct_num(rs.getInt("product_num"));
				shopBean.setProduct_name(rs.getString("product_name"));
				shopBean.setProduct_category(rs.getString("product_category"));
				shopBean.setProduct_type(rs.getString("product_type"));
				shopBean.setProduct_price(rs.getInt("product_price"));
				shopBean.setProduct_sale(rs.getInt("product_sale"));
				shopBean.setProduct_weight(rs.getString("product_weight"));
				shopBean.setProduct_content(rs.getString("product_content"));
				shopBean.setProduct_origin(rs.getString("product_origin"));
				shopBean.setProduct_alcohol(rs.getString("product_alcohol"));
				shopBean.setProduct_expirationdate(rs.getString("product_expirationdate"));
				shopBean.setProduct_Quantity(rs.getInt("product_quantity"));

				articleList.add(shopBean);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("selectProductList sql구문요청 에러 :" + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("asdf"+articleList.size());
		return articleList;
	}

	public ShopBean selectProduct(int product_num) {

		ShopBean shopBean = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT p.product_num,p.product_name,p.product_category,"
					+ "p.product_type,p.product_price,p.product_sale,p.product_weight,"
					+ "p.product_material,p.product_review,"
					+ "p.product_content,p.product_origin,p.product_alcohol,p.product_expirationdate,"
					+ "p.product_quantity, ROUND(AVG(r.star),2) star FROM product p, review r WHERE p.product_num = r.ref_num and p.product_num =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, product_num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				shopBean = new ShopBean();
				shopBean.setProduct_num(rs.getInt("product_num"));
				shopBean.setProduct_name(rs.getString("product_name"));
				shopBean.setProduct_category(rs.getString("product_category"));
				shopBean.setProduct_type(rs.getString("product_type"));
				shopBean.setProduct_price(rs.getInt("product_price"));
				shopBean.setProduct_sale(rs.getInt("product_sale"));
				shopBean.setProduct_weight(rs.getString("product_weight"));
				shopBean.setProduct_material(rs.getString("product_material"));
				shopBean.setProduct_review(rs.getString("product_review"));
				shopBean.setProduct_content(rs.getString("product_content"));
				shopBean.setProduct_origin(rs.getString("product_origin"));
				shopBean.setProduct_alcohol(rs.getString("product_alcohol"));
				shopBean.setProduct_expirationdate(rs.getString("product_expirationdate"));
				shopBean.setProduct_Quantity(rs.getInt("product_quantity"));
				shopBean.setStar(rs.getDouble("star"));
			}

		} catch (Exception e) {
			System.out.println("selectProduct sql구문요청 에러 :" + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return shopBean;
	}

	public int selectUser_num(String user_id) {
		// TODO Auto-generated method stub

		int user_num = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM user WHERE user_id =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				user_num = rs.getInt("user_num");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("selectUser_num sql구문요청 에러 :" + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return user_num;
	}

	public int insertTrade_onCart(TradeBean tradeBean) {
		PreparedStatement pstmt = null;
		String sql = "";
		int insertCount = 0;

		try {
			sql = "insert into trade values(null,?,?,?,?,now(),'',?,now(),'cart',?,?,null)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, tradeBean.getTrade_quantity());
			pstmt.setInt(2, tradeBean.getProduct_product_num());
			System.out.println(tradeBean.getUser_user_num());
			pstmt.setInt(3, tradeBean.getUser_user_num());
			pstmt.setInt(4, tradeBean.getTrade_classification());
			pstmt.setInt(5, tradeBean.getTrade_sale());
			pstmt.setString(6, tradeBean.getProduct_name());
			pstmt.setInt(7, tradeBean.getProduct_price());

			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("insertTrade_onCart 에러 :" + e);
		} finally {
			close(pstmt);
		}

		return insertCount;
	}

	public boolean getPossible_onCart(int user_num, int product_num) {
		// TODO Auto-generated method stub
		boolean isPossible = true;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT product_product_num FROM trade WHERE user_user_num =? and trade_state='cart'";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user_num);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				if (rs.getInt("product_product_num") == product_num) {
					isPossible = false;
					break;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("selectUser_num sql구문요청 에러 :" + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return isPossible;
	}

	public ArrayList<TradeBean> selectCartList(int user_num) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<TradeBean> cartList = new ArrayList<TradeBean>();

		try {

			String sql = "SELECT * FROM trade where user_user_num=? and trade_state = 'cart'";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user_num);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				TradeBean tradeBean = new TradeBean();

				tradeBean.setTrade_num(rs.getInt("trade_num"));
				tradeBean.setTrade_quantity(rs.getInt("trade_quantity"));
				tradeBean.setProduct_product_num(rs.getInt("product_product_num"));
				tradeBean.setUser_user_num(rs.getInt("user_user_num"));
				tradeBean.setTrade_classification(rs.getInt("trade_classification"));
				tradeBean.setTrade_date(rs.getDate("trade_date"));
				tradeBean.setTrade_notice(rs.getString("trade_notice"));
				tradeBean.setTrade_sale(rs.getInt("trade_sale"));
				tradeBean.setTrade_state_date(rs.getDate("trade_state_date"));
				tradeBean.setTrade_state(rs.getString("trade_state"));
				tradeBean.setProduct_name(rs.getString("product_name"));
				tradeBean.setProduct_price(rs.getInt("product_price"));

				cartList.add(tradeBean);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("selectProductList sql구문요청 에러 :" + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return cartList;
	}

	public int countCartQuantity(String user_id) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int CartQuantity = 0;

		int user_num = selectUser_num(user_id);

		try {

			String sql = "select count(*) from trade where user_user_num = ? and trade_state = 'cart'";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				CartQuantity = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("selectProductList sql구문요청 에러 :" + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return CartQuantity;
	}

	public TradeBean selectProductInfo(int product_num) {
		// TODO Auto-generated method stub
		TradeBean tradeBean = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT product_name,product_price,product_sale FROM product WHERE product_num =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, product_num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				tradeBean = new TradeBean();
				tradeBean.setProduct_name(rs.getString(1));
				tradeBean.setProduct_price(rs.getInt(2));
				tradeBean.setTrade_sale(rs.getInt(3));
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("selectUser_num sql구문요청 에러 :" + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return tradeBean;
	}

	public int update_quantity(String[] quantity_array, String[] trade_num_array, String trade_notice) {
		PreparedStatement pstmt = null;
		String sql = "";
		int updateCount = 0;
		int TupdateCount = 7;

		for (int i = 0; i < quantity_array.length; i++) {
			int quantity = Integer.parseInt(quantity_array[i]);
			int trade_num = Integer.parseInt(trade_num_array[i]);
			try {
				sql = "update trade set trade_quantity=?, trade_notice=? where trade_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, quantity);
				pstmt.setString(2, trade_notice);
				pstmt.setInt(3, trade_num);

				updateCount = pstmt.executeUpdate(); // 수정
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("insertTrade_onCart 에러 :" + e);
			} finally {
				close(pstmt);
			}
			if (updateCount <= 0) {
				TupdateCount = updateCount;
			}
		}
		if (TupdateCount <= 0) {
			updateCount = TupdateCount;
		}

		return updateCount;

	}

	public ArrayList<AdressBean> selectAdressList(int user_num) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<AdressBean> adressList = new ArrayList<AdressBean>();

		try {

			String sql = "SELECT * FROM adress where adress_user_num=? and deleted = 'false'";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user_num);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				AdressBean adressBean = new AdressBean();

				adressBean.setAdress_num(rs.getInt("adress_num"));
				adressBean.setAdress_user_num(rs.getInt("adress_user_num"));
				adressBean.setAdress_table_num(rs.getInt("adress_table_num"));
				adressBean.setAdress_table_name(rs.getString("adress_table_name"));
				adressBean.setAdress_adress(rs.getString("adress_adress"));
				adressBean.setAdress_details(rs.getString("adress_details"));
				adressBean.setAdress_post_num(rs.getInt("adress_post_num"));
				adressBean.setAdress_phone_num(rs.getString("adress_phone_num"));

				adressList.add(adressBean);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("selectProductList sql구문요청 에러 :" + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return adressList;
	}

	public int cart_delete(int trade_num) {
		PreparedStatement pstmt = null;

		int deleteCount = 0;

		try {
			// board_num 에 해당하는 레코드 삭제
			String sql = "DELETE FROM trade WHERE trade_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, trade_num);
			deleteCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("deleteArticle() 오류 - " + e.getMessage());
		} finally {
			close(pstmt);
		}

		return deleteCount;
	}

	public int adress_Insert(AdressBean adressBean) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String sql = "";
		int insertCount = 0;

		try {

			sql = "insert into adress values(null,?,?,?,?,?,?,?,'false')";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, adressBean.getAdress_user_num());
			pstmt.setString(2, adressBean.getAdress_adress());
			pstmt.setString(3, adressBean.getAdress_details());
			pstmt.setInt(4, adressBean.getAdress_table_num());
			pstmt.setString(5, adressBean.getAdress_table_name());
			pstmt.setInt(6, adressBean.getAdress_post_num());
			pstmt.setString(7, adressBean.getAdress_phone_num());

			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("adress_Insert 에러 :" + e);
		} finally {
			close(pstmt);
		}

		return insertCount;
	}

	public int adress_Modify(AdressBean adressBean) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String sql = "";
		int ModifyCount = 0;

		try {
			sql = "UPDATE adress "
					+ "SET adress_adress=?,adress_details=?,adress_table_name=?,adress_post_num=?,adress_phone_num=?"
					+ " WHERE adress_user_num=? and adress_table_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, adressBean.getAdress_adress());
			pstmt.setString(2, adressBean.getAdress_details());
			pstmt.setString(3, adressBean.getAdress_table_name());
			pstmt.setInt(4, adressBean.getAdress_post_num());
			pstmt.setString(5, adressBean.getAdress_phone_num());
			pstmt.setInt(6, adressBean.getAdress_user_num());
			pstmt.setInt(7, adressBean.getAdress_table_num());

			ModifyCount = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("adress_Modify 에러 :" + e);
		} finally {
			close(pstmt);
		}

		return ModifyCount;
	}

	public int adress_Delete(AdressBean adressBean) {
		// $$ 삭제할 주소의 어드레스번호를 찾아내서 트레이드에 하나라도 등록되어있는 주소라면 deleted는 false, 포함된게 없다면 그냥
		// delete문 실행.
		PreparedStatement pstmt = null;

		int deleteCount = 0;

		try {
			// board_num 에 해당하는 레코드 삭제

			String sql = "UPDATE adress SET deleted='true'" + " WHERE adress_user_num=? and adress_table_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, adressBean.getAdress_user_num());
			pstmt.setInt(2, adressBean.getAdress_table_num());
			deleteCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("deleteArticle() 오류 - " + e.getMessage());
		} finally {
			close(pstmt);
		}

		return deleteCount;
	}

	public int placeAnOrder(int user_num, int adress_table_num) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int ModifyCount = 0;

		int trade_classification = 0;
		int adress_num = 0;
		try {
			sql = "select MAX(trade_classification) from trade";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				trade_classification = rs.getInt(1);
				trade_classification++;
				System.out.println("trade_classification = " + trade_classification);
			}

			sql = "select adress_num from adress where adress_user_num=? and adress_table_num=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, user_num);
			pstmt.setInt(2, adress_table_num);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				adress_num = rs.getInt(1);
				System.out.println("adress_num = " + adress_num);
			}

			sql = "UPDATE trade " + "SET trade_state = 'deposit_completed',trade_classification=?,adress_adress_num=?"
					+ " WHERE user_user_num=? and trade_state='cart'";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, trade_classification);
			pstmt.setInt(2, adress_num);
			pstmt.setInt(3, user_num);

			ModifyCount = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("adress_Modify 에러 :" + e);
		} finally {
			close(pstmt);
			close(rs);
		}

		return ModifyCount;
	}

	// 주문확인 메서드
	public ArrayList<TradeBean> ordertrackinglist(String id) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int userNum = 0;
		ArrayList<TradeBean> ordertrackinglist = new ArrayList<TradeBean>();

		try {
			String sql = "select * from user where user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			System.out.println(id);
			// 해당 유저가 맞는지 확인하는 구문
			while (rs.next()) {
				if (rs.getString("user_id").equals(id)) {
					userNum = rs.getInt("user_num");

				} else {
					userNum = 500;
				}
			}
			System.out.println("유저번호 : " + userNum);
			// 해당 유저의 거래 완료된 부분을 찾는 부분

			sql = "select * from trade where user_user_num=? and trade_state=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userNum);
			pstmt.setString(2, "cart");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				TradeBean tb = new TradeBean();

				tb.setTrade_classification(rs.getInt("Trade_classification"));
				tb.setProduct_product_num(rs.getInt("product_product_num"));
				tb.setProduct_product_num(rs.getInt("product_product_num"));
				tb.setTrade_state_date(rs.getDate("trade_state_date"));
				tb.setTrade_quantity(rs.getInt("trade_quantity"));
				tb.setTrade_sale(rs.getInt("trade_sale"));
				tb.setProduct_name(rs.getString("product_name"));
				tb.setProduct_price(rs.getInt("product_price"));
				tb.setAdress_adress_num(rs.getInt("adress_adress_num"));

				ordertrackinglist.add(tb);

			}
			System.out.println("DAO :" + ordertrackinglist);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("주문확인 에러 : " + e.getMessage());
		}

		return ordertrackinglist;
	}

	// ------------------------ 박광오 --------------------------------
	// ------------------------ 리뷰추가 & 리스트 ------------------------

	public ArrayList<ReViewBean> getReviewList(int board_num) {
		System.out.println("DAO.getReviewList");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ReViewBean> reviewList = new ArrayList<ReViewBean>();
		System.out.println("board_num ="+board_num);
		try {
			String sql = "select * from review where ref_num=? order by review_num";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			rs = pstmt.executeQuery();

//		         CommentBean reviewBean = new CommentBean();// 여기두면 마지막값만 저장됨
			while (rs.next()) {
				ReViewBean reviewBean = new ReViewBean(); // 중복을 제거하기 위해 여기 선언
				reviewBean.setUser_id(rs.getString("user_id"));
				reviewBean.setReview(rs.getString("Review"));// $$?????????
				reviewBean.setStar(rs.getInt("star"));
				reviewBean.setDate(rs.getDate("date"));
				reviewBean.setRef_num(rs.getInt("ref_num"));
				reviewBean.setReview_num(rs.getInt("review_num"));
				reviewList.add(reviewBean);
			}
		} catch (SQLException e) {
			System.out.println("getReviewList - 오류" + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		return reviewList;
	}

	public int InsertReview(int product_num, String user_id, String review, int star) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int review_num = 0; // 댓글번호
		int insertcount = 0; // 추가된 결과값 담을 변수

		try {
			// 원본글의 최대댓글번호(max(review_num))를 select 해야함
			// 이유는 댓글이 있는경우에는 최대댓글번호에 +1을 해줘야하고
			// 없는 경우에는 댓글번호(review_num)가 1이 되어야함
			String sql = "Select max(review_num) from review";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// review_num가 안에 글이 있으면 댓글 최대번호에 +1을 해줘라
				review_num = rs.getInt("max(review_num)") + 1;
			} else {
				// 아니면 review_num을 1로 초기화해라
				review_num = 1;
			}
			sql = "insert into review values(?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			pstmt.setInt(2, product_num);
			pstmt.setString(3, user_id);
			pstmt.setString(4, review);
			pstmt.setInt(5, star);
			insertcount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("InsertReview - 오류" + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}

		return insertcount;
	}

	// ------------------------- 박광오 끝 --------------------------------------------

	public int review_delete(int review_num) {
		PreparedStatement pstmt = null;

		int deleteCount = 0;

		try {
			// board_num 에 해당하는 레코드 삭제
			String sql = "DELETE FROM review WHERE review_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			deleteCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("deleteArticle() 오류 - " + e.getMessage());
		} finally {
			close(pstmt);
		}

		return deleteCount;
	}

	public int review_update(ReViewBean reViewBean) {
		PreparedStatement pstmt = null;
		String sql = "";
		int ModifyCount = 0;

		System.out.println(reViewBean.getReview_num());
		System.out.println(reViewBean.Review());
		System.out.println(reViewBean.getStar());
		try {
			sql = "UPDATE review SET review=?,star=? WHERE review_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reViewBean.Review());
			pstmt.setInt(2, reViewBean.getStar());
			pstmt.setInt(3, reViewBean.getReview_num());

			ModifyCount = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("adress_Modify 에러 :" + e);
		} finally {
			close(pstmt);
		}

		return ModifyCount;
	}

	public ReViewBean getReview(int review_num) {
		System.out.println("DAO.getReview");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReViewBean reviewBean = null;

		try {
			String sql = "select * from review where review_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			rs = pstmt.executeQuery();

//		         CommentBean reviewBean = new CommentBean();// 여기두면 마지막값만 저장됨
			if (rs.next()) {
				reviewBean = new ReViewBean();
				reviewBean.setUser_id(rs.getString("user_id"));
				reviewBean.setReview(rs.getString("review"));
				reviewBean.setStar(rs.getInt("star"));
			}
		} catch (SQLException e) {
			System.out.println("getReviewList - 오류" + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		return reviewBean;
	}

	public ArrayList<ShopBean> selectBestList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ShopBean> articleList = new ArrayList<ShopBean>();
		
		
		try {
			// $$ where 판매중인지 여부판별(soldout)
			String sql = "select product_product_num, sum(trade_quantity)as q , p.* from trade t join product p "
					+ "on t.product_product_num = p.product_num "
					+ "where t.trade_state != 'cart'"
					+ "GROUP BY product_product_num "
					+ "order by q desc "
					+ "limit 0,8";
			
			
			
			System.out.println("sql = "+sql);
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ShopBean shopBean = new ShopBean();

				shopBean.setProduct_num(rs.getInt("product_num"));
				shopBean.setProduct_name(rs.getString("product_name"));
				shopBean.setProduct_category(rs.getString("product_category"));
				shopBean.setProduct_type(rs.getString("product_type"));
				shopBean.setProduct_price(rs.getInt("product_price"));
				shopBean.setProduct_sale(rs.getInt("product_sale"));
				shopBean.setProduct_weight(rs.getString("product_weight"));
//				shopBean.setProduct_content(rs.getString("product_content"));
				shopBean.setProduct_origin(rs.getString("product_origin"));
				shopBean.setProduct_alcohol(rs.getString("product_alcohol"));
				shopBean.setProduct_expirationdate(rs.getString("product_expirationdate"));
//				shopBean.setProduct_Quantity(rs.getInt("product_quantity"));

				articleList.add(shopBean);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("selectProductList sql구문요청 에러 :" + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return articleList;
	}

	public ArrayList<ShopBean> selectSaleList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ShopBean> articleList = new ArrayList<ShopBean>();
		
		
		try {
			// $$ where 판매중인지 여부판별(soldout)
			String sql = "SELECT * FROM product where product_sale >= 10 ORDER BY product_sale desc LIMIT 0,12;";
			System.out.println("sql = "+sql);
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ShopBean shopBean = new ShopBean();

				shopBean.setProduct_num(rs.getInt("product_num"));
				shopBean.setProduct_name(rs.getString("product_name"));
				shopBean.setProduct_category(rs.getString("product_category"));
				shopBean.setProduct_type(rs.getString("product_type"));
				shopBean.setProduct_price(rs.getInt("product_price"));
				shopBean.setProduct_sale(rs.getInt("product_sale"));
				shopBean.setProduct_weight(rs.getString("product_weight"));
//				shopBean.setProduct_content(rs.getString("product_content"));
				shopBean.setProduct_origin(rs.getString("product_origin"));
				shopBean.setProduct_alcohol(rs.getString("product_alcohol"));
				shopBean.setProduct_expirationdate(rs.getString("product_expirationdate"));
//				shopBean.setProduct_Quantity(rs.getInt("product_quantity"));

				articleList.add(shopBean);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("selectProductList sql구문요청 에러 :" + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return articleList;
	}

	public ArrayList<ShopBean> selectNewList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ShopBean> articleList = new ArrayList<ShopBean>();
		
		String sql = "";
		try {
			// $$ where 판매중인지 여부판별(soldout)
			int max = 0 ;
			sql = " select max(product_num) from product";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				max=rs.getInt(1);
			}
			
			max = max - 8;
			
			sql = "SELECT * FROM product LIMIT ?,8";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, max);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ShopBean shopBean = new ShopBean();
				shopBean.setProduct_num(rs.getInt("product_num"));
				shopBean.setProduct_name(rs.getString("product_name"));
				shopBean.setProduct_category(rs.getString("product_category"));
				shopBean.setProduct_type(rs.getString("product_type"));
				shopBean.setProduct_price(rs.getInt("product_price"));
				shopBean.setProduct_sale(rs.getInt("product_sale"));
				shopBean.setProduct_weight(rs.getString("product_weight"));
//				shopBean.setProduct_content(rs.getString("product_content"));
				shopBean.setProduct_origin(rs.getString("product_origin"));
				shopBean.setProduct_alcohol(rs.getString("product_alcohol"));
				shopBean.setProduct_expirationdate(rs.getString("product_expirationdate"));
//				shopBean.setProduct_Quantity(rs.getInt("product_quantity"));

				articleList.add(shopBean);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("selectProductList sql구문요청 에러 :" + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return articleList;
	}

	public ArrayList<ShopBean> selectInventory() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ShopBean> articleList = new ArrayList<ShopBean>();
		
		String sql = "";
		try {
			sql = "SELECT * FROM product";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ShopBean shopBean = new ShopBean();
				shopBean.setProduct_num(rs.getInt("product_num"));
				shopBean.setProduct_name(rs.getString("product_name"));
				shopBean.setProduct_type(rs.getString("product_type"));
				shopBean.setProduct_Quantity(rs.getInt("product_quantity"));

				articleList.add(shopBean);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("selectProductList sql구문요청 에러 :" + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return articleList;
	}

	public int stateChange(int classification, String state) {
		System.out.println("here!");
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		String sql = "";
		int updateCount = 0;

		
		try {
			sql = "update trade set trade_state=? where trade_classification=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, state);
			pstmt.setInt(2, classification);

			updateCount = pstmt.executeUpdate(); // 수정
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("insertTrade_onCart 에러 :" + e);
		} finally {
			close(pstmt);
		}
		
		if(state.equals("delivery_completed")) {
			System.out.println("here!");
			sql="SELECT t.trade_quantity,p.product_num FROM trade t, product p WHERE t.product_product_num = p.product_num and t.trade_classification=?";
			try {
				System.out.println(classification);
				pstmt2 = con.prepareStatement(sql);
				pstmt2.setInt(1, classification);

				rs = pstmt2.executeQuery();
				
				while(rs.next()) {
					System.out.println(rs.getInt("trade_quantity"));
					System.out.println(rs.getInt("product_num"));
					sql="update product set product_quantity=product_quantity-? where product_num=?";
					try {
						pstmt3 = con.prepareStatement(sql);
						pstmt3.setInt(1, rs.getInt("trade_quantity"));
						pstmt3.setInt(2, rs.getInt("product_num"));

						updateCount = pstmt3.executeUpdate(); // 수정
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("insertTrade_onCart 에러 :" + e);
					} finally {
						close(pstmt3);
					}

				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("insertTrade_onCart 에러 :" + e);
			} finally {
				close(pstmt2);
				close(rs);
			}
			
			
		}
		
		


		return updateCount;
		
	}

	public String selectUser_id(String id) {
		String user_id = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT product_name FROM trade WHERE trade_num =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				user_id = rs.getString(1);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("selectUser_num sql구문요청 에러 :" + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return user_id;
	}

}