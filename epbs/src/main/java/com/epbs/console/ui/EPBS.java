package com.epbs.console.ui;

import com.epbs.console.manufacturer.ManufacturerApp;
import com.epbs.util.Utilities;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EPBS {
    private static final Logger LOGGER = Logger.getLogger(EPBS.class.getName());

    private static final int WORK_WITH_MANUFACTURER = 1;
    private static final int WORK_WITH_ASSEMBLY = 2;
    private static final int WORK_WITH_PART = 3;
    private static final int EXIT = 4;

    public EPBS(){
    }

    private int displayMainMenu(){
        Screen.displayMessageLine("\nMain menu:");
        Screen.displayMessageLine("1 - Work with Manufacturers");
        Screen.displayMessageLine("2 - Work with Assemblies");
        Screen.displayMessageLine("3 - Work with Part");
        Screen.displayMessageLine("4 - Exit system");
        String userInput = "";
        try{
            userInput = Keypad.getInput();
            if(!Utilities.isDigit(userInput)){
                LOGGER.log(Level.SEVERE, "Option invalid");
            }
            return Integer.parseInt(userInput);
        }
        catch (IOException ex){
            LOGGER.log(Level.SEVERE, "Invalid input");
        }
        return 0;
    }

    private void startOperations(){
        boolean userExited = false;
        while (!userExited){
            int mainMenuSelection = displayMainMenu();
            ManufacturerApp manufacturerApp = null;
            switch (mainMenuSelection){
                case WORK_WITH_MANUFACTURER:
                    manufacturerApp = new ManufacturerApp();
                    manufacturerApp.doSetup();
                    break;
                case EXIT :
                    Screen.displayMessage("\nExiting the system epbs...");
                    userExited = true;
                    break;
                default:
                    Screen.displayMessageLine("\nYou did not enter a valid selection. Try again");
            }
        }

    }

    public void run(){
        while (true){
            startOperations();
            Screen.displayMessageLine("\nThank you, goodbye...");
        }
    }


}
