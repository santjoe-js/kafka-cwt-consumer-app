/**
 * 
 */
package com.cwt.kafka.consumer.model;

/**
 * @author SJOSEP39
 *
 */
public class EmployeeJSONModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int salary;
	private boolean martialStatus;
	
	
	public EmployeeJSONModel() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public boolean isMartialStatus() {
		return martialStatus;
	}
	public void setMartialStatus(boolean martialStatus) {
		this.martialStatus = martialStatus;
	}
	@Override
	public String toString() {
		return "EmployeeJSONModel [name=" + name + ", salary=" + salary + ", martialStatus=" + martialStatus + "]";
	}
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + (martialStatus ? 1231 : 1237);
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + salary;
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		EmployeeJSONModel other = (EmployeeJSONModel) obj;
//		if (martialStatus != other.martialStatus)
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		if (salary != other.salary)
//			return false;
//		return true;
//	}
//	
	
	
		
}
