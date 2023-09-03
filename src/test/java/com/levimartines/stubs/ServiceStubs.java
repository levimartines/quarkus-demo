package com.levimartines.stubs;

import com.levimartines.models.Service;

public class ServiceStubs {

	public static Service testService() {
		Service service = new Service();
		service.setName("lavagem simples");
		service.setValue(30.50);
		return service;
	}
}
