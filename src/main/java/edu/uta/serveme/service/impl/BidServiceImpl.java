package edu.uta.serveme.service.impl;

import edu.uta.serveme.entity.Bid;
import edu.uta.serveme.mapper.BidMapper;
import edu.uta.serveme.service.BidService;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author hxy
 */
@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class BidServiceImpl implements BidService {

    private final BidMapper bidMapper;

    @Override
    public List<Bid> selectBySelective(Bid bid) {
        return bidMapper.selectBySelective(bid);
    }

    @Override
    public int insertBid(Bid bid) {
        return bidMapper.insert(bid);
    }

    @Override
    public int updateBid(Bid bid) {
        return bidMapper.updateByPrimaryKeySelective(bid);
    }
}
