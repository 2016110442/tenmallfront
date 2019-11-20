package com.cn.wanxi.dao.address;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cn.wanxi.model.address.Address;

import java.util.List;

/**
 * @author lxq
 * @date 2019/11/20 9:38
 */

@Repository
public interface AddressDao extends CrudRepository<Address, Long> {

    @Query("select a from Address a")
    List<Address> find(@Param("address") Address address);

    Integer insert(@Param("address") Address address);

    Integer update(@Param("address") Address address);

    Integer delete(@Param("id") Integer id);
}
