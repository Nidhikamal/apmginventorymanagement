package com.bourntec.apmg.inventorymanagement.v1.service.impl;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bourntec.apmg.entity.LibraryItem;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.LibraryItemRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.LibraryItemResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.ImageItemRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.ImageUplodeOption;
import com.bourntec.apmg.inventorymanagement.v1.service.LibraryItemService;
import com.bourntec.apmg.inventorymanagement.v1.utils.DateUtils;

/**
 * 
 * Service class implementation for libray image upload and read
 * 
 * @author Babuv
 *
 */
@Service(value = "LibraryItemServiceImpl")
public class LibraryItemServiceImpl implements LibraryItemService {

	private static final Logger logger = LogManager.getLogger(LibraryItemServiceImpl.class);

	@Autowired
	ImageItemRepository imageItemRepository;
	@Autowired
	ImageUplodeOption imageUplodeOption;
	
	@Value("${image.path}")
	private String imagePath;

	@Override
	public LibraryItemResponseDTO saveLibraryItem(List<LibraryItemRequestDTO> reqDTO) throws Exception {
		LibraryItemResponseDTO iibraryItemResponseDTO = new LibraryItemResponseDTO();
		/*
		 * List<LibraryItemRequestDTO> reqDTO1 = new ArrayList<>();
		 * LibraryItemResponseDTO iibraryItemResponseDTO = new LibraryItemResponseDTO();
		 * // Testing LibraryItemRequestDTO dt1 = new LibraryItemRequestDTO();
		 * MultipartFile n1 = new MultipartFile() {
		 * 
		 * @Override public void transferTo(File dest) throws IOException,
		 * IllegalStateException { // TODO Auto-generated method stub
		 * 
		 * }
		 * 
		 * @Override public boolean isEmpty() { // TODO Auto-generated method stub
		 * return false; }
		 * 
		 * @Override public long getSize() { // TODO Auto-generated method stub return
		 * 0; }
		 * 
		 * @Override public String getOriginalFilename() { // TODO Auto-generated method
		 * stub return "kid.JPG"; }
		 * 
		 * @Override public String getName() { // TODO Auto-generated method stub return
		 * null; }
		 * 
		 * @Override public InputStream getInputStream() throws IOException { // TODO
		 * Auto-generated method stub File initialFile = new File("E:\\\\kid.JPG");
		 * InputStream targetStream = new FileInputStream(initialFile);
		 * 
		 * return targetStream; }
		 * 
		 * @Override public String getContentType() { // TODO Auto-generated method stub
		 * return null; }
		 * 
		 * public byte[] getBytes() throws IOException { File fil = new
		 * File("E:\\kid.JPG"); byte[] fileContent = Files.readAllBytes(fil.toPath());
		 * 
		 * return fileContent; } }; dt1.setFile(n1); reqDTO1.add(dt1);
		 * System.out.println("reqDTO1 ==========================" + reqDTO1);
		 */		// End
		logger.info("Entering saveLibraryItem method");
		try {
			for (LibraryItemRequestDTO libraryItemRequestDTO : reqDTO) {
				String itemCode = libraryItemRequestDTO.getItemCode();
				MultipartFile file = libraryItemRequestDTO.getFile();
				logger.info("file =" + file);
				String imageBase = imagePath+"inventory/";

				imageBase = imageBase + itemCode + "/";
				libraryItemRequestDTO.setItemCode(itemCode);

				String actualFilename = DateUtils.getCurrentTime() + "Actual_" + file.getOriginalFilename();
				libraryItemRequestDTO.setActualImage(imageBase + "/" + actualFilename);

				imageUplodeOption.actualImageUpload(imageBase, file, actualFilename);
				imageUplodeOption.shortImageUpload(imageBase, file, actualFilename);
				libraryItemRequestDTO.setShortImage(
						imageBase + "/" + DateUtils.getCurrentTime() + "Short_" + file.getOriginalFilename());
				LibraryItem libraryItem = libraryItemRequestDTO.toModel(libraryItemRequestDTO);

				LibraryItem libraryItemEntity = imageItemRepository.save(libraryItem);
			}
			iibraryItemResponseDTO.setResponseMessage("Library Items saved successfully.");
		} catch (Exception e) {
			logger.error("Save: library Data  error " + e);
			throw e;
		}
		logger.info("Exit saveLibraryItem method");
		return iibraryItemResponseDTO;
	}

	@Override
	public LibraryItemResponseDTO updateLibraryItem(List<LibraryItemRequestDTO> reqDTO, String itemCode)
			throws Exception {
		logger.info("Enter updateLibraryItem method");
		List<LibraryItem> libItemist = imageItemRepository.findByItemCode(itemCode);
		libItemist.forEach((libObj) -> {
			imageItemRepository.delete(libObj);
		});
		LibraryItemResponseDTO resDto = saveLibraryItem(reqDTO);
		logger.info("Exit updateLibraryItem method");
		return resDto;
	}

	@Override
	public List<LibraryItemResponseDTO> getLibraryItemById(String itemCode) {

		List<LibraryItemResponseDTO> lstResp = new ArrayList<>();

		List<LibraryItem> libItemist = imageItemRepository.findByItemCode(itemCode);
		libItemist.forEach((libObj) -> {
			LibraryItemResponseDTO respDTO = new LibraryItemResponseDTO();
			String shortImagepath = libObj.getShortImage();
			try {
				byte[] imageArray = imageUplodeOption.shortReadImage(shortImagepath);
				respDTO.setShortImageArray(imageArray);
				respDTO.setLibraryId(libObj.getLibraryId());
				respDTO.setItemCode(libObj.getItemCode());
			} catch (IOException e) {
				e.printStackTrace();
			}
			lstResp.add(respDTO);
		});

		return lstResp;
	}

	@Override
	public byte[] readActualImage(int libId) {
		Optional<LibraryItem> libItem = imageItemRepository.findById(String.valueOf(libId));
		if (libItem.isPresent()) {
			LibraryItem libraryItem = libItem.get();
			String imagepath = libraryItem.getActualImage();
			try {
				byte[] imageArray = imageUplodeOption.actualReadImage(imagepath);
				return imageArray;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

}
