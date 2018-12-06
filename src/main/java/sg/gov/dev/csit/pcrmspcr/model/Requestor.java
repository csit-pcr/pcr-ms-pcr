package sg.gov.dev.csit.pcrmspcr.model;

//Classes imported or used
import sg.gov.dev.csit.pcrmspcr.model.EmployeeDetails;

//Spring imports
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//Javax imports
import javax.persistence.*;

//Java imports
import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Table(name="Requestor")
@EntityListeners(AuditingEntityListener.class)
public class Requestor extends EmployeeDetails implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private RandomString requestor_id = new RandomString(8, ThreadLocalRandom.current());

    //Mapping to Change Request <entity> - Child 
    @OneToOne(mappedBy="fk_requestor_id", cascade = CascadeType.ALL)
    private Set <ChangeRequest> requests;

    public RandomString getRequestorID() {
        return this.requestor_id;
    }

    public void setRequestorID(RandomString requestorID) {
        this.requestor_id = requestorID;
    }


}