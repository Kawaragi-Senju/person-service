package ru.person.personservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.person.personservice.service.WorkHardService;

@RestController("/work-processing")
@RequiredArgsConstructor
public class WorkHardController {

    public final WorkHardService workHardService;

    @GetMapping("/get-box-get-food")
    public void getBoxGetFood(){
        workHardService.getBoxGetFood();
    }

    @GetMapping("/game-mother-came")
    public void getGameAndMotherCame(){
        workHardService.getGameAndMotherCame();
    }
}
