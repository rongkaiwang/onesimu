package input;

import core.DTNHost;

import java.util.List;

public class MultiMessageEvent extends ExternalEvent{
    /** address of the node the message is from */
    protected int fromAddr;
    /** address of the node the message is to */
    protected int toAddr;
    /** identifier of the message */
    protected String id;
    /** grouplist of the node the message is to */
    protected List<DTNHost> dest;

    /**
     * Creates a multi-message  event
     * @param from Where the message comes from
     * @param to Who the message goes to
     * @param id ID of the message
     * @param time Time when the message event occurs
     */
    public MultiMessageEvent(int from, int to, String id, double time, List<DTNHost> dest) {
        super(time);
        this.fromAddr = from;
        this.toAddr = to;
        this.id = id;
        this.dest = dest;
    }

    @Override
    public String toString() {
        return "MULTIMSG @" + this.time + " " + id;
    }
}
