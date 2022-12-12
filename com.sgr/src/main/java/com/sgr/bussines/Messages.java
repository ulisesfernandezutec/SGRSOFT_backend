package com.sgr.bussines;

import lombok.Data;

@Data
public class Messages {
	private Messages(){

	}

	//Collections
	public static final String PERSONAS = "Persona";
	public static final String RUTA = "Ruta";
	public static final String RUTAP = "Ruta Punto";
	public static final String RUTAPE = "Ruta Punto Estado";
	public static final String PUNTOS_DR = "Puntos De Recoleccion";
	public static final String PUNTOS_DP = "Puntos De Partida";
	public static final String PUNTOS_DL = "Puntos De LLegada";
	public static final String ROL = "Rol";
	public static final String TIPO_RESIDUO = "Tipo De Residuo";
	public static final String USUARIO = "Usuario";
	public static final String VEHICULOS = "Vehiculo";
	public static final String ZONA = "Zona";
	public static final String TOKEN 	= "Token";
	public static final String MSG 		= "Msg";
	public static final String PUNTOMAPA 		= "Punto Mapa";
	public static final String PUNTODRE 		= "Punto de Recolleción Estado";

	//Messages
	public static final String PERSONA_NOT_FOUND = "No se encuentra el registro";
	public static final String PER_NOT_FOUND = "No se encuentra el registro id: %s de Punto de Persona";
	public static final String USR_CREADO = "Usuario creado con id ";
	public static final String USR_ELIMINADO = "Usuario eliminado";
	public static final String TR_CREADO = "Tipo de Residuo creado";
	public static final String ROL_CREADO = "Rol creado";
	public static final String PNT_CREADO = "Punto Mapa creado";
	public static final String PNS_CREADO = "Punto Salida creado";
	public static final String PNS_ELIMINADO = "Punto Salida eliminado";
	public static final String RPE_CREADO = "Ruta Punto Estado creado";
	public static final String RPE_ELIMINADO = "Ruta Punto Estado eliminado";
	public static final String RP_CREADO = "Ruta Punto creado";
	public static final String RP_ELIMINADO = "Ruta Punto eliminado";
	public static final String RT_CREADO = "Ruta creadA";
	public static final String RT_ELIMINADO = "Ruta eliminadA";
	public static final String PNT_ELIMINADO = "Punto Mapa eliminado";
	public static final String PDF_CREADO = "Punto Disposición Final creado";
	public static final String PDF_ELIMINADO = "Punto Disposición Final eliminado";
	public static final String ROL_ELIMINADO = "Rol eliminado";
	public static final String TR_ELIMINADO = "Tipo de Residuo eliminado";
	public static final String PDR_NOT_FOUND = "No se encuentra el registro id: %s de Punto de Recolección";
	public static final String PTR_NOT_FOUND = "No se encuentra el registro id: %s de Punto de Tipo de Residuo";
	public static final String ROL_NOT_FOUND = "No se encuentra el registro id: %s de Rol";
	public static final String EMAIL_SEND = "Mensaje enviado a";
	public static final String EMAIL_ERROR = "Error al enviar mensaje a";
	public static final String EMAIL_INVALID ="Email inválido";
	public static final String EMAIL_EXIST = "Email ya existe";
	public static final String CREATE_ERROR = "Error al crear ";
	public static final String UPDATE_ERROR = "Error al actualziar ";
	public static final String DELETE_ERROR = "Error al borrar ";
	public static final String READ_ERROR = "Error al leer ";
	public static final String ERROR = "Error";
	public static final String ACTIVE = "SGR Soft - Activar Usuario";





}
