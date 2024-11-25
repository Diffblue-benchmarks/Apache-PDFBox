package org.apache.pdfbox.examples.signature.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AddValidationInformationDiffblueTest {
  /**
   * Test {@link AddValidationInformation#validateSignature(File, File)}.
   * <ul>
   *   <li>Then throw {@link FileNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AddValidationInformation#validateSignature(File, File)}
   */
  @Test
  @DisplayName("Test validateSignature(File, File); then throw FileNotFoundException")
  void testValidateSignature_thenThrowFileNotFoundException() throws IOException {
    // Arrange
    AddValidationInformation addValidationInformation = new AddValidationInformation();
    File inFile = Paths.get(System.getProperty("java.io.tmpdir"), "name").toFile();

    // Act and Assert
    assertThrows(FileNotFoundException.class, () -> addValidationInformation.validateSignature(inFile,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
  }
}
