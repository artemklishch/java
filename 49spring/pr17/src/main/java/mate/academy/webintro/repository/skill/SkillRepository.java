package mate.academy.webintro.repository.skill;

import mate.academy.webintro.model.Skill;

import java.util.List;

public interface SkillRepository {
    Skill save(Skill skill);

    List<Skill> findAll();
}
