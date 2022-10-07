package org.example.계산기.calculate.tobe;

import org.example.계산기.calculate.domain.PositiveNumber;

public interface ArithmeticOperator {
    boolean supports(String operator);
    int calculate(PositiveNumber operand1, PositiveNumber operand2);
}
