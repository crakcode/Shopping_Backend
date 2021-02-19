package com.shopping.dao.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shopping.entity.Order;
import com.shopping.entity.Product;
import com.shopping.entity.User;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {


	@Query(value="select ohp.ohp_id from tb_order o join tb_order_have_product ohp on ohp.o_id=o.o_id where o.o_id=:oId",nativeQuery=true)
	Long findByUidForOhpid(@Param("oId") Long oId);

	
	@Query(value="select ohp.ohp_id from tb_order_have_product ohp join tb_order o on ohp.o_id=o.o_id where o.o_id=:oId and o.id=:id",nativeQuery=true)
	Long findByOrderUsingId(Long oId,Long id);
	
	@Query(value="select ohp.ohp_id from tb_order_have_product ohp join tb_order o on ohp.o_id=o.o_id where ohp.status=:status and o.id=:id",nativeQuery=true)
	List<Long> findByOhpIdByStatusAndID(String status,Long id);



}
