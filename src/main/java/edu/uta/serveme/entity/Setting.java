package edu.uta.serveme.entity;

import java.io.Serializable;

/**
 * @author hxy
 */
public class Setting implements Serializable {
    private Integer id;

    private Integer userId;

    private String vibration;

    private String notification;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getVibration() {
        return vibration;
    }

    public void setVibration(String vibration) {
        this.vibration = vibration == null ? null : vibration.trim();
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification == null ? null : notification.trim();
    }
}