package tomguradbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.NoArgsConstructor;
import javax.persistence.*;




@Entity
@Table(name="Server")
public class Server {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serverid;

    private String client;

    private String location;

    private String ipAddress;

    private String status;

    private String app;

    public Server() {
    }
    public Server(Integer serverid, String client, String location, String ipAddress, String status, String app) {
        this.serverid = serverid;
        this.client = client;
        this.location = location;
        this.ipAddress = ipAddress;
        this.status = status;
        this.app = app;
    }

    public Integer getServerid() {
        return serverid;
    }

    public String getClient() {
        return client;
    }

    public String getLocation() {
        return location;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getStatus() {
        return status;
    }

    public String getApp() {
        return app;
    }

    public void setServerid(Integer serverid) {
        this.serverid = serverid;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setApp(String app) {
        this.app = app;
    }
}