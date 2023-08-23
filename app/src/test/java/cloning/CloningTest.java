package cloning;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import cloning.domain.Company;
import cloning.factory.CompanyFactory;
import cloning.util.Cloner;

public class CloningTest {

  @Test
  public void testDeepCopyUsingSerialization() throws Exception {
    Company company = CompanyFactory.createCompany(1, 5, 2);
    Company copyCompany = Cloner.deepCopyUsingSerialization(company);
    assertEquals(company, copyCompany);
  }

  @Test
  public void testDeepCopyAndChangeDepartmentNameUsingSerialization() throws Exception {
    Company company = CompanyFactory.createCompany(1, 5, 2);
    Company copyCompany = Cloner.deepCopyUsingSerialization(company);
    company.getDepartments().get(0).setDepartmentName("NewDepartment");
    assertNotEquals(copyCompany, company);
  }

  @Test
  public void testDeepCopyAndChangeEmployeeNameUsingSerialization() throws Exception {
    Company company = CompanyFactory.createCompany(1, 5, 2);
    Company copyCompany = Cloner.deepCopyUsingSerialization(company);
    company.getDepartments().get(0).getEmployees().get(2).setFirstName("NewEmployee");
    assertNotEquals(copyCompany, company);
  }

  @Test
  public void testDeepCopyAndChangeAddressCityUsingSerialization() throws Exception {
    Company company = CompanyFactory.createCompany(1, 5, 2);
    Company copyCompany = Cloner.deepCopyUsingSerialization(company);
    company.getDepartments().get(0).getEmployees().get(2).getAddress().setCity("NewCity");
    assertNotEquals(copyCompany, company);
  }

  @Test
  public void testDeepCopyAndChangeTaskSummaryUsingSerialization() throws Exception {
    Company company = CompanyFactory.createCompany(1, 5, 2);
    Company copyCompany = Cloner.deepCopyUsingSerialization(company);
    company.getDepartments().get(0).getEmployees().get(2).getTasksCompleted().get(0).setSummary("NewTask");
    assertNotEquals(copyCompany, company);
  }

  @Test
  public void testDeepCopyUsingReflection() throws Exception {
    Company company = CompanyFactory.createCompany(1, 5, 2);
    Company copyCompany = Cloner.deepCopyUsingReflection(company);
    assertEquals(company, copyCompany);
  }

  @Test
  public void testDeepCopyAndChangeDepartmentNameUsingReflection() throws Exception {
    Company company = CompanyFactory.createCompany(1, 5, 2);
    Company copyCompany = Cloner.deepCopyUsingReflection(company);
    company.getDepartments().get(0).setDepartmentName("NewDepartment");
    assertNotEquals(copyCompany, company);
  }

  @Test
  public void testDeepCopyAndChangeEmployeeNameUsingReflection() throws Exception {
    Company company = CompanyFactory.createCompany(1, 5, 2);
    Company copyCompany = Cloner.deepCopyUsingReflection(company);
    company.getDepartments().get(0).getEmployees().get(2).setFirstName("NewEmployee");
    assertNotEquals(copyCompany, company);
  }

  @Test
  public void testDeepCopyAndChangeAddressCityUsingReflection() throws Exception {
    Company company = CompanyFactory.createCompany(1, 5, 2);
    Company copyCompany = Cloner.deepCopyUsingReflection(company);
    company.getDepartments().get(0).getEmployees().get(2).getAddress().setCity("NewCity");
    assertNotEquals(copyCompany, company);
  }

  @Test
  public void testDeepCopyAndChangeTaskSummaryUsingReflection() throws Exception {
    Company company = CompanyFactory.createCompany(1, 5, 2);
    Company copyCompany = Cloner.deepCopyUsingReflection(company);
    company.getDepartments().get(0).getEmployees().get(2).getTasksCompleted().get(0).setSummary("NewTask");
    assertNotEquals(copyCompany, company);
  }

  @Test
  public void testDeepCopyUsingCopyConstructor() throws Exception {
    Company company = CompanyFactory.createCompany(1, 5, 2);
    Company copyCompany = new Company(company);
    assertEquals(company, copyCompany);
  }

  @Test
  public void testDeepCopyAndChangeDepartmentNameUsingCopyConstructor() throws Exception {
    Company company = CompanyFactory.createCompany(1, 5, 2);
    Company copyCompany = new Company(company);
    company.getDepartments().get(0).setDepartmentName("NewDepartment");
    assertNotEquals(copyCompany, company);
  }

  @Test
  public void testDeepCopyAndChangeEmployeeNameUsingCopyConstructor() throws Exception {
    Company company = CompanyFactory.createCompany(1, 5, 2);
    Company copyCompany = new Company(company);
    company.getDepartments().get(0).getEmployees().get(2).setFirstName("NewEmployee");
    assertNotEquals(copyCompany, company);
  }

  @Test
  public void testDeepCopyAndChangeAddressCityUsingCopyConstructor() throws Exception {
    Company company = CompanyFactory.createCompany(1, 5, 2);
    Company copyCompany = new Company(company);
    company.getDepartments().get(0).getEmployees().get(2).getAddress().setCity("NewCity");
    assertNotEquals(copyCompany, company);
  }

  @Test
  public void testDeepCopyAndChangeTaskSummaryUsingCopyConstructor() throws Exception {
    Company company = CompanyFactory.createCompany(1, 5, 2);
    Company copyCompany = new Company(company);
    company.getDepartments().get(0).getEmployees().get(2).getTasksCompleted().get(0).setSummary("NewTask");
    assertNotEquals(copyCompany, company);
  }

}