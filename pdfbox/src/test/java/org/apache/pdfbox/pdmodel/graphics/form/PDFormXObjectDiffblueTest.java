package org.apache.pdfbox.pdmodel.graphics.form;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDPropertyList;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDFormXObjectDiffblueTest {
  /**
   * Test {@link PDFormXObject#PDFormXObject(PDStream)}.
   * <ul>
   *   <li>Then return ContentStream DecodeParms is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFormXObject#PDFormXObject(PDStream)}
   */
  @Test
  @DisplayName("Test new PDFormXObject(PDStream); then return ContentStream DecodeParms is 'null'")
  void testNewPDFormXObject_thenReturnContentStreamDecodeParmsIsNull() throws IOException {
    // Arrange
    PDStream stream = new PDStream(new COSDocument());

    // Act
    PDFormXObject actualPdFormXObject = new PDFormXObject(stream);

    // Assert
    PDStream contentStream = actualPdFormXObject.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(contentStream.getFileDecodeParams());
    COSStream cOSObject = actualPdFormXObject.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdFormXObject.getResources());
    assertNull(contentStream.getMetadata());
    assertNull(actualPdFormXObject.getBBox());
    assertNull(contentStream.getFile());
    assertNull(actualPdFormXObject.getOptionalContent());
    assertNull(actualPdFormXObject.getGroup());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, actualPdFormXObject.getStructParents());
    assertEquals(0, contentStream.getLength());
    Matrix matrix = actualPdFormXObject.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(1, actualPdFormXObject.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(stream, actualPdFormXObject.getStream());
    assertSame(fileFilters, contentStream.getFilters());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDFormXObject#PDFormXObject(COSStream)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return Stream DecodeParms is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFormXObject#PDFormXObject(COSStream)}
   */
  @Test
  @DisplayName("Test new PDFormXObject(COSStream); when COSStream(); then return Stream DecodeParms is 'null'")
  void testNewPDFormXObject_whenCOSStream_thenReturnStreamDecodeParmsIsNull() throws IOException {
    // Arrange
    COSStream stream = new COSStream();

    // Act
    PDFormXObject actualPdFormXObject = new PDFormXObject(stream);

    // Assert
    PDStream stream2 = actualPdFormXObject.getStream();
    assertNull(stream2.getDecodeParms());
    PDStream contentStream = actualPdFormXObject.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(stream2.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(actualPdFormXObject.getResources());
    assertNull(stream2.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(actualPdFormXObject.getBBox());
    assertNull(stream2.getFile());
    assertNull(contentStream.getFile());
    assertNull(actualPdFormXObject.getOptionalContent());
    assertNull(actualPdFormXObject.getGroup());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, actualPdFormXObject.getStructParents());
    assertEquals(0, stream2.getLength());
    assertEquals(0, contentStream.getLength());
    Matrix matrix = actualPdFormXObject.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(1, actualPdFormXObject.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(3, stream.size());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(stream, stream2.getCOSObject());
    assertSame(stream, contentStream.getCOSObject());
    assertSame(stream, actualPdFormXObject.getCOSObject());
    assertSame(fileFilters, stream2.getFileFilters());
    assertSame(fileFilters, stream2.getFilters());
    assertSame(fileFilters, contentStream.getFilters());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDFormXObject#PDFormXObject(COSStream, ResourceCache)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return Stream DecodeParms is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFormXObject#PDFormXObject(COSStream, ResourceCache)}
   */
  @Test
  @DisplayName("Test new PDFormXObject(COSStream, ResourceCache); when COSStream(); then return Stream DecodeParms is 'null'")
  void testNewPDFormXObject_whenCOSStream_thenReturnStreamDecodeParmsIsNull2() throws IOException {
    // Arrange
    COSStream stream = new COSStream();

    // Act
    PDFormXObject actualPdFormXObject = new PDFormXObject(stream, new DefaultResourceCache());

    // Assert
    PDStream stream2 = actualPdFormXObject.getStream();
    assertNull(stream2.getDecodeParms());
    PDStream contentStream = actualPdFormXObject.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(stream2.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(actualPdFormXObject.getResources());
    assertNull(stream2.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(actualPdFormXObject.getBBox());
    assertNull(stream2.getFile());
    assertNull(contentStream.getFile());
    assertNull(actualPdFormXObject.getOptionalContent());
    assertNull(actualPdFormXObject.getGroup());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, actualPdFormXObject.getStructParents());
    assertEquals(0, stream2.getLength());
    assertEquals(0, contentStream.getLength());
    Matrix matrix = actualPdFormXObject.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(1, actualPdFormXObject.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(3, stream.size());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(stream, stream2.getCOSObject());
    assertSame(stream, contentStream.getCOSObject());
    assertSame(stream, actualPdFormXObject.getCOSObject());
    assertSame(fileFilters, stream2.getFileFilters());
    assertSame(fileFilters, stream2.getFilters());
    assertSame(fileFilters, contentStream.getFilters());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDFormXObject#PDFormXObject(PDDocument)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return Stream DecodeParms is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFormXObject#PDFormXObject(PDDocument)}
   */
  @Test
  @DisplayName("Test new PDFormXObject(PDDocument); when PDDocument(); then return Stream DecodeParms is 'null'")
  void testNewPDFormXObject_whenPDDocument_thenReturnStreamDecodeParmsIsNull() throws IOException {
    // Arrange and Act
    PDFormXObject actualPdFormXObject = new PDFormXObject(new PDDocument());

    // Assert
    PDStream stream = actualPdFormXObject.getStream();
    assertNull(stream.getDecodeParms());
    PDStream contentStream = actualPdFormXObject.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(stream.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    COSStream cOSObject = actualPdFormXObject.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdFormXObject.getResources());
    assertNull(stream.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(actualPdFormXObject.getBBox());
    assertNull(stream.getFile());
    assertNull(contentStream.getFile());
    assertNull(actualPdFormXObject.getOptionalContent());
    assertNull(actualPdFormXObject.getGroup());
    assertEquals(-1, stream.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, actualPdFormXObject.getStructParents());
    assertEquals(0, stream.getLength());
    assertEquals(0, contentStream.getLength());
    Matrix matrix = actualPdFormXObject.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(1, actualPdFormXObject.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, stream.getFileFilters());
    assertSame(fileFilters, stream.getFilters());
    assertSame(fileFilters, contentStream.getFilters());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDFormXObject#getFormType()}.
   * <p>
   * Method under test: {@link PDFormXObject#getFormType()}
   */
  @Test
  @DisplayName("Test getFormType()")
  void testGetFormType() {
    // Arrange, Act and Assert
    assertEquals(1, (new PDFormXObject(new COSStream())).getFormType());
  }

  /**
   * Test {@link PDFormXObject#setFormType(int)}.
   * <p>
   * Method under test: {@link PDFormXObject#setFormType(int)}
   */
  @Test
  @DisplayName("Test setFormType(int)")
  void testSetFormType() {
    // Arrange
    PDFormXObject pdFormXObject = new PDFormXObject(new COSStream());

    // Act
    pdFormXObject.setFormType(1);

    // Assert
    COSStream cOSObject = pdFormXObject.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDFormXObject#getGroup()}.
   * <p>
   * Method under test: {@link PDFormXObject#getGroup()}
   */
  @Test
  @DisplayName("Test getGroup()")
  void testGetGroup() {
    // Arrange, Act and Assert
    assertNull((new PDFormXObject(new COSStream())).getGroup());
  }

  /**
   * Test {@link PDFormXObject#getContentStream()}.
   * <p>
   * Method under test: {@link PDFormXObject#getContentStream()}
   */
  @Test
  @DisplayName("Test getContentStream()")
  void testGetContentStream() throws IOException {
    // Arrange
    COSStream stream = new COSStream();

    // Act
    PDStream actualContentStream = (new PDFormXObject(stream)).getContentStream();

    // Assert
    assertNull(actualContentStream.getDecodeParms());
    assertNull(actualContentStream.getFileDecodeParams());
    assertNull(actualContentStream.getMetadata());
    assertNull(actualContentStream.getFile());
    assertEquals(-1, actualContentStream.getDecodedStreamLength());
    assertEquals(0, actualContentStream.getLength());
    List<String> fileFilters = actualContentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(stream, actualContentStream.getCOSObject());
    assertSame(fileFilters, actualContentStream.getFilters());
  }

  /**
   * Test {@link PDFormXObject#getResources()}.
   * <p>
   * Method under test: {@link PDFormXObject#getResources()}
   */
  @Test
  @DisplayName("Test getResources()")
  void testGetResources() {
    // Arrange, Act and Assert
    assertNull((new PDFormXObject(new COSStream())).getResources());
  }

  /**
   * Test {@link PDFormXObject#setResources(PDResources)}.
   * <p>
   * Method under test: {@link PDFormXObject#setResources(PDResources)}
   */
  @Test
  @DisplayName("Test setResources(PDResources)")
  void testSetResources() {
    // Arrange
    PDFormXObject pdFormXObject = new PDFormXObject(new COSStream());

    // Act
    pdFormXObject.setResources(new PDResources());

    // Assert
    assertNull(pdFormXObject.getResources().getResourceCache());
    COSStream cOSObject = pdFormXObject.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDFormXObject#getBBox()}.
   * <p>
   * Method under test: {@link PDFormXObject#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox()")
  void testGetBBox() {
    // Arrange, Act and Assert
    assertNull((new PDFormXObject(new COSStream())).getBBox());
  }

  /**
   * Test {@link PDFormXObject#setBBox(PDRectangle)}.
   * <ul>
   *   <li>Then {@link PDFormXObject#PDFormXObject(COSStream)} with stream is
   * {@link COSStream#COSStream()} COSObject Values size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFormXObject#setBBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setBBox(PDRectangle); then PDFormXObject(COSStream) with stream is COSStream() COSObject Values size is three")
  void testSetBBox_thenPDFormXObjectWithStreamIsCOSStreamCOSObjectValuesSizeIsThree() {
    // Arrange
    PDFormXObject pdFormXObject = new PDFormXObject(new COSStream());

    // Act
    pdFormXObject.setBBox(null);

    // Assert
    COSStream cOSObject = pdFormXObject.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDFormXObject#getMatrix()}.
   * <p>
   * Method under test: {@link PDFormXObject#getMatrix()}
   */
  @Test
  @DisplayName("Test getMatrix()")
  void testGetMatrix() {
    // Arrange and Act
    Matrix actualMatrix = (new PDFormXObject(new COSStream())).getMatrix();

    // Assert
    assertEquals(0.0f, actualMatrix.getShearX());
    assertEquals(0.0f, actualMatrix.getShearY());
    assertEquals(0.0f, actualMatrix.getTranslateX());
    assertEquals(0.0f, actualMatrix.getTranslateY());
    assertEquals(1.0f, actualMatrix.getScaleX());
    assertEquals(1.0f, actualMatrix.getScaleY());
    assertEquals(1.0f, actualMatrix.getScalingFactorX());
    assertEquals(1.0f, actualMatrix.getScalingFactorY());
    float[][] values = actualMatrix.getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDFormXObject#setMatrix(AffineTransform)}.
   * <p>
   * Method under test: {@link PDFormXObject#setMatrix(AffineTransform)}
   */
  @Test
  @DisplayName("Test setMatrix(AffineTransform)")
  void testSetMatrix() {
    // Arrange
    PDFormXObject pdFormXObject = new PDFormXObject(new COSStream());

    // Act
    pdFormXObject.setMatrix(new AffineTransform());

    // Assert
    COSStream cOSObject = pdFormXObject.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDFormXObject#getStructParents()}.
   * <p>
   * Method under test: {@link PDFormXObject#getStructParents()}
   */
  @Test
  @DisplayName("Test getStructParents()")
  void testGetStructParents() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDFormXObject(new COSStream())).getStructParents());
  }

  /**
   * Test {@link PDFormXObject#setStructParents(int)}.
   * <p>
   * Method under test: {@link PDFormXObject#setStructParents(int)}
   */
  @Test
  @DisplayName("Test setStructParents(int)")
  void testSetStructParents() {
    // Arrange
    PDFormXObject pdFormXObject = new PDFormXObject(new COSStream());

    // Act
    pdFormXObject.setStructParents(1);

    // Assert
    assertEquals(1, pdFormXObject.getStructParents());
    COSStream cOSObject = pdFormXObject.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDFormXObject#setOptionalContent(PDPropertyList)}.
   * <p>
   * Method under test: {@link PDFormXObject#setOptionalContent(PDPropertyList)}
   */
  @Test
  @DisplayName("Test setOptionalContent(PDPropertyList)")
  void testSetOptionalContent() {
    // Arrange
    PDFormXObject pdFormXObject = new PDFormXObject(new COSStream());
    PDPropertyList oc = mock(PDPropertyList.class);
    when(oc.getCOSObject()).thenReturn(null);

    // Act
    pdFormXObject.setOptionalContent(oc);

    // Assert
    verify(oc).getCOSObject();
    COSStream cOSObject = pdFormXObject.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDFormXObject#setOptionalContent(PDPropertyList)}.
   * <p>
   * Method under test: {@link PDFormXObject#setOptionalContent(PDPropertyList)}
   */
  @Test
  @DisplayName("Test setOptionalContent(PDPropertyList)")
  void testSetOptionalContent2() {
    // Arrange
    PDFormXObject pdFormXObject = new PDFormXObject(new COSStream());

    COSDictionary cosDictionary = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);

    cosDictionary.setKey(key);
    PDPropertyList oc = mock(PDPropertyList.class);
    when(oc.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdFormXObject.setOptionalContent(oc);

    // Assert
    verify(oc).getCOSObject();
    assertSame(key, pdFormXObject.getOptionalContent().getCOSObject().getKey());
  }

  /**
   * Test {@link PDFormXObject#setOptionalContent(PDPropertyList)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFormXObject#setOptionalContent(PDPropertyList)}
   */
  @Test
  @DisplayName("Test setOptionalContent(PDPropertyList); given COSDictionary()")
  void testSetOptionalContent_givenCOSDictionary() {
    // Arrange
    PDFormXObject pdFormXObject = new PDFormXObject(new COSStream());
    PDPropertyList oc = mock(PDPropertyList.class);
    COSDictionary cosDictionary = new COSDictionary();
    when(oc.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdFormXObject.setOptionalContent(oc);

    // Assert
    verify(oc).getCOSObject();
    COSStream cOSObject = pdFormXObject.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertSame(cosDictionary, pdFormXObject.getOptionalContent().getCOSObject());
  }

  /**
   * Test {@link PDFormXObject#setOptionalContent(PDPropertyList)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFormXObject#setOptionalContent(PDPropertyList)}
   */
  @Test
  @DisplayName("Test setOptionalContent(PDPropertyList); given COSDictionary() Direct is 'true'")
  void testSetOptionalContent_givenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDFormXObject pdFormXObject = new PDFormXObject(new COSStream());

    COSDictionary cosDictionary = new COSDictionary();
    cosDictionary.setDirect(true);
    PDPropertyList oc = mock(PDPropertyList.class);
    when(oc.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdFormXObject.setOptionalContent(oc);

    // Assert
    verify(oc).getCOSObject();
    COSStream cOSObject = pdFormXObject.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertSame(cosDictionary, pdFormXObject.getOptionalContent().getCOSObject());
  }
}
