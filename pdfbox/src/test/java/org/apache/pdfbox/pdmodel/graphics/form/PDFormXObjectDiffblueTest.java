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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDPropertyList;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFormXObjectDiffblueTest {
  /**
   * Test {@link PDFormXObject#PDFormXObject(PDStream)}.
   *
   * <ul>
   *   <li>Then return Resources is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormXObject#PDFormXObject(PDStream)}
   */
  @Test
  @DisplayName("Test new PDFormXObject(PDStream); then return Resources is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormXObject.<init>(PDStream)"})
  void testNewPDFormXObject_thenReturnResourcesIsNull() {
    // Arrange
    PDStream stream = new PDStream(new COSDocument());

    // Act
    PDFormXObject actualPdFormXObject = new PDFormXObject(stream);

    // Assert
    assertNull(actualPdFormXObject.getResources());
    assertNull(actualPdFormXObject.getBBox());
    assertNull(actualPdFormXObject.getOptionalContent());
    assertNull(actualPdFormXObject.getGroup());
    assertEquals(-1, actualPdFormXObject.getStructParents());
    assertEquals(1, actualPdFormXObject.getFormType());
    assertSame(stream, actualPdFormXObject.getStream());
  }

  /**
   * Test {@link PDFormXObject#PDFormXObject(COSStream)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then return Resources is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormXObject#PDFormXObject(COSStream)}
   */
  @Test
  @DisplayName(
      "Test new PDFormXObject(COSStream); when COSStream(); then return Resources is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormXObject.<init>(COSStream)"})
  void testNewPDFormXObject_whenCOSStream_thenReturnResourcesIsNull() {
    // Arrange
    COSStream stream = new COSStream();

    // Act
    PDFormXObject actualPdFormXObject = new PDFormXObject(stream);

    // Assert
    assertNull(actualPdFormXObject.getResources());
    assertNull(actualPdFormXObject.getBBox());
    assertNull(actualPdFormXObject.getOptionalContent());
    assertNull(actualPdFormXObject.getGroup());
    assertEquals(-1, actualPdFormXObject.getStructParents());
    assertEquals(1, actualPdFormXObject.getFormType());
    assertEquals(3, stream.size());
    assertSame(stream, actualPdFormXObject.getCOSObject());
  }

  /**
   * Test {@link PDFormXObject#PDFormXObject(COSStream, ResourceCache)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then return Resources is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormXObject#PDFormXObject(COSStream, ResourceCache)}
   */
  @Test
  @DisplayName(
      "Test new PDFormXObject(COSStream, ResourceCache); when COSStream(); then return Resources is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormXObject.<init>(COSStream, ResourceCache)"})
  void testNewPDFormXObject_whenCOSStream_thenReturnResourcesIsNull2() {
    // Arrange
    COSStream stream = new COSStream();

    // Act
    PDFormXObject actualPdFormXObject = new PDFormXObject(stream, new DefaultResourceCache());

    // Assert
    assertNull(actualPdFormXObject.getResources());
    assertNull(actualPdFormXObject.getBBox());
    assertNull(actualPdFormXObject.getOptionalContent());
    assertNull(actualPdFormXObject.getGroup());
    assertEquals(-1, actualPdFormXObject.getStructParents());
    assertEquals(1, actualPdFormXObject.getFormType());
    assertEquals(3, stream.size());
    assertSame(stream, actualPdFormXObject.getCOSObject());
  }

  /**
   * Test {@link PDFormXObject#PDFormXObject(PDDocument)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then return Resources is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormXObject#PDFormXObject(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test new PDFormXObject(PDDocument); when PDDocument(); then return Resources is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormXObject.<init>(PDDocument)"})
  void testNewPDFormXObject_whenPDDocument_thenReturnResourcesIsNull() {
    // Arrange and Act
    PDFormXObject actualPdFormXObject = new PDFormXObject(new PDDocument());

    // Assert
    assertNull(actualPdFormXObject.getResources());
    assertNull(actualPdFormXObject.getBBox());
    assertNull(actualPdFormXObject.getOptionalContent());
    assertNull(actualPdFormXObject.getGroup());
    assertEquals(-1, actualPdFormXObject.getStructParents());
    assertEquals(1, actualPdFormXObject.getFormType());
  }

  /**
   * Test {@link PDFormXObject#getFormType()}.
   *
   * <p>Method under test: {@link PDFormXObject#getFormType()}
   */
  @Test
  @DisplayName("Test getFormType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFormXObject.getFormType()"})
  void testGetFormType() {
    // Arrange, Act and Assert
    assertEquals(1, new PDFormXObject(new COSStream()).getFormType());
  }

  /**
   * Test {@link PDFormXObject#setFormType(int)}.
   *
   * <ul>
   *   <li>Then {@link PDFormXObject#PDFormXObject(COSStream)} with stream is {@link
   *       COSStream#COSStream()} FormType is {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormXObject#setFormType(int)}
   */
  @Test
  @DisplayName(
      "Test setFormType(int); then PDFormXObject(COSStream) with stream is COSStream() FormType is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormXObject.setFormType(int)"})
  void testSetFormType_thenPDFormXObjectWithStreamIsCOSStreamFormTypeIsMin_value() {
    // Arrange
    PDFormXObject pdFormXObject = new PDFormXObject(new COSStream());

    // Act
    pdFormXObject.setFormType(Integer.MIN_VALUE);

    // Assert
    COSStream cOSObject = pdFormXObject.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdFormXObject.getFormType());
  }

  /**
   * Test {@link PDFormXObject#setFormType(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link PDFormXObject#PDFormXObject(COSStream)} with stream is {@link
   *       COSStream#COSStream()} FormType is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFormXObject#setFormType(int)}
   */
  @Test
  @DisplayName(
      "Test setFormType(int); when one; then PDFormXObject(COSStream) with stream is COSStream() FormType is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormXObject.setFormType(int)"})
  void testSetFormType_whenOne_thenPDFormXObjectWithStreamIsCOSStreamFormTypeIsOne() {
    // Arrange
    PDFormXObject pdFormXObject = new PDFormXObject(new COSStream());

    // Act
    pdFormXObject.setFormType(1);

    // Assert
    assertEquals(1, pdFormXObject.getFormType());
    COSStream cOSObject = pdFormXObject.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDFormXObject#setFormType(int)}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then {@link PDFormXObject#PDFormXObject(COSStream)} with stream is {@link
   *       COSStream#COSStream()} FormType is six.
   * </ul>
   *
   * <p>Method under test: {@link PDFormXObject#setFormType(int)}
   */
  @Test
  @DisplayName(
      "Test setFormType(int); when six; then PDFormXObject(COSStream) with stream is COSStream() FormType is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormXObject.setFormType(int)"})
  void testSetFormType_whenSix_thenPDFormXObjectWithStreamIsCOSStreamFormTypeIsSix() {
    // Arrange
    PDFormXObject pdFormXObject = new PDFormXObject(new COSStream());

    // Act
    pdFormXObject.setFormType(6);

    // Assert
    COSStream cOSObject = pdFormXObject.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(6, pdFormXObject.getFormType());
  }

  /**
   * Test {@link PDFormXObject#getGroup()}.
   *
   * <p>Method under test: {@link PDFormXObject#getGroup()}
   */
  @Test
  @DisplayName("Test getGroup()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.graphics.form.PDTransparencyGroupAttributes PDFormXObject.getGroup()"
  })
  void testGetGroup() {
    // Arrange, Act and Assert
    assertNull(new PDFormXObject(new COSStream()).getGroup());
  }

  /**
   * Test {@link PDFormXObject#getContentStream()}.
   *
   * <p>Method under test: {@link PDFormXObject#getContentStream()}
   */
  @Test
  @DisplayName("Test getContentStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDStream PDFormXObject.getContentStream()"})
  void testGetContentStream() throws IOException {
    // Arrange
    COSStream stream = new COSStream();

    // Act
    PDStream actualContentStream = new PDFormXObject(stream).getContentStream();

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
   *
   * <p>Method under test: {@link PDFormXObject#getResources()}
   */
  @Test
  @DisplayName("Test getResources()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDResources PDFormXObject.getResources()"})
  void testGetResources() {
    // Arrange, Act and Assert
    assertNull(new PDFormXObject(new COSStream()).getResources());
  }

  /**
   * Test {@link PDFormXObject#setResources(PDResources)}.
   *
   * <p>Method under test: {@link PDFormXObject#setResources(PDResources)}
   */
  @Test
  @DisplayName("Test setResources(PDResources)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormXObject.setResources(PDResources)"})
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
   *
   * <p>Method under test: {@link PDFormXObject#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDFormXObject.getBBox()"})
  void testGetBBox() {
    // Arrange, Act and Assert
    assertNull(new PDFormXObject(new COSStream()).getBBox());
  }

  /**
   * Test {@link PDFormXObject#setBBox(PDRectangle)}.
   *
   * <p>Method under test: {@link PDFormXObject#setBBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setBBox(PDRectangle)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormXObject.setBBox(PDRectangle)"})
  void testSetBBox() {
    // Arrange
    PDFormXObject pdFormXObject = new PDFormXObject(new COSStream());

    // Act
    pdFormXObject.setBBox(null);

    // Assert that nothing has changed
    COSIncrement toIncrementResult = pdFormXObject.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDFormXObject#setBBox(PDRectangle)}.
   *
   * <ul>
   *   <li>Then {@link PDFormXObject#PDFormXObject(COSStream)} with stream is {@link
   *       COSStream#COSStream()} BBox UpperRightX is {@code 1683.7795}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormXObject#setBBox(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setBBox(PDRectangle); then PDFormXObject(COSStream) with stream is COSStream() BBox UpperRightX is '1683.7795'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormXObject.setBBox(PDRectangle)"})
  void testSetBBox_thenPDFormXObjectWithStreamIsCOSStreamBBoxUpperRightXIs16837795() {
    // Arrange
    PDFormXObject pdFormXObject = new PDFormXObject(new COSStream());

    // Act
    pdFormXObject.setBBox(PDRectangle.A1);

    // Assert
    PDRectangle bBox = pdFormXObject.getBBox();
    assertEquals(1683.7795f, bBox.getUpperRightX());
    assertEquals(1683.7795f, bBox.getWidth());
    assertEquals(2383.937f, bBox.getHeight());
    assertEquals(2383.937f, bBox.getUpperRightY());
  }

  /**
   * Test {@link PDFormXObject#getMatrix()}.
   *
   * <p>Method under test: {@link PDFormXObject#getMatrix()}
   */
  @Test
  @DisplayName("Test getMatrix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix PDFormXObject.getMatrix()"})
  void testGetMatrix() {
    // Arrange and Act
    Matrix actualMatrix = new PDFormXObject(new COSStream()).getMatrix();

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
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDFormXObject#setMatrix(AffineTransform)}.
   *
   * <ul>
   *   <li>Then {@link PDFormXObject#PDFormXObject(COSStream)} with stream is {@link
   *       COSStream#COSStream()} COSObject Values size is four.
   * </ul>
   *
   * <p>Method under test: {@link PDFormXObject#setMatrix(AffineTransform)}
   */
  @Test
  @DisplayName(
      "Test setMatrix(AffineTransform); then PDFormXObject(COSStream) with stream is COSStream() COSObject Values size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormXObject.setMatrix(AffineTransform)"})
  void testSetMatrix_thenPDFormXObjectWithStreamIsCOSStreamCOSObjectValuesSizeIsFour() {
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
   *
   * <p>Method under test: {@link PDFormXObject#getStructParents()}
   */
  @Test
  @DisplayName("Test getStructParents()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFormXObject.getStructParents()"})
  void testGetStructParents() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDFormXObject(new COSStream()).getStructParents());
  }

  /**
   * Test {@link PDFormXObject#setStructParents(int)}.
   *
   * <p>Method under test: {@link PDFormXObject#setStructParents(int)}
   */
  @Test
  @DisplayName("Test setStructParents(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormXObject.setStructParents(int)"})
  void testSetStructParents() {
    // Arrange
    PDFormXObject pdFormXObject = new PDFormXObject(new COSStream());

    // Act
    pdFormXObject.setStructParents(Integer.MIN_VALUE);

    // Assert
    COSStream cOSObject = pdFormXObject.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdFormXObject.getStructParents());
  }

  /**
   * Test {@link PDFormXObject#setStructParents(int)}.
   *
   * <ul>
   *   <li>Then {@link PDFormXObject#PDFormXObject(COSStream)} with stream is {@link
   *       COSStream#COSStream()} StructParents is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFormXObject#setStructParents(int)}
   */
  @Test
  @DisplayName(
      "Test setStructParents(int); then PDFormXObject(COSStream) with stream is COSStream() StructParents is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormXObject.setStructParents(int)"})
  void testSetStructParents_thenPDFormXObjectWithStreamIsCOSStreamStructParentsIsOne() {
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
   * Test {@link PDFormXObject#getOptionalContent()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormXObject#getOptionalContent()}
   */
  @Test
  @DisplayName("Test getOptionalContent(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPropertyList PDFormXObject.getOptionalContent()"})
  void testGetOptionalContent_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDFormXObject(new COSStream()).getOptionalContent());
  }

  /**
   * Test {@link PDFormXObject#setOptionalContent(PDPropertyList)}.
   *
   * <p>Method under test: {@link PDFormXObject#setOptionalContent(PDPropertyList)}
   */
  @Test
  @DisplayName("Test setOptionalContent(PDPropertyList)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormXObject.setOptionalContent(PDPropertyList)"})
  void testSetOptionalContent() {
    // Arrange
    PDFormXObject pdFormXObject = new PDFormXObject(new COSStream());

    PDPropertyList oc = mock(PDPropertyList.class);
    when(oc.getCOSObject()).thenReturn(null);

    // Act
    pdFormXObject.setOptionalContent(oc);

    // Assert that nothing has changed
    verify(oc).getCOSObject();
    COSStream cOSObject = pdFormXObject.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDFormXObject#setOptionalContent(PDPropertyList)}.
   *
   * <p>Method under test: {@link PDFormXObject#setOptionalContent(PDPropertyList)}
   */
  @Test
  @DisplayName("Test setOptionalContent(PDPropertyList)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormXObject.setOptionalContent(PDPropertyList)"})
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
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormXObject#setOptionalContent(PDPropertyList)}
   */
  @Test
  @DisplayName("Test setOptionalContent(PDPropertyList); given COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormXObject.setOptionalContent(PDPropertyList)"})
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
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormXObject#setOptionalContent(PDPropertyList)}
   */
  @Test
  @DisplayName("Test setOptionalContent(PDPropertyList); given COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormXObject.setOptionalContent(PDPropertyList)"})
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
