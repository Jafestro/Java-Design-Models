package ChainOfResponsibility;

public class DevelopmentSuggestionHandler extends FeedbackHandler {
    @Override
    public void handleFeedback(Message message) {
        if (message.getType() == Message.MessageType.DEVELOPMENT_SUGGESTION) {
            System.out.println("Logging development suggestion from: " + message.getSenderEmail());
            // Log the suggestion for prioritization
        } else if (nextHandler != null) {
            nextHandler.handleFeedback(message);
        }
    }
}
