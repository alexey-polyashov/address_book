package ru.mikron.address_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mikron.address_book.entity.FullTextIndex;
import ru.mikron.address_book.utility.DataType;

import java.util.List;

public interface FullTextRepo  extends JpaRepository<FullTextIndex, Long> {
    List<FullTextIndex> findFullTextIndexByTextContaining(String text);

    List<FullTextIndex> findFullTextIndexByTextContainingAndDataType(String text, DataType dataType);
}
