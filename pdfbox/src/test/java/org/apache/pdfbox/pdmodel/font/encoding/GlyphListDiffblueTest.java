package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

class GlyphListDiffblueTest {
  /**
   * Method under test: {@link GlyphList#codePointToName(int)}
   */
  @Test
  void testCodePointToName() {
    // Arrange, Act and Assert
    assertEquals("controlSTX", GlyphList.getAdobeGlyphList().codePointToName(1));
    assertEquals(".notdef", GlyphList.getZapfDingbats().codePointToName(1));
  }

  /**
   * Method under test: {@link GlyphList#sequenceToName(String)}
   */
  @Test
  void testSequenceToName() {
    // Arrange, Act and Assert
    assertEquals(".notdef", GlyphList.getAdobeGlyphList().sequenceToName("Unicode Sequence"));
  }

  /**
   * Method under test: {@link GlyphList#toUnicode(String)}
   */
  @Test
  void testToUnicode() {
    // Arrange, Act and Assert
    assertNull(GlyphList.getAdobeGlyphList().toUnicode("Name"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GlyphList#getAdobeGlyphList()}
   *   <li>{@link GlyphList#getZapfDingbats()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    GlyphList actualAdobeGlyphList = GlyphList.getAdobeGlyphList();
    GlyphList actualAdobeGlyphList2 = actualAdobeGlyphList.getAdobeGlyphList();
    actualAdobeGlyphList.getZapfDingbats();

    // Assert
    assertSame(actualAdobeGlyphList, actualAdobeGlyphList2);
  }

  /**
   * Method under test: {@link GlyphList#GlyphList(InputStream, int)}
   */
  @Test
  void testNewGlyphList() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new GlyphList(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 10));

  }

  /**
   * Method under test: {@link GlyphList#GlyphList(InputStream, int)}
   */
  @Test
  void testNewGlyphList2() throws IOException {
    // Arrange and Act
    GlyphList actualGlyphList = new GlyphList(new ByteArrayInputStream(new byte[]{}), 10);

    // Assert
    assertEquals(".notdef", actualGlyphList.codePointToName(1));
    assertEquals(".notdef", actualGlyphList.sequenceToName("Unicode Sequence"));
    assertNull(actualGlyphList.toUnicode("Name"));
  }

  /**
   * Method under test: {@link GlyphList#GlyphList(GlyphList, InputStream)}
   */
  @Test
  void testNewGlyphList3() throws IOException {
    // Arrange
    GlyphList glyphList = GlyphList.getAdobeGlyphList();

    // Act and Assert
    assertThrows(IOException.class,
        () -> new GlyphList(glyphList, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

  }
}
