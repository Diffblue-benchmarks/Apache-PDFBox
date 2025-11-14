package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
class ExportXFDFDiffblueTest {
  @InjectMocks private ExportXFDF exportXFDF;

  @Mock private File file;

  /**
   * Test {@link ExportXFDF#call()}.
   *
   * <p>Method under test: {@link ExportXFDF#call()}
   */
  @Test
  @DisplayName("Test call()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer ExportXFDF.call()"})
  void testCall() {
    // Arrange
    when(file.toPath()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), ""));

    // Act
    Integer actualCallResult = exportXFDF.call();

    // Assert
    verify(file).toPath();
    assertEquals(4, actualCallResult.intValue());
  }

  /**
   * Test {@link ExportXFDF#call()}.
   *
   * <ul>
   *   <li>Given {@link File} {@link File#toPath()} return Property is {@code java.io.tmpdir} is
   *       array of {@link String} with {@code test.txt}.
   * </ul>
   *
   * <p>Method under test: {@link ExportXFDF#call()}
   */
  @Test
  @DisplayName(
      "Test call(); given File toPath() return Property is 'java.io.tmpdir' is array of String with 'test.txt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer ExportXFDF.call()"})
  void testCall_givenFileToPathReturnPropertyIsJavaIoTmpdirIsArrayOfStringWithTestTxt() {
    // Arrange
    when(file.toPath()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

    // Act
    Integer actualCallResult = exportXFDF.call();

    // Assert
    verify(file).toPath();
    assertEquals(4, actualCallResult.intValue());
  }
}
