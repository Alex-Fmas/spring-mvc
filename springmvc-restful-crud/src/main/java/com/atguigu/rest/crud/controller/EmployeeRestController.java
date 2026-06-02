package com.atguigu.rest.crud.controller;


import com.atguigu.rest.crud.bean.Employee;
import com.atguigu.rest.crud.common.R;
import com.atguigu.rest.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeRestController {

    @Autowired
    EmployeeService employeeService;

    /**
     * 获取员工数据
     * @param id
     * @return
     */
    @GetMapping(value = "/employee/{id}")
    public R<Employee> getEmp(@PathVariable Long id) {
        Employee emp = employeeService.getEmp(id);
        return R.ok(emp);

    }

    /**
     * 添加员工
     * @param employee
     */
    @PostMapping(value = "/employee")
    public R<Object> addEmp(@RequestBody Employee employee) {
        employeeService.saveEmp(employee);
        return R.ok();
    }

    /**
     * 修改员工
     * @param employee
     */
    @PutMapping(value = "/employee")
    public R<Object> updateEmp(@RequestBody Employee employee) {
        employeeService.updateEmp(employee);
        return R.ok();
    }

    @DeleteMapping(value = "/employee/{id}")
    public R<Object> deleteEmp(@PathVariable Long id) {
        employeeService.deleteEmp(id);
        return R.ok();
    }
}
