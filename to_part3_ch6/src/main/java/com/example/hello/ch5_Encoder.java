package com.example.hello;


public class ch5_Encoder {

    private IEncoder iEncoder; // 본인이 가지고 있기

    public ch5_Encoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    public void setIEncoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    public String encode(String message){
        return iEncoder.encode(message);
    }
}
