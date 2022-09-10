package SGR.com.sgr;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.sgr.api.PersonaServiceImplement;
import com.sgr.api.VehiculoServiceImplement;
import com.sgr.entities.Persona;
import com.sgr.entities.Vehiculo;

@SpringBootTest
@SpringBootConfiguration
@ComponentScan(basePackages = { "com.sgr" })
@TestMethodOrder(OrderAnnotation.class)
class ApplicationTests {

	@Autowired
	PersonaServiceImplement servicepr;
	@Autowired
	VehiculoServiceImplement servicevh;
	
	// Crud de Usuario Test
	@Test
	@Order(1)
	void crearPersonaTest() {
		System.out.println("Creando Persona Test");
		Persona tp = new Persona(999999996L, "TestNombre", "TestApellido", "TestDireccion 555", "099099099",
				"ObservacionesTest", "OtrosTest");
		servicepr.create(tp);
	}

	@Test
	@Order(2)
	void obtenerPersonaTest() {
		System.out.println("Obteniendo Persona Test");
		Optional<Persona> po = Optional.of(servicepr.getById(999999996L));
		assertTrue(po.isPresent());
	}

	@Test
	@Order(3)
	void actualizarPersonaTest() {
		System.out.println("Actualizando Persona Test");
		Persona p = servicepr.getById(999999996L);
		if (p != null) {
			p.setNombre("JUnitTest");
			servicepr.update(p);
		}
		assertTrue(servicepr.getById(999999996L).getNombre().equals("JUnitTest"));

	}

	@Test
	@Order(4)
	void eliminarPersonaTest() {
		System.out.println("Eliminando Persona Test");
		Optional<Persona> po = Optional.of(servicepr.getById(999999996L));
		if (po.isPresent()) {
			servicepr.delete(999999996L);
		}
		assertTrue(servicepr.getById(999999996L) == null);
	}
	
	@Test
	@Order(5)
	void crearVehiculoTest() {
		System.out.println("Creando Vehiculo Test");
		Vehiculo vh = new Vehiculo(999999996L,"vh1", "MatTest", "MarcaTest", "ModeloTest", 999999996L);
		servicevh.create(vh);

	}
	
	@Test
	@Order(6)
	void obtenerVehiculoTest() {
		System.out.println("Obteniendo Vehiculo Test");
		Optional<Vehiculo> po = Optional.of(servicevh.getById(999999996L));
		assertTrue(po.isPresent());
	}
	
	
	@Test
	@Order(7)
	void actualizarVehiculoTest() {
		System.out.println("Actualizando Vehiculo Test");
		Vehiculo p = servicevh.getById(999999996L);
		if (p != null) {
			p.setMarca("MarcaJunitTest");
			servicevh.update(p);
		}
		assertTrue(servicevh.getById(999999996L).getMarca().equals("MarcaJunitTest"));

	}
	
	@Test
	@Order(8)
	void eliminarVehiculoTest() {
		System.out.println("Eliminando Vehiculo Test");
		Optional<Vehiculo> po = Optional.of(servicevh.getById(999999996L));
		if (po.isPresent()) {
			servicevh.delete(999999996L);
		}
		assertTrue(servicevh.getById(999999996L) == null);
	}
	
}
