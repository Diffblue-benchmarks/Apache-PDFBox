package org.apache.fontbox.afm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TrackKernDiffblueTest {
  /**
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
