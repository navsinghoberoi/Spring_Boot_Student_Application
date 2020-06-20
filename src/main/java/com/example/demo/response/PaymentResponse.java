package com.example.demo.response;

public class PaymentResponse {

    private String message;
    private Integer code;
    private double updatedWalletBalance;

    public double getUpdatedWalletBalance() {
        return updatedWalletBalance;
    }

    public void setUpdatedWalletBalance(double updatedWalletBalance) {
        this.updatedWalletBalance = updatedWalletBalance;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
