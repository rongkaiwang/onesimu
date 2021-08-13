package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A multi-message that is created at a node or passed between a node and a list of nodes.
 */

public class MultiMessage extends Message{
    /** Value for infinite TTL of message */
    public static final int INFINITE_TTL = -1;
    private DTNHost from;
    private DTNHost to;
    /* Destination List of the message */
    private List<DTNHost> dest;
    /** Identifier of the message */
    private String id;
    /** Size of the message (bytes) */
    private int size;
    /** List of nodes this message has passed */
//    private List<DTNHost> path;
    /** Next unique identifier to be given */
//    private static int nextUniqueId;
    /** Unique ID of this message */
//    private int uniqueId;
    /** The time this message was received */
//    private double timeReceived;
    /** The time when this message was created */
//    private double timeCreated;
    /** Initial TTL of the message */
//    private int initTtl;

    /** if a response to this message is required, this is the size of the
     * response message (or 0 if no response is requested) */
//    private int responseSize;
    /** if this message is a response message, this is set to the request msg*/
//    private Message requestMsg;

    /** Container for generic message properties. Note that all values
     * stored in the properties should be immutable because only a shallow
     * copy of the properties is made when replicating messages */
    private Map<String, Object> properties;

    /** Application ID of the application that created the message */
//    private String	appID;

    /**
     * Creates a new Message.
     *
     * @param from Who the message is (originally) from
     * @param to   Who the message is (originally) to
     * @param dest   Who the message is (possibly) to
     * @param id   Message identifier (must be unique for message but
     *             will be the same for all replicates of the message)
     * @param size Size of the message (in bytes)
     */
    public MultiMessage(DTNHost from, DTNHost to, List<DTNHost> dest, String id, int size) {
        super(from, to, id, size);
        this.dest = dest;
    }

    /**
     * Returns the node list this message is originally towards
     * @return the node list this message is originally towards
     */
    public List<DTNHost> getDest() {return this.dest; }

    /**
     * Deep copies message data from other message. If new fields are
     * introduced to this class, most likely they should be copied here too
     * (unless done in constructor).
     * @param m The message where the data is copied
     */
    protected void copyFrom(MultiMessage m) {
        this.dest = m.dest;

        if (m.properties != null) {
            Set<String> keys = m.properties.keySet();
            for (String key : keys) {
                updateProperty(key, m.getProperty(key));
            }
        }
    }

    /**
     * Returns a replicate of this multi-message (identical except for the unique id)
     * @return A replicate of the multi-message
     */
    public Message replicate() {
        Message m = new MultiMessage(from, to, dest, id, size);
        m.copyFrom(this);
        return m;
    }
//    static {
//        reset();
//        DTNSim.registerForReset(Message.class.getCanonicalName());
//    }



}
