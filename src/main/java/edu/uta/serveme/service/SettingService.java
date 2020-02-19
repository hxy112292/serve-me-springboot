package edu.uta.serveme.service;

import edu.uta.serveme.entity.Setting;

import java.util.List;

/**
 * @author hxy
 */
public interface SettingService {

    List<Setting> findBySelective(Setting setting);

    int insertSetting(Setting setting);

    int updateSetting(Setting setting);

    Setting initSetting(Setting setting);
}
