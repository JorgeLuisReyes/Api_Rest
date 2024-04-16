package com.sybven.jwt.token.util;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class RSAEncryption {
	/*
	private static PrivateKey privateKey;
	private static PublicKey publicKey;

	//generarClaves
	public static void generarClaves() throws Exception {

		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(2048);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();

		// Obtener la clave pública y privada en formato String
		String publicKey = Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());
		String privateKey = Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded());

		// Imprimir las claves generadas
		System.out.println("Clave pública: " + publicKey);
		System.out.println("Clave privada: " + privateKey);
	}

	//obtenerPrivateKey
	public static String obtenerPrivateKey() {
		return privateKey.toString();
	}

	//obtenerPublicKey
	public static String obtenerPublicKey() {
		return publicKey.toString();
	}*/
	
	private static String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAx7srgPA2pBHJWH0O01jNrWFK5F0nR8QbwV+12NqEn24axMx2Ff8Faa2Kt32wOcH9DNAXl47AMctvEzrM18kobwS9MXkBw97juvlmZaEyI+q24O9mmoivWFdpWbICIUkRKU9xqeNWMSqLEp4gyF5ntvWZ8pLvZfquRp9uaC980IJ1T40527N++QzauXzvhnFbBLIln99NFB4O8sRuKBBM99TaEsl4SmwbHsYGUPN2Ew6N71ACzAUSZGwtUgqVUlrKUfixC69M4bNRmLueF75DG13R1i1Tex2y9+3Sg/wJQ82acZlHzZ3JG+yfWtAyP19XuAcIhjgYA0uUsWZx44X9swIDAQAB";
	private static String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDHuyuA8DakEclYfQ7TWM2tYUrkXSdHxBvBX7XY2oSfbhrEzHYV/wVprYq3fbA5wf0M0BeXjsAxy28TOszXyShvBL0xeQHD3uO6+WZloTIj6rbg72aaiK9YV2lZsgIhSREpT3Gp41YxKosSniDIXme29Znyku9l+q5Gn25oL3zQgnVPjTnbs375DNq5fO+GcVsEsiWf300UHg7yxG4oEEz31NoSyXhKbBsexgZQ83YTDo3vUALMBRJkbC1SCpVSWspR+LELr0zhs1GYu54XvkMbXdHWLVN7HbL37dKD/AlDzZpxmUfNnckb7J9a0DI/X1e4BwiGOBgDS5SxZnHjhf2zAgMBAAECggEAWlo6iN6h6UC+k9Am98bRbGB576qQTW/SmnzAl7PqkPDPHT3dIYA3I6JFAVLTeJ1f6v7r3TzPhvcfbVSJPAicyPQc3hd+i+v1myydfNYaB5NzXXgPM1Mn90+7sb7MJeCW6dgtdAwKfr1fInH0JJBIXMTn+osrzzdCxWH0IR9yWCQO57FPi2+OhZ1vTkrJ78JDSLiy4L9r9eXd9MCYLzebJeAUGdpD3cAIoGKQSoqqzYowouYlkFyFJNKMLYuJZWekwR1+sKlvfSx/BC2BFUfkdY1s7p5mHE1aYjyBcGaNKDZc8fPGi9p80W52a9DRDu2mv5UTBqb61I7OL87EuKoeKQKBgQDSEUaR2ECHFPHtMXJfSitkluZD1DaIdQEo7ZXiUVZ28jLSrkYIfQrVkCJ+5FCI4Em57kUM3vd1gmSuPnmZo1iCrWik3hKlIshqvubTOB1QfQ7gJMDHZnLwj8MN4bSv+Ssu7nS+OOCFo40Sw+Q8Lz5HR4eTEHigpkRsmyX6Mll0VwKBgQDzZ06vS3+GHZjTcGF2pTh5dtZcEi/UYtwaa5rNkc28hNUNjMia4cAqmprsOkuL8PQTtj1/N5SiCy1ryQGQ4yEJP7RXhnkWLm3mmDxZWhS6Kv+X7rh3yFa8TAJtsISOmw5HEfMh9NHpm2uG8JxbVfQqUzFDo4NWRz7CWEQtDnwIBQKBgQCl8wnZ24mWbSB1rhNZXeGL1H3R5cqy4CPrbk1y/aidzNYDg7NFr2qorfXiYoGQsAbuQGICOf4psbnRwP8VNWqNyWoanGkEVccYNPlqsTDPTgw7XC2DGNcCXb/MrpqsTd4kdDJ7t7j/OeYPhfs+5F+BtetPbbqtxsvVNHe7AJ2UfwKBgGdfE3q9DJ6vySzbCHlz98UWJDmb+7Yueh26X1c4ufB7VWRYywWEJLGzUWJL67O2FGKevgVeXIBpUNP63PBkla4w4O1fDePOuhv5wX+NE0pxYnVrC+rLKZL0kP92vQU3ctvaErD0IYYd3I/FdhIQMg8bn8uDEQ8+WLf+9o1QHnrlAoGAFTb5TcKECCbc2D+0kjEUR+Qe4wYdylddqz8CR/HlmKFkDyyTilPAujsenHpeMPTrMNjkI/Tx+8B+gC0lx4IYyYRNmRyGJsd/7eXMqlMp8XOp4XAo5Wo8jDnr/MUm4n6PmgcoPIuQ40e0Fx+s5y+onOriU7zWzFUGhX0NhvZA31A=";
	
	/**
	 * 
	 * @param mensaje
	 * @return cifrar
	 * @throws Exception
	 */
	public static String cifrar(String mensaje) throws Exception {
		byte[] publicKeyBytes = Base64.getDecoder().decode(RSAEncryption.publicKey);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKeyObj = keyFactory.generatePublic(keySpec);

		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, publicKeyObj);

		byte[] encryptedBytes = cipher.doFinal(mensaje.getBytes());
		return Base64.getEncoder().encodeToString(encryptedBytes);
	}

	/**
	 * 
	 * @param cifrado
	 * @return descifrar
	 * @throws Exception
	 */
	public static String descifrar(String cifrado) throws Exception {
		byte[] privateKeyBytes = Base64.getDecoder().decode(RSAEncryption.privateKey);
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privateKeyObj = keyFactory.generatePrivate(keySpec);

		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.DECRYPT_MODE, privateKeyObj);

		byte[] encryptedBytes = Base64.getDecoder().decode(cifrado);
		byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
		return new String(decryptedBytes);
	}

}
