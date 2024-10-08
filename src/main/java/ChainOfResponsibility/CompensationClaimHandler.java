package ChainOfResponsibility;

public class CompensationClaimHandler extends FeedbackHandler {
    @Override
    public void handleFeedback(Message message) {
        if (message.getType() == Message.MessageType.COMPENSATION_CLAIM) {
            System.out.println("Handling compensation claim for: " + message.getSenderEmail());
            // Process the compensation claim
        } else if (nextHandler != null) {
            nextHandler.handleFeedback(message);
        }
    }
}
