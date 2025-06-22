
interface Command {
    void execute();
}


class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}


class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}


class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}


public class Main {
    public static void main(String[] args) {
        
        Light livingRoomLight = new Light();

        
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        
        RemoteControl remote = new RemoteControl();

        
        remote.setCommand(lightOn);
        remote.pressButton();

        
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
