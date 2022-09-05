package SGR.com.sgr;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import com.sgr.api.PersonaServiceImplement;
import com.sgr.entities.Persona;

@SpringBootTest
@SpringBootConfiguration
@ComponentScan(basePackages = { "com.sgr" })
@TestMethodOrder(OrderAnnotation.class)
class ApplicationTests {

	@Autowired
	PersonaServiceImplement service;
	// Crud de Usuario Test

	@Test
	@Order(1)
	void crearPersonaTest() {
		System.out.println("Creando Persona Test");
		Persona tp = new Persona(999999996L, "TestNombre", "TestApellido", "TestDireccion 555", "099099099",
				"ObservacionesTest", "OtrosTest");
		service.create(tp);
	}

	@Test
	@Order(2)
	void obtenerPersonaTest() {
		System.out.println("Obteniendo Persona Test");
		Optional<Persona> po = Optional.of(service.getById(999999996L));
		assertTrue(po.isPresent());
	}

	@Test
	@Order(3)
	void actualizarPersonaTest() {
		System.out.println("Actualizando Persona Test");
		Persona p = service.getById(999999996L);
		if (p != null) {
			p.setNombre("JUnitTest");
			service.update(p);
		}
		assertTrue(service.getById(999999996L).getNombre().equals("JUnitTest"));

	}

	@Test
	@Order(4)
	void eliminarPersonaTest() {
		System.out.println("Eliminando Persona Test");
		Optional<Persona> po = Optional.of(service.getById(999999996L));
		if (po.isPresent()) {
			service.delete(999999996L);
		}
		assertTrue(service.getById(999999996L) == null);
	}
}
