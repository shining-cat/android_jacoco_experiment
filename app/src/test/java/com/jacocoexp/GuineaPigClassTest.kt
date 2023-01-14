package com.jacocoexp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GuineaPigClassTest{

    val testedClass = GuineaPigClass()

    @Test
    fun `test fun1 incomplete coverage`(){
        assertEquals("is zero", testedClass.function1(0))
    }

    @Test
    fun `test fun2 complete coverage`(){
        assertEquals("blank string", testedClass.function2(""))
    }

    @Test
    fun `test fun2 complete coverage 2`(){
        assertEquals("is not blank", testedClass.function2("not empty"))
    }

    //function3 not covered at all
}