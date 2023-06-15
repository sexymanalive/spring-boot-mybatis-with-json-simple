package com.example.testing_json;

import com.example.testing_json.model.MadeUpData;
import com.example.testing_json.model.Person;
import com.example.testing_json.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.security.auth.Subject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class TestingJsonApplicationTests {


	@Autowired
	PersonService personService;

	@Test
	void contextLoads() {
	}

	@Test
	void testingInsertionByOne(){
		System.out.println("TypeHandler Insertion ");
		Person person = new Person("mr.james",12,"siem reap");
		int result =  personService.savingData(person);
		personService.savingData(person);
		System.out.println("Here is the value of the result is : "+result);


	}

	@Test
	void testingInsertion(){
		System.out.println("testing insertion of person ");


		List<Person> people = new ArrayList<>(){{
			add(new Person("mr.james",21,"phnom penh"));
			add(new Person("mr.bona john",22,"testing location"));
			add(new Person("mr.apple",33,"siem reap "));
		}};
		int rowResult = personService.insertListOfPeople(people);
		System.out.println("Here is the row Result is : "+rowResult);


	}


	@Test
	void testingReadingValue() throws IOException {
		Person person = personService.getPersonByID(1);
		System.out.println("**********************************************");
		System.out.println("Person name is : "+person.getName());
		System.out.println("Person Age is : "+person.getAge());
		System.out.println("Person Address is : "+person.getAddress());
		System.out.println("**********************************************");
		System.out.println("Here is the value of the Person : "+person);
	}

	@Test
	void readingValueAsList () throws IOException {

		System.out.println("Reading the list of object :");
		List<Person> people = personService.gettingListOfPeople(4);
		System.out.println("Here are the list of the users : "+people);

	}

}
