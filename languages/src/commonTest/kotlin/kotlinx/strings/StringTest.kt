package kotlinx.strings

import kotlinx.languages.english.plural
import kotlin.test.Test
import kotlin.test.assertEquals

class StringTest {

    @Test
    fun testYEndingPlurals() {
        assertEquals("rays", "ray".plural)
        assertEquals("boys", "boy".plural)
        assertEquals("pays", "pay".plural)
        assertEquals("cities", "city".plural)
        assertEquals("puppies", "puppy".plural)
        assertEquals("countries", "country".plural)
    }


    @Test
    fun testFEndingPlurals() {
        assertEquals("wives", "wife".plural)
        assertEquals("wolves", "wolf".plural)
        assertEquals("roofs", "roof".plural)
        assertEquals("chefs", "chef".plural)
        assertEquals("chiefs", "chief".plural)
    }

    @Test
    fun testUsEndingPlurals() {
        assertEquals("cacti", "cactus".plural)
        assertEquals("foci", "focus".plural)

    }

    @Test
    fun testIsEndingPlurals() {
        assertEquals("analyses", "analysis".plural)
        assertEquals("ellipses", "ellipsis".plural)

    }

    @Test
    fun testOnEndingPlurals() {
        assertEquals("phenomena", "phenomenon".plural)
        assertEquals("criteria", "criterion".plural)
    }

    @Test
    fun testGeneralEndingPlurals() {
        assertEquals("cats", "cat".plural)
        assertEquals("bats", "bat".plural)
        assertEquals("houses", "house".plural)
    }

    @Test
    fun testS_SS_SH_CH_X_Z_EndingPlurals() {
        assertEquals("trusses", "truss".plural)
        assertEquals("buses", "bus".plural)
        assertEquals("marshes", "marsh".plural)
        assertEquals("lunches", "lunch".plural)
        assertEquals("taxes", "tax".plural)
        assertEquals("blitzes", "blitz".plural)
    }


}