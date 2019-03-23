package com.sloboda.hibernateprobe.repository;

import com.sloboda.hibernateprobe.entity.article.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
