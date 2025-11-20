package mate.academy.spring.mapper;

public interface DtoResponseMapper<D, C> {
    D toDto(C object);
}
