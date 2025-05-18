package com.gl.ceir.config.repository.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gl.ceir.config.model.app.Tac;

@Repository
public interface TacRepository extends JpaRepository<Tac, String> {

}
