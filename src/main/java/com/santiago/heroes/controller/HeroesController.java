package com.santiago.heroes.controller;

import com.santiago.heroes.model.addheroe.AddHeroe_IN;
import com.santiago.heroes.model.deleteheroe.DeleteHeroe_IN;
import com.santiago.heroes.model.findheroe.FindHeroe_IN;
import com.santiago.heroes.model.listheroes.ListHeroes_OUT;
import com.santiago.heroes.model.listheroesbyname.ListHeroesByName_IN;
import com.santiago.heroes.model.listheroesbyname.ListHeroesByName_OUT;
import com.santiago.heroes.model.modifyheroe.ModifyHeroe_IN;
import com.santiago.heroes.service.HeroesService;
import com.santiago.heroes.model.findheroe.FindHeroe_OUT;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "heroes", produces = MediaType.APPLICATION_JSON_VALUE)
public class HeroesController {

    @Autowired
    private HeroesService heroesService;

    @Operation(summary = "Inserta un Heroe")
    @PostMapping(value = "/addHeroe")
    public ResponseEntity<Void> addHeroe(@Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Nombre y grupo del Heroe a insertar")
            @RequestBody AddHeroe_IN in, BindingResult result) {
        heroesService.addHeroe(in);
        return new ResponseEntity<Void>( HttpStatus.OK );
    }

    @Operation(summary = "Elimina un Heroe")
    @PostMapping(value = "/deleteHeroe")
    public ResponseEntity<Void> deleteHeroe(@Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "NOMBRE del Heroe a eliminar")
            @RequestBody DeleteHeroe_IN in, BindingResult result) {

        heroesService.deleteHeroe(in);
        return new ResponseEntity<Void>( HttpStatus.OK );
    }

    @Operation(summary = "Busca un Heroe")
    @PostMapping(value = "/findHeroe")
    public ResponseEntity<FindHeroe_OUT> findHeroe(@Valid
            @Parameter(description = "ID del Heroe a buscar")
            @RequestBody FindHeroe_IN in, BindingResult result) {

        FindHeroe_OUT out = heroesService.findHeroe(in);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(out);
    }

    @Operation(summary = "Busca todos los Heroes")
    @PostMapping(value = "/listHeroes")
    public ResponseEntity<ListHeroes_OUT> listHeroes() {
        ListHeroes_OUT out = heroesService.listHeroes();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(out);
    }

    @Operation(summary = "Busca Heroes por patron")
    @PostMapping(value = "/listHeroesByName")
    public ResponseEntity<ListHeroesByName_OUT> listHeroesByName(@Parameter(description = "Patron a buscar en el nombre de los heroes")
            @RequestBody ListHeroesByName_IN in) {
        ListHeroesByName_OUT out = heroesService.listHeroesByName(in);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(out);
    }

    @Operation(summary = "Modifica un Heroe")
    @PostMapping(value = "/modifyHeroe")
    public ResponseEntity<Void> modifyHeroe(@Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos del Heroe a modificar")
            @RequestBody ModifyHeroe_IN in, BindingResult result) {

        heroesService.modifyHeroe(in);
        return new ResponseEntity<Void>( HttpStatus.OK );
    }
}
