package com.example.wigilabsprueba.core.di;


import android.content.Context
import com.example.wigilabsprueba.features.movies.frameworks.repository.Repository
import com.example.wigilabsprueba.features.movies.frameworks.repository.datasources.local.MovieLocalDatasource
import com.example.wigilabsprueba.features.movies.frameworks.repository.datasources.remote.MovieRemoteDatasource
import com.example.wigilabsprueba.features.movies.interactors.FecthFromWebService
import com.example.wigilabsprueba.features.movies.interactors.GetMovieDetails
import com.example.wigilabsprueba.features.movies.interactors.GetMovies
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
   fun databaseProvider(@ApplicationContext context: Context)=MovieLocalDatasource(context)

    @Provides
    @Singleton
    fun repositoryProvider(MRD:MovieRemoteDatasource,MLD:MovieLocalDatasource)=Repository(MRD,MLD)


    @Provides
    @Singleton
    fun interactorGetMoviesProvider(repository: Repository)=GetMovies(repository)


    @Provides
    @Singleton
    fun interactorGetMovieDetailsProvider(repository: Repository)= GetMovieDetails(repository)

    @Provides
    @Singleton
    fun interactorFetchDataFromWebService(repository: Repository)=FecthFromWebService(repository)

}
