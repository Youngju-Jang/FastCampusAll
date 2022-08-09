package org.example.client.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Calculator {

    private final ICarcluator iCarcluator;

/*    @RequiredArgsConstructor이 대신해줌 <<
        public Calculator(ICarcluator iCarcluator){
        this.iCarcluator = iCarcluator;
    }*/

    public int sum(int x, int y){
        this.iCarcluator.init();
        return this.iCarcluator.sum(x, y);
    }

    public int minus(int x, int y){
        this.iCarcluator.init();
        return this.iCarcluator.minus(x, y);
    }

}
