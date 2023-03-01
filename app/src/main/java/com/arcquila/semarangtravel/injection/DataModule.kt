package com.arcquila.semarangtravel.injection


import com.arcquila.semarangtravel.data.repository.SemarangTourismRepository
import com.arcquila.semarangtravel.data.repository.SemarangTourismRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun provideSemarangTourismRepository(semarangTourismRepositoryImpl: SemarangTourismRepositoryImpl) : SemarangTourismRepository
}