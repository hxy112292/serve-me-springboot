package edu.uta.serveme.mapper;

import edu.uta.serveme.entity.Bid;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BidMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bid record);

    int insertSelective(Bid record);

    Bid selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bid record);

    int updateByPrimaryKey(Bid record);

    List<Bid> selectBySelective(Bid bid);
}