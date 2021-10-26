package com.example.wigilabsprueba.core.di;


import com.example.wigilabsprueba.features.movies.frameworks.repository.Repository
import com.example.wigilabsprueba.features.movies.frameworks.repository.datasources.local.MovieLocalDatasource
import com.example.wigilabsprueba.features.movies.frameworks.repository.datasources.remote.MovieRemoteDatasource
import com.example.wigilabsprueba.features.movies.interactors.GetMovieDetails
import com.example.wigilabsprueba.features.movies.interactors.GetMovies
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

   @Provides
   @Singleton
   fun apiProvider()=MovieRemoteDatasource()

   @Provides
   @Singleton
   fun databaseProvider()=MovieLocalDatasource()


    @Provides
    @Singleton
    fun casoDeUsoGetMoviesProvider()=GetMovies(Repository(MovieRemoteDatasource(),MovieLocalDatasource()))


    @Provides
    @Singleton
    fun casoDeUsoGetMovieDetailsProvider()= GetMovieDetails(Repository(MovieRemoteDatasource(),MovieLocalDatasource()))

    @Provides
    @Singleton
    fun repositoryProvider()=Repository(MovieRemoteDatasource(),MovieLocalDatasource())

}
