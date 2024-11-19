package Bridge.remotes;

import Bridge.devices.Device;

public class SmartRemote extends AdvancedRemote {
    public SmartRemote(Device device) {
        super(device);
    }

    public void voiceControl(String command) {
        if (device.isEnabled()) {
            System.out.println("Executing voice command: " + command);
        } else {
            System.out.println("Turn on the device to use voice control.");
        }
    }
    
}
