package com.app.retrofitfulldemo;

import com.app.retrofitfulldemo.models.Comment;
import com.app.retrofitfulldemo.models.Post;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface JsonPlaceholderApi {

    /*
   @Path - to set specific value in url endpoints
    */
    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId);

    /*
    @Query - set multiple endpoints
     */
    @GET("posts")
    Call<List<Post>> getPosts(
            @Query("userId") Integer[] userId,
            @Query("_sort") String sort,
            @Query("_order") String order
    );

    /*
    @QueryMap - set multiple endpoints in single HashMap
     */
    @GET("posts")
    Call<List<Post>> getPosts(@QueryMap Map<String, String> parameters);

    /*
    @Url - Send Whole BASE URL
     */
    @GET
    Call<List<Comment>> getComments(@Url String url);


    /*
    Send Request in Post
     */
    @POST("posts")
    Call<Post> createPost(@Body Post post);

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPostFormUrl(@Field("userId") int userId,
                                 @Field("title") String title,
                                 @Field("body") String text
    );

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPostFormUrlMap(@FieldMap Map<String, String> fields);

    /*
    Put,Patch and Delete
     */
    @PUT("posts/{id}")
    Call<Post> putPost(@Path("id") int id, @Body Post post);

    @PATCH("posts/{id}")
    Call<Post> patchPost(@Path("id") int id, @Body Post post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);

}
