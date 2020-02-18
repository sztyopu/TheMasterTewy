package edu.sf.ebolt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.sf.ebolt.entities.Idtable;

public interface IdtableRepository extends JpaRepository<Idtable, String> {

}
