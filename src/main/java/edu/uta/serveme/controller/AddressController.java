package edu.uta.serveme.controller;

import edu.uta.serveme.base.BaseResponse;
import edu.uta.serveme.base.ResultResponse;
import edu.uta.serveme.entity.Address;
import edu.uta.serveme.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hxy
 */
@RestController
@RequestMapping(value = "/address")
@RequiredArgsConstructor
public class AddressController {


    private final AddressService addressService;

    @GetMapping(value = "/findByCustomer")
    public BaseResponse<List<Address>> findByCustomer(@RequestParam int userId) {

        Address address = new Address();
        address.setUserId(userId);
        return new ResultResponse<>(addressService.selectBySelective(address));
    }

    @PostMapping(value = "/insertAddress")
    public BaseResponse<Integer> insertAddress(@RequestBody Address address) {

        return new ResultResponse<>(addressService.insertAddress(address));
    }

    @PutMapping(value = "/updateAddress")
    public BaseResponse<Integer> updateAddress(@RequestBody Address address) {

        return new ResultResponse<>(addressService.updateAddress(address));
    }

    @DeleteMapping(value = "/deleteAddress")
    public BaseResponse<Integer> deleteAddress(@RequestParam int id) {

        return new ResultResponse<>(addressService.deleteAddress(id));
    }
}
