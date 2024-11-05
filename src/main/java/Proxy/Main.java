package Proxy;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("user1");
        User user2 = new User("user2");

        // Unprotected document
        Document doc1 = new Document("doc1", "Unprotected Content");

        // Protected document with access control via proxy
        DocumentProxy protectedDoc = new DocumentProxy(new Document("doc2", "Protected Content"), "user1");

        try {
            System.out.println("User1 accessing unprotected doc1: " + doc1.getContent(user1));
            System.out.println("User2 accessing unprotected doc1: " + doc1.getContent(user2));

            System.out.println("User1 accessing protected doc2: " + protectedDoc.getContent(user1)); // Should succeed
            System.out.println("User2 accessing protected doc2: " + protectedDoc.getContent(user2)); // Should fail
        } catch (AccessDeniedException e) {
            System.err.println(e.getMessage());
        }
    }
}