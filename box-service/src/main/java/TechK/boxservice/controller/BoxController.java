package TechK.boxservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TechK.boxservice.data.requests.box.CreateBoxRequest;
import TechK.boxservice.data.responses.CreateBoxResponse;
import TechK.boxservice.data.responses.GetAllBoxResponses;
import TechK.boxservice.service.abstracts.box.BoxService;
import TechK.common.utilities.results.DataResult;
import TechK.common.utilities.results.Result;

@RestController
@RequestMapping("boxs")
public class BoxController {

	@Autowired
	private BoxService boxService;

	@PostMapping
	public DataResult<CreateBoxResponse> createBook(@RequestBody CreateBoxRequest createBoxRequest) {
		System.out.println("Deneme");
		return this.boxService.createBox(createBoxRequest);
	}
	
	@GetMapping()
	public DataResult<List<GetAllBoxResponses>> getAll() {
		return this.boxService.getAll();
	}

	@GetMapping("{id}")
	public DataResult<GetAllBoxResponses> getById(@PathVariable("id") String id) {

		return this.boxService.getById(id);
	}

	@DeleteMapping("{id}")
	public Result deleteBook(@PathVariable("id") String id) {
		return this.boxService.delete(id);
	}

//	@PutMapping("{id}/book/change/{name}/change{releaseYear}")
//	public  DataResult<BookDto> updateNameOfAuthorByBook(@PathVariable("id") String id,
//			@PathVariable("name") String name, @PathVariable("releaseYear") String releaseYear) {
//		return this.bookService.updateByReleaseYearAndName(id, name, releaseYear);
//	}
}