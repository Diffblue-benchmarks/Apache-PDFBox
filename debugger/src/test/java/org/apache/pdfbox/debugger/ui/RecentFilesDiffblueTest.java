package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RecentFilesDiffblueTest {
  /**
   * Test {@link RecentFiles#removeAll()}.
   * <p>
   * Method under test: {@link RecentFiles#removeAll()}
   */
  @Test
  @DisplayName("Test removeAll()")
  void testRemoveAll() {
    // Arrange
    Class<Object> className = Object.class;
    RecentFiles recentFiles = new RecentFiles(className, 3);

    // Act
    recentFiles.removeAll();

    // Assert
    assertNull(recentFiles.getFiles());
    assertTrue(recentFiles.isEmpty());
  }

  /**
   * Test {@link RecentFiles#isEmpty()}.
   * <p>
   * Method under test: {@link RecentFiles#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty()")
  void testIsEmpty() {
    // Arrange
    Class<Object> className = Object.class;

    // Act and Assert
    assertFalse((new RecentFiles(className, 3)).isEmpty());
  }

  /**
   * Test {@link RecentFiles#addFile(String)}.
   * <ul>
   *   <li>Then not {@link RecentFiles#RecentFiles(Class, int)} with className is
   * {@link Object} and maximumFile is three Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RecentFiles#addFile(String)}
   */
  @Test
  @DisplayName("Test addFile(String); then not RecentFiles(Class, int) with className is Object and maximumFile is three Empty")
  void testAddFile_thenNotRecentFilesWithClassNameIsObjectAndMaximumFileIsThreeEmpty() {
    // Arrange
    Class<Object> className = Object.class;
    RecentFiles recentFiles = new RecentFiles(className, 3);

    // Act
    recentFiles.addFile("Path");

    // Assert
    assertFalse(recentFiles.isEmpty());
    assertTrue(recentFiles.getFiles().isEmpty());
  }

  /**
   * Test {@link RecentFiles#addFile(String)}.
   * <ul>
   *   <li>Then not {@link RecentFiles#RecentFiles(Class, int)} with className is
   * {@link Object} and maximumFile is zero Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RecentFiles#addFile(String)}
   */
  @Test
  @DisplayName("Test addFile(String); then not RecentFiles(Class, int) with className is Object and maximumFile is zero Empty")
  void testAddFile_thenNotRecentFilesWithClassNameIsObjectAndMaximumFileIsZeroEmpty() {
    // Arrange
    Class<Object> className = Object.class;

    RecentFiles recentFiles = new RecentFiles(className, 0);
    recentFiles.addFile("42");

    // Act
    recentFiles.addFile("Path");

    // Assert
    assertFalse(recentFiles.isEmpty());
    assertTrue(recentFiles.getFiles().isEmpty());
  }

  /**
   * Test {@link RecentFiles#getFiles()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RecentFiles#getFiles()}
   */
  @Test
  @DisplayName("Test getFiles(); then return Empty")
  void testGetFiles_thenReturnEmpty() {
    // Arrange
    Class<Object> className = Object.class;

    // Act and Assert
    assertTrue((new RecentFiles(className, 3)).getFiles().isEmpty());
  }
}
