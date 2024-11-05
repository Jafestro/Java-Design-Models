package Visitor;

import java.util.ArrayList;
import java.util.List;

class Directory implements IFileSystemElement {
    private final String name;
    private final List<IFileSystemElement> elements = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addElement(IFileSystemElement element) {
        elements.add(element);
    }

    public List<IFileSystemElement> getElements() {
        return elements;
    }

    @Override
    public void accept(IFileSystemVisitor visitor) {
        visitor.visit(this);
        for (IFileSystemElement element : elements) {
            element.accept(visitor);
        }
    }
}

