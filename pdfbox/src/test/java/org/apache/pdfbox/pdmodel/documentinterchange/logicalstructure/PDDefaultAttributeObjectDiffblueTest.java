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
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;

class PDDefaultAttributeObjectDiffblueTest {
  /**
   * Method under test: {@link PDDefaultAttributeObject#getAttributeNames()}
   */
  @Test
  void testGetAttributeNames() {
    // Arrange, Act and Assert
    assertTrue((new PDDefaultAttributeObject()).getAttributeNames().isEmpty());
  }

  /**
   * Method under test: {@link PDDefaultAttributeObject#getAttributeNames()}
   */
  @Test
  void testGetAttributeNames2() {
    // Arrange and Act
    List<String> actualAttributeNames = (new PDDefaultAttributeObject(new COSStream())).getAttributeNames();

    // Assert
    assertEquals(1, actualAttributeNames.size());
    assertEquals("Length", actualAttributeNames.get(0));
  }

  /**
   * Method under test: {@link PDDefaultAttributeObject#getAttributeNames()}
   */
  @Test
  void testGetAttributeNames3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement structureElement = new PDStructureElement(new COSDictionary());
    structureElement.appendObjectableKid(objectable);

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);

    // Act
    List<String> actualAttributeNames = pdDefaultAttributeObject.getAttributeNames();

    // Assert
    verify(objectable).getCOSObject();
    assertTrue(actualAttributeNames.isEmpty());
  }

  /**
   * Method under test: {@link PDDefaultAttributeObject#getAttributeValue(String)}
   */
  @Test
  void testGetAttributeValue() {
    // Arrange, Act and Assert
    assertNull((new PDDefaultAttributeObject()).getAttributeValue("Attr Name"));
    assertNull((new PDDefaultAttributeObject(new COSDictionary())).getAttributeValue("Attr Name"));
  }

  /**
   * Method under test: {@link PDDefaultAttributeObject#getAttributeValue(String)}
   */
  @Test
  void testGetAttributeValue2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement structureElement = new PDStructureElement(new COSDictionary());
    structureElement.appendObjectableKid(objectable);

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);

    // Act
    COSBase actualAttributeValue = pdDefaultAttributeObject.getAttributeValue("Attr Name");

    // Assert
    verify(objectable).getCOSObject();
    assertNull(actualAttributeValue);
  }

  /**
   * Method under test:
   * {@link PDDefaultAttributeObject#getAttributeValue(String, COSBase)}
   */
  @Test
  void testGetAttributeValue3() {
    // Arrange and Act
    COSBase actualAttributeValue = (new PDDefaultAttributeObject()).getAttributeValue("Attr Name", COSBoolean.FALSE);

    // Assert
    assertSame(((COSBoolean) actualAttributeValue).FALSE, actualAttributeValue);
  }

  /**
   * Method under test:
   * {@link PDDefaultAttributeObject#getAttributeValue(String, COSBase)}
   */
  @Test
  void testGetAttributeValue4() {
    // Arrange and Act
    COSBase actualAttributeValue = (new PDDefaultAttributeObject(new COSDictionary())).getAttributeValue("Attr Name",
        COSBoolean.FALSE);

    // Assert
    assertSame(((COSBoolean) actualAttributeValue).FALSE, actualAttributeValue);
  }

  /**
   * Method under test:
   * {@link PDDefaultAttributeObject#getAttributeValue(String, COSBase)}
   */
  @Test
  void testGetAttributeValue5() throws IOException {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument defaultValue = new COSDocument(streamCacheCreateFunction);

    // Act
    COSBase actualAttributeValue = pdDefaultAttributeObject.getAttributeValue("Attr Name", defaultValue);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertSame(defaultValue, actualAttributeValue);
  }

  /**
   * Method under test:
   * {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}
   */
  @Test
  void testSetAttribute() {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();

    // Act
    pdDefaultAttributeObject.setAttribute("Attr Name", COSBoolean.FALSE);

    // Assert
    List<String> attributeNames = pdDefaultAttributeObject.getAttributeNames();
    assertEquals(1, attributeNames.size());
    assertEquals("Attr Name", attributeNames.get(0));
    COSDictionary cOSObject = pdDefaultAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}
   */
  @Test
  void testSetAttribute2() {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();

    // Act
    pdDefaultAttributeObject.setAttribute("Attr Name", new COSArray());

    // Assert
    List<String> attributeNames = pdDefaultAttributeObject.getAttributeNames();
    assertEquals(1, attributeNames.size());
    assertEquals("Attr Name", attributeNames.get(0));
    COSDictionary cOSObject = pdDefaultAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}
   */
  @Test
  void testSetAttribute3() {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();

    // Act
    pdDefaultAttributeObject.setAttribute("Attr Name", new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Assert
    List<String> attributeNames = pdDefaultAttributeObject.getAttributeNames();
    assertEquals(1, attributeNames.size());
    assertEquals("Attr Name", attributeNames.get(0));
    COSDictionary cOSObject = pdDefaultAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}
   */
  @Test
  void testSetAttribute4() {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();

    // Act
    pdDefaultAttributeObject.setAttribute("Attr Name", null);

    // Assert
    COSDictionary cOSObject = pdDefaultAttributeObject.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(pdDefaultAttributeObject.getAttributeNames().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}
   */
  @Test
  void testSetAttribute5() {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();

    // Act
    pdDefaultAttributeObject.setAttribute("Attr Name", new COSDictionary());

    // Assert
    List<String> attributeNames = pdDefaultAttributeObject.getAttributeNames();
    assertEquals(1, attributeNames.size());
    assertEquals("Attr Name", attributeNames.get(0));
    COSDictionary cOSObject = pdDefaultAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}
   */
  @Test
  void testSetAttribute6() throws IOException {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdDefaultAttributeObject.setAttribute("Attr Name", new COSDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    List<String> attributeNames = pdDefaultAttributeObject.getAttributeNames();
    assertEquals(1, attributeNames.size());
    assertEquals("Attr Name", attributeNames.get(0));
    COSDictionary cOSObject = pdDefaultAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}
   */
  @Test
  void testSetAttribute7() throws IOException {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(new PDStructureElement(new COSDictionary()));
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdDefaultAttributeObject.setAttribute("Attr Name", new COSDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    List<String> attributeNames = pdDefaultAttributeObject.getAttributeNames();
    assertEquals(1, attributeNames.size());
    assertEquals("Attr Name", attributeNames.get(0));
    COSDictionary cOSObject = pdDefaultAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}
   */
  @Test
  void testSetAttribute8() throws IOException {
    // Arrange
    PDStructureElement structureElement = new PDStructureElement(new COSDictionary());
    structureElement.addAttribute(new PDDefaultAttributeObject());

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdDefaultAttributeObject.setAttribute("Attr Name", new COSDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    List<String> attributeNames = pdDefaultAttributeObject.getAttributeNames();
    assertEquals(1, attributeNames.size());
    assertEquals("Attr Name", attributeNames.get(0));
    COSDictionary cOSObject = pdDefaultAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}
   */
  @Test
  void testSetAttribute9() throws IOException {
    // Arrange
    PDStructureElement structureElement = new PDStructureElement(new COSDictionary());
    structureElement.incrementRevisionNumber();

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdDefaultAttributeObject.setAttribute("Attr Name", new COSDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    List<String> attributeNames = pdDefaultAttributeObject.getAttributeNames();
    assertEquals(1, attributeNames.size());
    assertEquals("Attr Name", attributeNames.get(0));
    COSDictionary cOSObject = pdDefaultAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDDefaultAttributeObject#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("O=null, attributes={}", (new PDDefaultAttributeObject()).toString());
    assertEquals("O=null, attributes={Length=COSInt{0}}", (new PDDefaultAttributeObject(new COSStream())).toString());
  }

  /**
   * Method under test: {@link PDDefaultAttributeObject#toString()}
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
   * Method under test:
   * {@link PDDefaultAttributeObject#PDDefaultAttributeObject()}
   */
  @Test
  void testNewPDDefaultAttributeObject() {
    // Arrange, Act and Assert
    COSDictionary cOSObject = (new PDDefaultAttributeObject()).getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDDefaultAttributeObject#PDDefaultAttributeObject(COSDictionary)}
   */
  @Test
  void testNewPDDefaultAttributeObject2() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, (new PDDefaultAttributeObject(dictionary)).getCOSObject());
  }
}
