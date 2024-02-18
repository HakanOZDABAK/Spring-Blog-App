package com.hakanozdabak.BlogApp.dataAccess.abstracts;

import com.hakanozdabak.BlogApp.entities.concretes.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test,Integer> {
}
