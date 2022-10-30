package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage getById(int id);
	
	void add(ProgrammingLanguage programmingLanguage) ;
	
	
	void deleteById(int id);
	void updateById(int id,String name);
}
