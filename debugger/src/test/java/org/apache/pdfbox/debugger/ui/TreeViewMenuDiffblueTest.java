package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import javax.swing.JMenu;
import javax.swing.event.ChangeListener;
import org.junit.jupiter.api.Test;

class TreeViewMenuDiffblueTest {
  /**
   * Method under test: {@link TreeViewMenu#getInstance()}
   */
  @Test
  void testGetInstance() {
    // Arrange, Act and Assert
    assertEquals(TreeViewMenu.VIEW_PAGES, TreeViewMenu.getInstance().getTreeViewSelection());
  }

  /**
   * Method under test: {@link TreeViewMenu#setTreeViewSelection(String)}
   */
  @Test
  void testSetTreeViewSelection() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TreeViewMenu.getInstance().setTreeViewSelection("Selection"));
  }

  /**
   * Method under test: {@link TreeViewMenu#setTreeViewSelection(String)}
   */
  @Test
  void testSetTreeViewSelection2() {
    // Arrange
    TreeViewMenu instance = TreeViewMenu.getInstance();

    // Act
    instance.setTreeViewSelection(TreeViewMenu.VIEW_PAGES);

    // Assert that nothing has changed
    assertEquals(TreeViewMenu.VIEW_PAGES, instance.getTreeViewSelection());
  }

  /**
   * Method under test: {@link TreeViewMenu#setTreeViewSelection(String)}
   */
  @Test
  void testSetTreeViewSelection3() {
    // Arrange
    TreeViewMenu instance = TreeViewMenu.getInstance();

    // Act
    instance.setTreeViewSelection(TreeViewMenu.VIEW_STRUCTURE);

    // Assert that nothing has changed
    assertEquals(TreeViewMenu.VIEW_STRUCTURE, instance.getTreeViewSelection());
  }

  /**
   * Method under test: {@link TreeViewMenu#setTreeViewSelection(String)}
   */
  @Test
  void testSetTreeViewSelection4() {
    // Arrange
    TreeViewMenu instance = TreeViewMenu.getInstance();

    // Act
    instance.setTreeViewSelection(TreeViewMenu.VIEW_CROSS_REF_TABLE);

    // Assert that nothing has changed
    assertEquals(TreeViewMenu.VIEW_CROSS_REF_TABLE, instance.getTreeViewSelection());
  }

  /**
   * Method under test: {@link TreeViewMenu#setTreeViewSelection(String)}
   */
  @Test
  void testSetTreeViewSelection5() {
    // Arrange
    JMenu menu = new JMenu("foo");
    menu.addChangeListener(mock(ChangeListener.class));
    TreeViewMenu instance = TreeViewMenu.getInstance();
    instance.setMenu(menu);

    // Act
    instance.setTreeViewSelection(TreeViewMenu.VIEW_PAGES);

    // Assert that nothing has changed
    assertEquals(TreeViewMenu.VIEW_PAGES, instance.getTreeViewSelection());
  }

  /**
   * Method under test: {@link TreeViewMenu#getTreeViewSelection()}
   */
  @Test
  void testGetTreeViewSelection() {
    // Arrange, Act and Assert
    assertEquals(TreeViewMenu.VIEW_PAGES, TreeViewMenu.getInstance().getTreeViewSelection());
  }

  /**
   * Method under test: {@link TreeViewMenu#getTreeViewSelection()}
   */
  @Test
  void testGetTreeViewSelection2() {
    // Arrange
    JMenu menu = new JMenu(TreeViewMenu.VIEW_PAGES);
    menu.addChangeListener(mock(ChangeListener.class));
    TreeViewMenu instance = TreeViewMenu.getInstance();
    instance.setMenu(menu);

    // Act and Assert
    assertEquals(TreeViewMenu.VIEW_PAGES, instance.getTreeViewSelection());
  }

  /**
   * Method under test: {@link TreeViewMenu#isValidViewMode(String)}
   */
  @Test
  void testIsValidViewMode() {
    // Arrange, Act and Assert
    assertFalse(TreeViewMenu.isValidViewMode("View Mode"));
  }
}
