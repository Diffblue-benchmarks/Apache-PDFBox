package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
class DecompressObjectstreamsDiffblueTest {
  @InjectMocks private DecompressObjectstreams decompressObjectstreams;

  @Mock private File file;

  /**
   * Test new {@link DecompressObjectstreams} (default constructor).
   *
   * <ul>
   *   <li>Then return not {@link DecompressObjectstreams#usageHelpRequested}.
   * </ul>
   *
   * <p>Method under test: default or parameterless constructor of {@link DecompressObjectstreams}
   */
  @Test
  @DisplayName(
      "Test new DecompressObjectstreams (default constructor); then return not usageHelpRequested")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DecompressObjectstreams.<init>()"})
  void testNewDecompressObjectstreams_thenReturnNotUsageHelpRequested() {
    // Arrange, Act and Assert
    assertFalse(new DecompressObjectstreams().usageHelpRequested);
  }

  /**
   * Test {@link DecompressObjectstreams#call()}.
   *
   * <p>Method under test: {@link DecompressObjectstreams#call()}
   */
  @Test
  @DisplayName("Test call()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer DecompressObjectstreams.call()"})
  void testCall() {
    // Arrange
    when(file.toPath()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), ""));

    // Act
    Integer actualCallResult = decompressObjectstreams.call();

    // Assert
    verify(file).toPath();
    assertEquals(4, actualCallResult.intValue());
  }

  /**
   * Test {@link DecompressObjectstreams#call()}.
   *
   * <ul>
   *   <li>Given {@link File} {@link File#toPath()} return Property is {@code java.io.tmpdir} is
   *       array of {@link String} with {@code test.txt}.
   * </ul>
   *
   * <p>Method under test: {@link DecompressObjectstreams#call()}
   */
  @Test
  @DisplayName(
      "Test call(); given File toPath() return Property is 'java.io.tmpdir' is array of String with 'test.txt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer DecompressObjectstreams.call()"})
  void testCall_givenFileToPathReturnPropertyIsJavaIoTmpdirIsArrayOfStringWithTestTxt() {
    // Arrange
    when(file.toPath()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

    // Act
    Integer actualCallResult = decompressObjectstreams.call();

    // Assert
    verify(file).toPath();
    assertEquals(4, actualCallResult.intValue());
  }
}
