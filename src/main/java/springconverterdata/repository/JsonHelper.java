package springconverterdata.repository;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import org.json.simple.parser.ParseException;
import org.springframework.web.multipart.MultipartFile;
import springconverterdata.config.TestProperties;
import springconverterdata.model.Exemplar;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class JsonHelper {
    public static String TYPE = "application/json";

    public static boolean hasJsonFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }

    public static List<Exemplar> jsonToTutorials(MultipartFile file) throws IOException, ParseException {
        InputStream inputStream = file.getInputStream();

        String text = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));

        Object obj = new JSONParser().parse(text);
        JSONArray jsonArray = (JSONArray) obj;
        Iterator iterator = jsonArray.iterator();
        List<Exemplar> exemplarList = new ArrayList<>();
        while (iterator.hasNext()) {
            JSONObject jsonObject = (JSONObject) iterator.next();
            long id = (long) jsonObject.get("id");
            List<String> parameters = new ArrayList<>();
            Exemplar exemplar = new Exemplar(id, (String) jsonObject.get(TestProperties.param2), (String) jsonObject.get(TestProperties.param3),
                    (String) jsonObject.get(TestProperties.param4), (String) jsonObject.get(TestProperties.param5), (String) jsonObject.get(TestProperties.param6),
                    (String) jsonObject.get(TestProperties.param7), (String) jsonObject.get(TestProperties.param8), (String) jsonObject.get(TestProperties.param9),
                    (String) jsonObject.get(TestProperties.param10), (String) jsonObject.get(TestProperties.param11), (String) jsonObject.get(TestProperties.param12),
                    (String) jsonObject.get(TestProperties.param13), (String) jsonObject.get(TestProperties.param14), (String) jsonObject.get(TestProperties.param15),
                    (String) jsonObject.get(TestProperties.param16), (String) jsonObject.get(TestProperties.param17), (String) jsonObject.get(TestProperties.param18),
                    (String) jsonObject.get(TestProperties.param19), (String) jsonObject.get(TestProperties.param20), (String) jsonObject.get(TestProperties.param21),
                    (String) jsonObject.get(TestProperties.param22), (String) jsonObject.get(TestProperties.param23), (String) jsonObject.get(TestProperties.param24),
                    (String) jsonObject.get(TestProperties.param25), (String) jsonObject.get(TestProperties.param26), (String) jsonObject.get(TestProperties.param27),
                    (String) jsonObject.get(TestProperties.param28), (String) jsonObject.get(TestProperties.param29), (String) jsonObject.get(TestProperties.param30));

            exemplarList.add(exemplar);
        }
        return exemplarList;
    }
}
