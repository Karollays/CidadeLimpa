package br.com.fiap.cidadelimpa.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="T_MORADOR")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Morador {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_T_MORADOR")
    @SequenceGenerator(
            name = "SEQ_T_MORADOR",
            sequenceName = "SEQ_T_MORADOR",
            allocationSize = 1)
    @Column(name = "id_morador")
    private Long id;
    @Column(name = "nm_morador")
    private String nome;
    @Column(name = "nr_cpf")
    private String cpf;
    @Column(name = "ds_email")
    private String email;
    @ManyToOne
    @JoinColumn(name = "imovel_id")
    private Imovel imovel;
}