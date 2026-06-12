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

                Event e5 = new Event();
                e5.setTitle("Charity Fundraiser");
                e5.setOrganization("Hope NGO");
                e5.setDescription("Fundraising event for local community projects.");
                e5.setEmailContactPerson("fundraising@hopengo.org");
                e5.setTime(LocalDateTime.of(2026, 8, 10, 14, 0));

                Event e6 = new Event();
                e6.setTitle("Tree Plantation Drive");
                e6.setOrganization("Green Earth");
                e6.setDescription("Planting trees to promote sustainability.");
                e6.setEmailContactPerson("trees@greenearth.org");
                e6.setTime(LocalDateTime.of(2026, 8, 15, 9, 0));

                Event e7 = new Event();
                e7.setTitle("Blood Donation Camp");
                e7.setOrganization("Red Care");
                e7.setDescription("Community blood donation event.");
                e7.setEmailContactPerson("blood@redcare.org");
                e7.setTime(LocalDateTime.of(2026, 8, 20, 10, 0));

                Event e8 = new Event();
                e8.setTitle("Women's Empowerment Workshop");
                e8.setOrganization("Empower Together");
                e8.setDescription("Skills and leadership training.");
                e8.setEmailContactPerson("women@empower.org");
                e8.setTime(LocalDateTime.of(2026, 8, 25, 13, 0));

                Event e9 = new Event();
                e9.setTitle("Youth Leadership Camp");
                e9.setOrganization("Future Leaders");
                e9.setDescription("Leadership activities for young people.");
                e9.setEmailContactPerson("youth@futureleaders.org");
                e9.setTime(LocalDateTime.of(2026, 9, 1, 11, 0));

                Event e10 = new Event();
                e10.setTitle("Community Health Check");
                e10.setOrganization("Health First");
                e10.setDescription("Free health screenings for residents.");
                e10.setEmailContactPerson("health@healthfirst.org");
                e10.setTime(LocalDateTime.of(2026, 9, 5, 10, 0));

                eventRepository.save(e1);
                eventRepository.save(e2);
                eventRepository.save(e3);
                eventRepository.save(e4);
                eventRepository.save(e5);
                eventRepository.save(e6);
                eventRepository.save(e7);
                eventRepository.save(e8);
                eventRepository.save(e9);
                eventRepository.save(e10);
            }
        }
    }
