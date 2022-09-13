/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package mermaid.kt

import kotlin.test.*

import mermaid.kt.Sequence.*

private val sample = sequenceDiagram {
    autonumber()
    participants(listOf(Actor("alice"), Actor("bob"), Actor("john")))

    alternative("x=0") {
        solidArrow(Actor("alice"), Actor("bob"), "hihi")
        dottedArrow(Actor("bob"), Actor("alice"), "hihi")
        elseClause("x=1") {
            solidArrow(Actor("alice"), Actor("bob"), "hihi")
            dottedArrow(Actor("bob"), Actor("alice"), "hihi")
        }
        elseClause("x=2") {
            solidArrow(Actor("alice"), Actor("bob"), "hihi")
            dottedArrow(Actor("bob"), Actor("alice"), "hihi")
        }
        elseClause("x=3") {
            solidArrow(Actor("alice"), Actor("bob"), "hihi")
            dottedArrow(Actor("bob"), Actor("alice"), "hihi")
        }
    }

    solidArrow(Actor("alice"), Actor("bob"), "hihi")
    noteOver(Actor("alice"), "alice says hihi")
    solidArrow(Actor("bob"), Actor("john"), "hoho")
    noteOver(Actor("bob"), Actor("john"), "bob says hoho")

    parallel("Alice to Bob") {
        solidArrow(Actor("alice"), Actor("bob"), "hihi")
        andClause("Bob to John") {
            solidArrow(Actor("bob"), Actor("john"), "hihi")
        }
        andClause("Alice to John") {
            solidArrow(Actor("alice"), Actor("john"), "hihi")
        }
    }

    highlight("red") {
        optional("this is red") {
            solidArrow(Actor("alice"), Actor("bob"), "hihi")
            dottedArrow(Actor("bob"), Actor("alice"), "hihi")
        }
    }
}

class SequenceTest {
    @Test
    fun testBase1() {
        val expected = """
        sequenceDiagram
            Note left of John: Text in note
        """.trimIndent()
        val dsl = sequenceDiagram {
            noteLeft(Actor("John"), "Text in note")
        }
        println(dsl)
        assertEquals(expected, dsl)
    }
}
