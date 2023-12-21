package sv.bank.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "CLIENT")
@Entity
@Getter
@Setter
@ToString
public class ClientEntity {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "clientId") 
	 private Long id;
	 private String name;
	 private String last_name;
	 private Date birthday;
	 private String phone;
	 private String email;
	 private String address;
	 

}
