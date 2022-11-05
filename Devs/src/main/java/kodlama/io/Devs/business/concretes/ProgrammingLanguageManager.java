package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.business.requests.CreateProgrammingLanguagesRequest;
import kodlama.io.Devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;
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
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		
		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
		List<GetAllProgrammingLanguagesResponse> programmingLanguagesResponse = new ArrayList<GetAllProgrammingLanguagesResponse>();
		
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			GetAllProgrammingLanguagesResponse responseItem = new GetAllProgrammingLanguagesResponse();
			responseItem.setId(programmingLanguage.getId());
			responseItem.setName(programmingLanguage.getName());
			
			programmingLanguagesResponse.add(responseItem);
			}
		//BUSİNESS RULE
		return programmingLanguagesResponse;
	}

	
	@Override
	public void getById(int id) {
		programmingLanguageRepository.findById(id);
		
	}

	//TAMAMLANDI
	@Override
	public void add(CreateProgrammingLanguagesRequest createProgrammingLanguagesRequest) {
		
		
				ProgrammingLanguage programmingLanguageNew = new ProgrammingLanguage();
				programmingLanguageNew.setName(createProgrammingLanguagesRequest.getName());
			
				if(isLanguageExists(createProgrammingLanguagesRequest) ) 
				{
					 System.out.println("Language is already Exists");
				}
				else if(isLanguageNull(createProgrammingLanguagesRequest) ) {
					 System.out.println("Language name is can not be null");
				}
				else {
					this.programmingLanguageRepository.save(programmingLanguageNew);
				}
			
		
	}
	  //****TAMAMLANDI******
	@Override
	public void update(UpdateProgrammingLanguageRequest  updateProgrammingLanguageRequest) {
		idFinder(updateProgrammingLanguageRequest);
	}

	
	@Override
	public void deleteById(int id) {
		programmingLanguageRepository.deleteById(id);
	}

	
	
	
	
     //****TAMAMLANDI*****
	//Business Rule
	
	
	
	  private boolean isLanguageExists(CreateProgrammingLanguagesRequest createProgrammingLanguagesRequest) 
	  {
		  List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
		  
		  for (ProgrammingLanguage programmingLanguage : programmingLanguages) 
		  { 
			  if(programmingLanguage.getName().equals(createProgrammingLanguagesRequest.getName()))
			  {
				  return true; 
			  } 
		} return false; 
	  }
	 
	  
	  //BELİRTİLEN ID Yİ BULUP İSMİ DEĞİŞTİRİYOR
	  private void idFinder(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) 
	  {
		  List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
		  
		  for (ProgrammingLanguage programmingLanguage : programmingLanguages) 
		  { 
			  if(programmingLanguage.getId() == updateProgrammingLanguageRequest.getId())
			  {
				  programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
				  this.programmingLanguageRepository.save(programmingLanguage);
			  } 
			  else
			  {
				  System.out.println("THIS VALUE IS NOT EXIST");
			  }
		} 
	  }
	 
	//DEFAULT OLARAK GELEN STRİNG İFADESİ VE NULL DURMUNDA HAYTA VERİYOR ANCAK HATA FIRLATMIYORR
	private boolean isLanguageNull(CreateProgrammingLanguagesRequest createProgrammingLanguagesRequest) {
		if (createProgrammingLanguagesRequest.getName().equals("") || createProgrammingLanguagesRequest.getName().equals("string")) {
			return true;
		}
		return false;
	}

	
	
	

}
