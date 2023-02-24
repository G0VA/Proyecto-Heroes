package com.santiago.heroes.controller;

import com.santiago.heroes.model.addheroe.AddHeroe_IN;
import com.santiago.heroes.model.deleteheroe.DeleteHeroe_IN;
import com.santiago.heroes.model.findheroe.FindHeroe_IN;
import com.santiago.heroes.model.listheroes.ListHeroes_IN;
import com.santiago.heroes.model.listheroes.ListHeroes_OUT;
import com.santiago.heroes.model.modifyheroe.ModifyHeroe_IN;
import com.santiago.heroes.service.HeroesService;
import com.santiago.heroes.model.findheroe.FindHeroe_OUT;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "heroes", produces = MediaType.APPLICATION_JSON_VALUE)
public class HeroesController {

    @Autowired
    private HeroesService heroesService;

    @Operation(summary = "Inserta un Heroe")
    @PostMapping(value = "/addHeroe")
    public ResponseEntity<Void> addHeroe(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Nombre y grupo del Heroe a insertar")
            @RequestBody AddHeroe_IN in) {
        heroesService.addHeroe(in);
        return new ResponseEntity<Void>( HttpStatus.OK );
    }

    @Operation(summary = "Elimina un Heroe")
    @DeleteMapping(value = "/deleteHeroe")
    public ResponseEntity<Void> deleteHeroe(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "ID del Heroe a eliminar")
            @RequestBody DeleteHeroe_IN in) {

        heroesService.deleteHeroe(in);
        return new ResponseEntity<Void>( HttpStatus.OK );
    }

    @Operation(summary = "Busca un Heroe")
    @GetMapping(value = "/findHeroe")
    public ResponseEntity<FindHeroe_OUT> findHeroe(
            @Parameter(description = "ID del Heroe a buscar")
            @RequestBody FindHeroe_IN in) {

        FindHeroe_OUT out = heroesService.findHeroe(in);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(out);
    }

    @Operation(summary = "Busca Heroes. Si se le pasa texto busca heroes con dicho texto")
    @GetMapping(value = "/listHeroes")
    public ResponseEntity<ListHeroes_OUT> listHeroes(@Parameter(description = "Texto a buscar en el nombre de los heroes")
            @RequestBody ListHeroes_IN in) {
        ListHeroes_OUT out = heroesService.listHeroes(in);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(out);
    }

    @Operation(summary = "Modifica un Heroe")
    @PutMapping(value = "/modifyHeroe")
    public ResponseEntity<Void> modifyHeroe(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos del Heroe a modificar")
            @RequestBody ModifyHeroe_IN in) {

        heroesService.modifyHeroe(in);
        return new ResponseEntity<Void>( HttpStatus.OK );
    }
}
