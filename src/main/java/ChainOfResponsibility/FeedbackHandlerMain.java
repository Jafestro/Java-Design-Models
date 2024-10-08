package ChainOfResponsibility;

public class FeedbackHandlerMain {
    public static void main(String[] args) {
        // Create the handler chain
        FeedbackHandler compensationClaimHandler = new CompensationClaimHandler();
        FeedbackHandler contactRequestHandler = new ContactRequestHandler();
        FeedbackHandler developmentSuggestionHandler = new DevelopmentSuggestionHandler();
        FeedbackHandler generalFeedbackHandler = new GeneralFeedbackHandler();

        compensationClaimHandler.setNextHandler(contactRequestHandler);
        contactRequestHandler.setNextHandler(developmentSuggestionHandler);
        developmentSuggestionHandler.setNextHandler(generalFeedbackHandler);

        // Create sample feedback messages
        Message compensationClaim = new Message(Message.MessageType.COMPENSATION_CLAIM, "Refund request for order #12345", "customer1@example.com");
        Message contactRequest = new Message(Message.MessageType.CONTACT_REQUEST, "Need help with an order", "customer2@example.com");
        Message developmentSuggestion = new Message(Message.MessageType.DEVELOPMENT_SUGGESTION, "Add more payment options", "customer3@example.com");
        Message generalFeedback = new Message(Message.MessageType.GENERAL_FEEDBACK, "Great service!", "customer4@example.com");

        // Send messages to the handler chain
        compensationClaimHandler.handleFeedback(compensationClaim);
        compensationClaimHandler.handleFeedback(contactRequest);
        compensationClaimHandler.handleFeedback(developmentSuggestion);
        compensationClaimHandler.handleFeedback(generalFeedback);
    }
}
