package com.atguigu.rest.crud.service;

import com.atguigu.rest.crud.bean.Employee;

public interface EmployeeService {

    /**
     * 查询用户
     * @param id
     * @return
     */
    Employee getEmp(Long id);

    /**
     * 更新用户
     * @param employee
     */
    void updateEmp(Employee employee);

    /**
     * 新增用户
     * @param employee
     */
    void saveEmp(Employee employee);

    /**
     * 删除用户
     * @param id
     */
    void deleteEmp(Long id);

}
