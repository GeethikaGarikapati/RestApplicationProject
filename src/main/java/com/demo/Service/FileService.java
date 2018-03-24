package com.demo.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

	// replace this path with required destination path where you want to upload
	// the files
	private static String DESTINATION_PATH = "C://Users//Geeta//hello//";

	public boolean isFileUploaded(MultipartFile fileName) {

		boolean result = false;

		try {
			File path = new File(DESTINATION_PATH);
			if (!path.exists()) {
				result = false; // path doesn't exist
			} else {
				File file = new File(DESTINATION_PATH + fileName.getOriginalFilename());
				file.createNewFile();
				FileOutputStream fout = new FileOutputStream(file);
				fout.write(fileName.getBytes());
				fout.close();
				result = true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}
}
