package sg.gov.dev.csit.pcrmspcr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// import org.springframework.data.annotation.CreatedDate;
// import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="portFilteringDetails")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value= {"createdAt", "updatedAt"},
            allowGetters=true)
//Prevent specified files from being serializable or deserialized

public class PortFilteringDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String portdetailsid;

    @NotBlank
    private String source_hostname;

    @NotBlank
    private String source_ip;

    @NotBlank
    private String destination_hostname;

    @NotBlank
    private Double port_no;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "request_no")
    private String cr_id;

    //Start of Getters

    public String getPortDetailsID() {
        return this.portdetailsid;
    }

    public String getSourceHostname() {
        return this.source_hostname;
    }

    public String getSourceIP() {
        return this.source_ip;
    }

    public String getDestinationHostname() {
        return this.destination_hostname;
    }

    public Double getPortNo() {
        return this.port_no;
    }

    public String getCRID() {
        return this.cr_id;
    }

    //Start of Setters

    public void setEmployeeNo(String portDetailsID) {
        this.portdetailsid = portDetailsID;
    }

    public void setSourceHostname(String sourceHostname) {
        this.source_hostname = sourceHostname;
    }

    public void setSourceIP(String sourceIP) {
        this.source_ip = sourceIP;
    }

    public void setDestinationHostname(String destinationHostname) {
        this.destination_hostname = destinationHostname;
    }

    public void setPortNo(Double portNo) {
        this.port_no = portNo;
    }

    //not sure if need to set the CRID
    
}