package com.app.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.PaymentRepository;
import com.app.dao.UserRepository;
import com.app.dto.PaymentDTO;
import com.app.pojos.Payment;
import com.app.pojos.User;

@Service
@Transactional
public class PaymentServiceImpl implements IPaymentService {
	
	@Autowired
	private PaymentRepository payRepo;

	@Autowired
	private UserRepository userRepo;

	@Override
	public Payment addPaymentDetails(PaymentDTO paymentDto) {

		Payment payment = new Payment();
		int UserId= paymentDto.getUser_id();
		User user = userRepo.findById(UserId);
		user.setIsPremium(true);
		
		BeanUtils.copyProperties(paymentDto, payment);
		System.out.println("add payment src : " + paymentDto);
		System.out.println(payment);
		
		return payRepo.save(payment);
	}

	
	
	
}
