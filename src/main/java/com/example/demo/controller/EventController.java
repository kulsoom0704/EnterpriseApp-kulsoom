package com.example.demo.controller;

import com.example.demo.model.Event;
import com.example.demo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.ContactForm;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Controller
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private JavaMailSender mailSender;

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
    public String contact(Model model) {

        model.addAttribute("contactForm", new ContactForm());

        return "contact";
    }
    @PostMapping("/contact")
    public String sendContact(
            @Valid @ModelAttribute ContactForm contactForm,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("error", true);
            return "contact";
        }
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo("admin@hopengo.org");
        message.setSubject("New Contact Message");

        message.setText(
                "Name: " + contactForm.getName() + "\n" +
                        "Email: " + contactForm.getEmail() + "\n\n" +
                        contactForm.getMessage()
        );

        //mailSender.send(message);

//        System.out.println("Name: " + contactForm.getName());
//        System.out.println("Email: " + contactForm.getEmail());
//        System.out.println("Message: " + contactForm.getMessage());

        model.addAttribute("success", true);

        return "contact";
    }
}