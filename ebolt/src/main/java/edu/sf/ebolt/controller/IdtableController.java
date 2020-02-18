package edu.sf.ebolt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.sf.ebolt.entities.Idtable;
import edu.sf.ebolt.services.IdtableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(tags = { "ebolt-handler" })
@RestController
@RequiredArgsConstructor
public class IdtableController {

	@Autowired
	IdtableService idtableService;

	// Idtable idtable;

	@GetMapping(value = "/api/init")
	@ApiOperation(value = "végpont A.", httpMethod = "GET")
	public String getId(Idtable idtable) {
		// String id24 = RandomStringUtils.randomAlphanumeric(24);
		idtableService.addId(idtable);
		return idtable.getId();
	}

	// @PostMapping(value = "/api/valami", consumes = MediaType.APPLICATION_JSON_VALUE)
	// @ApiOperation(value = "végpont D.", httpMethod = "POST")
	// public void addIdtable(@Valid @RequestBody Idtable idtable) {
	// idtableService.addId(idtable);
	// }

}
