package Prototype.Bookstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Recommendation> recommendations = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Book Recommendation System ---");
            System.out.println("1. View Recommendations");
            System.out.println("2. Create New Recommendation");
            System.out.println("3. Clone a Recommendation");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    // View Recommendations
                    if (recommendations.isEmpty()) {
                        System.out.println("No recommendations available.");
                    } else {
                        for (int i = 0; i < recommendations.size(); i++) {
                            System.out.println("\nRecommendation " + (i + 1) + ":");
                            System.out.println(recommendations.get(i));
                        }
                    }
                }
                case 2 -> {
                    // Create New Recommendation
                    System.out.print("Enter target audience: ");
                    String audience = scanner.nextLine();
                    Recommendation rec = new Recommendation(audience);

                    while (true) {
                        System.out.print("Add a book? (y/n): ");
                        String response = scanner.nextLine().toLowerCase();
                        if (response.equals("y")) {
                            System.out.print("Author: ");
                            String author = scanner.nextLine();
                            System.out.print("Title: ");
                            String title = scanner.nextLine();
                            System.out.print("Genre: ");
                            String genre = scanner.nextLine();
                            System.out.print("Publication Year: ");
                            int year = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            rec.addBook(new Book(author, title, genre, year));
                        } else {
                            break;
                        }
                    }
                    recommendations.add(rec);
                    System.out.println("New recommendation created.");
                }
                case 3 -> {
                    // Clone a Recommendation
                    if (recommendations.isEmpty()) {
                        System.out.println("No recommendations available to clone.");
                    } else {
                        for (int i = 0; i < recommendations.size(); i++) {
                            System.out.println((i + 1) + ". " + recommendations.get(i));
                        }
                        System.out.print("Choose a recommendation to clone (by number): ");
                        int index = scanner.nextInt() - 1;
                        scanner.nextLine(); // Consume newline

                        if (index >= 0 && index < recommendations.size()) {
                            Recommendation clonedRec = recommendations.get(index).clone();
                            System.out.print("Enter new target audience: ");
                            clonedRec.updateAudience(scanner.nextLine());
                            recommendations.add(clonedRec);
                            System.out.println("Recommendation cloned successfully.");
                        } else {
                            System.out.println("Invalid selection.");
                        }
                    }
                }
                case 4 -> {
                    // Exit
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
