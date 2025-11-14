package org.apache.pdfbox.debugger.treestatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.swing.tree.TreePath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TreeStatusDiffblueTest {
  /**
   * Test {@link TreeStatus#getStringForPath(TreePath)}.
   *
   * <ul>
   *   <li>When {@link TreePath#TreePath(Object[])} with array of {@link Object} with {@code Path}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link TreeStatus#getStringForPath(TreePath)}
   */
  @Test
  @DisplayName(
      "Test getStringForPath(TreePath); when TreePath(Object[]) with array of Object with 'Path'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TreeStatus.getStringForPath(TreePath)"})
  void testGetStringForPath_whenTreePathWithArrayOfObjectWithPath_thenReturnEmptyString() {
    // Arrange
    TreeStatus treeStatus = new TreeStatus("Root Node");
    Object[] objectArray = new Object[] {"Path"};
    TreePath path = new TreePath(objectArray);

    // Act
    String actualStringForPath = treeStatus.getStringForPath(path);

    // Assert
    assertEquals("", actualStringForPath);
  }
}
