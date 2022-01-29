package day02;

import java.util.ArrayList;
import java.util.List;

public class MovieService {
    private List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie){
        movies.add(movie);
    }

    public List<Movie> findMoviesWithActor(String actor){
        return movies.stream()
                .filter(movie -> movie.getActors().contains(actor))
                .toList();
    }

    public double findLongestMovie(){
        return movies.stream()
                .mapToDouble(Movie::getLength)
                .max()
                .orElseThrow(()-> new IllegalStateException("Empty list"));
    }
}
