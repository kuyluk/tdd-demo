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
import com.example.demo.model.SalariesId;

/**
 *
 * <p>Title: Salaries</p>
 *
 * <p>Description: Domain Object describing a Salaries entity</p>
 *
 */
@Entity (name="Salaries")
@Table (name="\"salaries\"")
@NamedQueries ({
	 @NamedQuery(name="Salaries.findAll", query="SELECT a FROM Salaries a")
	,@NamedQuery(name="Salaries.findBySalary", query="SELECT a FROM Salaries a WHERE a.salary = :salary")
	,@NamedQuery(name="Salaries.findByFromDateContaining", query="SELECT a FROM Salaries a WHERE a.fromDate like :fromDate")

	,@NamedQuery(name="Salaries.findByToDate", query="SELECT a FROM Salaries a WHERE a.toDate = :toDate")

})

public class Salaries implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Salaries.findAll";
    public static final String FIND_BY_SALARY = "Salaries.findBySalary";
    public static final String FIND_BY_TODATE = "Salaries.findByToDate";
    public static final String FIND_BY_FROMDATE_CONTAINING ="Salaries.findByFromDateContaining";
	
    @EmbeddedId
    public SalariesId salariesId;     
    
    @Column(name="from_date"  , nullable=false , unique=false , insertable=false, updatable=false)
    private Date fromDate;
    
    @Column(name="salary"   , nullable=false , unique=false)
    private Integer salary; 

    @Column(name="to_date"   , nullable=false , unique=false)
    private Date toDate; 

    @MapsId ("emp_no")
    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="emp_no", referencedColumnName = "emp_no" , nullable=false , unique=false , insertable=true, updatable=true) 
    private Employees empNo;

	public SalariesId getSalariesId() {
		return salariesId;
	}

	public void setSalariesId(SalariesId salariesId) {
		this.salariesId = salariesId;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Employees getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Employees empNo) {
		this.empNo = empNo;
	}  
}
