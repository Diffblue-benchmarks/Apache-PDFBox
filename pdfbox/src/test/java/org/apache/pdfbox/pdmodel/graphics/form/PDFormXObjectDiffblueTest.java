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
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDPropertyList;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;

class PDFormXObjectDiffblueTest {
  /**
   * Method under test: {@link PDFormXObject#getFormType()}
   */
  @Test
  void testGetFormType() {
    // Arrange, Act and Assert
    assertEquals(1, (new PDFormXObject(new COSStream())).getFormType());
  }

  /**
   * Method under test: {@link PDFormXObject#setFormType(int)}
   */
  @Test
  void testSetFormType() {
    // Arrange
    COSStream stream = new COSStream();
    PDFormXObject pdFormXObject = new PDFormXObject(stream);

    // Act
    pdFormXObject.setFormType(1);

    // Assert
    assertSame(stream, pdFormXObject.getCOSObject());
  }

  /**
   * Method under test: {@link PDFormXObject#getGroup()}
   */
  @Test
  void testGetGroup() {
    // Arrange, Act and Assert
    assertNull((new PDFormXObject(new COSStream())).getGroup());
  }

  /**
   * Method under test: {@link PDFormXObject#getContentStream()}
   */
  @Test
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
   * Method under test: {@link PDFormXObject#getResources()}
   */
  @Test
  void testGetResources() {
    // Arrange, Act and Assert
    assertNull((new PDFormXObject(new COSStream())).getResources());
  }

  /**
   * Method under test: {@link PDFormXObject#setResources(PDResources)}
   */
  @Test
  void testSetResources() {
    // Arrange
    COSStream stream = new COSStream();
    PDFormXObject pdFormXObject = new PDFormXObject(stream);

    // Act
    pdFormXObject.setResources(new PDResources());

    // Assert
    assertNull(pdFormXObject.getResources().getResourceCache());
    assertSame(stream, pdFormXObject.getCOSObject());
  }

  /**
   * Method under test: {@link PDFormXObject#getBBox()}
   */
  @Test
  void testGetBBox() {
    // Arrange, Act and Assert
    assertNull((new PDFormXObject(new COSStream())).getBBox());
  }

  /**
   * Method under test: {@link PDFormXObject#setBBox(PDRectangle)}
   */
  @Test
  void testSetBBox() {
    // Arrange
    COSStream stream = new COSStream();
    PDFormXObject pdFormXObject = new PDFormXObject(stream);

    // Act
    pdFormXObject.setBBox(PDRectangle.A0);

    // Assert
    PDRectangle bBox = pdFormXObject.getBBox();
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(2383.937f, bBox.getUpperRightX());
    assertEquals(2383.937f, bBox.getWidth());
    assertEquals(3370.3938f, bBox.getHeight());
    assertEquals(3370.3938f, bBox.getUpperRightY());
    assertSame(stream, pdFormXObject.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDFormXObject#setBBox(PDRectangle)}
   */
  @Test
  void testSetBBox2() {
    // Arrange
    COSStream stream = new COSStream();
    PDFormXObject pdFormXObject = new PDFormXObject(stream);

    // Act
    pdFormXObject.setBBox(null);

    // Assert
    assertNull(pdFormXObject.getBBox());
    assertSame(stream, pdFormXObject.getCOSObject());
  }

  /**
   * Method under test: {@link PDFormXObject#getMatrix()}
   */
  @Test
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
   * Method under test: {@link PDFormXObject#setMatrix(AffineTransform)}
   */
  @Test
  void testSetMatrix() {
    // Arrange
    COSStream stream = new COSStream();
    PDFormXObject pdFormXObject = new PDFormXObject(stream);

    // Act
    pdFormXObject.setMatrix(new AffineTransform());

    // Assert
    assertSame(stream, pdFormXObject.getCOSObject());
  }

  /**
   * Method under test: {@link PDFormXObject#getStructParents()}
   */
  @Test
  void testGetStructParents() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDFormXObject(new COSStream())).getStructParents());
  }

  /**
   * Method under test: {@link PDFormXObject#setStructParents(int)}
   */
  @Test
  void testSetStructParents() {
    // Arrange
    COSStream stream = new COSStream();
    PDFormXObject pdFormXObject = new PDFormXObject(stream);

    // Act
    pdFormXObject.setStructParents(1);

    // Assert
    assertEquals(1, pdFormXObject.getStructParents());
    assertSame(stream, pdFormXObject.getCOSObject());
  }

  /**
   * Method under test: {@link PDFormXObject#setOptionalContent(PDPropertyList)}
   */
  @Test
  void testSetOptionalContent() {
    // Arrange
    COSStream stream = new COSStream();
    PDFormXObject pdFormXObject = new PDFormXObject(stream);
    PDPropertyList oc = mock(PDPropertyList.class);
    COSDictionary cosDictionary = new COSDictionary();
    when(oc.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdFormXObject.setOptionalContent(oc);

    // Assert
    verify(oc).getCOSObject();
    assertSame(cosDictionary, pdFormXObject.getOptionalContent().getCOSObject());
    assertSame(stream, pdFormXObject.getCOSObject());
  }

  /**
   * Method under test: {@link PDFormXObject#setOptionalContent(PDPropertyList)}
   */
  @Test
  void testSetOptionalContent2() {
    // Arrange
    COSStream stream = new COSStream();
    PDFormXObject pdFormXObject = new PDFormXObject(stream);
    PDPropertyList oc = mock(PDPropertyList.class);
    when(oc.getCOSObject()).thenReturn(null);

    // Act
    pdFormXObject.setOptionalContent(oc);

    // Assert
    verify(oc).getCOSObject();
    assertNull(pdFormXObject.getOptionalContent());
    assertSame(stream, pdFormXObject.getCOSObject());
  }

  /**
   * Method under test: {@link PDFormXObject#setOptionalContent(PDPropertyList)}
   */
  @Test
  void testSetOptionalContent3() {
    // Arrange
    COSStream stream = new COSStream();
    PDFormXObject pdFormXObject = new PDFormXObject(stream);

    COSDictionary cosDictionary = new COSDictionary();
    cosDictionary.setDirect(true);
    PDPropertyList oc = mock(PDPropertyList.class);
    when(oc.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdFormXObject.setOptionalContent(oc);

    // Assert
    verify(oc).getCOSObject();
    assertSame(cosDictionary, pdFormXObject.getOptionalContent().getCOSObject());
    assertSame(stream, pdFormXObject.getCOSObject());
  }

  /**
   * Method under test: {@link PDFormXObject#setOptionalContent(PDPropertyList)}
   */
  @Test
  void testSetOptionalContent4() {
    // Arrange
    COSStream stream = new COSStream();
    PDFormXObject pdFormXObject = new PDFormXObject(stream);

    COSDictionary cosDictionary = new COSDictionary();
    cosDictionary.setKey(new COSObjectKey(1L, 1));
    PDPropertyList oc = mock(PDPropertyList.class);
    when(oc.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdFormXObject.setOptionalContent(oc);

    // Assert
    verify(oc).getCOSObject();
    assertSame(cosDictionary, pdFormXObject.getOptionalContent().getCOSObject());
    assertSame(stream, pdFormXObject.getCOSObject());
  }

  /**
   * Method under test: {@link PDFormXObject#PDFormXObject(COSStream)}
   */
  @Test
  void testNewPDFormXObject() throws IOException {
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
   * Method under test:
   * {@link PDFormXObject#PDFormXObject(COSStream, ResourceCache)}
   */
  @Test
  void testNewPDFormXObject2() throws IOException {
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
   * Method under test: {@link PDFormXObject#PDFormXObject(PDDocument)}
   */
  @Test
  void testNewPDFormXObject3() throws IOException {
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
   * Method under test: {@link PDFormXObject#PDFormXObject(PDDocument)}
   */
  @Test
  void testNewPDFormXObject4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDFormXObject actualPdFormXObject = new PDFormXObject(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
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
   * Method under test: {@link PDFormXObject#PDFormXObject(PDStream)}
   */
  @Test
  void testNewPDFormXObject5() throws IOException {
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
   * Method under test: {@link PDFormXObject#PDFormXObject(PDStream)}
   */
  @Test
  void testNewPDFormXObject6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDStream stream = new PDStream(new COSDocument(streamCacheCreateFunction));
    stream.setFilters(new ArrayList<>());

    // Act
    PDFormXObject actualPdFormXObject = new PDFormXObject(stream);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSStream cOSObject = actualPdFormXObject.getCOSObject();
    COSBase filters = cOSObject.getFilters();
    assertTrue(filters instanceof COSArray);
    PDStream contentStream = actualPdFormXObject.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(contentStream.getFileDecodeParams());
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
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(((COSArray) filters).toList().isEmpty());
    assertTrue(contentStream.getFileFilters().isEmpty());
    assertTrue(contentStream.getFilters().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(stream, actualPdFormXObject.getStream());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }
}
