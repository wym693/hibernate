package bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 员工表对应的实体�?
 */
public class Emp implements Serializable {
	//员工编号
	private Integer empNo;
	//员工姓名
	private String empName;
	//�?��部门	
	private Dept dept;
	//职位
	private String job;
	//工资
	private Double salary;
	//入职时间
	private Date hireDate;
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emp( String empName) {
		this.empName = empName;
	}
	
	public Emp(Integer empNo, String empName) {
		super();
		this.empNo = empNo;
		this.empName = empName;
	}

	public Emp(Integer empNo, String empName, Dept dept) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.dept = dept;
	}
	
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	

}
