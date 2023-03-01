package com.arcquila.semarangtravel.data.repository

import com.arcquila.semarangtravel.data.model.SemarangTourismData
import com.arcquila.semarangtravel.data.model.SemarangTourismModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SemarangTourismRepositoryImpl  @Inject constructor(

) : SemarangTourismRepository {

    private val dummyTourism = mutableListOf<SemarangTourismModel>()

    init {
        if (dummyTourism.isEmpty()) {
            dummyTourism.addAll(SemarangTourismData.dummyTourism)
        }
    }
    override fun searchSemarangTourism(query: String) = flow {
        val data = dummyTourism.filter {
            it.name.contains(query, ignoreCase = true)
        }
        emit(data)
    }

    override fun getSemarangTourism() = flow {
        emit(dummyTourism)
    }

    override fun getTourismPlaceById(id: Int): Flow<SemarangTourismModel> {
        return flowOf(dummyTourism.first { it.id == id })
    }

}