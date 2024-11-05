package Visitor;

public class SizeCalculatorVisitor implements IFileSystemVisitor {
    private int totalSize = 0;

    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        // No specific action needed for directory; we only care about file sizes
    }

    public int getTotalSize() {
        return totalSize;
    }
}
