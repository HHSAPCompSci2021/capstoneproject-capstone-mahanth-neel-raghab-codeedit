package codeedit.halideeditor.utils;

// TODO Needed?
public class NativeOSUtils {
    
    public static enum OperatingSystem {
        MAC("Mac OS X"),
        WINDOWS, // TODO
        OTHER; // TODO
        private final String osString;

        private OperatingSystem() {
            this.osString = "";
        }

        private OperatingSystem(String osString) {
            this.osString = osString;
        }

        public String getOSString() {
            return osString;
        }

    }

    public static boolean isOperatingSystem(OperatingSystem os) {
        return (System.getProperty("os.name").equals(os.getOSString()));
    }

    public static boolean isMac() {
        return isOperatingSystem(OperatingSystem.MAC);
    }

    public static boolean isWindows() {
        return isOperatingSystem(OperatingSystem.WINDOWS);
    }

    public static boolean isOther() {
        return isOperatingSystem(OperatingSystem.OTHER);
    }

}
