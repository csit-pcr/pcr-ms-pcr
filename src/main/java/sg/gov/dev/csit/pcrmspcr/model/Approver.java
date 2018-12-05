package sg.gov.dev.csit.pcrmspcr.model;

//Classes that are imported or used
import sg.gov.dev.csit.pcrmspcr.model.EmployeeDetails;

//Spring imported
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//Javax imported
import javax.persistence.*;

//Java imported
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="Approver")
@EntityListeners(AuditingEntityListener.class)
public class Approver extends EmployeeDetails implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String approver_id;

    private String[] directorate_assigned;

    private String[] section_assigned;

    public String getApproverID() {
        return this.approver_id;
    }

    //Mapping to Change Request <entity> - Child 
    @OneToOne(mappedBy="fk_approver_id", cascade = CascadeType.ALL)
    private Set <ChangeRequest> requests;

    //Start of Getters

    public String[] getDirectorateAssigned() {
        return this.directorate_assigned;
    }

    public String[] getSectionAssigned() {
        return this.section_assigned;
    }

    //Start of Setters 

    public void setApproverID(String approverID) {
        this.approver_id = approverID;
    }

    public void setDirectorateAssigned(String[] directorateAssigned) {
        this.directorate_assigned = directorateAssigned;
    }

    public void setSectionAssigned(String[] sectionAssigned) {
        this.section_assigned = sectionAssigned;
    }


}