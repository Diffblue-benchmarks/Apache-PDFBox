package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TreeViewMenuDiffblueTest {
  /**
   * Test {@link TreeViewMenu#setTreeViewSelection(String)}.
   *
   * <ul>
   *   <li>Then Instance TreeViewSelection is {@link TreeViewMenu#VIEW_CROSS_REF_TABLE}.
   * </ul>
   *
   * <p>Method under test: {@link TreeViewMenu#setTreeViewSelection(String)}
   */
  @Test
  @DisplayName(
      "Test setTreeViewSelection(String); then Instance TreeViewSelection is VIEW_CROSS_REF_TABLE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TreeViewMenu.setTreeViewSelection(String)"})
  void testSetTreeViewSelection_thenInstanceTreeViewSelectionIsView_cross_ref_table() {
    // Arrange
    TreeViewMenu instance = TreeViewMenu.getInstance();

    // Act
    instance.setTreeViewSelection(TreeViewMenu.VIEW_CROSS_REF_TABLE);

    // Assert
    assertEquals(TreeViewMenu.VIEW_CROSS_REF_TABLE, instance.getTreeViewSelection());
  }

  /**
   * Test {@link TreeViewMenu#setTreeViewSelection(String)}.
   *
   * <ul>
   *   <li>Then Instance TreeViewSelection is {@link TreeViewMenu#VIEW_PAGES}.
   * </ul>
   *
   * <p>Method under test: {@link TreeViewMenu#setTreeViewSelection(String)}
   */
  @Test
  @DisplayName("Test setTreeViewSelection(String); then Instance TreeViewSelection is VIEW_PAGES")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TreeViewMenu.setTreeViewSelection(String)"})
  void testSetTreeViewSelection_thenInstanceTreeViewSelectionIsView_pages() {
    // Arrange
    TreeViewMenu instance = TreeViewMenu.getInstance();

    // Act
    instance.setTreeViewSelection(TreeViewMenu.VIEW_PAGES);

    // Assert
    assertEquals(TreeViewMenu.VIEW_PAGES, instance.getTreeViewSelection());
  }

  /**
   * Test {@link TreeViewMenu#setTreeViewSelection(String)}.
   *
   * <ul>
   *   <li>Then Instance TreeViewSelection is {@link TreeViewMenu#VIEW_STRUCTURE}.
   * </ul>
   *
   * <p>Method under test: {@link TreeViewMenu#setTreeViewSelection(String)}
   */
  @Test
  @DisplayName(
      "Test setTreeViewSelection(String); then Instance TreeViewSelection is VIEW_STRUCTURE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TreeViewMenu.setTreeViewSelection(String)"})
  void testSetTreeViewSelection_thenInstanceTreeViewSelectionIsView_structure() {
    // Arrange
    TreeViewMenu instance = TreeViewMenu.getInstance();

    // Act
    instance.setTreeViewSelection(TreeViewMenu.VIEW_STRUCTURE);

    // Assert
    assertEquals(TreeViewMenu.VIEW_STRUCTURE, instance.getTreeViewSelection());
  }

  /**
   * Test {@link TreeViewMenu#setTreeViewSelection(String)}.
   *
   * <ul>
   *   <li>When {@code Selection}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TreeViewMenu#setTreeViewSelection(String)}
   */
  @Test
  @DisplayName(
      "Test setTreeViewSelection(String); when 'Selection'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TreeViewMenu.setTreeViewSelection(String)"})
  void testSetTreeViewSelection_whenSelection_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> TreeViewMenu.getInstance().setTreeViewSelection("Selection"));
  }

  /**
   * Test {@link TreeViewMenu#isValidViewMode(String)}.
   *
   * <p>Method under test: {@link TreeViewMenu#isValidViewMode(String)}
   */
  @Test
  @DisplayName("Test isValidViewMode(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TreeViewMenu.isValidViewMode(String)"})
  void testIsValidViewMode() {
    // Arrange, Act and Assert
    assertFalse(TreeViewMenu.isValidViewMode("View Mode"));
  }
}
