package edu.uta.serveme.service;

import edu.uta.serveme.entity.Address;

import java.util.List;

/**
 * @author hxy
 */
public interface AddressService {

    List<Address> selectBySelective(Address address);

    int updateAddress(Address address);

    int insertAddress(Address address);

    int deleteAddress(int id);
}
