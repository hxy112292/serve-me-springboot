package edu.uta.serveme.controller;

import edu.uta.serveme.base.BaseResponse;
import edu.uta.serveme.base.ResultResponse;
import edu.uta.serveme.entity.Service;
import edu.uta.serveme.service.ServeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hxy
 */
@RestController
@RequestMapping(value = "/service")
@RequiredArgsConstructor
public class ServiceController {

    private final ServeService serveService;

    @GetMapping(value = "/searchVendor")
    public BaseResponse<List<Service>> searchVendor(@RequestParam(value = "city", required = false) String city, @RequestParam("type") String type, @RequestParam(value = "vendorId", required = false) Integer vendorId) {

        Service service = new Service();
        service.setCity(city);
        service.setType(type);
        service.setVendorId(vendorId);
        return new ResultResponse<>(serveService.findVendorByService(service));
    }

    @GetMapping(value = "/findServiceByVendorId")
    public BaseResponse<List<Service>> findService(@RequestParam(value = "vendorId") Integer vendorId) {

        Service service = new Service();
        service.setVendorId(vendorId);
        return new ResultResponse<>(serveService.findVendorByService(service));
    }

    @PostMapping(value = "/insert")
    public BaseResponse<Integer> insertService(@RequestBody Service service) {
        return new ResultResponse<>(serveService.insertService(service));
    }

    @PutMapping(value = "/update")
    public BaseResponse<Integer> updateService(@RequestBody Service service) {
        return new ResultResponse<>(serveService.updateService(service));
    }

    @DeleteMapping(value = "/delete")
    public BaseResponse<Integer> deleteService(@RequestParam(value = "id") int id) {
        return new ResultResponse<>(serveService.deleteService(id));
    }
}
