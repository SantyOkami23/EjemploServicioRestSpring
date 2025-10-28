package com.ciaf.DemoJDBC.controller;


import com.ciaf.DemoJDBC.model.Producto;
import com.ciaf.DemoJDBC.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @GetMapping
    public List<Producto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Producto buscar(@PathVariable int id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Producto crear(@RequestBody Producto nuevo) {
        return service.agregar(nuevo);
    }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable int id, @RequestBody Producto actualizado) {
        return service.actualizar(id, actualizado);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        boolean eliminado = service.eliminar(id);
        return eliminado ? "Producto eliminado " : "Producto no encontrado ";
    }
}
