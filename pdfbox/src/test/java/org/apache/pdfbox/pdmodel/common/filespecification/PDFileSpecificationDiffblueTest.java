package org.apache.pdfbox.pdmodel.common.filespecification;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDFileSpecificationDiffblueTest {
  /**
   * Test {@link PDFileSpecification#createFS(COSBase)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@link PDComplexFileSpecification}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFileSpecification#createFS(COSBase)}
   */
  @Test
  @DisplayName("Test createFS(COSBase); when COSDictionary(); then return PDComplexFileSpecification")
  void testCreateFS_whenCOSDictionary_thenReturnPDComplexFileSpecification() throws IOException {
    // Arrange
    COSDictionary base = new COSDictionary();

    // Act
    PDFileSpecification actualCreateFSResult = PDFileSpecification.createFS(base);

    // Assert
    assertTrue(actualCreateFSResult instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) actualCreateFSResult).getFileDescription());
    assertNull(((PDComplexFileSpecification) actualCreateFSResult).getFileDos());
    assertNull(((PDComplexFileSpecification) actualCreateFSResult).getFileMac());
    assertNull(((PDComplexFileSpecification) actualCreateFSResult).getFileUnicode());
    assertNull(((PDComplexFileSpecification) actualCreateFSResult).getFileUnix());
    assertNull(((PDComplexFileSpecification) actualCreateFSResult).getFilename());
    assertNull(actualCreateFSResult.getFile());
    assertNull(((PDComplexFileSpecification) actualCreateFSResult).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) actualCreateFSResult).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) actualCreateFSResult).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) actualCreateFSResult).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) actualCreateFSResult).getEmbeddedFileUnix());
    assertFalse(((PDComplexFileSpecification) actualCreateFSResult).isVolatile());
    assertSame(base, actualCreateFSResult.getCOSObject());
  }

  /**
   * Test {@link PDFileSpecification#createFS(COSBase)}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFileSpecification#createFS(COSBase)}
   */
  @Test
  @DisplayName("Test createFS(COSBase); when FALSE; then throw IOException")
  void testCreateFS_whenFalse_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDFileSpecification.createFS(COSBoolean.FALSE));
  }

  /**
   * Test {@link PDFileSpecification#createFS(COSBase)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFileSpecification#createFS(COSBase)}
   */
  @Test
  @DisplayName("Test createFS(COSBase); when 'null'; then return 'null'")
  void testCreateFS_whenNull_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(PDFileSpecification.createFS(null));
  }
}
