
package com.example.demo.model;

import java.util.Set;
import java.util.HashSet;

import java.io.Serializable;
import javax.persistence.*;
import com.example.demo.model.DeptEmp;
import com.example.demo.model.DeptManager;

/**
 *
 * <p>Title: Departments</p>
 *
 * <p>Description: Domain Object describing a Departments entity</p>
 *
 */
@Entity (name="Departments")
@Table (name="\"departments\"")
@NamedQueries ({
	 @NamedQuery(name="Departments.findAll", query="SELECT a FROM Departments a")
	,@NamedQuery(name="Departments.findByDeptName", query="SELECT a FROM Departments a WHERE a.deptName = :deptName")
	,@NamedQuery(name="Departments.findByDeptNameContaining", query="SELECT a FROM Departments a WHERE a.deptName like :deptName")

})

public class Departments implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Departments.findAll";
    public static final String FIND_BY_DEPTNAME = "Departments.findByDeptName";
    public static final String FIND_BY_DEPTNAME_CONTAINING ="Departments.findByDeptNameContaining";
	
    @Id 
    @Column(name="dept_no" ,length=4) 
    private String deptNo;

    @Column(name="dept_name"  , length=40 , nullable=false , unique=false)
    private String deptName; 
    
    @OneToMany (targetEntity=com.example.demo.model.DeptEmp.class, fetch=FetchType.LAZY, mappedBy="deptEmpId__.deptNo", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <DeptEmp> deptEmpDepartmentsViaDeptNo = new HashSet<DeptEmp>(); 

    
    @OneToMany (targetEntity=com.example.demo.model.DeptManager.class, fetch=FetchType.LAZY, mappedBy="deptManagerId__.deptNo", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <DeptManager> deptManagerDepartmentsViaDeptNo = new HashSet<DeptManager>(); 

    /**
    * Default constructor
    */
    public Departments() {
    }

	/**
	* All field constructor 
	*/
    public Departments(
       String deptNo,
       String deptName) {
	 this(
       deptNo,
       deptName
	 ,true);
	}
    
	public Departments(
       String deptNo,
       String deptName	
    , boolean setRelationship) {
       //primary keys
       setDeptNo (deptNo);
       //attributes
       setDeptName (deptName);
       //parents
    }

	public Departments flat() {
	   return new Departments(
          getDeptNo(),
          getDeptName()
       , false
	   );
	}

    public String getDeptNo() {
        return deptNo;
    }
	
    public void setDeptNo (String deptNo) {
        this.deptNo =  deptNo;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-dept_name@
    public String getDeptName() {
        return deptName;
    }
	
    public void setDeptName (String deptName) {
        this.deptName =  deptName;
    }
	
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @deptEmpDepartmentsViaDeptNo-getter-departments@
    public Set<DeptEmp> getDeptEmpDepartmentsViaDeptNo() {
        if (deptEmpDepartmentsViaDeptNo == null){
            deptEmpDepartmentsViaDeptNo = new HashSet<DeptEmp>();
        }
        return deptEmpDepartmentsViaDeptNo;
    }

    public void setDeptEmpDepartmentsViaDeptNo (Set<DeptEmp> deptEmpDepartmentsViaDeptNo) {
        this.deptEmpDepartmentsViaDeptNo = deptEmpDepartmentsViaDeptNo;
    }	
    
    public void addDeptEmpDepartmentsViaDeptNo (DeptEmp element) {
    	    getDeptEmpDepartmentsViaDeptNo().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @deptManagerDepartmentsViaDeptNo-getter-departments@
    public Set<DeptManager> getDeptManagerDepartmentsViaDeptNo() {
        if (deptManagerDepartmentsViaDeptNo == null){
            deptManagerDepartmentsViaDeptNo = new HashSet<DeptManager>();
        }
        return deptManagerDepartmentsViaDeptNo;
    }

    public void setDeptManagerDepartmentsViaDeptNo (Set<DeptManager> deptManagerDepartmentsViaDeptNo) {
        this.deptManagerDepartmentsViaDeptNo = deptManagerDepartmentsViaDeptNo;
    }	
    
    public void addDeptManagerDepartmentsViaDeptNo (DeptManager element) {
    	    getDeptManagerDepartmentsViaDeptNo().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
