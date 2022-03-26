package co.com.sofka.diceroller.controller;

import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import co.com.sofka.diceroller.Dto.DadoDTO;
import co.com.sofka.diceroller.Repository.DadoRepository;
import co.com.sofka.diceroller.model.Dado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/r")
public class DadoController {

    private DadoRepository dadoRepository;

    @Autowired
    public DadoController(DadoRepository dadoRepository) {
        this.dadoRepository = dadoRepository;
    }

   @PostMapping("")
    public Mono<Dado> post(@RequestBody DadoDTO request) {
        return Mono.just(new Dado()).map(entity -> {
            entity.setDate(new Date());
            entity.setInitialDataList(request.getList());
            return entity;
        }).map(entity -> {
            var list = Stream.of(request.getList().split(","))
                .map(p -> p.trim())
                    .map(p-> p =  (int) Math.floor(Math.random()*6+1)+"")
                .collect(Collectors.toList());
            Collections.shuffle(list);
            var randomList = list.stream().collect(Collectors.joining(","));
            entity.setresultThrowlist(randomList);
            return entity;
        }).flatMap(dadoRepository::save);
    }

    @GetMapping("")
    public Flux<Dado> get() {
        return dadoRepository.findAll();
    }
}
