package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bourntec.apmg.inventorymanagement.v1.service.ImageUplodeOption;
import com.bourntec.apmg.inventorymanagement.v1.utils.DateUtils;
/**
 * 
 * @author Babu
 *Common image diskupload logic
 */
@Service(value = "DiskUploadServiceImpl")
@Qualifier("DiskUploadServiceImpl")
public class DiskUploadServiceImpl implements ImageUplodeOption {

	@Override
	public boolean shortImageUpload(String path, MultipartFile file, String filename) throws Exception {
		BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		img.createGraphics().drawImage(
				ImageIO.read(new File(path + filename)).getScaledInstance(100, 100, Image.SCALE_SMOOTH), 0, 0, null);
		ImageIO.write(img, "jpg", new File(path + DateUtils.getCurrentTime() + "Short_" + file.getOriginalFilename()));

		return false;
	}

	public void deleteDir(File dir) {
		File[] files = dir.listFiles();
		if (files != null) {
			for (final File file : files) {
				deleteDir(file);
			}
		}
		dir.delete();
	}

	@Override
	public boolean actualImageUpload(String path, MultipartFile file, String filename) throws IOException {
		byte[] bytes = file.getBytes();
		File file1 = new File(path);
		System.out.println("path-------------------" + path);
		boolean fileExists = file1.exists();
		deleteDir(file1);
		// if(!fileExists) {
		System.out.println("gggggggggggggg-------------------" + fileExists);
		// file1.delete();
		file1.mkdirs();
		// }

		Path pathData = Paths.get(path + filename);
		Files.write(pathData, bytes);

		return true;
	}

	@Override
	public byte[] shortReadImage(String imagePath) throws IOException {

		InputStream in = new BufferedInputStream(new FileInputStream(imagePath));
		if (in.available() > 0) {
			byte[] result = new byte[in.available()];
			in.read(result);
			return result;
		}

		return (byte[]) null;
	}

	@Override
	public byte[] actualReadImage(String imagePath) throws IOException {
		InputStream in = new BufferedInputStream(new FileInputStream(imagePath));
		if (in.available() > 0) {
			byte[] result = new byte[in.available()];
			in.read(result);
			return result;
		}

		return (byte[]) null;
	}

}
