package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.filespecification.PDComplexFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDSimpleFileSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDAnnotationFileAttachmentDiffblueTest {
  /**
   * Test {@link PDAnnotationFileAttachment#PDAnnotationFileAttachment()}.
   *
   * <p>Method under test: {@link PDAnnotationFileAttachment#PDAnnotationFileAttachment()}
   */
  @Test
  @DisplayName("Test new PDAnnotationFileAttachment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFileAttachment.<init>()"})
  void testNewPDAnnotationFileAttachment() throws IOException {
    // Arrange and Act
    PDAnnotationFileAttachment actualPdAnnotationFileAttachment = new PDAnnotationFileAttachment();

    // Assert
    assertNull(actualPdAnnotationFileAttachment.getAnnotationName());
    assertNull(actualPdAnnotationFileAttachment.getContents());
    assertNull(actualPdAnnotationFileAttachment.getModifiedDate());
    assertNull(actualPdAnnotationFileAttachment.getIntent());
    assertNull(actualPdAnnotationFileAttachment.getRichContents());
    assertNull(actualPdAnnotationFileAttachment.getSubject());
    assertNull(actualPdAnnotationFileAttachment.getTitlePopup());
    assertNull(actualPdAnnotationFileAttachment.getCreationDate());
    assertNull(actualPdAnnotationFileAttachment.getAppearanceState());
    assertNull(actualPdAnnotationFileAttachment.getPage());
    assertNull(actualPdAnnotationFileAttachment.getRectangle());
    assertNull(actualPdAnnotationFileAttachment.getFile());
    assertNull(actualPdAnnotationFileAttachment.getOptionalContent());
    assertNull(actualPdAnnotationFileAttachment.getColor());
    assertNull(actualPdAnnotationFileAttachment.getInReplyTo());
    assertNull(actualPdAnnotationFileAttachment.getPopup());
    assertNull(actualPdAnnotationFileAttachment.getAppearance());
    assertNull(actualPdAnnotationFileAttachment.getNormalAppearanceStream());
    assertNull(actualPdAnnotationFileAttachment.getBorderStyle());
    assertNull(actualPdAnnotationFileAttachment.getExternalData());
    assertEquals(-1, actualPdAnnotationFileAttachment.getStructParent());
    assertEquals(0, actualPdAnnotationFileAttachment.getAnnotationFlags());
    assertEquals(1.0f, actualPdAnnotationFileAttachment.getConstantOpacity());
    assertFalse(actualPdAnnotationFileAttachment.isHidden());
    assertFalse(actualPdAnnotationFileAttachment.isInvisible());
    assertFalse(actualPdAnnotationFileAttachment.isLocked());
    assertFalse(actualPdAnnotationFileAttachment.isLockedContents());
    assertFalse(actualPdAnnotationFileAttachment.isNoRotate());
    assertFalse(actualPdAnnotationFileAttachment.isNoView());
    assertFalse(actualPdAnnotationFileAttachment.isNoZoom());
    assertFalse(actualPdAnnotationFileAttachment.isPrinted());
    assertFalse(actualPdAnnotationFileAttachment.isReadOnly());
    assertFalse(actualPdAnnotationFileAttachment.isToggleNoView());
    assertEquals(
        PDAnnotationFileAttachment.ATTACHMENT_NAME_PUSH_PIN,
        actualPdAnnotationFileAttachment.getAttachmentName());
    assertEquals(
        PDAnnotationFileAttachment.SUB_TYPE, actualPdAnnotationFileAttachment.getSubtype());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationFileAttachment.getReplyType());
  }

  /**
   * Test {@link PDAnnotationFileAttachment#PDAnnotationFileAttachment(COSDictionary)}.
   *
   * <ul>
   *   <li>Then return AnnotationName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PDAnnotationFileAttachment#PDAnnotationFileAttachment(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDAnnotationFileAttachment(COSDictionary); then return AnnotationName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFileAttachment.<init>(COSDictionary)"})
  void testNewPDAnnotationFileAttachment_thenReturnAnnotationNameIsNull() throws IOException {
    // Arrange
    COSDictionary field = new COSDictionary();

    // Act
    PDAnnotationFileAttachment actualPdAnnotationFileAttachment =
        new PDAnnotationFileAttachment(field);

    // Assert
    assertNull(actualPdAnnotationFileAttachment.getAnnotationName());
    assertNull(actualPdAnnotationFileAttachment.getContents());
    assertNull(actualPdAnnotationFileAttachment.getModifiedDate());
    assertNull(actualPdAnnotationFileAttachment.getSubtype());
    assertNull(actualPdAnnotationFileAttachment.getIntent());
    assertNull(actualPdAnnotationFileAttachment.getRichContents());
    assertNull(actualPdAnnotationFileAttachment.getSubject());
    assertNull(actualPdAnnotationFileAttachment.getTitlePopup());
    assertNull(actualPdAnnotationFileAttachment.getCreationDate());
    assertNull(actualPdAnnotationFileAttachment.getAppearanceState());
    assertNull(actualPdAnnotationFileAttachment.getPage());
    assertNull(actualPdAnnotationFileAttachment.getRectangle());
    assertNull(actualPdAnnotationFileAttachment.getFile());
    assertNull(actualPdAnnotationFileAttachment.getOptionalContent());
    assertNull(actualPdAnnotationFileAttachment.getColor());
    assertNull(actualPdAnnotationFileAttachment.getInReplyTo());
    assertNull(actualPdAnnotationFileAttachment.getPopup());
    assertNull(actualPdAnnotationFileAttachment.getAppearance());
    assertNull(actualPdAnnotationFileAttachment.getNormalAppearanceStream());
    assertNull(actualPdAnnotationFileAttachment.getBorderStyle());
    assertNull(actualPdAnnotationFileAttachment.getExternalData());
    assertEquals(-1, actualPdAnnotationFileAttachment.getStructParent());
    assertEquals(0, actualPdAnnotationFileAttachment.getAnnotationFlags());
    assertEquals(1, field.size());
    assertEquals(1.0f, actualPdAnnotationFileAttachment.getConstantOpacity());
    assertFalse(actualPdAnnotationFileAttachment.isHidden());
    assertFalse(actualPdAnnotationFileAttachment.isInvisible());
    assertFalse(actualPdAnnotationFileAttachment.isLocked());
    assertFalse(actualPdAnnotationFileAttachment.isLockedContents());
    assertFalse(actualPdAnnotationFileAttachment.isNoRotate());
    assertFalse(actualPdAnnotationFileAttachment.isNoView());
    assertFalse(actualPdAnnotationFileAttachment.isNoZoom());
    assertFalse(actualPdAnnotationFileAttachment.isPrinted());
    assertFalse(actualPdAnnotationFileAttachment.isReadOnly());
    assertFalse(actualPdAnnotationFileAttachment.isToggleNoView());
    assertEquals(
        PDAnnotationFileAttachment.ATTACHMENT_NAME_PUSH_PIN,
        actualPdAnnotationFileAttachment.getAttachmentName());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationFileAttachment.getReplyType());
    assertSame(field, actualPdAnnotationFileAttachment.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationFileAttachment#getFile()}.
   *
   * <p>Method under test: {@link PDAnnotationFileAttachment#getFile()}
   */
  @Test
  @DisplayName("Test getFile()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFileSpecification PDAnnotationFileAttachment.getFile()"})
  void testGetFile() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationFileAttachment().getFile());
  }

  /**
   * Test {@link PDAnnotationFileAttachment#setFile(PDFileSpecification)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFileAttachment#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName(
      "Test setFile(PDFileSpecification); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFileAttachment.setFile(PDFileSpecification)"})
  void testSetFile_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAnnotationFileAttachment.setFile(new PDComplexFileSpecification(dict));

    // Assert
    PDFileSpecification file = pdAnnotationFileAttachment.getFile();
    assertTrue(file instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) file).getFileDescription());
    assertNull(((PDComplexFileSpecification) file).getFileDos());
    assertNull(((PDComplexFileSpecification) file).getFileMac());
    assertNull(((PDComplexFileSpecification) file).getFileUnicode());
    assertNull(((PDComplexFileSpecification) file).getFileUnix());
    assertNull(((PDComplexFileSpecification) file).getFilename());
    assertNull(file.getFile());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileUnix());
    assertFalse(((PDComplexFileSpecification) file).isVolatile());
    assertSame(dict, file.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationFileAttachment#setFile(PDFileSpecification)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFileAttachment#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName(
      "Test setFile(PDFileSpecification); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFileAttachment.setFile(PDFileSpecification)"})
  void testSetFile_givenTrue_whenCOSDictionaryDirectIsTrue() throws IOException {
    // Arrange
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();

    COSDictionary dict = new COSDictionary();
    dict.setDirect(true);

    // Act
    pdAnnotationFileAttachment.setFile(new PDComplexFileSpecification(dict));

    // Assert
    PDFileSpecification file = pdAnnotationFileAttachment.getFile();
    assertTrue(file instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) file).getFileDescription());
    assertNull(((PDComplexFileSpecification) file).getFileDos());
    assertNull(((PDComplexFileSpecification) file).getFileMac());
    assertNull(((PDComplexFileSpecification) file).getFileUnicode());
    assertNull(((PDComplexFileSpecification) file).getFileUnix());
    assertNull(((PDComplexFileSpecification) file).getFilename());
    assertNull(file.getFile());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileUnix());
    assertFalse(((PDComplexFileSpecification) file).isVolatile());
    assertSame(dict, file.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationFileAttachment#setFile(PDFileSpecification)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationFileAttachment#PDAnnotationFileAttachment()} File {@link
   *       PDSimpleFileSpecification}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFileAttachment#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName(
      "Test setFile(PDFileSpecification); then PDAnnotationFileAttachment() File PDSimpleFileSpecification")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFileAttachment.setFile(PDFileSpecification)"})
  void testSetFile_thenPDAnnotationFileAttachmentFilePDSimpleFileSpecification()
      throws IOException {
    // Arrange
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();

    // Act
    pdAnnotationFileAttachment.setFile(new PDSimpleFileSpecification());

    // Assert
    PDFileSpecification file = pdAnnotationFileAttachment.getFile();
    assertTrue(file instanceof PDSimpleFileSpecification);
    assertEquals("", file.getFile());
    COSDictionary cOSObject = pdAnnotationFileAttachment.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationFileAttachment#setFile(PDFileSpecification)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationFileAttachment#PDAnnotationFileAttachment()} COSObject Values
   *       size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFileAttachment#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName(
      "Test setFile(PDFileSpecification); when 'null'; then PDAnnotationFileAttachment() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFileAttachment.setFile(PDFileSpecification)"})
  void testSetFile_whenNull_thenPDAnnotationFileAttachmentCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();

    // Act
    pdAnnotationFileAttachment.setFile(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationFileAttachment.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationFileAttachment#setFile(PDFileSpecification)}.
   *
   * <ul>
   *   <li>When {@link PDComplexFileSpecification#PDComplexFileSpecification()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFileAttachment#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName("Test setFile(PDFileSpecification); when PDComplexFileSpecification()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFileAttachment.setFile(PDFileSpecification)"})
  void testSetFile_whenPDComplexFileSpecification() throws IOException {
    // Arrange
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();

    // Act
    pdAnnotationFileAttachment.setFile(new PDComplexFileSpecification());

    // Assert
    PDFileSpecification file = pdAnnotationFileAttachment.getFile();
    assertTrue(file instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) file).getFileDescription());
    assertNull(((PDComplexFileSpecification) file).getFileDos());
    assertNull(((PDComplexFileSpecification) file).getFileMac());
    assertNull(((PDComplexFileSpecification) file).getFileUnicode());
    assertNull(((PDComplexFileSpecification) file).getFileUnix());
    assertNull(((PDComplexFileSpecification) file).getFilename());
    assertNull(file.getFile());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileUnix());
    assertFalse(((PDComplexFileSpecification) file).isVolatile());
  }

  /**
   * Test {@link PDAnnotationFileAttachment#getAttachmentName()}.
   *
   * <p>Method under test: {@link PDAnnotationFileAttachment#getAttachmentName()}
   */
  @Test
  @DisplayName("Test getAttachmentName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAnnotationFileAttachment.getAttachmentName()"})
  void testGetAttachmentName() {
    // Arrange, Act and Assert
    assertEquals(
        PDAnnotationFileAttachment.ATTACHMENT_NAME_PUSH_PIN,
        new PDAnnotationFileAttachment().getAttachmentName());
  }

  /**
   * Test {@link PDAnnotationFileAttachment#setAttachmentName(String)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationFileAttachment#PDAnnotationFileAttachment()} AttachmentName is
   *       {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFileAttachment#setAttachmentName(String)}
   */
  @Test
  @DisplayName(
      "Test setAttachmentName(String); then PDAnnotationFileAttachment() AttachmentName is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFileAttachment.setAttachmentName(String)"})
  void testSetAttachmentName_thenPDAnnotationFileAttachmentAttachmentNameIsName() {
    // Arrange
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();

    // Act
    pdAnnotationFileAttachment.setAttachmentName("Name");

    // Assert
    assertEquals("Name", pdAnnotationFileAttachment.getAttachmentName());
    COSDictionary cOSObject = pdAnnotationFileAttachment.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationFileAttachment#setAttachmentName(String)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationFileAttachment#PDAnnotationFileAttachment()} COSObject Values
   *       size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFileAttachment#setAttachmentName(String)}
   */
  @Test
  @DisplayName(
      "Test setAttachmentName(String); then PDAnnotationFileAttachment() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFileAttachment.setAttachmentName(String)"})
  void testSetAttachmentName_thenPDAnnotationFileAttachmentCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();

    // Act
    pdAnnotationFileAttachment.setAttachmentName(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationFileAttachment.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(
        PDAnnotationFileAttachment.ATTACHMENT_NAME_PUSH_PIN,
        pdAnnotationFileAttachment.getAttachmentName());
  }

  /**
   * Test {@link PDAnnotationFileAttachment#setAttachmentName(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link PDAnnotationFileAttachment#PDAnnotationFileAttachment()} AttachmentName is
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFileAttachment#setAttachmentName(String)}
   */
  @Test
  @DisplayName(
      "Test setAttachmentName(String); when '42'; then PDAnnotationFileAttachment() AttachmentName is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFileAttachment.setAttachmentName(String)"})
  void testSetAttachmentName_when42_thenPDAnnotationFileAttachmentAttachmentNameIs42() {
    // Arrange
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();

    // Act
    pdAnnotationFileAttachment.setAttachmentName("42");

    // Assert
    assertEquals("42", pdAnnotationFileAttachment.getAttachmentName());
    COSDictionary cOSObject = pdAnnotationFileAttachment.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationFileAttachment#constructAppearances(PDDocument)} with {@code
   * PDDocument}.
   *
   * <ul>
   *   <li>Then array length is three.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFileAttachment#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; then array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFileAttachment.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_thenArrayLengthIsThree() {
    // Arrange
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();
    pdAnnotationFileAttachment.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFileAttachment.constructAppearances(new PDDocument());

    // Assert
    float[][] values =
        pdAnnotationFileAttachment.getNormalAppearanceStream().getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAnnotationFileAttachment#constructAppearances(PDDocument)} with {@code
   * PDDocument}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then array length is three.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFileAttachment#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; when 'null'; then array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFileAttachment.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_whenNull_thenArrayLengthIsThree() {
    // Arrange
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();
    pdAnnotationFileAttachment.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFileAttachment.constructAppearances(null);

    // Assert
    float[][] values =
        pdAnnotationFileAttachment.getNormalAppearanceStream().getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAnnotationFileAttachment#constructAppearances()}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationFileAttachment#PDAnnotationFileAttachment()} COSObject Values
   *       size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFileAttachment#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); then PDAnnotationFileAttachment() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFileAttachment.constructAppearances()"})
  void testConstructAppearances_thenPDAnnotationFileAttachmentCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();

    // Act
    pdAnnotationFileAttachment.constructAppearances();

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationFileAttachment.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }
}
