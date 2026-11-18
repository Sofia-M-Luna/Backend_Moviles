package cl.duoc.proveedores_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @NotBlank
    @Column(name = "company_name", nullable = false)
    private String companyName;

    @NotBlank
    @Column(name = "contact_name", nullable = false)
    private String contactName;

    @Email
    @NotBlank
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone")
    private String phone;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "proveedor_categorias", joinColumns = @JoinColumn(name = "proveedor_id"))
    @Column(name = "categoria")
    private List<String> suppliedCategories = new ArrayList<>();

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
}
