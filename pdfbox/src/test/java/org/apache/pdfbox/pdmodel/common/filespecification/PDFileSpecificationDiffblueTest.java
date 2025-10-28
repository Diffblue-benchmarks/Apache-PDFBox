package org.apache.pdfbox.pdmodel.common.filespecification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSString;
import org.junit.jupiter.api.Test;

class PDFileSpecificationDiffblueTest {
  /**
   * Method under test: {@link PDFileSpecification#createFS(COSBase)}
   */
  @Test
  void testCreateFS() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDFileSpecification.createFS(COSBoolean.FALSE));
    assertNull(PDFileSpecification.createFS(null));
  }

  /**
   * Method under test: {@link PDFileSpecification#createFS(COSBase)}
   */
  @Test
  void testCreateFS2() throws IOException {
    // Arrange
    COSString base = COSString.parseHex("0123456789ABCDEF");

    // Act
    PDFileSpecification actualCreateFSResult = PDFileSpecification.createFS(base);

    // Assert
    assertTrue(actualCreateFSResult instanceof PDSimpleFileSpecification);
    assertEquals("\u0001#Eg›«Íï", actualCreateFSResult.getFile());
    assertSame(base, actualCreateFSResult.getCOSObject());
  }

  /**
   * Method under test: {@link PDFileSpecification#createFS(COSBase)}
   */
  @Test
  void testCreateFS3() throws IOException {
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
}
