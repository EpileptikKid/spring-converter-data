package springconverterdata;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import org.json.simple.parser.ParseException;
import org.springframework.web.multipart.MultipartFile;
import springconverterdata.model.Exemplar;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
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

        System.out.println(text);
        Object obj = new JSONParser().parse(text);
        JSONArray jsonArray = (JSONArray) obj;
        Iterator iterator = jsonArray.iterator();
        List<Exemplar> exemplarList = new ArrayList<>();
        while (iterator.hasNext()) {
            JSONObject jsonObject = (JSONObject) iterator.next();
            long id = (long) jsonObject.get("id");
            String title = (String) jsonObject.get("title");
            String description = (String) jsonObject.get("description");
            long q = (long) jsonObject.get("published");
            boolean published = q > 0;

            Exemplar exemplar = new Exemplar(id, title, description, published);

            exemplarList.add(exemplar);
        }
        return exemplarList;
    }
}
