package com.payment.demo.Repository;

import com.payment.demo.Domain.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommodityRepository extends JpaRepository<Commodity, Long> {
     Commodity findByName(String name);
}
