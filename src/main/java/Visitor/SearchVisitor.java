package Visitor;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements IFileSystemVisitor {
    private final String namePattern;
    private final List<File> matchingFiles = new ArrayList<>();

    public SearchVisitor(String namePattern) {
        this.namePattern = namePattern;
    }

    @Override
    public void visit(File file) {
        if (file.getName().contains(namePattern)) {
            matchingFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        // No specific action needed for directory itself
    }

    public List<File> getMatchingFiles() {
        return matchingFiles;
    }
}
