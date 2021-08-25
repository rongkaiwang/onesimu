package input;

import core.DTNHost;
import core.Message;
import core.MultiMessage;
import core.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MultiMessageCreateEvent extends MultiMessageEvent{
    private int size;
    private int responseSize;

    /**
     * Creates a multi-message  event
     *
     * @param from Where the message comes from
     * @param to   Who the message goes to
     * @param id   ID of the message
     * @param time Time when the message event occurs
     * @param dest grouplist of the node the message is to
     */
    public MultiMessageCreateEvent(int from, int to, String id, double time, Set<DTNHost> dest,
                                   int size, int responseSize) {
        super(from, to, id, time, dest);
        this.size = size;
        this.responseSize = size;
    }

    /**
     * Creates the multi-message this event represents.
     */
    @Override
    public void processEvent(World world) {
        DTNHost to = world.getNodeByAddress(this.toAddr);
        DTNHost from = world.getNodeByAddress(this.fromAddr);

        MultiMessage m = new MultiMessage(from, to, this.dest, this.id, this.size);
        List<DTNHost> destinations = new ArrayList<DTNHost>();
        destinations.add(to);
        m.setResponseSize(this.responseSize);
        m.updateProperty("destination", destinations);
        from.createNewMultiMessage(m);//mark add points here
    }

    @Override
    public String toString() {
        return super.toString() + " [" + fromAddr + "->" + toAddr + "] " +
                "size:" + size + " CREATE";
    }
}
