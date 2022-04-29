package com.pnwd.americano.event;

import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductReviewEventHandler {

	@TransactionalEventListener
	public void productReview(ProductReviewEvent event) {
		log.info("event : {}",event);
	}
	
}
