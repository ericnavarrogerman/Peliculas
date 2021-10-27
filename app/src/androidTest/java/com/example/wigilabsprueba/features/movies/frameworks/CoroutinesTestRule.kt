package com.example.wigilabsprueba.features.movies.frameworks

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.*
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class CoroutinesTestRule: TestWatcher() {

    val testDispacher=kotlinx.coroutines.test.TestCoroutineDispatcher()

    override fun starting(description: Description?) {
        super.starting(description)
        Dispatchers.setMain(testDispacher)
    }

    override fun finished(description: Description?) {
        super.finished(description)
        Dispatchers.resetMain()
        testDispacher.cleanupTestCoroutines()
    }
}