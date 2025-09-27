package org.apache.pdfbox.examples.ant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.nio.file.Paths;
import org.apache.tools.ant.AntClassLoader;
import org.apache.tools.ant.BuildListener;
import org.apache.tools.ant.DirectoryScanner;
import org.apache.tools.ant.Location;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.RuntimeConfigurable;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.types.FileSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class PDFToTextTaskDiffblueTest {
  /**
   * Test {@link PDFToTextTask#execute()}.
   *
   * <p>Method under test: {@link PDFToTextTask#execute()}
   */
  @Test
  @DisplayName("Test execute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFToTextTask.execute()"})
  void testExecute() {
    // Arrange
    DirectoryScanner directoryScanner = new DirectoryScanner();
    directoryScanner.addExcludes(new String[] {"PDFToTextTask executing"});

    FileSet set = mock(FileSet.class);
    when(set.getDirectoryScanner(Mockito.<Project>any())).thenReturn(directoryScanner);
    doNothing().when(set).setFile(Mockito.<File>any());
    set.setFile(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    Project project = mock(Project.class);
    doNothing().when(project).addBuildListener(Mockito.<BuildListener>any());
    doNothing().when(project).log(Mockito.<Task>any(), Mockito.<String>any(), anyInt());
    project.addBuildListener(new AntClassLoader());

    PDFToTextTask pdfToTextTask = new PDFToTextTask();
    pdfToTextTask.setProject(project);
    pdfToTextTask.addFileset(set);

    // Act
    pdfToTextTask.execute();

    // Assert
    verify(project).addBuildListener(isA(BuildListener.class));
    verify(project).log(isA(Task.class), eq("PDFToTextTask executing"), eq(2));
    verify(set).getDirectoryScanner(isA(Project.class));
    verify(set).setFile(isA(File.class));
  }

  /**
   * Test {@link PDFToTextTask#execute()}.
   *
   * <p>Method under test: {@link PDFToTextTask#execute()}
   */
  @Test
  @DisplayName("Test execute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFToTextTask.execute()"})
  void testExecute2() {
    // Arrange
    DirectoryScanner directoryScanner = new DirectoryScanner();
    directoryScanner.setIncludes(new String[] {"PDFToTextTask executing"});
    directoryScanner.addExcludes(new String[] {"PDFToTextTask executing"});

    FileSet set = mock(FileSet.class);
    when(set.getDirectoryScanner(Mockito.<Project>any())).thenReturn(directoryScanner);
    doNothing().when(set).setFile(Mockito.<File>any());
    set.setFile(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    Project project = mock(Project.class);
    doNothing().when(project).addBuildListener(Mockito.<BuildListener>any());
    doNothing().when(project).log(Mockito.<Task>any(), Mockito.<String>any(), anyInt());
    project.addBuildListener(new AntClassLoader());

    PDFToTextTask pdfToTextTask = new PDFToTextTask();
    pdfToTextTask.setProject(project);
    pdfToTextTask.addFileset(set);

    // Act
    pdfToTextTask.execute();

    // Assert
    verify(project).addBuildListener(isA(BuildListener.class));
    verify(project).log(isA(Task.class), eq("PDFToTextTask executing"), eq(2));
    verify(set).getDirectoryScanner(isA(Project.class));
    verify(set).setFile(isA(File.class));
  }

  /**
   * Test {@link PDFToTextTask#execute()}.
   *
   * <p>Method under test: {@link PDFToTextTask#execute()}
   */
  @Test
  @DisplayName("Test execute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFToTextTask.execute()"})
  void testExecute3() throws IllegalStateException {
    // Arrange
    DirectoryScanner directoryScanner = mock(DirectoryScanner.class);
    when(directoryScanner.getBasedir())
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    when(directoryScanner.getIncludedFiles()).thenReturn(new String[] {"Included Files"});
    doNothing().when(directoryScanner).addExcludes(Mockito.<String[]>any());
    doNothing().when(directoryScanner).scan();
    directoryScanner.addExcludes(new String[] {"PDFToTextTask executing"});

    FileSet set = mock(FileSet.class);
    when(set.getDirectoryScanner(Mockito.<Project>any())).thenReturn(directoryScanner);
    doNothing().when(set).setFile(Mockito.<File>any());
    set.setFile(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    Project project = mock(Project.class);
    doNothing().when(project).addBuildListener(Mockito.<BuildListener>any());
    doNothing().when(project).log(Mockito.<Task>any(), Mockito.<String>any(), anyInt());
    project.addBuildListener(new AntClassLoader());

    PDFToTextTask pdfToTextTask = new PDFToTextTask();
    pdfToTextTask.setProject(project);
    pdfToTextTask.addFileset(set);

    // Act
    pdfToTextTask.execute();

    // Assert
    verify(directoryScanner).addExcludes(isA(String[].class));
    verify(directoryScanner).getBasedir();
    verify(directoryScanner).getIncludedFiles();
    verify(directoryScanner).scan();
    verify(project).addBuildListener(isA(BuildListener.class));
    verify(project, atLeast(1)).log(isA(Task.class), Mockito.<String>any(), eq(2));
    verify(set).getDirectoryScanner(isA(Project.class));
    verify(set).setFile(isA(File.class));
  }

  /**
   * Test {@link PDFToTextTask#execute()}.
   *
   * <ul>
   *   <li>Given {@link FileSet} {@link FileSet#getDirectoryScanner(Project)} return {@link
   *       DirectoryScanner} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PDFToTextTask#execute()}
   */
  @Test
  @DisplayName(
      "Test execute(); given FileSet getDirectoryScanner(Project) return DirectoryScanner (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFToTextTask.execute()"})
  void testExecute_givenFileSetGetDirectoryScannerReturnDirectoryScanner() {
    // Arrange
    FileSet set = mock(FileSet.class);
    when(set.getDirectoryScanner(Mockito.<Project>any())).thenReturn(new DirectoryScanner());
    doNothing().when(set).setFile(Mockito.<File>any());
    set.setFile(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    Project project = mock(Project.class);
    doNothing().when(project).addBuildListener(Mockito.<BuildListener>any());
    doNothing().when(project).log(Mockito.<Task>any(), Mockito.<String>any(), anyInt());
    project.addBuildListener(new AntClassLoader());

    PDFToTextTask pdfToTextTask = new PDFToTextTask();
    pdfToTextTask.setProject(project);
    pdfToTextTask.addFileset(set);

    // Act
    pdfToTextTask.execute();

    // Assert
    verify(project).addBuildListener(isA(BuildListener.class));
    verify(project).log(isA(Task.class), eq("PDFToTextTask executing"), eq(2));
    verify(set).getDirectoryScanner(isA(Project.class));
    verify(set).setFile(isA(File.class));
  }

  /**
   * Test {@link PDFToTextTask#execute()}.
   *
   * <ul>
   *   <li>Given {@link Runtime} {@link Runtime#exit(int)} does nothing.
   *   <li>Then calls {@link Runtime#exit(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFToTextTask#execute()}
   */
  @Test
  @DisplayName("Test execute(); given Runtime exit(int) does nothing; then calls exit(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFToTextTask.execute()"})
  void testExecute_givenRuntimeExitDoesNothing_thenCallsExit() throws IllegalStateException {
    // Arrange
    try (MockedStatic<Runtime> mockRuntime = mockStatic(Runtime.class)) {

      Runtime runtime = mock(Runtime.class);
      doNothing().when(runtime).exit(anyInt());
      mockRuntime.when(Runtime::getRuntime).thenReturn(runtime);

      DirectoryScanner directoryScanner = mock(DirectoryScanner.class);
      when(directoryScanner.getBasedir())
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
      when(directoryScanner.getIncludedFiles())
          .thenReturn(new String[] {"PDFToTextTask executing", ".PDF"});
      doNothing().when(directoryScanner).addExcludes(Mockito.<String[]>any());
      doNothing().when(directoryScanner).scan();
      directoryScanner.addExcludes(new String[] {"PDFToTextTask executing"});

      FileSet set = mock(FileSet.class);
      when(set.getDirectoryScanner(Mockito.<Project>any())).thenReturn(directoryScanner);
      doNothing().when(set).setFile(Mockito.<File>any());
      set.setFile(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

      Project project = mock(Project.class);
      doNothing().when(project).addBuildListener(Mockito.<BuildListener>any());
      doNothing().when(project).log(Mockito.<Task>any(), Mockito.<String>any(), anyInt());
      project.addBuildListener(new AntClassLoader());

      PDFToTextTask pdfToTextTask = new PDFToTextTask();
      pdfToTextTask.setProject(project);
      pdfToTextTask.addFileset(set);

      // Act
      pdfToTextTask.execute();

      // Assert
      verify(runtime).exit(2);
      mockRuntime.verify(Runtime::getRuntime);
      verify(directoryScanner).addExcludes(isA(String[].class));
      verify(directoryScanner, atLeast(1)).getBasedir();
      verify(directoryScanner).getIncludedFiles();
      verify(directoryScanner).scan();
      verify(project).addBuildListener(isA(BuildListener.class));
      verify(project, atLeast(1)).log(isA(Task.class), Mockito.<String>any(), eq(2));
      verify(set).getDirectoryScanner(isA(Project.class));
      verify(set).setFile(isA(File.class));
    }
  }

  /**
   * Test new {@link PDFToTextTask} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link PDFToTextTask}
   */
  @Test
  @DisplayName("Test new PDFToTextTask (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFToTextTask.<init>()"})
  void testNewPDFToTextTask() {
    // Arrange and Act
    PDFToTextTask actualPdfToTextTask = new PDFToTextTask();

    // Assert
    Location location = actualPdfToTextTask.getLocation();
    assertNull(location.getFileName());
    assertNull(actualPdfToTextTask.getDescription());
    RuntimeConfigurable runtimeConfigurableWrapper =
        actualPdfToTextTask.getRuntimeConfigurableWrapper();
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
