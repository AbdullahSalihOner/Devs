package kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public interface ProgrammingLanguageRepository {
	
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage getById(int id);
	
	void add(ProgrammingLanguage programmingLanguage);
	
	void deleteById(int id);
	void updateById(int id,String name);
	
	
	
	
	
	
}
