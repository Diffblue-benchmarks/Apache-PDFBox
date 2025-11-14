package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.HeadlessException;
import java.io.File;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PDFToImageDiffblueTest {
  @Mock private File file;

  @InjectMocks private PDFToImage pDFToImage;

  /**
   * Test {@link PDFToImage#call()}.
   *
   * <p>Method under test: {@link PDFToImage#call()}
   */
  @Test
  @DisplayName("Test call()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer PDFToImage.call()"})
  void testCall() {
    // Arrange
    when(file.getAbsolutePath()).thenReturn("Absolute Path");
    when(file.toPath()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), ""));

    // Act
    Integer actualCallResult = pDFToImage.call();

    // Assert
    verify(file).getAbsolutePath();
    verify(file).toPath();
    assertEquals(4, actualCallResult.intValue());
  }

  /**
   * Test {@link PDFToImage#call()}.
   *
   * <ul>
   *   <li>Given {@link File} {@link File#getAbsolutePath()} return {@code null}.
   *   <li>Then return intValue is four.
   * </ul>
   *
   * <p>Method under test: {@link PDFToImage#call()}
   */
  @Test
  @DisplayName(
      "Test call(); given File getAbsolutePath() return 'null'; then return intValue is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer PDFToImage.call()"})
  void testCall_givenFileGetAbsolutePathReturnNull_thenReturnIntValueIsFour() {
    // Arrange
    when(file.getAbsolutePath()).thenReturn(null);
    when(file.toPath()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

    // Act
    Integer actualCallResult = pDFToImage.call();

    // Assert
    verify(file).getAbsolutePath();
    verify(file).toPath();
    assertEquals(4, actualCallResult.intValue());
  }

  /**
   * Test {@link PDFToImage#call()}.
   *
   * <ul>
   *   <li>Given {@link File} {@link File#toPath()} return Property is {@code java.io.tmpdir} is
   *       array of {@link String} with {@code test.txt}.
   * </ul>
   *
   * <p>Method under test: {@link PDFToImage#call()}
   */
  @Test
  @DisplayName(
      "Test call(); given File toPath() return Property is 'java.io.tmpdir' is array of String with 'test.txt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer PDFToImage.call()"})
  void testCall_givenFileToPathReturnPropertyIsJavaIoTmpdirIsArrayOfStringWithTestTxt() {
    // Arrange
    when(file.getAbsolutePath()).thenReturn("Absolute Path");
    when(file.toPath()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

    // Act
    Integer actualCallResult = pDFToImage.call();

    // Assert
    verify(file).getAbsolutePath();
    verify(file).toPath();
    assertEquals(4, actualCallResult.intValue());
  }

  /**
   * Test {@link PDFToImage#call()}.
   *
   * <ul>
   *   <li>Then throw {@link HeadlessException}.
   * </ul>
   *
   * <p>Method under test: {@link PDFToImage#call()}
   */
  @Test
  @DisplayName("Test call(); then throw HeadlessException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer PDFToImage.call()"})
  void testCall_thenThrowHeadlessException() {
    // Arrange
    when(file.getAbsolutePath()).thenThrow(new HeadlessException());

    // Act and Assert
    assertThrows(HeadlessException.class, () -> pDFToImage.call());
    verify(file).getAbsolutePath();
  }
}
