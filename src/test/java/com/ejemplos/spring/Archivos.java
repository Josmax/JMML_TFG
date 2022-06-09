package com.ejemplos.spring;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.ejemplos.spring.controller.IncidenciaController;

@ExtendWith(SpringExtension.class)
@WebMvcTest(IncidenciaController.class)
public class Archivos {
	 
	@Autowired
	private MockMvc mockMvc;
	 
	@Test
	void contextLoads() throws Exception {
		mockMvc.perform(get("/css/styles.css"))
			   .andDo(print())
			   .andExpect(status().isOk());
	}
}
