package sg.gov.dev.csit.pcrmspcr.repository;

import sg.gov.dev.csit.pcrmspcr.model.Files;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilesRepository extends JpaRepository<Files, Long> {

}