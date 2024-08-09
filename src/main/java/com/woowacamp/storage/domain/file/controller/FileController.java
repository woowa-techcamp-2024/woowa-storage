package com.woowacamp.storage.domain.file.controller;

import java.io.InputStream;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.woowacamp.storage.domain.file.service.FileService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/files")
public class FileController {

	private final FileService fileService;
	private final AmazonS3 amazonS3;

	@PostMapping
	public void uploadFile(@RequestPart MultipartFile request) {
		testUpload(request);
	}

	public void testUpload(MultipartFile request) {
		try {
			var metadata = new ObjectMetadata();
			metadata.setContentType(request.getContentType());
			metadata.setContentLength(request.getResource().contentLength());

			amazonS3.putObject("group-6-drive", "keykey", request.getInputStream(), metadata);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
