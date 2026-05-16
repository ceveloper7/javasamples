package com.ceva.io;

import java.io.Serializable;

/**
 * Al ser Request y Response Serializable, las clases cuando se transmiten por la red
 * pasan como una matriz de bytes
 *
 * Como nuestra nuestra aplicacion se va a comunicar con otra aplicacion java, esta bien la serializacion pero
 * si quisieramos que nuestra aplicacion se comunique con otra aplicacion con un lenguaje de programacion
 * distinto podriamos optar por serializar los objetos a texto como JSON para permitir la compatibilidad.
 */
public class Request implements Serializable {
    private static final long serialVersionUID = 1L;

    private Double op1;
    private Double op2;
    private String oper;
    public Request(Double op1, Double op2, String oper) {
        super();
        this.op1 = op1;
        this.op2 = op2;
        this.oper = oper;
    }
    public Request() {
        super();
    }
    public Double getOp1() {
        return op1;
    }
    public void setOp1(Double op1) {
        this.op1 = op1;
    }
    public Double getOp2() {
        return op2;
    }
    public void setOp2(Double op2) {
        this.op2 = op2;
    }
    public String getOper() {
        return oper;
    }
    public void setOper(String oper) {
        this.oper = oper;
    }
    @Override
    public String toString() {
        return "Request [op1=" + op1 + ", op2=" + op2 + ", oper=" + oper + "]";
    }
}
