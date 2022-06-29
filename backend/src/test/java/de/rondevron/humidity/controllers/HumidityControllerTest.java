package de.rondevron.humidity.controllers;

import de.rondevron.humidity.services.HumidityService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = HumidityController.class)
public class HumidityControllerTest {

    private final String endpoint = "/api/v1/humidity";
    private final String calcEndpoint = endpoint + "/calc";
    private final String sensorEndpoint = endpoint + "/sensor";

    @MockBean
    private HumidityService humidityServiceMock;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("should return 200 on calling " + calcEndpoint + " POST with correct data")
    void calculateHumidity_success() throws Exception {
        // arrange

        // act, assert
        mockMvc.perform(MockMvcRequestBuilders.post(calcEndpoint)
                .contentType(MediaType.APPLICATION_JSON).content("{\"temperature\": \"24.2\",\"humidity\": \"65\"}"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    @DisplayName("should return 200 on calling " + sensorEndpoint + " GET with correct data")
    void getAllHumidity_success() throws Exception {
        // arrange

        // act, assert
        mockMvc.perform(MockMvcRequestBuilders.get(sensorEndpoint))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    @DisplayName("should return 200 on calling " + sensorEndpoint + " PUT with correct data")
    void saveHumidityData_success() throws Exception {
        // arrange

        // act, assert
        mockMvc.perform(MockMvcRequestBuilders.put(sensorEndpoint)
                .contentType(MediaType.APPLICATION_JSON).content("{\"temperature\": \"24.2\",\"humidity\": \"65\"}"))
                .andExpect(MockMvcResultMatchers.status().is(201));
    }

    // ToDo: Test other issues, contents and return errors
}
