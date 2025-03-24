package com.ood.ch01.ricksGuitarChoise;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private List<Guitar> guitars;

    public Inventory(){
        guitars = new LinkedList<Guitar>();
    }

    public void addGuitar(String serialNUmber, double price, Builder builder, String model, Type type, Wood backWood, Wood topWood){
        Guitar guitar = new Guitar(serialNUmber, price, builder, model, type, backWood, topWood);
        guitars.add(guitar);
    }

    public Guitar getGuitar(String serialNUmber){
        for (Guitar guitar : guitars) {
            if (guitar.getSerialNUmber().equals(serialNUmber))
                return guitar;
        }
        return null;
    }

    /*
     * Retornamos todas las guitarras que coincidan con la busqueda del cliente
     */
    public List search(Guitar searchGuitar){
        List matchingGuitars = new LinkedList();
        for (Guitar guitar : guitars) {
            // Ignore serial number since that's unique
            // Ignore price since that's unique
            if (searchGuitar.getBuilder() != guitar.getBuilder())
                continue;
            String model = searchGuitar.getModel().toLowerCase();
            if ((model != null) && (!model.equals("")) && (!model.equals(guitar.getModel().toLowerCase())))
                continue;
            if (searchGuitar.getType() != guitar.getType())
                continue;
            if (searchGuitar.getBackWood() != guitar.getBackWood())
                continue;
            if (searchGuitar.getTopWood() != guitar.getTopWood())
                continue;
            matchingGuitars.add(guitar);
        }
        return matchingGuitars;
    }
}
