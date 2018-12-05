package sg.gov.dev.csit.pcrmspcr.model;

//Classes imported or used
import sg.gov.dev.csit.pcrmspcr.model.EmployeeDetails;

//Spring imported
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//Javax imported
import javax.persistence.*;

//Java imported
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name="Requestor")
@EntityListeners(AuditingEntityListener.class)
public class Requestor extends EmployeeDetails implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String requestor_id;

    //Mapping to Change Request <entity> - Child 
    @OneToOne(mappedBy="fk_requestor_id", cascade = CascadeType.ALL)
    private Set <ChangeRequest> requests;

    public String getRequestorID() {
        return this.requestor_id;
    }

    public void setRequestorID(String requestorID) {
        this.requestor_id = requestorID;
    }


}