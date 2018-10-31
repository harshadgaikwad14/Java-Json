package com.example;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class JsonUtility {

	private static ObjectMapper getObjectMapper() {
		final ObjectMapper mapper = new ObjectMapper();
		final SimpleModule module = new SimpleModule();
		module.addSerializer(BigDecimal.class, new ToStringSerializer());
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.registerModule(module);
		return mapper;

	}

	private static Employee getEmployee() {
		final Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Harshad");
		employee.setSalary(new BigDecimal("500.12"));
		final Address address = new Address();
		address.setCity("Mumbai");
		address.setCountry("India");
		employee.setAddress(address);
		final String[] friends = { "A", "B", "C" };
		employee.setFriends(friends);
		employee.setHobby(Arrays.asList("Cricket", "football"));
		final Map<String, String> job = new HashMap<String, String>();
		job.put("ATOM", "2");
		job.put("TRAVELEX", "3");
		employee.setJob(job);

		return employee;
	}

	private static JsonNode createJson(final Employee employee) {
		final JsonNode node = getObjectMapper().convertValue(employee, JsonNode.class);
		return node;
	}

	private static Employee getEmployee(final JsonNode employeeNode) {
		return Optional.ofNullable(employeeNode).map(emp -> getObjectMapper().convertValue(emp, Employee.class))
				.orElse(null);
	}

	public static void main(String[] args) {
		/* Get Employee Object */
		final Employee employee = getEmployee();

		/* Get Employee Json Object */
		final JsonNode employeeNode = createJson(employee);
		System.out.println("employeeNode : " + employeeNode);

		/* Get Employee-Adreess Json Object */
		final JsonNode addressNode = (JsonNode) Optional.ofNullable(employeeNode).map(emp -> emp.get("address"))
				.orElse(null);
		System.out.println("addressNode : " + addressNode);

		/* Get Employee-Adreess-City Json String Value */
		String city = addressNode.get("city").textValue();
		System.out.println("city : " + city);

		/* Get Employee Object from Json Object */
		final Employee employeeParse = getEmployee(employeeNode);
		System.out.println("employeeParse : " + employeeParse);

	}

}
