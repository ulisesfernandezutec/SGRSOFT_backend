package SGR.com.sgr;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import com.sgr.api.*;
import com.sgr.bussines.Utils;
import com.sgr.entities.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@SpringBootConfiguration
@ComponentScan(basePackages = { "com.sgr" })
@TestMethodOrder(OrderAnnotation.class)
class ApplicationTests {
	String var = "Cambio de Información";

	@Autowired
	PersonaServiceImplement servicepr;
	@Autowired
	VehiculoServiceImplement servicevh;
	@Autowired
	PuntoDRServiceImplement servicepd;
	@Autowired
	TipoResiduoServiceImplement servicetr;
	@Autowired
	UsuarioServiceImplement serviceur;
	@Autowired
	RolServiceImplement servicerol;
	//TEST DE PERSONAS
	@Test
	@Order(1)
	void crearPersonaTest() {
		System.out.println("Creando Persona Test");
		Persona tp = new Persona(999999996L, "TestNombre", "TestApellido", "TestDireccion 555", "099099099", "ObservacionesTest", "OtrosTest");
		servicepr.create(tp);
	}

	@Test
	@Order(2)
	void obtenerPersonaTest() {
		System.out.println("Obteniendo Persona Test");
		Optional<Persona> po = Optional.of(servicepr.getById(Utils.intToLong(999999996)));
		assertTrue(po.isPresent());
	}

	@Test
	@Order(3)
	void actualizarPersonaTest() {
		System.out.println("Actualizando Persona Test");
		Persona p = servicepr.getById(999999996L);
		if (p != null) {
			p.setNombre(var);
			servicepr.update(p);
		}
		assertTrue(servicepr.getById(999999996L).getNombre().equals(var));

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
	//TEST PUNTOS DE RECOLECCIÓN
	@Test
	@Order(5)
	void crearPDRTest() {
		System.out.println("Creando Punto de Recolección Test");
		PuntoDR vh = new PuntoDR(999999996L, 999999996L, 999999996L, "TestCoordenadas");
		servicepd.create(vh);

	}
	
	@Test
	@Order(6)
	void obtenerPDRTest() {
		System.out.println("Obteniendo Punto de Recolección Test");
		Optional<PuntoDR> po = Optional.of(servicepd.getById(999999996L));
		assertTrue(po.isPresent());
	}
	
	
	@Test
	@Order(7)
	void actualizarPDRTest() {
		System.out.println("Actualizando Punto de Recolección Test");
		PuntoDR p = servicepd.getById(999999996L);
		if (p != null) {
			p.setCoordenadas(var);
			servicepd.update(p);
		}
		assertTrue(servicepd.getById(999999996L).getCoordenadas().equals(var));

	}
	
	@Test
	@Order(8)
	void eliminarPDRTest() {
		System.out.println("Eliminando Punto de Recolección Test");
		Optional<PuntoDR> po = Optional.of(servicepd.getById(999999996L));
		if (po.isPresent()) {
			servicepd.delete(999999996L);
		}
		assertTrue(servicepd.getById(999999996L) == null);
	}
	
	//TEST VEHICULOS
	@Test
	@Order(9)
	void crearVehiculoTest() {
		System.out.println("Creando Vehiculo Test");
		Vehiculo vh = new Vehiculo(999999996L,"vh1", "MatTest", "MarcaTest", "ModeloTest", 999999996L);
		servicevh.create(vh);

	}
	
	@Test
	@Order(10)
	void obtenerVehiculoTest() {
		System.out.println("Obteniendo Vehiculo Test");
		Optional<Vehiculo> po = Optional.of(servicevh.getById(999999996L));
		assertTrue(po.isPresent());
	}
	
	
	@Test
	@Order(11)
	void actualizarVehiculoTest() {
		System.out.println("Actualizando Vehiculo Test");
		Vehiculo p = servicevh.getById(999999996L);
		if (p != null) {
			p.setMarca(var);
			servicevh.update(p);
		}
		assertTrue(servicevh.getById(999999996L).getMarca().equals(var));

	}
	
	@Test
	@Order(12)
	void eliminarVehiculoTest() {
		System.out.println("Eliminando Vehiculo Test");
		Optional<Vehiculo> po = Optional.of(servicevh.getById(999999996L));
		if (po.isPresent()) {
			servicevh.delete(999999996L);
		}
		assertTrue(servicevh.getById(999999996L) == null);
	}
	//TEST TIPO DE RESIDUO
	@Test
	@Order(13)
	void crearTipoR() {
		System.out.println("Creando Tipo de Residuo Test");
		TipoDeResiduo tr = new TipoDeResiduo(999999996L,"Tipo1");
		servicetr.create(tr);

	}
	@Test
	@Order(14)
	void obtenerTipoR() {
		System.out.println("Obteniendo Tipo de Residuo Test");
		Optional<TipoDeResiduo> po = Optional.of(servicetr.getById(999999996L));
		assertTrue(po.isPresent());
	}
	@Test
	@Order(15)
	void actualizarTipoR() {
		System.out.println("Actualizando Tipo de Residuo Test");
		TipoDeResiduo p = servicetr.getById(999999996L);
		if (p != null) {
			p.setNombre(var);
			servicetr.update(p);
		}
		assertTrue(servicetr.getById(999999996L).getNombre().equals(var));

	}
	@Test
	@Order(16)
	void eliminarTipoR() {
		System.out.println("Eliminando Usuario Test");
		Optional<TipoDeResiduo> po = Optional.of(servicetr.getById(999999996L));
		if (po.isPresent()) {
			servicetr.delete(999999996L);
		}
		assertTrue(servicetr.getById(999999996L) == null);
	}
	//TEST USUARIO
	@Test
	@Order(17)
	void crearUsuario() {
		System.out.println("Creando Usuario Test");
		Usuario u = new Usuario(999999996L, "Usuario", "contraseña");
		serviceur.create(u);

	}

	@Test
	@Order(18)
	void obtenerUsuario() {
		System.out.println("Obteniendo Usuario Test");
		Optional<Usuario> po = Optional.of(serviceur.getById(999999996L));
		assertTrue(po.isPresent());
	}
	@Test
	@Order(19)
	void actualizarUsuario() {
		System.out.println("Actualizando Usuario Test");
		Usuario p = serviceur.getById(999999996L);
		if (p != null) {
			p.setUsuario(var);
			serviceur.update(p);
		}
		assertTrue(serviceur.getById(999999996L).getUsuario().equals(var));

	}
	@Test
	@Order(20)
	void eliminarUsuario() {
		System.out.println("Eliminando Usuario Test");
		Optional<Usuario> po = Optional.of(serviceur.getById(999999996L));
		if (po.isPresent()) {
			servicetr.delete(999999996L);
		}
		assertTrue(servicetr.getById(999999996L) == null);
	}
	//TEST ROL
	@Test
	@Order(21)
	void crearRol() {
		System.out.println("Creando Rol Test");
		Rol u = new Rol(999999996L, "Rol");
		servicerol.create(u);

	}
	@Test
	@Order(22)
	void obtenerRol() {
		System.out.println("Obteniendo Rol Test");
		Optional<Rol> po = Optional.of(servicerol.getById(999999996L));
		assertTrue(po.isPresent());
	}
	@Test
	@Order(23)
	void actualizarRol() {
		System.out.println("Actualizando Rol Test");
		Rol p = servicerol.getById(999999996L);
		if (p != null) {
			p.setNombre(var);
			servicerol.update(p);
		}
		assertTrue(servicerol.getById(999999996L).getNombre().equals(var));

	}
	@Test
	@Order(24)
	void eliminarRol() {
		System.out.println("Eliminando Rol Test");
		Optional<Rol> po = Optional.of(servicerol.getById(999999996L));
		if (po.isPresent()) {
			servicerol.delete(999999996L);
		}
		assertTrue(servicerol.getById(999999996L) == null);
	}
}
