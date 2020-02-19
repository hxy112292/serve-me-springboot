package edu.uta.serveme.controller;

import edu.uta.serveme.base.BaseResponse;
import edu.uta.serveme.base.ResultResponse;
import edu.uta.serveme.constant.Constant;
import edu.uta.serveme.entity.User;
import edu.uta.serveme.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author hxy
 */
@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/login")
    public BaseResponse<User> login(@RequestBody User user) {

        return new ResultResponse<>(userService.login(user));
    }

    @PostMapping(value = "/signup")
    public BaseResponse<User> signup(@RequestBody User user) {

        return new ResultResponse<>(userService.createUser(user));
    }

    @GetMapping(value = "/info")
    public BaseResponse<User> getUserInfo(@RequestParam Integer userId) {

        return new ResultResponse<>(userService.findUserById(userId));
    }

    @PutMapping(value = "/update")
    public BaseResponse<User> updateUserInfo(@RequestBody User user) {

        return new ResultResponse<>(userService.updateUser(user));
    }
}
