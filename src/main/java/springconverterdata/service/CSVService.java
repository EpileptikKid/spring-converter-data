package springconverterdata;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import springconverterdata.model.Exemplar;
import springconverterdata.repository.CSVHelper;
import springconverterdata.repository.ExemplarRepository;
import springconverterdata.repository.JsonHelper;

@Service
public class CSVService {
    @Autowired
    ExemplarRepository repository;

    public void save(MultipartFile file) {
        try {
            List<Exemplar> tutorials = JsonHelper.jsonToTutorials(file);
            System.out.println("1");
            repository.saveAll(tutorials);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public ByteArrayInputStream load() {
        List<Exemplar> tutorials = repository.findAll();

        ByteArrayInputStream in = CSVHelper.tutorialsToCSV(tutorials);
        return in;
    }

    public List<Exemplar> getAllTutorials() {
        return repository.findAll();
    }
}
