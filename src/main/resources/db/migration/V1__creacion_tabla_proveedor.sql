CREATE TABLE proveedores (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(50) NOT NULL UNIQUE,
    company_name VARCHAR(150) NOT NULL,
    contact_name VARCHAR(150) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(50),
    is_active BOOLEAN DEFAULT TRUE NOT NULL
);

CREATE TABLE proveedor_categorias (
    proveedor_id BIGINT NOT NULL,
    categoria VARCHAR(100) NOT NULL,
    CONSTRAINT fk_proveedor_categoria FOREIGN KEY (proveedor_id) REFERENCES proveedores (id) ON DELETE CASCADE
);
