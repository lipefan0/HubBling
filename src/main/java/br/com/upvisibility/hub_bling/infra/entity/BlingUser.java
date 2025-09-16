package br.com.upvisibility.hub_bling.infra.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_bling_user")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlingUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String companyId;
    private String companyName;
    private String companyEmail;
    private String companyCnpj;
    private String acessToken;
    private String refreshToken;
    @Column(unique = true, nullable = false)
    private String userId;

}
