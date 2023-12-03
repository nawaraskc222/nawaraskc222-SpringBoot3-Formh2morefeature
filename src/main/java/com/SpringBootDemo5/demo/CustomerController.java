package com.SpringBootDemo5.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class CustomerController {


    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/form")
    public String showForm() {
        return "customer-form.jsp";
    }

    @PostMapping("/add")
    public String addCustomer(@RequestParam String cname,
    		@RequestParam String cmail,
    		@RequestParam int cid) {
        Customer customer = new Customer();
        customer.setCname(cname);
        customer.setCid(cid);
        customer.setCmail(cmail);
        System.out.println("Received form submission: name=" + cname + ", id=" + cid+"email="+cmail);

        customerRepository.save(customer);
        return "customer-form.jsp";
    }

    @GetMapping("/search")
    public String searchCustomerForm() {
        return "search-form.jsp";
    }

    @GetMapping("/get")
    public String getCustomerById(@RequestParam int cid, Model model) {
        Customer customer = customerRepository.findById(cid).orElse(null);
        model.addAttribute("customer", customer);
        return "display-customer.jsp";
    }


}
