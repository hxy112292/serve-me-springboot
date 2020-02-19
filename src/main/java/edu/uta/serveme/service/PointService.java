package edu.uta.serveme.service;

import edu.uta.serveme.entity.Point;

import java.util.List;

/**
 * @author hxy
 */
public interface PointService {

    List<Point> findBySelective(Point point);
}
