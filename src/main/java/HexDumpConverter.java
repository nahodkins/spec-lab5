import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class HexDumpConverter {

    private static final String OUTPUT_LINE_TEMPLATE = "%s\t%s\t%s%n";
    private static final String MEMORY_ADDRESS_TEMPLATE = "%08X";
    private static final String HEX_VALUE_TEMPLATE = "%02X ";
    private static final String DOT_CHARACTER = ".";
    private static final String EMPTY_HEX = "   ";
    private static final String START_PROGRAM_MSG = "Start program";
    private static final String END_OF_THE_PROGRAM_MSG = "End of the program";
    private static final String HEX_DUMP_ERROR_MSG = "Failed to create hex dump!";

    public static void convertFileToHexDump(File file) {
        System.out.println(START_PROGRAM_MSG);
        try (InputStream stream = new FileInputStream(file)){
            int memoryAddressValue = 0;
            while (stream.available() > 0) {
                StringBuilder hexBuilder = new StringBuilder();
                StringBuilder textBuilder = new StringBuilder();
                String memoryAddress = String.format(MEMORY_ADDRESS_TEMPLATE, (memoryAddressValue++) * 16);
                for (int i = 0; i < 16; i++) {
                    if (stream.available() > 0) {
                        int value = stream.read();
                        hexBuilder.append(String.format(HEX_VALUE_TEMPLATE, value));
                        if (!Character.isISOControl(value)) {
                            textBuilder.append((char) value);
                        } else {
                            textBuilder.append(DOT_CHARACTER);
                        }
                    } else {
                        hexBuilder.append(EMPTY_HEX);
                    }
                }
                System.out.printf((OUTPUT_LINE_TEMPLATE), memoryAddress, hexBuilder, textBuilder);
            }
        } catch (IOException e) {
            System.out.println(HEX_DUMP_ERROR_MSG);
        } finally {
            System.out.println(END_OF_THE_PROGRAM_MSG);
        }
    }
}
