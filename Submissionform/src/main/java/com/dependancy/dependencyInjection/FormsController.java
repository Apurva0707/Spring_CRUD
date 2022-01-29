package com.dependancy.dependencyInjection;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class FormsController 
{ 
	@Autowired
	CustomersRepo repo;
	@RequestMapping("/")
	public String details()
	{
		return "apurva";
	}
	
	@RequestMapping("/details")
	public String details(customers cust)
	{
		repo.save(cust);
		return "apurva";
	}
	
	@RequestMapping("/getdetails")
	public String getdetails()
	{
		return "ViewCustomer";
	}
	
	@PostMapping("/getdetails")
	public ModelAndView getdetails(@RequestParam int custid)
	{
		ModelAndView mv= new ModelAndView("Retrive");
		customers cust = repo.findById(custid).orElse(null);
		mv.addObject(cust);
		return mv;
	}
	@RequestMapping("/customers")
	@ResponseBody
	public List<customers> GetCustomers()
	{
		return (List<customers>) repo.findAll();
	}
	
	@RequestMapping("/customers/{custid}")
	@ResponseBody
	public Optional<customers> GetCustomersbyid(@PathVariable("custid") int custid)
	{
		return repo.findById(custid);
	}
	
	@PostMapping("/customers")
	public customers GetCustomers2(@RequestBody customers cus)
	{
		repo.save(cus);
		return cus;
	}
	
	@DeleteMapping("/customers/{custid}")
	@ResponseBody
	public customers GetCustomers3(@PathVariable("custid") int custid)
	{
		customers cust = repo.getOne(custid);
		repo.delete(cust);
		return cust;
		
	}
	
	@PutMapping(path="/customers" ,consumes={"application/json"})
	public customers GetCustomers4(@RequestBody customers cust)
	{
		repo.save(cust);
		return cust;
		
	}
}
