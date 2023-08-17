package cloning;

import java.time.Duration;
import java.time.Instant;

import cloning.domain.Company;
import cloning.factory.CompanyFactory;
import cloning.util.Cloner;

public class SpeedTest {

  public static void main(String[] args) throws Exception {
    Company company = CompanyFactory.createCompany();

    int totalTimeUsingSerialization = 0;
    int totalTimeUsingReflection = 0;
    int totalTimeUsingCopyConstructor = 0;

    for (int i = 1; i <= 5; i++) {
      System.out.printf("Iteration #%d\n", i);
      
      Instant startInstant = Instant.now();
      Company companyCopiedUsingSerialization = Cloner.deepCopyUsingSerialization(company);
      Instant endInstant = Instant.now();
      System.out.printf("%-25s : Equality check = %s | Time taken (ms) = %5d\n", "Using serialization", company.equals(companyCopiedUsingSerialization),
        Duration.between(startInstant, endInstant).toMillis());
      totalTimeUsingSerialization += Duration.between(startInstant, endInstant).toMillis();

      startInstant = Instant.now();
      Company companyCopiedUsingReflection = Cloner.deepCopyUsingReflection(company);
      endInstant = Instant.now();
      System.out.printf("%-25s : Equality check = %s | Time taken (ms) = %5d\n", "Using reflection", company.equals(companyCopiedUsingReflection),
        Duration.between(startInstant, endInstant).toMillis());
      totalTimeUsingReflection += Duration.between(startInstant, endInstant).toMillis();

      startInstant = Instant.now();
      Company companyCopiedUsingCopyConstructor = new Company(company);
      endInstant = Instant.now();
      System.out.printf("%-25s : Equality check = %s | Time taken (ms) = %5d\n", "Using copy constructor", company.equals(companyCopiedUsingCopyConstructor),
        Duration.between(startInstant, endInstant).toMillis());
      totalTimeUsingCopyConstructor += Duration.between(startInstant, endInstant).toMillis();
    }

    System.out.println("****************************");
    System.out.printf("%-20s :\n", "Average Timings (ms)");
    System.out.printf("%-20s : %5d\n", "Serialization", totalTimeUsingSerialization / 5);
    System.out.printf("%-20s : %5d\n", "Reflection", totalTimeUsingReflection / 5);
    System.out.printf("%-20s : %5d\n", "Copy constructor", totalTimeUsingCopyConstructor / 5);
  }
}
