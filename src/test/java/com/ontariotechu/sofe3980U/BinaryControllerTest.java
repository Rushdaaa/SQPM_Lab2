package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryController.class)
public class BinaryControllerTest {

    @Autowired
    private MockMvc mvc;

    // ✅ Basic UI Tests
    // Test to verify the default view of the calculator
    @Test
    public void getDefaultCalculatorView() throws Exception {
        this.mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", ""))
                .andExpect(model().attribute("operand1Focused", false));
    }

    // Test to verify the calculator view with an operand
    @Test
    public void getCalculatorWithOperand() throws Exception {
        this.mvc.perform(get("/").param("operand1", "111"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", "111"))
                .andExpect(model().attribute("operand1Focused", true));
    }

    // ✅ Binary Operations Tests
    // Test to verify the addition operation
    @Test
    public void postAdditionOperation() throws Exception {
        this.mvc.perform(post("/").param("operand1", "111").param("operator", "+").param("operand2", "111"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1110"))
                .andExpect(model().attribute("operand1", "111"));
    }

    // Test to verify the multiplication operation
    @Test
    public void postMultiplicationOperation() throws Exception {
        this.mvc.perform(post("/").param("operand1", "101").param("operator", "*").param("operand2", "11"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1111")); // 101 * 11 = 1111
    }

    // Test to verify the bitwise AND operation
    @Test
    public void postBitwiseAndOperation() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1101").param("operator", "&").param("operand2", "1011"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1001")); // 1101 & 1011 = 1001
    }

    // Test to verify the bitwise OR operation
    @Test
    public void postBitwiseOrOperation() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1010").param("operator", "|").param("operand2", "0110"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1110")); // 1010 | 0110 = 1110
    }

    // ❗️ Error Handling Tests
    // Test to verify error handling for invalid operator
    @Test
    public void postInvalidOperatorError() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1010").param("operator", "-").param("operand2", "11"))
                .andExpect(status().isOk())
                .andExpect(view().name("error")); // Expecting error for unsupported operator
    }

    // Test to verify error handling for invalid binary input
    @Test
    public void postInvalidBinaryInputError() throws Exception {
        this.mvc.perform(post("/").param("operand1", "102").param("operator", "+").param("operand2", "11"))
                .andExpect(status().isOk())
                .andExpect(view().name("error")); // Invalid binary input should trigger error view
    }

    // ✅ Edge Case Tests
    // Test to verify default behavior for empty operands
    @Test
    public void postEmptyOperandsDefaultToZero() throws Exception {
        this.mvc.perform(post("/").param("operand1", "").param("operator", "+").param("operand2", ""))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0")); // Empty inputs treated as zero
    }

    // Test to verify addition operation with leading zeros
    @Test
    public void postAdditionWithLeadingZeros() throws Exception {
        this.mvc.perform(post("/").param("operand1", "000101").param("operator", "+").param("operand2", "000011"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1000")); // 101 + 11 = 1000
    }

    // Test to verify addition operation with large binary numbers
    @Test
    public void postAdditionWithLargeBinaryNumbers() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1111111111111111").param("operator", "+").param("operand2", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "10000000000000000")); // Large binary numbers
    }
}
