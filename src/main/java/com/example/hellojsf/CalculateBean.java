package com.example.hellojsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CalculateBean {
    private int number1;
    private int number2;
    private int result;

    public void diff(){
        result = number1-number2;
    }
    public void mult(){
        result = number1*number2;
    }
    public void divide(){
        result = number1/number2;
    }
    public void sum(){
        result = number1+number2;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
