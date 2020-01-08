package svc;
import static db.jdbcUtil.*;
import java.sql.Connection;

import dao.ShopDAO;

public class InsertReviewService {
   
   public void insertreview(int product_num,String user_id,String review,int star) {
      
      Connection con = getConnection();
      
      ShopDAO shopDAO = ShopDAO.getInstence();
      shopDAO.setConnection(con);
      
      int check = 0;
      check = shopDAO.InsertReview(product_num, user_id, review, star);
      
      if(check >0) {
         commit(con);
         
      }else {
         rollback(con);
      }
      
      close(con);
   }
}