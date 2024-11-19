package Bridge;

import Bridge.devices.SmartTv;
import Bridge.remotes.SmartRemote;

public class Demo {
    public static void main(String[] args) {
        SmartTv smartTV = new SmartTv();
        SmartRemote smartRemote = new SmartRemote(smartTV);

        smartRemote.power();
        smartRemote.volumeUp();
        smartRemote.channelUp();

        smartRemote.voiceControl("Open YouTube");
        smartTV.browseInternet();
    }
}
