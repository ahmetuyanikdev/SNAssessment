package com.project.service.impl;

import com.project.model.Subscriber;
import com.project.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriberService {

    @Autowired
    SubscriberRepository subscriberRepository;

    public Subscriber create(Subscriber subscriber) {
        subscriberRepository.save(subscriber);
        return subscriber;
    }

    public Subscriber update(Subscriber subscriber) {
        subscriberRepository.save(subscriber);
        return subscriber;
    }


    public Subscriber read(String email) {
        Subscriber subscriber = subscriberRepository.findByEmail(email);
        return subscriber;
    }

    public void delete() {
        subscriberRepository.deleteAll();
    }
}
