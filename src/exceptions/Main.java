package exceptions;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws DeviceIsOffException {
        
        Device dev = new Device();
        dev.ping();
        
     //     List<Device> devices = new ArrayList<>();
     //     devices.add(new Mouse(true));
     //     devices.add(new Display(true));

    }
}

class Device {
    

    public void ping() throws DeviceIsOffException {

        Mouse mouse = new Mouse();
        Display display = new Display();
        Keyboard keyboard = new Keyboard();

        mouse.mouseCheck();
        display.displayCheck();
        keyboard.keyboardCheck();

    }
}

class Mouse extends Device {

    boolean isOn = true;

    public void mouseCheck() throws DeviceIsOffException {
       if (isOn = true){
           System.out.println("Mouse working");
       }
       else {
           throw new DeviceIsOffException("Mouse not working");
       }
   }

}
class Display extends Device {

    boolean isOn = true;

    public void displayCheck() throws DeviceIsOffException {
        if (isOn = true){
            System.out.println("Display working");
        }
        else {
            throw new DeviceIsOffException("Display not working");
        }
    }

}
class Keyboard extends Device {

    boolean isOn = true;

    public void keyboardCheck() throws DeviceIsOffException {
        if (isOn = true){
            System.out.println("Keyboard working");
        }
        else {
            throw new DeviceIsOffException("Keyboard not working");
        }
    }
}


class DeviceIsOffException extends Exception {

    public DeviceIsOffException(String message) {
        super(message);
    }

}

class Monitoring {

    public void pingAllDevices() {

    }
}