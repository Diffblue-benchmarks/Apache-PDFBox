package org.apache.fontbox.afm;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.apache.fontbox.util.BoundingBox;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FontMetricsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FontMetrics.<init>()", "float FontMetrics.getAFMVersion()",
      "float FontMetrics.getAscender()", "float FontMetrics.getCapHeight()", "float[] FontMetrics.getCharWidth()",
      "String FontMetrics.getCharacterSet()", "int FontMetrics.getCharacters()", "float FontMetrics.getDescender()",
      "String FontMetrics.getEncodingScheme()", "int FontMetrics.getEscChar()", "String FontMetrics.getFamilyName()",
      "BoundingBox FontMetrics.getFontBBox()", "String FontMetrics.getFontName()",
      "String FontMetrics.getFontVersion()", "String FontMetrics.getFullName()", "boolean FontMetrics.getIsBaseFont()",
      "boolean FontMetrics.getIsFixedPitch()", "float FontMetrics.getItalicAngle()",
      "int FontMetrics.getMappingScheme()", "int FontMetrics.getMetricSets()", "String FontMetrics.getNotice()",
      "float FontMetrics.getStandardHorizontalWidth()", "float FontMetrics.getStandardVerticalWidth()",
      "float FontMetrics.getUnderlinePosition()", "float FontMetrics.getUnderlineThickness()",
      "float[] FontMetrics.getVVector()", "String FontMetrics.getWeight()", "float FontMetrics.getXHeight()",
      "void FontMetrics.setAFMVersion(float)", "void FontMetrics.setAscender(float)",
      "void FontMetrics.setCapHeight(float)", "void FontMetrics.setCharWidth(float[])",
      "void FontMetrics.setCharacterSet(String)", "void FontMetrics.setCharacters(int)",
      "void FontMetrics.setDescender(float)", "void FontMetrics.setEncodingScheme(String)",
      "void FontMetrics.setEscChar(int)", "void FontMetrics.setFamilyName(String)",
      "void FontMetrics.setFixedPitch(boolean)", "void FontMetrics.setFontBBox(BoundingBox)",
      "void FontMetrics.setFontName(String)", "void FontMetrics.setFontVersion(String)",
      "void FontMetrics.setFullName(String)", "void FontMetrics.setIsBaseFont(boolean)",
      "void FontMetrics.setItalicAngle(float)", "void FontMetrics.setMappingScheme(int)",
      "void FontMetrics.setNotice(String)", "void FontMetrics.setStandardHorizontalWidth(float)",
      "void FontMetrics.setStandardVerticalWidth(float)", "void FontMetrics.setUnderlinePosition(float)",
      "void FontMetrics.setUnderlineThickness(float)", "void FontMetrics.setVVector(float[])",
      "void FontMetrics.setWeight(String)", "void FontMetrics.setXHeight(float)"})
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

    // Assert
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
    assertArrayEquals(new float[]{10.0f, 0.0f, 10.0f, 0.0f}, actualCharWidth, 0.0f);
    assertArrayEquals(new float[]{10.0f, 0.0f, 10.0f, 0.0f}, actualVVector, 0.0f);
  }

  /**
   * Test {@link FontMetrics#getCharacterWidth(String)}.
   * <ul>
   *   <li>Given {@link FontMetrics} (default constructor) addCharMetric {@link CharMetric} (default constructor).</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMetrics#getCharacterWidth(String)}
   */
  @Test
  @DisplayName("Test getCharacterWidth(String); given FontMetrics (default constructor) addCharMetric CharMetric (default constructor); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float FontMetrics.getCharacterWidth(String)"})
  void testGetCharacterWidth_givenFontMetricsAddCharMetricCharMetric_whenNull() {
    // Arrange
    FontMetrics fontMetrics = new FontMetrics();
    fontMetrics.addCharMetric(new CharMetric());

    // Act and Assert
    assertEquals(0.0f, fontMetrics.getCharacterWidth(null));
  }

  /**
   * Test {@link FontMetrics#getCharacterWidth(String)}.
   * <ul>
   *   <li>Given {@link FontMetrics} (default constructor).</li>
   *   <li>When {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMetrics#getCharacterWidth(String)}
   */
  @Test
  @DisplayName("Test getCharacterWidth(String); given FontMetrics (default constructor); when 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float FontMetrics.getCharacterWidth(String)"})
  void testGetCharacterWidth_givenFontMetrics_whenName() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new FontMetrics()).getCharacterWidth("Name"));
  }

  /**
   * Test {@link FontMetrics#getCharacterHeight(String)}.
   * <p>
   * Method under test: {@link FontMetrics#getCharacterHeight(String)}
   */
  @Test
  @DisplayName("Test getCharacterHeight(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float FontMetrics.getCharacterHeight(String)"})
  void testGetCharacterHeight() {
    // Arrange
    CharMetric metric = new CharMetric();
    metric.setBoundingBox(new BoundingBox(10.0f, 10.0f, 10.0f, 10.0f));

    FontMetrics fontMetrics = new FontMetrics();
    fontMetrics.addCharMetric(metric);

    // Act and Assert
    assertEquals(0.0f, fontMetrics.getCharacterHeight(null));
  }

  /**
   * Test {@link FontMetrics#getCharacterHeight(String)}.
   * <ul>
   *   <li>Given {@link CharMetric} (default constructor) Wy is ten.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMetrics#getCharacterHeight(String)}
   */
  @Test
  @DisplayName("Test getCharacterHeight(String); given CharMetric (default constructor) Wy is ten; when 'null'; then return ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float FontMetrics.getCharacterHeight(String)"})
  void testGetCharacterHeight_givenCharMetricWyIsTen_whenNull_thenReturnTen() {
    // Arrange
    CharMetric metric = new CharMetric();
    metric.setWy(10.0f);

    FontMetrics fontMetrics = new FontMetrics();
    fontMetrics.addCharMetric(metric);

    // Act and Assert
    assertEquals(10.0f, fontMetrics.getCharacterHeight(null));
  }

  /**
   * Test {@link FontMetrics#getCharacterHeight(String)}.
   * <ul>
   *   <li>Given {@link FontMetrics} (default constructor).</li>
   *   <li>When {@code Name}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMetrics#getCharacterHeight(String)}
   */
  @Test
  @DisplayName("Test getCharacterHeight(String); given FontMetrics (default constructor); when 'Name'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float FontMetrics.getCharacterHeight(String)"})
  void testGetCharacterHeight_givenFontMetrics_whenName_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new FontMetrics()).getCharacterHeight("Name"));
  }

  /**
   * Test {@link FontMetrics#getAverageCharacterWidth()}.
   * <ul>
   *   <li>Given {@link CharMetric} (default constructor) Wx is ten.</li>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMetrics#getAverageCharacterWidth()}
   */
  @Test
  @DisplayName("Test getAverageCharacterWidth(); given CharMetric (default constructor) Wx is ten; then return ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float FontMetrics.getAverageCharacterWidth()"})
  void testGetAverageCharacterWidth_givenCharMetricWxIsTen_thenReturnTen() {
    // Arrange
    CharMetric metric = new CharMetric();
    metric.setWx(10.0f);

    FontMetrics fontMetrics = new FontMetrics();
    fontMetrics.addCharMetric(metric);

    // Act and Assert
    assertEquals(10.0f, fontMetrics.getAverageCharacterWidth());
  }

  /**
   * Test {@link FontMetrics#getAverageCharacterWidth()}.
   * <ul>
   *   <li>Given {@link FontMetrics} (default constructor).</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMetrics#getAverageCharacterWidth()}
   */
  @Test
  @DisplayName("Test getAverageCharacterWidth(); given FontMetrics (default constructor); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float FontMetrics.getAverageCharacterWidth()"})
  void testGetAverageCharacterWidth_givenFontMetrics_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new FontMetrics()).getAverageCharacterWidth());
  }

  /**
   * Test {@link FontMetrics#getAverageCharacterWidth()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMetrics#getAverageCharacterWidth()}
   */
  @Test
  @DisplayName("Test getAverageCharacterWidth(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float FontMetrics.getAverageCharacterWidth()"})
  void testGetAverageCharacterWidth_thenReturnZero() {
    // Arrange
    FontMetrics fontMetrics = new FontMetrics();
    fontMetrics.addCharMetric(new CharMetric());

    // Act and Assert
    assertEquals(0.0f, fontMetrics.getAverageCharacterWidth());
  }

  /**
   * Test {@link FontMetrics#addComment(String)}.
   * <p>
   * Method under test: {@link FontMetrics#addComment(String)}
   */
  @Test
  @DisplayName("Test addComment(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FontMetrics.addComment(String)"})
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
   * Test {@link FontMetrics#getComments()}.
   * <p>
   * Method under test: {@link FontMetrics#getComments()}
   */
  @Test
  @DisplayName("Test getComments()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FontMetrics.getComments()"})
  void testGetComments() {
    // Arrange, Act and Assert
    assertTrue((new FontMetrics()).getComments().isEmpty());
  }

  /**
   * Test {@link FontMetrics#setMetricSets(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMetrics#setMetricSets(int)}
   */
  @Test
  @DisplayName("Test setMetricSets(int); when forty-two; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FontMetrics.setMetricSets(int)"})
  void testSetMetricSets_whenFortyTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new FontMetrics()).setMetricSets(42));
  }

  /**
   * Test {@link FontMetrics#setMetricSets(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMetrics#setMetricSets(int)}
   */
  @Test
  @DisplayName("Test setMetricSets(int); when minus one; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FontMetrics.setMetricSets(int)"})
  void testSetMetricSets_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new FontMetrics()).setMetricSets(-1));
  }

  /**
   * Test {@link FontMetrics#getIsFixedV()}.
   * <ul>
   *   <li>Given {@link FontMetrics} (default constructor) IsFixedV is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMetrics#getIsFixedV()}
   */
  @Test
  @DisplayName("Test getIsFixedV(); given FontMetrics (default constructor) IsFixedV is 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FontMetrics.getIsFixedV()"})
  void testGetIsFixedV_givenFontMetricsIsFixedVIsTrue_thenReturnTrue() {
    // Arrange
    FontMetrics fontMetrics = new FontMetrics();
    fontMetrics.setIsFixedV(true);
    fontMetrics.setVVector(null);

    // Act and Assert
    assertTrue(fontMetrics.getIsFixedV());
  }

  /**
   * Test {@link FontMetrics#getIsFixedV()}.
   * <ul>
   *   <li>Given {@link FontMetrics} (default constructor) VVector is array of {@code float} with ten and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMetrics#getIsFixedV()}
   */
  @Test
  @DisplayName("Test getIsFixedV(); given FontMetrics (default constructor) VVector is array of float with ten and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FontMetrics.getIsFixedV()"})
  void testGetIsFixedV_givenFontMetricsVVectorIsArrayOfFloatWithTenAndZero() {
    // Arrange
    FontMetrics fontMetrics = new FontMetrics();
    fontMetrics.setVVector(new float[]{10.0f, 0.0f, 10.0f, 0.0f});

    // Act and Assert
    assertTrue(fontMetrics.getIsFixedV());
  }

  /**
   * Test {@link FontMetrics#getIsFixedV()}.
   * <ul>
   *   <li>Given {@link FontMetrics} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMetrics#getIsFixedV()}
   */
  @Test
  @DisplayName("Test getIsFixedV(); given FontMetrics (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FontMetrics.getIsFixedV()"})
  void testGetIsFixedV_givenFontMetrics_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new FontMetrics()).getIsFixedV());
  }

  /**
   * Test {@link FontMetrics#setIsFixedV(boolean)}.
   * <p>
   * Method under test: {@link FontMetrics#setIsFixedV(boolean)}
   */
  @Test
  @DisplayName("Test setIsFixedV(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FontMetrics.setIsFixedV(boolean)"})
  void testSetIsFixedV() {
    // Arrange
    FontMetrics fontMetrics = new FontMetrics();

    // Act
    fontMetrics.setIsFixedV(true);

    // Assert
    assertTrue(fontMetrics.getIsFixedV());
  }

  /**
   * Test {@link FontMetrics#getCharMetrics()}.
   * <p>
   * Method under test: {@link FontMetrics#getCharMetrics()}
   */
  @Test
  @DisplayName("Test getCharMetrics()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FontMetrics.getCharMetrics()"})
  void testGetCharMetrics() {
    // Arrange, Act and Assert
    assertTrue((new FontMetrics()).getCharMetrics().isEmpty());
  }

  /**
   * Test {@link FontMetrics#addCharMetric(CharMetric)}.
   * <ul>
   *   <li>When {@link CharMetric} (default constructor).</li>
   *   <li>Then {@link FontMetrics} (default constructor) CharMetrics size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMetrics#addCharMetric(CharMetric)}
   */
  @Test
  @DisplayName("Test addCharMetric(CharMetric); when CharMetric (default constructor); then FontMetrics (default constructor) CharMetrics size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FontMetrics.addCharMetric(CharMetric)"})
  void testAddCharMetric_whenCharMetric_thenFontMetricsCharMetricsSizeIsOne() {
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
   * Test {@link FontMetrics#getTrackKern()}.
   * <p>
   * Method under test: {@link FontMetrics#getTrackKern()}
   */
  @Test
  @DisplayName("Test getTrackKern()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FontMetrics.getTrackKern()"})
  void testGetTrackKern() {
    // Arrange, Act and Assert
    assertTrue((new FontMetrics()).getTrackKern().isEmpty());
  }

  /**
   * Test {@link FontMetrics#addTrackKern(TrackKern)}.
   * <p>
   * Method under test: {@link FontMetrics#addTrackKern(TrackKern)}
   */
  @Test
  @DisplayName("Test addTrackKern(TrackKern)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FontMetrics.addTrackKern(TrackKern)"})
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
   * Test {@link FontMetrics#getComposites()}.
   * <p>
   * Method under test: {@link FontMetrics#getComposites()}
   */
  @Test
  @DisplayName("Test getComposites()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FontMetrics.getComposites()"})
  void testGetComposites() {
    // Arrange, Act and Assert
    assertTrue((new FontMetrics()).getComposites().isEmpty());
  }

  /**
   * Test {@link FontMetrics#addComposite(Composite)}.
   * <p>
   * Method under test: {@link FontMetrics#addComposite(Composite)}
   */
  @Test
  @DisplayName("Test addComposite(Composite)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FontMetrics.addComposite(Composite)"})
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
   * Test {@link FontMetrics#getKernPairs()}.
   * <p>
   * Method under test: {@link FontMetrics#getKernPairs()}
   */
  @Test
  @DisplayName("Test getKernPairs()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FontMetrics.getKernPairs()"})
  void testGetKernPairs() {
    // Arrange, Act and Assert
    assertTrue((new FontMetrics()).getKernPairs().isEmpty());
  }

  /**
   * Test {@link FontMetrics#addKernPair(KernPair)}.
   * <p>
   * Method under test: {@link FontMetrics#addKernPair(KernPair)}
   */
  @Test
  @DisplayName("Test addKernPair(KernPair)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FontMetrics.addKernPair(KernPair)"})
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
   * Test {@link FontMetrics#getKernPairs0()}.
   * <p>
   * Method under test: {@link FontMetrics#getKernPairs0()}
   */
  @Test
  @DisplayName("Test getKernPairs0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FontMetrics.getKernPairs0()"})
  void testGetKernPairs0() {
    // Arrange, Act and Assert
    assertTrue((new FontMetrics()).getKernPairs0().isEmpty());
  }

  /**
   * Test {@link FontMetrics#addKernPair0(KernPair)}.
   * <p>
   * Method under test: {@link FontMetrics#addKernPair0(KernPair)}
   */
  @Test
  @DisplayName("Test addKernPair0(KernPair)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FontMetrics.addKernPair0(KernPair)"})
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
   * Test {@link FontMetrics#getKernPairs1()}.
   * <p>
   * Method under test: {@link FontMetrics#getKernPairs1()}
   */
  @Test
  @DisplayName("Test getKernPairs1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FontMetrics.getKernPairs1()"})
  void testGetKernPairs1() {
    // Arrange, Act and Assert
    assertTrue((new FontMetrics()).getKernPairs1().isEmpty());
  }

  /**
   * Test {@link FontMetrics#addKernPair1(KernPair)}.
   * <p>
   * Method under test: {@link FontMetrics#addKernPair1(KernPair)}
   */
  @Test
  @DisplayName("Test addKernPair1(KernPair)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FontMetrics.addKernPair1(KernPair)"})
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
}
