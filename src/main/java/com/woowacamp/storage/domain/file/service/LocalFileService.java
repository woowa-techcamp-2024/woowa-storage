package com.woowacamp.storage.domain.file.service;

import org.springframework.stereotype.Service;

import com.woowacamp.storage.domain.file.repository.FileMetadataRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocalFileService implements FileService {

	private final FileMetadataRepository fileMetadataRepository;


}
