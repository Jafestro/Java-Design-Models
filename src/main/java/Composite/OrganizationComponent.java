package Composite;

public abstract class OrganizationComponent {
    protected String name;

    public OrganizationComponent(String name) {
        this.name = name;
    }

    public abstract void add(OrganizationComponent component);
    public abstract void delete(OrganizationComponent component);
    public abstract Integer getTotalSalary();
    public abstract void printXML(StringBuilder builder, int indentLevel);
}
