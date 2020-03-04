package edu.uta.serveme.service.impl;

import edu.uta.serveme.entity.Address;
import edu.uta.serveme.mapper.AddressMapper;
import edu.uta.serveme.service.AddressService;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author hxy
 */
@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressMapper addressMapper;

    @Override
    public List<Address> selectBySelective(Address address) {
        return addressMapper.selectBySelective(address);
    }

    @Override
    public int updateAddress(Address address) {

        address.setUpdateTime(new Date());
        return addressMapper.updateByPrimaryKeySelective(address);
    }

    @Override
    public int insertAddress(Address address) {

        address.setCreateTime(new Date());
        return addressMapper.insert(address);
    }

    @Override
    public int deleteAddress(int id) {
        return addressMapper.deleteByPrimaryKey(id);
    }
}
