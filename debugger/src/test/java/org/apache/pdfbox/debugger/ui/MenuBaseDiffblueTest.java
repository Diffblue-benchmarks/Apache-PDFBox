package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.DefaultEditorKit.BeepAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MenuBaseDiffblueTest {
  /**
   * Test {@link MenuBase#addMenuListeners(ActionListener)}.
   *
   * <ul>
   *   <li>Given {@link JMenu#JMenu()} add {@link BeepAction} (default constructor).
   *   <li>Then second element {@link JMenuItem}.
   * </ul>
   *
   * <p>Method under test: {@link MenuBase#addMenuListeners(ActionListener)}
   */
  @Test
  @DisplayName(
      "Test addMenuListeners(ActionListener); given JMenu() add BeepAction (default constructor); then second element JMenuItem")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MenuBase.addMenuListeners(ActionListener)"})
  void testAddMenuListeners_givenJMenuAddBeepAction_thenSecondElementJMenuItem() {
    // Arrange
    JMenu menu = new JMenu();
    menu.add(new BeepAction());
    menu.add(new JMenuItem());

    ImageTypeMenu instance = ImageTypeMenu.getInstance();
    instance.setMenu(menu);

    // Act
    instance.addMenuListeners(mock(ActionListener.class));

    // Assert
    JMenu menu2 = instance.getMenu();
    Component[] menuComponents = menu2.getMenuComponents();
    Component component = menuComponents[1];
    assertTrue(component instanceof JMenuItem);
    assertEquals(1, ((JMenuItem) component).getActionListeners().length);
    Dimension preferredSize = menu2.getPopupMenu().getPreferredSize();
    assertEquals(19, preferredSize.width);
    assertEquals(19.0d, preferredSize.getWidth());
    assertEquals(2, menuComponents.length);
    assertEquals(31, preferredSize.height);
    assertEquals(31.0d, preferredSize.getHeight());
  }

  /**
   * Test {@link MenuBase#addMenuListeners(ActionListener)}.
   *
   * <ul>
   *   <li>Given {@link JMenu#JMenu()} add {@link JMenuItem#JMenuItem()}.
   *   <li>Then first element {@link JMenuItem}.
   * </ul>
   *
   * <p>Method under test: {@link MenuBase#addMenuListeners(ActionListener)}
   */
  @Test
  @DisplayName(
      "Test addMenuListeners(ActionListener); given JMenu() add JMenuItem(); then first element JMenuItem")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MenuBase.addMenuListeners(ActionListener)"})
  void testAddMenuListeners_givenJMenuAddJMenuItem_thenFirstElementJMenuItem() {
    // Arrange
    JMenu menu = new JMenu();
    menu.add(new JMenuItem());

    ImageTypeMenu instance = ImageTypeMenu.getInstance();
    instance.setMenu(menu);
    ActionListener actionListener = mock(ActionListener.class);

    // Act
    instance.addMenuListeners(actionListener);

    // Assert
    JMenu menu2 = instance.getMenu();
    Component[] menuComponents = menu2.getMenuComponents();
    Component component = menuComponents[0];
    assertTrue(component instanceof JMenuItem);
    ActionListener[] actionListeners = ((JMenuItem) component).getActionListeners();
    assertEquals(1, actionListeners.length);
    assertEquals(1, menuComponents.length);
    Dimension preferredSize = menu2.getPopupMenu().getPreferredSize();
    assertEquals(18, preferredSize.height);
    assertEquals(18.0d, preferredSize.getHeight());
    assertEquals(19, preferredSize.width);
    assertEquals(19.0d, preferredSize.getWidth());
    assertSame(actionListener, actionListeners[0]);
  }

  /**
   * Test {@link MenuBase#addMenuListeners(ActionListener)}.
   *
   * <ul>
   *   <li>Then Instance Menu PopupMenu PreferredSize {@link Dimension#height} is zero.
   * </ul>
   *
   * <p>Method under test: {@link MenuBase#addMenuListeners(ActionListener)}
   */
  @Test
  @DisplayName(
      "Test addMenuListeners(ActionListener); then Instance Menu PopupMenu PreferredSize height is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MenuBase.addMenuListeners(ActionListener)"})
  void testAddMenuListeners_thenInstanceMenuPopupMenuPreferredSizeHeightIsZero() {
    // Arrange
    ImageTypeMenu instance = ImageTypeMenu.getInstance();
    instance.setMenu(new JMenu());

    // Act
    instance.addMenuListeners(mock(ActionListener.class));

    // Assert that nothing has changed
    Dimension preferredSize = instance.getMenu().getPopupMenu().getPreferredSize();
    assertEquals(0, preferredSize.height);
    assertEquals(0, preferredSize.width);
    assertEquals(0.0d, preferredSize.getHeight());
    assertEquals(0.0d, preferredSize.getWidth());
  }
}
