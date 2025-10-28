package org.apache.fontbox.afm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.fontbox.util.BoundingBox;
import org.junit.jupiter.api.Test;

class FontMetricsDiffblueTest {
  /**
   * Method under test: {@link FontMetrics#getCharacterWidth(String)}
   */
  @Test
  void testGetCharacterWidth() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new FontMetrics()).getCharacterWidth("Name"));
  }

  /**
   * Method under test: {@link FontMetrics#getCharacterWidth(String)}
   */
  @Test
  void testGetCharacterWidth2() {
    // Arrange
    FontMetrics fontMetrics = new FontMetrics();
    fontMetrics.addCharMetric(new CharMetric());

    // Act and Assert
    assertEquals(0.0f, fontMetrics.getCharacterWidth(null));
  }

  /**
   * Method under test: {@link FontMetrics#getCharacterHeight(String)}
   */
  @Test
  void testGetCharacterHeight() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new FontMetrics()).getCharacterHeight("Name"));
  }

  /**
   * Method under test: {@link FontMetrics#getCharacterHeight(String)}
   */
  @Test
  void testGetCharacterHeight2() {
    // Arrange
    CharMetric metric = new CharMetric();
    metric.setBoundingBox(new BoundingBox(10.0f, 10.0f, 10.0f, 10.0f));

    FontMetrics fontMetrics = new FontMetrics();
    fontMetrics.addCharMetric(metric);

    // Act and Assert
    assertEquals(0.0f, fontMetrics.getCharacterHeight(null));
  }

  /**
   * Method under test: {@link FontMetrics#getCharacterHeight(String)}
   */
  @Test
  void testGetCharacterHeight3() {
    // Arrange
    CharMetric metric = new CharMetric();
    metric.setWy(10.0f);

    FontMetrics fontMetrics = new FontMetrics();
    fontMetrics.addCharMetric(metric);

    // Act and Assert
    assertEquals(10.0f, fontMetrics.getCharacterHeight(null));
  }

  /**
   * Method under test: {@link FontMetrics#getAverageCharacterWidth()}
   */
  @Test
  void testGetAverageCharacterWidth() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new FontMetrics()).getAverageCharacterWidth());
  }

  /**
   * Method under test: {@link FontMetrics#getAverageCharacterWidth()}
   */
  @Test
  void testGetAverageCharacterWidth2() {
    // Arrange
    FontMetrics fontMetrics = new FontMetrics();
    fontMetrics.addCharMetric(new CharMetric());

    // Act and Assert
    assertEquals(0.0f, fontMetrics.getAverageCharacterWidth());
  }

  /**
   * Method under test: {@link FontMetrics#getAverageCharacterWidth()}
   */
  @Test
  void testGetAverageCharacterWidth3() {
    // Arrange
    CharMetric metric = new CharMetric();
    metric.setWx(10.0f);

    FontMetrics fontMetrics = new FontMetrics();
    fontMetrics.addCharMetric(metric);

    // Act and Assert
    assertEquals(10.0f, fontMetrics.getAverageCharacterWidth());
  }

  /**
   * Method under test: {@link FontMetrics#addComment(String)}
   */
  @Test
  void testAddComment() {
    // Arrange
    FontMetrics fontMetrics = new FontMetrics();

    // Act
    fontMetrics.addComment(AFMParser.COMMENT);

    // Assert
    List<String> comments = fontMetrics.getComments();
    assertEquals(1, comments.size());
    assertEquals(AFMParser.COMMENT, comments.get(0));
  }

  /**
   * Method under test: {@link FontMetrics#getComments()}
   */
  @Test
  void testGetComments() {
    // Arrange, Act and Assert
    assertTrue((new FontMetrics()).getComments().isEmpty());
  }

  /**
   * Method under test: {@link FontMetrics#setMetricSets(int)}
   */
  @Test
  void testSetMetricSets() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new FontMetrics()).setMetricSets(42));
    assertThrows(IllegalArgumentException.class, () -> (new FontMetrics()).setMetricSets(-1));
  }

  /**
   * Method under test: {@link FontMetrics#getIsFixedV()}
   */
  @Test
  void testGetIsFixedV() {
    // Arrange, Act and Assert
    assertFalse((new FontMetrics()).getIsFixedV());
  }

  /**
   * Method under test: {@link FontMetrics#getIsFixedV()}
   */
  @Test
  void testGetIsFixedV2() {
    // Arrange
    FontMetrics fontMetrics = new FontMetrics();
    fontMetrics.setIsFixedV(true);
    fontMetrics.setVVector(null);

    // Act and Assert
    assertTrue(fontMetrics.getIsFixedV());
  }

  /**
   * Method under test: {@link FontMetrics#getIsFixedV()}
   */
  @Test
  void testGetIsFixedV3() {
    // Arrange
    FontMetrics fontMetrics = new FontMetrics();
    fontMetrics.setVVector(new float[]{10.0f, 0.0f, 10.0f, 0.0f});

    // Act and Assert
    assertTrue(fontMetrics.getIsFixedV());
  }

  /**
   * Method under test: {@link FontMetrics#setIsFixedV(boolean)}
   */
  @Test
  void testSetIsFixedV() {
    // Arrange
    FontMetrics fontMetrics = new FontMetrics();

    // Act
    fontMetrics.setIsFixedV(true);

    // Assert
    assertTrue(fontMetrics.getIsFixedV());
  }

  /**
   * Method under test: {@link FontMetrics#getCharMetrics()}
   */
  @Test
  void testGetCharMetrics() {
    // Arrange, Act and Assert
    assertTrue((new FontMetrics()).getCharMetrics().isEmpty());
  }

  /**
   * Method under test: {@link FontMetrics#addCharMetric(CharMetric)}
   */
  @Test
  void testAddCharMetric() {
    // Arrange
    FontMetrics fontMetrics = new FontMetrics();
    CharMetric metric = new CharMetric();

    // Act
    fontMetrics.addCharMetric(metric);

    // Assert
    List<CharMetric> charMetrics = fontMetrics.getCharMetrics();
    assertEquals(1, charMetrics.size());
    assertSame(metric, charMetrics.get(0));
  }

  /**
   * Method under test: {@link FontMetrics#getTrackKern()}
   */
  @Test
  void testGetTrackKern() {
    // Arrange, Act and Assert
    assertTrue((new FontMetrics()).getTrackKern().isEmpty());
  }

  /**
   * Method under test: {@link FontMetrics#addTrackKern(TrackKern)}
   */
  @Test
  void testAddTrackKern() {
    // Arrange
    FontMetrics fontMetrics = new FontMetrics();
    TrackKern kern = new TrackKern(1, 10.0f, 10.0f, 10.0f, 10.0f);

    // Act
    fontMetrics.addTrackKern(kern);

    // Assert
    List<TrackKern> trackKern = fontMetrics.getTrackKern();
    assertEquals(1, trackKern.size());
    assertSame(kern, trackKern.get(0));
  }

  /**
   * Method under test: {@link FontMetrics#getComposites()}
   */
  @Test
  void testGetComposites() {
    // Arrange, Act and Assert
    assertTrue((new FontMetrics()).getComposites().isEmpty());
  }

  /**
   * Method under test: {@link FontMetrics#addComposite(Composite)}
   */
  @Test
  void testAddComposite() {
    // Arrange
    FontMetrics fontMetrics = new FontMetrics();
    Composite composite = new Composite("Name");

    // Act
    fontMetrics.addComposite(composite);

    // Assert
    List<Composite> composites = fontMetrics.getComposites();
    assertEquals(1, composites.size());
    assertSame(composite, composites.get(0));
  }

  /**
   * Method under test: {@link FontMetrics#getKernPairs()}
   */
  @Test
  void testGetKernPairs() {
    // Arrange, Act and Assert
    assertTrue((new FontMetrics()).getKernPairs().isEmpty());
  }

  /**
   * Method under test: {@link FontMetrics#addKernPair(KernPair)}
   */
  @Test
  void testAddKernPair() {
    // Arrange
    FontMetrics fontMetrics = new FontMetrics();
    KernPair kernPair = new KernPair("First Kern Character", "Second Kern Character", 10.0f, 10.0f);

    // Act
    fontMetrics.addKernPair(kernPair);

    // Assert
    List<KernPair> kernPairs = fontMetrics.getKernPairs();
    assertEquals(1, kernPairs.size());
    assertSame(kernPair, kernPairs.get(0));
  }

  /**
   * Method under test: {@link FontMetrics#getKernPairs0()}
   */
  @Test
  void testGetKernPairs0() {
    // Arrange, Act and Assert
    assertTrue((new FontMetrics()).getKernPairs0().isEmpty());
  }

  /**
   * Method under test: {@link FontMetrics#addKernPair0(KernPair)}
   */
  @Test
  void testAddKernPair0() {
    // Arrange
    FontMetrics fontMetrics = new FontMetrics();
    KernPair kernPair = new KernPair("First Kern Character", "Second Kern Character", 10.0f, 10.0f);

    // Act
    fontMetrics.addKernPair0(kernPair);

    // Assert
    List<KernPair> kernPairs0 = fontMetrics.getKernPairs0();
    assertEquals(1, kernPairs0.size());
    assertSame(kernPair, kernPairs0.get(0));
  }

  /**
   * Method under test: {@link FontMetrics#getKernPairs1()}
   */
  @Test
  void testGetKernPairs1() {
    // Arrange, Act and Assert
    assertTrue((new FontMetrics()).getKernPairs1().isEmpty());
  }

  /**
   * Method under test: {@link FontMetrics#addKernPair1(KernPair)}
   */
  @Test
  void testAddKernPair1() {
    // Arrange
    FontMetrics fontMetrics = new FontMetrics();
    KernPair kernPair = new KernPair("First Kern Character", "Second Kern Character", 10.0f, 10.0f);

    // Act
    fontMetrics.addKernPair1(kernPair);

    // Assert
    List<KernPair> kernPairs1 = fontMetrics.getKernPairs1();
    assertEquals(1, kernPairs1.size());
    assertSame(kernPair, kernPairs1.get(0));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FontMetrics}
   *   <li>{@link FontMetrics#setAFMVersion(float)}
   *   <li>{@link FontMetrics#setAscender(float)}
   *   <li>{@link FontMetrics#setCapHeight(float)}
   *   <li>{@link FontMetrics#setCharWidth(float[])}
   *   <li>{@link FontMetrics#setCharacterSet(String)}
   *   <li>{@link FontMetrics#setCharacters(int)}
   *   <li>{@link FontMetrics#setDescender(float)}
   *   <li>{@link FontMetrics#setEncodingScheme(String)}
   *   <li>{@link FontMetrics#setEscChar(int)}
   *   <li>{@link FontMetrics#setFamilyName(String)}
   *   <li>{@link FontMetrics#setFixedPitch(boolean)}
   *   <li>{@link FontMetrics#setFontBBox(BoundingBox)}
   *   <li>{@link FontMetrics#setFontName(String)}
   *   <li>{@link FontMetrics#setFontVersion(String)}
   *   <li>{@link FontMetrics#setFullName(String)}
   *   <li>{@link FontMetrics#setIsBaseFont(boolean)}
   *   <li>{@link FontMetrics#setItalicAngle(float)}
   *   <li>{@link FontMetrics#setMappingScheme(int)}
   *   <li>{@link FontMetrics#setNotice(String)}
   *   <li>{@link FontMetrics#setStandardHorizontalWidth(float)}
   *   <li>{@link FontMetrics#setStandardVerticalWidth(float)}
   *   <li>{@link FontMetrics#setUnderlinePosition(float)}
   *   <li>{@link FontMetrics#setUnderlineThickness(float)}
   *   <li>{@link FontMetrics#setVVector(float[])}
   *   <li>{@link FontMetrics#setWeight(String)}
   *   <li>{@link FontMetrics#setXHeight(float)}
   *   <li>{@link FontMetrics#getAFMVersion()}
   *   <li>{@link FontMetrics#getAscender()}
   *   <li>{@link FontMetrics#getCapHeight()}
   *   <li>{@link FontMetrics#getCharWidth()}
   *   <li>{@link FontMetrics#getCharacterSet()}
   *   <li>{@link FontMetrics#getCharacters()}
   *   <li>{@link FontMetrics#getDescender()}
   *   <li>{@link FontMetrics#getEncodingScheme()}
   *   <li>{@link FontMetrics#getEscChar()}
   *   <li>{@link FontMetrics#getFamilyName()}
   *   <li>{@link FontMetrics#getFontBBox()}
   *   <li>{@link FontMetrics#getFontName()}
   *   <li>{@link FontMetrics#getFontVersion()}
   *   <li>{@link FontMetrics#getFullName()}
   *   <li>{@link FontMetrics#getIsBaseFont()}
   *   <li>{@link FontMetrics#getIsFixedPitch()}
   *   <li>{@link FontMetrics#getItalicAngle()}
   *   <li>{@link FontMetrics#getMappingScheme()}
   *   <li>{@link FontMetrics#getMetricSets()}
   *   <li>{@link FontMetrics#getNotice()}
   *   <li>{@link FontMetrics#getStandardHorizontalWidth()}
   *   <li>{@link FontMetrics#getStandardVerticalWidth()}
   *   <li>{@link FontMetrics#getUnderlinePosition()}
   *   <li>{@link FontMetrics#getUnderlineThickness()}
   *   <li>{@link FontMetrics#getVVector()}
   *   <li>{@link FontMetrics#getWeight()}
   *   <li>{@link FontMetrics#getXHeight()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    FontMetrics actualFontMetrics = new FontMetrics();
    actualFontMetrics.setAFMVersion(10.0f);
    actualFontMetrics.setAscender(10.0f);
    actualFontMetrics.setCapHeight(10.0f);
    float[] charWidthValue = new float[]{10.0f, 0.0f, 10.0f, 0.0f};
    actualFontMetrics.setCharWidth(charWidthValue);
    actualFontMetrics.setCharacterSet("42");
    actualFontMetrics.setCharacters(42);
    actualFontMetrics.setDescender(10.0f);
    actualFontMetrics.setEncodingScheme("UTF-8");
    actualFontMetrics.setEscChar(42);
    actualFontMetrics.setFamilyName("42");
    actualFontMetrics.setFixedPitch(true);
    BoundingBox bBox = new BoundingBox(10.0f, 10.0f, 10.0f, 10.0f);

    actualFontMetrics.setFontBBox(bBox);
    actualFontMetrics.setFontName("Name");
    actualFontMetrics.setFontVersion("42");
    actualFontMetrics.setFullName("Dr Jane Doe");
    actualFontMetrics.setIsBaseFont(true);
    actualFontMetrics.setItalicAngle(10.0f);
    actualFontMetrics.setMappingScheme(42);
    actualFontMetrics.setNotice("42");
    actualFontMetrics.setStandardHorizontalWidth(10.0f);
    actualFontMetrics.setStandardVerticalWidth(10.0f);
    actualFontMetrics.setUnderlinePosition(10.0f);
    actualFontMetrics.setUnderlineThickness(10.0f);
    float[] vVectorValue = new float[]{10.0f, 0.0f, 10.0f, 0.0f};
    actualFontMetrics.setVVector(vVectorValue);
    actualFontMetrics.setWeight("42");
    actualFontMetrics.setXHeight(10.0f);
    float actualAFMVersion = actualFontMetrics.getAFMVersion();
    float actualAscender = actualFontMetrics.getAscender();
    float actualCapHeight = actualFontMetrics.getCapHeight();
    float[] actualCharWidth = actualFontMetrics.getCharWidth();
    String actualCharacterSet = actualFontMetrics.getCharacterSet();
    int actualCharacters = actualFontMetrics.getCharacters();
    float actualDescender = actualFontMetrics.getDescender();
    String actualEncodingScheme = actualFontMetrics.getEncodingScheme();
    int actualEscChar = actualFontMetrics.getEscChar();
    String actualFamilyName = actualFontMetrics.getFamilyName();
    BoundingBox actualFontBBox = actualFontMetrics.getFontBBox();
    String actualFontName = actualFontMetrics.getFontName();
    String actualFontVersion = actualFontMetrics.getFontVersion();
    String actualFullName = actualFontMetrics.getFullName();
    boolean actualIsBaseFont = actualFontMetrics.getIsBaseFont();
    boolean actualIsFixedPitch = actualFontMetrics.getIsFixedPitch();
    float actualItalicAngle = actualFontMetrics.getItalicAngle();
    int actualMappingScheme = actualFontMetrics.getMappingScheme();
    int actualMetricSets = actualFontMetrics.getMetricSets();
    String actualNotice = actualFontMetrics.getNotice();
    float actualStandardHorizontalWidth = actualFontMetrics.getStandardHorizontalWidth();
    float actualStandardVerticalWidth = actualFontMetrics.getStandardVerticalWidth();
    float actualUnderlinePosition = actualFontMetrics.getUnderlinePosition();
    float actualUnderlineThickness = actualFontMetrics.getUnderlineThickness();
    float[] actualVVector = actualFontMetrics.getVVector();
    String actualWeight = actualFontMetrics.getWeight();

    // Assert that nothing has changed
    assertEquals("42", actualCharacterSet);
    assertEquals("42", actualFamilyName);
    assertEquals("42", actualFontVersion);
    assertEquals("42", actualNotice);
    assertEquals("42", actualWeight);
    assertEquals("Dr Jane Doe", actualFullName);
    assertEquals("Name", actualFontName);
    assertEquals("UTF-8", actualEncodingScheme);
    assertEquals(0, actualMetricSets);
    assertEquals(10.0f, actualAFMVersion);
    assertEquals(10.0f, actualAscender);
    assertEquals(10.0f, actualCapHeight);
    assertEquals(10.0f, actualDescender);
    assertEquals(10.0f, actualItalicAngle);
    assertEquals(10.0f, actualStandardHorizontalWidth);
    assertEquals(10.0f, actualStandardVerticalWidth);
    assertEquals(10.0f, actualUnderlinePosition);
    assertEquals(10.0f, actualUnderlineThickness);
    assertEquals(10.0f, actualFontMetrics.getXHeight());
    assertEquals(42, actualCharacters);
    assertEquals(42, actualEscChar);
    assertEquals(42, actualMappingScheme);
    assertTrue(actualIsBaseFont);
    assertTrue(actualIsFixedPitch);
    assertSame(bBox, actualFontBBox);
    assertSame(charWidthValue, actualCharWidth);
    assertSame(vVectorValue, actualVVector);
  }
}
