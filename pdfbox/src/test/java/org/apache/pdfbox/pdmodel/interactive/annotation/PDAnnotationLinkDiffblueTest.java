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
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.interactive.action.OpenMode;
import org.apache.pdfbox.pdmodel.interactive.action.PDAction;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionEmbeddedGoTo;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionURI;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDNamedDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageFitDestination;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDAnnotationLinkDiffblueTest {
  /**
   * Test {@link PDAnnotationLink#PDAnnotationLink()}.
   *
   * <p>Method under test: {@link PDAnnotationLink#PDAnnotationLink()}
   */
  @Test
  @DisplayName("Test new PDAnnotationLink()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLink.<init>()"})
  void testNewPDAnnotationLink() throws IOException {
    // Arrange and Act
    PDAnnotationLink actualPdAnnotationLink = new PDAnnotationLink();

    // Assert
    assertNull(actualPdAnnotationLink.getQuadPoints());
    assertNull(actualPdAnnotationLink.getAnnotationName());
    assertNull(actualPdAnnotationLink.getContents());
    assertNull(actualPdAnnotationLink.getModifiedDate());
    assertNull(actualPdAnnotationLink.getAppearanceState());
    assertNull(actualPdAnnotationLink.getPage());
    assertNull(actualPdAnnotationLink.getRectangle());
    assertNull(actualPdAnnotationLink.getOptionalContent());
    assertNull(actualPdAnnotationLink.getColor());
    assertNull(actualPdAnnotationLink.getAction());
    assertNull(actualPdAnnotationLink.getPreviousURI());
    assertNull(actualPdAnnotationLink.getAppearance());
    assertNull(actualPdAnnotationLink.getNormalAppearanceStream());
    assertNull(actualPdAnnotationLink.getBorderStyle());
    assertNull(actualPdAnnotationLink.getDestination());
    assertEquals(-1, actualPdAnnotationLink.getStructParent());
    assertEquals(0, actualPdAnnotationLink.getAnnotationFlags());
    assertFalse(actualPdAnnotationLink.isHidden());
    assertFalse(actualPdAnnotationLink.isInvisible());
    assertFalse(actualPdAnnotationLink.isLocked());
    assertFalse(actualPdAnnotationLink.isLockedContents());
    assertFalse(actualPdAnnotationLink.isNoRotate());
    assertFalse(actualPdAnnotationLink.isNoView());
    assertFalse(actualPdAnnotationLink.isNoZoom());
    assertFalse(actualPdAnnotationLink.isPrinted());
    assertFalse(actualPdAnnotationLink.isReadOnly());
    assertFalse(actualPdAnnotationLink.isToggleNoView());
    assertEquals(PDAnnotationLink.HIGHLIGHT_MODE_INVERT, actualPdAnnotationLink.getHighlightMode());
    assertEquals(PDAnnotationLink.SUB_TYPE, actualPdAnnotationLink.getSubtype());
  }

  /**
   * Test {@link PDAnnotationLink#PDAnnotationLink(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return QuadPoints is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLink#PDAnnotationLink(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDAnnotationLink(COSDictionary); when COSDictionary(); then return QuadPoints is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLink.<init>(COSDictionary)"})
  void testNewPDAnnotationLink_whenCOSDictionary_thenReturnQuadPointsIsNull() throws IOException {
    // Arrange
    COSDictionary field = new COSDictionary();

    // Act
    PDAnnotationLink actualPdAnnotationLink = new PDAnnotationLink(field);

    // Assert
    assertNull(actualPdAnnotationLink.getQuadPoints());
    assertNull(actualPdAnnotationLink.getAnnotationName());
    assertNull(actualPdAnnotationLink.getContents());
    assertNull(actualPdAnnotationLink.getModifiedDate());
    assertNull(actualPdAnnotationLink.getSubtype());
    assertNull(actualPdAnnotationLink.getAppearanceState());
    assertNull(actualPdAnnotationLink.getPage());
    assertNull(actualPdAnnotationLink.getRectangle());
    assertNull(actualPdAnnotationLink.getOptionalContent());
    assertNull(actualPdAnnotationLink.getColor());
    assertNull(actualPdAnnotationLink.getAction());
    assertNull(actualPdAnnotationLink.getPreviousURI());
    assertNull(actualPdAnnotationLink.getAppearance());
    assertNull(actualPdAnnotationLink.getNormalAppearanceStream());
    assertNull(actualPdAnnotationLink.getBorderStyle());
    assertNull(actualPdAnnotationLink.getDestination());
    assertEquals(-1, actualPdAnnotationLink.getStructParent());
    assertEquals(0, actualPdAnnotationLink.getAnnotationFlags());
    assertEquals(1, field.size());
    assertFalse(actualPdAnnotationLink.isHidden());
    assertFalse(actualPdAnnotationLink.isInvisible());
    assertFalse(actualPdAnnotationLink.isLocked());
    assertFalse(actualPdAnnotationLink.isLockedContents());
    assertFalse(actualPdAnnotationLink.isNoRotate());
    assertFalse(actualPdAnnotationLink.isNoView());
    assertFalse(actualPdAnnotationLink.isNoZoom());
    assertFalse(actualPdAnnotationLink.isPrinted());
    assertFalse(actualPdAnnotationLink.isReadOnly());
    assertFalse(actualPdAnnotationLink.isToggleNoView());
    assertEquals(PDAnnotationLink.HIGHLIGHT_MODE_INVERT, actualPdAnnotationLink.getHighlightMode());
    assertSame(field, actualPdAnnotationLink.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationLink#getAction()}.
   *
   * <p>Method under test: {@link PDAnnotationLink#getAction()}
   */
  @Test
  @DisplayName("Test getAction()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAction PDAnnotationLink.getAction()"})
  void testGetAction() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationLink().getAction());
  }

  /**
   * Test {@link PDAnnotationLink#setAction(PDAction)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLink#setAction(PDAction)}
   */
  @Test
  @DisplayName(
      "Test setAction(PDAction); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLink.setAction(PDAction)"})
  void testSetAction_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAnnotationLink.setAction(new PDActionEmbeddedGoTo(a));

    // Assert
    assertNull(pdAnnotationLink.getAction());
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLink#setAction(PDAction)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLink#setAction(PDAction)}
   */
  @Test
  @DisplayName("Test setAction(PDAction); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLink.setAction(PDAction)"})
  void testSetAction_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    COSDictionary a = new COSDictionary();
    a.setDirect(true);

    // Act
    pdAnnotationLink.setAction(new PDActionEmbeddedGoTo(a));

    // Assert
    assertNull(pdAnnotationLink.getAction());
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLink#setAction(PDAction)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationLink#PDAnnotationLink()} Action {@link PDActionEmbeddedGoTo}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLink#setAction(PDAction)}
   */
  @Test
  @DisplayName("Test setAction(PDAction); then PDAnnotationLink() Action PDActionEmbeddedGoTo")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLink.setAction(PDAction)"})
  void testSetAction_thenPDAnnotationLinkActionPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.setAction(new PDActionEmbeddedGoTo());

    // Assert
    PDAction action = pdAnnotationLink.getAction();
    assertTrue(action instanceof PDActionEmbeddedGoTo);
    assertEquals("Action", action.getType());
    assertEquals("GoToE", action.getSubType());
    assertNull(action.getNext());
    assertNull(((PDActionEmbeddedGoTo) action).getFile());
    assertNull(((PDActionEmbeddedGoTo) action).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) action).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) action).getOpenInNewWindow());
  }

  /**
   * Test {@link PDAnnotationLink#setAction(PDAction)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationLink#PDAnnotationLink()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLink#setAction(PDAction)}
   */
  @Test
  @DisplayName(
      "Test setAction(PDAction); when 'null'; then PDAnnotationLink() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLink.setAction(PDAction)"})
  void testSetAction_whenNull_thenPDAnnotationLinkCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.setAction(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLink#setBorderStyle(PDBorderStyleDictionary)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLink#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  @DisplayName(
      "Test setBorderStyle(PDBorderStyleDictionary); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLink.setBorderStyle(PDBorderStyleDictionary)"})
  void testSetBorderStyle_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAnnotationLink.setBorderStyle(new PDBorderStyleDictionary(dict));

    // Assert
    PDBorderStyleDictionary borderStyle = pdAnnotationLink.getBorderStyle();
    PDLineDashPattern dashStyle = borderStyle.getDashStyle();
    COSBase cOSObject = dashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertSame(dict, borderStyle.getCOSObject());
    assertArrayEquals(new float[] {3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationLink#setBorderStyle(PDBorderStyleDictionary)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLink#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  @DisplayName(
      "Test setBorderStyle(PDBorderStyleDictionary); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLink.setBorderStyle(PDBorderStyleDictionary)"})
  void testSetBorderStyle_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    COSDictionary dict = new COSDictionary();
    dict.setDirect(true);

    // Act
    pdAnnotationLink.setBorderStyle(new PDBorderStyleDictionary(dict));

    // Assert
    PDBorderStyleDictionary borderStyle = pdAnnotationLink.getBorderStyle();
    PDLineDashPattern dashStyle = borderStyle.getDashStyle();
    COSBase cOSObject = dashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertSame(dict, borderStyle.getCOSObject());
    assertArrayEquals(new float[] {3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationLink#setBorderStyle(PDBorderStyleDictionary)}.
   *
   * <ul>
   *   <li>When {@link PDBorderStyleDictionary#PDBorderStyleDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLink#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  @DisplayName("Test setBorderStyle(PDBorderStyleDictionary); when PDBorderStyleDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLink.setBorderStyle(PDBorderStyleDictionary)"})
  void testSetBorderStyle_whenPDBorderStyleDictionary() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.setBorderStyle(new PDBorderStyleDictionary());

    // Assert
    PDLineDashPattern dashStyle = pdAnnotationLink.getBorderStyle().getDashStyle();
    COSBase cOSObject = dashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertArrayEquals(new float[] {3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationLink#getBorderStyle()}.
   *
   * <p>Method under test: {@link PDAnnotationLink#getBorderStyle()}
   */
  @Test
  @DisplayName("Test getBorderStyle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDBorderStyleDictionary PDAnnotationLink.getBorderStyle()"})
  void testGetBorderStyle() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationLink().getBorderStyle());
  }

  /**
   * Test {@link PDAnnotationLink#getDestination()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLink#getDestination()}
   */
  @Test
  @DisplayName("Test getDestination(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDestination PDAnnotationLink.getDestination()"})
  void testGetDestination_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationLink().getDestination());
  }

  /**
   * Test {@link PDAnnotationLink#setDestination(PDDestination)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationLink#PDAnnotationLink()} Destination {@link PDNamedDestination}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLink#setDestination(PDDestination)}
   */
  @Test
  @DisplayName(
      "Test setDestination(PDDestination); then PDAnnotationLink() Destination PDNamedDestination")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLink.setDestination(PDDestination)"})
  void testSetDestination_thenPDAnnotationLinkDestinationPDNamedDestination() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.setDestination(new PDNamedDestination("Dest"));

    // Assert
    PDDestination destination = pdAnnotationLink.getDestination();
    assertTrue(destination instanceof PDNamedDestination);
    assertEquals("Dest", ((PDNamedDestination) destination).getNamedDestination());
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLink#setDestination(PDDestination)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationLink#PDAnnotationLink()} Destination {@link
   *       PDPageFitDestination}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLink#setDestination(PDDestination)}
   */
  @Test
  @DisplayName(
      "Test setDestination(PDDestination); then PDAnnotationLink() Destination PDPageFitDestination")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLink.setDestination(PDDestination)"})
  void testSetDestination_thenPDAnnotationLinkDestinationPDPageFitDestination() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.setDestination(new PDPageFitDestination());

    // Assert
    PDDestination destination = pdAnnotationLink.getDestination();
    assertTrue(destination instanceof PDPageFitDestination);
    assertNull(((PDPageFitDestination) destination).getPage());
    assertEquals(-1, ((PDPageFitDestination) destination).getPageNumber());
  }

  /**
   * Test {@link PDAnnotationLink#setDestination(PDDestination)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationLink#PDAnnotationLink()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLink#setDestination(PDDestination)}
   */
  @Test
  @DisplayName(
      "Test setDestination(PDDestination); when 'null'; then PDAnnotationLink() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLink.setDestination(PDDestination)"})
  void testSetDestination_whenNull_thenPDAnnotationLinkCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.setDestination(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLink#getHighlightMode()}.
   *
   * <p>Method under test: {@link PDAnnotationLink#getHighlightMode()}
   */
  @Test
  @DisplayName("Test getHighlightMode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAnnotationLink.getHighlightMode()"})
  void testGetHighlightMode() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationLink.HIGHLIGHT_MODE_INVERT, new PDAnnotationLink().getHighlightMode());
  }

  /**
   * Test {@link PDAnnotationLink#setHighlightMode(String)}.
   *
   * <p>Method under test: {@link PDAnnotationLink#setHighlightMode(String)}
   */
  @Test
  @DisplayName("Test setHighlightMode(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLink.setHighlightMode(String)"})
  void testSetHighlightMode() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink(new COSDictionary());

    // Act
    pdAnnotationLink.setHighlightMode("Mode");

    // Assert
    assertEquals("Mode", pdAnnotationLink.getHighlightMode());
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLink#setHighlightMode(String)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationLink#PDAnnotationLink()} HighlightMode is {@code Mode}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLink#setHighlightMode(String)}
   */
  @Test
  @DisplayName("Test setHighlightMode(String); then PDAnnotationLink() HighlightMode is 'Mode'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLink.setHighlightMode(String)"})
  void testSetHighlightMode_thenPDAnnotationLinkHighlightModeIsMode() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.setHighlightMode("Mode");

    // Assert
    assertEquals("Mode", pdAnnotationLink.getHighlightMode());
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLink#setHighlightMode(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationLink#PDAnnotationLink()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLink#setHighlightMode(String)}
   */
  @Test
  @DisplayName(
      "Test setHighlightMode(String); when 'null'; then PDAnnotationLink() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLink.setHighlightMode(String)"})
  void testSetHighlightMode_whenNull_thenPDAnnotationLinkCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.setHighlightMode(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(PDAnnotationLink.HIGHLIGHT_MODE_INVERT, pdAnnotationLink.getHighlightMode());
  }

  /**
   * Test {@link PDAnnotationLink#setPreviousURI(PDActionURI)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLink#setPreviousURI(PDActionURI)}
   */
  @Test
  @DisplayName(
      "Test setPreviousURI(PDActionURI); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLink.setPreviousURI(PDActionURI)"})
  void testSetPreviousURI_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAnnotationLink.setPreviousURI(new PDActionURI(a));

    // Assert
    PDActionURI previousURI = pdAnnotationLink.getPreviousURI();
    assertNull(previousURI.getSubType());
    assertNull(previousURI.getType());
    assertSame(a, previousURI.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationLink#setPreviousURI(PDActionURI)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLink#setPreviousURI(PDActionURI)}
   */
  @Test
  @DisplayName(
      "Test setPreviousURI(PDActionURI); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLink.setPreviousURI(PDActionURI)"})
  void testSetPreviousURI_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    COSDictionary a = new COSDictionary();
    a.setDirect(true);

    // Act
    pdAnnotationLink.setPreviousURI(new PDActionURI(a));

    // Assert
    PDActionURI previousURI = pdAnnotationLink.getPreviousURI();
    assertNull(previousURI.getSubType());
    assertNull(previousURI.getType());
    assertSame(a, previousURI.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationLink#setPreviousURI(PDActionURI)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationLink#PDAnnotationLink()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLink#setPreviousURI(PDActionURI)}
   */
  @Test
  @DisplayName(
      "Test setPreviousURI(PDActionURI); when 'null'; then PDAnnotationLink() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLink.setPreviousURI(PDActionURI)"})
  void testSetPreviousURI_whenNull_thenPDAnnotationLinkCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.setPreviousURI(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLink#setPreviousURI(PDActionURI)}.
   *
   * <ul>
   *   <li>When {@link PDActionURI#PDActionURI()}.
   *   <li>Then {@link PDAnnotationLink#PDAnnotationLink()} PreviousURI Type is {@code Action}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLink#setPreviousURI(PDActionURI)}
   */
  @Test
  @DisplayName(
      "Test setPreviousURI(PDActionURI); when PDActionURI(); then PDAnnotationLink() PreviousURI Type is 'Action'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLink.setPreviousURI(PDActionURI)"})
  void testSetPreviousURI_whenPDActionURI_thenPDAnnotationLinkPreviousURITypeIsAction() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.setPreviousURI(new PDActionURI());

    // Assert
    PDActionURI previousURI = pdAnnotationLink.getPreviousURI();
    assertEquals("Action", previousURI.getType());
    assertEquals("URI", previousURI.getSubType());
    assertNull(previousURI.getURI());
    assertNull(previousURI.getNext());
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLink#getPreviousURI()}.
   *
   * <p>Method under test: {@link PDAnnotationLink#getPreviousURI()}
   */
  @Test
  @DisplayName("Test getPreviousURI()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDActionURI PDAnnotationLink.getPreviousURI()"})
  void testGetPreviousURI() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationLink().getPreviousURI());
  }

  /**
   * Test {@link PDAnnotationLink#setQuadPoints(float[])}.
   *
   * <p>Method under test: {@link PDAnnotationLink#setQuadPoints(float[])}
   */
  @Test
  @DisplayName("Test setQuadPoints(float[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLink.setQuadPoints(float[])"})
  void testSetQuadPoints() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.setQuadPoints(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, pdAnnotationLink.getQuadPoints(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationLink#getQuadPoints()}.
   *
   * <p>Method under test: {@link PDAnnotationLink#getQuadPoints()}
   */
  @Test
  @DisplayName("Test getQuadPoints()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDAnnotationLink.getQuadPoints()"})
  void testGetQuadPoints() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationLink().getQuadPoints());
  }
}
