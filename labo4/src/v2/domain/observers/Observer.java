package v2.domain.observers;

import v2.domain.BankEvent;

public interface Observer {
    void update(BankEvent event);
}
