package com.travelagency.serviceorder.repo;

import com.travelagency.serviceorder.repo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo  extends JpaRepository<Order, Long> {

}

