package edu.sf.ebolt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sf.ebolt.entities.Idtable;
import edu.sf.ebolt.repositories.IdtableRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class IdtableService {

	@Autowired
	IdtableRepository idtableRepository;

	public void addId(Idtable idtable) {
		// String shortId = RandomStringUtils.randomAlphanumeric(24);
		idtableRepository.save(idtable);

	}

}
