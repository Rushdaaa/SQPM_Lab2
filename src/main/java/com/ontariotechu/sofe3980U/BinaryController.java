package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BinaryController {

	// Handles GET requests to the root URL and displays the calculator page
	@GetMapping("/")
	public String getCalculator(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
			Model model) {
		// Add operand1 to the model and set focus if operand1 is not empty
		model.addAttribute("operand1", operand1);
		model.addAttribute("operand1Focused", operand1.length() > 0);
		return "calculator";
	}

	// Handles POST requests to the root URL and processes the calculation
	@PostMapping("/")
	public String result(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
			@RequestParam(name = "operator", required = false, defaultValue = "") String operator,
			@RequestParam(name = "operand2", required = false, defaultValue = "") String operand2, Model model) {
		// Add operands and operator to the model
		model.addAttribute("operand1", operand1);
		model.addAttribute("operator", operator);
		model.addAttribute("operand2", operand2);

		// Validate that both operands are binary numbers
		if (!operand1.matches("[01]*") || !operand2.matches("[01]*")) {
			return "error"; // Trigger error view for invalid binary input
		}

		// Create Binary objects from the operands
		Binary number1 = new Binary(operand1);
		Binary number2 = new Binary(operand2);
		Binary result = null;

		// Perform the operation based on the operator
		switch (operator) {
			case "+":
				result = Binary.add(number1, number2);
				break;
			case "&":
				result = Binary.and(number1, number2);
				break;
			case "|":
				result = Binary.or(number1, number2);
				break;
			case "*":
				result = Binary.multiply(number1, number2);
				break;
			default:
				return "error"; // Trigger error view for invalid operator
		}

		// Add the result to the model and return the result view
		model.addAttribute("result", result.getValue());
		return "result";
	}
}