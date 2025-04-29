package com.epbs.console.ui;

import com.epbs.util.Utilities;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EPBS {
    private static final Logger LOGGER = Logger.getLogger(EPBS.class.getName());

    private final Screen screen;
    private final Keypad keypad;

    private static final int NEW_MANUFACTURER = 1;
    private static final int NEW_ASSEMBLY = 2;
    private static final int NEW_PART = 3;
    private static final int EXIT = 4;

    public EPBS(){
        screen = new Screen();
        keypad = new Keypad();
    }

    private int displayMainMenu(){
        screen.displayMessageLine("\nMain menu:");
        screen.displayMessageLine("1 - Work with Manufacturers");
        screen.displayMessageLine("2 - Work with Assemblies");
        screen.displayMessageLine("3 - Work with Part");
        screen.displayMessageLine("4 - Exit system");
        String userInput = "";
        try{
            userInput = keypad.getInput();
            if(!Utilities.isDigit(userInput)){
                LOGGER.log(Level.SEVERE, "Option invalid");
            }
        }
        catch (IOException ex){
            LOGGER.log(Level.SEVERE, "Invalid input");
        }
        return Integer.parseInt(userInput);
    }

    private void startOperations(){
        boolean userExited = false;
        while (!userExited){
            int mainMenuSelection = displayMainMenu();
            switch (mainMenuSelection){

                case EXIT :
                    screen.displayMessage("\nExiting the system epbs...");
                    userExited = true;
                default:
                    screen.displayMessageLine("\nYou did not enter a valid selection. Try again");
            }
        }

    }

    public void run(){
        while (true){
            startOperations();
            screen.displayMessageLine("\nThank you, goodbye...");
        }
    }


}
