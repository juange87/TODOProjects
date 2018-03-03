package com.juange.todoprojects.data.di

import android.util.Base64
import com.juange.todoprojects.data.net.ProjectApi
import com.juange.todoprojects.data.net.ProjectApiImpl
import com.juange.todoprojects.data.net.ProjectService
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideProjectApi(api: ProjectApiImpl): ProjectApi = api

    @Provides
    @Named(Companion.ENDPOINT)
    fun provideEndpoint(): String {
        return "https://yat.teamwork.com/"
    }

    @Provides
    @Named(Companion.API_TOKEN)
    fun provideApiToken(): String {
        return "twp_TEbBXGCnvl2HfvXWfkLUlzx92e3T"
    }

    @Provides
    @Named(Companion.API_PASSWORD)
    fun provideApiPassword(): String {
        return "xxx"
    }

    @Provides
    @Named(Companion.API_AUTH)
    fun provideApiAuth(
            @Named(Companion.API_TOKEN) token: String,
            @Named(Companion.API_PASSWORD) password: String
    ): String {
        val toByteArray = "$token:$password".toByteArray()
        val base64 = Base64.encodeToString(toByteArray,  Base64.DEFAULT).replace("\n", "");
        return "Basic $base64"
    }

    @Provides
    @Named(Companion.GSON_CONVERTER)
    fun provideGsonConverter(): GsonConverterFactory? {
        return GsonConverterFactory.create()
    }

    @Provides
    @Named(Companion.OKHTTP_CLIENT)
    fun provideOkHttpClient(@Named(Companion.INTERCEPTOR) interceptor: Interceptor): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.addNetworkInterceptor(interceptor)
        return okHttpClientBuilder.build()
    }

    @Provides
    @Named(Companion.INTERCEPTOR)
    fun provideInterceptor(@Named(Companion.API_AUTH) auth: String): Interceptor {
        return Interceptor { chain ->
            var request = chain.request()
            val headerBuilder = request.headers().newBuilder()
            headerBuilder.add("Accept", "application/json")
            headerBuilder.add("Content-Type", "application/json")
            headerBuilder.add("Authorization", auth)
            request = request.newBuilder().headers(headerBuilder.build()).build()
            chain.proceed(request)
        }
    }

    @Provides
    @Named(Companion.RETROFIT_CLIENT)
    fun provideRetrofit(
            @Named(Companion.ENDPOINT) endpoint: String,
            @Named(Companion.GSON_CONVERTER) converter: GsonConverterFactory?,
            @Named(Companion.OKHTTP_CLIENT) client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
                .baseUrl(endpoint)
                .client(client)
                .addConverterFactory(converter)
                .build()
    }

    @Provides
    @Named(Companion.PROJECT_SERVICE)
    fun provideProjectService(@Named(Companion.RETROFIT_CLIENT) retrofit: Retrofit): ProjectService {
        return retrofit.create(ProjectService::class.java)
    }

    companion object {
        const val ENDPOINT = "endpoint"
        const val RETROFIT_CLIENT = "retrofit_client"
        const val GSON_CONVERTER = "gson_converter"
        const val OKHTTP_CLIENT = "okhttp_client"
        const val API_TOKEN = "api_token"
        const val API_PASSWORD = "xxx"
        const val API_AUTH = "api_auth"
        const val INTERCEPTOR = "interceptor"
        const val PROJECT_SERVICE = "project_service"
    }
}
