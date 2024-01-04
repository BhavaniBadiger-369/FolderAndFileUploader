package com.folderupload;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FolderAndFileUpload {

	private static void uploadFolder(String sourceFolderPath, String destinationFolderPath) {
		File sourceFolder = new File(sourceFolderPath);
		File[] files = sourceFolder.listFiles();
		if (files != null) {
			for (File file : files) {
				if (file.isFile()) {
					uploadFile(file.getAbsolutePath(), destinationFolderPath);

				}
			}
		}
	}

	private static void uploadFile(String sourceFilePath, String destinationFolderPath) {
		try {
			
			Path source = Paths.get(sourceFilePath);
			Path destination = Paths.get(destinationFolderPath + File.separator + new File(sourceFilePath).getName());
			Files.copy(source, destination);
			System.out.println("File uploaded: " + sourceFilePath);
			
		} catch (IOException e) {
			
			System.err.println("Failed to upload file: " + sourceFilePath);
			e.printStackTrace();
			
		}
	}

	public static void main(String[] args) {

		String sourceFolderPath = "C:\\Users\\SACHI\\OneDrive\\Desktop\\Source\\BhavaniDocuments";
		String destinationFolderPath = "C:\\Users\\SACHI\\OneDrive\\Desktop\\Destination";

		uploadFolder(sourceFolderPath, destinationFolderPath);
	}

}
