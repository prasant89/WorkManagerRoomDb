package com.prasant.workmanagerroomdb.model.data

import ccom.prasant.workmanagerroomdb.model.data.ResultData

data class QuoteList(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<ResultData>,
    val totalCount: Int,
    val totalPages: Int
)
