package mate.academy.spring.mapper.impl.request;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.request.MovieRequestDto;
import org.springframework.stereotype.Component;

@Component
public class MovieRequestMapper implements DtoRequestMapper<MovieRequestDto, Movie> {
    @Override
    public Movie fromDto(MovieRequestDto dto) {
        Movie movie = new Movie();
        movie.setTitle(dto.getTitle());
        movie.setDescription(dto.getDescription());
        return movie;
    }
}
