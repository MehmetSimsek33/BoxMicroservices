package TechK.boxservice.service.abstracts.box;

import java.util.List;

import org.springframework.stereotype.Service;

import TechK.boxservice.core.mapping.ModelMapperService;
import TechK.boxservice.data.entities.Box;
import TechK.boxservice.data.requests.box.CreateBoxRequest;
import TechK.boxservice.data.requests.box.UpdateBoxRequest;
import TechK.boxservice.data.responses.CreateBoxResponse;
import TechK.boxservice.data.responses.GetAllBoxResponses;
import TechK.boxservice.data.responses.UpdateBoxResponse;
import TechK.boxservice.service.abstracts.box.entity.BoxMongoEntityService;
import TechK.boxservice.service.constant.BoxMessages;
import TechK.common.utilities.results.DataResult;
import TechK.common.utilities.results.Result;
import TechK.common.utilities.results.SuccessDataResult;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoxManager implements BoxService {

	private BoxMongoEntityService boxMongoEntityService;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult<CreateBoxResponse> createBox(CreateBoxRequest createBoxRequest) {
		Box box = this.modelMapperService.forRequest().map(createBoxRequest, Box.class);
		CreateBoxResponse createBoxResponse = this.modelMapperService.forRequest().map(box, CreateBoxResponse.class);
		box = boxMongoEntityService.save(box);
		return new SuccessDataResult<CreateBoxResponse>(createBoxResponse, BoxMessages.BoxCreated);
	}

	@Override
	public Result delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<UpdateBoxResponse> update(UpdateBoxRequest updateBoxResponse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<GetAllBoxResponses>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<GetAllBoxResponses> getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
