package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class WriteDecodedDocDiffblueTest {
  @Mock private File file;

  @InjectMocks private WriteDecodedDoc writeDecodedDoc;

  /**
   * Test {@link WriteDecodedDoc#call()}.
   *
   * <ul>
   *   <li>Given {@link File} {@link File#getAbsolutePath()} return {@code 42}.
   *   <li>Then return intValue is four.
   * </ul>
   *
   * <p>Method under test: {@link WriteDecodedDoc#call()}
   */
  @Test
  @DisplayName(
      "Test call(); given File getAbsolutePath() return '42'; then return intValue is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer WriteDecodedDoc.call()"})
  void testCall_givenFileGetAbsolutePathReturn42_thenReturnIntValueIsFour() {
    // Arrange
    when(file.getAbsolutePath()).thenReturn("42");

    // Act
    Integer actualCallResult = writeDecodedDoc.call();

    // Assert
    verify(file, atLeast(1)).getAbsolutePath();
    assertEquals(4, actualCallResult.intValue());
  }

  /**
   * Test {@link WriteDecodedDoc#call()}.
   *
   * <ul>
   *   <li>Given {@link File} {@link File#getAbsolutePath()} return {@code Absolute Path}.
   *   <li>Then return intValue is four.
   * </ul>
   *
   * <p>Method under test: {@link WriteDecodedDoc#call()}
   */
  @Test
  @DisplayName(
      "Test call(); given File getAbsolutePath() return 'Absolute Path'; then return intValue is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer WriteDecodedDoc.call()"})
  void testCall_givenFileGetAbsolutePathReturnAbsolutePath_thenReturnIntValueIsFour() {
    // Arrange
    when(file.getAbsolutePath()).thenReturn("Absolute Path");

    // Act
    Integer actualCallResult = writeDecodedDoc.call();

    // Assert
    verify(file, atLeast(1)).getAbsolutePath();
    assertEquals(4, actualCallResult.intValue());
  }

  /**
   * Test {@link WriteDecodedDoc#call()}.
   *
   * <ul>
   *   <li>Given {@link File} {@link File#getAbsolutePath()} return empty string.
   *   <li>Then return intValue is four.
   * </ul>
   *
   * <p>Method under test: {@link WriteDecodedDoc#call()}
   */
  @Test
  @DisplayName(
      "Test call(); given File getAbsolutePath() return empty string; then return intValue is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer WriteDecodedDoc.call()"})
  void testCall_givenFileGetAbsolutePathReturnEmptyString_thenReturnIntValueIsFour() {
    // Arrange
    when(file.getAbsolutePath()).thenReturn("");

    // Act
    Integer actualCallResult = writeDecodedDoc.call();

    // Assert
    verify(file, atLeast(1)).getAbsolutePath();
    assertEquals(4, actualCallResult.intValue());
  }

  /**
   * Test {@link WriteDecodedDoc#call()}.
   *
   * <ul>
   *   <li>Given {@link File} {@link File#getAbsolutePath()} return {@code foo}.
   *   <li>Then return intValue is four.
   * </ul>
   *
   * <p>Method under test: {@link WriteDecodedDoc#call()}
   */
  @Test
  @DisplayName(
      "Test call(); given File getAbsolutePath() return 'foo'; then return intValue is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer WriteDecodedDoc.call()"})
  void testCall_givenFileGetAbsolutePathReturnFoo_thenReturnIntValueIsFour() {
    // Arrange
    when(file.getAbsolutePath()).thenReturn("foo");

    // Act
    Integer actualCallResult = writeDecodedDoc.call();

    // Assert
    verify(file, atLeast(1)).getAbsolutePath();
    assertEquals(4, actualCallResult.intValue());
  }

  /**
   * Test {@link WriteDecodedDoc#call()}.
   *
   * <ul>
   *   <li>Given {@link File} {@link File#getAbsolutePath()} return {@code .pdf}.
   *   <li>Then return intValue is four.
   * </ul>
   *
   * <p>Method under test: {@link WriteDecodedDoc#call()}
   */
  @Test
  @DisplayName(
      "Test call(); given File getAbsolutePath() return '.pdf'; then return intValue is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer WriteDecodedDoc.call()"})
  void testCall_givenFileGetAbsolutePathReturnPdf_thenReturnIntValueIsFour() {
    // Arrange
    when(file.getAbsolutePath()).thenReturn(".pdf");

    // Act
    Integer actualCallResult = writeDecodedDoc.call();

    // Assert
    verify(file, atLeast(1)).getAbsolutePath();
    assertEquals(4, actualCallResult.intValue());
  }
}
