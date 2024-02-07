package systeme.components.utils;

import org.example.systeme.components.IPorte;

public class PorteSpy implements IPorte {
    private boolean open = false;
    public void ouvrir() {
        this.open = true;
    }

    public boolean isOpen() {
        return open;
    }
}
