package org.coe.customer.api;

import org.coe.customer.domain.Customer;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static org.coe.customer.web.rest.ApiConstants.API_V1_BASE_PATH;

@FeignClient(
        name ="customer-service",
        url = "http://localhost:8080" + API_V1_BASE_PATH
)
public interface CustomerClient {
    @RequestMapping(method = RequestMethod.GET, value = "/customers")
    List<Customer> findAll();
}
