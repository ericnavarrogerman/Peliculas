package com.example.wigilabsprueba.features.movies.frameworks.repository.datasources.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.wigilabsprueba.core.App
import com.example.wigilabsprueba.features.movies.frameworks.CoroutinesTestRule
import com.example.wigilabsprueba.features.movies.frameworks.model.MoviesEntityRom
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.junit.runner.RunWith
import java.io.IOException
import kotlinx.coroutines.test.*
import org.junit.*


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class AppDatabaseTest : TestCase() {

    @get:Rule
    var corrutineRule=CoroutinesTestRule()

    private val job = Job()
    private val testScope = TestCoroutineScope(job + corrutineRule.testDispacher)



    private lateinit var db: AppDatabase
    private lateinit var dao: MoviesDao

    @Before
    public override fun setUp() {

        val context = ApplicationProvider.getApplicationContext<App>()

        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java
        ).build()

        dao = db.moviesDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }


    @InternalCoroutinesApi
    @Test
    fun test_insertAndChanges()=testScope.runBlockingTest {
        var list: ArrayList<MoviesEntityRom> = getDataSimulate()

        var result=dao.findAllMovies()
        launch {
            dao.InsertAllMovies(list)

            result.collect { Assert.assertEquals(list,it) }
            job.cancel()
        }


    }

    private fun getDataSimulate(): ArrayList<MoviesEntityRom> {

        return arrayListOf<MoviesEntityRom>(
            MoviesEntityRom(
                1,
                438631,
                "https://image.tmdb.org/t/p/original/eeijXm3553xvuFbkPFkDG6CLCbQ.jpg",
                "Dune",
                "Paul Atreides, a brilliant and gifted young man born into a great destiny beyond his understanding, must travel to the most dangerous planet in the universe to ensure the future of his family and his people. As malevolent forces explode into conflict over the planet's exclusive supply of the most precious resource in existence-a commodity capable of unlocking humanity's greatest potential-only those who can conquer their fear will survive.",
                "7858.899",
                "https://image.tmdb.org/t/p/original/d5NXSklXo0qyIYkgV94XAgMIckC.jpg",
                "2021-09-15",
                8.1f,
                2625
            ),
            MoviesEntityRom(
                2,
                438631,
                "https://image.tmdb.org/t/p/original/eeijXm3553xvuFbkPFkDG6CLCbQ.jpg",
                "Dune",
                "Paul Atreides, a brilliant and gifted young man born into a great destiny beyond his understanding, must travel to the most dangerous planet in the universe to ensure the future of his family and his people. As malevolent forces explode into conflict over the planet's exclusive supply of the most precious resource in existence-a commodity capable of unlocking humanity's greatest potential-only those who can conquer their fear will survive.",
                "7858.899",
                "https://image.tmdb.org/t/p/original/d5NXSklXo0qyIYkgV94XAgMIckC.jpg",
                "2021-09-15",
                8.1f,
                2625
            ),
            MoviesEntityRom(
                3,
                438631,
                "https://image.tmdb.org/t/p/original/eeijXm3553xvuFbkPFkDG6CLCbQ.jpg",
                "Dune",
                "Paul Atreides, a brilliant and gifted young man born into a great destiny beyond his understanding, must travel to the most dangerous planet in the universe to ensure the future of his family and his people. As malevolent forces explode into conflict over the planet's exclusive supply of the most precious resource in existence-a commodity capable of unlocking humanity's greatest potential-only those who can conquer their fear will survive.",
                "7858.899",
                "https://image.tmdb.org/t/p/original/d5NXSklXo0qyIYkgV94XAgMIckC.jpg",
                "2021-09-15",
                8.1f,
                2625
            ),
            MoviesEntityRom(
                4,
                438631,
                "https://image.tmdb.org/t/p/original/eeijXm3553xvuFbkPFkDG6CLCbQ.jpg",
                "Dune",
                "Paul Atreides, a brilliant and gifted young man born into a great destiny beyond his understanding, must travel to the most dangerous planet in the universe to ensure the future of his family and his people. As malevolent forces explode into conflict over the planet's exclusive supply of the most precious resource in existence-a commodity capable of unlocking humanity's greatest potential-only those who can conquer their fear will survive.",
                "7858.899",
                "https://image.tmdb.org/t/p/original/d5NXSklXo0qyIYkgV94XAgMIckC.jpg",
                "2021-09-15",
                8.1f,
                2625
            ),
            MoviesEntityRom(
                5,
                438631,
                "https://image.tmdb.org/t/p/original/eeijXm3553xvuFbkPFkDG6CLCbQ.jpg",
                "Dune",
                "Paul Atreides, a brilliant and gifted young man born into a great destiny beyond his understanding, must travel to the most dangerous planet in the universe to ensure the future of his family and his people. As malevolent forces explode into conflict over the planet's exclusive supply of the most precious resource in existence-a commodity capable of unlocking humanity's greatest potential-only those who can conquer their fear will survive.",
                "7858.899",
                "https://image.tmdb.org/t/p/original/d5NXSklXo0qyIYkgV94XAgMIckC.jpg",
                "2021-09-15",
                8.1f,
                2625
            ),
            MoviesEntityRom(
                6,
                438631,
                "https://image.tmdb.org/t/p/original/eeijXm3553xvuFbkPFkDG6CLCbQ.jpg",
                "Dune",
                "Paul Atreides, a brilliant and gifted young man born into a great destiny beyond his understanding, must travel to the most dangerous planet in the universe to ensure the future of his family and his people. As malevolent forces explode into conflict over the planet's exclusive supply of the most precious resource in existence-a commodity capable of unlocking humanity's greatest potential-only those who can conquer their fear will survive.",
                "7858.899",
                "https://image.tmdb.org/t/p/original/d5NXSklXo0qyIYkgV94XAgMIckC.jpg",
                "2021-09-15",
                8.1f,
                2625
            ),

        )
    }


}