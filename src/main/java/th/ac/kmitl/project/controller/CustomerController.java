package th.ac.kmitl.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ac.kmitl.project.service.CustomerService;
import th.ac.kmitl.project.model.Customer;

@Controller
@RequestMapping(value = "/customer", method=RequestMethod.POST)
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String getCustomerPage(Model model) {
        model.addAttribute("allCustomer", customerService.getCustomers());
        return "customer"; // customer.html
    }
    @RequestMapping(value = "/customer", method=RequestMethod.POST)
    public String registerCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
        return "redirect:home";
    }
}
