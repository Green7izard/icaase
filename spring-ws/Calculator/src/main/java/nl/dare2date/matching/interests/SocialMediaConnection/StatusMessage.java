package nl.dare2date.matching.interests.SocialMediaConnection;

import nl.dare2date.matching.orchestration.MessageState;

/**
 * Created by Bas on 5-10-2015.
 */
public class StatusMessage {
    private final String message;
    private final MessageState state;

    public StatusMessage(MessageState state, String message) {
        this.state = state;
        this.message = message;
    }

    public nl.dare2date.matching.orchestration.StatusMessage toSoap() {
        nl.dare2date.matching.orchestration.StatusMessage soapMessage = new nl.dare2date.matching.orchestration.StatusMessage();
        soapMessage.setMessage(message);
        soapMessage.setState(state);
        return soapMessage;
    }
}
