package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GlyphListDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GlyphList#getAdobeGlyphList()}
   *   <li>{@link GlyphList#getZapfDingbats()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GlyphList GlyphList.getAdobeGlyphList()", "GlyphList GlyphList.getZapfDingbats()"})
  void testGettersAndSetters() {
    // Arrange and Act
    GlyphList actualAdobeGlyphList = GlyphList.getAdobeGlyphList();
    GlyphList actualAdobeGlyphList2 = actualAdobeGlyphList.getAdobeGlyphList();
    actualAdobeGlyphList.getZapfDingbats();

    // Assert
    assertSame(actualAdobeGlyphList, actualAdobeGlyphList2);
  }

  /**
   * Test {@link GlyphList#GlyphList(InputStream, int)}.
   * <ul>
   *   <li>Then return codePointToName one is {@code .notdef}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphList#GlyphList(InputStream, int)}
   */
  @Test
  @DisplayName("Test new GlyphList(InputStream, int); then return codePointToName one is '.notdef'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GlyphList.<init>(InputStream, int)"})
  void testNewGlyphList_thenReturnCodePointToNameOneIsNotdef() throws IOException {
    // Arrange and Act
    GlyphList actualGlyphList = new GlyphList(new ByteArrayInputStream(new byte[]{}), 10);

    // Assert
    assertEquals(".notdef", actualGlyphList.codePointToName(1));
    assertEquals(".notdef", actualGlyphList.sequenceToName("Unicode Sequence"));
    assertNull(actualGlyphList.toUnicode("Name"));
  }

  /**
   * Test {@link GlyphList#GlyphList(InputStream, int)}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphList#GlyphList(InputStream, int)}
   */
  @Test
  @DisplayName("Test new GlyphList(InputStream, int); then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GlyphList.<init>(InputStream, int)"})
  void testNewGlyphList_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new GlyphList(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 10));

  }

  /**
   * Test {@link GlyphList#GlyphList(GlyphList, InputStream)}.
   * <ul>
   *   <li>When AdobeGlyphList.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphList#GlyphList(GlyphList, InputStream)}
   */
  @Test
  @DisplayName("Test new GlyphList(GlyphList, InputStream); when AdobeGlyphList; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GlyphList.<init>(GlyphList, InputStream)"})
  void testNewGlyphList_whenAdobeGlyphList_thenThrowIOException() throws IOException {
    // Arrange
    GlyphList glyphList = GlyphList.getAdobeGlyphList();

    // Act and Assert
    assertThrows(IOException.class,
        () -> new GlyphList(glyphList, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

  }

  /**
   * Test {@link GlyphList#codePointToName(int)}.
   * <ul>
   *   <li>Given AdobeGlyphList.</li>
   *   <li>Then return {@code controlSTX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphList#codePointToName(int)}
   */
  @Test
  @DisplayName("Test codePointToName(int); given AdobeGlyphList; then return 'controlSTX'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String GlyphList.codePointToName(int)"})
  void testCodePointToName_givenAdobeGlyphList_thenReturnControlSTX() {
    // Arrange, Act and Assert
    assertEquals("controlSTX", GlyphList.getAdobeGlyphList().codePointToName(1));
  }

  /**
   * Test {@link GlyphList#codePointToName(int)}.
   * <ul>
   *   <li>Given ZapfDingbats.</li>
   *   <li>Then return {@code .notdef}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphList#codePointToName(int)}
   */
  @Test
  @DisplayName("Test codePointToName(int); given ZapfDingbats; then return '.notdef'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String GlyphList.codePointToName(int)"})
  void testCodePointToName_givenZapfDingbats_thenReturnNotdef() {
    // Arrange, Act and Assert
    assertEquals(".notdef", GlyphList.getZapfDingbats().codePointToName(1));
  }

  /**
   * Test {@link GlyphList#sequenceToName(String)}.
   * <p>
   * Method under test: {@link GlyphList#sequenceToName(String)}
   */
  @Test
  @DisplayName("Test sequenceToName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String GlyphList.sequenceToName(String)"})
  void testSequenceToName() {
    // Arrange, Act and Assert
    assertEquals(".notdef", GlyphList.getAdobeGlyphList().sequenceToName("Unicode Sequence"));
  }

  /**
   * Test {@link GlyphList#toUnicode(String)}.
   * <p>
   * Method under test: {@link GlyphList#toUnicode(String)}
   */
  @Test
  @DisplayName("Test toUnicode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String GlyphList.toUnicode(String)"})
  void testToUnicode() {
    // Arrange, Act and Assert
    assertNull(GlyphList.getAdobeGlyphList().toUnicode("Name"));
  }
}
