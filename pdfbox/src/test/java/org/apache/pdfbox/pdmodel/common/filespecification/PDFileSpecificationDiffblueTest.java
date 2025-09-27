package org.apache.pdfbox.pdmodel.common.filespecification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFileSpecificationDiffblueTest {
  /**
   * Test {@link PDFileSpecification#createFS(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return {@link PDComplexFileSpecification}.
   * </ul>
   *
   * <p>Method under test: {@link PDFileSpecification#createFS(COSBase)}
   */
  @Test
  @DisplayName(
      "Test createFS(COSBase); when COSDictionary(); then return PDComplexFileSpecification")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFileSpecification PDFileSpecification.createFS(COSBase)"})
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
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDFileSpecification#createFS(COSBase)}
   */
  @Test
  @DisplayName("Test createFS(COSBase); when FALSE; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFileSpecification PDFileSpecification.createFS(COSBase)"})
  void testCreateFS_whenFalse_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDFileSpecification.createFS(COSBoolean.FALSE));
  }

  /**
   * Test {@link PDFileSpecification#createFS(COSBase)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFileSpecification#createFS(COSBase)}
   */
  @Test
  @DisplayName("Test createFS(COSBase); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFileSpecification PDFileSpecification.createFS(COSBase)"})
  void testCreateFS_whenNull_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(PDFileSpecification.createFS(null));
  }

  /**
   * Test {@link PDFileSpecification#createFS(COSBase)}.
   *
   * <ul>
   *   <li>When parseHex {@code 0123456789ABCDEF}.
   *   <li>Then return {@link PDSimpleFileSpecification}.
   * </ul>
   *
   * <p>Method under test: {@link PDFileSpecification#createFS(COSBase)}
   */
  @Test
  @DisplayName(
      "Test createFS(COSBase); when parseHex '0123456789ABCDEF'; then return PDSimpleFileSpecification")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFileSpecification PDFileSpecification.createFS(COSBase)"})
  void testCreateFS_whenParseHex0123456789abcdef_thenReturnPDSimpleFileSpecification()
      throws IOException {
    // Arrange
    COSString base = COSString.parseHex("0123456789ABCDEF");

    // Act
    PDFileSpecification actualCreateFSResult = PDFileSpecification.createFS(base);

    // Assert
    assertTrue(actualCreateFSResult instanceof PDSimpleFileSpecification);
    assertEquals("\u0001#Eg›«Íï", actualCreateFSResult.getFile());
    assertSame(base, actualCreateFSResult.getCOSObject());
  }
}
