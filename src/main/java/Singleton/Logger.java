package main.java.Singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static Logger instance;
    private String fileName;
    private FileWriter fileWriter;
    private PrintWriter printWriter;

    private Logger(){
        fileName = "logger_file.txt";
        initializeWriter();
    }

    public static synchronized Logger getInstance(){
        if(instance == null) {
            instance = new Logger();
        } 
        return instance;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        close(); // Close the current writers if they exist
        initializeWriter(); // Reinitialize with the new file name
    } 

    private void initializeWriter() {
        try {
            fileWriter = new FileWriter(fileName, true); // 'true' for append mode
            printWriter = new PrintWriter(fileWriter);
        } catch (IOException e) {
            System.err.println("An error occurred while initializing the writer."+e.getMessage());
        }
    }

    public void write(String message) {
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null");
        }

        if (printWriter != null) {
            printWriter.println(message); // Write message to the file with a new line
        } else {
            System.err.println("PrintWriter is not initialized.");
        }
    }

    public void close() {
        if (printWriter != null) {
            printWriter.close(); // Close PrintWriter, which also closes FileWriter
            printWriter = null;
        }
        if (fileWriter != null) {
            try {
                fileWriter.close();
            } catch (IOException e) {
                System.err.println("An error occurred while closing the file writer."+e.getMessage());
            }
            fileWriter = null;
        }
    }

}
