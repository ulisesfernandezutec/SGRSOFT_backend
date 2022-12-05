package com.sgr.bussines;

import lombok.Data;

@Data
public class Messages {
	private Messages(){

	}

	//Collections
	public static final String COL_PERSONAS = "Personas";
	public static final String COL_PUNTOS_DR = "PuntosDR";
	public static final String COL_ROLES = "Roles";
	public static final String COL_TIPO_RESIDUO = "TipoDeResiduo";
	public static final String COL_USUARIOS = "Usuarios";
	public static final String COL_VEHICULOS = "Vehiculos";
	public static final String COL_ZONAS = "Zonas";
	//Names
	public static final String TOKEN 	= "Token";
	public static final String MSG 		= "Msg";
	//Messages
	public static final String PERSONA_NOT_FOUND = "No se encuentra el registro id: %s de Persona";
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

}
