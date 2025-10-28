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
import static org.mockito.Mockito.when;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDRange;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FDFIconFitDiffblueTest {
  /**
   * Method under test: {@link FDFIconFit#getScaleOption()}
   */
  @Test
  void testGetScaleOption() {
    // Arrange, Act and Assert
    assertEquals(FDFIconFit.SCALE_OPTION_ALWAYS, (new FDFIconFit()).getScaleOption());
  }

  /**
   * Method under test: {@link FDFIconFit#getScaleOption()}
   */
  @Test
  void testGetScaleOption2() {
    // Arrange
    FDFIconFit fdfIconFit = new FDFIconFit();
    fdfIconFit.setScaleOption(FDFIconFit.SCALE_OPTION_ALWAYS);

    // Act and Assert
    assertEquals(FDFIconFit.SCALE_OPTION_ALWAYS, fdfIconFit.getScaleOption());
  }

  /**
   * Method under test: {@link FDFIconFit#setScaleOption(String)}
   */
  @Test
  void testSetScaleOption() {
    // Arrange
    COSDictionary f = mock(COSDictionary.class);
    doNothing().when(f).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    (new FDFIconFit(f)).setScaleOption("Option");

    // Assert that nothing has changed
    verify(f).setName(isA(COSName.class), eq("Option"));
  }

  /**
   * Method under test: {@link FDFIconFit#getScaleType()}
   */
  @Test
  void testGetScaleType() {
    // Arrange, Act and Assert
    assertEquals(FDFIconFit.SCALE_TYPE_PROPORTIONAL, (new FDFIconFit()).getScaleType());
  }

  /**
   * Method under test: {@link FDFIconFit#getScaleType()}
   */
  @Test
  void testGetScaleType2() {
    // Arrange
    FDFIconFit fdfIconFit = new FDFIconFit();
    fdfIconFit.setScaleType(FDFIconFit.SCALE_TYPE_PROPORTIONAL);

    // Act and Assert
    assertEquals(FDFIconFit.SCALE_TYPE_PROPORTIONAL, fdfIconFit.getScaleType());
  }

  /**
   * Method under test: {@link FDFIconFit#setScaleType(String)}
   */
  @Test
  void testSetScaleType() {
    // Arrange
    COSDictionary f = mock(COSDictionary.class);
    doNothing().when(f).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    (new FDFIconFit(f)).setScaleType("Scale");

    // Assert that nothing has changed
    verify(f).setName(isA(COSName.class), eq("Scale"));
  }

  /**
   * Method under test: {@link FDFIconFit#getFractionalSpaceToAllocate()}
   */
  @Test
  void testGetFractionalSpaceToAllocate() {
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
   * Method under test: {@link FDFIconFit#getFractionalSpaceToAllocate()}
   */
  @Test
  void testGetFractionalSpaceToAllocate2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray range = new COSArray();
    range.add(object);
    PDRange space = new PDRange(range);

    FDFIconFit fdfIconFit = new FDFIconFit();
    fdfIconFit.setFractionalSpaceToAllocate(space);

    // Act
    PDRange actualFractionalSpaceToAllocate = fdfIconFit.getFractionalSpaceToAllocate();

    // Assert
    verify(object).getCOSObject();
    assertSame(range, actualFractionalSpaceToAllocate.getCOSArray());
    assertSame(range, actualFractionalSpaceToAllocate.getCOSObject());
  }

  /**
   * Method under test: {@link FDFIconFit#setFractionalSpaceToAllocate(PDRange)}
   */
  @Test
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
   * Method under test: {@link FDFIconFit#setFractionalSpaceToAllocate(PDRange)}
   */
  @Test
  void testSetFractionalSpaceToAllocate2() {
    // Arrange
    FDFIconFit fdfIconFit = new FDFIconFit();

    // Act
    fdfIconFit.setFractionalSpaceToAllocate(null);

    // Assert
    PDRange fractionalSpaceToAllocate = fdfIconFit.getFractionalSpaceToAllocate();
    assertEquals(0.5f, fractionalSpaceToAllocate.getMax());
    assertEquals(0.5f, fractionalSpaceToAllocate.getMin());
  }

  /**
   * Method under test: {@link FDFIconFit#setFractionalSpaceToAllocate(PDRange)}
   */
  @Test
  void testSetFractionalSpaceToAllocate3() {
    // Arrange
    FDFIconFit fdfIconFit = new FDFIconFit();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray range = new COSArray();
    range.add(object);

    // Act
    fdfIconFit.setFractionalSpaceToAllocate(new PDRange(range));

    // Assert
    verify(object).getCOSObject();
    PDRange fractionalSpaceToAllocate = fdfIconFit.getFractionalSpaceToAllocate();
    assertSame(range, fractionalSpaceToAllocate.getCOSArray());
    assertSame(range, fractionalSpaceToAllocate.getCOSObject());
  }

  /**
   * Method under test: {@link FDFIconFit#shouldScaleToFitAnnotation()}
   */
  @Test
  void testShouldScaleToFitAnnotation() {
    // Arrange, Act and Assert
    assertFalse((new FDFIconFit()).shouldScaleToFitAnnotation());
  }

  /**
   * Method under test: {@link FDFIconFit#shouldScaleToFitAnnotation()}
   */
  @Test
  void testShouldScaleToFitAnnotation2() {
    // Arrange
    FDFIconFit fdfIconFit = new FDFIconFit();
    fdfIconFit.setScaleToFitAnnotation(true);

    // Act and Assert
    assertTrue(fdfIconFit.shouldScaleToFitAnnotation());
  }

  /**
   * Method under test: {@link FDFIconFit#shouldScaleToFitAnnotation()}
   */
  @Test
  void testShouldScaleToFitAnnotation3() {
    // Arrange
    FDFIconFit fdfIconFit = new FDFIconFit();
    fdfIconFit.setScaleToFitAnnotation(false);

    // Act and Assert
    assertFalse(fdfIconFit.shouldScaleToFitAnnotation());
  }

  /**
   * Method under test: {@link FDFIconFit#setScaleToFitAnnotation(boolean)}
   */
  @Test
  void testSetScaleToFitAnnotation() {
    // Arrange
    COSDictionary f = mock(COSDictionary.class);
    doNothing().when(f).setBoolean(Mockito.<COSName>any(), anyBoolean());

    // Act
    (new FDFIconFit(f)).setScaleToFitAnnotation(true);

    // Assert that nothing has changed
    verify(f).setBoolean(isA(COSName.class), eq(true));
  }

  /**
   * Method under test: {@link FDFIconFit#FDFIconFit(COSDictionary)}
   */
  @Test
  void testNewFDFIconFit() {
    // Arrange
    COSDictionary f = new COSDictionary();

    // Act and Assert
    assertSame(f, (new FDFIconFit(f)).getCOSObject());
  }

  /**
   * Method under test: {@link FDFIconFit#FDFIconFit()}
   */
  @Test
  void testNewFDFIconFit2() {
    // Arrange and Act
    FDFIconFit actualFdfIconFit = new FDFIconFit();

    // Assert
    PDRange fractionalSpaceToAllocate = actualFdfIconFit.getFractionalSpaceToAllocate();
    COSArray cOSArray = fractionalSpaceToAllocate.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSDictionary cOSObject = actualFdfIconFit.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertNull(cOSObject.getKey());
    assertEquals(0.5f, fractionalSpaceToAllocate.getMax());
    assertEquals(0.5f, fractionalSpaceToAllocate.getMin());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(FDFIconFit.SCALE_OPTION_ALWAYS, actualFdfIconFit.getScaleOption());
    assertEquals(FDFIconFit.SCALE_TYPE_PROPORTIONAL, actualFdfIconFit.getScaleType());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, fractionalSpaceToAllocate.getCOSObject());
  }
}
