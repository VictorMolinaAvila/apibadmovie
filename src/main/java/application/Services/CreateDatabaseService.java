package application.Services;

import application.Entities.MovieEntity;
import application.Entities.ProducerEntity;
import application.Entities.StudioEntity;
import application.Repositories.MovieRepository;
import application.Repositories.ProducerRepository;
import application.Repositories.StudioRepository;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CreateDatabaseService {

    private static final String FILE_NAME = "C:\\Users\\victor\\Desktop\\APIbadMovie\\tmp\\movielist.csv";

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ProducerRepository producerRepository;
    @Autowired
    private StudioRepository studioRepository;

    public void create() {
        try {
            CSVReader reader = new CSVReader(new FileReader(FILE_NAME), ';');

            //skip first line
            String[] record = reader.readNext();

            while ((record = reader.readNext()) != null) {

                if (!studioExists(record[2])) {
                    StudioEntity studio = new StudioEntity();
                    studio.setName(record[2]);
                    studioRepository.save(studio);
                }

                if (!producerExists(record[3])) {
                    ProducerEntity producer = new ProducerEntity();
                    producer.setName(record[3]);
                    producerRepository.save(producer);
                }

                StudioEntity studio = studioRepository.findByName(record[2]);
                ProducerEntity producer = producerRepository.findByName(record[3]);
                MovieEntity movie = new MovieEntity();
                movie.setYear(record[0]);
                movie.setTitle(record[1]);
                movie.setWinner(record[4]);
                List<StudioEntity> movieStudios = new ArrayList();
                movieStudios.add(studio);
                movie.setStudios(movieStudios);

                List<ProducerEntity> movieProducers = new ArrayList();
                movieProducers.add(producer);
                movie.setProducers(movieProducers);

                movieRepository.save(movie);
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean studioExists(String name) {
        StudioEntity studioEntity = studioRepository.findByName(name);
        return studioEntity != null;
    }

    public Boolean producerExists(String name) {
        ProducerEntity producerEntity = producerRepository.findByName(name);
        return producerEntity != null;
    }
}
