package com.mycompany.jerseytutorial.resources;

import com.mycompany.jerseytutorial.model.Candidate;
import com.mycompany.jerseytutorial.model.Skill;
import com.mycompany.jerseytutorial.services.CandidateService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;

/**
*
* @author manueltovaizquierdo
*/
@Path("/candidates")
//@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
//@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CandidateResource {

	CandidateService CandidateService = new CandidateService();

	/*
	   If using POSTMAN as client, remember setting a Header 
	   "Accept:application/json" for retrieving JSON format
	   "Accept:application/xml" for retrieving XML format
	 */    
	//   @GET
	//   public List<Candidate> getCandidates() {
	//	       return CandidateService.getAllCandidates();
	//   }

	@GET
	@Path("/{candidateID}")
	public Candidate getCandidate(@PathParam("candidateID") int id) {
		return CandidateService.getCandidate(id);
	}

	@GET
	@Path("/{candidateID}/skills/{skillID}")
	public Skill getCandidate(@PathParam("candidateID") int id, @PathParam("skillID") int skillID) {
		return CandidateService.getSkillInCandidate(id, skillID);
	}

	/*
	 * When using POSTMAN remember to include in Headers: Content-type : application/json
	 * and include in the body of the request in RAW format the object in JSON notation
	 */
	@POST
	public Candidate postCandidate(Candidate c) {
		return CandidateService.createCandidate(c);
	}

	/*
	 * Search for a Candidate 
	 * GET http://localhost:49000/api/candidates?name=Jack&skillname=helloworld
	 * either by @QueryParam candidate content
	 * or by @QueryParam author
	 */
	@GET
	public List<Candidate> getFilteredCandidates(@QueryParam("city") String city, 
			@QueryParam("name") String name, 
			@QueryParam("profession") String profession,
			@QueryParam("start") int start,
			@QueryParam("size") int size) {
		if ((city != null) || (name != null) || (profession != null)) {
			return CandidateService.getSearchCandidates(profession, city, name);
		}
		if (start >= 1 && size > 0 ) {
			return CandidateService.getAllCandidatesPaginated(start, size);
		}
		return CandidateService.getAllCandidates();
	} 
}

