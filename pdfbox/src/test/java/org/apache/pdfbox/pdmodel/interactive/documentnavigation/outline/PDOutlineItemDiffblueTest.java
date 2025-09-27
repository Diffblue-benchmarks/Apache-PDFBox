package org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageFitDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageXYZDestination;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDOutlineItemDiffblueTest {
  /**
   * Test {@link PDOutlineItem#PDOutlineItem(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineItem#PDOutlineItem(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDOutlineItem(COSDictionary); when COSDictionary(); then return COSObject is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineItem.<init>()", "void PDOutlineItem.<init>(COSDictionary)"})
  void testNewPDOutlineItem_whenCOSDictionary_thenReturnCOSObjectIsCOSDictionary() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    // Act and Assert
    assertSame(dic, new PDOutlineItem(dic).getCOSObject());
  }

  /**
   * Test {@link PDOutlineItem#insertSiblingAfter(PDOutlineItem)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineItem#insertSiblingAfter(PDOutlineItem)}
   */
  @Test
  @DisplayName("Test insertSiblingAfter(PDOutlineItem); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineItem.insertSiblingAfter(PDOutlineItem)"})
  void testInsertSiblingAfter_thenThrowIllegalArgumentException() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();

    PDOutlineItem newSibling = new PDOutlineItem();
    newSibling.insertSiblingAfter(new PDOutlineItem());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> pdOutlineItem.insertSiblingAfter(newSibling));
  }

  /**
   * Test {@link PDOutlineItem#insertSiblingBefore(PDOutlineItem)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineItem#insertSiblingBefore(PDOutlineItem)}
   */
  @Test
  @DisplayName("Test insertSiblingBefore(PDOutlineItem); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineItem.insertSiblingBefore(PDOutlineItem)"})
  void testInsertSiblingBefore_thenThrowIllegalArgumentException() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();

    PDOutlineItem newSibling = new PDOutlineItem();
    newSibling.insertSiblingAfter(new PDOutlineItem());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> pdOutlineItem.insertSiblingBefore(newSibling));
  }

  /**
   * Test {@link PDOutlineItem#getPreviousSibling()}.
   *
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineItem#getPreviousSibling()}
   */
  @Test
  @DisplayName("Test getPreviousSibling(); given PDOutlineItem(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDOutlineItem PDOutlineItem.getPreviousSibling()"})
  void testGetPreviousSibling_givenPDOutlineItem_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDOutlineItem().getPreviousSibling());
  }

  /**
   * Test {@link PDOutlineItem#getPreviousSibling()}.
   *
   * <ul>
   *   <li>Then return {@link PDOutlineItem#PDOutlineItem()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineItem#getPreviousSibling()}
   */
  @Test
  @DisplayName("Test getPreviousSibling(); then return PDOutlineItem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDOutlineItem PDOutlineItem.getPreviousSibling()"})
  void testGetPreviousSibling_thenReturnPDOutlineItem() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    PDOutlineItem newSibling = new PDOutlineItem();
    pdOutlineItem.insertSiblingBefore(newSibling);

    // Act and Assert
    assertEquals(newSibling, pdOutlineItem.getPreviousSibling());
  }

  /**
   * Test {@link PDOutlineItem#setPreviousSibling(PDOutlineNode)}.
   *
   * <ul>
   *   <li>Then {@link PDOutlineItem#PDOutlineItem()} PreviousSibling COSObject is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineItem#setPreviousSibling(PDOutlineNode)}
   */
  @Test
  @DisplayName(
      "Test setPreviousSibling(PDOutlineNode); then PDOutlineItem() PreviousSibling COSObject is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineItem.setPreviousSibling(PDOutlineNode)"})
  void testSetPreviousSibling_thenPDOutlineItemPreviousSiblingCOSObjectIsCOSDictionary() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();

    PDOutlineNode outlineNode = mock(PDOutlineNode.class);
    COSDictionary cosDictionary = new COSDictionary();
    when(outlineNode.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdOutlineItem.setPreviousSibling(outlineNode);

    // Assert
    verify(outlineNode).getCOSObject();
    PDOutlineItem previousSibling = pdOutlineItem.getPreviousSibling();
    assertSame(cosDictionary, previousSibling.getCOSObject());
    assertArrayEquals(
        new float[] {0.0f, 0.0f, 0.0f}, previousSibling.getTextColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDOutlineItem#getNextSibling()}.
   *
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineItem#getNextSibling()}
   */
  @Test
  @DisplayName("Test getNextSibling(); given PDOutlineItem(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDOutlineItem PDOutlineItem.getNextSibling()"})
  void testGetNextSibling_givenPDOutlineItem_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDOutlineItem().getNextSibling());
  }

  /**
   * Test {@link PDOutlineItem#getNextSibling()}.
   *
   * <ul>
   *   <li>Then return {@link PDOutlineItem#PDOutlineItem()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineItem#getNextSibling()}
   */
  @Test
  @DisplayName("Test getNextSibling(); then return PDOutlineItem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDOutlineItem PDOutlineItem.getNextSibling()"})
  void testGetNextSibling_thenReturnPDOutlineItem() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    PDOutlineItem newSibling = new PDOutlineItem();
    pdOutlineItem.insertSiblingAfter(newSibling);

    // Act and Assert
    assertEquals(newSibling, pdOutlineItem.getNextSibling());
  }

  /**
   * Test {@link PDOutlineItem#setNextSibling(PDOutlineNode)}.
   *
   * <ul>
   *   <li>Then {@link PDOutlineItem#PDOutlineItem()} NextSibling COSObject is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineItem#setNextSibling(PDOutlineNode)}
   */
  @Test
  @DisplayName(
      "Test setNextSibling(PDOutlineNode); then PDOutlineItem() NextSibling COSObject is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineItem.setNextSibling(PDOutlineNode)"})
  void testSetNextSibling_thenPDOutlineItemNextSiblingCOSObjectIsCOSDictionary() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();

    PDOutlineNode outlineNode = mock(PDOutlineNode.class);
    COSDictionary cosDictionary = new COSDictionary();
    when(outlineNode.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdOutlineItem.setNextSibling(outlineNode);

    // Assert
    verify(outlineNode).getCOSObject();
    PDOutlineItem nextSibling = pdOutlineItem.getNextSibling();
    assertSame(cosDictionary, nextSibling.getCOSObject());
    assertArrayEquals(
        new float[] {0.0f, 0.0f, 0.0f}, nextSibling.getTextColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDOutlineItem#getTitle()}.
   *
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineItem#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle(); given PDOutlineItem(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDOutlineItem.getTitle()"})
  void testGetTitle_givenPDOutlineItem_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDOutlineItem().getTitle());
  }

  /**
   * Test {@link PDOutlineItem#getDestination()}.
   *
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineItem#getDestination()}
   */
  @Test
  @DisplayName("Test getDestination(); given PDOutlineItem(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDestination PDOutlineItem.getDestination()"})
  void testGetDestination_givenPDOutlineItem_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDOutlineItem().getDestination());
  }

  /**
   * Test {@link PDOutlineItem#setDestination(PDDestination)} with {@code dest}.
   *
   * <ul>
   *   <li>Then {@link PDOutlineItem#PDOutlineItem()} Destination {@link PDPageFitDestination}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineItem#setDestination(PDDestination)}
   */
  @Test
  @DisplayName(
      "Test setDestination(PDDestination) with 'dest'; then PDOutlineItem() Destination PDPageFitDestination")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineItem.setDestination(PDDestination)"})
  void testSetDestinationWithDest_thenPDOutlineItemDestinationPDPageFitDestination()
      throws IOException {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();

    // Act
    pdOutlineItem.setDestination(new PDPageFitDestination());

    // Assert
    PDDestination destination = pdOutlineItem.getDestination();
    assertTrue(destination instanceof PDPageFitDestination);
    assertNull(((PDPageFitDestination) destination).getPage());
    assertEquals(-1, ((PDPageFitDestination) destination).getPageNumber());
  }

  /**
   * Test {@link PDOutlineItem#setDestination(PDPage)} with {@code page}.
   *
   * <p>Method under test: {@link PDOutlineItem#setDestination(PDPage)}
   */
  @Test
  @DisplayName("Test setDestination(PDPage) with 'page'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineItem.setDestination(PDPage)"})
  void testSetDestinationWithPage() throws IOException {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem(new COSDictionary());

    // Act
    pdOutlineItem.setDestination(new PDPage());

    // Assert
    PDDestination destination = pdOutlineItem.getDestination();
    assertTrue(destination instanceof PDPageXYZDestination);
    PDPage page = ((PDPageXYZDestination) destination).getPage();
    PDRectangle artBox = page.getArtBox();
    assertSame(artBox, page.getBBox());
    assertSame(artBox, page.getBleedBox());
    assertSame(artBox, page.getCropBox());
    assertSame(artBox, page.getMediaBox());
  }

  /**
   * Test {@link PDOutlineItem#setDestination(PDPage)} with {@code page}.
   *
   * <ul>
   *   <li>Then {@link PDOutlineItem#PDOutlineItem()} Destination {@link PDPageXYZDestination}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineItem#setDestination(PDPage)}
   */
  @Test
  @DisplayName(
      "Test setDestination(PDPage) with 'page'; then PDOutlineItem() Destination PDPageXYZDestination")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineItem.setDestination(PDPage)"})
  void testSetDestinationWithPage_thenPDOutlineItemDestinationPDPageXYZDestination()
      throws IOException {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();

    // Act
    pdOutlineItem.setDestination(new PDPage());

    // Assert
    PDDestination destination = pdOutlineItem.getDestination();
    assertTrue(destination instanceof PDPageXYZDestination);
    PDPage page = ((PDPageXYZDestination) destination).getPage();
    PDRectangle artBox = page.getArtBox();
    assertSame(artBox, page.getBBox());
    assertSame(artBox, page.getBleedBox());
    assertSame(artBox, page.getCropBox());
    assertSame(artBox, page.getMediaBox());
  }

  /**
   * Test {@link PDOutlineItem#setDestination(PDPage)} with {@code page}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDOutlineItem#PDOutlineItem()} Destination is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineItem#setDestination(PDPage)}
   */
  @Test
  @DisplayName(
      "Test setDestination(PDPage) with 'page'; when 'null'; then PDOutlineItem() Destination is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineItem.setDestination(PDPage)"})
  void testSetDestinationWithPage_whenNull_thenPDOutlineItemDestinationIsNull() throws IOException {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();

    // Act
    pdOutlineItem.setDestination((PDPage) null);

    // Assert that nothing has changed
    assertNull(pdOutlineItem.getDestination());
  }

  /**
   * Test {@link PDOutlineItem#findDestinationPage(PDDocument)}.
   *
   * <p>Method under test: {@link PDOutlineItem#findDestinationPage(PDDocument)}
   */
  @Test
  @DisplayName("Test findDestinationPage(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPage PDOutlineItem.findDestinationPage(PDDocument)"})
  void testFindDestinationPage() throws IOException {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();

    // Act and Assert
    assertNull(pdOutlineItem.findDestinationPage(new PDDocument()));
  }

  /**
   * Test {@link PDOutlineItem#getAction()}.
   *
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineItem#getAction()}
   */
  @Test
  @DisplayName("Test getAction(); given PDOutlineItem(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.interactive.action.PDAction PDOutlineItem.getAction()"
  })
  void testGetAction_givenPDOutlineItem_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDOutlineItem().getAction());
  }

  /**
   * Test {@link PDOutlineItem#getStructureElement()}.
   *
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineItem#getStructureElement()}
   */
  @Test
  @DisplayName("Test getStructureElement(); given PDOutlineItem(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureElement PDOutlineItem.getStructureElement()"
  })
  void testGetStructureElement_givenPDOutlineItem_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDOutlineItem().getStructureElement());
  }

  /**
   * Test {@link PDOutlineItem#getTextColor()}.
   *
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()}.
   *   <li>Then ColorSpace COSObject return {@link COSName}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineItem#getTextColor()}
   */
  @Test
  @DisplayName(
      "Test getTextColor(); given PDOutlineItem(); then ColorSpace COSObject return COSName")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColor PDOutlineItem.getTextColor()"})
  void testGetTextColor_givenPDOutlineItem_thenColorSpaceCOSObjectReturnCOSName() {
    // Arrange and Act
    PDColor actualTextColor = new PDOutlineItem().getTextColor();

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
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f}, actualTextColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDOutlineItem#setTextColor(PDColor)} with {@code PDColor}.
   *
   * <p>Method under test: {@link PDOutlineItem#setTextColor(PDColor)}
   */
  @Test
  @DisplayName("Test setTextColor(PDColor) with 'PDColor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineItem.setTextColor(PDColor)"})
  void testSetTextColorWithPDColor() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();

    // Act
    pdOutlineItem.setTextColor(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert that nothing has changed
    PDColor textColor = pdOutlineItem.getTextColor();
    assertFalse(textColor.isPattern());
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f}, textColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDOutlineItem#setTextColor(PDColor)} with {@code PDColor}.
   *
   * <ul>
   *   <li>Then {@link PDOutlineItem#PDOutlineItem()} TextColor Pattern.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineItem#setTextColor(PDColor)}
   */
  @Test
  @DisplayName("Test setTextColor(PDColor) with 'PDColor'; then PDOutlineItem() TextColor Pattern")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineItem.setTextColor(PDColor)"})
  void testSetTextColorWithPDColor_thenPDOutlineItemTextColorPattern() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();

    // Act
    pdOutlineItem.setTextColor(new PDColor(COSName.A, PDDeviceGray.INSTANCE));

    // Assert
    PDColor textColor = pdOutlineItem.getTextColor();
    assertTrue(textColor.isPattern());
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f}, textColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDOutlineItem#setTextColor(PDColor)} with {@code PDColor}.
   *
   * <ul>
   *   <li>Then {@link PDOutlineItem#PDOutlineItem()} TextColor PatternName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineItem#setTextColor(PDColor)}
   */
  @Test
  @DisplayName(
      "Test setTextColor(PDColor) with 'PDColor'; then PDOutlineItem() TextColor PatternName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineItem.setTextColor(PDColor)"})
  void testSetTextColorWithPDColor_thenPDOutlineItemTextColorPatternNameIsNull() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    PDColor textColor = new PDColor(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, PDDeviceGray.INSTANCE);

    // Act
    pdOutlineItem.setTextColor(textColor);

    // Assert
    PDColor textColor2 = pdOutlineItem.getTextColor();
    assertNull(textColor2.getPatternName());
    assertFalse(textColor2.isPattern());
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f}, textColor2.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDOutlineItem#isItalic()}.
   *
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineItem#isItalic()}
   */
  @Test
  @DisplayName("Test isItalic(); given PDOutlineItem(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOutlineItem.isItalic()"})
  void testIsItalic_givenPDOutlineItem_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDOutlineItem().isItalic());
  }

  /**
   * Test {@link PDOutlineItem#isBold()}.
   *
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineItem#isBold()}
   */
  @Test
  @DisplayName("Test isBold(); given PDOutlineItem(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOutlineItem.isBold()"})
  void testIsBold_givenPDOutlineItem_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDOutlineItem().isBold());
  }
}
