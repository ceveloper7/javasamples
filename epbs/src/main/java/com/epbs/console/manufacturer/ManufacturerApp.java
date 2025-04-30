package com.epbs.console.manufacturer;

import com.epbs.console.ui.Keypad;
import com.epbs.console.ui.Screen;
import com.epbs.model.Manufacturer;
import com.epbs.util.Utilities;

import java.io.IOException;
import java.security.Key;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManufacturerApp {
    private static final Logger LOGGER = Logger.getLogger(ManufacturerApp.class.getName());

    private static final int CREATE_MANUFACTURER = 1;
    private static final int UPDATE_MANUFACTURER = 2;
    private static final int SEARCH_MANUFACTURER = 3;
    private static final int DELETE_MANUFACTURER = 4;
    private static final int EXIT = 5;

    Manufacturer manufacturer = new Manufacturer();

    public void doSetup(){
        startOperations();
    }

    private void manufacturerId(){
        while (true){
            Screen.displayMessageLine("Enter Manufacturer ID: ");
            try{
                String id = Keypad.getInput();
                if(!Utilities.isDigit(id)){
                    Screen.displayMessageLine("Invalid id, must be a number");
                    continue;
                }
                manufacturer.setId(Integer.parseInt(id));
                break;
            }
            catch (IOException ex){
                LOGGER.log(Level.SEVERE, "Invalid Manufacturer Id");
            }
            break;
        }
    }

    private String manufacturerCode(){
        return manufacturer.getName().substring(0,2);
    }

    private void manufacturerName(){
        Screen.displayMessageLine("Enter Manufacturer name: ");
        try{
            String name = Keypad.getInput();
            if(name != null && !name.trim().isEmpty()){
                manufacturer.setName(name);
                manufacturer.setCode(manufacturerCode());
            }
        }
        catch (IOException ex){
            LOGGER.log(Level.SEVERE, "Invalid input");
        }
    }

    private void manufacturerDescription(){
        Screen.displayMessageLine("Enter a description: ");
        try{
            String description = Keypad.getInput();
            if(!description.isBlank() && !description.trim().isEmpty()){
                manufacturer.setDescription(description);
            }
            else{
                manufacturer.setDescription("");
            }
        }
        catch (IOException ex){}
    }

    private int displayMainMenu(){
        Screen.displayMessageLine("\nManufacturer Main Menu");
        Screen.displayMessageLine("1 - Add new Manufacturer");
        Screen.displayMessageLine("2 - Update Manufacturer");
        Screen.displayMessageLine("3 - Search Manufacturer");
        Screen.displayMessageLine("4 - Delete Manufacturer");
        Screen.displayMessageLine("5 - Exit");
        String userInput = "";
        try{
            userInput = Keypad.getInput();
            if(!Utilities.isDigit(userInput)){
                LOGGER.log(Level.SEVERE, "Option invalid");
            }
            return Integer.parseInt(userInput);
        }
        catch (IOException ex){
            LOGGER.log(Level.SEVERE, "Invalid user input");
        }
        return 0;
    }

    private void addNewManufacturer(){
        try{
            manufacturerId();
            manufacturerName();
        }
        catch (Exception ex){
            throw new RuntimeException();
        }
    }

    private void startOperations(){
        boolean userExited = false;
        while (!userExited){
            int manufacturerMainMenu = displayMainMenu();
            switch (manufacturerMainMenu){
                case CREATE_MANUFACTURER:
                    addNewManufacturer();
                    break;
            }
        }
    }
}
