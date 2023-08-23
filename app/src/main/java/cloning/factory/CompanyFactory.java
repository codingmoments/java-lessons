package cloning.factory;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import cloning.domain.Address;
import cloning.domain.Company;
import cloning.domain.Department;
import cloning.domain.Employee;
import cloning.domain.Task;

public class CompanyFactory {

  private static Random random = new Random();

  public static Company createCompany(int departmentCount, int employeesPerDepartment, int tasksPerEmployee) {
    Company company = new Company();
    company.setCompanyId(1L);
    company.setCompanyName("MyCompany");

    List<Department> departments = IntStream.rangeClosed(1, departmentCount).mapToObj(i -> createDepartment(employeesPerDepartment, tasksPerEmployee)).collect(Collectors.toList());
    company.setDepartments(departments);

    return company;
  }

  public static Department createDepartment(int employeesPerDepartment, int tasksPerEmployee) {
    Department department = new Department();
    department.setDepartmentId(random.nextLong());
    department.setDepartmentName(generateRandomString());
    department.setDepartmentCode(generateRandomString());

    List<Employee> employees = IntStream.rangeClosed(1, employeesPerDepartment).mapToObj(i -> createEmployee(tasksPerEmployee)).collect(Collectors.toList());
    department.setEmployees(employees);

    return department;
  }

  public static Employee createEmployee(int tasksPerEmployee) {
    Employee employee = new Employee();
    employee.setEmployeeId(random.nextLong());
    employee.setFirstName(generateRandomString());
    employee.setLastName(generateRandomString());
    employee.setBirthDate(LocalDate.of(random.nextInt(1950, 2000), random.nextInt(1, 12), random.nextInt(1, 25)));

    employee.setAddress(createAddress());

    employee.setDepartmentId(random.nextLong());
    employee.setSalary(random.nextInt() * 1000);
    employee.setJoiningDate(LocalDate.of(random.nextInt(2020, 2022), random.nextInt(1, 12), random.nextInt(1, 25)));

    List<Task> tasks = IntStream.rangeClosed(1, tasksPerEmployee).mapToObj(i -> createTask()).collect(Collectors.toList());
    employee.setTasksCompleted(tasks);

    return employee;
  }

  public static Address createAddress() {
    Address address = new Address();
    address.setAddressId(random.nextLong());
    address.setFirstLine(generateRandomString());
    address.setSecondLine(generateRandomString());
    address.setThirdLine(generateRandomString());
    address.setZipcode(generateRandomString());
    address.setCity(generateRandomString());
    address.setState(generateRandomString());
    address.setCountry(generateRandomString());

    return address;
  }

  public static Task createTask() {
    Task task = new Task();
    task.setTaskId(random.nextLong());
    task.setSummary(generateRandomString());
    task.setDescription(generateRandomString());
    task.setCreatedDate(LocalDate.of(random.nextInt(2020, 2022), random.nextInt(1, 12), random.nextInt(1, 25)));
    task.setCompletedDate(LocalDate.of(random.nextInt(2020, 2022), random.nextInt(1, 12), random.nextInt(1, 25)));

    return task;
  }

  private static String generateRandomString() {
    int targetStringLength = 10;
    int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'

    StringBuilder buffer = new StringBuilder(targetStringLength);
    for (int i = 0; i < targetStringLength; i++) {
      int randomLimitedInt = leftLimit + (int) (random.nextFloat() + (rightLimit - leftLimit + 1));
      buffer.append((char) randomLimitedInt);
    }

    return buffer.toString();
  }
}
