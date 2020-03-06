package edu.uta.serveme.service;

import edu.uta.serveme.entity.Bid;

import java.util.List;

/**
 * @author hxy
 */
public interface BidService {

    List<Bid> selectBySelective(Bid bid);

    int insertBid(Bid bid);

    int updateBid(Bid bid);
}
