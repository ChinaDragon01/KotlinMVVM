package com.example.baselib.bean

/**
 *Author: chinadragon
 *Time: 2024/5/20
 */
data class WXArticleBean(
    //https://wanandroid.com/wxarticle/chapters/json
    /* {
        "children": [],
        "courseId": 13,
        "id": 408,
        "name": "鸿洋",
        "order": 190000,
        "parentChapterId": 407,
        "userControlSetTop": false,
        "visible": 1
    }*/

    val children: List<Children>?,
    val courseId: Int?,
    val id: Int?,
    val name: String?,
    val order: Int?,
    val parentChapterId: Int?,
    val userControlSetTop: Boolean?,
    val visible: Int?
)

data class Children(val name: String)
