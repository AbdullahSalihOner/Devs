package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.CreateSubTechnologiesRequest;
import kodlama.io.Devs.business.requests.UpdateSubTechnologiesRequest;
import kodlama.io.Devs.business.responses.GetAllSubTechnologiesResponse;

public interface SubTechnologiesService {

	List<GetAllSubTechnologiesResponse> getAll();

	void add(CreateSubTechnologiesRequest createSubTechnologiesRequest);

	void update(UpdateSubTechnologiesRequest updateSubTechnologiesRequest);

	void getById(int id);

	void deleteById(int id);
}
