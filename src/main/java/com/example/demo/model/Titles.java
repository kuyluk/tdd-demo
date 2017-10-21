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
import com.example.demo.model.TitlesId;

/**
 *
 * <p>Title: Titles</p>
 *
 * <p>Description: Domain Object describing a Titles entity</p>
 *
 */
@Entity (name="Titles")
@Table (name="\"titles\"")
@NamedQueries ({
	 @NamedQuery(name="Titles.findAll", query="SELECT a FROM Titles a")
	,@NamedQuery(name="Titles.findByToDate", query="SELECT a FROM Titles a WHERE a.toDate = :toDate")
	,@NamedQuery(name="Titles.findByTitleContaining", query="SELECT a FROM Titles a WHERE a.title_ like :title")
	,@NamedQuery(name="Titles.findByFromDateContaining", query="SELECT a FROM Titles a WHERE a.fromDate_ like :fromDate")

})

public class Titles implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Titles.findAll";
    public static final String FIND_BY_TODATE = "Titles.findByToDate";
    public static final String FIND_BY_TITLE_CONTAINING ="Titles.findByTitleContaining";
    public static final String FIND_BY_FROMDATE_CONTAINING ="Titles.findByFromDateContaining";
	
    @EmbeddedId
    public TitlesId titlesId__;     @Column(name="title" , length=50 , nullable=false , unique=false , insertable=false, updatable=false)
    private String title_;
    @Column(name="from_date"  , nullable=false , unique=false , insertable=false, updatable=false)
    private Date fromDate_;
//MP-MANAGED-ADDED-AREA-BEGINNING @to_date-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @to_date-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-to_date@
    @Column(name="to_date"   , nullable=true , unique=false)
    private Date toDate; 
//MP-MANAGED-UPDATABLE-ENDING

    @MapsId ("emp_no")
    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="emp_no", referencedColumnName = "emp_no" , nullable=false , unique=false , insertable=true, updatable=true) 
    private Employees empNo;  

    @Column(name="emp_no"  , nullable=false , unique=false, insertable=false, updatable=false)
    private Integer empNo_;

    /**
    * Default constructor
    */
    public Titles() {
    }

	/**
	* All field constructor 
	*/
    public Titles(
       Integer empNo,
       String title,
       Date fromDate,
       Date toDate) {
	 this(
       empNo,
       title,
       fromDate,
       toDate
	 ,true);
	}
    
	public Titles(
       Integer empNo,
       String title,
       Date fromDate,
       Date toDate	
    , boolean setRelationship) {
       //primary keys
       this.titlesId__ = new TitlesId();  	
       this.titlesId__.setTitle (title);
       this.titlesId__.setFromDate (fromDate);
       //attributes
       setToDate (toDate);
       //parents
       if (setRelationship && empNo!=null) {
          this.empNo = new Employees();
          this.empNo.setEmpNo(empNo);
	      setEmpNo_ (empNo);
       }
    }

	public Titles flat() {
	   return new Titles(
		  getTitlesId__().getEmpNo(),
		  getTitlesId__().getTitle(),
		  getTitlesId__().getFromDate(),
          getToDate()
       , false
	   );
	}


    public TitlesId getTitlesId__() {
		if (titlesId__==null) titlesId__ = new TitlesId();
        return titlesId__;
    }
	
    public void setTitlesId__ (TitlesId titlesId__) {
        this.titlesId__ =  titlesId__;
    }
    public String getTitle_() {
        return title_;
    }
	
    public void setTitle_ (String title) {
        this.title_ =  title_;
    }
    
    public Date getFromDate_() {
        return fromDate_;
    }
	
    public void setFromDate_ (Date fromDate) {
        this.fromDate_ =  fromDate_;
    }
    
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
	




//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
