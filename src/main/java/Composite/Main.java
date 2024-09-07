package Composite;

public class Main {
    public static void main(String[] args) {
        Department root = new Department("HeadQuarters");
        Department hrDepartment = new Department("HR Department");
        Department itDepartment = new Department("IT Department");

        Employee employee1 = new Employee("John Cena", 5000);
        Employee employee2 = new Employee("Cant See Mee", 10000);
        Employee employee3 = new Employee("Bruce Lee", 20000);
        Employee employee4 = new Employee("Chick Nurris", 25000);

        root.add(hrDepartment);
        root.add(itDepartment);
        hrDepartment.add(employee1);
        hrDepartment.add(employee3);
        itDepartment.add(employee2);
        itDepartment.add(employee4);

        System.out.println("Total Salary of the Organization: $" + root.getTotalSalary());

        StringBuilder xmlBuilder = new StringBuilder();
        root.printXML(xmlBuilder, 0);
        System.out.println(xmlBuilder.toString());
    }
}
