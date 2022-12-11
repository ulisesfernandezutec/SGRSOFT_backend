package sgr.com.sgr;

import java.util.*;

import com.sgr.api.interfaces.impl.*;
import com.sgr.api.interfaces.service.EmailService;
import com.sgr.bussines.Messages;
import com.sgr.bussines.security.SecurityBussines;
import com.sgr.bussines.security.SecurityGoogleTokenVerifier;
import com.sgr.entities.*;

import com.sgr.entities.google.GoogleBound;
import com.sgr.entities.google.GoogleDistance;
import com.sgr.entities.google.GoogleDuration;
import lombok.extern.log4j.Log4j2;

import net.bytebuddy.matcher.FilterableList;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;

@Log4j2
@SpringBootTest
@SpringBootConfiguration
@ComponentScan(basePackages = { "com.sgr" })
@TestMethodOrder(OrderAnnotation.class)

class ApplicationTests {
	String test = "TEST >";
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
	@Autowired
	PuntoDisposicionFinalServiceImplement puntofinalservice;
	@Autowired
	PuntoMapaServiceImplement puntomapaservice;
	@Autowired
	PuntoRecoleccionServiceImplement puntorecoleccionservice;
	@Autowired
	PuntoSalidaServiceImplement puntoSalidaServiceImplement;
	@Autowired
	RutaServiceImplement rutaServiceImplement;
	@Autowired
	RutaPuntoServiceImplement rutaPuntoServiceImplement;
	@Autowired
	RutaPuntoEstadoServiceImplement rutaPuntoEstadoServiceImplement;
	@Autowired
	EmailServiceImplement emailServiceImplement;

	// TEST DE USUARIOS
	@Test
	@Order(1)
	void createUsuario() {
		log.info(test+"Creando Usuario Test");
		// Usuario tp = new Usuario(999999996L,);
		Usuario usr = new Usuario(999999996L, "apiId", null, "nombre", "apellido", "documento", "telefono", "email", "direccion","estado");
		usuario.create(usr);
	}

	@Test
	@Order(2)
	void getUsuarioTest() {
		log.info(test+" > Obteniendo Usuario Test");
		Optional<Usuario> po = Optional.of(usuario.getById(999999996L));
		assertTrue(po.isPresent());
	}

	@Test
	@Order(3)
	void updateUsuarioTest() {
		log.info(test+" > Actualizando Usuario Test");
		Usuario p = usuario.getById(999999996L);
		if (p != null) {
			p.setNombre(var);
			usuario.update(p);
		}
		assertEquals(var, usuario.getById(999999996L).getNombre());

	}

	@Test
	@Order(4)
	void deleteUsuario() {
		log.info(test+" > Eliminando Persona Test");
		Optional<Usuario> po = Optional.of(usuario.getById(999999996L));
		if (po.isPresent()) {
			usuario.delete(999999996L);
		}
		assertNull(usuario.getById(999999996L));
	}

	// TEST PUNTOS DE RECOLECCIÓN ESTADO
	@Test
	@Order(5)
	void createpdreTest() {
		log.info(test+" > Creando Punto de Recolección Estado Test");
		PuntoRecoleccionEstado pr = new PuntoRecoleccionEstado(999999996L, "22/05/1986", 1L, "Estado", "Estado");
		puntorecoleccionestado.create(pr);
		Optional<PuntoRecoleccionEstado> pdre = Optional.of(puntorecoleccionestado.getById(999999996L));
		assertTrue(pdre.isPresent());
	}

	@Test
	@Order(6)
	void getpdreTest() {
		log.info(test+" > Obteniendo Punto de Recolección Estado Test");
		Optional<PuntoRecoleccionEstado> pdre = Optional.of(puntorecoleccionestado.getById(999999996L));
		assertTrue(pdre.isPresent());
	}

	@Test
	@Order(7)
	void updatepdreTest() {
		log.info(test+" > Actualizando Punto de Recolección Estado Test");
		String det = "Esto es un datalle de prueba";
		PuntoRecoleccionEstado p = puntorecoleccionestado.getById(999999996L);
		if (p != null) {
			p.setDetalle(det);
			puntorecoleccionestado.update(p);
		}
		Optional<PuntoRecoleccionEstado> po = Optional.of(puntorecoleccionestado.getById(999999996L));
		assertEquals(det, po.get().getDetalle());
	}

	@Test
	@Order(8)
	void deletepdreTest() {
		log.info(test+" > Eliminando Punto de Recolección Estado Test");
		Optional<PuntoRecoleccionEstado> po = Optional.of(puntorecoleccionestado.getById(999999996L));
		if (po.isPresent()) {
			puntorecoleccionestado.delete(999999996L);
		}
		assertNull(puntorecoleccionestado.getById(999999996L));
	}

	// TEST VEHICULOS
	@Test
	@Order(9)
	void createVehiculosTest() {
		log.info(test+" > Creando Vehiculo Test");
		Vehiculo vh = new Vehiculo(999999996L, "vh1", "MatTest", "MarcaTest", "ModeloTest", 999999996L);
		vehiculo.create(vh);

	}

	@Test
	@Order(10)
	void getVehiculosTest() {
		log.info(test+" > Obteniendo Vehiculo Test");
		Optional<Vehiculo> po = Optional.of(vehiculo.getById(999999996L));
		assertTrue(po.isPresent());
	}

	@Test
	@Order(11)
	void updateVehiculosTest() {
		log.info(test+" > Actualizando Vehiculo Test");
		Vehiculo p = vehiculo.getById(999999996L);
		if (p != null) {
			p.setMarca(var);
			vehiculo.update(p);
		}
		assertEquals(var, vehiculo.getById(999999996L).getMarca());
	}
	@Test
	@Order(12)
	void deleteVehiculosTest() {
		log.info(test+" > Eliminando Vehiculo Test");
		Optional<Vehiculo> po = Optional.of(vehiculo.getById(999999996L));
		if (po.isPresent()) {
			vehiculo.delete(999999996L);
		}
		assertNull(vehiculo.getById(999999996L));
	}

	// TEST TIPO DE RESIDUO
	@Test
	@Order(13)
	void crearTipoR() {
		log.info(test+" > Creando Tipo de Residuo Test");
		TipoDeResiduo tr = new TipoDeResiduo(999999996L, "Tipo1");
		tiporesiduo.create(tr);

	}

	@Test
	@Order(14)
	void obtenerTipoR() {
		log.info(test+" > Obteniendo Tipo de Residuo Test");
		Optional<TipoDeResiduo> po = Optional.of(tiporesiduo.getById(999999996L));
		assertTrue(po.isPresent());
	}

	@Test
	@Order(15)
	void actualizarTipoR() {
		log.info(test+" > Actualizando Tipo de Residuo Test");
		TipoDeResiduo p = tiporesiduo.getById(999999996L);
		if (p != null) {
			p.setNombre(var);
			tiporesiduo.update(p);
		}
		assertEquals(var, tiporesiduo.getById(999999996L).getNombre());

	}

	@Test
	@Order(16)
	void eliminarTipoR() {
		log.info(test+" > Eliminando Tipo de Residuo Test");
		Optional<TipoDeResiduo> po = Optional.of(tiporesiduo.getById(999999996L));
		if (po.isPresent()) {
			tiporesiduo.delete(999999996L);
		}
		assertNull(tiporesiduo.getById(999999996L));
	}

	// TEST PUNTO DE RECOLLECION
	@Test
	@Order(17)
	void createpdrTest() {
		log.info(test+" > Creando Punto de Recolección Test");
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
		log.info(test+" > Obtener Punto de Recolección Test");
		Optional<PuntoRecoleccion> po = Optional.of(puntoderecoleccion.getById(999999996L));
		assertTrue(po.isPresent());
	}

	@Test
	@Order(19)
	void updatepdrTest() {
		log.info(test+" > Actualizando Punto de Recolección Test");
		String desc = "Descripcion";
		PuntoRecoleccion p = puntoderecoleccion.getById(999999996L);
		if (p != null) {
			p.setDescripcion(desc);
			puntoderecoleccion.update(p);
		}
		assertEquals(desc, puntoderecoleccion.getById(999999996L).getDescripcion());
	}

	@Test
	@Order(20)
	void deletepdrTest() {
		log.info(test+" > Eliminando Punto de Recolección Test");
		Optional<PuntoRecoleccion> po = Optional.of(puntoderecoleccion.getById(999999996L));
		if (po.isPresent()) {
			puntoderecoleccion.delete(999999996L);
		}
		assertNull(puntoderecoleccion.getById(999999996L));
	}

	// TEST DE ROL
	@Test
	@Order(21)
	void createRol() {
		log.info(test+" > Creando Rol Test");
		Rol rol = new Rol(999999996L, "Nuevo Rol");
		rolservice.create(rol);
	}

	@Test
	@Order(22)
	void getRolTest() {
		log.info(test+" > Obteniendo Rol Test");
		Optional<Rol> po = Optional.of(rolservice.getById(999999996L));
		assertTrue(po.isPresent());
	}

	@Test
	@Order(23)
	void updateRol() {
		log.info(test+" > Actualizando Rol Test");
		String test = "Nuevo test";
		Rol r = rolservice.getById(999999996L);
		if (r != null) {
			r.setNombre(test);
			rolservice.update(r);
		}
		assertEquals(test, rolservice.getById(999999996L).getNombre());
	}

	@Test
	@Order(24)
	void deleteRol() {
		log.info(test+" > Eliminando Rol Test");
		Optional<Rol> po = Optional.of(rolservice.getById(999999996L));
		if (po.isPresent()) {
			rolservice.delete(999999996L);
		}
		assertNull(rolservice.getById(999999996L));
	}
	
	// CREAR USUARIOS TEST
	@Test
	@Order(25)
	void findUsuarioByName() {
		log.info(test+" > Buscando usuario por email Test");
		String email = "test"+1+"@test.com";
		Optional<Usuario> op = usuario.findFirstByEmailLike(email);
		if(!op.isPresent()) {
			Usuario usr = new Usuario(1L, "apiId", new Rol(1, "ADMIN"), "nombre", "apellido", "documento", "telefono",
					email, "direccion", "estado");
			usuario.create(usr);
			op = usuario.findFirstByEmailLike(email);
		}
		assertTrue(op.isPresent());
	}
	
	@Test
	@Order(26)
	void createUsuario0() {
		log.info(test+" > Buscando usuario por email Test");
		String email = "test"+2+"@test.com";
		Optional<Usuario> op = usuario.findFirstByEmailLike(email);
		if(!op.isPresent()) {
			Usuario usr = new Usuario(1L, "username2", new Rol(2, "USER"), "nombre", "apellido", "documento", "telefono",
					email, "direccion","estado");
			usuario.create(usr);
			op = usuario.findFirstByEmailLike(email);
		}
		assertTrue(op.isPresent());
	}
	
	@Test
	@Order(27)
	void createUsuario1() {
		log.info(test+" > Buscando usuario por email Test");
		String email = "test"+3+"@test.com";
		Optional<Usuario> op = usuario.findFirstByEmailLike(email);
		if(!op.isPresent()) {
			Usuario usr = new Usuario(1L, "apiId", new Rol(3, "CHOFER"), "nombre", "apellido", "documento", "telefono",
					email, "direccion", "estado");
			usuario.create(usr);
			op = usuario.findFirstByEmailLike(email);
		}
		assertTrue(op.isPresent());
	}
	@Test
	@Order(27)
	void createUsuario2() {
		log.info(test+" > Buscando usuario por email Test");
		String email = "test"+3+"@test.com";
		Optional<Usuario> op = usuario.findFirstByEmailLike(email);
		if(!op.isPresent()) {
			Usuario usr = new Usuario(1L, "apiId", new Rol(3, "CHOFER"), "nombre", "apellido", "documento", "telefono",
					email, "direccion","estado");
			usuario.create(usr);
			op = usuario.findFirstByEmailLike(email);
		}
		assertTrue(op.isPresent());
	}

	@Test
	@Order(28)
	void findUsuarioByEmail() {
		String u = "test2@test.com";
		log.info(test+" > Buscando usuario por username "+u);
		Optional<Usuario> op = usuario.findFirstByEmailLike(u);
		if(!op.isPresent()) {

			Usuario usr = new Usuario(1L, "apiId", new Rol(3, "CHOFER"), "nombre", "apellido", "documento", "telefono", "test@i123.com", "direccion","estado");
			usuario.create(usr);
			op = usuario.findFirstByEmailLike(u);
		}
		assertTrue(op.isPresent());
	}

	@Test
	@Order(29)
	void getTokenInfo() {
		Boolean r = SecurityBussines.chekTockenExp("eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJiODdkZjY3Mi0xNjYyLTQ2ZDMtODI0Mi00ZGUzODM5NjM1NDUiLCJzdWIiOiJ1c2VybmFtZTEwIiwiYXV0aG9yaXRpZXMiOlsiVVNFUiJdLCJpYXQiOjE2NjgzODQ0MDcsIkVtYWlsIjoidGVzdEBpMTIzLmNvbSIsImV4cCI6MTY2ODM4NTAwN30.T2xs_XvJbazp3O4Nq_5HeMgTn1YjnG4A8VMdjFVpgGvFCeCNAatwRwG1UlqLn7jpxr5OzfuLc7R9wifz4Unn4w");
		assertEquals(false,r);
	}
	@Test
	@Order(30)
	void checkGoogleToken() {
		log.info(test+" > Checkeando verificador de google token");
		String gtoken = "";
		String msg = "invalid_token";
		gtoken = gtoken.replace("token=", "");
		APOD resp = SecurityGoogleTokenVerifier.verificar(gtoken);
		assertEquals(msg, resp.getError());
	}
	@Test
	@Order(31)
	void createPuntoDeDisposiciónFinal() {
		log.info(test+" > Creando Punto de Disposición Final Test");
		PuntoDisposicionFinal pdf = new PuntoDisposicionFinal();
		pdf.set_id(999999996L);
		pdf.setLongitud(33.5);
		pdf.setLatitud(33.5);
		pdf.setDescripcion("Test case");
		pdf.setEnRuta(true);
		List<TipoDeResiduo> tiposDeResiduo = new ArrayList<>();
		tiposDeResiduo.add(new TipoDeResiduo(999999996L, "Test Tipo de residuo"));
		pdf.setTipos(tiposDeResiduo);
		pdf.setDireccion("Test Dirección");
		PuntoDisposicionFinal pdftest = puntofinalservice.create(pdf);
		assertEquals(999999996L,pdftest.get_id());
	}
	@Test
	@Order(32)
	void findPuntoDeDisposiciónFinal() {
		log.info(test+" > Obteniendo Punto de Disposición Final Test");
		assertEquals(999999996L,puntofinalservice.getById(999999996L).get_id());
	}
	@Test
	@Order(33)
	void updatePuntoDeDisposiciónFinal() {
		log.info(test+" > Actualizando Punto de Disposición Final Test");
		PuntoDisposicionFinal pdf = puntofinalservice.getById(999999996L);
		pdf.setEnRuta(false);
		puntofinalservice.update(pdf);
		assertFalse(puntofinalservice.getById(999999996L).isEnRuta());
	}
	@Test
	@Order(34)
	void deletePuntoDeDisposiciónFinal() {
		log.info(test+" > Eliminando Punto de Disposición Final Test");
		puntofinalservice.delete(999999996L);
		assertNull(puntofinalservice.getById(999999996L));
	}
	@Test
	@Order(35)
	void createPuntoMapa() {
		log.info(test+" > Creando Punto Mapa");
		PuntoMapa pm = new PuntoMapa();
		pm.set_id(999999996L);
		pm.setLongitud(55.5);
		pm.setLatitud(33.5);
		pm.setDescripcion("Test case");
		pm.setEnRuta(true);
		pm.setDireccion("Ruta 1234");
		PuntoMapa puntoMapa = puntomapaservice.create(pm);
		assertEquals(999999996L,puntoMapa.get_id());
	}
	@Test
	@Order(36)
	void findPuntoMapa() {
		log.info(test+" > Obteniendo Punto Mapa");
		assertEquals(999999996L,puntomapaservice.getById(999999996L).get_id());
	}
	@Test
	@Order(37)
	void updatePuntoMapa() {
		log.info(test+" > Actualizando Punto Mapa");
		PuntoMapa pdf = puntomapaservice.getById(999999996L);
		pdf.setEnRuta(false);
		puntomapaservice.update(pdf);
		assertFalse(puntomapaservice.getById(999999996L).isEnRuta());
	}
	@Test
	@Order(38)
	void deletePuntoMapa() {
		log.info(test+" > Eliminando Punto Mapa");
		puntomapaservice.delete(999999996L);
		assertNull(puntomapaservice.getById(999999996L));
	}
	@Test
	@Order(39)
	void createPuntoDeRecolección() {
		log.info(test+" > Creando Punto de Recolección");
		PuntoRecoleccion pr = new PuntoRecoleccion();
		pr.set_id(999999996L);
		pr.setLongitud(55.5);
		pr.setLatitud(33.5);
		pr.setDescripcion("Test case");
		pr.setUsuario(999999996L);
		pr.setTipo(new TipoDeResiduo(999999996L, "Test"));
		pr.setDescripcion("Test");
		PuntoRecoleccionEstado pre = new PuntoRecoleccionEstado(999999996L, new Date().toString(), 999999996L, "En ruta", "Test");
		List<PuntoRecoleccionEstado> prel = new ArrayList<>();
		prel.add(pre);
		pr.setEstados(prel);
		PuntoRecoleccion puntoRecoleccion = puntorecoleccionservice.create(pr);
		assertEquals(999999996L,puntoRecoleccion.get_id());
	}
	@Test
	@Order(40)
	void findPuntoDeRecolección() {
		log.info(test+" > Obteniendo Punto de Recolección");
		assertEquals(999999996L,puntorecoleccionservice.getById(999999996L).get_id());
	}
	@Test
	@Order(41)
	void updatePuntoDeRecolección() {
		log.info(test+" > Actualizando Punto de Recolección");
		PuntoRecoleccion pr = puntorecoleccionservice.getById(999999996L);
		String nd = "Nueva dirección";
		pr.setDireccion(nd);
		puntorecoleccionservice.update(pr);
		assertEquals(puntorecoleccionservice.getById(999999996L).getDireccion(),nd);
	}
	@Test
	@Order(42)
	void deletePuntoRecolección() {
		log.info(test+" > Eliminando Punto de Recolección");
		puntorecoleccionservice.delete(999999996L);
		assertNull(puntorecoleccionservice.getById(999999996L));
	}
	@Test
	@Order(43)
	void createPuntoSalida() {
		log.info(test+" > Creando Punto de Salida");
		PuntoSalida ps = new PuntoSalida();
		ps.set_id(999999996L);
		ps.setLongitud(55.5);
		ps.setLatitud(33.5);
		ps.setDescripcion("Test case");
		ps.setEnRuta(true);
		ps.setDescripcion("Test");
		PuntoSalida pstest = puntoSalidaServiceImplement.create(ps);
		assertEquals(999999996L,pstest.get_id());
	}
	@Test
	@Order(44)
	void findPuntoSalida() {
		log.info(test+" > Obteniendo Punto de Salida");
		assertEquals(999999996L,puntoSalidaServiceImplement.getById(999999996L).get_id());
	}
	@Test
	@Order(45)
	void updatePuntoSalida() {
		log.info(test+" > Actualizando Punto de Salida");
		PuntoSalida puntoSalida = puntoSalidaServiceImplement.getById(999999996L);
		puntoSalida.setEnRuta(false);
		puntoSalidaServiceImplement.update(puntoSalida);
		assertFalse(puntoSalidaServiceImplement.getById(999999996L).isEnRuta());
	}
	@Test
	@Order(46)
	void deletePuntoSalida(){
		log.info(test+" > Eliminando Punto de Salida");
		puntoSalidaServiceImplement.delete(999999996L);
		assertNull(puntoSalidaServiceImplement.getById(999999996L));
	}
	@Test
	@Order(47)
	void createRuta() {
		log.info(test+" > Creando Ruta");
		Ruta ruta = new Ruta();
		ruta.set_id(999999996L);
		ruta.setNombre("Ruta1");
		ruta.setBound(new GoogleBound());
		List<RutaPunto> lista = null;
		ruta.setPuntos(lista);
		ruta.setChofer(usuario.findFirstByEmailLike("test1@test.com").get());
		ruta.setVehiculo(new Vehiculo(999999996L, "VehiculoTest", "MAT1234", "Marca", "Modelo", 999999996L));
		Ruta rstest = rutaServiceImplement.create(ruta);
		assertEquals(999999996L,rstest.get_id());
	}
	@Test
	@Order(48)
	void findRuta() {
		log.info(test+" > Obteniendo Ruta");
		assertEquals(999999996L,rutaServiceImplement.getById(999999996L).get_id());
	}
	@Test
	@Order(49)
	void updateRuta() {
		log.info(test+" > Actualizando Ruta");
		String nombre = "Ruta 25";
		Ruta ruta = rutaServiceImplement.getById(999999996L);
		ruta.setNombre(nombre);
		rutaServiceImplement.update(ruta);
		assertEquals(rutaServiceImplement.getById(999999996L).getNombre(), nombre);
	}
	@Test
	@Order(50)
	void deleteRuta(){
		log.info(test+" > Eliminando Ruta");
		rutaServiceImplement.delete(999999996L);
		assertNull(rutaServiceImplement.getById(999999996L));
	}
	@Test
	@Order(51)
	void createRP() {
		log.info(test+" > Creando Ruta Punto");
		RutaPunto rutap = new RutaPunto();
		rutap.set_id(999999996L);
		rutap.setPunto(new PuntoMapa());
		RutaPuntoEstado rpe = new RutaPuntoEstado();
		rpe.set_id(999999996L);
		rpe.setNombre("RutaPuntoEstado test");
		rpe.setDescripcion("Nueva Desc");
		rutap.setEstado(rpe);
		rutap.setGoogleDistance(new GoogleDistance());
		rutap.setGoogleDuration(new GoogleDuration());
		RutaPunto ptest = rutaPuntoServiceImplement.create(rutap);
		assertEquals(999999996L,ptest.get_id());
	}
	@Test
	@Order(52)
	void findRP() {
		log.info(test+" > Obteniendo Ruta Punto");
		assertEquals(999999996L,rutaPuntoServiceImplement.getById(999999996L).get_id());
	}
	@Test
	@Order(53)
	void updateRP() {
		log.info(test+" > Actualizando Ruta Punto");
		String nombre = "Ruta 25";
		RutaPunto rutaPunto = rutaPuntoServiceImplement.getById(999999996L);
		RutaPuntoEstado rpe = rutaPunto.getEstado();
		rpe.setDescripcion(nombre);
		rutaPunto.setEstado(rpe);
		rutaPuntoServiceImplement.update(rutaPunto);
		assertEquals(rutaPuntoServiceImplement.getById(999999996L).getEstado().getDescripcion(), nombre);
	}
	@Test
	@Order(54)
	void deleteRP(){
		log.info(test+" > Eliminando Ruta Punto");
		rutaPuntoServiceImplement.delete(999999996L);
		assertNull(rutaPuntoServiceImplement.getById(999999996L));
	}
	@Test
	@Order(55)
	void createRPE() {
		log.info(test+" > Creando Ruta Punto Estado");
		RutaPuntoEstado rutaPuntoEstado = new RutaPuntoEstado();
		rutaPuntoEstado.set_id(999999996L);
		rutaPuntoEstado.setNombre("Nombre");
		rutaPuntoEstado.setDescripcion("Desc");
		RutaPuntoEstado rpetest = rutaPuntoEstadoServiceImplement.create(rutaPuntoEstado);
		assertEquals(999999996L,rpetest.get_id());
	}
	@Test
	@Order(56)
	void findRPE() {
		log.info(test+" > Obteniendo Ruta Punto Estado");
		assertEquals(999999996L,rutaPuntoEstadoServiceImplement.getById(999999996L).get_id());
	}
	@Test
	@Order(57)
	void updateRPE() {
		log.info(test+" > Actualizando Ruta Punto Estado");
		String nombre = "Nuevo nombre";
		RutaPuntoEstado ruta = rutaPuntoEstadoServiceImplement.getById(999999996L);
		ruta.setNombre(nombre);
		rutaPuntoEstadoServiceImplement.update(ruta);
		assertEquals(rutaPuntoEstadoServiceImplement.getById(999999996L).getNombre(), nombre);
	}
	@Test
	@Order(58)
	void deleteRPE(){
		log.info(test+" > Eliminando Ruta Punto Estado");
		rutaPuntoEstadoServiceImplement.delete(999999996L);
		assertNull(rutaPuntoEstadoServiceImplement.getById(999999996L));
	}
	@Test
	@Order(59)
	void email(){
		log.info(test+" > Enviando emails test");
		Email mail = new Email();
		mail.setMsgBody("Mensaje de prueba");
		mail.setRecipient("christopher.rodrigue@estudiantes.utec.edu.uy");
		mail.setSubject("Email Test desde SGRSoft");
		assertThat(emailServiceImplement.sendSimpleMail(mail), containsString(Messages.EMAIL_SEND));
	}
}
