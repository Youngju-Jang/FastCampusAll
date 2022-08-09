package org.example.client.controller;

import lombok.RequiredArgsConstructor;
import org.example.client.component.Calculator;
import org.example.client.dto.Req;
import org.example.client.dto.Res;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calApi")
@RequiredArgsConstructor
public class CalculatorApiController {

    private final Calculator calculator;

/*    public CalculatorApiController(org.example.client.component.Calculator calculator) {
        Calculator = calculator;
    }*/

    @GetMapping("/sum")
    public int sum(@RequestParam int x, @RequestParam int y){
        return calculator.sum(x, y);
    }

    @PostMapping("/minus")
    public Res minus(@RequestBody Req req){
        int result = calculator.minus(req.getX(), req.getY());

        Res res = new Res();
        res.setResult(result);
        res.setResult(result);
        return res;
    }
}
