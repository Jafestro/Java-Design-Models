package Composite;

public class Employee extends OrganizationComponent{
    private Integer salary;

    public Employee(String name, Integer salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public void add(OrganizationComponent component) {
        throw new UnsupportedOperationException("Leaf can't do it");
    }

    @Override
    public void delete(OrganizationComponent component) {
        throw new UnsupportedOperationException("Leaf can't do it");
    }

    @Override
    public Integer getTotalSalary() {
        return salary;
    }

    @Override
    public void printXML(StringBuilder builder, int indentLevel) {
        builder.append("\t".repeat(indentLevel))
               .append("<Employee name=\"").append(name)
               .append("\" salary=\"").append(salary).append("\"/>\n");
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
