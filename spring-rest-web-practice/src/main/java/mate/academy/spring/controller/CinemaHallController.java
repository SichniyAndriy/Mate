package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.request.CinemaHallRequestDto;
import mate.academy.spring.model.dto.response.CinemaHallResponseDto;
import mate.academy.spring.service.CinemaHallService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final DtoRequestMapper<CinemaHallRequestDto, CinemaHall> cinemaHallDtoRequestMapper;
    private final DtoResponseMapper<CinemaHallResponseDto, CinemaHall> cinemaHallDtoResponseMapper;

    public CinemaHallController(CinemaHallService cinemaHallService,
                                DtoRequestMapper<CinemaHallRequestDto, CinemaHall>
                                        cinemaHallDtoRequestMapper,
                                DtoResponseMapper<CinemaHallResponseDto, CinemaHall>
                                        cinemaHallDtoResponseMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallDtoRequestMapper = cinemaHallDtoRequestMapper;
        this.cinemaHallDtoResponseMapper = cinemaHallDtoResponseMapper;
    }

    @PostMapping
    public CinemaHallResponseDto add(@RequestBody CinemaHallRequestDto dto) {
        CinemaHall cinemaHall = cinemaHallService.add(cinemaHallDtoRequestMapper.fromDto(dto));
        return cinemaHallDtoResponseMapper.toDto(cinemaHall);
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
