package edu.wpi.cs.wpisuitetng.modules.defecttracker.defect;

import com.google.gson.Gson;

import edu.wpi.cs.wpisuitetng.modules.defecttracker.models.Defect;
import edu.wpi.cs.wpisuitetng.network.IRequest;
import edu.wpi.cs.wpisuitetng.network.Request;
import edu.wpi.cs.wpisuitetng.network.RequestObserver;
import edu.wpi.cs.wpisuitetng.network.Response;

/**
 * An Observer for a Request to create a Defect.
 */
public class CreateDefectRequestObserver implements RequestObserver {

	private final DefectView view;

	/**
	 * Constructs a new CreateDefectRequestObserver
	 * 
	 * @param view	The DefectView that will be affected by any updates.
	 */
	public CreateDefectRequestObserver(DefectView view) {
		this.view = view;
	}

	@Override
	public void success(IRequest iReq) {
		// If observable is a Request...
		if (Request.class.getName().equals(iReq.getClass().getName())) {
			// cast observable to a Request
			Request request = (Request) iReq;

			// get the response from the request
			Response response = request.getResponse();


			// print the body
			System.out.println("Received response: " + response.getBody()); //TODO change this to logger

			// parse the defect from the body
			Gson parser = new Gson();
			Defect defect = parser.fromJson(response.getBody(), Defect.class);

			// make sure the defect isn't null
			if (defect != null) {
				((DefectPanel) view.getDefectPanel()).updateModel(defect);
			}
			else {
				// TODO notify user of server error
			}			
		}
		// Otherwise...
		else {
			System.out.println("Observable is not a Request."); // TODO change this to logger
		}
	}

	@Override
	public void error(IRequest iReq) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fail(IRequest iReq, String errorMessage) {
		// TODO Auto-generated method stub

	}
}
