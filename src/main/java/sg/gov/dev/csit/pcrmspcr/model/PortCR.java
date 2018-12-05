package sg.gov.dev.csit.pcrmspcr.model;

//Classes that are imported or used
import sg.gov.dev.csit.pcrmspcr.model.ChangeRequest;

//Javax imports
import javax.persistence.*;

//Java imports
import java.io.Serializable;
import java.util.Set;

public class PortCR extends ChangeRequest implements Serializable{
    private static final long serialVersionUID = 1L;

    private String[] portfilteringdetails;

    //Mapping to the Port Filtering Details <Entity>

    @OneToMany(mappedBy="cr_id", cascade = CascadeType.ALL)
    private Set <PortFilteringDetails> portilteringdetails;

    public String[] getPortFilteringDetails() {
        return this.portfilteringdetails;
    }

    public void setPortNo(String[] portFilteringDetails) {
        this.portfilteringdetails = portFilteringDetails;
    }


}