package com.pnwd.americano.models;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Putu Ngurah Wigadoni
 *
 */
public interface ProductNameBrand {

	@Value("#{'Product Name : ' + target.name + ', brand : ' +target.brand}")
	public String getTitle();
	
}
