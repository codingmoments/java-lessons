package cloning.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import cloning.util.ListUtil;

public class Department implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long departmentId;
  private String departmentName;
  private String departmentCode;

  private List<Employee> employees;

  public Department() {
  }

  public Department(Department department) {
    this.departmentId = department.getDepartmentId();
    this.departmentName = department.getDepartmentName();
    this.departmentCode = department.getDepartmentCode();

    List<Employee> employees = department.getEmployees().stream().map(emp -> new Employee(emp)).collect(Collectors.toList());
    this.employees = employees;
  }

  public Long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public String getDepartmentCode() {
    return departmentCode;
  }

  public void setDepartmentCode(String departmentCode) {
    this.departmentCode = departmentCode;
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }

  public boolean deepEquals(Object obj) {
    // Unlike equals(), if both references point to same object, we return false.
    if (this == obj)
      return false;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Department other = (Department) obj;
    return Objects.equals(departmentCode, other.departmentCode) && Objects.equals(departmentId, other.departmentId) && Objects.equals(departmentName, other.departmentName)
      && ListUtil.areListsDeepEqual(employees, other.employees);
  }

}
