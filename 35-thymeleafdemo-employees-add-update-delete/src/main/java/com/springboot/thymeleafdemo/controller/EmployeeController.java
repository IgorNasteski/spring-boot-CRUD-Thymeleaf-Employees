package com.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.thymeleafdemo.entity.Employee;
import com.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	//@Autowired je opciono, ne mora da se pise kada imamo samo jedan konstruktor preko koga smo injectovali
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	//add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model theModel){
		//get employees from db
		List<Employee> theEmployees = employeeService.findAll();
		
		//add to the spring model
		theModel.addAttribute("employees", theEmployees);
		
		return "/employees/list-employees";
		//trazice ovu stranicu na putanji
		//src/main/resources/templates/employees/list-employees.html
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		//create model attribute to bind form data
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "/employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee")Employee theEmployee){
		System.out.println(theEmployee.getId() + " " + theEmployee.getFirstName() + " " + theEmployee.getLastName());
		employeeService.save(theEmployee);
		System.out.println(theEmployee.getId() + " " + theEmployee.getFirstName() + " " + theEmployee.getLastName());
		
		return "redirect:/employees/list";//kada redirektujemo, bacamo nas na
						//kontroler "/list" pa gledamo njegovu html return stranicu
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId")int theId, Model model){
		Employee theEmployee = employeeService.findById(theId);
		model.addAttribute("employee", theEmployee);
		return "/employees/employee-form";
	}
	
	@GetMapping("/showFormForDelete")
	public String showFormForDelete(@RequestParam("employeeId")int theId){
		employeeService.deleteById(theId);
		return "redirect:/employees/list";
	}
	
	
	/*NA DRUGI NACIN, KOJI SAM NASAO NA NETU... U STRANICI list-employees.html JE ZAKOMENTARISAN DEO KOJI JE VEZAN ZA OVE 2 METODE
	@GetMapping("/showFormForUpdate/{employeeId}")
	public String showUpdateForm(@PathVariable("employeeId")int theId, Model model){
		Employee theEmployee = employeeService.findById(theId);
		model.addAttribute("employee", theEmployee);
		return "/employees/employee-form";
	}
	
	@GetMapping("/showFormForDelete/{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId")int theId){
		employeeService.deleteById(theId);
		return "redirect:/employees/list";
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
