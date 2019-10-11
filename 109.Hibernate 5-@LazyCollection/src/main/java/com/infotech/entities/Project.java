package com.infotech.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="project")
@NamedEntityGraph(name="project.employees",
        attributeNodes=@NamedAttributeNode(value="employees",subgraph="project.employees.department"),
        subgraphs=@NamedSubgraph(name="project.employees.department",attributeNodes=@NamedAttributeNode("department")))
public class Project {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="project_name",nullable=false,length=100)
    private String projectName;

    @ManyToMany
    @JoinTable(name="project_employee",joinColumns=@JoinColumn(name="project_id"),inverseJoinColumns=@JoinColumn(name="employee_id"))
    private List<Employee> employees = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}