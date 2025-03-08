package org.ceva.renders;

import org.ceva.providers.MessageProvider;

public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider messageProvider);
}
