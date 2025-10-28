package com.ciaf.DemoJDBC.service;


import com.ciaf.DemoJDBC.model.Producto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProductoService {

    private List<Producto> productos = new ArrayList<>();

    public ProductoService() {
        // Datos iniciales
        productos.add(new Producto(1, "Televisor", 2500.0));
        productos.add(new Producto(2, "Lavadora", 1800.0));
    }

    public List<Producto> listar() {
        return productos;
    }

    public Producto buscarPorId(int id) {
        return productos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Producto agregar(Producto nuevo) {
        productos.add(nuevo);
        return nuevo;
    }

    public Producto actualizar(int id, Producto actualizado) {
        Producto existente = buscarPorId(id);
        if (existente != null) {
            existente.setNombre(actualizado.getNombre());
            existente.setPrecio(actualizado.getPrecio());
        }
        return existente;
    }

    public boolean eliminar(int id) {
        return productos.removeIf(p -> p.getId() == id);
    }
}
