package ru.mikron.address_book.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.mikron.address_book.entity.FullTextIndex;
import ru.mikron.address_book.dto.FullTextResult;

@Mapper(componentModel = "spring")
public interface FullTextMapper {
    @Mapping(target="objectTypePresentation", expression = "java(DataType.getPresentation(source.getDataType()))")
    @Mapping(target="dataType", source="source.dataType")
    FullTextResult FullTextIndexToResult(FullTextIndex source);
}
