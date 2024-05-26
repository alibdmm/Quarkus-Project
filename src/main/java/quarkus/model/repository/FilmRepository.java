package quarkus.model.repository;


import com.speedment.jpastreamer.application.JPAStreamer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import quarkus.model.Film;
import quarkus.model.Film$;

import java.util.Optional;
import java.util.stream.Stream;

@ApplicationScoped
public class FilmRepository {

    @Inject
    JPAStreamer jpaStreamer;

    private static  final int PAGE_SIZE = 20;

    public Optional<Film> getFilm(short filmId){
        return jpaStreamer.stream(Film.class).filter(Film$.filmId.equal(filmId)).findFirst();
    }

    public Stream<Film> paged(long page, short minLength){
        return jpaStreamer.stream(Film.class)
                .filter(Film$.length.greaterThan(minLength))
                .sorted(Film$.length)
                .skip(page * PAGE_SIZE)
                .limit(PAGE_SIZE);
    }

}
