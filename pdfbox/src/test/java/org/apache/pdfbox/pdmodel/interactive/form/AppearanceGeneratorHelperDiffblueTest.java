package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionEmbeddedGoTo;
import org.apache.pdfbox.pdmodel.interactive.action.PDFormFieldAdditionalActions;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AppearanceGeneratorHelperDiffblueTest {
  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue() throws IOException {
    // Arrange
    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(new PDAnnotationWidget());

    PDComboBox field = mock(PDComboBox.class);
    when(field.getFullyQualifiedName()).thenThrow(new IllegalArgumentException());
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");
    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new AppearanceGeneratorHelper(field).setAppearanceValue("42"));
    verify(field).getAcroForm();
    verify(field).getActions();
    verify(field).getFullyQualifiedName();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue2() throws IOException {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getRectangle()).thenThrow(new IllegalArgumentException());
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");
    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new AppearanceGeneratorHelper(field).setAppearanceValue("42"));
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget).getRectangle();
    verify(field).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue3() throws IOException {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearance()).thenThrow(new IllegalArgumentException());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");
    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new AppearanceGeneratorHelper(field).setAppearanceValue("42"));
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget).getRectangle();
    verify(field).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue4() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.AA);
    pdDefaultAppearanceString.setFont(font);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getQ()).thenReturn(1);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field).setAppearanceValue("42");

    // Assert
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue5() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.ADBE_PKCS7_DETACHED);
    pdDefaultAppearanceString.setFont(font);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getQ()).thenReturn(1);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field).setAppearanceValue("42");

    // Assert
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue6() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.ADBE_PKCS7_SHA1);
    pdDefaultAppearanceString.setFont(font);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getQ()).thenReturn(1);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field).setAppearanceValue("42");

    // Assert
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue7() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.ADBE_X509_RSA_SHA1);
    pdDefaultAppearanceString.setFont(font);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getQ()).thenReturn(1);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field).setAppearanceValue("42");

    // Assert
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue8() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.AFTER);
    pdDefaultAppearanceString.setFont(font);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getQ()).thenReturn(1);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field).setAppearanceValue("42");

    // Assert
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue9() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toCOSNumberFloatList()).thenThrow(new IllegalArgumentException());

    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getQ()).thenReturn(1);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new AppearanceGeneratorHelper(field).setAppearanceValue("42"));
    verify(cosArray).toCOSNumberFloatList();
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue10() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getFloat(Mockito.<COSName>any(), anyFloat())).thenReturn(10.0f);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(new COSStream());

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toCOSNumberFloatList()).thenReturn(new ArrayList<>());

    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics()).thenReturn(null);
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getQ()).thenReturn(1);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field).setAppearanceValue("42");

    // Assert
    verify(cosArray2).toCOSNumberFloatList();
    verify(cosArray).toFloatArray();
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSStream(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosDictionary, atLeast(1)).getFloat(Mockito.<COSName>any(), eq(0.0f));
    verify(fontDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue11() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getFloat(Mockito.<COSName>any(), anyFloat())).thenReturn(10.0f);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(new COSStream());

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toCOSNumberFloatList()).thenReturn(new ArrayList<>());

    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);

    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.isEmpty()).thenReturn(true);
    when(cosArray3.get(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray3.size()).thenReturn(3);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray3);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(dict));
    when(pdAnnotationWidget.getAppearance())
        .thenReturn(new PDAppearanceDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getQ()).thenReturn(1);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field).setAppearanceValue("42");

    // Assert
    verify(cosArray3, atLeast(1)).get(anyInt());
    verify(cosArray3, atLeast(1)).isEmpty();
    verify(cosArray3, atLeast(1)).size();
    verify(cosArray2).toCOSNumberFloatList();
    verify(cosArray).toFloatArray();
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSStream(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosDictionary, atLeast(1)).getFloat(Mockito.<COSName>any(), eq(0.0f));
    verify(fontDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(dict).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue12() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(new COSStream());

    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.containsKey(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(cosDictionary2);

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDFormFieldAdditionalActions pdFormFieldAdditionalActions =
        mock(PDFormFieldAdditionalActions.class);
    when(pdFormFieldAdditionalActions.getF()).thenReturn(new PDActionEmbeddedGoTo());

    PDComboBox field = mock(PDComboBox.class);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(pdFormFieldAdditionalActions);
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new AppearanceGeneratorHelper(field).setAppearanceValue("42"));
    verify(cosDictionary2).containsKey("PMD");
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSStream(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(pdFormFieldAdditionalActions).getF();
    verify(pdAnnotationWidget).getCOSObject();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue13() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(new COSStream());

    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);

    PDFormFieldAdditionalActions pdFormFieldAdditionalActions =
        mock(PDFormFieldAdditionalActions.class);
    when(pdFormFieldAdditionalActions.getF()).thenThrow(new IllegalArgumentException());

    PDComboBox field = mock(PDComboBox.class);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getActions()).thenReturn(pdFormFieldAdditionalActions);
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new AppearanceGeneratorHelper(field).setAppearanceValue("42"));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSStream(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(pdFormFieldAdditionalActions).getF();
    verify(field).getAcroForm();
    verify(field).getActions();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add one.
   *   <li>Then calls {@link COSArray#toCOSNumberFloatList()}.
   * </ul>
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName(
      "Test setAppearanceValue(String); given ArrayList() add one; then calls toCOSNumberFloatList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_givenArrayListAddOne_thenCallsToCOSNumberFloatList()
      throws IOException {
    // Arrange
    ArrayList<Float> resultFloatList = new ArrayList<>();
    resultFloatList.add(1.0f);

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toCOSNumberFloatList()).thenReturn(resultFloatList);

    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getQ()).thenReturn(1);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field).setAppearanceValue("42");

    // Assert
    verify(cosArray).toCOSNumberFloatList();
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationWidget#PDAnnotationWidget()}.
   * </ul>
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String); given ArrayList() add PDAnnotationWidget()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_givenArrayListAddPDAnnotationWidget() throws IOException {
    // Arrange
    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(new PDAnnotationWidget());

    PDComboBox field = mock(PDComboBox.class);
    when(field.getFullyQualifiedName()).thenReturn("Dr Jane Doe");
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");
    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field).setAppearanceValue("42");

    // Assert
    verify(field).getAcroForm();
    verify(field).getActions();
    verify(field).getFullyQualifiedName();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationWidget#PDAnnotationWidget()}.
   * </ul>
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String); given ArrayList() add PDAnnotationWidget()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_givenArrayListAddPDAnnotationWidget2() throws IOException {
    // Arrange
    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(new PDAnnotationWidget());
    pdAnnotationWidgetList.add(new PDAnnotationWidget());

    PDComboBox field = mock(PDComboBox.class);
    when(field.getFullyQualifiedName()).thenReturn("Dr Jane Doe");
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");
    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field).setAppearanceValue("42");

    // Assert
    verify(field).getAcroForm();
    verify(field).getActions();
    verify(field, atLeast(1)).getFullyQualifiedName();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#isEmpty()} return {@code true}.
   *   <li>Then calls {@link COSArray#get(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName(
      "Test setAppearanceValue(String); given COSArray isEmpty() return 'true'; then calls get(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_givenCOSArrayIsEmptyReturnTrue_thenCallsGet() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getFloat(Mockito.<COSName>any(), anyFloat())).thenReturn(10.0f);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(new COSStream());

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toCOSNumberFloatList()).thenReturn(new ArrayList<>());

    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);

    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.isEmpty()).thenReturn(true);
    when(cosArray3.get(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray3.size()).thenReturn(3);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray3);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(dict));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getQ()).thenReturn(1);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field).setAppearanceValue("42");

    // Assert
    verify(cosArray3, atLeast(1)).get(anyInt());
    verify(cosArray3, atLeast(1)).isEmpty();
    verify(cosArray3, atLeast(1)).size();
    verify(cosArray2).toCOSNumberFloatList();
    verify(cosArray).toFloatArray();
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSStream(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosDictionary, atLeast(1)).getFloat(Mockito.<COSName>any(), eq(0.0f));
    verify(fontDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(dict).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#isEmpty()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName(
      "Test setAppearanceValue(String); given COSArray isEmpty() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_givenCOSArrayIsEmptyThrowIllegalArgumentException()
      throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(new COSStream());

    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenThrow(new IllegalArgumentException());
    when(cosArray.size()).thenReturn(3);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(dict));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new AppearanceGeneratorHelper(field).setAppearanceValue("42"));
    verify(cosArray).isEmpty();
    verify(cosArray).size();
    verify(dict).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSStream(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(dict).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#size()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName(
      "Test setAppearanceValue(String); given COSArray size() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_givenCOSArraySizeThrowIllegalArgumentException() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(new COSStream());

    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.size()).thenThrow(new IllegalArgumentException());

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(dict));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new AppearanceGeneratorHelper(field).setAppearanceValue("42"));
    verify(cosArray).size();
    verify(dict).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSStream(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(dict).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#toFloatArray()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName(
      "Test setAppearanceValue(String); given COSArray toFloatArray() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_givenCOSArrayToFloatArrayThrowIllegalArgumentException()
      throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenThrow(new IllegalArgumentException());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(new COSStream());

    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new AppearanceGeneratorHelper(field).setAppearanceValue("42"));
    verify(cosArray).toFloatArray();
    verify(fontDictionary).isDirect();
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSStream(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#containsKey(String)} return {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName(
      "Test setAppearanceValue(String); given COSDictionary containsKey(String) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_givenCOSDictionaryContainsKeyReturnTrue() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(new COSStream());

    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.containsKey(Mockito.<String>any())).thenReturn(true);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(cosDictionary2);

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getFullyQualifiedName()).thenReturn("Dr Jane Doe");
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field).setAppearanceValue("42");

    // Assert
    verify(cosDictionary2).containsKey("PMD");
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSStream(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(pdAnnotationWidget).getCOSObject();
    verify(field).getAcroForm();
    verify(field).getActions();
    verify(field).getFullyQualifiedName();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName(
      "Test setAppearanceValue(String); given COSDictionary getCOSArray(COSName) return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_givenCOSDictionaryGetCOSArrayReturnCOSArray() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getFloat(Mockito.<COSName>any(), anyFloat())).thenReturn(10.0f);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(new COSStream());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toCOSNumberFloatList()).thenReturn(new ArrayList<>());

    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getQ()).thenReturn(1);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field).setAppearanceValue("42");

    // Assert
    verify(cosArray).toCOSNumberFloatList();
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSStream(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosDictionary, atLeast(1)).getFloat(Mockito.<COSName>any(), eq(0.0f));
    verify(fontDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName(
      "Test setAppearanceValue(String); given COSDictionary getCOSArray(COSName) return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_givenCOSDictionaryGetCOSArrayReturnCOSArray2() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getFloat(Mockito.<COSName>any(), anyFloat())).thenReturn(10.0f);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(new COSStream());

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toCOSNumberFloatList()).thenReturn(new ArrayList<>());

    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(dict));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getQ()).thenReturn(1);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field).setAppearanceValue("42");

    // Assert
    verify(cosArray2).toCOSNumberFloatList();
    verify(cosArray).toFloatArray();
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSStream(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosDictionary, atLeast(1)).getFloat(Mockito.<COSName>any(), eq(0.0f));
    verify(fontDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(dict).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@link
   *       COSArray#COSArray()}.
   *   <li>Then calls {@link PDComboBox#getQ()}.
   * </ul>
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName(
      "Test setAppearanceValue(String); given COSDictionary getCOSArray(COSName) return COSArray(); then calls getQ()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_givenCOSDictionaryGetCOSArrayReturnCOSArray_thenCallsGetQ()
      throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getQ()).thenReturn(1);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field).setAppearanceValue("42");

    // Assert
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName(
      "Test setAppearanceValue(String); given COSDictionary getCOSArray(COSName) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_givenCOSDictionaryGetCOSArrayReturnNull() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getFloat(Mockito.<COSName>any(), anyFloat())).thenReturn(10.0f);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(new COSStream());

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toCOSNumberFloatList()).thenReturn(new ArrayList<>());

    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(null);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(dict));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getQ()).thenReturn(1);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field).setAppearanceValue("42");

    // Assert
    verify(cosArray2).toCOSNumberFloatList();
    verify(cosArray).toFloatArray();
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSStream(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosDictionary, atLeast(1)).getFloat(Mockito.<COSName>any(), eq(0.0f));
    verify(fontDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(dict).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@code
   *       null}.
   *   <li>Then calls {@link PDComboBox#getQ()}.
   * </ul>
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName(
      "Test setAppearanceValue(String); given COSDictionary getCOSArray(COSName) return 'null'; then calls getQ()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_givenCOSDictionaryGetCOSArrayReturnNull_thenCallsGetQ()
      throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getQ()).thenReturn(1);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field).setAppearanceValue("42");

    // Assert
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName(
      "Test setAppearanceValue(String); given COSDictionary getCOSDictionary(COSName) return COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_givenCOSDictionaryGetCOSDictionaryReturnCOSDictionary()
      throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toCOSNumberFloatList()).thenReturn(new ArrayList<>());

    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getQ()).thenReturn(1);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field).setAppearanceValue("42");

    // Assert
    verify(cosArray).toCOSNumberFloatList();
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName(
      "Test setAppearanceValue(String); given COSDictionary getCOSDictionary(COSName) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_givenCOSDictionaryGetCOSDictionaryReturnNull() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toCOSNumberFloatList()).thenReturn(new ArrayList<>());

    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getQ()).thenReturn(1);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field).setAppearanceValue("42");

    // Assert
    verify(cosArray).toCOSNumberFloatList();
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName(
      "Test setAppearanceValue(String); given COSDictionary getInt(COSName, int) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_givenCOSDictionaryGetIntThrowIllegalArgumentException()
      throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt()))
        .thenThrow(new IllegalArgumentException());
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getQ()).thenReturn(1);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new AppearanceGeneratorHelper(field).setAppearanceValue("42"));
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary).getInt(isA(COSName.class), eq(-1));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationWidget} {@link PDAnnotationWidget#getBorderStyle()} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName(
      "Test setAppearanceValue(String); given PDAnnotationWidget getBorderStyle() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_givenPDAnnotationWidgetGetBorderStyleReturnNull() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getFloat(Mockito.<COSName>any(), anyFloat())).thenReturn(10.0f);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(new COSStream());

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toCOSNumberFloatList()).thenReturn(new ArrayList<>());

    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);

    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.isEmpty()).thenReturn(true);
    when(cosArray3.get(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray3.size()).thenReturn(3);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray3);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(dict));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(null);
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getQ()).thenReturn(1);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field).setAppearanceValue("42");

    // Assert
    verify(cosArray3, atLeast(1)).get(anyInt());
    verify(cosArray3, atLeast(1)).isEmpty();
    verify(cosArray3, atLeast(1)).size();
    verify(cosArray2).toCOSNumberFloatList();
    verify(cosArray).toFloatArray();
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSStream(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosDictionary, atLeast(1)).getFloat(Mockito.<COSName>any(), eq(0.0f));
    verify(fontDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(dict).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationWidget} {@link PDAnnotationWidget#getRectangle()} return {@link
   *       PDRectangle#PDRectangle()}.
   * </ul>
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName(
      "Test setAppearanceValue(String); given PDAnnotationWidget getRectangle() return PDRectangle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_givenPDAnnotationWidgetGetRectangleReturnPDRectangle()
      throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getFloat(Mockito.<COSName>any(), anyFloat())).thenReturn(10.0f);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(new COSStream());

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toCOSNumberFloatList()).thenReturn(new ArrayList<>());

    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);

    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.isEmpty()).thenReturn(true);
    when(cosArray3.get(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray3.size()).thenReturn(3);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray3);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(dict));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(new PDRectangle());
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getQ()).thenReturn(1);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field).setAppearanceValue("42");

    // Assert
    verify(cosArray3, atLeast(1)).get(anyInt());
    verify(cosArray3, atLeast(1)).isEmpty();
    verify(cosArray3, atLeast(1)).size();
    verify(cosArray2).toCOSNumberFloatList();
    verify(cosArray).toFloatArray();
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSStream(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosDictionary, atLeast(1)).getFloat(Mockito.<COSName>any(), eq(0.0f));
    verify(fontDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(dict).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <ul>
   *   <li>Given {@link PDComboBox} {@link PDComboBox#getActions()} return {@code null}.
   *   <li>Then calls {@link COSDictionary#containsKey(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName(
      "Test setAppearanceValue(String); given PDComboBox getActions() return 'null'; then calls containsKey(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_givenPDComboBoxGetActionsReturnNull_thenCallsContainsKey()
      throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(new COSStream());

    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.containsKey(Mockito.<String>any())).thenReturn(true);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(cosDictionary2);

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getFullyQualifiedName()).thenReturn("Dr Jane Doe");
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(null);
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field).setAppearanceValue("42");

    // Assert
    verify(cosDictionary2).containsKey("PMD");
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSStream(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(pdAnnotationWidget).getCOSObject();
    verify(field).getAcroForm();
    verify(field).getActions();
    verify(field).getFullyQualifiedName();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <ul>
   *   <li>Given {@link PDComboBox} {@link PDComboBox#getQ()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName(
      "Test setAppearanceValue(String); given PDComboBox getQ() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_givenPDComboBoxGetQThrowIllegalArgumentException()
      throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getQ()).thenThrow(new IllegalArgumentException());
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new AppearanceGeneratorHelper(field).setAppearanceValue("42"));
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <ul>
   *   <li>Then calls {@link PDComboBox#getWidgets()}.
   * </ul>
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String); then calls getWidgets()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_thenCallsGetWidgets() throws IOException {
    // Arrange
    PDComboBox field = mock(PDComboBox.class);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");
    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(new ArrayList<>());
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field).setAppearanceValue("42");

    // Assert
    verify(field).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <ul>
   *   <li>Then calls {@link PDAnnotationWidget#setAppearance(PDAppearanceDictionary)}.
   * </ul>
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String); then calls setAppearance(PDAppearanceDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_thenCallsSetAppearance() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getFloat(Mockito.<COSName>any(), anyFloat())).thenReturn(10.0f);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(new COSStream());

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toCOSNumberFloatList()).thenReturn(new ArrayList<>());

    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);

    COSArray cosArray3 = mock(COSArray.class);
    when(cosArray3.isEmpty()).thenReturn(true);
    when(cosArray3.get(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray3.size()).thenReturn(3);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray3);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(dict));
    when(pdAnnotationWidget.getAppearance()).thenReturn(null);
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    doNothing().when(pdAnnotationWidget).setAppearance(Mockito.<PDAppearanceDictionary>any());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getQ()).thenReturn(1);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field).setAppearanceValue("42");

    // Assert
    verify(cosArray3, atLeast(1)).get(anyInt());
    verify(cosArray3, atLeast(1)).isEmpty();
    verify(cosArray3, atLeast(1)).size();
    verify(cosArray2).toCOSNumberFloatList();
    verify(cosArray).toFloatArray();
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSStream(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosDictionary, atLeast(1)).getFloat(Mockito.<COSName>any(), eq(0.0f));
    verify(fontDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(dict).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget).setAppearance(isA(PDAppearanceDictionary.class));
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <ul>
   *   <li>Then calls {@link COSArray#toFloatArray()}.
   * </ul>
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String); then calls toFloatArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_thenCallsToFloatArray() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getFloat(Mockito.<COSName>any(), anyFloat())).thenReturn(10.0f);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(new COSStream());

    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.toCOSNumberFloatList()).thenReturn(new ArrayList<>());

    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    when(fontDictionary.isDirect()).thenReturn(true);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(fontDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDMMType1Font font = new PDMMType1Font(fontDictionary);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);
    pdDefaultAppearanceString.setFont(font);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getQ()).thenReturn(1);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act
    new AppearanceGeneratorHelper(field).setAppearanceValue("42");

    // Assert
    verify(cosArray2).toCOSNumberFloatList();
    verify(cosArray).toFloatArray();
    verify(fontDictionary).isDirect();
    verify(fontDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSStream(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosDictionary, atLeast(1)).getFloat(Mockito.<COSName>any(), eq(0.0f));
    verify(fontDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(fontDictionary).getUpdateState();
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
    verify(field).getQ();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");
    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new AppearanceGeneratorHelper(field).setAppearanceValue("42"));
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
  }

  /**
   * Test {@link AppearanceGeneratorHelper#setAppearanceValue(String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AppearanceGeneratorHelper#setAppearanceValue(String)}
   */
  @Test
  @DisplayName("Test setAppearanceValue(String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppearanceGeneratorHelper.setAppearanceValue(String)"})
  void testSetAppearanceValue_thenThrowIllegalArgumentException2() throws IOException {
    // Arrange
    COSString defaultAppearance = COSString.parseHex("0123456789ABCDEF");

    PDDefaultAppearanceString pdDefaultAppearanceString =
        new PDDefaultAppearanceString(defaultAppearance, new PDResources());
    pdDefaultAppearanceString.setFontName(COSName.A);

    PDAnnotationWidget pdAnnotationWidget = mock(PDAnnotationWidget.class);
    when(pdAnnotationWidget.getAppearanceCharacteristics())
        .thenReturn(new PDAppearanceCharacteristicsDictionary(new COSDictionary()));
    when(pdAnnotationWidget.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(pdAnnotationWidget.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(pdAnnotationWidget.getRectangle()).thenReturn(PDRectangle.A0);
    when(pdAnnotationWidget.getCOSObject()).thenReturn(new COSDictionary());

    ArrayList<PDAnnotationWidget> pdAnnotationWidgetList = new ArrayList<>();
    pdAnnotationWidgetList.add(pdAnnotationWidget);

    PDComboBox field = mock(PDComboBox.class);
    when(field.getDefaultAppearanceString()).thenReturn(pdDefaultAppearanceString);
    when(field.getWidgets()).thenReturn(pdAnnotationWidgetList);
    when(field.getActions()).thenReturn(new PDFormFieldAdditionalActions());
    when(field.getAcroForm()).thenReturn(new PDAcroForm(new PDDocument()));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new AppearanceGeneratorHelper(field).setAppearanceValue("42"));
    verify(pdAnnotationWidget).getAppearance();
    verify(pdAnnotationWidget, atLeast(1)).getCOSObject();
    verify(pdAnnotationWidget, atLeast(1)).getRectangle();
    verify(pdAnnotationWidget, atLeast(1)).getAppearanceCharacteristics();
    verify(pdAnnotationWidget, atLeast(1)).getBorderStyle();
    verify(field, atLeast(1)).getAcroForm();
    verify(field).getActions();
    verify(field).getWidgets();
    verify(field).getDefaultAppearanceString();
  }
}
