package application.APIs;

import application.Entities.MovieEntity;
import application.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/movie")
public class MovieApi {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public @ResponseBody
    String createData() {
        movieService.createData();
        return "ok";
    }

    @GetMapping
    public @ResponseBody
    List<MovieEntity> getMoviesWinner() {
        return movieService.getMoviesWinner();
    }
}
