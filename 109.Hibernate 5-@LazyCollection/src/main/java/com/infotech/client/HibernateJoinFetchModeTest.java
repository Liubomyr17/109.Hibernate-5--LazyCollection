package com.infotech.client;

import com.infotech.entities.Department;
import com.infotech.entities.Employee;
import com.infotech.entities.Project;
import com.infotech.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Collections;
import java.util.List;

public class HibernateJoinFetchModeTest {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Long departmentId = 1L;
            Department department = session.get(Department.class, departmentId);
            if(department != null){
                System.out.println("Department ID:"+department.getId());
                List<Employee> employees = department.getEmployees();
                System.out.println("Employees count:" + employees.size());
                for (Employee employee : employees) {
                    System.out.println(employee.getEmployeeName()+"\t"+employee.getUsername());
                }
            }else{
                System.out.println("Department details not found with ID: "+departmentId);
            }

        }
    }
}