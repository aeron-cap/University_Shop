/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER-E5-471
 */
class UserU {
    private String uniformC;
    private int quantityCU,  idCU;
    private double priceCU;
 
    public UserU(int idCU, String uniformC, int quantityCU, double priceCU){
        
        this.idCU = idCU;
        this.uniformC=uniformC;
        this.quantityCU=quantityCU;
        this.priceCU= priceCU;

    }
    public int getQuantityU(){
        return quantityCU;
    }
    public String getUniform(){
        return uniformC;
    }
    public double getPriceCU() {
        return priceCU;
    }
    public int getidCU() {
        return idCU;
    }
}

class UserB {
    private String bookC;
    private int quantityCB, priceCB;

    public UserB(String bookC, int quantityCB, int priceCB) {

        this.bookC = bookC;
        this.quantityCB = quantityCB;
    }
    public int getQuantityB() {
        return quantityCB;
    }
    public String getBook() {
        return bookC;
    }
    public int getPriceCB() {
        return priceCB;
    }
}