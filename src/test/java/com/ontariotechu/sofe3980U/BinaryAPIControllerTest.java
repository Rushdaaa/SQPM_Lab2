package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

    // Test for addition operation
    @Test
    public void testAddition() throws Exception {
        this.mvc.perform(get("/add").param("operand1", "111").param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(content().string("10001"));
    }

    // Test for multiplication operation
    @Test
    public void testMultiplication() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1", "101").param("operand2", "11"))
                .andExpect(status().isOk())
                .andExpect(content().string("1111")); // 101 * 11 = 1111
    }

    // Test for bitwise AND operation
    @Test
    public void testBitwiseAnd() throws Exception {
        this.mvc.perform(get("/and").param("operand1", "1101").param("operand2", "1011"))
                .andExpect(status().isOk())
                .andExpect(content().string("1001")); // 1101 & 1011 = 1001
    }

    // Test for bitwise OR operation
    @Test
    public void testBitwiseOr() throws Exception {
        this.mvc.perform(get("/or").param("operand1", "1010").param("operand2", "0110"))
                .andExpect(status().isOk())
                .andExpect(content().string("1110")); // 1010 | 0110 = 1110
    }

    // Test for bitwise OR operation with JSON response
    @Test
    public void testOrJSON() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1", "1010").param("operand2", "0110"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.operand1").value("1010"))
                .andExpect(jsonPath("$.operand2").value("110")) // Updated expected value
                .andExpect(jsonPath("$.result").value("1110"))
                .andExpect(jsonPath("$.operator").value("or"));
    }

    // Test for invalid binary input
    @Test
    public void testInvalidInput() throws Exception {
        this.mvc.perform(get("/add").param("operand1", "102").param("operand2", "11"))
                .andExpect(status().isOk())
                .andExpect(content().string("11")); // Invalid binary "102" defaults to "0"
    }

    // Test for zero operands
    @Test
    public void testZeroOperands() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1", "0").param("operand2", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("0")); // 0 * 0 = 0
    }
}