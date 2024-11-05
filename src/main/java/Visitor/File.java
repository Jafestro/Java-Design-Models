package Visitor;

class File implements IFileSystemElement {
    private final String name;
    private final int size; // in megabytes

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void accept(IFileSystemVisitor visitor) {
        visitor.visit(this);
    }
}

