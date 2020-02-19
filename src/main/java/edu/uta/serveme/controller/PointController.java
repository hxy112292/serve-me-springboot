package edu.uta.serveme.controller;

import com.google.common.base.Preconditions;
import edu.uta.serveme.base.BaseResponse;
import edu.uta.serveme.base.ResultResponse;
import edu.uta.serveme.constant.ErrorMessage;
import edu.uta.serveme.entity.Point;
import edu.uta.serveme.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hxy
 */
@RestController
@RequestMapping(value = "/point")
@RequiredArgsConstructor
public class PointController {

    private final PointService pointService;

    @GetMapping(value = "/findPointByUser")
    public BaseResponse<List<Point>> findPointByUser(@RequestParam("userId") Integer userId) {

        Preconditions.checkNotNull(userId, ErrorMessage.ACCOUNT_NOT_FOUND);

        Point point = new Point();
        point.setUserId(userId);

        return new ResultResponse<>(pointService.findBySelective(point));
    }
}
