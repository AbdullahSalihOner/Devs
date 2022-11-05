package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.CreateProgrammingLanguagesRequest;
import kodlama.io.Devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;

public interface ProgrammingLanguageService {
	List<GetAllProgrammingLanguagesResponse> getAll();

	void add(CreateProgrammingLanguagesRequest createProgrammingLanguagesRequest);

	void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest);

	void getById(int id);

	void deleteById(int id);

}
