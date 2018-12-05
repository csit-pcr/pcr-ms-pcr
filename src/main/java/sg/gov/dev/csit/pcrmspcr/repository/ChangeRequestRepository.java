package sg.gov.dev.csit.pcrmspcr.repository;

import sg.gov.dev.csit.pcrmspcr.model.ChangeRequest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangeRequestRepository extends JpaRepository<ChangeRequest, Long> {

}