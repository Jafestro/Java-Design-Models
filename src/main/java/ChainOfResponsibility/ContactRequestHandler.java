package ChainOfResponsibility;

public class ContactRequestHandler extends FeedbackHandler {
    @Override
    public void handleFeedback(Message message) {
        if (message.getType() == Message.MessageType.CONTACT_REQUEST) {
            System.out.println("Forwarding contact request from: " + message.getSenderEmail());
            // Forward contact request to appropriate department
        } else if (nextHandler != null) {
            nextHandler.handleFeedback(message);
        }
    }
}

