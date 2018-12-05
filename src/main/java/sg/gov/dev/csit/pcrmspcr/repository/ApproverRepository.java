package sg.gov.dev.csit.pcrmspcr.repository;

import sg.gov.dev.csit.pcrmspcr.model.Approver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApproverRepository extends JpaRepository<Approver, Long> {

}