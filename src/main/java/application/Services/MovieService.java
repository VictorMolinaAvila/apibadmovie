package application.Services;

import application.Entities.MovieEntity;
import application.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private CreateDatabaseService createDatabaseService;

    public void createData() {
        createDatabaseService.create();
    }

    public List<MovieEntity> getMovies() {
        return movieRepository.findAll();
    }

    public List<MovieEntity> getMoviesWinner() {

        List<MovieEntity> movieEntities = movieRepository.getMoviesWinner();

        return movieEntities;
    }

}
