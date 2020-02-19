package edu.uta.serveme.service.impl;

import edu.uta.serveme.entity.Service;
import edu.uta.serveme.mapper.ServiceMapper;
import edu.uta.serveme.service.ServeService;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author hxy
 */
@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServeServiceImpl implements ServeService {

    private final ServiceMapper serviceMapper;

    @Override
    public List<Service> findServiceBySelective(Service service) {
        return serviceMapper.findBySelective(service);
    }

    @Override
    public List<Service> findVendorByService(Service service) {
        return serviceMapper.findVendorByService(service);
    }

    @Override
    public int insertService(Service service) {
        return serviceMapper.insert(service);
    }

    @Override
    public int updateService(Service service) {
        return serviceMapper.updateByPrimaryKeySelective(service);
    }

    @Override
    public int deleteService(int id) {
        return serviceMapper.deleteByPrimaryKey(id);
    }
}
