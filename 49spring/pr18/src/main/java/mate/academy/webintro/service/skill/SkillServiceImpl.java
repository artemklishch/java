package mate.academy.webintro.service.skill;

import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.skill.CreateSkillDto;
import mate.academy.webintro.dto.skill.SkillDto;
import mate.academy.webintro.mapper.SkillMapper;
import mate.academy.webintro.repository.skill.SkillRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SkillServiceImpl implements SkillService {
    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;

    @Override
    public List<SkillDto> findAll() {
        return skillRepository.findAll().stream()
                .map(skillMapper::toDto)
                .toList();
    }

    @Override
    public SkillDto save(CreateSkillDto requestDto) {
        return skillMapper.toDto(skillRepository.save(skillMapper.toModel(requestDto)));
    }
}
