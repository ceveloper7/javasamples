package com.ceva.ch02.ajusteSerializacion;

import java.io.*;
import java.awt.geom.*;

/**
 * Ejemplo de Personalizacion del Mecanismo de Serializacion
 * Vamos a serializar la clase LabeledPoint que posee el
 * atributo point que es de tipo Point2D.Double el cual no es serializable
 */
public class LabeledPoint {
    private String label;
    // con transient evitarmos la serializacion del atributo
    private transient Point2D.Double point;

    public LabeledPoint(String label, double x, double y)
    {
        this.label = label;
        this.point = new Point2D.Double(x, y);
    }

    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException
    {
        System.out.println("writeObject");
        out.defaultWriteObject();
        out.writeDouble(point.getX());
        out.writeDouble(point.getY());
    }

    @Serial
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
    {
        System.out.println("readObject");
        in.defaultReadObject();
        double x = in.readDouble();
        double y = in.readDouble();
        point = new Point2D.Double(x, y);
    }

    public String getLabel()
    {
        return label;
    }

    public Point2D.Double getPoint()
    {
        return point;
    }

    public String toString()
    {
        return "%s[label=%s,point=%s]".formatted(getClass(), label, point);
    }
}
