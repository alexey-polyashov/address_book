package ru.mikron.address_book.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mikron.address_book.entity.FullTextIndex;
import ru.mikron.address_book.dto.FullTextResult;
import ru.mikron.address_book.mapper.FullTextMapper;
import ru.mikron.address_book.repository.FullTextRepo;
import ru.mikron.address_book.utility.DataType;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FullTextService {

    private final FullTextRepo fullTextRepo;
    private final FullTextMapper ftMapper;

    public List<FullTextResult> findAllObjects(String text){
        List<FullTextIndex> fullTextIndexList = fullTextRepo.findFullTextIndexByTextContaining(text);
        return fullTextIndexList.stream()
                .map(ftMapper::FullTextIndexToResult)
                .collect(Collectors.toList());
    }

    public List<FullTextResult> findAllObjects(String text, DataType dataType){
        List<FullTextIndex> fullTextIndexList = fullTextRepo.findFullTextIndexByTextContainingAndDataType(text, dataType);
        return fullTextIndexList.stream()
                .map(ftMapper::FullTextIndexToResult)
                .collect(Collectors.toList());
    }
}
