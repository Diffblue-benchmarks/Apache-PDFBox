package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.io.ScratchFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.common.filespecification.PDComplexFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDSimpleFileSpecification;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDCircleAppearanceHandler;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;

class PDAnnotationFileAttachmentDiffblueTest {
  /**
   * Method under test: {@link PDAnnotationFileAttachment#getFile()}
   */
  @Test
  void testGetFile() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationFileAttachment()).getFile());
  }

  /**
   * Method under test:
   * {@link PDAnnotationFileAttachment#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile() throws IOException {
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
    COSDictionary cOSObject = pdAnnotationFileAttachment.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(((PDComplexFileSpecification) file).isVolatile());
  }

  /**
   * Method under test:
   * {@link PDAnnotationFileAttachment#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile2() throws IOException {
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
   * Method under test:
   * {@link PDAnnotationFileAttachment#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile3() throws IOException {
    // Arrange
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();

    // Act
    pdAnnotationFileAttachment.setFile(null);

    // Assert
    assertNull(pdAnnotationFileAttachment.getFile());
    COSDictionary cOSObject = pdAnnotationFileAttachment.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationFileAttachment#getAttachmentName()}
   */
  @Test
  void testGetAttachmentName() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationFileAttachment.ATTACHMENT_NAME_PUSH_PIN,
        (new PDAnnotationFileAttachment()).getAttachmentName());
  }

  /**
   * Method under test:
   * {@link PDAnnotationFileAttachment#setAttachmentName(String)}
   */
  @Test
  void testSetAttachmentName() {
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
   * Method under test:
   * {@link PDAnnotationFileAttachment#setAttachmentName(String)}
   */
  @Test
  void testSetAttachmentName2() {
    // Arrange
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();

    // Act
    pdAnnotationFileAttachment.setAttachmentName("NameName");

    // Assert
    assertEquals("NameName", pdAnnotationFileAttachment.getAttachmentName());
    COSDictionary cOSObject = pdAnnotationFileAttachment.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationFileAttachment#constructAppearances()}
   */
  @Test
  void testConstructAppearances() {
    // Arrange
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();

    // Act
    pdAnnotationFileAttachment.constructAppearances();

    // Assert
    assertNull(pdAnnotationFileAttachment.getRectangle());
    assertNull(pdAnnotationFileAttachment.getAppearance());
    assertNull(pdAnnotationFileAttachment.getNormalAppearanceStream());
    COSDictionary cOSObject = pdAnnotationFileAttachment.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationFileAttachment#constructAppearances()}
   */
  @Test
  void testConstructAppearances2() throws IOException {
    // Arrange
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();
    pdAnnotationFileAttachment.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFileAttachment.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFileAttachment.getNormalAppearanceStream();
    PDResources resources = normalAppearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDRectangle bBox = normalAppearanceStream.getBBox();
    COSArray cOSArray = bBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    assertTrue(toListResult.get(2) instanceof COSFloat);
    assertTrue(toListResult.get(3) instanceof COSFloat);
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFileAttachment.getAppearance();
    PDAppearanceEntry downAppearance = appearance.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
    PDAppearanceStream appearanceStream2 = normalAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceEntry rolloverAppearance = appearance.getRolloverAppearance();
    PDAppearanceStream appearanceStream3 = rolloverAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadBuffer);
    PDStream stream = normalAppearanceStream.getStream();
    assertNull(stream.getDecodeParms());
    PDStream stream2 = appearanceStream.getStream();
    assertNull(stream2.getDecodeParms());
    PDStream stream3 = appearanceStream2.getStream();
    assertNull(stream3.getDecodeParms());
    PDStream stream4 = appearanceStream3.getStream();
    assertNull(stream4.getDecodeParms());
    PDStream contentStream = normalAppearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    PDStream contentStream2 = appearanceStream.getContentStream();
    assertNull(contentStream2.getDecodeParms());
    PDStream contentStream3 = appearanceStream2.getContentStream();
    assertNull(contentStream3.getDecodeParms());
    PDStream contentStream4 = appearanceStream3.getContentStream();
    assertNull(contentStream4.getDecodeParms());
    assertNull(stream.getFileDecodeParams());
    assertNull(stream2.getFileDecodeParams());
    assertNull(stream3.getFileDecodeParams());
    assertNull(stream4.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(contentStream2.getFileDecodeParams());
    assertNull(contentStream3.getFileDecodeParams());
    assertNull(contentStream4.getFileDecodeParams());
    COSStream cOSObject = normalAppearanceStream.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSUpdateState updateState2 = cOSObject.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSDictionary cOSObject3 = appearance.getCOSObject();
    COSUpdateState updateState3 = cOSObject3.getUpdateState();
    assertNull(updateState3.getOriginDocumentState());
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject3.getKey());
    assertNull(resources.getResourceCache());
    PDResources resources2 = appearanceStream.getResources();
    assertNull(resources2.getResourceCache());
    PDResources resources3 = appearanceStream2.getResources();
    assertNull(resources3.getResourceCache());
    PDResources resources4 = appearanceStream3.getResources();
    assertNull(resources4.getResourceCache());
    assertNull(stream.getMetadata());
    assertNull(stream2.getMetadata());
    assertNull(stream3.getMetadata());
    assertNull(stream4.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(contentStream2.getMetadata());
    assertNull(contentStream3.getMetadata());
    assertNull(contentStream4.getMetadata());
    assertNull(stream.getFile());
    assertNull(stream2.getFile());
    assertNull(stream3.getFile());
    assertNull(stream4.getFile());
    assertNull(contentStream.getFile());
    assertNull(contentStream2.getFile());
    assertNull(contentStream3.getFile());
    assertNull(contentStream4.getFile());
    assertNull(normalAppearanceStream.getOptionalContent());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream2.getOptionalContent());
    assertNull(appearanceStream3.getOptionalContent());
    assertNull(normalAppearanceStream.getGroup());
    assertNull(appearanceStream.getGroup());
    assertNull(appearanceStream2.getGroup());
    assertNull(appearanceStream3.getGroup());
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(-0.0f, matrix.getTranslateX());
    assertEquals(-0.0f, matrix.getTranslateY());
    assertEquals(-1, stream.getDecodedStreamLength());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, stream3.getDecodedStreamLength());
    assertEquals(-1, stream4.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, contentStream2.getDecodedStreamLength());
    assertEquals(-1, contentStream3.getDecodedStreamLength());
    assertEquals(-1, contentStream4.getDecodedStreamLength());
    assertEquals(-1, normalAppearanceStream.getStructParents());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(-1, appearanceStream2.getStructParents());
    assertEquals(-1, appearanceStream3.getStructParents());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getLowerLeftX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(0.0f, bBox2.getLowerLeftX());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(0.0f, bBox3.getLowerLeftX());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(0.0f, bBox4.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(0.0f, bBox2.getLowerLeftY());
    assertEquals(0.0f, bBox3.getLowerLeftY());
    assertEquals(0.0f, bBox4.getLowerLeftY());
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0L, contentsForStreamParsing.getPosition());
    assertEquals(0L, contentsForStreamParsing2.getPosition());
    assertEquals(0L, contentsForStreamParsing3.getPosition());
    assertEquals(0L, contentsForStreamParsing4.getPosition());
    assertEquals(0L, contentsForRandomAccess.getPosition());
    assertEquals(0L, contentsForRandomAccess2.getPosition());
    assertEquals(0L, contentsForRandomAccess3.getPosition());
    assertEquals(0L, contentsForRandomAccess4.getPosition());
    assertEquals(1, cOSObject3.getValues().size());
    assertEquals(1, cOSObject3.size());
    assertEquals(1, normalAppearanceStream.getFormType());
    assertEquals(1, appearanceStream.getFormType());
    assertEquals(1, appearanceStream2.getFormType());
    assertEquals(1, appearanceStream3.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(18.0f, bBox.getHeight());
    assertEquals(18.0f, bBox2.getHeight());
    assertEquals(18.0f, bBox3.getHeight());
    assertEquals(18.0f, bBox4.getHeight());
    PDRectangle rectangle = pdAnnotationFileAttachment.getRectangle();
    assertEquals(18.0f, rectangle.getHeight());
    assertEquals(18.0f, bBox.getUpperRightX());
    assertEquals(18.0f, bBox2.getUpperRightX());
    assertEquals(18.0f, bBox3.getUpperRightX());
    assertEquals(18.0f, bBox4.getUpperRightX());
    assertEquals(18.0f, rectangle.getUpperRightX());
    assertEquals(18.0f, bBox.getUpperRightY());
    assertEquals(18.0f, bBox2.getUpperRightY());
    assertEquals(18.0f, bBox3.getUpperRightY());
    assertEquals(18.0f, bBox4.getUpperRightY());
    assertEquals(18.0f, bBox.getWidth());
    assertEquals(18.0f, bBox2.getWidth());
    assertEquals(18.0f, bBox3.getWidth());
    assertEquals(18.0f, bBox4.getWidth());
    assertEquals(18.0f, rectangle.getWidth());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertEquals(3352.3938f, rectangle.getLowerLeftY());
    COSDictionary cOSObject4 = pdAnnotationFileAttachment.getCOSObject();
    assertEquals(4, cOSObject4.getValues().size());
    assertEquals(4, cOSObject4.size());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertEquals(804, contentsForStreamParsing.available());
    assertEquals(804, contentsForStreamParsing2.available());
    assertEquals(804, contentsForStreamParsing3.available());
    assertEquals(804, contentsForStreamParsing4.available());
    assertEquals(804, contentsForRandomAccess.available());
    assertEquals(804, contentsForRandomAccess2.available());
    assertEquals(804, contentsForRandomAccess3.available());
    assertEquals(804, contentsForRandomAccess4.available());
    assertEquals(804, stream.getLength());
    assertEquals(804, stream2.getLength());
    assertEquals(804, stream3.getLength());
    assertEquals(804, stream4.getLength());
    assertEquals(804, contentStream.getLength());
    assertEquals(804, contentStream2.getLength());
    assertEquals(804, contentStream3.getLength());
    assertEquals(804, contentStream4.getLength());
    assertEquals(804L, cOSObject.getLength());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject3.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(updateState3.isUpdated());
    assertFalse(contentsForStreamParsing.isClosed());
    assertFalse(contentsForStreamParsing2.isClosed());
    assertFalse(contentsForStreamParsing3.isClosed());
    assertFalse(contentsForStreamParsing4.isClosed());
    assertFalse(contentsForRandomAccess.isClosed());
    assertFalse(contentsForRandomAccess2.isClosed());
    assertFalse(contentsForRandomAccess3.isClosed());
    assertFalse(contentsForRandomAccess4.isClosed());
    assertFalse(downAppearance.isSubDictionary());
    assertFalse(normalAppearance.isSubDictionary());
    assertFalse(rolloverAppearance.isSubDictionary());
    assertTrue(cOSObject2.getValues().isEmpty());
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(toIncrementResult3.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(cOSObject.hasData());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    COSArray cOSArray2 = bBox2.getCOSArray();
    assertEquals(toListResult, cOSArray2.toList());
    COSArray cOSArray3 = bBox3.getCOSArray();
    assertEquals(toListResult, cOSArray3.toList());
    COSArray cOSArray4 = bBox4.getCOSArray();
    assertEquals(toListResult, cOSArray4.toList());
    assertEquals(matrix, appearanceStream.getMatrix());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertEquals(matrix, appearanceStream3.getMatrix());
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(cOSObject2, resources3.getCOSObject());
    assertSame(cOSObject2, resources4.getCOSObject());
    assertSame(cOSArray, bBox.getCOSObject());
    assertSame(cOSArray2, bBox2.getCOSObject());
    assertSame(cOSArray3, bBox3.getCOSObject());
    assertSame(cOSArray4, bBox4.getCOSObject());
    assertSame(fileFilters, stream.getFileFilters());
    assertSame(fileFilters, stream2.getFileFilters());
    assertSame(fileFilters, stream3.getFileFilters());
    assertSame(fileFilters, stream4.getFileFilters());
    assertSame(fileFilters, contentStream2.getFileFilters());
    assertSame(fileFilters, contentStream3.getFileFilters());
    assertSame(fileFilters, contentStream4.getFileFilters());
    assertSame(fileFilters, stream.getFilters());
    assertSame(fileFilters, stream2.getFilters());
    assertSame(fileFilters, stream3.getFilters());
    assertSame(fileFilters, stream4.getFilters());
    assertSame(fileFilters, contentStream.getFilters());
    assertSame(fileFilters, contentStream2.getFilters());
    assertSame(fileFilters, contentStream3.getFilters());
    assertSame(fileFilters, contentStream4.getFilters());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, stream2.getCOSObject());
    assertSame(cOSObject, stream3.getCOSObject());
    assertSame(cOSObject, stream4.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, contentStream2.getCOSObject());
    assertSame(cOSObject, contentStream3.getCOSObject());
    assertSame(cOSObject, contentStream4.getCOSObject());
    assertSame(cOSObject, appearanceStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, appearanceStream3.getCOSObject());
    assertSame(cOSObject, downAppearance.getCOSObject());
    assertSame(cOSObject, normalAppearance.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(colorSpaceNames, resources3.getColorSpaceNames());
    assertSame(colorSpaceNames, resources4.getColorSpaceNames());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources2.getExtGStateNames());
    assertSame(colorSpaceNames, resources3.getExtGStateNames());
    assertSame(colorSpaceNames, resources4.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getFontNames());
    assertSame(colorSpaceNames, resources2.getFontNames());
    assertSame(colorSpaceNames, resources3.getFontNames());
    assertSame(colorSpaceNames, resources4.getFontNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources2.getPatternNames());
    assertSame(colorSpaceNames, resources3.getPatternNames());
    assertSame(colorSpaceNames, resources4.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources2.getPropertiesNames());
    assertSame(colorSpaceNames, resources3.getPropertiesNames());
    assertSame(colorSpaceNames, resources4.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources2.getShadingNames());
    assertSame(colorSpaceNames, resources3.getShadingNames());
    assertSame(colorSpaceNames, resources4.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(colorSpaceNames, resources2.getXObjectNames());
    assertSame(colorSpaceNames, resources3.getXObjectNames());
    assertSame(colorSpaceNames, resources4.getXObjectNames());
    assertArrayEquals("13.574 9.301 m\n8.926 13.949 l\n7.648 15.227 5.625 15".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("13.574 9.301 m\n8.926 13.949 l\n7.648 15.227 5.625 15".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("13.574 9.301 m\n8.926 13.949 l\n7.648 15.227 5.625 15".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("13.574 9.301 m\n8.926 13.949 l\n7.648 15.227 5.625 15".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test:
   * {@link PDAnnotationFileAttachment#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances3() {
    // Arrange
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();

    // Act
    pdAnnotationFileAttachment.constructAppearances(new PDDocument());

    // Assert
    assertNull(pdAnnotationFileAttachment.getRectangle());
    assertNull(pdAnnotationFileAttachment.getAppearance());
    assertNull(pdAnnotationFileAttachment.getNormalAppearanceStream());
    COSDictionary cOSObject = pdAnnotationFileAttachment.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDAnnotationFileAttachment#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances4() throws IOException {
    // Arrange
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdAnnotationFileAttachment.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(pdAnnotationFileAttachment.getRectangle());
    assertNull(pdAnnotationFileAttachment.getAppearance());
    assertNull(pdAnnotationFileAttachment.getNormalAppearanceStream());
    COSDictionary cOSObject = pdAnnotationFileAttachment.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDAnnotationFileAttachment#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances5() throws IOException {
    // Arrange
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();
    pdAnnotationFileAttachment.setRectangle(PDRectangle.A0);
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdAnnotationFileAttachment.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    PDAppearanceStream normalAppearanceStream = pdAnnotationFileAttachment.getNormalAppearanceStream();
    PDResources resources = normalAppearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDRectangle bBox = normalAppearanceStream.getBBox();
    COSArray cOSArray = bBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    assertTrue(toListResult.get(2) instanceof COSFloat);
    assertTrue(toListResult.get(3) instanceof COSFloat);
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFileAttachment.getAppearance();
    PDAppearanceEntry downAppearance = appearance.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
    PDAppearanceStream appearanceStream2 = normalAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceEntry rolloverAppearance = appearance.getRolloverAppearance();
    PDAppearanceStream appearanceStream3 = rolloverAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadBuffer);
    PDStream stream = normalAppearanceStream.getStream();
    assertNull(stream.getDecodeParms());
    PDStream stream2 = appearanceStream.getStream();
    assertNull(stream2.getDecodeParms());
    PDStream stream3 = appearanceStream2.getStream();
    assertNull(stream3.getDecodeParms());
    PDStream stream4 = appearanceStream3.getStream();
    assertNull(stream4.getDecodeParms());
    PDStream contentStream = normalAppearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    PDStream contentStream2 = appearanceStream.getContentStream();
    assertNull(contentStream2.getDecodeParms());
    PDStream contentStream3 = appearanceStream2.getContentStream();
    assertNull(contentStream3.getDecodeParms());
    PDStream contentStream4 = appearanceStream3.getContentStream();
    assertNull(contentStream4.getDecodeParms());
    assertNull(stream.getFileDecodeParams());
    assertNull(stream2.getFileDecodeParams());
    assertNull(stream3.getFileDecodeParams());
    assertNull(stream4.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(contentStream2.getFileDecodeParams());
    assertNull(contentStream3.getFileDecodeParams());
    assertNull(contentStream4.getFileDecodeParams());
    COSStream cOSObject = normalAppearanceStream.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSUpdateState updateState2 = cOSObject.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSDictionary cOSObject3 = appearance.getCOSObject();
    COSUpdateState updateState3 = cOSObject3.getUpdateState();
    assertNull(updateState3.getOriginDocumentState());
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject3.getKey());
    assertNull(resources.getResourceCache());
    PDResources resources2 = appearanceStream.getResources();
    assertNull(resources2.getResourceCache());
    PDResources resources3 = appearanceStream2.getResources();
    assertNull(resources3.getResourceCache());
    PDResources resources4 = appearanceStream3.getResources();
    assertNull(resources4.getResourceCache());
    assertNull(stream.getMetadata());
    assertNull(stream2.getMetadata());
    assertNull(stream3.getMetadata());
    assertNull(stream4.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(contentStream2.getMetadata());
    assertNull(contentStream3.getMetadata());
    assertNull(contentStream4.getMetadata());
    assertNull(stream.getFile());
    assertNull(stream2.getFile());
    assertNull(stream3.getFile());
    assertNull(stream4.getFile());
    assertNull(contentStream.getFile());
    assertNull(contentStream2.getFile());
    assertNull(contentStream3.getFile());
    assertNull(contentStream4.getFile());
    assertNull(normalAppearanceStream.getOptionalContent());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream2.getOptionalContent());
    assertNull(appearanceStream3.getOptionalContent());
    assertNull(normalAppearanceStream.getGroup());
    assertNull(appearanceStream.getGroup());
    assertNull(appearanceStream2.getGroup());
    assertNull(appearanceStream3.getGroup());
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(-0.0f, matrix.getTranslateX());
    assertEquals(-0.0f, matrix.getTranslateY());
    assertEquals(-1, stream.getDecodedStreamLength());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, stream3.getDecodedStreamLength());
    assertEquals(-1, stream4.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, contentStream2.getDecodedStreamLength());
    assertEquals(-1, contentStream3.getDecodedStreamLength());
    assertEquals(-1, contentStream4.getDecodedStreamLength());
    assertEquals(-1, normalAppearanceStream.getStructParents());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(-1, appearanceStream2.getStructParents());
    assertEquals(-1, appearanceStream3.getStructParents());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getLowerLeftX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(0.0f, bBox2.getLowerLeftX());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(0.0f, bBox3.getLowerLeftX());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(0.0f, bBox4.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(0.0f, bBox2.getLowerLeftY());
    assertEquals(0.0f, bBox3.getLowerLeftY());
    assertEquals(0.0f, bBox4.getLowerLeftY());
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0L, contentsForStreamParsing.getPosition());
    assertEquals(0L, contentsForStreamParsing2.getPosition());
    assertEquals(0L, contentsForStreamParsing3.getPosition());
    assertEquals(0L, contentsForStreamParsing4.getPosition());
    assertEquals(0L, contentsForRandomAccess.getPosition());
    assertEquals(0L, contentsForRandomAccess2.getPosition());
    assertEquals(0L, contentsForRandomAccess3.getPosition());
    assertEquals(0L, contentsForRandomAccess4.getPosition());
    assertEquals(1, cOSObject3.getValues().size());
    assertEquals(1, cOSObject3.size());
    assertEquals(1, normalAppearanceStream.getFormType());
    assertEquals(1, appearanceStream.getFormType());
    assertEquals(1, appearanceStream2.getFormType());
    assertEquals(1, appearanceStream3.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(18.0f, bBox.getHeight());
    assertEquals(18.0f, bBox2.getHeight());
    assertEquals(18.0f, bBox3.getHeight());
    assertEquals(18.0f, bBox4.getHeight());
    PDRectangle rectangle = pdAnnotationFileAttachment.getRectangle();
    assertEquals(18.0f, rectangle.getHeight());
    assertEquals(18.0f, bBox.getUpperRightX());
    assertEquals(18.0f, bBox2.getUpperRightX());
    assertEquals(18.0f, bBox3.getUpperRightX());
    assertEquals(18.0f, bBox4.getUpperRightX());
    assertEquals(18.0f, rectangle.getUpperRightX());
    assertEquals(18.0f, bBox.getUpperRightY());
    assertEquals(18.0f, bBox2.getUpperRightY());
    assertEquals(18.0f, bBox3.getUpperRightY());
    assertEquals(18.0f, bBox4.getUpperRightY());
    assertEquals(18.0f, bBox.getWidth());
    assertEquals(18.0f, bBox2.getWidth());
    assertEquals(18.0f, bBox3.getWidth());
    assertEquals(18.0f, bBox4.getWidth());
    assertEquals(18.0f, rectangle.getWidth());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertEquals(3352.3938f, rectangle.getLowerLeftY());
    COSDictionary cOSObject4 = pdAnnotationFileAttachment.getCOSObject();
    assertEquals(4, cOSObject4.getValues().size());
    assertEquals(4, cOSObject4.size());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertEquals(804, contentsForStreamParsing.available());
    assertEquals(804, contentsForStreamParsing2.available());
    assertEquals(804, contentsForStreamParsing3.available());
    assertEquals(804, contentsForStreamParsing4.available());
    assertEquals(804, contentsForRandomAccess.available());
    assertEquals(804, contentsForRandomAccess2.available());
    assertEquals(804, contentsForRandomAccess3.available());
    assertEquals(804, contentsForRandomAccess4.available());
    assertEquals(804, stream.getLength());
    assertEquals(804, stream2.getLength());
    assertEquals(804, stream3.getLength());
    assertEquals(804, stream4.getLength());
    assertEquals(804, contentStream.getLength());
    assertEquals(804, contentStream2.getLength());
    assertEquals(804, contentStream3.getLength());
    assertEquals(804, contentStream4.getLength());
    assertEquals(804L, cOSObject.getLength());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject3.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(updateState3.isUpdated());
    assertFalse(contentsForStreamParsing.isClosed());
    assertFalse(contentsForStreamParsing2.isClosed());
    assertFalse(contentsForStreamParsing3.isClosed());
    assertFalse(contentsForStreamParsing4.isClosed());
    assertFalse(contentsForRandomAccess.isClosed());
    assertFalse(contentsForRandomAccess2.isClosed());
    assertFalse(contentsForRandomAccess3.isClosed());
    assertFalse(contentsForRandomAccess4.isClosed());
    assertFalse(downAppearance.isSubDictionary());
    assertFalse(normalAppearance.isSubDictionary());
    assertFalse(rolloverAppearance.isSubDictionary());
    assertTrue(cOSObject2.getValues().isEmpty());
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(toIncrementResult3.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(cOSObject.hasData());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    COSArray cOSArray2 = bBox2.getCOSArray();
    assertEquals(toListResult, cOSArray2.toList());
    COSArray cOSArray3 = bBox3.getCOSArray();
    assertEquals(toListResult, cOSArray3.toList());
    COSArray cOSArray4 = bBox4.getCOSArray();
    assertEquals(toListResult, cOSArray4.toList());
    assertEquals(matrix, appearanceStream.getMatrix());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertEquals(matrix, appearanceStream3.getMatrix());
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(cOSObject2, resources3.getCOSObject());
    assertSame(cOSObject2, resources4.getCOSObject());
    assertSame(cOSArray, bBox.getCOSObject());
    assertSame(cOSArray2, bBox2.getCOSObject());
    assertSame(cOSArray3, bBox3.getCOSObject());
    assertSame(cOSArray4, bBox4.getCOSObject());
    assertSame(fileFilters, stream.getFileFilters());
    assertSame(fileFilters, stream2.getFileFilters());
    assertSame(fileFilters, stream3.getFileFilters());
    assertSame(fileFilters, stream4.getFileFilters());
    assertSame(fileFilters, contentStream2.getFileFilters());
    assertSame(fileFilters, contentStream3.getFileFilters());
    assertSame(fileFilters, contentStream4.getFileFilters());
    assertSame(fileFilters, stream.getFilters());
    assertSame(fileFilters, stream2.getFilters());
    assertSame(fileFilters, stream3.getFilters());
    assertSame(fileFilters, stream4.getFilters());
    assertSame(fileFilters, contentStream.getFilters());
    assertSame(fileFilters, contentStream2.getFilters());
    assertSame(fileFilters, contentStream3.getFilters());
    assertSame(fileFilters, contentStream4.getFilters());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, stream2.getCOSObject());
    assertSame(cOSObject, stream3.getCOSObject());
    assertSame(cOSObject, stream4.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, contentStream2.getCOSObject());
    assertSame(cOSObject, contentStream3.getCOSObject());
    assertSame(cOSObject, contentStream4.getCOSObject());
    assertSame(cOSObject, appearanceStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, appearanceStream3.getCOSObject());
    assertSame(cOSObject, downAppearance.getCOSObject());
    assertSame(cOSObject, normalAppearance.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(colorSpaceNames, resources3.getColorSpaceNames());
    assertSame(colorSpaceNames, resources4.getColorSpaceNames());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources2.getExtGStateNames());
    assertSame(colorSpaceNames, resources3.getExtGStateNames());
    assertSame(colorSpaceNames, resources4.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getFontNames());
    assertSame(colorSpaceNames, resources2.getFontNames());
    assertSame(colorSpaceNames, resources3.getFontNames());
    assertSame(colorSpaceNames, resources4.getFontNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources2.getPatternNames());
    assertSame(colorSpaceNames, resources3.getPatternNames());
    assertSame(colorSpaceNames, resources4.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources2.getPropertiesNames());
    assertSame(colorSpaceNames, resources3.getPropertiesNames());
    assertSame(colorSpaceNames, resources4.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources2.getShadingNames());
    assertSame(colorSpaceNames, resources3.getShadingNames());
    assertSame(colorSpaceNames, resources4.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(colorSpaceNames, resources2.getXObjectNames());
    assertSame(colorSpaceNames, resources3.getXObjectNames());
    assertSame(colorSpaceNames, resources4.getXObjectNames());
    assertArrayEquals("13.574 9.301 m\n8.926 13.949 l\n7.648 15.227 5.625 15".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("13.574 9.301 m\n8.926 13.949 l\n7.648 15.227 5.625 15".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("13.574 9.301 m\n8.926 13.949 l\n7.648 15.227 5.625 15".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("13.574 9.301 m\n8.926 13.949 l\n7.648 15.227 5.625 15".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test:
   * {@link PDAnnotationFileAttachment#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances6() throws IOException {
    // Arrange
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();
    pdAnnotationFileAttachment.setRectangle(PDRectangle.A0);
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);

    // Act
    pdAnnotationFileAttachment.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    PDAppearanceStream normalAppearanceStream = pdAnnotationFileAttachment.getNormalAppearanceStream();
    PDResources resources = normalAppearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDRectangle bBox = normalAppearanceStream.getBBox();
    COSArray cOSArray = bBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    assertTrue(toListResult.get(2) instanceof COSFloat);
    assertTrue(toListResult.get(3) instanceof COSFloat);
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationFileAttachment.getAppearance();
    PDAppearanceEntry downAppearance = appearance.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
    PDAppearanceStream appearanceStream2 = normalAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceEntry rolloverAppearance = appearance.getRolloverAppearance();
    PDAppearanceStream appearanceStream3 = rolloverAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadBuffer);
    PDStream stream = normalAppearanceStream.getStream();
    assertNull(stream.getDecodeParms());
    PDStream stream2 = appearanceStream.getStream();
    assertNull(stream2.getDecodeParms());
    PDStream stream3 = appearanceStream2.getStream();
    assertNull(stream3.getDecodeParms());
    PDStream stream4 = appearanceStream3.getStream();
    assertNull(stream4.getDecodeParms());
    PDStream contentStream = normalAppearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    PDStream contentStream2 = appearanceStream.getContentStream();
    assertNull(contentStream2.getDecodeParms());
    PDStream contentStream3 = appearanceStream2.getContentStream();
    assertNull(contentStream3.getDecodeParms());
    PDStream contentStream4 = appearanceStream3.getContentStream();
    assertNull(contentStream4.getDecodeParms());
    assertNull(stream.getFileDecodeParams());
    assertNull(stream2.getFileDecodeParams());
    assertNull(stream3.getFileDecodeParams());
    assertNull(stream4.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(contentStream2.getFileDecodeParams());
    assertNull(contentStream3.getFileDecodeParams());
    assertNull(contentStream4.getFileDecodeParams());
    COSStream cOSObject = normalAppearanceStream.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSUpdateState updateState2 = cOSObject.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSDictionary cOSObject3 = appearance.getCOSObject();
    COSUpdateState updateState3 = cOSObject3.getUpdateState();
    assertNull(updateState3.getOriginDocumentState());
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject3.getKey());
    assertNull(resources.getResourceCache());
    PDResources resources2 = appearanceStream.getResources();
    assertNull(resources2.getResourceCache());
    PDResources resources3 = appearanceStream2.getResources();
    assertNull(resources3.getResourceCache());
    PDResources resources4 = appearanceStream3.getResources();
    assertNull(resources4.getResourceCache());
    assertNull(stream.getMetadata());
    assertNull(stream2.getMetadata());
    assertNull(stream3.getMetadata());
    assertNull(stream4.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(contentStream2.getMetadata());
    assertNull(contentStream3.getMetadata());
    assertNull(contentStream4.getMetadata());
    assertNull(stream.getFile());
    assertNull(stream2.getFile());
    assertNull(stream3.getFile());
    assertNull(stream4.getFile());
    assertNull(contentStream.getFile());
    assertNull(contentStream2.getFile());
    assertNull(contentStream3.getFile());
    assertNull(contentStream4.getFile());
    assertNull(normalAppearanceStream.getOptionalContent());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream2.getOptionalContent());
    assertNull(appearanceStream3.getOptionalContent());
    assertNull(normalAppearanceStream.getGroup());
    assertNull(appearanceStream.getGroup());
    assertNull(appearanceStream2.getGroup());
    assertNull(appearanceStream3.getGroup());
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(-0.0f, matrix.getTranslateX());
    assertEquals(-0.0f, matrix.getTranslateY());
    assertEquals(-1, stream.getDecodedStreamLength());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, stream3.getDecodedStreamLength());
    assertEquals(-1, stream4.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, contentStream2.getDecodedStreamLength());
    assertEquals(-1, contentStream3.getDecodedStreamLength());
    assertEquals(-1, contentStream4.getDecodedStreamLength());
    assertEquals(-1, normalAppearanceStream.getStructParents());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(-1, appearanceStream2.getStructParents());
    assertEquals(-1, appearanceStream3.getStructParents());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getLowerLeftX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(0.0f, bBox2.getLowerLeftX());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(0.0f, bBox3.getLowerLeftX());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(0.0f, bBox4.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(0.0f, bBox2.getLowerLeftY());
    assertEquals(0.0f, bBox3.getLowerLeftY());
    assertEquals(0.0f, bBox4.getLowerLeftY());
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0L, contentsForStreamParsing.getPosition());
    assertEquals(0L, contentsForStreamParsing2.getPosition());
    assertEquals(0L, contentsForStreamParsing3.getPosition());
    assertEquals(0L, contentsForStreamParsing4.getPosition());
    assertEquals(0L, contentsForRandomAccess.getPosition());
    assertEquals(0L, contentsForRandomAccess2.getPosition());
    assertEquals(0L, contentsForRandomAccess3.getPosition());
    assertEquals(0L, contentsForRandomAccess4.getPosition());
    assertEquals(1, cOSObject3.getValues().size());
    assertEquals(1, cOSObject3.size());
    assertEquals(1, normalAppearanceStream.getFormType());
    assertEquals(1, appearanceStream.getFormType());
    assertEquals(1, appearanceStream2.getFormType());
    assertEquals(1, appearanceStream3.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(18.0f, bBox.getHeight());
    assertEquals(18.0f, bBox2.getHeight());
    assertEquals(18.0f, bBox3.getHeight());
    assertEquals(18.0f, bBox4.getHeight());
    PDRectangle rectangle = pdAnnotationFileAttachment.getRectangle();
    assertEquals(18.0f, rectangle.getHeight());
    assertEquals(18.0f, bBox.getUpperRightX());
    assertEquals(18.0f, bBox2.getUpperRightX());
    assertEquals(18.0f, bBox3.getUpperRightX());
    assertEquals(18.0f, bBox4.getUpperRightX());
    assertEquals(18.0f, rectangle.getUpperRightX());
    assertEquals(18.0f, bBox.getUpperRightY());
    assertEquals(18.0f, bBox2.getUpperRightY());
    assertEquals(18.0f, bBox3.getUpperRightY());
    assertEquals(18.0f, bBox4.getUpperRightY());
    assertEquals(18.0f, bBox.getWidth());
    assertEquals(18.0f, bBox2.getWidth());
    assertEquals(18.0f, bBox3.getWidth());
    assertEquals(18.0f, bBox4.getWidth());
    assertEquals(18.0f, rectangle.getWidth());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertEquals(3352.3938f, rectangle.getLowerLeftY());
    COSDictionary cOSObject4 = pdAnnotationFileAttachment.getCOSObject();
    assertEquals(4, cOSObject4.getValues().size());
    assertEquals(4, cOSObject4.size());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertEquals(804, contentsForStreamParsing.available());
    assertEquals(804, contentsForStreamParsing2.available());
    assertEquals(804, contentsForStreamParsing3.available());
    assertEquals(804, contentsForStreamParsing4.available());
    assertEquals(804, contentsForRandomAccess.available());
    assertEquals(804, contentsForRandomAccess2.available());
    assertEquals(804, contentsForRandomAccess3.available());
    assertEquals(804, contentsForRandomAccess4.available());
    assertEquals(804, stream.getLength());
    assertEquals(804, stream2.getLength());
    assertEquals(804, stream3.getLength());
    assertEquals(804, stream4.getLength());
    assertEquals(804, contentStream.getLength());
    assertEquals(804, contentStream2.getLength());
    assertEquals(804, contentStream3.getLength());
    assertEquals(804, contentStream4.getLength());
    assertEquals(804L, cOSObject.getLength());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject3.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(updateState3.isUpdated());
    assertFalse(contentsForStreamParsing.isClosed());
    assertFalse(contentsForStreamParsing2.isClosed());
    assertFalse(contentsForStreamParsing3.isClosed());
    assertFalse(contentsForStreamParsing4.isClosed());
    assertFalse(contentsForRandomAccess.isClosed());
    assertFalse(contentsForRandomAccess2.isClosed());
    assertFalse(contentsForRandomAccess3.isClosed());
    assertFalse(contentsForRandomAccess4.isClosed());
    assertFalse(downAppearance.isSubDictionary());
    assertFalse(normalAppearance.isSubDictionary());
    assertFalse(rolloverAppearance.isSubDictionary());
    assertTrue(cOSObject2.getValues().isEmpty());
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(toIncrementResult3.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(cOSObject.hasData());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    COSArray cOSArray2 = bBox2.getCOSArray();
    assertEquals(toListResult, cOSArray2.toList());
    COSArray cOSArray3 = bBox3.getCOSArray();
    assertEquals(toListResult, cOSArray3.toList());
    COSArray cOSArray4 = bBox4.getCOSArray();
    assertEquals(toListResult, cOSArray4.toList());
    assertEquals(matrix, appearanceStream.getMatrix());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertEquals(matrix, appearanceStream3.getMatrix());
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(cOSObject2, resources3.getCOSObject());
    assertSame(cOSObject2, resources4.getCOSObject());
    assertSame(cOSArray, bBox.getCOSObject());
    assertSame(cOSArray2, bBox2.getCOSObject());
    assertSame(cOSArray3, bBox3.getCOSObject());
    assertSame(cOSArray4, bBox4.getCOSObject());
    assertSame(fileFilters, stream.getFileFilters());
    assertSame(fileFilters, stream2.getFileFilters());
    assertSame(fileFilters, stream3.getFileFilters());
    assertSame(fileFilters, stream4.getFileFilters());
    assertSame(fileFilters, contentStream2.getFileFilters());
    assertSame(fileFilters, contentStream3.getFileFilters());
    assertSame(fileFilters, contentStream4.getFileFilters());
    assertSame(fileFilters, stream.getFilters());
    assertSame(fileFilters, stream2.getFilters());
    assertSame(fileFilters, stream3.getFilters());
    assertSame(fileFilters, stream4.getFilters());
    assertSame(fileFilters, contentStream.getFilters());
    assertSame(fileFilters, contentStream2.getFilters());
    assertSame(fileFilters, contentStream3.getFilters());
    assertSame(fileFilters, contentStream4.getFilters());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, stream2.getCOSObject());
    assertSame(cOSObject, stream3.getCOSObject());
    assertSame(cOSObject, stream4.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, contentStream2.getCOSObject());
    assertSame(cOSObject, contentStream3.getCOSObject());
    assertSame(cOSObject, contentStream4.getCOSObject());
    assertSame(cOSObject, appearanceStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, appearanceStream3.getCOSObject());
    assertSame(cOSObject, downAppearance.getCOSObject());
    assertSame(cOSObject, normalAppearance.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(colorSpaceNames, resources3.getColorSpaceNames());
    assertSame(colorSpaceNames, resources4.getColorSpaceNames());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources2.getExtGStateNames());
    assertSame(colorSpaceNames, resources3.getExtGStateNames());
    assertSame(colorSpaceNames, resources4.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getFontNames());
    assertSame(colorSpaceNames, resources2.getFontNames());
    assertSame(colorSpaceNames, resources3.getFontNames());
    assertSame(colorSpaceNames, resources4.getFontNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources2.getPatternNames());
    assertSame(colorSpaceNames, resources3.getPatternNames());
    assertSame(colorSpaceNames, resources4.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources2.getPropertiesNames());
    assertSame(colorSpaceNames, resources3.getPropertiesNames());
    assertSame(colorSpaceNames, resources4.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources2.getShadingNames());
    assertSame(colorSpaceNames, resources3.getShadingNames());
    assertSame(colorSpaceNames, resources4.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(colorSpaceNames, resources2.getXObjectNames());
    assertSame(colorSpaceNames, resources3.getXObjectNames());
    assertSame(colorSpaceNames, resources4.getXObjectNames());
    assertArrayEquals("13.574 9.301 m\n8.926 13.949 l\n7.648 15.227 5.625 15".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("13.574 9.301 m\n8.926 13.949 l\n7.648 15.227 5.625 15".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("13.574 9.301 m\n8.926 13.949 l\n7.648 15.227 5.625 15".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("13.574 9.301 m\n8.926 13.949 l\n7.648 15.227 5.625 15".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test:
   * {@link PDAnnotationFileAttachment#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances7() throws IOException {
    // Arrange
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();
    pdAnnotationFileAttachment.setRectangle(PDRectangle.A0);
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(1L)));

    // Act
    pdAnnotationFileAttachment.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    PDAppearanceStream normalAppearanceStream = pdAnnotationFileAttachment.getNormalAppearanceStream();
    PDResources resources = normalAppearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDStream stream = normalAppearanceStream.getStream();
    assertNull(stream.getDecodeParms());
    PDAppearanceDictionary appearance = pdAnnotationFileAttachment.getAppearance();
    PDAppearanceEntry downAppearance = appearance.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDStream stream2 = appearanceStream.getStream();
    assertNull(stream2.getDecodeParms());
    PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
    PDAppearanceStream appearanceStream2 = normalAppearance.getAppearanceStream();
    PDStream stream3 = appearanceStream2.getStream();
    assertNull(stream3.getDecodeParms());
    PDAppearanceEntry rolloverAppearance = appearance.getRolloverAppearance();
    PDAppearanceStream appearanceStream3 = rolloverAppearance.getAppearanceStream();
    PDStream stream4 = appearanceStream3.getStream();
    assertNull(stream4.getDecodeParms());
    PDStream contentStream = normalAppearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    PDStream contentStream2 = appearanceStream.getContentStream();
    assertNull(contentStream2.getDecodeParms());
    PDStream contentStream3 = appearanceStream2.getContentStream();
    assertNull(contentStream3.getDecodeParms());
    PDStream contentStream4 = appearanceStream3.getContentStream();
    assertNull(contentStream4.getDecodeParms());
    assertNull(stream.getFileDecodeParams());
    assertNull(stream2.getFileDecodeParams());
    assertNull(stream3.getFileDecodeParams());
    assertNull(stream4.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(contentStream2.getFileDecodeParams());
    assertNull(contentStream3.getFileDecodeParams());
    assertNull(contentStream4.getFileDecodeParams());
    COSStream cOSObject = normalAppearanceStream.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSUpdateState updateState2 = cOSObject.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSDictionary cOSObject3 = appearance.getCOSObject();
    COSUpdateState updateState3 = cOSObject3.getUpdateState();
    assertNull(updateState3.getOriginDocumentState());
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject3.getKey());
    assertNull(resources.getResourceCache());
    PDResources resources2 = appearanceStream.getResources();
    assertNull(resources2.getResourceCache());
    PDResources resources3 = appearanceStream2.getResources();
    assertNull(resources3.getResourceCache());
    PDResources resources4 = appearanceStream3.getResources();
    assertNull(resources4.getResourceCache());
    assertNull(stream.getMetadata());
    assertNull(stream2.getMetadata());
    assertNull(stream3.getMetadata());
    assertNull(stream4.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(contentStream2.getMetadata());
    assertNull(contentStream3.getMetadata());
    assertNull(contentStream4.getMetadata());
    assertNull(stream.getFile());
    assertNull(stream2.getFile());
    assertNull(stream3.getFile());
    assertNull(stream4.getFile());
    assertNull(contentStream.getFile());
    assertNull(contentStream2.getFile());
    assertNull(contentStream3.getFile());
    assertNull(contentStream4.getFile());
    assertNull(normalAppearanceStream.getOptionalContent());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream2.getOptionalContent());
    assertNull(appearanceStream3.getOptionalContent());
    assertNull(normalAppearanceStream.getGroup());
    assertNull(appearanceStream.getGroup());
    assertNull(appearanceStream2.getGroup());
    assertNull(appearanceStream3.getGroup());
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(-0.0f, matrix.getTranslateX());
    assertEquals(-0.0f, matrix.getTranslateY());
    assertEquals(-1, stream.getDecodedStreamLength());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, stream3.getDecodedStreamLength());
    assertEquals(-1, stream4.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, contentStream2.getDecodedStreamLength());
    assertEquals(-1, contentStream3.getDecodedStreamLength());
    assertEquals(-1, contentStream4.getDecodedStreamLength());
    assertEquals(-1, normalAppearanceStream.getStructParents());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(-1, appearanceStream2.getStructParents());
    assertEquals(-1, appearanceStream3.getStructParents());
    assertEquals(0, cOSObject2.size());
    assertEquals(0, stream.getLength());
    assertEquals(0, stream2.getLength());
    assertEquals(0, stream3.getLength());
    assertEquals(0, stream4.getLength());
    assertEquals(0, contentStream.getLength());
    assertEquals(0, contentStream2.getLength());
    assertEquals(0, contentStream3.getLength());
    assertEquals(0, contentStream4.getLength());
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(0.0f, bBox.getLowerLeftX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(0.0f, bBox2.getLowerLeftX());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(0.0f, bBox3.getLowerLeftX());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(0.0f, bBox4.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(0.0f, bBox2.getLowerLeftY());
    assertEquals(0.0f, bBox3.getLowerLeftY());
    assertEquals(0.0f, bBox4.getLowerLeftY());
    PDRectangle rectangle = pdAnnotationFileAttachment.getRectangle();
    assertEquals(0.0f, rectangle.getLowerLeftY());
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(1, cOSObject3.getValues().size());
    assertEquals(1, cOSObject3.size());
    assertEquals(1, normalAppearanceStream.getFormType());
    assertEquals(1, appearanceStream.getFormType());
    assertEquals(1, appearanceStream2.getFormType());
    assertEquals(1, appearanceStream3.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(2383.937f, bBox.getUpperRightX());
    assertEquals(2383.937f, bBox2.getUpperRightX());
    assertEquals(2383.937f, bBox3.getUpperRightX());
    assertEquals(2383.937f, bBox4.getUpperRightX());
    assertEquals(2383.937f, rectangle.getUpperRightX());
    assertEquals(2383.937f, bBox.getWidth());
    assertEquals(2383.937f, bBox2.getWidth());
    assertEquals(2383.937f, bBox3.getWidth());
    assertEquals(2383.937f, bBox4.getWidth());
    assertEquals(2383.937f, rectangle.getWidth());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertEquals(3370.3938f, bBox.getHeight());
    assertEquals(3370.3938f, bBox2.getHeight());
    assertEquals(3370.3938f, bBox3.getHeight());
    assertEquals(3370.3938f, bBox4.getHeight());
    assertEquals(3370.3938f, rectangle.getHeight());
    assertEquals(3370.3938f, bBox.getUpperRightY());
    assertEquals(3370.3938f, bBox2.getUpperRightY());
    assertEquals(3370.3938f, bBox3.getUpperRightY());
    assertEquals(3370.3938f, bBox4.getUpperRightY());
    COSDictionary cOSObject4 = pdAnnotationFileAttachment.getCOSObject();
    assertEquals(4, cOSObject4.getValues().size());
    assertEquals(4, cOSObject4.size());
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject3.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(updateState3.isUpdated());
    assertFalse(downAppearance.isSubDictionary());
    assertFalse(normalAppearance.isSubDictionary());
    assertFalse(rolloverAppearance.isSubDictionary());
    assertTrue(cOSObject2.getValues().isEmpty());
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(toIncrementResult3.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    assertEquals(matrix, appearanceStream.getMatrix());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertEquals(matrix, appearanceStream3.getMatrix());
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(cOSObject2, resources3.getCOSObject());
    assertSame(cOSObject2, resources4.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
    COSArray expectedCOSObject2 = bBox2.getCOSArray();
    assertSame(expectedCOSObject2, bBox2.getCOSObject());
    COSArray expectedCOSObject3 = bBox3.getCOSArray();
    assertSame(expectedCOSObject3, bBox3.getCOSObject());
    COSArray expectedCOSObject4 = bBox4.getCOSArray();
    assertSame(expectedCOSObject4, bBox4.getCOSObject());
    assertSame(fileFilters, stream.getFileFilters());
    assertSame(fileFilters, stream2.getFileFilters());
    assertSame(fileFilters, stream3.getFileFilters());
    assertSame(fileFilters, stream4.getFileFilters());
    assertSame(fileFilters, contentStream2.getFileFilters());
    assertSame(fileFilters, contentStream3.getFileFilters());
    assertSame(fileFilters, contentStream4.getFileFilters());
    assertSame(fileFilters, stream.getFilters());
    assertSame(fileFilters, stream2.getFilters());
    assertSame(fileFilters, stream3.getFilters());
    assertSame(fileFilters, stream4.getFilters());
    assertSame(fileFilters, contentStream.getFilters());
    assertSame(fileFilters, contentStream2.getFilters());
    assertSame(fileFilters, contentStream3.getFilters());
    assertSame(fileFilters, contentStream4.getFilters());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, stream2.getCOSObject());
    assertSame(cOSObject, stream3.getCOSObject());
    assertSame(cOSObject, stream4.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, contentStream2.getCOSObject());
    assertSame(cOSObject, contentStream3.getCOSObject());
    assertSame(cOSObject, contentStream4.getCOSObject());
    assertSame(cOSObject, appearanceStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, appearanceStream3.getCOSObject());
    assertSame(cOSObject, downAppearance.getCOSObject());
    assertSame(cOSObject, normalAppearance.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(colorSpaceNames, resources3.getColorSpaceNames());
    assertSame(colorSpaceNames, resources4.getColorSpaceNames());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources2.getExtGStateNames());
    assertSame(colorSpaceNames, resources3.getExtGStateNames());
    assertSame(colorSpaceNames, resources4.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getFontNames());
    assertSame(colorSpaceNames, resources2.getFontNames());
    assertSame(colorSpaceNames, resources3.getFontNames());
    assertSame(colorSpaceNames, resources4.getFontNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources2.getPatternNames());
    assertSame(colorSpaceNames, resources3.getPatternNames());
    assertSame(colorSpaceNames, resources4.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources2.getPropertiesNames());
    assertSame(colorSpaceNames, resources3.getPropertiesNames());
    assertSame(colorSpaceNames, resources4.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources2.getShadingNames());
    assertSame(colorSpaceNames, resources3.getShadingNames());
    assertSame(colorSpaceNames, resources4.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(colorSpaceNames, resources2.getXObjectNames());
    assertSame(colorSpaceNames, resources3.getXObjectNames());
    assertSame(colorSpaceNames, resources4.getXObjectNames());
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test:
   * {@link PDAnnotationFileAttachment#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances8() {
    // Arrange
    PDAnnotationCircle annotation = new PDAnnotationCircle();
    annotation.setRectangle(PDRectangle.A0);
    PDCircleAppearanceHandler appearanceHandler = new PDCircleAppearanceHandler(annotation);

    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();
    pdAnnotationFileAttachment.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationFileAttachment.constructAppearances(new PDDocument());

    // Assert
    assertNull(pdAnnotationFileAttachment.getRectangle());
    assertNull(pdAnnotationFileAttachment.getAppearance());
    assertNull(pdAnnotationFileAttachment.getNormalAppearanceStream());
    COSDictionary cOSObject = pdAnnotationFileAttachment.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }
}
