import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Employee {
	private String name;
	private String dept;
	private int salary;
	
	public Employee(String name, String dept, int salary) {
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
	return "Employee{name='" + name + "', dept='" + dept + "', salary=" + salary + "}";
	}

	
}

class EmployeeGroupingExample {
	record DeptSalaryKey(String dept, String range) {}

	
	static String range(int salary) {
	return salary > 60000 ? "HIGH" : "LOW";
	}

	public static void main(String[] args) {
		List<Employee> employees = List.of(
			new Employee("Muheeb Pasha", "Software Engineer", 58000),
			new Employee("Saba", "Finance", 60000),
			new Employee("Mohammed Maaz", "Marketting Business", 35000),
			new Employee("Syed Zeeshan", "Data Analyst", 55000),
			new Employee("Ameer Suhail", "Software Engineer", 80000),
			new Employee("Riyan Ahmed", "Data Analyst", 60000),
			new Employee("Soha", "Finance", 20000),
			new Employee("Arham", "Software Engineer", 50000),
			new Employee("Hanzalah", "Marketting Business", 45000),
			new Employee("Mufeez", "Software Engineer", 70000),
			new Employee("Aiza", "Marketting Business", 50000),
			new Employee("Shahid", "Marketting Business", 45000),
			new Employee("Mukram", "Software Engineer", 70000)
		);
	
		//✅ Grouping + Counting
		Map<String,Long> countByDept = employees.stream()
									.collect(Collectors.groupingBy(e->e.getDept(), Collectors.counting()));
								
		System.out.println("Count employees in each department :"+countByDept);

		//✅ Grouping + Summing

		Map<String, Long> totalSalary = employees.stream()
									.collect(Collectors.groupingBy(e->e.getDept(), Collectors.summingLong(e->e.getSalary())));

		System.out.println("Total salary department-wise :"+ totalSalary);

		// ✅ 5. Grouping + Max/Min

		Map<String, Optional<Employee>> highestPaid = employees.stream()
										.collect(Collectors.groupingBy(e->e.getDept(),
											Collectors.maxBy(Comparator.comparingInt(e -> e.getSalary()))
										));
		System.out.println("Find highest paid employee in each department : "+ highestPaid);
											

										 
										
		//✅ 6. Grouping into Custom Object Instead of List
		Map<String, List<String>> namesByDept =
								employees.stream()
										.collect(Collectors.groupingBy(
											Employee::getDept,
											Collectors.mapping(Employee::getName, Collectors.toList())
										));


		System.out.println("Group departments → get names only (not Employee objects) : "+ namesByDept);

		// ✅ 7. GroupingBy Multiple Fields (Composite Key)
		

		Map<DeptSalaryKey, List<Employee>> grouped =
				employees.stream()
						.collect(Collectors.groupingBy(
							e -> new DeptSalaryKey(e.getDept(), range(e.getSalary()))
						));


		System.out.println("Group by department + salary range : "+grouped);
	}
}
