package com.hakanozdabak.BlogApp.dataAccess.abstracts;

import com.hakanozdabak.BlogApp.entities.concretes.FileDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileDetail,Integer> {
}
