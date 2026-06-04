package com.example.demo.service;

import com.example.demo.model.Event;
import com.example.demo.repository.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

    @Component
    public class DataLoader implements CommandLineRunner {

        private final EventRepository eventRepository;

        public DataLoader(EventRepository eventRepository) {
            this.eventRepository = eventRepository;
        }

        @Override
        public void run(String... args) {

            if(eventRepository.count() == 0) {

                Event e1 = new Event();
                e1.setTitle("Community Food Drive");
                e1.setOrganization("Hope NGO");
                e1.setDescription("Collecting food donations for families in need.");
                e1.setEmailContactPerson("fooddrive@hopengo.org");
                e1.setTime(LocalDateTime.of(2026,7,10,10,0));

                Event e2 = new Event();
                e2.setTitle("Youth Coding Workshop");
                e2.setOrganization("Tech4All");
                e2.setDescription("Programming workshop for teenagers.");
                e2.setEmailContactPerson("coding@tech4all.org");
                e2.setTime(LocalDateTime.of(2026,7,15,14,0));

                Event e3 = new Event();
                e3.setTitle("Community Clean-Up Day");
                e3.setOrganization("Green Future");
                e3.setDescription("Cleaning parks and public spaces.");
                e3.setEmailContactPerson("cleanup@greenfuture.org");
                e3.setTime(LocalDateTime.of(2026,7,20,9,0));

                Event e4 = new Event();
                e4.setTitle("Senior Support Gathering");
                e4.setOrganization("Hope NGO");
                e4.setDescription("Assistance and social activities for seniors.");
                e4.setEmailContactPerson("seniors@hopengo.org");
                e4.setTime(LocalDateTime.of(2026,7,25,11,0));

                eventRepository.save(e1);
                eventRepository.save(e2);
                eventRepository.save(e3);
                eventRepository.save(e4);
            }
        }
    }
