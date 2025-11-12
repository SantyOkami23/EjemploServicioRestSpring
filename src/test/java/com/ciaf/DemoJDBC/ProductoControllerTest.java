package com.ciaf.DemoJDBC;
import com.ciaf.DemoJDBC.controller.ProductoController;
import com.ciaf.DemoJDBC.model.Producto;
import com.ciaf.DemoJDBC.service.ProductoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductoController.class)
class ProductoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductoService service;

    @TestConfiguration
    static class MockConfig {
        @Bean
        public ProductoService productoService() {
            return Mockito.mock(ProductoService.class);
        }
    }



        @Test
        void listar_debeRetornarListaDeProductos() throws Exception {
            Producto producto = new Producto(1, "Producto1", 100.0);
            given(service.listar()).willReturn(Arrays.asList(producto));
            mockMvc.perform(get("/productos"))
                    .andExpect(status().isOk());
        }
}
