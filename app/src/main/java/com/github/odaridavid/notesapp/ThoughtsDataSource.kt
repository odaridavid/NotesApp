package com.github.odaridavid.notesapp

object ThoughtsDataSource {

    private val thoughts: MutableList<String> = mutableListOf()

    fun provideThoughts(): List<String> = thoughts

    fun addThought(thought: String) = thoughts.add(thought)
}
