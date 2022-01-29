package com.dependancy.dependencyInjection;

import org.springframework.data.repository.CrudRepository;

public interface CustomersRepo extends CrudRepository<customers,Integer>{

	customers getOne(int custid);
	
}
