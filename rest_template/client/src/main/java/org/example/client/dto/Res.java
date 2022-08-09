package org.example.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Res {
    private int result;
    private Body resopnse;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Body{
        private String resultCode = "OK";
    }
}
