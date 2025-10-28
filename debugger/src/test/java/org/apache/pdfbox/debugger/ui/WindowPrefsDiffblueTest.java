package org.apache.pdfbox.debugger.ui;

import static org.mockito.Mockito.mockStatic;
import java.util.prefs.Preferences;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class WindowPrefsDiffblueTest {
  /**
   * Method under test: {@link WindowPrefs#WindowPrefs(Class)}
   */
  @Test
  void testNewWindowPrefs() {
    try (MockedStatic<Preferences> mockPreferences = mockStatic(Preferences.class)) {
      // Arrange
      mockPreferences.when(() -> Preferences.userNodeForPackage(Mockito.<Class<Object>>any())).thenReturn(null);
      Class<Object> className = Object.class;

      // Act
      new WindowPrefs(className);

      // Assert
      mockPreferences.verify(() -> Preferences.userNodeForPackage(Mockito.<Class<Object>>any()));
    }
  }
}
