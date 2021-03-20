package com.app.service;

import com.app.dto.PaymentDTO;
import com.app.pojos.Payment;
import com.app.pojos.User;

public interface IPaymentService {

	Payment addPaymentDetails(PaymentDTO paymentDto);
}
