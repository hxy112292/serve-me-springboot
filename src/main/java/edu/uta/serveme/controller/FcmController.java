package edu.uta.serveme.controller;

import edu.uta.serveme.base.BaseResponse;
import edu.uta.serveme.base.ResultResponse;
import edu.uta.serveme.entity.Fcm;
import edu.uta.serveme.service.FcmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hxy
 */
@RestController
@RequestMapping(value = "/fcm")
@RequiredArgsConstructor
public class FcmController {

    private final FcmService fcmService;

    @PostMapping(value = "/register")
    public BaseResponse<Integer> registerFcm(@RequestBody Fcm fcm) {
        return new ResultResponse<>(fcmService.register(fcm));
    }
}
