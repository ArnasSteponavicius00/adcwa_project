package com.sales.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sales.models.Order;

//References for troubleshooting: https://stackoverflow.com/questions/54507552/how-to-join-results-of-multiple-tables-in-spring-jpa-repository
//Lecture slides
@Repository
public interface OrderInterface extends CrudRepository<Order, Long>  {
	//query used to update the amount of products in stock on login, called in the SecurityConfig.java
	@Modifying
	@Transactional
	@Query(value = "update products p inner join orders o on o.p_id = p.pid set p.qtyinstock = p.qtyinstock - o.qty where o.p_id = p.pid;",
			nativeQuery = true)
	public void updateQuantity();
}
