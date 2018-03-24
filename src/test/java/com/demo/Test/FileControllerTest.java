package com.demo.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;

import com.demo.Controller.FileController;
import com.demo.Service.FileService;

@RunWith(MockitoJUnitRunner.class)
public class FileControllerTest {

	@InjectMocks
	FileController fileController;

	@Mock
	FileService fileService;

	@Before
	public void setUp() throws Exception {
		fileController = new FileController();
		Whitebox.setInternalState(fileController, "fileService", fileService);
	}

	@Test
	public void testFileUploadSuccess() throws Exception {
		MockMultipartFile mockFile = new MockMultipartFile("fileName", "someFileName.txt", "multipart/form-data", "some text data".getBytes());
		Mockito.when(fileService.isFileUploaded(mockFile)).thenReturn(true);

		ResponseEntity<?> response = fileController.uploadFile(mockFile);
		assertNotNull(response);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void testFileUploadFailure() throws Exception {
		MockMultipartFile mockFile = new MockMultipartFile("fileName", "someFileName.txt", "multipart/form-data", "some text data".getBytes());
		Mockito.when(fileService.isFileUploaded(mockFile)).thenReturn(false);

		ResponseEntity<?> response = fileController.uploadFile(mockFile);
		assertNotNull(response);
		assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
	}
}
