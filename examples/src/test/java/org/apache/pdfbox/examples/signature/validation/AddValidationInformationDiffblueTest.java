package org.apache.pdfbox.examples.signature.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

class AddValidationInformationDiffblueTest {
  /**
   * Method under test:
   * {@link AddValidationInformation#validateSignature(File, File)}
   */
  @Test
  void testValidateSignature() throws IOException {
    // Arrange
    AddValidationInformation addValidationInformation = new AddValidationInformation();
    File inFile = Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile();

    // Act and Assert
    assertThrows(FileNotFoundException.class, () -> addValidationInformation.validateSignature(inFile,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
  }
}
