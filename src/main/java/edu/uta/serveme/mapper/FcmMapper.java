package edu.uta.serveme.mapper;

import edu.uta.serveme.entity.Fcm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hxy
 */
@Mapper
public interface FcmMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Fcm record);

    int insertSelective(Fcm record);

    Fcm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Fcm record);

    int updateByPrimaryKey(Fcm record);

    List<Fcm> findBySelective(Fcm fcm);
}