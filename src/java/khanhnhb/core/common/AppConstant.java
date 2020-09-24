package khanhnhb.core.common;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Hello
 */
public class AppConstant {    
    public static final String CONTENT = "content";
    public static final String OPEN_BRACKET = "openBracket";
    public static final String OPEN_TAG_NAME = "openTagName";
    public static final String TAG_INNER = "tagInner";
    public static final String ATTR_NAME = "attributeName";
    public static final String EQUAL_WAIT = "equalWait";
    public static final String EQUAL = "equal";
    public static final String VALUE_WAIT = "valueWait";
    public static final String ATTR_VALUE_NQ = "nonQuotedAttributeValue";
    public static final String ATTR_VALUE_Q = "qouteAttributeValue";
    public static final String EMPTY_SLASH = "emptyTagSlash";
    public static final String CLOSE_BRACKET = "closeBracket";
    public static final String CLOSE_TAG_SLASH = "closeTagSlash";
    public static final String CLOSE_TAG_NAME = "closeTagName";
    public static final String WAIT_END_TAG_CLOSE = "waitEndTagClose";
    
    public static final char LT = '<';
    public static final char SLASH = '/';
    public static final char GT = '>';
    public static final char EQ = '=';
    public static final char D_QUOT = '"';
    public static final char S_QUOT = '\'';
    
    public static final char UNDERSCORE = '_';
    public static final char COLON = ':';
    public static final char HYPHEN = '-';
    public static final char PERIOD = '.';
    
    
    public static final String PRODUCT = "PRODUCT";
    public static final String CATALOG = "CATALOG";
    public static final String CATEGORY = "CATEGORY";
    public static final String VENDOR = "VENDOR";
    public static final String ADDRESS = "ADDRESS";
    public static final String BRAND = "BRAND";
    
    private static boolean isStartChar(char c) {
        return Character.isLetter(c) || UNDERSCORE == c || COLON == c;
    }
    
    private static boolean isNamedChar(char c) {
        return Character.isLetterOrDigit(c) || UNDERSCORE == c || HYPHEN == c || PERIOD == c;
    }
    
    public static boolean isStartTagChars(char c) {
        return isStartChar(c);
    }
    
    public static boolean isStartAttrChars(char c) {
        return isStartChar(c);
    }
    
    public static boolean isTagChars(char c) {
        return isNamedChar(c);
    }
    
    public static boolean isAttrChars(char c) {
        return isNamedChar(c);
    }
    
    public static boolean isSpace(char c) {
        return Character.isSpaceChar(c);
    }
    
    public static final List<String> INLINE_TAGS = Arrays.asList(
            "area", "base", "br", "col", "command", "embed", "hr", 
            "img", "input", "keygen", "link", "meta", "param", 
            "source", "track", "wbr");
}
