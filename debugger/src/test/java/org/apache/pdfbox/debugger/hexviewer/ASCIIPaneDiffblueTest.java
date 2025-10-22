package org.apache.pdfbox.debugger.hexviewer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Dimension;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ASCIIPaneDiffblueTest {
  /**
   * Test {@link ASCIIPane#ASCIIPane(HexModel)}.
   * <ul>
   *   <li>Then return PreferredSize Size Size Size Size {@link Dimension#height} is forty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCIIPane#ASCIIPane(HexModel)}
   */
  @Test
  @DisplayName("Test new ASCIIPane(HexModel); then return PreferredSize Size Size Size Size height is forty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ASCIIPane.<init>(HexModel)"})
  void testNewASCIIPane_thenReturnPreferredSizeSizeSizeSizeSizeHeightIsForty() throws UnsupportedEncodingException {
    // Arrange and Act
    ASCIIPane actualAsciiPane = new ASCIIPane(new HexModel("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    ColorModel colorModel = actualAsciiPane.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    Dimension preferredSize = actualAsciiPane.getPreferredSize();
    Dimension size = preferredSize.getSize();
    Dimension size2 = size.getSize();
    Dimension size3 = size2.getSize();
    assertEquals(40, size3.getSize().height);
    assertEquals(40, size3.height);
    assertEquals(40, size2.height);
    assertEquals(40, size.height);
    assertEquals(40, preferredSize.height);
    assertEquals(40.0d, size3.getHeight());
    assertEquals(40.0d, size2.getHeight());
    assertEquals(40.0d, size.getHeight());
    assertEquals(40.0d, preferredSize.getHeight());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
  }

  /**
   * Test {@link ASCIIPane#ASCIIPane(HexModel)}.
   * <ul>
   *   <li>Then return PreferredSize Size Size Size Size {@link Dimension#height} is twenty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCIIPane#ASCIIPane(HexModel)}
   */
  @Test
  @DisplayName("Test new ASCIIPane(HexModel); then return PreferredSize Size Size Size Size height is twenty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ASCIIPane.<init>(HexModel)"})
  void testNewASCIIPane_thenReturnPreferredSizeSizeSizeSizeSizeHeightIsTwenty() {
    // Arrange and Act
    ASCIIPane actualAsciiPane = new ASCIIPane(new HexModel(new byte[]{}));

    // Assert
    ColorModel colorModel = actualAsciiPane.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    Dimension preferredSize = actualAsciiPane.getPreferredSize();
    Dimension size = preferredSize.getSize();
    Dimension size2 = size.getSize();
    Dimension size3 = size2.getSize();
    assertEquals(20, size3.getSize().height);
    assertEquals(20, size3.height);
    assertEquals(20, size2.height);
    assertEquals(20, size.height);
    assertEquals(20, preferredSize.height);
    assertEquals(20.0d, size3.getHeight());
    assertEquals(20.0d, size2.getHeight());
    assertEquals(20.0d, size.getHeight());
    assertEquals(20.0d, preferredSize.getHeight());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
  }
}
