package br.com.fishrecord.impl.di

import br.com.fishrecord.impl.data.datasource.remote.ApiService
import br.com.fishrecord.impl.data.datasource.remote.FishRecordDataSource
import br.com.fishrecord.impl.data.datasource.remote.FishRecordDataSourceImpl
import br.com.fishrecord.impl.ui.login.LoginViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        ApiService()
    }

    single<FishRecordDataSource> {
        FishRecordDataSourceImpl(api = get())
    }

    viewModel {
        LoginViewModel(dataSource = get())
    }
}