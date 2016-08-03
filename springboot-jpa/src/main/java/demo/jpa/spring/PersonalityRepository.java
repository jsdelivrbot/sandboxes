package demo.jpa.spring;

import demo.entity.Personality;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface PersonalityRepository extends PagingAndSortingRepository<Personality, Integer> {
}
