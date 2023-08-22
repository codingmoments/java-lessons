package cloning.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import cloning.util.ListUtil;

public class Employee implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long employeeId;
  private String firstName;
  private String lastName;
  private LocalDate birthDate;

  private Long departmentId;
  private LocalDate joiningDate;
  private Integer salary;

  private Address address;

  private List<Task> tasksCompleted;

  public Employee() {
  }

  public Employee(Employee employee) {
    this.employeeId = employee.getEmployeeId();
    this.firstName = employee.getFirstName();
    this.lastName = employee.getLastName();
    this.birthDate = employee.getBirthDate();

    this.departmentId = employee.getDepartmentId();
    this.joiningDate = employee.getJoiningDate();
    this.salary = employee.getSalary();

    this.address = new Address(employee.getAddress());

    List<Task> tasks = employee.getTasksCompleted().stream().map(task -> new Task(task)).collect(Collectors.toList());
    this.tasksCompleted = tasks;
  }

  public Long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public Long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
  }

  public LocalDate getJoiningDate() {
    return joiningDate;
  }

  public void setJoiningDate(LocalDate joiningDate) {
    this.joiningDate = joiningDate;
  }

  public Integer getSalary() {
    return salary;
  }

  public void setSalary(Integer salary) {
    this.salary = salary;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public List<Task> getTasksCompleted() {
    return tasksCompleted;
  }

  public void setTasksCompleted(List<Task> tasksCompleted) {
    this.tasksCompleted = tasksCompleted;
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, birthDate, departmentId, employeeId, firstName, joiningDate, lastName, salary, tasksCompleted);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Employee other = (Employee) obj;
    return Objects.equals(address, other.address) && Objects.equals(birthDate, other.birthDate) && Objects.equals(departmentId, other.departmentId) && Objects.equals(employeeId, other.employeeId)
      && Objects.equals(firstName, other.firstName) && Objects.equals(joiningDate, other.joiningDate) && Objects.equals(lastName, other.lastName) && Objects.equals(salary, other.salary)
      && ListUtil.areListsEqual(tasksCompleted, other.tasksCompleted);
  }

}
