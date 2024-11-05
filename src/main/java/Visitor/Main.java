package Visitor;

public class Main {
    public static void main(String[] args) {
        // Creating the file system structure
        Directory root = new Directory("root");
        Directory home = new Directory("home");
        Directory documents = new Directory("documents");
        File file1 = new File("resume.pdf", 2);
        File file2 = new File("photo.jpg", 5);
        File file3 = new File("notes.txt", 1);
        
        root.addElement(home);
        home.addElement(documents);
        documents.addElement(file1);
        documents.addElement(file2);
        home.addElement(file3);

        // Applying SizeCalculatorVisitor
        SizeCalculatorVisitor sizeCalculator = new SizeCalculatorVisitor();
        root.accept(sizeCalculator);
        System.out.println("Total size of all files: " + sizeCalculator.getTotalSize() + " MB");

        // Applying SearchVisitor
        SearchVisitor searchVisitor = new SearchVisitor("resume");
        root.accept(searchVisitor);
        System.out.println("Files matching 'resume':");
        for (File file : searchVisitor.getMatchingFiles()) {
            System.out.println("- " + file.getName());
        }
    }
}

