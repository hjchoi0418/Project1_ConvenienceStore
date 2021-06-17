package AnyPlace.model;

public class Employee {

	private String employee_no;
	private String employee_id;
	private String employee_name;
	private String hire_date;
	private String employee_wage;
	private String last_date;
	private String work_on;
	private String work_off;
	private String work_time;
	private String doe;
	
	public String getEmployee_no() {
		return employee_no;
	}
	public void setEmployee_no(String employee_no) {
		this.employee_no = employee_no;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	public String getEmployee_wage() {
		return employee_wage;
	}
	public void setEmployee_wage(String employee_wage) {
		this.employee_wage = employee_wage;
	}
	public String getLast_date() {
		return last_date;
	}
	public void setLast_date(String last_date) {
		this.last_date = last_date;
	}
	public String getWork_on() {
		return work_on;
	}
	public void setWork_on(String work_on) {
		this.work_on = work_on;
	}
	public String getWork_off() {
		return work_off;
	}
	public void setWork_off(String work_off) {
		this.work_off = work_off;
	}
	public String getWork_time() {
		return work_time;
	}
	public void setWork_time(String work_time) {
		this.work_time = work_time;
	}
	public String getDoe() {
		return doe;
	}
	public void setDoe(String doe) {
		this.doe = doe;
	}
	@Override
	public String toString() {
		return "Employee [employee_no=" + employee_no + ", employee_id=" + employee_id + ", employee_name="
				+ employee_name + ", hire_date=" + hire_date + ", employee_wage=" + employee_wage + ", last_date="
				+ last_date + ", work_on=" + work_on + ", work_off=" + work_off + ", work_time=" + work_time + ", doe="
				+ doe + "]";
	}
	
}
