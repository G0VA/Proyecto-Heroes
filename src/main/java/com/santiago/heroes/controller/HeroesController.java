package com.santiago.heroes.controller;

import com.santiago.heroes.model.addheroe.AddHeroe_IN;
import com.santiago.heroes.model.deleteheroe.DeleteHeroe_IN;
import com.santiago.heroes.model.findheroe.FindHeroe_IN;
import com.santiago.heroes.model.listheroes.ListHeroes_IN;
import com.santiago.heroes.model.listheroes.ListHeroes_OUT;
import com.santiago.heroes.model.modifyheroe.ModifyHeroe_IN;
import com.santiago.heroes.service.HeroesService;
import com.santiago.heroes.model.findheroe.FindHeroe_OUT;
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

    @PostMapping(value = "/addHeroe")
    public ResponseEntity<Void> addHeroe(@RequestBody AddHeroe_IN in) {
        heroesService.addHeroe(in);
        return new ResponseEntity<Void>( HttpStatus.OK );
    }

    @PostMapping(value = "/deleteHeroe")
    public ResponseEntity<Void> deleteHeroe(@RequestBody DeleteHeroe_IN in) {
        heroesService.deleteHeroe(in);
        return new ResponseEntity<Void>( HttpStatus.OK );
    }

    @PostMapping(value = "/findHeroe")
    public ResponseEntity<FindHeroe_OUT> findHeroe(@RequestBody FindHeroe_IN in) {
        FindHeroe_OUT out = heroesService.findHeroe(in);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(out);
    }

    @PostMapping(value = "/listHeroes")
    public ResponseEntity<ListHeroes_OUT> listHeroes(@RequestBody ListHeroes_IN in) {
        ListHeroes_OUT out = heroesService.listHeroes(in);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(out);
    }

    @PostMapping(value = "/modifyHeroe")
    public ResponseEntity<Void> modifyHeroe(@RequestBody ModifyHeroe_IN in) {
        heroesService.modifyHeroe(in);
        return new ResponseEntity<Void>( HttpStatus.OK );
    }
}
