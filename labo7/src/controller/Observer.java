package controller;

import model.CipherEvent;

public interface Observer {
    void update(CipherEvent event);
}
