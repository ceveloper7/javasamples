package com.ceva.ex1.ch02.expressions_operands_operators;

import com.ceva.util.Util;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Check If Loot Can Be Shared Fairly
 */
public class Program1 {
    private static final Logger LOGGER = Logger.getLogger(Program1.class.getName());

    private Scanner input = new Scanner(System.in);


    private boolean validateInput(String input){
        return Util.isDigit(input);
    }

    private void userInput(){
        int botellas;
        int tripulacion;

        System.out.print("Ingrese Cantidad de botellas robadas: ");
        String rpta = input.nextLine();
        if(validateInput(rpta)){
            botellas = Integer.parseInt(rpta);
        }else {
            LOGGER.log(Level.SEVERE, "Dato invalido");
            return;
        }

        System.out.print("Ingrese numero de la tripulacion: ");
        rpta = input.nextLine();
        if(validateInput(rpta)){
            tripulacion = Integer.parseInt(rpta);
        }else{
            LOGGER.log(Level.SEVERE, "Dato invalido");
            return;
        }

        process(botellas, tripulacion);
    }

    private void process(int botellas, int tripulacion){
        int botinCapitan = 0;
        int botinTripulacion = 0;
        if(botellas % 2 == 0){
            botinCapitan = botellas / 2;
            botinTripulacion = (botellas - botinCapitan) / tripulacion;
        }else{
            botinCapitan = (botellas - 1) / 2;
            botinTripulacion = (botellas - botinCapitan) / tripulacion;

        }

        output(botellas, tripulacion, botinCapitan, botinTripulacion);
    }

    private void output(int botellas, int tripulacion, int botinCapitan, int botinTripulacion){
        System.out.println("\n********* Reparticion del Botin *********");
        System.out.println("\tNumero de botellas del botin: " + botellas);
        System.out.println("\tNumero de la tripulacion: " + tripulacion);
        System.out.println("\tNumero de botellas para el Capitan: " + botinCapitan);
        System.out.println("\tNumero de botellas para cada miembro: " + botinTripulacion);
    }

    public static void main(String[] args) {
        Program1 program = new Program1();
        program.userInput();
    }
}
