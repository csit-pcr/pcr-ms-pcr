package sg.gov.dev.csit.pcrmspcr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Spring Imports
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//Javax imports
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

//Java imports
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name="changerequest")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value= {"createdAt", "updatedAt"},
            allowGetters=true) 
//Prevent specified files from being serializable or deserialized

public class ChangeRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String request_no;

    @NotBlank
    private String request_name;

    @NotBlank
    private enum Network{
        POP, ORD, OCS;
    };

    private Network network;

    @NotBlank
    private enum Application{
        PRIME, OPTIMUS, BUMBLE
    };

    private Application application;

    @NotBlank
    private String description;

    @NotBlank
    private enum Category{
        PRIME, OPTIMUS, BUMBLE
    };

    private Category category;

    @NotBlank
    private String request_details;

    @NotBlank
    private enum Section{
        ITA_CS,IIT_IO,ITP_IP
    };

    private Section assign_to;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date start_by;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date done_by;

    @NotBlank
    private String deployment_plan;

    // private String files[];

    @NotBlank
    private String project_name;
    
    @NotBlank
    private enum POC{
        BOB, JACK, JUNE
    };

    private POC poc;

    @NotBlank
    private Section poc_section;

    @NotBlank
    private String requestor_id;

    @NotBlank
    private String approver_id;

    @NotBlank
    private String tasker_id;

    @NotBlank
    private String taskee_id;

    //Mapping to the Message(Taskee&Tasker) <interface>-Child
    
    @OneToOne(mappedBy="cr_id", cascade = CascadeType.ALL)
    private Set <TaskerMessage> taskermessage;

    @OneToOne(mappedBy="cr_id", cascade = CascadeType.ALL)
    private Set <TaskeeMessage> taskeemessage;

    //Mapping to the Files <Entity>-Child

    @OneToMany(mappedBy="cr_id", cascade = CascadeType.ALL)
    private Set <Files> files;

    //Mapping to the Tasker <Entity>-Parent

    @OneToOne
    @JoinColumn(name = "FK_tasker_ID")
    private Tasker fk_tasker_id;
    
    @Column(nullable = false, updatable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;


    //Start of Getters

    public String getRequestNo() {
        return this.request_no;
    }

    public String getRequestName() {
        return this.request_name;
    }

    @Enumerated(EnumType.STRING)
    public Network getNetwork() {
        return this.network;
    }

    public Application getSystem() {
        return this.application;
    }

    public String getBusinessReason() {
        return this.description;
    }

    public Category getCategory() {
        return this.category;
    }

    public String getRequestDetails() {
        return this.request_details;
    }

    public Section getAssignTo() {
        return this.assign_to;
    }

    public Date getStartBy() {
        return this.start_by;
    }

    public Date getDoneBy() {
        return this.done_by;
    }

    // public String[] getFiles() {
    //     return this.files;
    // }
    
    public String getProjectName() {
        return this.project_name;
    }

    public POC getPOC() {
        return this.poc;
    }

    public Section getPOCSection() {
        return this.poc_section;
    }

    public String getRequestorID() {
        return this.requestor_id;
    }

    public String getApproverID() {
        return this.approver_id;
    }

    public String getTaskerID() {
        return this.tasker_id;
    }

    public String getTaskeeID() {
        return this.taskee_id;
    }

    // Start of Setters

    public void setRequestNo(String requestNo) {
        this.request_no = requestNo;
    }

    public void setRequestName(String requestName) {
        this.request_name = requestName;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public void setSystem(Application system) {
        this.application = system;
    }

    public void setBusinessReason(String businessReason) {
        this.description = businessReason;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setRequestDetails(String requestDetails) {
        this.request_details = requestDetails;
    }

    public void setAssignTo(Section assignTo) {
        this.assign_to = assignTo;
    }

    public void setStartBy(Date startBy) {
        this.start_by = startBy;
    }

    public void setDoneBy(Date doneBy) {
        this.done_by = doneBy;
    }

    public void setDeploymentPlan(String deploymentPlan) {
        this.deployment_plan = deploymentPlan;
    }

    // public void setFiles (String[] files) {
    //     this.files = files;
    // }
    public void setProjectName(String projectName) {
        this.project_name = projectName;
    }

    public void setPOC (POC poc) {
        this.poc = poc;
    }

    public void setPOCSection(Section pocSection) {
        this.poc_section = pocSection;
    }

    public void setRequestID(String requestorID) {
        this.requestor_id = requestorID;
    }

    public void setApproverID(String approverID) {
        this.approver_id = approverID;
    }

    public void setTaskerID(String taskerID) {
        this.tasker_id = taskerID;
    }

    public void setTaskeeID(String taskeeID) {
        this.taskee_id = taskeeID;
    }


//     public void setCreatedAt(Date createdAt) {
//         this.createdAt = createdAt;
//     }

//     public void setUpdatedAt(Date updatedAt) {
//         this.updatedAt = updatedAt;
//     }
}