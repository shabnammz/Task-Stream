import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Task 1
        System.out.println("Task 1----------------------");
        List<Integer> numList = List.of(12, 15, 51, 96, 23, 42);
        List<Integer> result = numList
                .stream()
                .filter(n-> n%2==0)
                .map(n-> n*n)
                .collect(Collectors.toList());
        System.out.println(result);

        //Task 2
        System.out.println("Task 2----------------------");
        List<String> words = List.of("lorem", "ipsum", "dolor", "sit", "amet");
        List<String> finalWords = words
                .stream()
                .distinct()
                .filter(n-> n.length()>3)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(finalWords);

        //Task 3
        System.out.println("Task 3----------------------");
        List<Employee> employees = List.of(
                new Employee("Orxan", "IT", 3000.0, 28),
                new Employee("Aysel", "HR", 1400.0, 32),
                new Employee("Leyla", "IT", 3500.0, 35),
                new Employee("Rauf", "Finance", 2200.0, 40),
                new Employee("Nigar", "HR", 1250.0, 26)
        );
        Optional<Employee> maxSalaryEmployee = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(maxSalaryEmployee);

        double average = employees
                .stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(average);

        double total = employees
                .stream()
                .filter(em->em.getAge()>30)
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println(total);

        //Task 4
        System.out.println("Task 4----------------------");
        Map<String, List<Employee>> groups  = employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        Map<String, Long> counts = employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        Map<String, Double> departmentAverage = employees
                .stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        //Task 5
        System.out.println("Task 5----------------------");
        List<String> emails = List.of("lorem@gmail.com", "loREm@gmail.com", "ipsum@gmail.com", "dolor@yahoo.com", "sitAmet@gmail.com");
        long uniqueEmails = emails
                .stream()
                .map(w->w.toLowerCase())
                .filter(w->w.endsWith("@gmail.com"))
                .distinct()
                .count();
        System.out.println(uniqueEmails);

        //Task 6
        System.out.println("Task 6----------------------");
        List<String> names = List.of("Leyla", "Nigar", "Aysel", "Lala");
        names.stream()
                .map(name->"Student: "+ name)
                .forEach(System.out::println);

        //Task 7
        System.out.println("Task 7----------------------");
        List<Integer> numbers = List.of(5, 25, 4, 83, 24, 44, 42);
        numbers.stream()
                .filter(n-> n > 10)
                .map(number -> "Number: "+ number)
                .forEach(System.out::print);

        //Task 8
        System.out.println("Task 8----------------------");
        Map<String, Integer> grades = Map.of(
                "Math",90,
                "Physics", 98,
                "Computer Science", 80,
                "Geography", 95,
                "Chemistry", 82);
        grades.forEach((key, value)-> System.out.println(key + " -> " + value));
    }
}