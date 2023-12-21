package sv.bank.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClienteDTO {

    private Long id;
    private String name;
    private String last_name;

}
