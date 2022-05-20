package codeedit.halideeditor.utils;

import static java.awt.event.InputEvent.CTRL_DOWN_MASK;
import static java.awt.event.InputEvent.META_DOWN_MASK;

/**
 * Contains data and functions relating to the native operating system/device.
 * @author Neel Sudhakaran
 */
public class NativeOSUtils {

    /**
     * The name of the Mac operating system.
     */
    public static final String MAC_OS = "Mac OS X";
    
    /**
     * The default action key for the operating system ({@code CTRL} or {@code CMD}).
     */
    public static final int ACTION_KEY = isMac() ? META_DOWN_MASK : CTRL_DOWN_MASK;

    // TODO: For Windows & Linux

    /**
     * Determines whether or not the running OS is MacOS.
     * @return true if the device is running MacOS, false if not
     */
    public static boolean isMac() {
        return System.getProperty("os.name").equals(MAC_OS);
    }

}
