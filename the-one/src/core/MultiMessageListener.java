package core;

import java.util.List;
import java.util.Set;

public interface MultiMessageListener {

    /**
     * Method is called when a new message is created
     * @param m multi-Message that was created
     */
    public void newMultiMessage(MultiMessage m);

    /**
     * Method is called when a multi-message's transfer is started
     * @param m The multi-message that is going to be transferred
     * @param from Node where the multi-message is transferred from
     * @param to Node where the multi-message is transferred to
     * @param dest list of nodes where the multi-message will be transfer to
     */
    public void multiMessageTransferStarted(MultiMessage m, DTNHost from, DTNHost to, Set<DTNHost> dest);

    /**
     * Method is called when a multi-message is deleted
     * @param m The multi-message that was deleted
     * @param where The host where the multi-message was deleted
     * @param dropped True if the multi-message was dropped, false if removed
     */
    public void multiMessageDeleted(MultiMessage m, DTNHost where, boolean dropped);

    /**
     * Method is called when a multi-message's transfer was aborted before
     * it finished
     * @param m The multi-message that was being transferred
     * @param from Node where the multi-message was being transferred from
     * @param to Node where the multi-message was being transferred to
     * @param dest list of nodes where the multi-message would be transfer to
     */
    public void multiMessageTransferAborted(MultiMessage m, DTNHost from, DTNHost to, Set<DTNHost> dest);

    /**
     * Method is called when a multi-message is successfully transferred from
     * a node to another.
     * @param m The multi-message that was transferred
     * @param from Node where the multi-message was transferred from
     * @param to Node where the multi-message was transferred to
     * @param firstDelivery Was the target node final destination of the message
     * and received this message for the first time.
     */
    public void multiMessageTransferred(MultiMessage m, DTNHost from, DTNHost to,
                                   boolean firstDelivery);
}
