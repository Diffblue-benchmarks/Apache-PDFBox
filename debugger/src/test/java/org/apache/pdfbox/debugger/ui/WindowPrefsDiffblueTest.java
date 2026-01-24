package org.apache.pdfbox.debugger.ui;

import static org.mockito.Mockito.mockStatic;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.prefs.Preferences;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class WindowPrefsDiffblueTest {
  /**
   * Test {@link WindowPrefs#WindowPrefs(Class)}.
   *
   * <ul>
   *   <li>Then calls {@link Preferences#userNodeForPackage(Class)}.
   * </ul>
   *
   * <p>Method under test: {@link WindowPrefs#WindowPrefs(Class)}
   */
  @Test
  @DisplayName("Test new WindowPrefs(Class); then calls userNodeForPackage(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WindowPrefs.<init>(Class)"})
  void testNewWindowPrefs_thenCallsUserNodeForPackage() {
    // Arrange
    try (MockedStatic<Preferences> mockPreferences = mockStatic(Preferences.class)) {
      mockPreferences
          .when(() -> Preferences.userNodeForPackage(Mockito.<Class<?>>any()))
          .thenReturn(null);
      Class<Object> className = Object.class;

      // Act
      new WindowPrefs(className);

      // Assert
      mockPreferences.verify(() -> Preferences.userNodeForPackage(Mockito.<Class<?>>any()));
    }
  }
}
