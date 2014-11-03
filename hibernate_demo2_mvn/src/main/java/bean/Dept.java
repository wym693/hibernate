package bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * 部门表对应的实体�?
 */
public class Dept implements Serializable {
	private Integer deptNo;//部门编号
	private String deptName;//部门名称
	private String location;//部门地址
	private Set<Emp> emps = new HashSet<Emp>();//员工集合
	
	public Set<Emp> getEmps() {
		return emps;
	}
	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dept( String deptName, String location) {
		this.deptName = deptName;
		this.location = location;
	}
	
	public Integer getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
