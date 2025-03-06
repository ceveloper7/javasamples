package com.ceva.renders;

import com.ceva.providers.MessageProvider;

public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider messageProvider);
}
