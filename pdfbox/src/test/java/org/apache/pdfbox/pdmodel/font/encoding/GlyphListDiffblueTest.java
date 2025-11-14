package org.apache.pdfbox.pdmodel.font.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GlyphListDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GlyphList#getAdobeGlyphList()}
   *   <li>{@link GlyphList#getZapfDingbats()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GlyphList GlyphList.getAdobeGlyphList()",
    "GlyphList GlyphList.getZapfDingbats()"
  })
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
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then calls {@link DataInputStream#available()}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphList#GlyphList(InputStream, int)}
   */
  @Test
  @DisplayName("Test new GlyphList(InputStream, int); given IOException(); then calls available()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphList.<init>(InputStream, int)"})
  void testNewGlyphList_givenIOException_thenCallsAvailable() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.available()).thenThrow(new IOException());
    doThrow(new IOException()).when(input).close();

    // Act and Assert
    assertThrows(IOException.class, () -> new GlyphList(input, 10));
    verify(input).available();
    verify(input).close();
  }

  /**
   * Test {@link GlyphList#GlyphList(InputStream, int)}.
   *
   * <ul>
   *   <li>Then return codePointToName one is {@code .notdef}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphList#GlyphList(InputStream, int)}
   */
  @Test
  @DisplayName("Test new GlyphList(InputStream, int); then return codePointToName one is '.notdef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphList.<init>(InputStream, int)"})
  void testNewGlyphList_thenReturnCodePointToNameOneIsNotdef() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[] {});

    // Act
    GlyphList actualGlyphList = new GlyphList(input, 10);

    // Assert
    assertEquals(".notdef", actualGlyphList.codePointToName(1));
    assertEquals(".notdef", actualGlyphList.sequenceToName("Unicode Sequence"));
    assertNull(actualGlyphList.toUnicode("Name"));
  }

  /**
   * Test {@link GlyphList#GlyphList(GlyphList, InputStream)}.
   *
   * <ul>
   *   <li>When AdobeGlyphList.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphList#GlyphList(GlyphList, InputStream)}
   */
  @Test
  @DisplayName(
      "Test new GlyphList(GlyphList, InputStream); when AdobeGlyphList; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphList.<init>(GlyphList, InputStream)"})
  void testNewGlyphList_whenAdobeGlyphList_thenThrowIOException() throws IOException {
    // Arrange
    GlyphList glyphList = GlyphList.getAdobeGlyphList();

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> new GlyphList(glyphList, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link GlyphList#GlyphList(InputStream, int)}.
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphList#GlyphList(InputStream, int)}
   */
  @Test
  @DisplayName(
      "Test new GlyphList(InputStream, int); when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphList.<init>(InputStream, int)"})
  void testNewGlyphList_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new GlyphList(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 10));
  }

  /**
   * Test {@link GlyphList#codePointToName(int)}.
   *
   * <ul>
   *   <li>Given AdobeGlyphList.
   *   <li>Then return {@code controlSTX}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphList#codePointToName(int)}
   */
  @Test
  @DisplayName("Test codePointToName(int); given AdobeGlyphList; then return 'controlSTX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GlyphList.codePointToName(int)"})
  void testCodePointToName_givenAdobeGlyphList_thenReturnControlSTX() {
    // Arrange, Act and Assert
    assertEquals("controlSTX", GlyphList.getAdobeGlyphList().codePointToName(1));
  }

  /**
   * Test {@link GlyphList#codePointToName(int)}.
   *
   * <ul>
   *   <li>Given ZapfDingbats.
   *   <li>Then return {@code .notdef}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphList#codePointToName(int)}
   */
  @Test
  @DisplayName("Test codePointToName(int); given ZapfDingbats; then return '.notdef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GlyphList.codePointToName(int)"})
  void testCodePointToName_givenZapfDingbats_thenReturnNotdef() {
    // Arrange, Act and Assert
    assertEquals(".notdef", GlyphList.getZapfDingbats().codePointToName(1));
  }

  /**
   * Test {@link GlyphList#sequenceToName(String)}.
   *
   * <p>Method under test: {@link GlyphList#sequenceToName(String)}
   */
  @Test
  @DisplayName("Test sequenceToName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GlyphList.sequenceToName(String)"})
  void testSequenceToName() {
    // Arrange, Act and Assert
    assertEquals(".notdef", GlyphList.getAdobeGlyphList().sequenceToName("Unicode Sequence"));
  }

  /**
   * Test {@link GlyphList#toUnicode(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphList#toUnicode(String)}
   */
  @Test
  @DisplayName("Test toUnicode(String); when 'Name'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GlyphList.toUnicode(String)"})
  void testToUnicode_whenName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(GlyphList.getAdobeGlyphList().toUnicode("Name"));
  }

  /**
   * Test {@link GlyphList#toUnicode(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphList#toUnicode(String)}
   */
  @Test
  @DisplayName("Test toUnicode(String); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GlyphList.toUnicode(String)"})
  void testToUnicode_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(GlyphList.getAdobeGlyphList().toUnicode(null));
  }

  /**
   * Test {@link GlyphList#toUnicode(String)}.
   *
   * <ul>
   *   <li>When {@code u}.
   *   <li>Then return {@code u}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphList#toUnicode(String)}
   */
  @Test
  @DisplayName("Test toUnicode(String); when 'u'; then return 'u'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GlyphList.toUnicode(String)"})
  void testToUnicode_whenU_thenReturnU() {
    // Arrange, Act and Assert
    assertEquals("u", GlyphList.getAdobeGlyphList().toUnicode("u"));
  }

  /**
   * Test {@link GlyphList#toUnicode(String)}.
   *
   * <ul>
   *   <li>When {@code uni}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphList#toUnicode(String)}
   */
  @Test
  @DisplayName("Test toUnicode(String); when 'uni'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GlyphList.toUnicode(String)"})
  void testToUnicode_whenUni_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(GlyphList.getAdobeGlyphList().toUnicode("uni"));
  }
}
