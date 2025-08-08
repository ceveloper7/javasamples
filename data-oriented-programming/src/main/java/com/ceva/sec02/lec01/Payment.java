package com.ceva.sec02.lec01;

public sealed abstract class Payment permits Cash, CreditCard{
    public abstract void process(double amount);
}
