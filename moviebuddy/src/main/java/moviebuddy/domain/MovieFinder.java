package moviebuddy.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MovieFinder {

    // 객체 생성시점에 받을수있도록 final
    private final MovieReader movieReader;

    //@Autowired // 생성자가 하나뿐이라면 생략가능함
    //public MovieFinder(@Qualifier("jaxbMovieReader") MovieReader movieReader){
    public MovieFinder(MovieReader movieReader){
        this.movieReader = Objects.requireNonNull(movieReader);
    }
    
    /**
     * 저장된 영화 목록에서 감독으로 영화를 검색한다.
     *
     *
     * @param directedBy 감독
     * @return 검색된 영화 목록
     */
    public List<Movie> directedBy(String directedBy) {
        return movieReader.loadMovies().stream()
                .filter(it -> it.getDirector().toLowerCase().contains(directedBy.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * 저장된 영화 목록에서 개봉년도로 영화를 검색한다.
     *
     * @param releasedYearBy
     * @return 검색된 영화 목록
     */
    public List<Movie> releasedYearBy(int releasedYearBy) {
        return movieReader.loadMovies().stream()
                .filter(it -> Objects.equals(it.getReleaseYear(), releasedYearBy))
                .collect(Collectors.toList());
    }





}