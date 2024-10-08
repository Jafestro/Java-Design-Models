package ChainOfResponsibility;

public class GeneralFeedbackHandler extends FeedbackHandler {
    @Override
    public void handleFeedback(Message message) {
        if (message.getType() == Message.MessageType.GENERAL_FEEDBACK) {
            System.out.println("Analyzing general feedback from: " + message.getSenderEmail());
            // Analyze and respond to the feedback
        } else if (nextHandler != null) {
            nextHandler.handleFeedback(message);
        }
    }
}