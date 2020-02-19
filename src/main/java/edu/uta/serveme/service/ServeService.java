package edu.uta.serveme.service;

import edu.uta.serveme.entity.Service;

import java.util.List;

/**
 * @author hxy
 */
public interface ServeService {

    List<Service> findServiceBySelective(Service service);

    List<Service> findVendorByService(Service service);

    int insertService(Service service);

    int updateService(Service service);

    int deleteService(int id);
}
