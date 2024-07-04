package mate.academy.webintro.service.skill;

import mate.academy.webintro.dto.skill.CreateSkillDto;
import mate.academy.webintro.dto.skill.SkillDto;

import java.util.List;

public interface SkillService {
    List<SkillDto> findAll();

    SkillDto save(CreateSkillDto requestDto);
}
