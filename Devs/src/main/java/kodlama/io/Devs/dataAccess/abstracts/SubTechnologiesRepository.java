package kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.Devs.entities.concretes.SubTechnologies;

@Repository
public interface SubTechnologiesRepository extends JpaRepository<SubTechnologies, Integer> {

}
