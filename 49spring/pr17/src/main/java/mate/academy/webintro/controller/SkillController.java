package mate.academy.webintro.controller;

import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.skill.CreateSkillDto;
import mate.academy.webintro.dto.skill.SkillDto;
import mate.academy.webintro.service.skill.SkillService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/skills")
public class SkillController {
    private final SkillService skillService;

    @GetMapping
    public List<SkillDto> getAll() {
        return skillService.findAll();
    }

    @PostMapping
    public SkillDto save(@RequestBody CreateSkillDto requestDto) {
        return skillService.save(requestDto);
    }
}
