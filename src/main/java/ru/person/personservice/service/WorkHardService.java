package ru.person.personservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class WorkHardService {
    public static boolean gaming = false;

    public void getBoxGetFood() {
        CompletableFuture<Void> boxFuture = CompletableFuture.runAsync(() -> {
            log.info("Экрем начал разгружать коробки");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("Экрем закончил разгружать коробки");
        });

        CompletableFuture<Void> foodFuture = CompletableFuture.runAsync(() -> {
            log.info("Даня начал кушать");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("Даня закончил кушать");
        });

        CompletableFuture<Void> allWorkStop = CompletableFuture.allOf(foodFuture, boxFuture);
        allWorkStop.thenRun(() -> log.info("Даня и Экрем закончили процессы"));
    }

    public void getGameAndMotherCame(){
        game();
        came();
    }

    @Async
    public void game(){
        log.info("Ждем пока мама уйдет");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Начинается игра");
        gaming = true;
    }

    @Async
    public void came(){
        while (!gaming){
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        log.info("Ну все сына, игры окончены");
    }
}
