package com.example.biblioteca.controller;
import com.example.biblioteca.dto.LibroDto;
import com.example.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<LibroDto> findAll(){
        return this.libroService.findAll();
    }

    @GetMapping("{id}")
    public LibroDto findById(@RequestBody String id){
        return libroService.findById(id);
    }

    @PostMapping
    public  LibroDto save(@RequestBody  LibroDto prestadoDto){
        return this.libroService.save(prestadoDto);
    }

    @PutMapping("/{id}")
    public LibroDto update(@PathVariable String id, @RequestBody LibroDto prestadoDto){

        return this.libroService.update(id, prestadoDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        this.libroService.delete(id);
    }


}
