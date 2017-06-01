package com.icss.hibernate.test;

import java.util.List;

import com.icss.hibernate.model.entity.Order;
import com.icss.hibernate.model.entity.Product;
import com.icss.hibernate.model.entity.User;

public class Test2 {

	public static void main(String[] args) {

		String sql = " SELECT * FROM User ";
		
		List<User> userList = null;
		
		for(User u:userList){
			
			String sql1 = " SELECT * FROM Order o WHERE o.user.id = '" + u.getId() + "' ";
			
			List<Order> orderList = null;
			
			for(Order o:orderList){
				
				String sql2 = " SELECT * FROM Product p WHERE p.id = '" + o.getProduct().getId() + "' ";
				
				Product p = null;
				
				o.setProduct(p);
				
			}
			
			
		}
		
		
		
	}

}
