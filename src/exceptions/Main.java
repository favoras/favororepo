package exceptions;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws DeviceIsOffException {

        List<Device> devices=new ArrayList<>();
        devices.add(new Mouse(true));
        devices.add(new Display(true));
        devices.add(new Keyboard(true));
        devices.add(new Mouse(true));
        devices.add(new Display(true));
        devices.add(new Keyboard(true));
        Monitoring.pingAllDevices(devices);
        devices.get(3).setOn(false);
        System.out.println();
        Monitoring.pingAllDevices(devices);

    }
}

class Device {

    private boolean isOn;
    private static int newId;
    private int id;

    Device(boolean deviceStatus) {
        this.id = newId++;
        this.isOn = deviceStatus;
    }

    public void ping() throws DeviceIsOffException {
        if(!isOn()){
            throw new DeviceIsOffException("Prietaisas neveikia");
        }
    }


    public int getId() {
        return id;
    }

    public boolean isOn(){
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

}

class Mouse extends Device {

    public Mouse(boolean deviceStatus)
    {
        super(deviceStatus);
    }
}
class Display extends Device {

    public Display(boolean deviceStatus)
    {
        super(deviceStatus);
    }
}
class Keyboard extends Device {

    public Keyboard(boolean deviceStatus)
    {
        super(deviceStatus);
    }
}


class DeviceIsOffException extends Exception {

    public DeviceIsOffException(String message) {
        super(message);
    }

}

class Monitoring {

    public static void pingAllDevices(List<Device> devices) throws DeviceIsOffException {
        System.out.println("PINGING STARTED: ");
        for (Device device : devices) {
            try {
                device.ping();
                System.out.println(String.format("DEVICE %s with id %s is ON", device.getClass().getSimpleName(), device.getId()));
            } catch (DeviceIsOffException e) {
                System.out.println(String.format("DEVICE %s with id %s is OFF", device.getClass().getSimpleName(), device.getId()));
            }
        }
        System.out.println("PINGING FINISHED!!!");
    }
}
