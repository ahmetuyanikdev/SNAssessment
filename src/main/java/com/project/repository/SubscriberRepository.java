package com.project.repository;

import com.project.model.Subscriber;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubscriberRepository extends MongoRepository<Subscriber,String> {
    Subscriber findByEmail(String email);
}
