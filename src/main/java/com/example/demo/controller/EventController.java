package com.example.demo.controller;

import com.example.demo.model.Event;
import com.example.demo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("events",
                eventRepository.findTop10ByOrderByTimeDesc());

        return "index";
    }

    @GetMapping("/new")
    public String newEventForm(Model model) {

        model.addAttribute("event", new Event());

        return "new-event";
    }

    @PostMapping("/new")
    public String saveEvent(@ModelAttribute Event event) {

        eventRepository.save(event);

        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {

        Event event = eventRepository.findById(id).orElseThrow();

        model.addAttribute("event", event);

        return "details";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
}