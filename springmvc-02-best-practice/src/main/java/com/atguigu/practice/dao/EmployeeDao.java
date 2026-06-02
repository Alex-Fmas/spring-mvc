package com.atguigu.practice.dao;

import com.atguigu.practice.bean.Employee;

public interface EmployeeDao {

    /**
     * 根据ID查询员工信息
     * @param id
     * @return Employee
     */
    Employee getEmployeeById(Long id);

    /**
     * 新增员工
     * @param employee
     */
    void addEmployee(Employee employee);

    /**
     * 修改员工信息
     * @param employee
     */
    void updataEmployee(Employee employee);

    /**
     * 按照ID删除员工
     * @param id
     */
    void deleteEmployeeById(Long id);

}
