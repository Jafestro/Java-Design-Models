package Composite;

import java.util.ArrayList;
import java.util.List;

public class Department extends OrganizationComponent{
    private final List<OrganizationComponent> components = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void add(OrganizationComponent component) {
        components.add(component);
    }

    @Override
    public void delete(OrganizationComponent component) {
        components.remove(component);
    }

    @Override
    public Integer getTotalSalary() {
        return components.stream().mapToInt(OrganizationComponent::getTotalSalary).sum();
    }

    @Override
    public void printXML(StringBuilder builder, int indentLevel) {
        builder.append("\t".repeat(indentLevel))
               .append("<Department name=\"").append(name).append("\">\n");
        components.forEach(component -> component.printXML(builder, indentLevel + 1));
        builder.append("\t".repeat(indentLevel)).append("</Department>\n");
    }
}
