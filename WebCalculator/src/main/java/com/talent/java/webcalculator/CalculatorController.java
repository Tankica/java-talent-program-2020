package com.talent.java.webcalculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/calculator")
public class CalculatorController {

    @PostMapping
    @GetMapping
    @ResponseBody
    public String calculate(@RequestParam Long firstOperand,
                            @RequestParam Long secondOperand,
                            @RequestParam String operator){

        System.out.println(firstOperand + " " + secondOperand + " " + operator);
        if(operator.equals("+")){
            return "Calculated number is " + (firstOperand + secondOperand);
        }else if(operator.equals("-") && firstOperand >= secondOperand){
            return "Calculated number is " + (firstOperand - secondOperand);
        }else {
            return "Invalid input";
        }
    }

}
