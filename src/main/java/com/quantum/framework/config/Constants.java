package com.quantum.framework.config;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Constants {

  private Constants() {
    throw new IllegalStateException("Constants class");
  }

  //Element Types
  public static final String INPUT    = "Input";
  public static final String DROPDOWN = "Dropdown";
  public static final String TEXT     = "Text";
  public static final int MEDIUM_WAIT = 30;
  public static final int LONG_WAIT   = 180;

  public static final String TIME_STAMP = new SimpleDateFormat("yy_MM_dd_HH_mm_ss").format(new Date());
}
