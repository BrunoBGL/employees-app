package com.example.employees;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeService {

	List<Employee> employeelist = EmployeeList.getInstance();
	
	//Listar todos os empregados
	public List<Employee>getAllEmployess(){
		return employeeList;
	}
	
	//Listar todos os empregados com Nome o Sobrenome compativel com o searchParam, ordenadopelo nome ou sobrenome.
	public List<Employee> searchEmployeeByName(String searchParam){
		
		Comparator<Employee> groupByComparator = Comparator.comparing(Employee :: getName).thenComparing(Employee::getLastName);
		List<Employee> result = employeeList.stream().filter(e -> e.getName().equalsIgnoreCase(searchParam) || e.getLastName().equalsIgnoreCase(searchParam))
				.sorted(grouoByComparator).collect(Collectors.toList());
		return result;
	}
	
	public Employee gerEmployee(long id) throws Exception{
		Optional<Employee>match = employeelist.stream().filter(e.getId() == id).findFirst();
		if (match.isPresent()) {
			return match.get();
		}else {
			throw new Exception("The Employee id "+id+" not found");
		}
	}
	
	
	
}
