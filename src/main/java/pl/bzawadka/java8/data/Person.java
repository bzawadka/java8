package pl.bzawadka.java8.data;

public class Person {
    private final static Integer DEFAULT_SALARY = 100000;
    private final static Department DEFAULT_DEPARTMENT = Department.IT;

    private final String name;
    private final Integer salary;
    private final Department department;

    public Person(String name) {
        this.name = name;
        this.salary = DEFAULT_SALARY;
        this.department = DEFAULT_DEPARTMENT;
    }

    public Person(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
        this.department = DEFAULT_DEPARTMENT;
    }

    public Person(String name, Integer salary, Department department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public Integer getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Person) {
            Person other = (Person) o;
            if (name.equals(other.name) && department.equals(other.department) && salary.equals(other.salary)) {
                return true;
            }
        }
        return false;
    }
}
