package com.levimartines.stubs;

import com.levimartines.models.Car;

public class CarStub {

	public static Car testCar() {
		Car car = new Car();
		car.setPlate("DDD9999");
		car.setName("Corolla 2020");
		car.setComments("risco na lateral direita");
		return car;
	}

	public static Car testOldCar() {
		Car car = new Car();
		car.setPlate("AAA1234");
		car.setName("Parati 1996");
		return car;
	}
}
