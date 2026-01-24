package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Color;
import java.io.IOException;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.w3c.dom.Element;

class FDFAnnotationPolygonDiffblueTest {
  /**
   * Test {@link FDFAnnotationPolygon#FDFAnnotationPolygon(COSDictionary)}.
   *
   * <p>Method under test: {@link FDFAnnotationPolygon#FDFAnnotationPolygon(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFAnnotationPolygon(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationPolygon.<init>(COSDictionary)"})
  void testNewFDFAnnotationPolygon() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, new FDFAnnotationPolygon(a).getCOSObject());
  }

  /**
   * Test {@link FDFAnnotationPolygon#FDFAnnotationPolygon()}.
   *
   * <p>Method under test: {@link FDFAnnotationPolygon#FDFAnnotationPolygon()}
   */
  @Test
  @DisplayName("Test new FDFAnnotationPolygon()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationPolygon.<init>()"})
  void testNewFDFAnnotationPolygon2() throws IOException {
    // Arrange and Act
    FDFAnnotationPolygon actualFdfAnnotationPolygon = new FDFAnnotationPolygon();

    // Assert
    assertEquals("", actualFdfAnnotationPolygon.getRichContents());
    assertNull(actualFdfAnnotationPolygon.getVertices());
    assertNull(actualFdfAnnotationPolygon.getColor());
    assertNull(actualFdfAnnotationPolygon.getInteriorColor());
    assertNull(actualFdfAnnotationPolygon.getPage());
    assertNull(actualFdfAnnotationPolygon.getContents());
    assertNull(actualFdfAnnotationPolygon.getDate());
    assertNull(actualFdfAnnotationPolygon.getIntent());
    assertNull(actualFdfAnnotationPolygon.getName());
    assertNull(actualFdfAnnotationPolygon.getSubject());
    assertNull(actualFdfAnnotationPolygon.getTitle());
    assertNull(actualFdfAnnotationPolygon.getCreationDate());
    assertNull(actualFdfAnnotationPolygon.getRectangle());
    assertNull(actualFdfAnnotationPolygon.getBorderEffect());
    assertNull(actualFdfAnnotationPolygon.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationPolygon.getOpacity());
    assertFalse(actualFdfAnnotationPolygon.isHidden());
    assertFalse(actualFdfAnnotationPolygon.isInvisible());
    assertFalse(actualFdfAnnotationPolygon.isLocked());
    assertFalse(actualFdfAnnotationPolygon.isLockedContents());
    assertFalse(actualFdfAnnotationPolygon.isNoRotate());
    assertFalse(actualFdfAnnotationPolygon.isNoView());
    assertFalse(actualFdfAnnotationPolygon.isNoZoom());
    assertFalse(actualFdfAnnotationPolygon.isPrinted());
    assertFalse(actualFdfAnnotationPolygon.isReadOnly());
    assertFalse(actualFdfAnnotationPolygon.isToggleNoView());
  }

  /**
   * Test {@link FDFAnnotationPolygon#FDFAnnotationPolygon(Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationPolygon#FDFAnnotationPolygon(Element)}
   */
  @Test
  @DisplayName(
      "Test new FDFAnnotationPolygon(Element); when IIOMetadataNode(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationPolygon.<init>(Element)"})
  void testNewFDFAnnotationPolygon_whenIIOMetadataNode_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new FDFAnnotationPolygon(new IIOMetadataNode()));
  }

  /**
   * Test {@link FDFAnnotationPolygon#setVertices(float[])}.
   *
   * <ul>
   *   <li>Then {@link FDFAnnotationPolygon#FDFAnnotationPolygon()} COSObject Values size is three.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationPolygon#setVertices(float[])}
   */
  @Test
  @DisplayName(
      "Test setVertices(float[]); then FDFAnnotationPolygon() COSObject Values size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationPolygon.setVertices(float[])"})
  void testSetVertices_thenFDFAnnotationPolygonCOSObjectValuesSizeIsThree() {
    // Arrange
    FDFAnnotationPolygon fdfAnnotationPolygon = new FDFAnnotationPolygon();

    // Act
    fdfAnnotationPolygon.setVertices(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    COSDictionary cOSObject = fdfAnnotationPolygon.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, fdfAnnotationPolygon.getVertices(), 0.0f);
  }

  /**
   * Test {@link FDFAnnotationPolygon#getVertices()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationPolygon#FDFAnnotationPolygon()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationPolygon#getVertices()}
   */
  @Test
  @DisplayName("Test getVertices(); given FDFAnnotationPolygon(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] FDFAnnotationPolygon.getVertices()"})
  void testGetVertices_givenFDFAnnotationPolygon_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationPolygon().getVertices());
  }

  /**
   * Test {@link FDFAnnotationPolygon#getVertices()}.
   *
   * <ul>
   *   <li>Then return array of {@code float} with ten and {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationPolygon#getVertices()}
   */
  @Test
  @DisplayName("Test getVertices(); then return array of float with ten and '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] FDFAnnotationPolygon.getVertices()"})
  void testGetVertices_thenReturnArrayOfFloatWithTenAnd05() {
    // Arrange
    FDFAnnotationPolygon fdfAnnotationPolygon = new FDFAnnotationPolygon();
    fdfAnnotationPolygon.setVertices(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act and Assert
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, fdfAnnotationPolygon.getVertices(), 0.0f);
  }

  /**
   * Test {@link FDFAnnotationPolygon#setInteriorColor(Color)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setItem(COSName, COSBase)} does nothing.
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationPolygon#setInteriorColor(Color)}
   */
  @Test
  @DisplayName(
      "Test setInteriorColor(Color); given COSDictionary setItem(COSName, COSBase) does nothing; then calls setItem(COSName, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationPolygon.setInteriorColor(Color)"})
  void testSetInteriorColor_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary a = mock(COSDictionary.class);
    doNothing().when(a).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    // Act
    new FDFAnnotationPolygon(a).setInteriorColor(null);

    // Assert
    verify(a).setItem(isA(COSName.class), (COSBase) isNull());
  }

  /**
   * Test {@link FDFAnnotationPolygon#getInteriorColor()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationPolygon#FDFAnnotationPolygon()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationPolygon#getInteriorColor()}
   */
  @Test
  @DisplayName("Test getInteriorColor(); given FDFAnnotationPolygon(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color FDFAnnotationPolygon.getInteriorColor()"})
  void testGetInteriorColor_givenFDFAnnotationPolygon_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationPolygon().getInteriorColor());
  }
}
