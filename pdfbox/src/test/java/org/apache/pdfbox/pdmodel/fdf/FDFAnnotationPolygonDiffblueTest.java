package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Color;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FDFAnnotationPolygonDiffblueTest {
  /**
   * Test {@link FDFAnnotationPolygon#FDFAnnotationPolygon(COSDictionary)}.
   * <p>
   * Method under test: {@link FDFAnnotationPolygon#FDFAnnotationPolygon(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFAnnotationPolygon(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFAnnotationPolygon.<init>(COSDictionary)"})
  void testNewFDFAnnotationPolygon() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new FDFAnnotationPolygon(a)).getCOSObject());
  }

  /**
   * Test {@link FDFAnnotationPolygon#FDFAnnotationPolygon()}.
   * <p>
   * Method under test: {@link FDFAnnotationPolygon#FDFAnnotationPolygon()}
   */
  @Test
  @DisplayName("Test new FDFAnnotationPolygon()")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link FDFAnnotationPolygon#setVertices(float[])}.
   * <ul>
   *   <li>Then {@link FDFAnnotationPolygon#FDFAnnotationPolygon()} COSObject Values size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationPolygon#setVertices(float[])}
   */
  @Test
  @DisplayName("Test setVertices(float[]); then FDFAnnotationPolygon() COSObject Values size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFAnnotationPolygon.setVertices(float[])"})
  void testSetVertices_thenFDFAnnotationPolygonCOSObjectValuesSizeIsThree() {
    // Arrange
    FDFAnnotationPolygon fdfAnnotationPolygon = new FDFAnnotationPolygon();

    // Act
    fdfAnnotationPolygon.setVertices(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    COSDictionary cOSObject = fdfAnnotationPolygon.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, fdfAnnotationPolygon.getVertices(), 0.0f);
  }

  /**
   * Test {@link FDFAnnotationPolygon#getVertices()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationPolygon#FDFAnnotationPolygon()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationPolygon#getVertices()}
   */
  @Test
  @DisplayName("Test getVertices(); given FDFAnnotationPolygon(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float[] FDFAnnotationPolygon.getVertices()"})
  void testGetVertices_givenFDFAnnotationPolygon_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationPolygon()).getVertices());
  }

  /**
   * Test {@link FDFAnnotationPolygon#getVertices()}.
   * <ul>
   *   <li>Then return array of {@code float} with ten and {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationPolygon#getVertices()}
   */
  @Test
  @DisplayName("Test getVertices(); then return array of float with ten and '0.5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float[] FDFAnnotationPolygon.getVertices()"})
  void testGetVertices_thenReturnArrayOfFloatWithTenAnd05() {
    // Arrange
    FDFAnnotationPolygon fdfAnnotationPolygon = new FDFAnnotationPolygon();
    fdfAnnotationPolygon.setVertices(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Act and Assert
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, fdfAnnotationPolygon.getVertices(), 0.0f);
  }

  /**
   * Test {@link FDFAnnotationPolygon#getInteriorColor()}.
   * <ul>
   *   <li>Given {@link FDFAnnotationPolygon#FDFAnnotationPolygon()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationPolygon#getInteriorColor()}
   */
  @Test
  @DisplayName("Test getInteriorColor(); given FDFAnnotationPolygon(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Color FDFAnnotationPolygon.getInteriorColor()"})
  void testGetInteriorColor_givenFDFAnnotationPolygon_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationPolygon()).getInteriorColor());
  }

  /**
   * Test {@link FDFAnnotationPolygon#getInteriorColor()}.
   * <ul>
   *   <li>Then return decode {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFAnnotationPolygon#getInteriorColor()}
   */
  @Test
  @DisplayName("Test getInteriorColor(); then return decode '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Color FDFAnnotationPolygon.getInteriorColor()"})
  void testGetInteriorColor_thenReturnDecode42() throws NumberFormatException {
    // Arrange
    FDFAnnotationPolygon fdfAnnotationPolygon = new FDFAnnotationPolygon();
    Color color = Color.decode("42");
    fdfAnnotationPolygon.setInteriorColor(color);

    // Act and Assert
    assertEquals(color, fdfAnnotationPolygon.getInteriorColor());
  }
}
