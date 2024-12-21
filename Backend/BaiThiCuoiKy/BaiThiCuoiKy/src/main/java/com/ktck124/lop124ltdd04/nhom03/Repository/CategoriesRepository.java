package com.ktck124.lop124ltdd04.nhom03.Repository;

import com.ktck124.lop124ltdd04.nhom03.Models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {

}
