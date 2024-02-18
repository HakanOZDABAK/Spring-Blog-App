package com.hakanozdabak.BlogApp.business.concretes;

import com.hakanozdabak.BlogApp.business.abstracts.TestService;
import com.hakanozdabak.BlogApp.dataAccess.abstracts.TestRepository;
import com.hakanozdabak.BlogApp.entities.concretes.Test;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class TestManager implements TestService {

    @Autowired
    private TestRepository testRepository;
    @Override
    public void add(Test test) {
        this.testRepository.save(test);

    }
}
