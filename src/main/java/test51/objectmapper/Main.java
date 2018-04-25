package test51.objectmapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 4/25/18
 * Time: 5:23 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {

        // 1
        ObjectMapper mapper = new ObjectMapper();
        Car car = new Car("yellow", "BMW");
        mapper.writeValue(new File("target/car.json"), car);
        System.out.println(mapper.writeValueAsString(car));

        //2
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        Car c2 = mapper.readValue(json, Car.class);
        System.out.println(c2);

        c2 = mapper.readValue(new File("target/car.json"), Car.class);
//        c2 = mapper.readValue(new URL("target/car.json"), Car.class);

        //3
        json = "{ \"color\" : \"Black\", \"type\" : \"FIAT\" }";
        JsonNode node = mapper.readTree(json);
        String carName = node.get("color").asText();

        //4
        String jsonCarArray =
                "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
        List<Car> listCar = mapper.readValue(jsonCarArray, new TypeReference<List<Car>>(){});
        System.out.println(listCar.size());

        json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        Map<String, Object> map = mapper.readValue(json, new TypeReference<Map<String,Object>>(){});
        System.out.println(map.size());

        //5
        String jsonString = "{ \"color\" : \"Black\", \"type\" : \"Fiat\", \"year\" : \"1970\" }";
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        car = mapper.readValue(jsonString, Car.class);

        JsonNode jsonNodeRoot = mapper.readTree(jsonString);
        JsonNode jsonNodeYear = jsonNodeRoot.get("year");
        String year = jsonNodeYear.asText();

        //7
        Request request = new Request(car, new Date());
        ObjectMapper objectMapper = new ObjectMapper();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
        objectMapper.setDateFormat(df);
        String carAsString = objectMapper.writeValueAsString(request);
        // output: {"car":{"color":"yellow","type":"renault"},"datePurchased":"2016-07-03 11:43 AM CEST"}

        //8
        jsonCarArray =
                "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        Car[] cars = objectMapper.readValue(jsonCarArray, Car[].class);
        // List<Car> listCar = objectMapper.readValue(jsonCarArray, new TypeReference<List<Car>>(){});

    }
}
