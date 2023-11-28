package com.example.smartHome.supabase.di

import com.example.smartHome.BuildConfig
import com.example.smartHome.supabase.authorization.data.remote.AuthenticationRepository
import com.example.smartHome.supabase.authorization.data.remote.AuthenticationRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.annotations.SupabaseExperimental
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.FlowType
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.storage.Storage
import io.github.jan.supabase.storage.storage
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface SupabaseModule {

    companion object {

        @OptIn(SupabaseExperimental::class)
        @Provides
        @Singleton
        fun provideSupabaseClient(): SupabaseClient {
            return createSupabaseClient(
                supabaseUrl = BuildConfig.SUPABASE_URL,
                supabaseKey = BuildConfig.SUPABASE_ANON_KEY
            ) {
                install(Postgrest)
                install(GoTrue) {
                    flowType = FlowType.PKCE
                    scheme = "app"
                    host = "supabase.com"
                }
                install(Storage)
            }
        }

        @Provides
        @Singleton
        fun provideSupabaseDatabase(client: SupabaseClient): Postgrest {
            return client.postgrest
        }

        @Provides
        @Singleton
        fun provideSupabaseGoTrue(client: SupabaseClient): GoTrue {
            return client.gotrue
        }


        @Provides
        @Singleton
        fun provideSupabaseStorage(client: SupabaseClient): Storage {
            return client.storage
        }
    }

    @Binds
    fun bindMedicRepository(impl: AuthenticationRepositoryImpl): AuthenticationRepository
}