INSERT INTO proveedores (id, code, company_name, contact_name, email, phone, is_active)
VALUES
    (1, 'SUP-001', 'Filtros y Lubricantes Chile', 'Carlos Mendoza', 'ventas@filtroschile.cl', '+56 9 1234 5678', true),
    (2, 'SUP-002', 'Frenos & Suspensión Express', 'Andrea Rojas', 'contacto@frenosexpress.cl', '+56 9 8765 4321', true),
    (3, 'SUP-003', 'MegaStock Repuestos', 'Jorge Soto', 'pedidos@megastock.cl', '+56 2 2345 6789', true);

INSERT INTO proveedor_categorias (proveedor_id, categoria)
VALUES
    (1, 'Filtros'), (1, 'Aceites'), (1, 'Lubricantes'),
    (2, 'Frenos'), (2, 'Suspensión'),
    (3, 'Bujías'), (3, 'Correas'), (3, 'Refrigerantes');
