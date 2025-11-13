package app.ute.scaffold.data.api

import app.ute.scaffold.data.model.PostDTO
import retrofit2.http.*

interface PostsApi {
    @GET("posts")
    suspend fun getPosts(): List<PostDTO>

    @GET("posts/{id}")
    suspend fun getPost(@Path("id") id: Int): PostDTO

    @POST("posts")
    suspend fun createPost(@Body post: PostDTO): PostDTO
}