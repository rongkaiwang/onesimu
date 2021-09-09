package routing;

import core.Settings;

public class CustomRouter extends ActiveRouter {
    /**
     * Constructor. Creates a new message router based on the settings in
     * the given Settings object.
     * @param s The settings object
     */
    public CustomRouter(Settings s) {
        super(s);
        //TODO: read&use custom router specific settings (if any)
    }

    @Override
    public void update() {
        super.update();
        if (isTransferring() || !canStartTransfer()) {
            return; // transferring, don't try other connections yet
        }

        // Try first the messages that can be delivered to final recipient
        if (exchangeDeliverableMultiMessages() != null) {
            return; // started a transfer, don't try others (yet)
        }

        // then try any/all message to any/all connection
        this.tryAllMultiMessagesToAllConnections();
    }



    /**
     * Copy constructor.
     * @param r The router prototype where setting values are copied from
     */
    protected CustomRouter(CustomRouter r) {
        super(r);
        //TODO: copy epidemic settings here (if any)
    }

    @Override
    public CustomRouter replicate() {
        return new CustomRouter(this);
    }
}
