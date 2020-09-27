package id.ac.ui.cs.mobileprogramming.naufaldi.individualreport

import org.junit.Assert.*
import org.junit.Test

class MainActivityUnitTest {
    private val num : Int = 0
    @Test
    fun incrementNumber_returnsIncrementedNumber() {
        val mainActivity = MainActivity()
        val result = mainActivity.incrementNumber(num)

        assertEquals(result.num, 1)
    }

    @Test
    fun decrementNumber_returnsDecrementedNumber() {
        val mainActivity = MainActivity()
        val result = mainActivity.decrementNumber(num)

        assertEquals(result.num, -1)
    }
}