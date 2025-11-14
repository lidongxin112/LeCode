package com.Disruptor;

/**
 * @author 东鑫
 */
public class TradeTransaction {
    private String id; //交易id
    private Double price; //价格
    public TradeTransaction(){

    }
    public TradeTransaction(String id,double price){
        super();
        this.id = id;
        this.price = price;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public double getPirce(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
}
