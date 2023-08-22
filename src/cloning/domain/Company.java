package cloning.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import cloning.util.ListUtil;

public class Company implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long companyId;
  private String companyName;
  private List<Department> departments;

  public Company() {
  }

  public Company(Company company) {
    this.companyId = company.getCompanyId();
    this.companyName = company.getCompanyName();

    List<Department> departments = company.getDepartments().stream().map(dept -> new Department(dept)).collect(Collectors.toList());
    this.departments = departments;
  }

  public Long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Long companyId) {
    this.companyId = companyId;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public List<Department> getDepartments() {
    return departments;
  }

  public void setDepartments(List<Department> departments) {
    this.departments = departments;
  }

  public boolean deepEquals(Object obj) {
    // Unlike equals(), if both references point to same object, we return false.
    if (this == obj)
      return false;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Company other = (Company) obj;
    return Objects.equals(companyId, other.companyId) && Objects.equals(companyName, other.companyName) && ListUtil.areListsDeepEqual(departments, other.departments);
  }

}
