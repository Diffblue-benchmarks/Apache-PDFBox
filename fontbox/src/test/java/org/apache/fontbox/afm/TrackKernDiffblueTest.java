package org.apache.fontbox.afm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TrackKernDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TrackKern#TrackKern(int, float, float, float, float)}
   *   <li>{@link TrackKern#getDegree()}
   *   <li>{@link TrackKern#getMaxKern()}
   *   <li>{@link TrackKern#getMaxPointSize()}
   *   <li>{@link TrackKern#getMinKern()}
   *   <li>{@link TrackKern#getMinPointSize()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TrackKern.<init>(int, float, float, float, float)", "int TrackKern.getDegree()",
      "float TrackKern.getMaxKern()", "float TrackKern.getMaxPointSize()", "float TrackKern.getMinKern()",
      "float TrackKern.getMinPointSize()"})
  void testGettersAndSetters() {
    // Arrange and Act
    TrackKern actualTrackKern = new TrackKern(1, 10.0f, 10.0f, 10.0f, 10.0f);
    int actualDegree = actualTrackKern.getDegree();
    float actualMaxKern = actualTrackKern.getMaxKern();
    float actualMaxPointSize = actualTrackKern.getMaxPointSize();
    float actualMinKern = actualTrackKern.getMinKern();

    // Assert
    assertEquals(1, actualDegree);
    assertEquals(10.0f, actualMaxKern);
    assertEquals(10.0f, actualMaxPointSize);
    assertEquals(10.0f, actualMinKern);
    assertEquals(10.0f, actualTrackKern.getMinPointSize());
  }
}
