package com.example.wigilabsprueba.features.movies.frameworks.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Paging")
data class PagingEntityRom(
    @PrimaryKey() var id:Int=1,
    @ColumnInfo(name = "page")var page:Int,
    @ColumnInfo(name = "total_pages")var total_pages:Int,
    @ColumnInfo(name = "total_result")var total_results:Int

)
