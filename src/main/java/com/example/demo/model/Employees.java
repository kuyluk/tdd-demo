/**
	* Copyright (c) minuteproject, minuteproject@gmail.com
	* All rights reserved.
	* 
	* Licensed under the Apache License, Version 2.0 (the "License")
	* you may not use this file except in compliance with the License.
	* You may obtain a copy of the License at
	* 
	* http://www.apache.org/licenses/LICENSE-2.0
	* 
	* Unless required by applicable law or agreed to in writing, software
	* distributed under the License is distributed on an "AS IS" BASIS,
	* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	* See the License for the specific language governing permissions and
	* limitations under the License.
	* 
	* More information on minuteproject:
	* twitter @minuteproject
	* wiki http://minuteproject.wikispaces.com 
	* blog http://minuteproject.blogspot.net
	* 
*/
/**
	* template reference : 
	* - Minuteproject version : 0.9.8
	* - name      : DomainEntityJPA2Annotation
	* - file name : DomainEntityJPA2Annotation.vm
	* - time      : 2017/10/18 AD at 12:04:08 BST
*/
package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * <p>Title: Employees</p>
 *
 * <p>Description: Domain Object describing a Employees entity</p>
 *
 */
@Entity (name="Employees")
@Table (name="\"employees\"")
@NamedQueries ({
	 @NamedQuery(name="Employees.findAll", query="SELECT a FROM Employees a")
	,@NamedQuery(name="Employees.findByBirthDate", query="SELECT a FROM Employees a WHERE a.birthDate = :birthDate")

	,@NamedQuery(name="Employees.findByFirstName", query="SELECT a FROM Employees a WHERE a.firstName = :firstName")
	,@NamedQuery(name="Employees.findByFirstNameContaining", query="SELECT a FROM Employees a WHERE a.firstName like :firstName")

	,@NamedQuery(name="Employees.findByLastName", query="SELECT a FROM Employees a WHERE a.lastName = :lastName")
	,@NamedQuery(name="Employees.findByLastNameContaining", query="SELECT a FROM Employees a WHERE a.lastName like :lastName")

	,@NamedQuery(name="Employees.findByGender", query="SELECT a FROM Employees a WHERE a.gender = :gender")
	,@NamedQuery(name="Employees.findByGenderContaining", query="SELECT a FROM Employees a WHERE a.gender like :gender")

	,@NamedQuery(name="Employees.findByHireDate", query="SELECT a FROM Employees a WHERE a.hireDate = :hireDate")
	 , @NamedQuery(name="Employees.findByIdWithSalaries", query="SELECT a FROM Employees a  JOIN FETCH a.salariesEmployeesViaEmpNo where a.id = :id")
	 ,@NamedQuery(name="Employees.findByProjectName", query="SELECT DISTINCT(e) FROM Employees e  JOIN FETCH e.projects p where p.name = :projectName")

})

public class Employees implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Employees.findAll";
    public static final String FIND_BY_BIRTHDATE = "Employees.findByBirthDate";
    public static final String FIND_BY_FIRSTNAME = "Employees.findByFirstName";
    public static final String FIND_BY_FIRSTNAME_CONTAINING ="Employees.findByFirstNameContaining";
    public static final String FIND_BY_LASTNAME = "Employees.findByLastName";
    public static final String FIND_BY_LASTNAME_CONTAINING ="Employees.findByLastNameContaining";
    public static final String FIND_BY_GENDER = "Employees.findByGender";
    public static final String FIND_BY_GENDER_CONTAINING ="Employees.findByGenderContaining";
    public static final String FIND_BY_HIREDATE = "Employees.findByHireDate";
    public static final String FIND_BY_ID = "Employees.findByIdWithSalaries";
    public static final String FIND_BY_PROJECT_NAME = "Employees.findByProjectName";
	
    @Id @Column(name="emp_no" ) 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empNo;

    @Column(name="birth_date"   , nullable=false , unique=false)
    private Date birthDate; 

    @Column(name="first_name"  , length=14 , nullable=false , unique=false)
    private String firstName; 


    @Column(name="last_name"  , length=16 , nullable=false , unique=false)
    private String lastName; 


    @Column(name="gender"  , length=2 , nullable=false , unique=false)
    private String gender; 


    @Column(name="hire_date"   , nullable=false , unique=false)
    private Date hireDate; 


//    @OneToMany (targetEntity=com.example.demo.model.DeptEmp.class, fetch=FetchType.LAZY, mappedBy="deptEmpId__.empNo", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
//    private Set <DeptEmp> deptEmpEmployeesViaEmpNo = new HashSet<DeptEmp>(); 
//
//
//    @OneToMany (targetEntity=com.example.demo.model.DeptManager.class, fetch=FetchType.LAZY, mappedBy="deptManagerId__.empNo", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
//    private Set <DeptManager> deptManagerEmployeesViaEmpNo = new HashSet<DeptManager>(); 

    @OneToMany (targetEntity=com.example.demo.model.Salaries.class, fetch=FetchType.LAZY, mappedBy="salariesId.empNo", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Salaries> salariesEmployeesViaEmpNo = new HashSet<Salaries>(); 

    @OneToMany(targetEntity=Project.class, mappedBy="employee", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private Set <Project> projects = new HashSet<>();
    
//    @OneToMany (targetEntity=com.example.demo.model.Titles.class, fetch=FetchType.LAZY, mappedBy="titlesId__.empNo", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
//    private Set <Titles> titlesEmployeesViaEmpNo = new HashSet<Titles>(); 

    public Set<Project> getProjects() {
    		if (this.projects == null) {
    			this.projects = new HashSet<>();
    		}
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	
	public void addProjects(Project project) {
		getProjects().add(project);
	}

	/**
    * Default constructor
    */
    public Employees() {
    }

    public Integer getEmpNo() {
        return empNo;
    }
	
    public void setEmpNo (Integer empNo) {
        this.empNo =  empNo;
    }
    
    public Date getBirthDate() {
        return birthDate;
    }
	
    public void setBirthDate (Date birthDate) {
        this.birthDate =  birthDate;
    }
	
    public String getFirstName() {
        return firstName;
    }
	
    public void setFirstName (String firstName) {
        this.firstName =  firstName;
    }
	
    public String getLastName() {
        return lastName;
    }
	
    public void setLastName (String lastName) {
        this.lastName =  lastName;
    }
	
    public String getGender() {
        return gender;
    }
	
    public void setGender (String gender) {
        this.gender =  gender;
    }
	
    public Date getHireDate() {
        return hireDate;
    }
	
    public void setHireDate (Date hireDate) {
        this.hireDate =  hireDate;
    }
	
//    public Set<DeptEmp> getDeptEmpEmployeesViaEmpNo() {
//        if (deptEmpEmployeesViaEmpNo == null){
//            deptEmpEmployeesViaEmpNo = new HashSet<DeptEmp>();
//        }
//        return deptEmpEmployeesViaEmpNo;
//    }
//
//    public void setDeptEmpEmployeesViaEmpNo (Set<DeptEmp> deptEmpEmployeesViaEmpNo) {
//        this.deptEmpEmployeesViaEmpNo = deptEmpEmployeesViaEmpNo;
//    }	
//    
//    public void addDeptEmpEmployeesViaEmpNo (DeptEmp element) {
//    	    getDeptEmpEmployeesViaEmpNo().add(element);
//    }
// 
//    public Set<DeptManager> getDeptManagerEmployeesViaEmpNo() {
//        if (deptManagerEmployeesViaEmpNo == null){
//            deptManagerEmployeesViaEmpNo = new HashSet<DeptManager>();
//        }
//        return deptManagerEmployeesViaEmpNo;
//    }
//
//    public void setDeptManagerEmployeesViaEmpNo (Set<DeptManager> deptManagerEmployeesViaEmpNo) {
//        this.deptManagerEmployeesViaEmpNo = deptManagerEmployeesViaEmpNo;
//    }	
//    
//    public void addDeptManagerEmployeesViaEmpNo (DeptManager element) {
//    	    getDeptManagerEmployeesViaEmpNo().add(element);
//    }
    
    public Set<Salaries> getSalariesEmployeesViaEmpNo() {
        if (salariesEmployeesViaEmpNo == null){
            salariesEmployeesViaEmpNo = new HashSet<Salaries>();
        }
        return salariesEmployeesViaEmpNo;
    }

    public void setSalariesEmployeesViaEmpNo (Set<Salaries> salariesEmployeesViaEmpNo) {
        this.salariesEmployeesViaEmpNo = salariesEmployeesViaEmpNo;
    }	
    
    public void addSalariesEmployeesViaEmpNo (Salaries element) {
    	    getSalariesEmployeesViaEmpNo().add(element);
    }
    
//    public Set<Titles> getTitlesEmployeesViaEmpNo() {
//        if (titlesEmployeesViaEmpNo == null){
//            titlesEmployeesViaEmpNo = new HashSet<Titles>();
//        }
//        return titlesEmployeesViaEmpNo;
//    }
//
//    public void setTitlesEmployeesViaEmpNo (Set<Titles> titlesEmployeesViaEmpNo) {
//        this.titlesEmployeesViaEmpNo = titlesEmployeesViaEmpNo;
//    }	
//    
//    public void addTitlesEmployeesViaEmpNo (Titles element) {
//    	    getTitlesEmployeesViaEmpNo().add(element);
//    }

}
