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

//MP-MANAGED-ADDED-AREA-BEGINNING @import@
//MP-MANAGED-ADDED-AREA-ENDING @import@
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

import java.io.Serializable;
import javax.persistence.*;
import com.example.demo.model.Employees;
import com.example.demo.model.Departments;
import com.example.demo.model.DeptManagerId;

/**
 *
 * <p>Title: DeptManager</p>
 *
 * <p>Description: Domain Object describing a DeptManager entity</p>
 *
 */
@Entity (name="DeptManager")
@Table (name="\"dept_manager\"")
@NamedQueries ({
	 @NamedQuery(name="DeptManager.findAll", query="SELECT a FROM DeptManager a")
	,@NamedQuery(name="DeptManager.findByFromDate", query="SELECT a FROM DeptManager a WHERE a.fromDate = :fromDate")

	,@NamedQuery(name="DeptManager.findByToDate", query="SELECT a FROM DeptManager a WHERE a.toDate = :toDate")

})

public class DeptManager implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "DeptManager.findAll";
    public static final String FIND_BY_FROMDATE = "DeptManager.findByFromDate";
    public static final String FIND_BY_TODATE = "DeptManager.findByToDate";
	
    @EmbeddedId
    public DeptManagerId deptManagerId__; //MP-MANAGED-ADDED-AREA-BEGINNING @from_date-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @from_date-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-from_date@
    @Column(name="from_date"   , nullable=false , unique=false)
    private Date fromDate; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @to_date-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @to_date-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-to_date@
    @Column(name="to_date"   , nullable=false , unique=false)
    private Date toDate; 
//MP-MANAGED-UPDATABLE-ENDING

    @MapsId ("emp_no")
    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="emp_no", referencedColumnName = "emp_no" , nullable=false , unique=false , insertable=true, updatable=true) 
    private Employees empNo;  

    @Column(name="emp_no"  , nullable=false , unique=false, insertable=false, updatable=false)
    private Integer empNo_;

    @MapsId ("dept_no")
    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="dept_no", referencedColumnName = "dept_no" , nullable=false , unique=false , insertable=true, updatable=true) 
    private Departments deptNo;  

    @Column(name="dept_no" , length=4 , nullable=false , unique=true, insertable=false, updatable=false)
    private String deptNo_;

    /**
    * Default constructor
    */
    public DeptManager() {
    }

	/**
	* All field constructor 
	*/
    public DeptManager(
       Integer empNo,
       String deptNo,
       Date fromDate,
       Date toDate) {
	 this(
       empNo,
       deptNo,
       fromDate,
       toDate
	 ,true);
	}
    
	public DeptManager(
       Integer empNo,
       String deptNo,
       Date fromDate,
       Date toDate	
    , boolean setRelationship) {
       //primary keys
       this.deptManagerId__ = new DeptManagerId();  	
       //attributes
       setFromDate (fromDate);
       setToDate (toDate);
       //parents
       if (setRelationship && empNo!=null) {
          this.empNo = new Employees();
          this.empNo.setEmpNo(empNo);
	      setEmpNo_ (empNo);
       }
       if (setRelationship && deptNo!=null) {
          this.deptNo = new Departments();
          this.deptNo.setDeptNo(deptNo);
	      setDeptNo_ (deptNo);
       }
    }

	public DeptManager flat() {
	   return new DeptManager(
		  getDeptManagerId__().getEmpNo(),
		  getDeptManagerId__().getDeptNo(),
          getFromDate(),
          getToDate()
       , false
	   );
	}


    public DeptManagerId getDeptManagerId__() {
		if (deptManagerId__==null) deptManagerId__ = new DeptManagerId();
        return deptManagerId__;
    }
	
    public void setDeptManagerId__ (DeptManagerId deptManagerId__) {
        this.deptManagerId__ =  deptManagerId__;
    }
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-from_date@
    public Date getFromDate() {
        return fromDate;
    }
	
    public void setFromDate (Date fromDate) {
        this.fromDate =  fromDate;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-to_date@
    public Date getToDate() {
        return toDate;
    }
	
    public void setToDate (Date toDate) {
        this.toDate =  toDate;
    }
	
//MP-MANAGED-UPDATABLE-ENDING


    public Employees getEmpNo () {
    	return empNo;
    }
	
    public void setEmpNo (Employees empNo) {
    	this.empNo = empNo;
    }

    public Integer getEmpNo_() {
        return empNo_;
    }
	
    public void setEmpNo_ (Integer empNo) {
        this.empNo_ =  empNo;
    }
	
    public Departments getDeptNo () {
    	return deptNo;
    }
	
    public void setDeptNo (Departments deptNo) {
    	this.deptNo = deptNo;
    }

    public String getDeptNo_() {
        return deptNo_;
    }
	
    public void setDeptNo_ (String deptNo) {
        this.deptNo_ =  deptNo;
    }
	




//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
