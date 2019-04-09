package com.ansou.spring.hibernate.controller;

import com.ansou.spring.hibernate.dao.CustomerDAO;
import com.ansou.spring.hibernate.entity.Customer;
import com.ansou.spring.hibernate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    public CustomerController() {
    }

    @GetMapping("/list")
    public String listCustomer(Model theModel) {

        List<Customer> theCustomers = customerService.getCustomers();
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Customer theCustomer = new Customer();

        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }


    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {

        Customer theCustomer = customerService.getCustomers(theId);
        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int theId) {
        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }
}
