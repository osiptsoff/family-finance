package ru.spb.osiptsoff.finance.crud.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import ru.spb.osiptsoff.finance.crud.dto.DtoConverter;
import ru.spb.osiptsoff.finance.crud.model.Identifiable;
import ru.spb.osiptsoff.finance.lib.dto.Dto;
import ru.spb.osiptsoff.finance.lib.dto.PageRequestDto;
import ru.spb.osiptsoff.finance.lib.dto.PageResponseDto;
import ru.spb.osiptsoff.finance.lib.exception.CrudException;
import ru.spb.osiptsoff.finance.lib.exception.message.CommonMessagesProvider;

/**
 * @param <T> класс Id
 * @param <U> класс Dto
 * @param <V> класс модели
 */
@RequiredArgsConstructor
@Transactional
@Service
public abstract class MongoCrudService<U extends Dto, V extends Identifiable<UUID>> implements CrudService<UUID, U> {
    private final CommonMessagesProvider commonMessagesProvider = new CommonMessagesProvider();
    private final MongoRepository<V, UUID> repository;
    private final DtoConverter<UUID, U, V> dtoConversionFactory;

    @Override 
    public U create(U dto) {
        V object = dtoConversionFactory.convertFromDto(dto);

        if (isObjectExists(object)) {
            throw new CrudException(commonMessagesProvider.getObjectExistsMessage());
        }

        return dtoConversionFactory.convertToDto(repository.insert(object));
    }

    @Override 
    public PageResponseDto<U> findAll(PageRequestDto pageRequestDto) {
        Page<V> page = repository.findAll(PageRequest.of(
            pageRequestDto.getPageNumber(),
            pageRequestDto.getPageSize()));

        PageResponseDto<U> pageResponseDto = new PageResponseDto<>();
        pageResponseDto.setPages(page.getTotalPages());
        pageResponseDto.setSize(page.getNumberOfElements());
        pageResponseDto.setContent(page.getContent().stream()
            .map(dtoConversionFactory::convertToDto)
            .toList());

        return pageResponseDto;
    }

    @Override 
    public U readById(UUID id) {
        V object = repository.findById(id).orElseThrow(
            () -> new CrudException(commonMessagesProvider.getObjectDoesNotExistMessage())
        );

        return dtoConversionFactory.convertToDto(object);
    }

    @Override
    public U update(U dto) {
        V object = dtoConversionFactory.convertFromDto(dto);

        if (!isObjectExists(object)) {
            throw new CrudException(commonMessagesProvider.getObjectDoesNotExistMessage());
        }

        return dtoConversionFactory.convertToDto(repository.save(object));
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    private boolean isObjectExists(V object) {
        return object.getId() != null && repository.existsById(object.getId());
    }
}
