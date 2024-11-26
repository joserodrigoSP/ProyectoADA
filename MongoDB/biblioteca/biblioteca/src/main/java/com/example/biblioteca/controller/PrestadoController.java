package com.example.biblioteca.controller;

import com.example.biblioteca.dto.PrestadoDto;
import com.example.biblioteca.dto.UserDto;
import com.example.biblioteca.service.PrestadoService;
import com.example.biblioteca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestados")
public class PrestadoController {

    @Autowired
    private PrestadoService prestadoService;

    @GetMapping
    public List<PrestadoDto> findAll(){
        return this.prestadoService.findAll();
    }

    @GetMapping("{id}")
    public PrestadoDto findById(@RequestBody String id){
        return prestadoService.findById(id);
    }



    @PutMapping("/{id}")
    public PrestadoDto update(@PathVariable String id, @RequestBody PrestadoDto prestadoDto){

        return this.prestadoService.update(id, prestadoDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        this.prestadoService.delete(id);
    }

}
