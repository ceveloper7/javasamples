package org.ceva.ch03.fundamentals;

import org.ceva.ch03.fundamentals.datatypes.D_Enums;

public class F_Switch {
    public static void main(String[] args) {
        F_Switch swith = new F_Switch();
        swith.switchExpression();
        swith.switchStatement();
    }

    /*
     * Con tantas variaciones de switch, cual debemos usar
     * Debemos evitar la forma Fallthrough es poco comun necesitar fallthrough
     * Debemos preferir switch expression sobre switch statements
     */
    private void switchExpression(){
        // No Fallthrough: cada case termina con la flecha (->)
        D_Enums.Size size = D_Enums.Size.SMALL;
        int sizeValue = switch (size){
            case SMALL -> 1;
            case MEDIUM -> 2;
            case LARGE -> 3;
            case EXTRA_LARGE -> 4;
            default -> -1;
        };
        System.out.println(sizeValue);

        System.out.println("No Fallthrough");
        String seasonName = "Spring";
        int numLetters = switch (seasonName){
            case "Spring" -> {
                System.out.println("Spring break");
                yield 6;
            }

            case "Summer", "Winter" -> 6;
            case "Fall" -> 4;
            default -> -1;
        };

        // Fallthrough: Cada case termina con dos puntos (:)
        int seasonValue = switch(seasonName){
            case "Verano":
                yield 1;
            case "Otonio":
                yield 2;
            case "Invierno":
                yield 3;
            case "Primavera":
                yield 4;
            default:
                yield -1;
        };
        System.out.println(seasonValue);
    }

    private void switchStatement(){
        // Fallthrough
        D_Enums.Size size = D_Enums.Size.SMALL;
        int sizeValue = 0;
        switch (size){
            case SMALL:
                sizeValue = 1;
                break;

            case MEDIUM:
                sizeValue = 2;
                break;

            case LARGE:
                sizeValue = 3;
                break;

            case EXTRA_LARGE:
                sizeValue = 4;
                break;

            default: sizeValue = -1;
        }
        System.out.println(sizeValue);

        // No Fallthrough
        String seasonName = "Invierno";
        int seasonValue = 0;
        switch (seasonName){
            case "Verano" -> {
                seasonValue = 1;
            }
            case "Otonio" -> {
                seasonValue = 2;
            }
            case "Invierno" -> {
                seasonValue = 3;
            }
            case "Primavera" -> {
                seasonValue = 4;
            }
            default ->  seasonValue = -1;
        };
        System.out.println(seasonValue);
    }
}
