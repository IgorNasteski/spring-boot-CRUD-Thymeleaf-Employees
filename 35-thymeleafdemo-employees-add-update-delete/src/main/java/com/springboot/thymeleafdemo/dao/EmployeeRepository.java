package com.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//nema potrebe za pisanjem koda
	//dobijamo za dzabe mnoge metode tipa
	//findAll()
	//findById()
	//save()
	//deleteById()
	//...ostale
	//i ne trebaju nam uopste dao interfejs i klasa koja ga implementira
	
	
	//add a method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
						 //kada ovako nazovem metodu spring ce sam to
						//da uradi, ne moram uopste da pisem metodu za sortiranje
					//vise o besplatnim query metodama na sajtu
					//www.luv2code.com/query-methods
	
	
	
	//@Modifying
    //@Query("UPDATE Employee e SET e.firstName = :firstName AND e.lastName = :lastName AND e.email = :email WHERE e.id = :id")
    //int updateAddress(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("email") String email, @Param("id") int id);
}
