package edu.uta.serveme.mapper;

import com.github.pagehelper.Page;
import edu.uta.serveme.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hxy
 */
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> findBySelective(User record);

    User findAccount(User record);
}