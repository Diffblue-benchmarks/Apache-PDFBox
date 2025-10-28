package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import javax.swing.JMenu;
import javax.swing.event.ChangeListener;
import org.junit.jupiter.api.Test;

class MenuBaseDiffblueTest {
  /**
   * Method under test: {@link MenuBase#getMenu()}
   */
  @Test
  void testGetMenu() {
    // Arrange
    JMenu menu = new JMenu("foo");
    menu.addChangeListener(mock(ChangeListener.class));
    ImageTypeMenu instance = ImageTypeMenu.getInstance();
    instance.setMenu(menu);

    // Act and Assert
    assertSame(menu, instance.getMenu());
  }
}
