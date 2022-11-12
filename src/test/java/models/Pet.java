package models;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Builder
@Getter
@Setter
public class Pet {
	
	
	/*
	 * { "id": 1002,
	 *  "category": { "id": 0, "name": "string" },
	 *   "name": "doggie",
	 * "photoUrls": [ "string" ], 
	 * "tags": [ { "id": 10, "name": "string" } ],
	 * "status": "available" }
	 */
	private int id;
	private String name;
	private String status;
	private List<String> photoUrls;
	private List<Tags> tags;
	private Category category;
	
	

}
