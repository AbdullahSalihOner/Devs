package kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {

	List<ProgrammingLanguage> programmingLanguages;
	
	public InMemoryProgrammingLanguageRepository() {
		programmingLanguages = new ArrayList<ProgrammingLanguage>();
		programmingLanguages.add(new ProgrammingLanguage(1,"PHP"));
		programmingLanguages.add(new ProgrammingLanguage(2,"Java"));
		programmingLanguages.add(new ProgrammingLanguage(3,"C#"));
	
	}
	
	@Override
	public List<ProgrammingLanguage> getAll() {
				
		return programmingLanguages;
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return programmingLanguages.get(id-1);
	}

	@Override
	public void  add(ProgrammingLanguage programmingLanguage) {
		programmingLanguages.add(programmingLanguage);
	}
	@Override
	public void deleteById(int id) {
		programmingLanguages.remove(id-1);
	}

	@Override
	public void updateById(int id, String name) {
		programmingLanguages.get(id-1).setName(name);
		
	}

	

	

	

}
