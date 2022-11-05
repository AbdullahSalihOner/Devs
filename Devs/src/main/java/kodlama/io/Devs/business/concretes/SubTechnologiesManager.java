package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.SubTechnologiesService;
import kodlama.io.Devs.business.requests.CreateSubTechnologiesRequest;
import kodlama.io.Devs.business.requests.UpdateSubTechnologiesRequest;
import kodlama.io.Devs.business.responses.GetAllSubTechnologiesResponse;
import kodlama.io.Devs.dataAccess.abstracts.SubTechnologiesRepository;
import kodlama.io.Devs.entities.concretes.SubTechnologies;

@Service
public class SubTechnologiesManager implements SubTechnologiesService {
	
	private SubTechnologiesRepository subTechnologiesRepository;

	public SubTechnologiesManager(SubTechnologiesRepository subTechnologiesRepository) {
		super();
		this.subTechnologiesRepository = subTechnologiesRepository;
	}

	@Override
	public List<GetAllSubTechnologiesResponse> getAll() {
		
		List<SubTechnologies> subTechnologies = subTechnologiesRepository.findAll();
		List<GetAllSubTechnologiesResponse> subTechnologiesResponses = new ArrayList<GetAllSubTechnologiesResponse>();
		
		for (SubTechnologies subTechnologies2 : subTechnologies) {
			GetAllSubTechnologiesResponse responseItem = new GetAllSubTechnologiesResponse();
			responseItem.setId(subTechnologies2.getId());
			responseItem.setName(subTechnologies2.getName());
			
			subTechnologiesResponses.add(responseItem);
			}
		//BUSİNESS RULE
		return subTechnologiesResponses;
	}

	
	@Override
	public void add(CreateSubTechnologiesRequest createSubTechnologiesRequest) {

		SubTechnologies subTechnologiesNew = new SubTechnologies();
		subTechnologiesNew.setName(createSubTechnologiesRequest.getName());
	
		if(isTechnologyExists(createSubTechnologiesRequest) ) 
		{
			 System.out.println("Language is already Exists");
		}
		else if(isLanguageNull(createSubTechnologiesRequest) ) {
			 System.out.println("Language name is can not be null");
		}
		else {
			this.subTechnologiesRepository.save(subTechnologiesNew);
		}
		
	}
	

	@Override
	public void update(UpdateSubTechnologiesRequest updateSubTechnologiesRequest) {

		idFinder(updateSubTechnologiesRequest);
		
	}
	

	@Override
	public void getById(int id) {
		subTechnologiesRepository.findById(id);
	}

	
	@Override
	public void deleteById(int id) {
		subTechnologiesRepository.deleteById(id);
		
	}
	
	
	
	//BUSINESS RULES 
	
	private boolean isTechnologyExists(CreateSubTechnologiesRequest createSubTechnologiesRequest) 
	  {
		  List<SubTechnologies> subTechnologies = subTechnologiesRepository.findAll();
		  
		  for (SubTechnologies subTechnologies2 : subTechnologies) 
		  { 
			  if(subTechnologies2.getName().equals(createSubTechnologiesRequest.getName()))
			  {
				  return true; 
			  } 
		} return false; 
	  }
	 
	  
	  
	  private void idFinder(UpdateSubTechnologiesRequest updateSubTechnologiesRequest) 
	  {
		  List<SubTechnologies> subTechnologies = subTechnologiesRepository.findAll();
		  
		  for (SubTechnologies subTechnologies2 : subTechnologies) 
		  { 
			  if(subTechnologies2.getId() == updateSubTechnologiesRequest.getId())
			  {
				  subTechnologies2.setName(updateSubTechnologiesRequest.getName());
				  this.subTechnologiesRepository.save(subTechnologies2);
			  } 
			  else
			  {
				  System.out.println("THIS VALUE IS NOT EXIST");
			  }
		} 
	  }
	 
	
	private boolean isLanguageNull(CreateSubTechnologiesRequest createSubTechnologiesRequest) {
		if (createSubTechnologiesRequest.getName().equals("") || createSubTechnologiesRequest.getName().equals("string")) {
			return true;
		}
		return false;
	}

}
