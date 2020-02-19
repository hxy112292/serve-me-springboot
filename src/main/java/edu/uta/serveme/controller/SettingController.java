package edu.uta.serveme.controller;

import edu.uta.serveme.base.BaseResponse;
import edu.uta.serveme.base.ResultResponse;
import edu.uta.serveme.entity.Fcm;
import edu.uta.serveme.entity.Setting;
import edu.uta.serveme.service.SettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author hxy
 */
@RestController
@RequestMapping(value = "/setting")
@RequiredArgsConstructor
public class SettingController {

    private final SettingService settingService;

    @PostMapping(value = "/init")
    public BaseResponse<Setting> init(@RequestBody Setting setting) {
        return new ResultResponse<>(settingService.initSetting(setting));
    }

    @PutMapping(value = "/update")
    public BaseResponse<Integer> update(@RequestBody Setting setting) {
        return new ResultResponse<>(settingService.updateSetting(setting));
    }
}
