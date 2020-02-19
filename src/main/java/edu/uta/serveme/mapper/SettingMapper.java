package edu.uta.serveme.mapper;

import edu.uta.serveme.entity.Setting;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SettingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Setting record);

    int insertSelective(Setting record);

    Setting selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Setting record);

    int updateByPrimaryKey(Setting record);

    List<Setting> findBySelective(Setting setting);
}