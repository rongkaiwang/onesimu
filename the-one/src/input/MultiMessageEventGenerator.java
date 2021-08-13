package input;

import java.util.Random;

import core.Settings;
import core.SettingsError;


public class MultiMessageEventGenerator extends MessageEventGenerator {

    /**
     * Constructor, initializes the interval between events,
     * and the size of messages generated, as well as number
     * of hosts in the network.
     *
     * @param s Settings for this generator.
     */
    public MultiMessageEventGenerator(Settings s) {
        super(s);
    }
}
