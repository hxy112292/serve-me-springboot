package edu.uta.serveme.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import edu.uta.serveme.constant.Constant;
import edu.uta.serveme.constant.ErrorMessage;
import edu.uta.serveme.entity.Point;
import edu.uta.serveme.entity.User;
import edu.uta.serveme.mapper.PointMapper;
import edu.uta.serveme.mapper.UserMapper;
import edu.uta.serveme.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hxy
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final PointMapper pointMapper;

    @Override
    public User createUser(User user) {

        User userDto = new User();

        if(user.getUsername() != null) {
            userDto.setUsername(user.getUsername());
            userDto = userMapper.findAccount(userDto);
            if(userDto.getRole() != null && userDto.getRole().equals(Constant.GUEST)) {

            } else {
                Preconditions.checkArgument((userDto == null), ErrorMessage.USERNAME_EXIST);
            }
        }

        if(user.getEmail() != null) {
            userDto = new User();
            userDto.setEmail(user.getEmail());
            userDto = userMapper.findAccount(userDto);
            if(userDto.getRole() != null && userDto.getRole().equals(Constant.GUEST)) {

            } else {
                Preconditions.checkArgument((userDto==null), ErrorMessage.EMAIL_EXIST);
            }
        }

        if(user.getPhone() != null) {
            userDto = new User();
            userDto.setPhone(user.getPhone());
            userDto = userMapper.findAccount(userDto);
            if(userDto.getRole() != null && userDto.getRole().equals(Constant.GUEST)) {

            } else {
                Preconditions.checkArgument((userDto == null), ErrorMessage.PHONE_EXIST);
            }
        }

        userMapper.insert(user);
        user = findUserById(user.getId());

        pointCal(user, Constant.POINT_SIGN_UP, 10);
        return user;
    }

    @Override
    public List<User> findUserBySelective(User user) {

        return userMapper.findBySelective(user);
    }

    @Override
    public User login(User userDto) {

        User user = userMapper.findAccount(userDto);
        Preconditions.checkNotNull(user, ErrorMessage.ACCOUNT_NOT_FOUND);
        Preconditions.checkArgument((user.getPassword().equals(userDto.getPassword())), ErrorMessage.ACCOUNT_PASSWORD_ERROR);
        return user;
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
        user = findUserById(user.getId());
        return user;
    }

    private void pointCal(User user, String reason, Integer pointNum) {
        Point point = new Point();
        point.setUserId(user.getId());
        Map<String, String> signUp = new HashMap<>();
        signUp.put("reason", reason);
        point.setReason(JSONObject.toJSONString(signUp));
        point.setPoint(pointNum);
        point.setCreateTime(new Date());
        pointMapper.insert(point);
    }
}
