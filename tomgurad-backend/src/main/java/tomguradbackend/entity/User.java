package tomguradbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name="users")
@Data

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;

    private String last_name;


    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String password;

    private String job_title;
    private String role="ADMIN";

    @JsonIgnore
    private String resetToken;

    private String phone;

    private String location;

    @Column(columnDefinition = "text")
    private  String image;



}
