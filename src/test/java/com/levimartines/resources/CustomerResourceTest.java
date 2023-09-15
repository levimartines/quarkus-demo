package com.levimartines.resources;

import com.levimartines.models.Customer;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class CustomerResourceTest extends BaseResourceTest {

	@Test
	void shouldCreateWhenInputIsValid() {
		Customer customer = createTestCustomer();
		Assertions.assertNotNull(customer.id);
		Assertions.assertNotNull(customer.getCars().get(0).id);
	}

}