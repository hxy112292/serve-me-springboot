package edu.uta.serveme.service.impl;

import edu.uta.serveme.constant.Constant;
import edu.uta.serveme.entity.Fcm;
import edu.uta.serveme.entity.Setting;
import edu.uta.serveme.fcm.FcmClient;
import edu.uta.serveme.mapper.FcmMapper;
import edu.uta.serveme.mapper.SettingMapper;
import edu.uta.serveme.service.FcmService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hxy
 */
@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class FcmServiceImpl implements FcmService {

    private final static Logger logger = LoggerFactory.getLogger(FcmServiceImpl.class);

    private final FcmMapper fcmMapper;
    private final SettingMapper settingMapper;
    private final FcmClient fcmClient;

    @Override
    public Fcm findFcmById(int id) {
        return fcmMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Fcm> findFcmBySelective(Fcm fcm) {
        return fcmMapper.findBySelective(fcm);
    }

    @Override
    public int insertFcm(Fcm fcm) {
        return fcmMapper.insert(fcm);
    }

    @Override
    public int updateFcm(Fcm fcm) {
        return fcmMapper.updateByPrimaryKeySelective(fcm);
    }

    @Override
    public int register(Fcm fcm) {

        Fcm fcmDto = new Fcm();
        fcmDto.setUserId(fcm.getUserId());
        List<Fcm> fcmList = findFcmBySelective(fcmDto);

        if(fcmList.size() != 0) {
            fcmDto = fcmList.get(0);
            fcm.setId(fcmDto.getId());
            return updateFcm(fcm);
        } else {
            return insertFcm(fcm);
        }
    }

    @Override
    public void sendNotification(int userId, String title, String body) {
        Setting setting = new Setting();
        setting.setUserId(userId);
        List<Setting>settingList = settingMapper.findBySelective(setting);
        if(settingList.size() != 0 && settingList.get(0).getNotification().equals(Constant.SETTING_NOTIFICATION_OFF)) {
            return;
        }


        Fcm fcm = new Fcm();
        fcm.setUserId(userId);
        Map<String, String> message = new HashMap<>();
        message.put("id", "1");
        message.put("title", title);
        message.put("body", body);
        try {
            fcmClient.sendPersonalMessage(fcmMapper.findBySelective(fcm).get(0).getFcmToken(), message);
        } catch (Exception e) {
            logger.error("send message", e);
        }
    }
}
