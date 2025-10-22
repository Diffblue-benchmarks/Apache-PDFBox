package org.apache.pdfbox.examples.ant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Paths;
import org.apache.tools.ant.DirectoryScanner;
import org.apache.tools.ant.Location;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.RuntimeConfigurable;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.types.AbstractFileSet;
import org.apache.tools.ant.types.FileSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class PDFToTextTaskDiffblueTest {
  /**
   * Test {@link PDFToTextTask#execute()}.
   * <p>
   * Method under test: {@link PDFToTextTask#execute()}
   */
  @Test
  @DisplayName("Test execute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFToTextTask.execute()"})
  void testExecute() {
    // Arrange
    DirectoryScanner directoryScanner = new DirectoryScanner();
    directoryScanner.addExcludes(new String[]{"PDFToTextTask executing"});
    FileSet set = mock(FileSet.class);
    when(set.getDirectoryScanner(Mockito.<Project>any())).thenReturn(directoryScanner);

    PDFToTextTask pdfToTextTask = new PDFToTextTask();
    pdfToTextTask.addFileset(set);

    // Act
    pdfToTextTask.execute();

    // Assert
    verify(set).getDirectoryScanner(isNull());
  }

  /**
   * Test {@link PDFToTextTask#execute()}.
   * <p>
   * Method under test: {@link PDFToTextTask#execute()}
   */
  @Test
  @DisplayName("Test execute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFToTextTask.execute()"})
  void testExecute2() throws IllegalStateException {
    // Arrange
    DirectoryScanner directoryScanner = mock(DirectoryScanner.class);
    when(directoryScanner.getBasedir())
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    when(directoryScanner.getIncludedFiles()).thenReturn(new String[]{"Included Files"});
    doNothing().when(directoryScanner).scan();
    FileSet set = mock(FileSet.class);
    when(set.getDirectoryScanner(Mockito.<Project>any())).thenReturn(directoryScanner);

    PDFToTextTask pdfToTextTask = new PDFToTextTask();
    pdfToTextTask.addFileset(set);

    // Act
    pdfToTextTask.execute();

    // Assert
    verify(directoryScanner).getBasedir();
    verify(directoryScanner).getIncludedFiles();
    verify(directoryScanner).scan();
    verify(set).getDirectoryScanner(isNull());
  }

  /**
   * Test {@link PDFToTextTask#execute()}.
   * <p>
   * Method under test: {@link PDFToTextTask#execute()}
   */
  @Test
  @DisplayName("Test execute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFToTextTask.execute()"})
  void testExecute3() throws IllegalStateException {
    // Arrange
    DirectoryScanner directoryScanner = mock(DirectoryScanner.class);
    when(directoryScanner.getBasedir())
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    when(directoryScanner.getIncludedFiles()).thenReturn(new String[]{"Included Files"});
    doNothing().when(directoryScanner).scan();
    FileSet set = mock(FileSet.class);
    when(set.getDirectoryScanner(Mockito.<Project>any())).thenReturn(directoryScanner);

    PDFToTextTask pdfToTextTask = new PDFToTextTask();
    pdfToTextTask.setProject(new Project());
    pdfToTextTask.addFileset(set);

    // Act
    pdfToTextTask.execute();

    // Assert
    verify(directoryScanner).getBasedir();
    verify(directoryScanner).getIncludedFiles();
    verify(directoryScanner).scan();
    verify(set).getDirectoryScanner(isA(Project.class));
  }

  /**
   * Test {@link PDFToTextTask#execute()}.
   * <ul>
   *   <li>Given {@link FileSet} {@link AbstractFileSet#getDirectoryScanner(Project)} return {@link DirectoryScanner} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFToTextTask#execute()}
   */
  @Test
  @DisplayName("Test execute(); given FileSet getDirectoryScanner(Project) return DirectoryScanner (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFToTextTask.execute()"})
  void testExecute_givenFileSetGetDirectoryScannerReturnDirectoryScanner() {
    // Arrange
    FileSet set = mock(FileSet.class);
    when(set.getDirectoryScanner(Mockito.<Project>any())).thenReturn(new DirectoryScanner());

    PDFToTextTask pdfToTextTask = new PDFToTextTask();
    pdfToTextTask.addFileset(set);

    // Act
    pdfToTextTask.execute();

    // Assert
    verify(set).getDirectoryScanner(isNull());
  }

  /**
   * Test {@link PDFToTextTask#execute()}.
   * <ul>
   *   <li>Given {@link Project} {@link Project#log(Task, String, int)} does nothing.</li>
   *   <li>Then calls {@link Project#log(Task, String, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFToTextTask#execute()}
   */
  @Test
  @DisplayName("Test execute(); given Project log(Task, String, int) does nothing; then calls log(Task, String, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFToTextTask.execute()"})
  void testExecute_givenProjectLogDoesNothing_thenCallsLog() throws IllegalStateException {
    try (MockedStatic<Runtime> mockRuntime = mockStatic(Runtime.class)) {

      // Arrange
      Runtime runtime = mock(Runtime.class);
      doNothing().when(runtime).exit(anyInt());
      mockRuntime.when(Runtime::getRuntime).thenReturn(runtime);
      DirectoryScanner directoryScanner = mock(DirectoryScanner.class);
      when(directoryScanner.getBasedir())
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
      when(directoryScanner.getIncludedFiles()).thenReturn(new String[]{".PDF"});
      doNothing().when(directoryScanner).scan();
      FileSet set = mock(FileSet.class);
      when(set.getDirectoryScanner(Mockito.<Project>any())).thenReturn(directoryScanner);
      Project project = mock(Project.class);
      doNothing().when(project).log(Mockito.<Task>any(), Mockito.<String>any(), anyInt());

      PDFToTextTask pdfToTextTask = new PDFToTextTask();
      pdfToTextTask.setProject(project);
      pdfToTextTask.addFileset(set);

      // Act
      pdfToTextTask.execute();

      // Assert
      verify(runtime).exit(eq(2));
      mockRuntime.verify(Runtime::getRuntime);
      verify(directoryScanner).getBasedir();
      verify(directoryScanner).getIncludedFiles();
      verify(directoryScanner).scan();
      verify(project, atLeast(1)).log(isA(Task.class), Mockito.<String>any(), eq(2));
      verify(set).getDirectoryScanner(isA(Project.class));
    }
  }

  /**
   * Test {@link PDFToTextTask#execute()}.
   * <ul>
   *   <li>Given {@link Runtime} {@link Runtime#exit(int)} does nothing.</li>
   *   <li>Then calls {@link Runtime#exit(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFToTextTask#execute()}
   */
  @Test
  @DisplayName("Test execute(); given Runtime exit(int) does nothing; then calls exit(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFToTextTask.execute()"})
  void testExecute_givenRuntimeExitDoesNothing_thenCallsExit() throws IllegalStateException {
    try (MockedStatic<Runtime> mockRuntime = mockStatic(Runtime.class)) {

      // Arrange
      Runtime runtime = mock(Runtime.class);
      doNothing().when(runtime).exit(anyInt());
      mockRuntime.when(Runtime::getRuntime).thenReturn(runtime);
      DirectoryScanner directoryScanner = mock(DirectoryScanner.class);
      when(directoryScanner.getBasedir())
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
      when(directoryScanner.getIncludedFiles()).thenReturn(new String[]{".PDF"});
      doNothing().when(directoryScanner).scan();
      FileSet set = mock(FileSet.class);
      when(set.getDirectoryScanner(Mockito.<Project>any())).thenReturn(directoryScanner);

      PDFToTextTask pdfToTextTask = new PDFToTextTask();
      pdfToTextTask.addFileset(set);

      // Act
      pdfToTextTask.execute();

      // Assert
      verify(runtime).exit(eq(2));
      mockRuntime.verify(Runtime::getRuntime);
      verify(directoryScanner).getBasedir();
      verify(directoryScanner).getIncludedFiles();
      verify(directoryScanner).scan();
      verify(set).getDirectoryScanner(isNull());
    }
  }

  /**
   * Test new {@link PDFToTextTask} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link PDFToTextTask}
   */
  @Test
  @DisplayName("Test new PDFToTextTask (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFToTextTask.<init>()"})
  void testNewPDFToTextTask() {
    // Arrange and Act
    PDFToTextTask actualPdfToTextTask = new PDFToTextTask();

    // Assert
    Location location = actualPdfToTextTask.getLocation();
    assertNull(location.getFileName());
    assertNull(actualPdfToTextTask.getDescription());
    RuntimeConfigurable runtimeConfigurableWrapper = actualPdfToTextTask.getRuntimeConfigurableWrapper();
    assertNull(runtimeConfigurableWrapper.getElementTag());
    assertNull(runtimeConfigurableWrapper.getId());
    assertNull(runtimeConfigurableWrapper.getPolyType());
    assertNull(actualPdfToTextTask.getTaskName());
    assertNull(actualPdfToTextTask.getTaskType());
    assertNull(actualPdfToTextTask.getProject());
    assertNull(actualPdfToTextTask.getOwningTarget());
    assertNull(runtimeConfigurableWrapper.getAttributes());
    assertEquals(0, location.getColumnNumber());
    assertEquals(0, location.getLineNumber());
    assertTrue(runtimeConfigurableWrapper.getAttributeMap().isEmpty());
    assertSame(actualPdfToTextTask, runtimeConfigurableWrapper.getProxy());
  }
}
