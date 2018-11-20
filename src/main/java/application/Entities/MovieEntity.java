package application.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movie")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String year;
    private String title;
    private String winner;

    @ManyToMany
    private List<StudioEntity> studios;

    @ManyToMany
    private List<ProducerEntity> producers;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public List<StudioEntity> getStudios() {
        return studios;
    }

    public void setStudios(List<StudioEntity> studios) {
        this.studios = studios;
    }

    public List<ProducerEntity> getProducers() {
        return producers;
    }

    public void setProducers(List<ProducerEntity> producers) {
        this.producers = producers;
    }
}
