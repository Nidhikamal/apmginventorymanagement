package com.bourntec.apmg.inventorymanagement.v1.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;
/**
 * 
 * @author Babu
 *common image upload interface
 */
public interface ImageUplodeOption {

	public boolean actualImageUpload(String path,MultipartFile multipartFile,String filename) throws IOException;
	public byte[] shortReadImage(String path) throws IOException;
	public byte[] actualReadImage(String path) throws IOException;
	boolean shortImageUpload(String path, MultipartFile file, String filename) throws IOException, Exception;
}
