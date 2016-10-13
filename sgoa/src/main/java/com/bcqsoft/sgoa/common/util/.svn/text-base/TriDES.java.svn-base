package com.bcqsoft.sgoa.common.util;

import java.security.NoSuchAlgorithmException;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class TriDES {

	// IV为3des加密解密所需要的明钥,在此默认为8个0
	private static byte[] iv = new byte[] { (byte) 0x00, (byte) 0x00,
			(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00,
			(byte) 0x00 };
	// 加密解密的方式
	private static String information = "DESEDE/ECB/PKCS5Padding";//
	/**
	 * 进行3DES加密,选择 DESEDE/CBC/PKCS5Padding 作为加密方式
	 * 
	 * @param keybyte	密钥，长度为24的byte数组类型，建议试用GetRandomkey()方法随机产生的
	 * @param src		需要加密的数据
	 * 
	 * @return			加密后的密文，如果加密失败返回null
	 * @throws  
	 * @throws Exception 
	 */
	public byte[] TriDES_Encrypt(byte[] keybyte, byte[] src) throws Exception {
		SecretKey deskey = new SecretKeySpec(keybyte, "DESede");
		// 加密
//		IvParameterSpec iv_param_spec = new IvParameterSpec(iv);
		
		Cipher cipher = Cipher.getInstance(information);
		cipher.init(Cipher.ENCRYPT_MODE, deskey);
		return cipher.doFinal(src);
	}
	
	
	
	/**
	 * 3DES解密函数原型,选择 DESEDE/CBC/PKCS5Padding 作为解密方式.其他3DES解密函数都是在
	 * 这个函数上扩展的
	 * 
	 * @param keybyte	密钥，长度为24的byte数组类型，由GetRandomkey()函数随机产生的
	 * @param src		需要解密的数据
	 * @return			解密后的明文，如果解密失败返回null
	 * @throws  
	 * @throws Exception 
	 */
	public byte[] TriDES_Decrypt(byte[] keybyte, byte[] src) throws Exception {

		SecretKey deskey = new SecretKeySpec(keybyte, "DESede");
		// 解密
//		IvParameterSpec iv_param_spec = new IvParameterSpec(iv);
		Cipher cipher = Cipher.getInstance(information);
		cipher.init(Cipher.DECRYPT_MODE, deskey);
		return cipher.doFinal(src);

	}
}
