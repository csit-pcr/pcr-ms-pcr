package sg.gov.dev.csit.pcrmspcr.model;

//Spring imports
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//Javax imports
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

//Java imports
import java.io.Serializable;

@Entity
// @Table(name="employeeDetails")
@EntityListeners(AuditingEntityListener.class)

public abstract class EmployeeDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String employee_no;

    @NotBlank
    private enum Cluster{
        SAS, ACS, ALS;
    };

    private Cluster cluster;

    @NotBlank
    private enum Section{
        ITA_IIS, ITA_ICT, ITA_IRS;
    };

    private Section section;

    @NotBlank
    private String name;

    //Start of Getters

    public String getEmployeeNo() {
        return this.employee_no;
    }

    @Enumerated(EnumType.STRING)
    public Cluster getCluster() {
        return this.cluster;
    }

    @Enumerated(EnumType.STRING)
    public Section getSection() {
        return this.section;
    }
    
    public String getName() {
        return this.name;
    }

    //Start of Setters

    public void setEmployeeNo(String employeeNo) {
        this.employee_no = employeeNo;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}