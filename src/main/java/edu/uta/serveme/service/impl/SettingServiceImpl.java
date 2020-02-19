package edu.uta.serveme.service.impl;

import edu.uta.serveme.constant.Constant;
import edu.uta.serveme.entity.Setting;
import edu.uta.serveme.mapper.SettingMapper;
import edu.uta.serveme.service.SettingService;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author hxy
 */
@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class SettingServiceImpl implements SettingService {

    private final SettingMapper settingMapper;

    @Override
    public List<Setting> findBySelective(Setting setting) {
        return settingMapper.findBySelective(setting);
    }

    @Override
    public int insertSetting(Setting setting) {
        return settingMapper.insert(setting);
    }

    @Override
    public int updateSetting(Setting setting) {
        return settingMapper.updateByPrimaryKeySelective(setting);
    }

    @Override
    public Setting initSetting(Setting setting) {

        Setting settingDto = new Setting();
        settingDto.setUserId(setting.getUserId());
        List<Setting> settingList = findBySelective(settingDto);

        if(settingList.size() == 0){
            setting.setNotification(Constant.SETTING_NOTIFICATION_ON);
            setting.setVibration(Constant.SETTING_VIBRATION_ON);
            insertSetting(setting);
            return settingMapper.selectByPrimaryKey(setting.getId());
        } else {
            return settingList.get(0);
        }
    }
}
