package org.apache.fontbox.afm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.fontbox.util.BoundingBox;
import org.junit.jupiter.api.Test;

class CharMetricDiffblueTest {
  /**
   * Method under test: {@link CharMetric#addLigature(Ligature)}
   */
  @Test
  void testAddLigature() {
    // Arrange
    CharMetric charMetric = new CharMetric();
    Ligature ligature = new Ligature("Successor", "Ligature");

    // Act
    charMetric.addLigature(ligature);

    // Assert
    List<Ligature> ligatures = charMetric.getLigatures();
    assertEquals(1, ligatures.size());
    assertSame(ligature, ligatures.get(0));
  }

  /**
   * Method under test: {@link CharMetric#getLigatures()}
   */
  @Test
  void testGetLigatures() {
    // Arrange, Act and Assert
    assertTrue((new CharMetric()).getLigatures().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CharMetric}
   *   <li>{@link CharMetric#setBoundingBox(BoundingBox)}
   *   <li>{@link CharMetric#setCharacterCode(int)}
   *   <li>{@link CharMetric#setName(String)}
   *   <li>{@link CharMetric#setVv(float[])}
   *   <li>{@link CharMetric#setW0(float[])}
   *   <li>{@link CharMetric#setW0x(float)}
   *   <li>{@link CharMetric#setW0y(float)}
   *   <li>{@link CharMetric#setW1(float[])}
   *   <li>{@link CharMetric#setW1x(float)}
   *   <li>{@link CharMetric#setW1y(float)}
   *   <li>{@link CharMetric#setW(float[])}
   *   <li>{@link CharMetric#setWx(float)}
   *   <li>{@link CharMetric#setWy(float)}
   *   <li>{@link CharMetric#getBoundingBox()}
   *   <li>{@link CharMetric#getCharacterCode()}
   *   <li>{@link CharMetric#getName()}
   *   <li>{@link CharMetric#getVv()}
   *   <li>{@link CharMetric#getW()}
   *   <li>{@link CharMetric#getW0()}
   *   <li>{@link CharMetric#getW0x()}
   *   <li>{@link CharMetric#getW0y()}
   *   <li>{@link CharMetric#getW1()}
   *   <li>{@link CharMetric#getW1x()}
   *   <li>{@link CharMetric#getW1y()}
   *   <li>{@link CharMetric#getWx()}
   *   <li>{@link CharMetric#getWy()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    CharMetric actualCharMetric = new CharMetric();
    BoundingBox bBox = new BoundingBox(10.0f, 10.0f, 10.0f, 10.0f);

    actualCharMetric.setBoundingBox(bBox);
    actualCharMetric.setCharacterCode(1);
    actualCharMetric.setName("foo");
    float[] vvValue = new float[]{10.0f, 0.5f, 10.0f, 0.5f};
    actualCharMetric.setVv(vvValue);
    float[] w0Value = new float[]{10.0f, 0.5f, 10.0f, 0.5f};
    actualCharMetric.setW0(w0Value);
    actualCharMetric.setW0x(10.0f);
    actualCharMetric.setW0y(10.0f);
    float[] w1Value = new float[]{10.0f, 0.5f, 10.0f, 0.5f};
    actualCharMetric.setW1(w1Value);
    actualCharMetric.setW1x(10.0f);
    actualCharMetric.setW1y(10.0f);
    float[] wValue = new float[]{10.0f, 0.5f, 10.0f, 0.5f};
    actualCharMetric.setW(wValue);
    actualCharMetric.setWx(10.0f);
    actualCharMetric.setWy(10.0f);
    BoundingBox actualBoundingBox = actualCharMetric.getBoundingBox();
    int actualCharacterCode = actualCharMetric.getCharacterCode();
    String actualName = actualCharMetric.getName();
    float[] actualVv = actualCharMetric.getVv();
    float[] actualW = actualCharMetric.getW();
    float[] actualW0 = actualCharMetric.getW0();
    float actualW0x = actualCharMetric.getW0x();
    float actualW0y = actualCharMetric.getW0y();
    float[] actualW1 = actualCharMetric.getW1();
    float actualW1x = actualCharMetric.getW1x();
    float actualW1y = actualCharMetric.getW1y();
    float actualWx = actualCharMetric.getWx();

    // Assert that nothing has changed
    assertEquals("foo", actualName);
    assertEquals(1, actualCharacterCode);
    assertEquals(10.0f, actualW0x);
    assertEquals(10.0f, actualW0y);
    assertEquals(10.0f, actualW1x);
    assertEquals(10.0f, actualW1y);
    assertEquals(10.0f, actualWx);
    assertEquals(10.0f, actualCharMetric.getWy());
    assertSame(bBox, actualBoundingBox);
    assertSame(vvValue, actualVv);
    assertSame(wValue, actualW);
    assertSame(w0Value, actualW0);
    assertSame(w1Value, actualW1);
  }
}
