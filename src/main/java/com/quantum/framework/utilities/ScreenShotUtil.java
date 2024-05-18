package com.quantum.framework.utilities;

import org.openqa.selenium.WebDriver;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static com.assertthat.selenium_shutterbug.core.Capture.FULL;
import static com.assertthat.selenium_shutterbug.core.Shutterbug.shootPage;
import static com.quantum.framework.config.Constants.TIME_STAMP;
import static com.quantum.framework.utilities.LogUtil.info;
import static javax.imageio.ImageIO.write;

public class ScreenShotUtil {

    private ScreenShotUtil() {
        throw new IllegalStateException("ScreenShotUtil class");
    }

    public static byte[] captureScreen(String scenarioName, WebDriver driver) throws IOException {
        info("Taking the Screenshot of WebPage");
        var baos = new ByteArrayOutputStream();
        var shot = shootPage(driver, FULL, 500, true);
        shot.withName(scenarioName + "_" + TIME_STAMP).save();
        write(shot.getImage(), "png", baos);
        baos.flush();
        return baos.toByteArray();
    }
}


