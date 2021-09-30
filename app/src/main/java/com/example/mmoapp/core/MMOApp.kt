package com.example.mmoapp.core

import android.app.Application
import com.example.mmoapp.data.GamesRepository
import com.example.mmoapp.data.ToGameMapper
import com.example.mmoapp.data.cache.GameDataToDbMapper
import com.example.mmoapp.data.cache.GameListCacheDataSource
import com.example.mmoapp.data.cache.GameListCacheMapper
import com.example.mmoapp.data.cloud.GameListCloudDataSource
import com.example.mmoapp.data.cloud.GameListCloudMapper
import com.example.mmoapp.data.cloud.GameListService
import com.example.mmoapp.domain.BaseGameDataToDomainMapper
import com.example.mmoapp.domain.BaseGameListDataToDomainMapper
import com.example.mmoapp.domain.GamesInteractor
import com.example.mmoapp.presentation.BaseGameDomainToUiMapper
import com.example.mmoapp.presentation.BaseGameListDomainToUiMapper
import com.example.mmoapp.presentation.GameListCommunication
import com.example.mmoapp.presentation.GameListViewModel
import com.google.gson.Gson
import io.realm.Realm
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

//  https://www.mmobomb.com/api1/games
class MMOApp : Application() {

    private companion object {
        const val BASE_URL = "https://www.mmobomb.com/api1/"
    }

    lateinit var gameListViewModel: GameListViewModel

    private lateinit var resourceProvider: ResourceProvider
    private lateinit var gson: Gson
    private lateinit var retrofit: Retrofit
    private lateinit var realmProvider: RealmProvider

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val client = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .build()
        gson = Gson()
        realmProvider = RealmProvider.Base()
        resourceProvider = ResourceProvider.Base(this)

        val service = retrofit.create(GameListService::class.java)
        val communication = GameListCommunication.Base()
        val cloudDataSource = GameListCloudDataSource.Base(gson, service)
        val cacheDataSource =
            GameListCacheDataSource.Base(RealmProvider.Base(), GameDataToDbMapper.Base())
        val toGameMapper = ToGameMapper.Base()
        val gameListCloudMapper = GameListCloudMapper.Base(toGameMapper)
        val gameListCacheMapper = GameListCacheMapper.Base(toGameMapper)
        val gamesRepository = GamesRepository.Base(
            cloudDataSource,
            cacheDataSource,
            gameListCloudMapper,
            gameListCacheMapper
        )
        val gamesInteractor = GamesInteractor.Base(
            gamesRepository,
            BaseGameListDataToDomainMapper(BaseGameDataToDomainMapper())
        )
        gameListViewModel = GameListViewModel(
            gamesInteractor,
            BaseGameListDomainToUiMapper(
                resourceProvider,
                BaseGameDomainToUiMapper(resourceProvider)
            ),
            communication
        )
    }
}
