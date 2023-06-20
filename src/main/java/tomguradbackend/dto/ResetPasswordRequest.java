package tomguradbackend.dto;

import lombok.Data;

@Data
public class ResetPasswordRequest {
    private String token;
    private String new_password;
}
