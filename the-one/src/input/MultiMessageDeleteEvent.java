package input;

import core.DTNHost;
import core.Message;
import core.MultiMessage;
import core.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MultiMessageDeleteEvent extends MultiMessageEvent {

    /** is the delete caused by a drop (not "normal" removing) */
    private boolean drop;

    /**
     * Deletes the message
     */
    @Override
    public void processEvent(World world) {
        DTNHost host = world.getNodeByAddress(this.fromAddr);

        if (id.equals(StandardEventsReader.ALL_MESSAGES_ID)) {
            List<String> ids = new ArrayList<String>();
            for (MultiMessage m : host.getMultiMessageCollection()) {
                ids.add(m.getId());
            }
            for (String nextId : ids) {
                host.deleteMultiMessage(nextId, drop);
            }
        } else {
            host.deleteMultiMessage(id, drop);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " [" + fromAddr + "] DELETE";
    }
    /**
     * Creates a multi-message  event
     *
     * @param from Where the message comes from
     * @param to   Who the message goes to
     * @param id   ID of the message
     * @param time Time when the message event occurs
     * @param dest
     */
    public MultiMessageDeleteEvent(int from, int to, String id, double time, int[] dest) {
        super(from, to, id, time, dest);
    }
}
