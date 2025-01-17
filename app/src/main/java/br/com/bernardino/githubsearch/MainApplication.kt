package br.com.bernardino.githubsearch

import br.com.bernardino.githubsearch.di.databaseModule
import br.com.bernardino.githubsearch.di.networkModule

import android.app.Application
import br.com.bernardino.githubsearch.di.dataModulePullRequest
import br.com.bernardino.githubsearch.di.dataModuleRepository
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@MainApplication)
            modules(listOf(networkModule, dataModuleRepository, databaseModule, dataModulePullRequest))
        }
    }
}