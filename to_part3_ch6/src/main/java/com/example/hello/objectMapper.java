package com.example.hello;

import com.example.hello.dto.Car;
import com.example.hello.dto.ch5_User4;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Arrays;
import java.util.List;

public class objectMapper {

    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("main");

        ObjectMapper objectMapper = new ObjectMapper();

        ch5_User4 user = new ch5_User4();
        user.setName("홍길동");
        user.setAge(10);

        Car car1 = new Car();
        car1.setName("K5");
        car1.setCarNumber("11가 1111");
        car1.setType("sedan");

        Car car2 = new Car();
        car2.setName("Q5");
        car2.setCarNumber("22가 2222");
        car2.setType("SUV");
        List<Car> carList = Arrays.asList(car1, car2);
        user.setCars(carList);

        //// 기존 objectMapper 사용방법 ////
        String json = objectMapper.writeValueAsString(user); // json타입으로
        System.out.println(json); // {"name":"홍길동","age":10,"cars":[{"name":"K5","~~

        //// 순수 노드접근방법 ////
        JsonNode jsonNode = objectMapper.readTree(json);
        // 0.이건 잘됨
        String _name = jsonNode.get("name").asText();
        int _age = jsonNode.get("age").asInt();
        System.out.println("name: " + _name); // name: 홍길동
        System.out.println("age: " + _age); // age: 10

        //1. 위처럼 하면 cars에서는 에러뜸
        //String _list = jsonNode.get("cars").asText(); // asList가 없어서 asText()로했음
        //System.out.println(_list); // 이렇게하면 안나옴
        
        // 방법2 << 미리 json이 어떻게생겼는지 표준spec을 알고있을때 가능
        // >> cars배열의 노드를 들고와야 하는것.
        JsonNode cars = jsonNode.get("cars");  // cars 용 JsonNode 새로부여
        ArrayNode arrayNode = (ArrayNode)cars; // ArrayNode로 강제 형변환

        // convertValue : object를 원하는 클래스로 매핑시킬때씀
        List<Car> _cars = objectMapper.convertValue(arrayNode, new TypeReference<List<Car>>() {});
        System.out.println(_cars); 
        // [Car{name='K5', carNumber='11가 1111', type='sedan'}, Car{name='Q5', carNumber='22가 2222', type='SUV'}]
        
        //// 이걸 왜쓰느냐? 안에를 바꿔줄수 있음 ////
        ObjectNode objectNode = (ObjectNode) jsonNode;  // jsonNode 이건 user노드 전체임
        objectNode.put("name", "steve");
        objectNode.put("age", 20);

        System.out.println(objectNode.toPrettyString()); // json을 이쁘게 출력하는거
        // { ~~~  "name" : "steve",   "age" : 20, ~~~ 로 바뀜







    }
}
