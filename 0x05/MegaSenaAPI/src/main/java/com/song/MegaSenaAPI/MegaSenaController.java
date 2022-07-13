package com.song.MegaSenaAPI;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@RestController
@RequestMapping(value="/megasena")
public class MegaSenaController {

    @GetMapping("/simpleMessageWelcome")
    public String mensagemBoasVindas() {
        return "Bem vindo a API REST para geração de números para a loteria Mega Sena.";
    }


    @GetMapping("/getNumbers")
    public List<Integer> numerosMegaSena() {
        List<Integer> numerosGerados = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            numerosGerados.add(random.nextInt(60));
        }
        Collections.sort(numerosGerados);
        return numerosGerados;
    }
}
