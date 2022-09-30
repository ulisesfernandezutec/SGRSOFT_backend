package com.sgr.bussines;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.util.Base64;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Security {
	
	//Clase para encriptar la inforación utilizando Modo AES 128bit
	private SecretKey key;
	//Largo de la Secret Key
    private final int KEY_SIZE = 128;
    //Largo del total de bloques de información
    private final int DATA_LENGTH = 128;
    //Clase Java para cifrado
    private Cipher encryptionCipher;
    
    
    //Genera la secret Key para decriptar
    public void init() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(KEY_SIZE);
        key = keyGenerator.generateKey();
    }
    
	//Metodo encriptación
	public String encrypt(String data) throws Exception {
        byte[] dataInBytes 		= data.getBytes();
        encryptionCipher 		= Cipher.getInstance("AES/GCM/NoPadding");
        encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes 	= encryptionCipher.doFinal(dataInBytes);
        return encode(encryptedBytes);
    }
	
	//Método de decriptación
	public String decrypt(String encryptedData) throws Exception {
        byte[] dataInBytes 		= decode(encryptedData);
        Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec 	= new GCMParameterSpec(DATA_LENGTH, encryptionCipher.getIV());
        decryptionCipher.init(Cipher.DECRYPT_MODE, key, spec);
        byte[] decryptedBytes 	= decryptionCipher.doFinal(dataInBytes);
        return new String(decryptedBytes);
    }
	
    //Codifica en Base64
	private String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }
	
	//Decodifica desde Base64
    private byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }
    
}
