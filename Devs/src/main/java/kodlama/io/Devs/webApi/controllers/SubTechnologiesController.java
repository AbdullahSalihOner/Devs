package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.SubTechnologiesService;
import kodlama.io.Devs.business.requests.CreateSubTechnologiesRequest;
import kodlama.io.Devs.business.requests.UpdateSubTechnologiesRequest;
import kodlama.io.Devs.business.responses.GetAllSubTechnologiesResponse;

@RestController
@RequestMapping("/api/subtechnologies")
public class SubTechnologiesController {
	private SubTechnologiesService subTechnologiesService;

	@Autowired
	public SubTechnologiesController(SubTechnologiesService subTechnologiesService) {
		super();
		this.subTechnologiesService = subTechnologiesService;
	}

	@GetMapping("/getall")
	public List<GetAllSubTechnologiesResponse> getAll() {
		return subTechnologiesService.getAll();
	}

	@GetMapping("/getbyid")
	public void getById(int id) {
		subTechnologiesService.getById(id);
	}

	@PostMapping("/add")
	public void add(CreateSubTechnologiesRequest createSubTechnologiesRequest) {
		subTechnologiesService.add(createSubTechnologiesRequest);
	}

	@DeleteMapping("/deletebyid")
	public void deleteById(int id) {
		subTechnologiesService.deleteById(id);
	}

	@PostMapping("/update")
	public void updateById(UpdateSubTechnologiesRequest updateSubTechnologiesRequest) {
		subTechnologiesService.update(updateSubTechnologiesRequest);

	}

}
