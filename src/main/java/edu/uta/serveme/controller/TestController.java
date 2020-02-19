package edu.uta.serveme.controller;

import edu.uta.serveme.base.BaseResponse;
import edu.uta.serveme.base.ResultResponse;
import edu.uta.serveme.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author hxy
 */
@RestController
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class TestController {

    @GetMapping(value = "")
    public BaseResponse<String> test() {

        return new ResultResponse<>("hello world");
    }
}
