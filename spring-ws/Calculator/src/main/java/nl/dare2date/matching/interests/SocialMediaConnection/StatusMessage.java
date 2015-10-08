package nl.dare2date.matching.interests.socialMediaConnection;

import nl.dare2date.matching.orchestration.MessageState;

/**
 * Created by Bas on 5-10-2015.
 */
public class StatusMessage {
    private final String message;
    private final MessageState state;

    /**
     * Creates a statusmessage
     * @param state the state
     * @param message the extra message
     */
    public StatusMessage(MessageState state, String message) {
        this.state = state;
        this.message = message;
    }

    /**
     * Turns this object into a object used by the Orchestration layer
     * @return a Orchestration representation
     */
    public nl.dare2date.matching.orchestration.StatusMessage toOrchestration() {
        nl.dare2date.matching.orchestration.StatusMessage soapMessage = new nl.dare2date.matching.orchestration.StatusMessage();
        soapMessage.setMessage(message);
        soapMessage.setState(state);
        return soapMessage;
    }
}
