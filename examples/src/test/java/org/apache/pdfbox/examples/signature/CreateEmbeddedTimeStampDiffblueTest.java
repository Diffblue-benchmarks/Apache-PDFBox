package org.apache.pdfbox.examples.signature;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CreateEmbeddedTimeStampDiffblueTest {
  /**
   * Test {@link CreateEmbeddedTimeStamp#embedTimeStamp(File)} with {@code file}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link FileNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link CreateEmbeddedTimeStamp#embedTimeStamp(File)}
   */
  @Test
  @DisplayName(
      "Test embedTimeStamp(File) with 'file'; when 'null'; then throw FileNotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CreateEmbeddedTimeStamp.embedTimeStamp(File)"})
  void testEmbedTimeStampWithFile_whenNull_thenThrowFileNotFoundException()
      throws IOException, URISyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        FileNotFoundException.class,
        () -> new CreateEmbeddedTimeStamp("https://example.org/example").embedTimeStamp(null));
  }

  /**
   * Test {@link CreateEmbeddedTimeStamp#embedTimeStamp(File)} with {@code file}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code foo} toFile.
   * </ul>
   *
   * <p>Method under test: {@link CreateEmbeddedTimeStamp#embedTimeStamp(File)}
   */
  @Test
  @DisplayName(
      "Test embedTimeStamp(File) with 'file'; when Property is 'java.io.tmpdir' is 'foo' toFile")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CreateEmbeddedTimeStamp.embedTimeStamp(File)"})
  void testEmbedTimeStampWithFile_whenPropertyIsJavaIoTmpdirIsFooToFile()
      throws IOException, URISyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        FileNotFoundException.class,
        () ->
            new CreateEmbeddedTimeStamp("https://example.org/example")
                .embedTimeStamp(Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile()));
  }

  /**
   * Test {@link CreateEmbeddedTimeStamp#embedTimeStamp(File, File)} with {@code inFile}, {@code
   * outFile}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link FileNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link CreateEmbeddedTimeStamp#embedTimeStamp(File, File)}
   */
  @Test
  @DisplayName(
      "Test embedTimeStamp(File, File) with 'inFile', 'outFile'; when 'null'; then throw FileNotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CreateEmbeddedTimeStamp.embedTimeStamp(File, File)"})
  void testEmbedTimeStampWithInFileOutFile_whenNull_thenThrowFileNotFoundException()
      throws IOException, URISyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        FileNotFoundException.class,
        () ->
            new CreateEmbeddedTimeStamp("https://example.org/example")
                .embedTimeStamp(
                    null, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
  }

  /**
   * Test {@link CreateEmbeddedTimeStamp#embedTimeStamp(File, File)} with {@code inFile}, {@code
   * outFile}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code foo} toFile.
   * </ul>
   *
   * <p>Method under test: {@link CreateEmbeddedTimeStamp#embedTimeStamp(File, File)}
   */
  @Test
  @DisplayName(
      "Test embedTimeStamp(File, File) with 'inFile', 'outFile'; when Property is 'java.io.tmpdir' is 'foo' toFile")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CreateEmbeddedTimeStamp.embedTimeStamp(File, File)"})
  void testEmbedTimeStampWithInFileOutFile_whenPropertyIsJavaIoTmpdirIsFooToFile()
      throws IOException, URISyntaxException {
    // Arrange, Act and Assert
    assertThrows(
        FileNotFoundException.class,
        () ->
            new CreateEmbeddedTimeStamp("https://example.org/example")
                .embedTimeStamp(
                    Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile(),
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
  }
}
