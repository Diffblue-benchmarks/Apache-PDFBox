package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.PDRange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FDFIconFitDiffblueTest {
  /**
   * Test {@link FDFIconFit#FDFIconFit(COSDictionary)}.
   * <p>
   * Method under test: {@link FDFIconFit#FDFIconFit(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFIconFit(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFIconFit.<init>(COSDictionary)"})
  void testNewFDFIconFit() {
    // Arrange
    COSDictionary f = new COSDictionary();

    // Act and Assert
    assertSame(f, (new FDFIconFit(f)).getCOSObject());
  }

  /**
   * Test {@link FDFIconFit#FDFIconFit()}.
   * <p>
   * Method under test: {@link FDFIconFit#FDFIconFit()}
   */
  @Test
  @DisplayName("Test new FDFIconFit()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFIconFit.<init>()"})
  void testNewFDFIconFit2() {
    // Arrange and Act
    FDFIconFit actualFdfIconFit = new FDFIconFit();

    // Assert
    COSDictionary cOSObject = actualFdfIconFit.getCOSObject();
    assertNull(cOSObject.getKey());
    PDRange fractionalSpaceToAllocate = actualFdfIconFit.getFractionalSpaceToAllocate();
    assertEquals(0.5f, fractionalSpaceToAllocate.getMax());
    assertEquals(0.5f, fractionalSpaceToAllocate.getMin());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(FDFIconFit.SCALE_OPTION_ALWAYS, actualFdfIconFit.getScaleOption());
    assertEquals(FDFIconFit.SCALE_TYPE_PROPORTIONAL, actualFdfIconFit.getScaleType());
  }

  /**
   * Test {@link FDFIconFit#getScaleOption()}.
   * <ul>
   *   <li>Given {@link FDFIconFit#FDFIconFit()} ScaleOption is {@link FDFIconFit#SCALE_OPTION_ALWAYS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFIconFit#getScaleOption()}
   */
  @Test
  @DisplayName("Test getScaleOption(); given FDFIconFit() ScaleOption is SCALE_OPTION_ALWAYS")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FDFIconFit.getScaleOption()"})
  void testGetScaleOption_givenFDFIconFitScaleOptionIsScale_option_always() {
    // Arrange
    FDFIconFit fdfIconFit = new FDFIconFit();
    fdfIconFit.setScaleOption(FDFIconFit.SCALE_OPTION_ALWAYS);

    // Act and Assert
    assertEquals(FDFIconFit.SCALE_OPTION_ALWAYS, fdfIconFit.getScaleOption());
  }

  /**
   * Test {@link FDFIconFit#getScaleOption()}.
   * <ul>
   *   <li>Given {@link FDFIconFit#FDFIconFit()}.</li>
   *   <li>Then return {@link FDFIconFit#SCALE_OPTION_ALWAYS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFIconFit#getScaleOption()}
   */
  @Test
  @DisplayName("Test getScaleOption(); given FDFIconFit(); then return SCALE_OPTION_ALWAYS")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FDFIconFit.getScaleOption()"})
  void testGetScaleOption_givenFDFIconFit_thenReturnScale_option_always() {
    // Arrange, Act and Assert
    assertEquals(FDFIconFit.SCALE_OPTION_ALWAYS, (new FDFIconFit()).getScaleOption());
  }

  /**
   * Test {@link FDFIconFit#setScaleOption(String)}.
   * <p>
   * Method under test: {@link FDFIconFit#setScaleOption(String)}
   */
  @Test
  @DisplayName("Test setScaleOption(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFIconFit.setScaleOption(String)"})
  void testSetScaleOption() {
    // Arrange
    COSDictionary f = mock(COSDictionary.class);
    doNothing().when(f).setName(Mockito.<COSName>any(), Mockito.<String>any());
    FDFIconFit fdfIconFit = new FDFIconFit(f);

    // Act
    fdfIconFit.setScaleOption("Option");

    // Assert that nothing has changed
    verify(f).setName(isA(COSName.class), eq("Option"));
    assertEquals(FDFIconFit.SCALE_OPTION_ALWAYS, fdfIconFit.getScaleOption());
  }

  /**
   * Test {@link FDFIconFit#getScaleType()}.
   * <ul>
   *   <li>Given {@link FDFIconFit#FDFIconFit()} ScaleType is {@link FDFIconFit#SCALE_TYPE_PROPORTIONAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFIconFit#getScaleType()}
   */
  @Test
  @DisplayName("Test getScaleType(); given FDFIconFit() ScaleType is SCALE_TYPE_PROPORTIONAL")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FDFIconFit.getScaleType()"})
  void testGetScaleType_givenFDFIconFitScaleTypeIsScale_type_proportional() {
    // Arrange
    FDFIconFit fdfIconFit = new FDFIconFit();
    fdfIconFit.setScaleType(FDFIconFit.SCALE_TYPE_PROPORTIONAL);

    // Act and Assert
    assertEquals(FDFIconFit.SCALE_TYPE_PROPORTIONAL, fdfIconFit.getScaleType());
  }

  /**
   * Test {@link FDFIconFit#getScaleType()}.
   * <ul>
   *   <li>Given {@link FDFIconFit#FDFIconFit()}.</li>
   *   <li>Then return {@link FDFIconFit#SCALE_TYPE_PROPORTIONAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFIconFit#getScaleType()}
   */
  @Test
  @DisplayName("Test getScaleType(); given FDFIconFit(); then return SCALE_TYPE_PROPORTIONAL")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FDFIconFit.getScaleType()"})
  void testGetScaleType_givenFDFIconFit_thenReturnScale_type_proportional() {
    // Arrange, Act and Assert
    assertEquals(FDFIconFit.SCALE_TYPE_PROPORTIONAL, (new FDFIconFit()).getScaleType());
  }

  /**
   * Test {@link FDFIconFit#setScaleType(String)}.
   * <p>
   * Method under test: {@link FDFIconFit#setScaleType(String)}
   */
  @Test
  @DisplayName("Test setScaleType(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFIconFit.setScaleType(String)"})
  void testSetScaleType() {
    // Arrange
    COSDictionary f = mock(COSDictionary.class);
    doNothing().when(f).setName(Mockito.<COSName>any(), Mockito.<String>any());
    FDFIconFit fdfIconFit = new FDFIconFit(f);

    // Act
    fdfIconFit.setScaleType("Scale");

    // Assert that nothing has changed
    verify(f).setName(isA(COSName.class), eq("Scale"));
    assertEquals(FDFIconFit.SCALE_TYPE_PROPORTIONAL, fdfIconFit.getScaleType());
  }

  /**
   * Test {@link FDFIconFit#getFractionalSpaceToAllocate()}.
   * <ul>
   *   <li>Then COSArray toList first return {@link COSFloat}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFIconFit#getFractionalSpaceToAllocate()}
   */
  @Test
  @DisplayName("Test getFractionalSpaceToAllocate(); then COSArray toList first return COSFloat")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRange FDFIconFit.getFractionalSpaceToAllocate()"})
  void testGetFractionalSpaceToAllocate_thenCOSArrayToListFirstReturnCOSFloat() {
    // Arrange and Act
    PDRange actualFractionalSpaceToAllocate = (new FDFIconFit()).getFractionalSpaceToAllocate();

    // Assert
    COSArray cOSArray = actualFractionalSpaceToAllocate.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(0.5f, actualFractionalSpaceToAllocate.getMax());
    assertEquals(0.5f, actualFractionalSpaceToAllocate.getMin());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualFractionalSpaceToAllocate.getCOSObject());
  }

  /**
   * Test {@link FDFIconFit#getFractionalSpaceToAllocate()}.
   * <ul>
   *   <li>Then return COSArray toList second Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFIconFit#getFractionalSpaceToAllocate()}
   */
  @Test
  @DisplayName("Test getFractionalSpaceToAllocate(); then return COSArray toList second Key is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRange FDFIconFit.getFractionalSpaceToAllocate()"})
  void testGetFractionalSpaceToAllocate_thenReturnCOSArrayToListSecondKeyIsNull() {
    // Arrange
    FDFIconFit fdfIconFit = new FDFIconFit();
    fdfIconFit.setFractionalSpaceToAllocate(new PDRange());

    // Act
    PDRange actualFractionalSpaceToAllocate = fdfIconFit.getFractionalSpaceToAllocate();

    // Assert
    List<? extends COSBase> toListResult = actualFractionalSpaceToAllocate.getCOSArray().toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(0.0f, actualFractionalSpaceToAllocate.getMin());
    assertEquals(1.0f, actualFractionalSpaceToAllocate.getMax());
    assertFalse(getResult.isDirect());
  }

  /**
   * Test {@link FDFIconFit#setFractionalSpaceToAllocate(PDRange)}.
   * <p>
   * Method under test: {@link FDFIconFit#setFractionalSpaceToAllocate(PDRange)}
   */
  @Test
  @DisplayName("Test setFractionalSpaceToAllocate(PDRange)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFIconFit.setFractionalSpaceToAllocate(PDRange)"})
  void testSetFractionalSpaceToAllocate() {
    // Arrange
    FDFIconFit fdfIconFit = new FDFIconFit();

    // Act
    fdfIconFit.setFractionalSpaceToAllocate(new PDRange());

    // Assert
    PDRange fractionalSpaceToAllocate = fdfIconFit.getFractionalSpaceToAllocate();
    assertEquals(0.0f, fractionalSpaceToAllocate.getMin());
    assertEquals(1.0f, fractionalSpaceToAllocate.getMax());
  }

  /**
   * Test {@link FDFIconFit#setFractionalSpaceToAllocate(PDRange)}.
   * <ul>
   *   <li>Then {@link FDFIconFit#FDFIconFit()} FractionalSpaceToAllocate Max is {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFIconFit#setFractionalSpaceToAllocate(PDRange)}
   */
  @Test
  @DisplayName("Test setFractionalSpaceToAllocate(PDRange); then FDFIconFit() FractionalSpaceToAllocate Max is '0.5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFIconFit.setFractionalSpaceToAllocate(PDRange)"})
  void testSetFractionalSpaceToAllocate_thenFDFIconFitFractionalSpaceToAllocateMaxIs05() {
    // Arrange
    FDFIconFit fdfIconFit = new FDFIconFit();

    // Act
    fdfIconFit.setFractionalSpaceToAllocate(null);

    // Assert that nothing has changed
    PDRange fractionalSpaceToAllocate = fdfIconFit.getFractionalSpaceToAllocate();
    assertEquals(0.5f, fractionalSpaceToAllocate.getMax());
    assertEquals(0.5f, fractionalSpaceToAllocate.getMin());
  }

  /**
   * Test {@link FDFIconFit#shouldScaleToFitAnnotation()}.
   * <ul>
   *   <li>Given {@link FDFIconFit#FDFIconFit()} ScaleToFitAnnotation is {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFIconFit#shouldScaleToFitAnnotation()}
   */
  @Test
  @DisplayName("Test shouldScaleToFitAnnotation(); given FDFIconFit() ScaleToFitAnnotation is 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FDFIconFit.shouldScaleToFitAnnotation()"})
  void testShouldScaleToFitAnnotation_givenFDFIconFitScaleToFitAnnotationIsFalse() {
    // Arrange
    FDFIconFit fdfIconFit = new FDFIconFit();
    fdfIconFit.setScaleToFitAnnotation(false);

    // Act and Assert
    assertFalse(fdfIconFit.shouldScaleToFitAnnotation());
  }

  /**
   * Test {@link FDFIconFit#shouldScaleToFitAnnotation()}.
   * <ul>
   *   <li>Given {@link FDFIconFit#FDFIconFit()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFIconFit#shouldScaleToFitAnnotation()}
   */
  @Test
  @DisplayName("Test shouldScaleToFitAnnotation(); given FDFIconFit(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FDFIconFit.shouldScaleToFitAnnotation()"})
  void testShouldScaleToFitAnnotation_givenFDFIconFit_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new FDFIconFit()).shouldScaleToFitAnnotation());
  }

  /**
   * Test {@link FDFIconFit#shouldScaleToFitAnnotation()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFIconFit#shouldScaleToFitAnnotation()}
   */
  @Test
  @DisplayName("Test shouldScaleToFitAnnotation(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FDFIconFit.shouldScaleToFitAnnotation()"})
  void testShouldScaleToFitAnnotation_thenReturnTrue() {
    // Arrange
    FDFIconFit fdfIconFit = new FDFIconFit();
    fdfIconFit.setScaleToFitAnnotation(true);

    // Act and Assert
    assertTrue(fdfIconFit.shouldScaleToFitAnnotation());
  }

  /**
   * Test {@link FDFIconFit#setScaleToFitAnnotation(boolean)}.
   * <ul>
   *   <li>Then calls {@link COSDictionary#setBoolean(COSName, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FDFIconFit#setScaleToFitAnnotation(boolean)}
   */
  @Test
  @DisplayName("Test setScaleToFitAnnotation(boolean); then calls setBoolean(COSName, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FDFIconFit.setScaleToFitAnnotation(boolean)"})
  void testSetScaleToFitAnnotation_thenCallsSetBoolean() {
    // Arrange
    COSDictionary f = mock(COSDictionary.class);
    doNothing().when(f).setBoolean(Mockito.<COSName>any(), anyBoolean());

    // Act
    (new FDFIconFit(f)).setScaleToFitAnnotation(true);

    // Assert
    verify(f).setBoolean(isA(COSName.class), eq(true));
  }
}
