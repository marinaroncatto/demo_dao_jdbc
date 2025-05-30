package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		// Teste de Department
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("===== TEST 1: Department inset =====");
		
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = "+ newDepartment.getId());
		
		System.out.println("\n===== TEST 2: Department findById =====");
		Department dep = departmentDao.findById(4);
		System.out.println(dep);
		
		System.out.println("\n===== TEST 3: Department findAll =====");
		
		List<Department> list = departmentDao.findAll();
		
		for(Department d : list) {
			System.out.println(d);
		}
		
		System.out.println("\n===== TEST 4: Department Update =====");
		dep = departmentDao.findById(7);
		dep.setName("RH");
		departmentDao.update(dep);
		System.out.println("Update completed");
		
		System.out.println("\n===== TEST 5: Department Delete =====");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		sc.close();
	}

}
