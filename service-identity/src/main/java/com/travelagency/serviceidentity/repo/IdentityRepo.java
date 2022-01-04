package com.travelagency.serviceidentity.repo;

import com.travelagency.serviceidentity.repo.model.Identity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentityRepo  extends JpaRepository<Identity, Long> {

}
