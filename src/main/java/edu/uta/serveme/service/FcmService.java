package edu.uta.serveme.service;

import edu.uta.serveme.entity.Fcm;

import java.util.List;

/**
 * @author hxy
 */
public interface FcmService {

    Fcm findFcmById(int id);

    List<Fcm> findFcmBySelective(Fcm fcm);

    int insertFcm(Fcm fcm);

    int updateFcm(Fcm fcm);

    int register(Fcm fcm);

    void sendNotification(int userId, String title, String body);
}
