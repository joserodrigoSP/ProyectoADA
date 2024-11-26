package com.example.biblioteca.controller;

import com.example.biblioteca.dto.DevolucionRequest;
import com.example.biblioteca.dto.PrestamoRequest;
import com.example.biblioteca.dto.UserDto;
import com.example.biblioteca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> findAll(){
        return this.userService.findAll();
    }

    @GetMapping("{id}")
    public UserDto findById(@RequestBody Long id){
        return userService.findById(id);
    }

    @PostMapping
    public  UserDto save(@RequestBody  UserDto user){
        return this.userService.save(user);
    }


    @PutMapping("/{id}")
    public UserDto update(@PathVariable Long id, @RequestBody UserDto userDto){

        return this.userService.update(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.userService.delete(id);
    }

    @PostMapping("/prestar")
    public void prestarLibro(@RequestBody PrestamoRequest request) {
        userService.prestarlibro(request.getIdLibro(), request.getIdUsuario());
    }

    @PostMapping("/devolver")
    public void devolverLibro(@RequestBody DevolucionRequest request) {
        userService.devolverLibro(request.getIdPrestamo(), request.getIdLibro(), request.getIdUsuario());
    }
}
