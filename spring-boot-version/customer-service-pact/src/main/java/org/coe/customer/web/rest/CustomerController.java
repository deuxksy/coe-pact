package org.coe.customer.web.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.coe.customer.domain.Customer;
import org.coe.customer.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

import static org.coe.customer.web.rest.ApiConstants.API_V1_BASE_PATH;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(value = API_V1_BASE_PATH + "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @ApiOperation(value = "register customer")
    public Customer register(@RequestBody Customer customer) {
        return customerService.register(customer);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "get customer")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "customer id", required = true, dataType = "int", paramType = "path")
    })
    public Customer get(@PathVariable Integer id) {
        Customer customer = customerService.get(id);
        customer.add(linkTo(methodOn(this.getClass()).get(id)).withSelfRel());
        return customer;
    }

    @GetMapping
    @ApiOperation(value = "get all customer")
    public List<Customer> getAll() {
        return customerService.getAll();
    }
}