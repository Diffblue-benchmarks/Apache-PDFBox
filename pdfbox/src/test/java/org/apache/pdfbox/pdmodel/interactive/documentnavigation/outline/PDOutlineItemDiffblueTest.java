package org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureElement;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.interactive.action.PDAction;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageXYZDestination;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDOutlineItemDiffblueTest {
  /**
   * Method under test: {@link PDOutlineItem#getPreviousSibling()}
   */
  @Test
  void testGetPreviousSibling() {
    // Arrange, Act and Assert
    assertNull((new PDOutlineItem()).getPreviousSibling());
  }

  /**
   * Method under test: {@link PDOutlineItem#getPreviousSibling()}
   */
  @Test
  void testGetPreviousSibling2() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    PDOutlineItem newSibling = new PDOutlineItem();
    pdOutlineItem.insertSiblingBefore(newSibling);

    // Act and Assert
    assertEquals(newSibling, pdOutlineItem.getPreviousSibling());
  }

  /**
   * Method under test: {@link PDOutlineItem#getPreviousSibling()}
   */
  @Test
  void testGetPreviousSibling3() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    dic.setKey(new COSObjectKey(1L, 1));
    PDOutlineItem newSibling = new PDOutlineItem(dic);

    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    pdOutlineItem.insertSiblingBefore(newSibling);

    // Act and Assert
    assertEquals(newSibling, pdOutlineItem.getPreviousSibling());
  }

  /**
   * Method under test: {@link PDOutlineItem#setPreviousSibling(PDOutlineNode)}
   */
  @Test
  void testSetPreviousSibling() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    doNothing().when(dic).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    (new PDOutlineItem(dic)).setPreviousSibling(mock(PDOutlineNode.class));

    // Assert that nothing has changed
    verify(dic).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Method under test: {@link PDOutlineItem#getNextSibling()}
   */
  @Test
  void testGetNextSibling() {
    // Arrange, Act and Assert
    assertNull((new PDOutlineItem()).getNextSibling());
  }

  /**
   * Method under test: {@link PDOutlineItem#getNextSibling()}
   */
  @Test
  void testGetNextSibling2() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    PDOutlineItem newSibling = new PDOutlineItem();
    pdOutlineItem.insertSiblingAfter(newSibling);

    // Act and Assert
    assertEquals(newSibling, pdOutlineItem.getNextSibling());
  }

  /**
   * Method under test: {@link PDOutlineItem#getNextSibling()}
   */
  @Test
  void testGetNextSibling3() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    dic.setKey(new COSObjectKey(1L, 1));
    PDOutlineItem newSibling = new PDOutlineItem(dic);

    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    pdOutlineItem.insertSiblingAfter(newSibling);

    // Act and Assert
    assertEquals(newSibling, pdOutlineItem.getNextSibling());
  }

  /**
   * Method under test: {@link PDOutlineItem#setNextSibling(PDOutlineNode)}
   */
  @Test
  void testSetNextSibling() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    doNothing().when(dic).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    (new PDOutlineItem(dic)).setNextSibling(mock(PDOutlineNode.class));

    // Assert that nothing has changed
    verify(dic).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Method under test: {@link PDOutlineItem#getTitle()}
   */
  @Test
  void testGetTitle() {
    // Arrange, Act and Assert
    assertNull((new PDOutlineItem()).getTitle());
  }

  /**
   * Method under test: {@link PDOutlineItem#setTitle(String)}
   */
  @Test
  void testSetTitle() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    doNothing().when(dic).setString(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    (new PDOutlineItem(dic)).setTitle("Dr");

    // Assert that nothing has changed
    verify(dic).setString(isA(COSName.class), eq("Dr"));
  }

  /**
   * Method under test: {@link PDOutlineItem#setDestination(PDPage)}
   */
  @Test
  void testSetDestination() throws IOException {
    // Arrange
    COSDictionary dic = new COSDictionary();
    PDOutlineItem pdOutlineItem = new PDOutlineItem(dic);
    PDPage page = new PDPage();

    // Act
    pdOutlineItem.setDestination(page);

    // Assert
    PDDestination destination = pdOutlineItem.getDestination();
    List<? extends COSBase> toListResult = ((COSArray) destination.getCOSObject()).toList();
    assertEquals(5, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertTrue(destination instanceof PDPageXYZDestination);
    assertEquals("XYZ", ((COSName) getResult).getName());
    assertNull(toListResult.get(3));
    assertNull(toListResult.get(4));
    assertNull(getResult.getKey());
    assertEquals(-1, ((PDPageXYZDestination) destination).getPageNumber());
    assertEquals(-1, ((PDPageXYZDestination) destination).getLeft());
    assertEquals(-1, ((PDPageXYZDestination) destination).getTop());
    assertEquals(-1.0f, ((PDPageXYZDestination) destination).getZoom());
    assertFalse(getResult.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
    assertEquals(page, ((PDPageXYZDestination) destination).getPage());
    assertSame(dic, pdOutlineItem.getCOSObject());
  }

  /**
   * Method under test: {@link PDOutlineItem#setDestination(PDDestination)}
   */
  @Test
  void testSetDestination2() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    doNothing().when(dic).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    (new PDOutlineItem(dic)).setDestination(mock(PDDestination.class));

    // Assert that nothing has changed
    verify(dic).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Method under test: {@link PDOutlineItem#findDestinationPage(PDDocument)}
   */
  @Test
  void testFindDestinationPage() throws IOException {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();

    // Act and Assert
    assertNull(pdOutlineItem.findDestinationPage(new PDDocument()));
  }

  /**
   * Method under test: {@link PDOutlineItem#findDestinationPage(PDDocument)}
   */
  @Test
  void testFindDestinationPage2() throws IOException {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDPage actualFindDestinationPageResult = pdOutlineItem
        .findDestinationPage(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFindDestinationPageResult);
  }

  /**
   * Method under test: {@link PDOutlineItem#getAction()}
   */
  @Test
  void testGetAction() {
    // Arrange, Act and Assert
    assertNull((new PDOutlineItem()).getAction());
  }

  /**
   * Method under test: {@link PDOutlineItem#setAction(PDAction)}
   */
  @Test
  void testSetAction() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    doNothing().when(dic).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    (new PDOutlineItem(dic)).setAction(mock(PDAction.class));

    // Assert that nothing has changed
    verify(dic).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Method under test: {@link PDOutlineItem#getStructureElement()}
   */
  @Test
  void testGetStructureElement() {
    // Arrange, Act and Assert
    assertNull((new PDOutlineItem()).getStructureElement());
  }

  /**
   * Method under test:
   * {@link PDOutlineItem#setStructureElement(PDStructureElement)}
   */
  @Test
  void testSetStructureElement() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    doNothing().when(dic).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    PDOutlineItem pdOutlineItem = new PDOutlineItem(dic);

    // Act
    pdOutlineItem.setStructureElement(new PDStructureElement(mock(COSDictionary.class)));

    // Assert that nothing has changed
    verify(dic).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Method under test: {@link PDOutlineItem#getTextColor()}
   */
  @Test
  void testGetTextColor() {
    // Arrange and Act
    PDColor actualTextColor = (new PDOutlineItem()).getTextColor();

    // Assert
    PDColorSpace colorSpace = actualTextColor.getColorSpace();
    COSBase cOSObject = colorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(colorSpace instanceof PDDeviceRGB);
    assertEquals("DeviceRGB", ((COSName) cOSObject).getName());
    assertEquals("DeviceRGB", colorSpace.getName());
    PDColor initialColor = colorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(actualTextColor.getPatternName());
    assertNull(cOSObject.getKey());
    assertEquals(3, colorSpace.getNumberOfComponents());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSName) cOSObject).isEmpty());
    assertFalse(initialColor.isPattern());
    assertFalse(actualTextColor.isPattern());
    assertSame(colorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, actualTextColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDOutlineItem#setTextColor(PDColor)}
   */
  @Test
  void testSetTextColor() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();

    // Act
    pdOutlineItem.setTextColor(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    PDColor textColor = pdOutlineItem.getTextColor();
    assertNull(textColor.getPatternName());
    assertFalse(textColor.isPattern());
  }

  /**
   * Method under test: {@link PDOutlineItem#setTextColor(PDColor)}
   */
  @Test
  void testSetTextColor2() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();

    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);

    // Act
    pdOutlineItem.setTextColor(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    PDColor textColor = pdOutlineItem.getTextColor();
    assertNull(textColor.getPatternName());
    assertFalse(textColor.isPattern());
  }

  /**
   * Method under test: {@link PDOutlineItem#setTextColor(PDColor)}
   */
  @Test
  void testSetTextColor3() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSBoolean.FALSE);

    // Act
    pdOutlineItem.setTextColor(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    verify(object).getCOSObject();
    PDColor textColor = pdOutlineItem.getTextColor();
    assertNull(textColor.getPatternName());
    assertFalse(textColor.isPattern());
  }

  /**
   * Method under test: {@link PDOutlineItem#setTextColor(PDColor)}
   */
  @Test
  void testSetTextColor4() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSName.A);

    // Act
    pdOutlineItem.setTextColor(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    verify(object).getCOSObject();
    assertTrue(pdOutlineItem.getTextColor().isPattern());
  }

  /**
   * Method under test: {@link PDOutlineItem#isItalic()}
   */
  @Test
  void testIsItalic() {
    // Arrange, Act and Assert
    assertFalse((new PDOutlineItem()).isItalic());
  }

  /**
   * Method under test: {@link PDOutlineItem#setItalic(boolean)}
   */
  @Test
  void testSetItalic() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    doNothing().when(dic).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());

    // Act
    (new PDOutlineItem(dic)).setItalic(true);

    // Assert that nothing has changed
    verify(dic).setFlag(isA(COSName.class), eq(1), eq(true));
  }

  /**
   * Method under test: {@link PDOutlineItem#isBold()}
   */
  @Test
  void testIsBold() {
    // Arrange, Act and Assert
    assertFalse((new PDOutlineItem()).isBold());
  }

  /**
   * Method under test: {@link PDOutlineItem#setBold(boolean)}
   */
  @Test
  void testSetBold() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    doNothing().when(dic).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());

    // Act
    (new PDOutlineItem(dic)).setBold(true);

    // Assert that nothing has changed
    verify(dic).setFlag(isA(COSName.class), eq(2), eq(true));
  }

  /**
   * Method under test: {@link PDOutlineItem#PDOutlineItem(COSDictionary)}
   */
  @Test
  void testNewPDOutlineItem() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    // Act and Assert
    assertSame(dic, (new PDOutlineItem(dic)).getCOSObject());
  }
}
