package com.example.paginationdemo.mapper;

import com.example.paginationdemo.model.PageDTO;
import com.example.paginationdemo.model.TweetsDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PageToPageDTOMapper<T> {

    public PageDTO<T> pageToPageDTO(List<TweetsDto> page) {
        PageDTO<T> pageDTO = new PageDTO<>();
        pageDTO.setContent((List<T>) page);
        pageDTO.setTotalElements(page.stream().count());
        return pageDTO;
    }
}