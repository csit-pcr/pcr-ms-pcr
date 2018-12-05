package sg.gov.dev.csit.pcrmspcr.repository;

import sg.gov.dev.csit.pcrmspcr.model.TaskeeMessage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskeeMessageRepository extends JpaRepository<TaskeeMessage, Long> {

}