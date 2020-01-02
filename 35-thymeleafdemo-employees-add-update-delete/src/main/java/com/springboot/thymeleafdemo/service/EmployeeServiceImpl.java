package com.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.springboot.thymeleafdemo.dao.MojInterfejsZaDAOMetode;
import com.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService, MojInterfejsZaDAOMetode {

	@Autowired
	private MojInterfejsZaDAOMetode mojInterfejs;
	
	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	
	@Override
	//@Transactional	 NE TREBA NAM @Transactional JER NAM JpaRepository OBEZBEDJUJE TO SAM !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);	//oznaciti ovo employeeRepository.findById(theId) desni klik/refactor/extract local variable
		
		Employee theEmployee = null;
		if(result.isPresent()){	//true ako imam vrednost da vratim
			theEmployee = result.get();
		}
		else{
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

	@Override
	public void saveOrUpdateEmployee(Employee theEmployee) {
		mojInterfejs.saveOrUpdateEmployee(theEmployee);
	}

}
