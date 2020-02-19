package edu.uta.serveme.service.impl;

import edu.uta.serveme.entity.Point;
import edu.uta.serveme.mapper.PointMapper;
import edu.uta.serveme.service.PointService;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author hxy
 */
@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class PointServiceImpl implements PointService {

    private final PointMapper pointMapper;

    @Override
    public List<Point> findBySelective(Point point) {
        return pointMapper.findBySelective(point);
    }
}
