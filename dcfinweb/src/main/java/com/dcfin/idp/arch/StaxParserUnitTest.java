package com.dcfin.idp.arch;
//package com.dcfin.mf.arch;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//import java.util.List;
//
//import org.junit.Test;
//
//import com.dcfin.mf.model.Action;
//
//
//public class StaxParserUnitTest {
//    
//    @Test
//    public void givenWebsitesXML_whenParsed_thenNotNull() {
//        List<Action> websites = StaxParser.parse("src/test/resources/xml/actions.xml");
//        assertNotNull(websites);
//    }
//
//    @Test
//    public void givenWebsitesXML_whenParsed_thenSizeIsThree() {
//        List<Action> websites = StaxParser.parse("src/test/resources/xml/actions.xml");
//        assertEquals(7, websites.size());
//    }
//    
//    @Test
//    public void givenWebsitesXML_whenParsed_thenLocalhostExists() {
//        List<Action> websites = StaxParser.parse("src/test/resources/xml/actions.xml");
//        assertEquals("createRole", websites.get(2).getName());
//    }
//}
