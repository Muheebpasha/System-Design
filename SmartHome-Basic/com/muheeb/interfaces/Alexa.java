
package com.muheeb.interfaces;

// Alexa Implementation
public class Alexa implements InterfaceDevice {
    private String name;
    private String activationKeyword;

    public Alexa(String name, String activationKeyword ) {
        this.name = name;
        this.activationKeyword = activationKeyword;
    }

    @Override
    public String getActivationKeyword() {
        return activationKeyword;
    }
    
    @Override
    public void sendCommand(SmartHomeDevice device, String command) {
        System.out.println(name + " sending command: " + command);
        if ("On".equalsIgnoreCase(command)) {
            device.turnOn();
        } else if ("Off".equalsIgnoreCase(command)) {
            device.turnOff();
        } else {
            System.out.println("Invalid command.");
        }
    }

    @Override
    public void receiveResponse(String response) {
        System.out.println(name + " received response: " + response);
    }

    @Override
    public String getName() {
        return "Alexa"; // Replace with the actual device name
    }


}