package edu.uta.serveme.controller;

import edu.uta.serveme.base.BaseResponse;
import edu.uta.serveme.base.ResultResponse;
import edu.uta.serveme.entity.Bid;
import edu.uta.serveme.service.BidService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hxy
 */
@RestController
@RequestMapping(value = "/bid")
@RequiredArgsConstructor
public class BidController {

    private final BidService bidService;

    @GetMapping(value = "/searchBid")
    public BaseResponse<List<Bid>> searchBid(@RequestParam(value = "orderId", required = false) int orderId,
                                                 @RequestParam(value = "vendorId", required = false) int vendorId) {

        Bid bid = new Bid();
        bid.setOrderId(orderId);
        bid.setVendorId(vendorId);
        return new ResultResponse<>(bidService.selectBySelective(bid));
    }

    @PostMapping(value = "/insertBid")
    public BaseResponse<Integer> insertBid(@RequestBody Bid bid) {

        return new ResultResponse<>(bidService.insertBid(bid));
    }

    @PutMapping(value = "/updateBid")
    public BaseResponse<Integer> updateBid(@RequestBody Bid bid) {

        return new ResultResponse<>(bidService.updateBid(bid));
    }
}
