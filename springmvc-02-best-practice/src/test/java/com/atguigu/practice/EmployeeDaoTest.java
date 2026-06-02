package com.atguigu.practice;

import com.atguigu.practice.bean.Employee;
import com.atguigu.practice.dao.EmployeeDao;
import com.atguigu.practice.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class EmployeeDaoTest {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    EmployeeService employeeService;


    @Test
    public void testEmployeeService() {
//        Employee employee = new Employee();
//       employee.setId(4L);
////       employee.setName("李四22");
////       employee.setAge(10);
////       employee.setEmail("aaa");
////       employee.setGender("#");
//       employee.setAddress("下次对对对");
//       employee.setSalary(new BigDecimal("0.1"));
//
//        employeeService.updateEmp(employee);

        Employee employee = employeeService.getEmp(4L);
        System.out.println("employee" + employee);

    }




    @Test
    public void testEmployeeDao() {
////       Employee empById = employeeDao.getEmployeeById(4L);
////       System.out.println("empById" + empById);
//
//       Employee employee = new Employee();
//       employee.setId(5L);
//       employee.setName("李四22");
//       employee.setAge(10);
//       employee.setEmail("aaa");
//       employee.setGender("#");
//       employee.setAddress("下次对对对");
//       employee.setSalary(new BigDecimal("0.1"));
//
////       employeeDao.addEmployee(employee);
////       System.out.println("添加成功");
//        employeeDao.updataEmployee(employee);
//        System.out.println("修改成功");

        employeeDao.deleteEmployeeById(5L);

    }
}
