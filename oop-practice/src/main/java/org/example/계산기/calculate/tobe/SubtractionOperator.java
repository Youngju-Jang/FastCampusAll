package org.example.계산기.calculate.tobe;

import org.example.계산기.calculate.domain.PositiveNumber;
import org.example.계산기.calculate.tobe.ArithmeticOperator;

public class SubtractionOperator implements ArithmeticOperator {

    @Override
    public boolean supports(String operator) {
        return "-".equals(operator);
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
        return operand1 .toInt()- operand2.toInt();
    }
}
