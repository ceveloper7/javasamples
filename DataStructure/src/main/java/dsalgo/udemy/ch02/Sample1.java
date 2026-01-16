package dsalgo.udemy.ch02;

/**
 * Forma ineficiente de trabajar con String
 */
public class Sample1 {
    public String commaSeparatedList(String[] names){
        String nameList = "";

        /**
         * En cada iteracion se crea un nuevo String de tamano: nameList.length() + (name + ",").length
         */
        for(String name : names){
            nameList += name + ",";
        }

        return nameList.substring(0, nameList.length() - 1);
    }

    // version mejorada
    public String buildCommaSeparatedLIst(String[] names){
        // StringBuilder utiliza array dinemsionales
        StringBuilder nameList = new StringBuilder();
        for(String name : names){
            nameList.append(name).append(","); // complejidad Big O(1)
        }

        return  nameList.substring(0, nameList.length() - 1);
    }
}
