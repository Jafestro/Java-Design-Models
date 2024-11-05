package Visitor;

public interface IFileSystemElement {
    void accept(IFileSystemVisitor visitor);
}
