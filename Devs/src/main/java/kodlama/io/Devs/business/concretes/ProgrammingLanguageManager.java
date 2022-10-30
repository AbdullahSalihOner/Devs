package kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{
	
	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		super();
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		
		return programmingLanguageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return programmingLanguageRepository.getById(id);
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		if (isLanguageExists(programmingLanguage)) {
			System.out.print("Language is already Exists");
		}else if (isIdExists(programmingLanguage.getId())){
			System.out.print("Language name is can not be null");
		}else if (isLanguageNull(programmingLanguage)){
			System.out.print("Language name is can not be null");
		}else {
			programmingLanguageRepository.add(programmingLanguage);
		}
	}

	
	@Override
	public void deleteById(int id) {
		programmingLanguageRepository.deleteById(id);
	}

	@Override
	public void updateById(int id, String name) {
		programmingLanguageRepository.updateById(id, name);
		
	}
	
	
	
	
	//Business Rule
	
	//DİL MEVCUTSA EKLEMİYOR AMA HATA VERMİYOR
	private boolean isLanguageExists(ProgrammingLanguage programmingLanguage) {
		for (ProgrammingLanguage programmingLanguage2 : getAll()) {
			if (programmingLanguage.getName().equals(programmingLanguage2.getName())) {
				return true;
			}
		}
		return false;
	}
	
	//ID KULLANILIYORSA EKLEMİYOR AMA HATA VERMİYOR
	private boolean isIdExists(int id) {
		for (ProgrammingLanguage programmingLanguage2 : getAll()) {
			if (programmingLanguage2.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	
	//DEFAULT OLARAK GELEN STRİNG İFADESİ VE NULL DURMUNDA HAYTA VERİYOR ANCAK HATA FIRLATMIYORR
	private boolean isLanguageNull(ProgrammingLanguage programmingLanguage) {
		if (programmingLanguage.getName().equals("") || programmingLanguage.getName().equals("string")) {
			return true;
		}
		return false;
	}
	
	

}
