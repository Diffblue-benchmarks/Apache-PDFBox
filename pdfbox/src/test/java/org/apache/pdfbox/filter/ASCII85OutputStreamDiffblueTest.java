package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ASCII85OutputStreamDiffblueTest {
  /**
   * Test {@link ASCII85OutputStream#ASCII85OutputStream(OutputStream)}.
   *
   * <p>Method under test: {@link ASCII85OutputStream#ASCII85OutputStream(OutputStream)}
   */
  @Test
  @DisplayName("Test new ASCII85OutputStream(OutputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ASCII85OutputStream.<init>(OutputStream)"})
  void testNewASCII85OutputStream() {
    // Arrange and Act
    ASCII85OutputStream actualAscii85OutputStream =
        new ASCII85OutputStream(new ByteArrayOutputStream());

    // Assert
    assertEquals('~', actualAscii85OutputStream.getTerminator());
    assertEquals(72, actualAscii85OutputStream.getLineLength());
  }

  /**
   * Test {@link ASCII85OutputStream#setTerminator(char)}.
   *
   * <p>Method under test: {@link ASCII85OutputStream#setTerminator(char)}
   */
  @Test
  @DisplayName("Test setTerminator(char)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ASCII85OutputStream.setTerminator(char)"})
  void testSetTerminator() {
    // Arrange
    ASCII85OutputStream ascii85OutputStream = new ASCII85OutputStream(new ByteArrayOutputStream());

    // Act
    ascii85OutputStream.setTerminator('v');

    // Assert
    assertEquals('v', ascii85OutputStream.getTerminator());
  }

  /**
   * Test {@link ASCII85OutputStream#setTerminator(char)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85OutputStream#setTerminator(char)}
   */
  @Test
  @DisplayName("Test setTerminator(char); when 'A'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ASCII85OutputStream.setTerminator(char)"})
  void testSetTerminator_whenA_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new ASCII85OutputStream(new ByteArrayOutputStream()).setTerminator('A'));
  }

  /**
   * Test {@link ASCII85OutputStream#setTerminator(char)}.
   *
   * <ul>
   *   <li>When delete.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85OutputStream#setTerminator(char)}
   */
  @Test
  @DisplayName("Test setTerminator(char); when delete; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ASCII85OutputStream.setTerminator(char)"})
  void testSetTerminator_whenDelete_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new ASCII85OutputStream(new ByteArrayOutputStream()).setTerminator(''));
  }

  /**
   * Test {@link ASCII85OutputStream#setTerminator(char)}.
   *
   * <ul>
   *   <li>When {@code z}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85OutputStream#setTerminator(char)}
   */
  @Test
  @DisplayName("Test setTerminator(char); when 'z'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ASCII85OutputStream.setTerminator(char)"})
  void testSetTerminator_whenZ_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new ASCII85OutputStream(new ByteArrayOutputStream()).setTerminator('z'));
  }

  /**
   * Test {@link ASCII85OutputStream#setLineLength(int)}.
   *
   * <p>Method under test: {@link ASCII85OutputStream#setLineLength(int)}
   */
  @Test
  @DisplayName("Test setLineLength(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ASCII85OutputStream.setLineLength(int)"})
  void testSetLineLength() {
    // Arrange
    ASCII85OutputStream ascii85OutputStream = new ASCII85OutputStream(new ByteArrayOutputStream());

    // Act
    ascii85OutputStream.setLineLength(1);

    // Assert
    assertEquals(1, ascii85OutputStream.getLineLength());
  }

  /**
   * Test {@link ASCII85OutputStream#setLineLength(int)}.
   *
   * <p>Method under test: {@link ASCII85OutputStream#setLineLength(int)}
   */
  @Test
  @DisplayName("Test setLineLength(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ASCII85OutputStream.setLineLength(int)"})
  void testSetLineLength2() {
    // Arrange
    ASCII85OutputStream ascii85OutputStream = new ASCII85OutputStream(new ByteArrayOutputStream());

    // Act
    ascii85OutputStream.setLineLength(72);

    // Assert that nothing has changed
    assertEquals(72, ascii85OutputStream.getLineLength());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ASCII85OutputStream#getLineLength()}
   *   <li>{@link ASCII85OutputStream#getTerminator()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ASCII85OutputStream.getLineLength()",
    "char ASCII85OutputStream.getTerminator()"
  })
  void testGettersAndSetters() {
    // Arrange
    ASCII85OutputStream ascii85OutputStream = new ASCII85OutputStream(new ByteArrayOutputStream());

    // Act
    int actualLineLength = ascii85OutputStream.getLineLength();

    // Assert
    assertEquals('~', ascii85OutputStream.getTerminator());
    assertEquals(72, actualLineLength);
  }
}
