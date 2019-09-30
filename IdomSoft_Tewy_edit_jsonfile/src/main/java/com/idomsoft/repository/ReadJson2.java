package com.idomsoft.repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJson2 {

	public static <T> List<T> readJSONList(String jsonPath) {

		ObjectMapper objectMapper = new ObjectMapper();
		List<T> resultList = null;

		try {
			resultList = objectMapper.readValue(new File(jsonPath), new TypeReference<List<?>>() {
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultList;
	}

	public static <T> T readJSON(String jsonPath, Class<T> clazz) {

		ObjectMapper objectMapper = new ObjectMapper();
		T result = null;

		try {
			result =  (T) objectMapper.readValue(new File("src/main/resources/static/JSON/Szemely_1.json"),clazz);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clazz.cast(result);
	}

}