package sp.course2.homeworks_2.homework_13;

public class Employee {
    private String firstName;
    private String lastName;
    private int department;
    private int wages;

    Employee(String firstName, String lastName, int department, int wages) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.wages = wages;
    }

    // Геттеры
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public int getWages() {
        return wages;
    }

    // Стандартные методы

    @Override
    public int hashCode() {
        return firstName.hashCode() + lastName.hashCode();
    }

    public boolean equals(Employee obj) {
        if (this.hashCode() == obj.hashCode()) {
            return this.firstName.equals(obj.getFirstName()) && this.lastName.equals(obj.getLastName())
                    && this.department == obj.department && this.wages == obj.wages;
        } else
            return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && wages == employee.wages && firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public String toString() {
        return "Имя: " + firstName + " | Фамилия: " + lastName + " | Отдел: " + department + " | ЗП: " + wages;
    }
}
