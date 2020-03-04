package edu.uta.serveme.mapper;

import edu.uta.serveme.entity.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hxy
 */
@Mapper
public interface AddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    List<Address> selectBySelective(Address address);
}