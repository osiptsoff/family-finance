package ru.spb.osiptsoff.finance.crud.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import ru.spb.osiptsoff.finance.crud.service.CrudService;
import ru.spb.osiptsoff.finance.lib.dto.Dto;
import ru.spb.osiptsoff.finance.lib.dto.PageRequestDto;
import ru.spb.osiptsoff.finance.lib.dto.PageResponseDto;

@RequiredArgsConstructor 
public abstract class CrudController<T extends Dto> {
    private final CrudService<UUID, T> service;

    @PostMapping("")
    public T create(@RequestBody T dto) {
        return service.create(dto);
    }

    @GetMapping(("/{id}"))
    public T find(@PathVariable ("id") UUID id) {
        return service.readById(id);
    }

    @GetMapping("")
    public PageResponseDto<T> find(@RequestParam("pageNumber") Optional<Integer> pageNumber,
            @RequestParam("pageSize") Optional<Integer> pageSize) {
        PageRequestDto pageRequestDto = new PageRequestDto(
                pageNumber.orElse(1),
                pageSize.orElse(10));
        return service.findAll(pageRequestDto);
    }

    @PutMapping("")
    public T update(@RequestBody T dto) {
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID uuid) {
        service.deleteById(uuid);
    }
}
