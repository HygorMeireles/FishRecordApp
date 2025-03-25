package br.com.fishrecord.impl.di

import br.com.fishrecord.impl.data.datasource.remote.ApiService
import br.com.fishrecord.impl.data.datasource.remote.FishRecordDataSource
import br.com.fishrecord.impl.data.datasource.remote.FishRecordDataSourceImpl
import br.com.fishrecord.impl.data.repository.FishRecordRepository
import br.com.fishrecord.impl.data.repository.FishRecordRepositoryImpl
import br.com.fishrecord.impl.domain.usecase.DoLoginUseCase
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

    single<FishRecordRepository> {
        FishRecordRepositoryImpl(dataSource = get())
    }

    single {
        DoLoginUseCase(repository = get())
    }

    viewModel {
        LoginViewModel(doLoginUseCase = get())
    }
}