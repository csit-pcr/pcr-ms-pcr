package sg.gov.dev.csit.pcrmspcr.repository;

import sg.gov.dev.csit.pcrmspcr.model.Tasker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskerRepository extends JpaRepository<Tasker, Long> {

}