package cl.duoc.proveedores_service.controller;

import cl.duoc.proveedores_service.model.Proveedor;
import cl.duoc.proveedores_service.service.ProveedorService;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.tags.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@OpenAPIDefinition(
        info = @Info(
                title = "API de Proveedores",
                version = "1.0",
                description = "Operaciones de consulta para proveedores del sistema automotriz",
                contact = @Contact(
                        name = "Kevin Hurtado",
                        email = "tu.correo@duocuc.cl"
                )
        )
)

@Tag(name = "Proveedores", description = "Operaciones de consulta de proveedores")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET})
@RestController
@RequestMapping("api/v1/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @Operation(summary = "Listar proveedores", description = "Obtiene el listado completo de proveedores registrados en el sistema.")
    @ApiResponse(responseCode = "200", description = "Proveedores listados correctamente", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Proveedor.class))))
    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(proveedorService.findAll());
    }

    @Operation(summary = "Buscar proveedor por ID", description = "Obtiene un proveedor específico según su identificador.")
    @ApiResponse(responseCode = "200", description = "Proveedor encontrado correctamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Proveedor.class)))
    @ApiResponse(responseCode = "404", description = "Proveedor no encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(
            @Parameter(description = "ID del proveedor", example = "1")
            @PathVariable Long id) {
        Proveedor proveedor = proveedorService.findById(id);
        if (proveedor == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(proveedor);
    }
}
