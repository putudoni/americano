package com.pnwd.americano.event;

import com.pnwd.americano.model.Product;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProductReviewEvent {

	private final Product product;

}
