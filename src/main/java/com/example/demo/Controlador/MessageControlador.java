/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controlador;

import com.example.demo.Modelo.Message;
import com.example.demo.Servicio.MessageServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author USUARIO
 */

@RestController
@RequestMapping("/api/Message")

public class MessageControlador {
         @Autowired
    private MessageServicio messageService;
    @CrossOrigin(origins = "http://127.0.0.1:60283")
    @GetMapping("/all")
    public List<Message> getMessages(){
        return messageService.getAll();
    }
    @CrossOrigin(origins = "http://127.0.0.1:60283")
    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int messageId) {
        return messageService.getMessage(messageId);
    }
    @CrossOrigin(origins = "http://127.0.0.1:60283")
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message) {
        return messageService.save(message);
    }
}
