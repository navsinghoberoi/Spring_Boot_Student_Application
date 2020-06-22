package com.example.demo.controller;

import com.example.demo.model.PaymentRequest;
import com.example.demo.response.PaymentResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {
/*
    private static final double walletBalance = 100.0;
    private static final String secretKey = "SECRET_KEY";
    private static final String SUCCESS_STATUS = "success ";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 200;
    private static final int CODE_FAILURE = 400;

    @RequestMapping(value = "/debit/wallet", method = RequestMethod.POST)
    public PaymentResponse pay(@RequestParam(value = "key") String key, @RequestBody PaymentRequest request) {

        PaymentResponse response = new PaymentResponse();
        if (secretKey.equalsIgnoreCase(key)) {
            int userId = request.getUserId();
            String itemId = request.getItemId();

            double itemPrice = request.getPrice();
            double updatedBal = walletBalance - itemPrice;
            if (updatedBal < 0) {
                System.out.println("PRICE OF ITEM IS MORE THAN AVAILABLE WALLET BALANCE");
                response.setUpdatedWalletBalance(walletBalance);
                response.setMessage(ERROR_STATUS);
                response.setCode(CODE_FAILURE);
            } else {
                response.setUpdatedWalletBalance(updatedBal);
                response.setMessage(SUCCESS_STATUS);
                response.setCode(CODE_SUCCESS);
            }

        } else {
            response.setMessage("INCORRECT SECRET KEY");
            response.setCode(CODE_FAILURE);
        }
        return response;
    }*/
}
