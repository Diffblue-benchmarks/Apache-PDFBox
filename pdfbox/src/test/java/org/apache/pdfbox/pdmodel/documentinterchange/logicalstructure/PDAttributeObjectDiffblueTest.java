package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;

class PDAttributeObjectDiffblueTest {
  /**
   * Method under test: {@link PDAttributeObject#create(COSDictionary)}
   */
  @Test
  void testCreate() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act
    PDAttributeObject actualCreateResult = PDAttributeObject.create(dictionary);

    // Assert
    assertTrue(actualCreateResult instanceof PDDefaultAttributeObject);
    assertNull(actualCreateResult.getOwner());
    assertFalse(actualCreateResult.isEmpty());
    assertTrue(((PDDefaultAttributeObject) actualCreateResult).getAttributeNames().isEmpty());
    assertSame(dictionary, actualCreateResult.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAttributeObject#setStructureElement(PDStructureElement)}
   */
  @Test
  void testSetStructureElement() {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement structureElement = new PDStructureElement(new COSDictionary());
    structureElement.appendObjectableKid(objectable);

    // Act
    pdDefaultAttributeObject.setStructureElement(structureElement);

    // Assert
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test: {@link PDAttributeObject#getOwner()}
   */
  @Test
  void testGetOwner() {
    // Arrange, Act and Assert
    assertNull((new PDDefaultAttributeObject()).getOwner());
  }

  /**
   * Method under test: {@link PDAttributeObject#getOwner()}
   */
  @Test
  void testGetOwner2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement structureElement = new PDStructureElement(new COSDictionary());
    structureElement.appendObjectableKid(objectable);

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);

    // Act
    String actualOwner = pdDefaultAttributeObject.getOwner();

    // Assert
    verify(objectable).getCOSObject();
    assertNull(actualOwner);
  }

  /**
   * Method under test: {@link PDAttributeObject#setOwner(String)}
   */
  @Test
  void testSetOwner() {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();

    // Act
    pdDefaultAttributeObject.setOwner("Owner");

    // Assert
    assertEquals("Owner", pdDefaultAttributeObject.getOwner());
    COSDictionary cOSObject = pdDefaultAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdDefaultAttributeObject.isEmpty());
  }

  /**
   * Method under test: {@link PDAttributeObject#setOwner(String)}
   */
  @Test
  void testSetOwner2() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();
    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject(dictionary);

    // Act
    pdDefaultAttributeObject.setOwner("Owner");

    // Assert
    assertEquals("Owner", pdDefaultAttributeObject.getOwner());
    assertTrue(pdDefaultAttributeObject.isEmpty());
    assertSame(dictionary, pdDefaultAttributeObject.getCOSObject());
  }

  /**
   * Method under test: {@link PDAttributeObject#setOwner(String)}
   */
  @Test
  void testSetOwner3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement structureElement = new PDStructureElement(new COSDictionary());
    structureElement.appendObjectableKid(objectable);

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);

    // Act
    pdDefaultAttributeObject.setOwner("Owner");

    // Assert
    verify(objectable).getCOSObject();
    assertEquals("Owner", pdDefaultAttributeObject.getOwner());
    COSDictionary cOSObject = pdDefaultAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdDefaultAttributeObject.isEmpty());
  }

  /**
   * Method under test: {@link PDAttributeObject#isEmpty()}
   */
  @Test
  void testIsEmpty() {
    // Arrange, Act and Assert
    assertFalse((new PDDefaultAttributeObject()).isEmpty());
    assertFalse((new PDDefaultAttributeObject(new COSStream())).isEmpty());
  }

  /**
   * Method under test: {@link PDAttributeObject#isEmpty()}
   */
  @Test
  void testIsEmpty2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement structureElement = new PDStructureElement(new COSDictionary());
    structureElement.appendObjectableKid(objectable);

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);

    // Act
    boolean actualIsEmptyResult = pdDefaultAttributeObject.isEmpty();

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualIsEmptyResult);
  }

  /**
   * Method under test:
   * {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}
   */
  @Test
  void testPotentiallyNotifyChanged() throws IOException {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdDefaultAttributeObject.potentiallyNotifyChanged(new COSDocument(streamCacheCreateFunction), COSBoolean.FALSE);

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}
   */
  @Test
  void testPotentiallyNotifyChanged2() throws IOException {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(new PDStructureElement(new COSDictionary()));
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdDefaultAttributeObject.potentiallyNotifyChanged(new COSDocument(streamCacheCreateFunction), COSBoolean.FALSE);

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}
   */
  @Test
  void testPotentiallyNotifyChanged3() throws IOException {
    // Arrange
    PDStructureElement structureElement = new PDStructureElement(new COSDictionary());
    structureElement.addAttribute(new PDDefaultAttributeObject());

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdDefaultAttributeObject.potentiallyNotifyChanged(new COSDocument(streamCacheCreateFunction), COSBoolean.FALSE);

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}
   */
  @Test
  void testPotentiallyNotifyChanged4() throws IOException {
    // Arrange
    PDStructureElement structureElement = new PDStructureElement(new COSDictionary());
    structureElement.incrementRevisionNumber();

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdDefaultAttributeObject.potentiallyNotifyChanged(new COSDocument(streamCacheCreateFunction), COSBoolean.FALSE);

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDAttributeObject#notifyChanged()}
   */
  @Test
  void testNotifyChanged() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement structureElement = new PDStructureElement(new COSDictionary());
    structureElement.appendObjectableKid(objectable);
    structureElement.addAttribute(new PDDefaultAttributeObject());

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);

    // Act
    pdDefaultAttributeObject.notifyChanged();

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test: {@link PDAttributeObject#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("O=null, attributes={}", (new PDDefaultAttributeObject()).toString());
    assertEquals("O=null, attributes={Length=COSInt{0}}", (new PDDefaultAttributeObject(new COSStream())).toString());
  }

  /**
   * Method under test: {@link PDAttributeObject#toString()}
   */
  @Test
  void testToString2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement structureElement = new PDStructureElement(new COSDictionary());
    structureElement.appendObjectableKid(objectable);

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);

    // Act
    String actualToStringResult = pdDefaultAttributeObject.toString();

    // Assert
    verify(objectable).getCOSObject();
    assertEquals("O=null, attributes={}", actualToStringResult);
  }

  /**
   * Method under test: {@link PDAttributeObject#arrayToString(float[])}
   */
  @Test
  void testArrayToString() {
    // Arrange, Act and Assert
    assertEquals("[10.0, 0.5, 10.0, 0.5]", PDAttributeObject.arrayToString(new float[]{10.0f, 0.5f, 10.0f, 0.5f}));
    assertEquals("[Array]", PDAttributeObject.arrayToString(new Object[]{"Array"}));
  }
}
