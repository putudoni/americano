package com.pnwd.americano.events;

import com.pnwd.americano.models.Product;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProductReviewEvent {

	private final Product product;

}
