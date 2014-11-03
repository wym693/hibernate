package bean;

public class DeptSalary {
	private String deptName;//部门名称
	private Double avgSalary;//部门平均工资
	
	public DeptSalary(String deptName, Double avgSalary) {
		super();
		this.deptName = deptName;
		this.avgSalary = avgSalary;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Double getAvgSalary() {
		return avgSalary;
	}
	public void setAvgSalary(Double avgSalary) {
		this.avgSalary = avgSalary;
	}
	
}
