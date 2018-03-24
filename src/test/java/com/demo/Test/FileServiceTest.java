package com.demo.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;

import com.demo.Service.FileService;

@RunWith(MockitoJUnitRunner.class)
public class FileServiceTest {

	@InjectMocks
	FileService fileService;

	@Before
	public void setUp() throws Exception {
		fileService = new FileService();
	}

	@Test
	public void testIsFileUploaded() {
		MockMultipartFile fileName = new MockMultipartFile("fileName", "someFile.txt", "text/plain", "some text data".getBytes());
		boolean response = fileService.isFileUploaded(fileName);
		assertEquals(true, response);
	}

}
