package com.example.testing_json.service;

import com.example.testing_json.model.MadeUpData;
import com.example.testing_json.model.Person;
import com.example.testing_json.repository.DataRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.Subject;
import java.io.IOException;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private DataRepository dataRepository;

    public int savingData(Person person) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonData = objectMapper.valueToTree(person);
        System.out.println("Here is the value of the json data :" + jsonData);
        return dataRepository.addingData(jsonData);

    }

    public int insertListOfPeople(List<Person> people){
        /*dataRepository.addingListData(people);*/
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonData = objectMapper.valueToTree(people);
        System.out.println("Here is the value of the list : "+jsonData);
        return dataRepository.addingData(jsonData);
    }


    public Person getPersonByID(int id) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = dataRepository.getPersonJsonAsStringById(id);
        return objectMapper.readValue(jsonString, Person.class);
    }

    public List<Person> gettingListOfPeople(int id ) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = dataRepository.getPersonJsonAsStringById(id);
        List<Person> personList = objectMapper.readValue(jsonString, new TypeReference<List<Person>>(){});

        return personList;
    }
}
