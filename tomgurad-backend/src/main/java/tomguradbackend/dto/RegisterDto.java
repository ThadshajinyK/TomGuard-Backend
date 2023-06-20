package tomguradbackend.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String first_name;

    private String last_name;

    private String email;
    private String password;
}
