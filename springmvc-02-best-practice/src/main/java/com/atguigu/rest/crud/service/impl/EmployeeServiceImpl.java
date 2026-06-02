package com.atguigu.rest.crud.service.impl;

import com.atguigu.rest.crud.bean.Employee;
import com.atguigu.rest.crud.dao.EmployeeDao;
import com.atguigu.rest.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public Employee getEmp(Long id) {
        Employee employeeById = employeeDao.getEmployeeById(id);
        return employeeById;
    }

    @Override
    public void updateEmp(Employee employee) {
        Long id = employee.getId();
        if (id == null) {
            return;
        }

        Employee employeeById = employeeDao.getEmployeeById(id);

        if (StringUtils.hasText(employee.getName())){
            employeeById.setName(employee.getName());
        }

        if (StringUtils.hasText(employee.getEmail())) {
            employeeById.setEmail(employee.getEmail());
        }

        if (StringUtils.hasText(employee.getGender())) {
            employeeById.setGender(employee.getGender());
        }

        if (StringUtils.hasText(employee.getAddress())) {
            employeeById.setAddress(employee.getAddress());
        }

        if (employee.getSalary() != null) {
            employeeById.setSalary(employee.getSalary());
        }

        if (employee.getAge() != null) {
            employeeById.setAge(employee.getAge());
        }

        employeeDao.updataEmployee(employeeById);
    }

    @Override
    public void saveEmp(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public void deleteEmp(Long id) {
        employeeDao.deleteEmployeeById(id);
    }
}
