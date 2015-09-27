package pl.bzawadka.java8.data;

public class Person {
    private final static Integer DEFAULT_SALARY = 100000;
    private final static Department DEFAULT_DEPARTMENT = Department.IT;

    private final String name;
    private final Integer salary;
    private Department department;
    private boolean isEmployed;

    public Person(String name) {
        this(name, DEFAULT_SALARY, DEFAULT_DEPARTMENT);
    }

    public Person(String name, Integer salary) {
        this(name, salary, DEFAULT_DEPARTMENT);
    }

    public Person(String name, Department department) {
        this(name, DEFAULT_SALARY, department);
    }

    public Person(String name, Integer salary, Department department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.isEmployed = true;
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

    public boolean isEmployed() {
        return isEmployed;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void fire() {
        this.isEmployed = false;
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
