package TechK.boxservice.service.abstracts.box;

import java.util.List;

import TechK.boxservice.data.requests.box.CreateBoxRequest;
import TechK.boxservice.data.requests.box.UpdateBoxRequest;
import TechK.boxservice.data.responses.CreateBoxResponse;
import TechK.boxservice.data.responses.GetAllBoxResponses;
import TechK.boxservice.data.responses.UpdateBoxResponse;
import TechK.common.utilities.results.DataResult;
import TechK.common.utilities.results.Result;

public interface BoxService {

	DataResult<CreateBoxResponse> createBox(CreateBoxRequest createBoxRequest);
	Result delete(String id);
	DataResult<UpdateBoxResponse> update(UpdateBoxRequest updateBoxResponse);
	DataResult<List<GetAllBoxResponses>> getAll();
	DataResult<GetAllBoxResponses> getById(String id);
}
