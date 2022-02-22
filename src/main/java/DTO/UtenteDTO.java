package DTO;

import com.example.demo.model.Cosa;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UtenteDTO implements Serializable {
    private Long id;
    private String name;
    private String lastname;
    private String completeName;
    private String username;
    private String password;
    private String email;
    private CosaDTO cosaDTO;
    private String utilityTarget;
}
