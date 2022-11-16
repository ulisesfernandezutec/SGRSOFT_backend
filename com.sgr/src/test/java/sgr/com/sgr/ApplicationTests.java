package sgr.com.sgr;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sgr.api.*;
import com.sgr.bussines.security.SecurityBussines;
import com.sgr.entities.*;

import lombok.extern.log4j.Log4j2;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@Log4j2
@SpringBootTest
@SpringBootConfiguration
@ComponentScan(basePackages = { "com.sgr" })
@TestMethodOrder(OrderAnnotation.class)

class ApplicationTests {
	
	String var = "Cambio de Información";
	@Autowired
	UsuarioServiceImplement usuario;
	@Autowired
	PuntoRecoleccionEstadoServiceImplement puntorecoleccionestado;
	@Autowired
	VehiculoServiceImplement vehiculo;
	@Autowired
	PuntoRecoleccionServiceImplement puntoderecoleccion;
	@Autowired
	TipoResiduoServiceImplement tiporesiduo;
	@Autowired
	RolServiceImplement rolservice;

	// TEST DE USUARIOS
	@Test
	@Order(1)
	void createUsuario() {
		log.info("TEST > Creando Usuario Test");
		// Usuario tp = new Usuario(999999996L,);
		Usuario usr = new Usuario(999999996L, "username", "apiId", null, "nombre", "apellido", "documento", "telefono", "email", "direccion");
		usuario.create(usr);
	}

	@Test
	@Order(2)
	void getUsuarioTest() {
		log.info("TEST > Obteniendo Usuario Test");
		Optional<Usuario> po = Optional.of(usuario.getById(999999996L));
		assertTrue(po.isPresent());
	}

	@Test
	@Order(3)
	void updateUsuarioTest() {
		log.info("TEST > Actualizando Usuario Test");
		Usuario p = usuario.getById(999999996L);
		if (p != null) {
			p.setNombre(var);
			usuario.update(p);
		}
		assertTrue(usuario.getById(999999996L).getNombre().equals(var));

	}

	@Test
	@Order(4)
	void deleteUsuario() {
		log.info("TEST > Eliminando Persona Test");
		Optional<Usuario> po = Optional.of(usuario.getById(999999996L));
		if (po.isPresent()) {
			usuario.delete(999999996L);
		}
		assertTrue(usuario.getById(999999996L) == null);
	}

	// TEST PUNTOS DE RECOLECCIÓN ESTADO
	@Test
	@Order(5)
	void createpdreTest() {
		log.info("TEST > Creando Punto de Recolección Estado Test");
		PuntoRecoleccionEstado pr = new PuntoRecoleccionEstado(999999996L, "22/05/1986", 1L, "Estado", "Estado");
		puntorecoleccionestado.create(pr);
		Optional<PuntoRecoleccionEstado> pdre = Optional.of(puntorecoleccionestado.getById(999999996L));
		assertTrue(pdre.isPresent());
	}

	@Test
	@Order(6)
	void getpdreTest() {
		log.info("TEST > Obteniendo Punto de Recolección Estado Test");
		Optional<PuntoRecoleccionEstado> pdre = Optional.of(puntorecoleccionestado.getById(999999996L));
		assertTrue(pdre.isPresent());
	}

	@Test
	@Order(7)
	void updatepdreTest() {
		log.info("TEST > Actualizando Punto de Recolección Estado Test");
		String det = "Esto es un datalle de prueba";
		PuntoRecoleccionEstado p = puntorecoleccionestado.getById(999999996L);
		if (p != null) {
			p.setDetalle(det);
			puntorecoleccionestado.update(p);
		}
		Optional<PuntoRecoleccionEstado> po = Optional.of(puntorecoleccionestado.getById(999999996L));
		assertTrue(po.get().getDetalle().equals(det));
	}

	@Test
	@Order(8)
	void deletepdreTest() {
		log.info("TEST > Eliminando Punto de Recolección Estado Test");
		Optional<PuntoRecoleccionEstado> po = Optional.of(puntorecoleccionestado.getById(999999996L));
		if (po.isPresent()) {
			puntorecoleccionestado.delete(999999996L);
		}
		assertTrue(puntorecoleccionestado.getById(999999996L) == null);
	}

	// TEST VEHICULOS
	@Test
	@Order(9)
	void createVehiculosTest() {
		log.info("TEST > Creando Vehiculo Test");
		Vehiculo vh = new Vehiculo(999999996L, "vh1", "MatTest", "MarcaTest", "ModeloTest", 999999996L);
		vehiculo.create(vh);

	}

	@Test
	@Order(10)
	void getVehiculosTest() {
		log.info("TEST > Obteniendo Vehiculo Test");
		Optional<Vehiculo> po = Optional.of(vehiculo.getById(999999996L));
		assertTrue(po.isPresent());
	}

	@Test
	@Order(11)
	void updateVehiculosTest() {
		log.info("TEST > Actualizando Vehiculo Test");
		Vehiculo p = vehiculo.getById(999999996L);
		if (p != null) {
			p.setMarca(var);
			vehiculo.update(p);
		}
		assertTrue(vehiculo.getById(999999996L).getMarca().equals(var));

	}

	@Test
	@Order(12)
	void deleteVehiculosTest() {
		log.info("TEST > Eliminando Vehiculo Test");
		Optional<Vehiculo> po = Optional.of(vehiculo.getById(999999996L));
		if (po.isPresent()) {
			vehiculo.delete(999999996L);
		}
		assertTrue(vehiculo.getById(999999996L) == null);
	}

	// TEST TIPO DE RESIDUO
	@Test
	@Order(13)
	void crearTipoR() {
		log.info("TEST > Creando Tipo de Residuo Test");
		TipoDeResiduo tr = new TipoDeResiduo(999999996L, "Tipo1");
		tiporesiduo.create(tr);

	}

	@Test
	@Order(14)
	void obtenerTipoR() {
		log.info("TEST > Obteniendo Tipo de Residuo Test");
		Optional<TipoDeResiduo> po = Optional.of(tiporesiduo.getById(999999996L));
		assertTrue(po.isPresent());
	}

	@Test
	@Order(15)
	void actualizarTipoR() {
		log.info("TEST > Actualizando Tipo de Residuo Test");
		TipoDeResiduo p = tiporesiduo.getById(999999996L);
		if (p != null) {
			p.setNombre(var);
			tiporesiduo.update(p);
		}
		assertTrue(tiporesiduo.getById(999999996L).getNombre().equals(var));

	}

	@Test
	@Order(16)
	void eliminarTipoR() {
		log.info("TEST > Eliminando Tipo de Residuo Test");
		Optional<TipoDeResiduo> po = Optional.of(tiporesiduo.getById(999999996L));
		if (po.isPresent()) {
			tiporesiduo.delete(999999996L);
		}
		assertTrue(tiporesiduo.getById(999999996L) == null);
	}

	// TEST PUNTO DE RECOLLECION
	@Test
	@Order(17)
	void createpdrTest() {
		log.info("TEST > Creando Punto de Recolección Test");
		TipoDeResiduo tr = new TipoDeResiduo(1L, "Test");
		PuntoRecoleccionEstado estado = new PuntoRecoleccionEstado(999999996L, "Fecha", 999999996L, "Estado",
				"Detalles");
		List<PuntoRecoleccionEstado> estados = new ArrayList<>();
		estados.add(estado);
		PuntoRecoleccion pr = new PuntoRecoleccion(999999996L, tr, 1L, 22.5f, 22.5f, "Dirección", "Descripción",
				estados);
		puntoderecoleccion.create(pr);
	}

	@Test
	@Order(18)
	void getpdrTest() {
		log.info("TEST > Obtener Punto de Recolección Test");
		Optional<PuntoRecoleccion> po = Optional.of(puntoderecoleccion.getById(999999996L));
		assertTrue(po.isPresent());
	}

	@Test
	@Order(19)
	void updatepdrTest() {
		log.info("TEST > Actualizando Punto de Recolección Test");
		String desc = "Descripcion";
		PuntoRecoleccion p = puntoderecoleccion.getById(999999996L);
		if (p != null) {
			p.setDescripcion(desc);
			puntoderecoleccion.update(p);
		}
		assertTrue(puntoderecoleccion.getById(999999996L).getDescripcion().equals(desc));
	}

	@Test
	@Order(20)
	void deletepdrTest() {
		log.info("TEST > Eliminando Punto de Recolección Test");
		Optional<PuntoRecoleccion> po = Optional.of(puntoderecoleccion.getById(999999996L));
		if (po.isPresent()) {
			puntoderecoleccion.delete(999999996L);
		}
		assertTrue(puntoderecoleccion.getById(999999996L) == null);
	}

	// TEST DE ROL
	@Test
	@Order(21)
	void createRol() {
		log.info("TEST > Creando Rol Test");
		Rol rol = new Rol(999999996L, "Nuevo Rol");
		rolservice.create(rol);
	}

	@Test
	@Order(22)
	void getRolTest() {
		log.info("TEST > Obteniendo Rol Test");
		Optional<Rol> po = Optional.of(rolservice.getById(999999996L));
		assertTrue(po.isPresent());
	}

	@Test
	@Order(23)
	void updateRol() {
		log.info("TEST > Actualizando Rol Test");
		String test = "Nuevo test";
		Rol r = rolservice.getById(999999996L);
		if (r != null) {
			r.setNombre(test);
			rolservice.update(r);
		}
		assertTrue(rolservice.getById(999999996L).getNombre().equals(test));
	}

	@Test
	@Order(24)
	void deleteRol() {
		log.info("TEST > Eliminando Rol Test");
		Optional<Rol> po = Optional.of(rolservice.getById(999999996L));
		if (po.isPresent()) {
			rolservice.delete(999999996L);
		}
		assertTrue(rolservice.getById(999999996L) == null);
	}
	
	// CREAR USUARIOS TEST
	@Test
	@Order(25)
	void findUsuarioByName() {
		log.info("TEST > Buscando usuario por email Test");
		String email = "test"+1+"@test.com";
		Optional<Usuario> op = usuario.findFirstByEmailLike(email);
		if(!op.isPresent()) {
			Usuario usr = new Usuario(1L, "username1", "apiId", new Rol(1, "ADMIN"), "nombre", "apellido", "documento", "telefono",
					email, "direccion");
			usuario.create(usr);
			op = usuario.findFirstByEmailLike(email);
		}
		assertTrue(op.isPresent());
	}
	
	@Test
	@Order(26)
	void createUsuario0() {
		log.info("TEST > Buscando usuario por email Test");
		String email = "test"+2+"@test.com";
		Optional<Usuario> op = usuario.findFirstByEmailLike(email);
		if(!op.isPresent()) {
			Usuario usr = new Usuario(1L, "username2", "apiId", new Rol(2, "USER"), "nombre", "apellido", "documento", "telefono",
					email, "direccion");
			usuario.create(usr);
			op = usuario.findFirstByEmailLike(email);
		}
		assertTrue(op.isPresent());
	}
	
	@Test
	@Order(27)
	void createUsuario1() {
		log.info("TEST > Buscando usuario por email Test");
		String email = "test"+3+"@test.com";
		Optional<Usuario> op = usuario.findFirstByEmailLike(email);
		if(!op.isPresent()) {
			Usuario usr = new Usuario(1L, "username3", "apiId", new Rol(3, "CHOFER"), "nombre", "apellido", "documento", "telefono",
					email, "direccion");
			usuario.create(usr);
			op = usuario.findFirstByEmailLike(email);
		}
		assertTrue(op.isPresent());
	}
	
	@Test
	@Order(28)
	void createUsuario2() {
		log.info("TEST > Buscando usuario por email Test");
		String email = "test"+4+"@test.com";
		Optional<Usuario> op = usuario.findFirstByEmailLike(email);
		if(!op.isPresent()) {
			Usuario usr = new Usuario(1L, "username4", "apiId", new Rol(3, "CHOFER"), "nombre", "apellido", "documento", "telefono",
					email, "direccion");
			usuario.create(usr);
			op = usuario.findFirstByEmailLike(email);
		}
		assertTrue(op.isPresent());
	}
	
	@Test
	@Order(29)
	void createUsuario4() {
		log.info("TEST > Buscando usuario por email Test");
		String email = "test"+5+"@test.com";
		Optional<Usuario> op = usuario.findFirstByEmailLike(email);
		if(!op.isPresent()) {
			Usuario usr = new Usuario(1L, "username5", "apiId", new Rol(3, "CHOFER"), "nombre", "apellido", "documento", "telefono",
					email, "direccion");
			usuario.create(usr);
			op = usuario.findFirstByEmailLike(email);
		}
		assertTrue(op.isPresent());
	}
	
	@Test
	@Order(30)
	void findUsuarioByUsername() {
		String u = "username5";
		log.info("TEST > Buscando usuario por username "+u);
		Optional<Usuario> op = usuario.findFirstByEmailLike(u);
		if(!op.isPresent()) {
			Usuario usr = new Usuario(1L, u, "apiId", new Rol(3, "CHOFER"), "nombre", "apellido", "documento", "telefono", "test@i123.com", "direccion");
			usuario.create(usr);
			op = usuario.findFirstByEmailLike(u);
		}
		assertTrue(op.isPresent());
	}
	@Test
	@Order(31)
	void getTokenInfo() {
		Boolean r = SecurityBussines.chekTockenExp("eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJiODdkZjY3Mi0xNjYyLTQ2ZDMtODI0Mi00ZGUzODM5NjM1NDUiLCJzdWIiOiJ1c2VybmFtZTEwIiwiYXV0aG9yaXRpZXMiOlsiVVNFUiJdLCJpYXQiOjE2NjgzODQ0MDcsIkVtYWlsIjoidGVzdEBpMTIzLmNvbSIsImV4cCI6MTY2ODM4NTAwN30.T2xs_XvJbazp3O4Nq_5HeMgTn1YjnG4A8VMdjFVpgGvFCeCNAatwRwG1UlqLn7jpxr5OzfuLc7R9wifz4Unn4w");
		assertTrue(r==false);
	}
	
}
